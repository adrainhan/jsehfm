package org.hf.jsem.core;

import org.hf.jsem.controller.ExeMdAcctCprService;
import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.entity.SscfWorkMain;
import org.hf.jsem.test.TestInvoke;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/11/18.
 */
public class Inner {


    /**
     * @Author: adrainhan
     * @Time: 2016-11-18 14:42:21
     * @Description: 该方法为所有的作业任务的调度入口，
     * @Param: args  外部调用该方法时，参数不得为空，否则直接抛异常 下列对数组位置的参数进行了说明，如若需要新的位置，请添加新的说明
     * Param desc: args[0]:定义了需要跑的作业 对应的是 jcm_process 表中的：work_type
     * args[1]:任务运行的业务数据日期
     * args[2]:是否为历史数据   传入值为  H ： 历史数据     C： 当天数据    当传入的参数值超过三个值时，该值必须有值
     * @Return:
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Map<String, String> parames = new HashMap<String, String>();
        if (args != null && args.length == 1) {
            parames.put("target", args[0]);   //至少传入一个参数，定于任务
        }
        parames.put("target", "mdacctcpr");
        System.out.println("hello....");
        System.out.println(parames);
        String[] t = {"mdacctcpr", "20170101", "H"};
        try {
            if ("mdacctcpr".equals(parames.get("target"))) {
                ExeMdAcctCprService service = context.getBean(ExeMdAcctCprService.class);
                JcmJobInfo info = new JcmJobInfo();
                info.setJavaClassName(TestInvoke.class.getCanonicalName());
                info.setJavaMethodName("test");
                service.doMdAcctCpr(t);
                List<SscfWorkMain> workMains = new ArrayList<SscfWorkMain>();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
