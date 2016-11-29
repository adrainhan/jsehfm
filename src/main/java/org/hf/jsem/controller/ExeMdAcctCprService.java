package org.hf.jsem.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.apache.log4j.Logger;
import org.hf.jsem.dao.*;
import org.hf.jsem.entity.*;
import org.hf.jsem.keypool.KeyGenerator;
import org.hf.jsem.runnable.ExeMdAcctCprServiceI;
import org.hf.jsem.serviceI.*;
import org.hf.jsem.util.FtpClientUtil;
import org.hf.jsem.util.ShellInvokeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by adramer on 2016/11/1.
 * 委贷对账业务控制
 */
@Component
public class ExeMdAcctCprService implements ExeMdAcctCprServiceI {
    @Autowired
    private JcmProcessServiceI processServiceI;
    @Autowired
    private KeyGenerator keyGenerator;
    @Autowired
    private JcmPorcessLogSercieI porcessLogSercieI;
    @Autowired
    private ScmsSysCtrlMapper ctrlMapper;
    @Autowired
    private JcmJobInfoServiceI jobInfoServiceI;
    @Autowired
    private SystemConfigServiceI configServiceI;
    @Autowired
    private JcmJobIneerLogServerI jcmJobIneerLogServerI;
    @Autowired
    private WorkMainServiceI workMainServiceI;


    private static final Log log = LogFactoryImpl.getLog(ExeMdAcctCprService.class);

    public void doMdAcctCpr(String[] args) {
        Date clDate = new Date(this.ctrlMapper.selectByPrimaryKey("000").getCurPrcsDate().getTime());

        try {
            Map<String, Object> params = tanslateParams(args);
            JcmProcess process = this.processServiceI.getByPk(params.get("workType").toString());
            process.setCurrentDate(clDate);
            process.setLastRunDate(new Date(process.getCurrentDate().getTime() - 24 * 60 * 60 * 1000));
            Map<String, String> runFlag = gerExecuteFlag(process, params);
            JcmProcessLog log = createLog(process, runFlag);
            Map<String, String> acctCprRes = null;
            this.porcessLogSercieI.saveOrUPdate(log);
            if ("Y".equals(runFlag.get("run"))) {
                process.setRunFlag("Y");
                acctCprRes = doAcctCpr(params);
                if (!(params.containsKey("runType") && "H".equals(params.get("runType").toString()))) {
                    process.setCurrentFinishFlag(acctCprRes.get("result"));
                }
                process.setRemark(acctCprRes.get("info"));
                process.setCurrentExeResult(acctCprRes.get("result"));
                log.setInfo(new StringBuffer().append(log.getInfo()).append(" [").append(acctCprRes.get("result")).append("]: " +
                        "").append(acctCprRes.get("info")).toString());
            } else {
                process.setRunFlag("N");
            }
            log.setEnd(new Date(new java.util.Date().getTime()));
            log.setCost(BigDecimal.valueOf(log.getEnd().getTime() - log.getBegin().getTime()));
            this.porcessLogSercieI.saveOrUPdate(log);
            this.processServiceI.saveOrUpdate(process);

        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

    }


    private Map<String, String> gerExecuteFlag(JcmProcess process, Map<String, Object> params) {
        Map<String, String> runFlag = new HashMap<String, String>();
        Date currentDate = (Date) params.get("currentDate");
        runFlag.put("run", "N");
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        runFlag.put("currentDateText", params.get("currentDateText").toString());
        if (process != null) {
            //历史数据
            if (params.containsKey("runType") && "H".equals(params.get("runType"))) {
                runFlag.put("run", "Y");
                runFlag.put("info", "当前运行的为历史数据信息！");
                runFlag.put("runType", "H");
                runFlag.put("currentDate", format.format(currentDate));
                log.warn(runFlag.get("info"));
            } else {
                //当天数据
                if ("S".equals(process.getCurrentFinishFlag())) {
                    runFlag.put("info", "当前运行的数据日期为：" + format.format(currentDate) + ",该日期下的数据已经运行");
                    log.warn(runFlag.get("info"));
                    runFlag.put("run", "N");
                } else {
                    runFlag.put("run", "Y");
                    runFlag.put("info", "当前运行的数据日期为：" + format.format(currentDate));
                }
            }
            process.setCurrentRunInfo(params.get("currentDateText").toString());
        } else {
            runFlag.put("error", "无法获取到当前任务信息，JcmProcess 为null   ");
            log.warn(runFlag.get("error"));
        }
        return runFlag;
    }

    private Map<String, Object> tanslateParams(String[] args) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        int len = args.length;
        params.put("workType", args[0]);
        if (len > 1) {
            params.put("currentDate", new Date(new SimpleDateFormat("yyyyMMdd").parse(args[1]).getTime()));
            params.put("currentDateText", args[1]);
        }
        if (len > 2) params.put("runType", args[2]);
        return params;
    }


