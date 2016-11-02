package org.hf.jsem.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.serviceI.JcmProcessServiceI;
import org.hf.jsem.serviceImp.JcmProcessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by adramer on 2016/10/24.
 */
public class Test {
    private  static final Log log = LogFactoryImpl.getLog(Test.class);
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
    }

}
