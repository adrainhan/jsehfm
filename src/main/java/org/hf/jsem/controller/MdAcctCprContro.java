package org.hf.jsem.controller;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.entity.JcmProcess;
import org.hf.jsem.serviceI.JcmJobInfoServiceI;
import org.hf.jsem.serviceI.JcmProcessServiceI;
import org.hf.jsem.util.FtpClientUtil;
import org.hf.jsem.util.ShellInvokeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/11/1.
 * 委贷对账业务控制
 */
@Component
public class MdAcctCprContro {
    private JcmProcessServiceI processServiceI;
    private JcmJobInfoServiceI jobInfoServiceI;

    @Autowired
    public void setProcessServiceI(JcmProcessServiceI processServiceI) {
        this.processServiceI = processServiceI;
    }

    @Autowired
    public void setJobInfoServiceI(JcmJobInfoServiceI jobInfoServiceI) {
        this.jobInfoServiceI = jobInfoServiceI;
    }

    public int doAcctCprMain(String workType) {
        return runJobProcess(workType);


    }

    private int runJobProcess(String workType) {
        int result = 0;
        JcmProcess process = this.processServiceI.getByPk(workType);

        //返回真，标示需要进行相关操作
        if (processServiceI.getCurrentRunStatus(process)) {
            int runNums = downLoadData(process);
            if (runNums > 0) {
                boolean shellExe = importData(process);
            }

        }

        return result;
    }

    /**
     * 下载文件
     */
    private int downLoadData(JcmProcess process) {
        int result = 0;
        List<JcmJobInfo> jcmJobInfos = this.jobInfoServiceI.getByWorkType(process.getWorkType());
        for (JcmJobInfo jcmJobInfo : jcmJobInfos) {
            if ("N".equals(jcmJobInfo.getFinishFlag())) {
                result++;
                FtpClientUtil.doFtpDown(jcmJobInfo);
            }
        }
        return result;
    }


    /**
     * 执行数据库数据落表脚本
     */
    private boolean importData(JcmProcess process) {
        boolean result = true;
        Map<String, String> shellExe = null;
        List<JcmJobInfo> jcmJobInfos = this.jobInfoServiceI.getByWorkType(process.getWorkType());
        for (JcmJobInfo jcmJobInfo : jcmJobInfos) {
            if ("N".equals(jcmJobInfo.getFinishFlag())) {
                if ("L".equals(jcmJobInfo.getInvokeShellMode())) {
                    shellExe = ShellInvokeUtil.staticInvoke(jcmJobInfo.getShellStatement(), jcmJobInfo.getShellParameters().split("~@^@~"));
                } else if ("N".equals(jcmJobInfo.getInvokeShellMode())) {
                    shellExe = ShellInvokeUtil.dynamicExeShell(jcmJobInfo.getSshHost(), jcmJobInfo.getSshUser(), jcmJobInfo.getSshPwd(), jcmJobInfo.getShellStatement(), jcmJobInfo.getShellParameters().split
                            ("~@^@~"));
                } else {
                    shellExe = new HashMap<String, String>();
                    shellExe.put("result", "failed");
                    shellExe.put("info", "未知的ssh连接模式：" + jcmJobInfo.getInvokeShellMode() == null ? "连接模式为空" : jcmJobInfo.getInvokeShellMode());
                }
            }
        }
        if (shellExe == null || !shellExe.containsKey("result") || !"success".equals(shellExe.get("result"))) {
            result = false;
        }

        return result;
    }

    /**
     * 委贷对账 业务
     */
    private boolean doAcctCpr(String workType) {
        boolean result = false;
        if(this.jobInfoServiceI.validateAllFinishedByWorkType(workType)){






        }

        return result;
    }


}