    private JcmProcessLog createLog(JcmProcess process, Map<String, String> runFlag) throws ParseException {
        JcmProcessLog log = new JcmProcessLog();
        log.setId(BigDecimal.valueOf(this.keyGenerator.getKeyByTableName("JCM_PROCESS_LOG")));
        if (process != null) {
            log.setWorkType(process.getWorkType());
            log.setCurrentDate(process.getCurrentDate());
            log.setBegin(new Date(new java.util.Date().getTime()));
            log.setDataDate(runFlag.get("currentDateText"));
            log.setInfo(runFlag.get("info"));
        } else {
            log.setBegin(new Date(new java.util.Date().getTime()));
            log.setInfo(runFlag.get("error"));
        }

        return log;
    }


    private Map<String, String> doAcctCpr(Map<String, Object> params) {
        List<SscfWorkMain> workMains = workMainServiceI.getCompareObjBetw((Date) params.get("currentDate"));
        Map<String, String> result = new HashMap<String, String>();
        Map<String, String> ftp = null;
        String dataDate = params.get("currentDateText").toString();
        List<JcmJobInfo> jcmJobInfos = this.jobInfoServiceI.getByWorkType(params.get("workType").toString());
        JcmJobInfoExample example = new JcmJobInfoExample();
        JcmJobInfoExample.Criteria criteria = null;
        Map<String, String> stepResult = null;
        int nums = 0;
        boolean exeAll = true;
        StringBuffer exeAllBuffer = new StringBuffer();
        String shellStatement = null;
        JcmJobInnerLog innerLog = null;
        for (JcmJobInfo info : jcmJobInfos) {
            criteria = example.createCriteria();
            criteria.andWorkTypeEqualTo(params.get("workType").toString()).andExeResultEqualTo("S").andFinishFlagEqualTo("Y")
                    .andJobCdEqualTo(info.getJobCd());
            if (params.containsKey("runType") && "H".equals(params.get("runType"))) {
                criteria.andExeHistFlagEqualTo("Y").andHsitDateEqualTo(dataDate);
                info.setExeHistFlag("Y");
                info.setHsitDate(dataDate);
            } else {
                criteria.andCurrentDtEqualTo((java.util.Date) params.get("currentDate"));
                info.setCurrentDt((java.util.Date) params.get("currentDate"));
            }
            info.setFinishFlag("N");
            nums = this.jobInfoServiceI.getCountByExample(example);
            if (nums == 1) {
                innerLog = insertInnerLog(info);
                updateInnerLog(innerLog, "日期" + params.get("currentDate") + "已运行，本次忽略！");
                continue;
            }
            innerLog = insertInnerLog(info);
            stepResult = FtpClientUtil.getFilesByFtp(info);
            updateInnerLog(innerLog, stepResult.get("info"));
            String[] shellParams = {params.get("currentDateText").toString()};
            if (stepResult.containsKey("result") && "SUCCESS".equals(stepResult.get("result"))) {
                //DO SHELL LOAD DATA
                innerLog = insertInnerLog(info);
                stepResult = exeShell(info, shellParams);
                updateInnerLog(innerLog, stepResult.get("info"));
                System.out.println("the shell exe result is:" + stepResult);
                if (stepResult.containsKey("result") && "SUCCESS".equals(stepResult.get("result"))) {
                    //DO ACCOUNT COMPARE FUNCTION
                    innerLog = insertInnerLog(info);
                    stepResult = doJavaFucntion(info, workMains, params.get("currentDateText").toString());
                    updateInnerLog(innerLog, stepResult.get("info"));
                    if (!"SUCCESS".equals(stepResult.get("result"))) {
                        exeAllBuffer.append(info.getJobName()).append("执行失败！").append(stepResult.get("info"));
                        exeAll = false;
                    }
                } else {
                    exeAllBuffer.append(info.getJobName()).append("执行失败！").append(stepResult.get("info"));
                    exeAll = false;
                }

            } else {
                exeAllBuffer.append(info.getJobName()).append("执行失败！").append(stepResult.get("info"));
                exeAll = false;
            }

            this.jobInfoServiceI.saveOrUpdate(info);
        }

        if (exeAll) {
            result.put("result", "SUCCESS");
        } else {
            result.put("result", "FAILED");
        }
        result.put("info", exeAllBuffer.toString());

        return result;

    }

    private JcmJobInnerLog insertInnerLog(JcmJobInfo jcmJobInfo) {
        JcmJobInnerLog innerLog = new JcmJobInnerLog();
        innerLog.setId(BigDecimal.valueOf(keyGenerator.getKeyByTableName("jcm_job_inner_log")));
        innerLog.setWorkType(jcmJobInfo.getWorkType());
        innerLog.setJobCd(jcmJobInfo.getJobCd());
        innerLog.setLogDtDtl(new java.util.Date());
        innerLog.setPrcsDt(configServiceI.getSystemDate());
        innerLog.setStartTime(new java.util.Date());

        this.jcmJobIneerLogServerI.saveOrUpdate(innerLog);

        return innerLog;
    }

    private void updateInnerLog(JcmJobInnerLog jcmJobInnerLog, String info) {
        jcmJobInnerLog.setEnd(new java.util.Date());
        jcmJobInnerLog.setCost(BigDecimal.valueOf(jcmJobInnerLog.getEnd().getTime() - jcmJobInnerLog.getStartTime().getTime()));
        jcmJobInnerLog.setRemark(info);
        this.jcmJobIneerLogServerI.saveOrUpdate(jcmJobInnerLog);

    }


    private Map<String, String> exeShell(JcmJobInfo info, String[] shellParams) {
        Map<String, String> stepResult = null;
        //DO SHELL LOAD DATA
        //远程调用 当部署代码服务器与远程服务不在同一个服务器上时使用
        if ("F".equals(info.getInvokeShellMode())) {
            stepResult = ShellInvokeUtil.dynamicExeShell(info.getSshHost(), info.getSshUser(), info.getSshPwd(), info
                    .getShellStatement(), shellParams);
        } else {
            //本地调用
            stepResult = ShellInvokeUtil.staticInvoke(info.getShellStatement(), shellParams);
        }

        return stepResult;
    }

    /**
     * @Author: adrainhan
     * @Time: 2016-11-29 11:48:14
     * @Description: 执行java方法  通过java的反射
     * @Param: jcmJobInfo   作业
     * @Param:workMains
     * @Param:dataDate 数据日期
     * @Return: Map<String, String>
     */
    private Map<String, String> doJavaFucntion(JcmJobInfo jcmJobInfo, List<SscfWorkMain> workMains, String dataDate) {
        Map<String, String> result = new HashMap<String, String>();
        Class clazz = null;
        Object object = null;

        try {
            clazz = Class.forName(jcmJobInfo.getJavaClassName());
            object = clazz.getDeclaredMethod(jcmJobInfo.getJavaMethodName(), List.class, String.class).invoke(clazz.newInstance(),
                    workMains, dataDate);
            result = (Map<String, String>) object;
        } catch (IllegalAccessException e) {
            result.put("result", "FAILURE");
            result.put("info", e.getMessage());
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            result.put("result", "FAILURE");
            result.put("info", e.getMessage());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            result.put("result", "FAILURE");
            result.put("info", e.getMessage());
            e.printStackTrace();
        } catch (InstantiationException e) {
            result.put("result", "FAILURE");
            result.put("info", e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            result.put("result", "FAILURE");
            result.put("info", e.getMessage());
            e.printStackTrace();
        }
        return result;
    }


}
