package org.hf.jsem.core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.hf.jsem.dao.ProceeLogDao;
import org.hf.jsem.dao.ProcessDao;
import org.hf.jsem.dao.SscfLnmtCaafverDtlMapper;
import org.hf.jsem.dao.SscfMsgPpslMapper;
import org.hf.jsem.entity.*;
import org.hf.jsem.keypool.KeyGenerator;
import org.hf.jsem.orm.DataSourceSelector;
import org.hf.jsem.orm.MultDataSource;
import org.hf.jsem.serviceI.JcmProcessServiceI;
import org.hf.jsem.serviceI.WorkMainServiceI;
import org.hf.jsem.serviceImp.JcmProcessService;
import org.hf.jsem.serviceImp.WorkMainService;
import org.hf.jsem.shortmsg.MsgClientSingle;
import org.hf.jsem.shortmsg.ShortMessage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/10/24.
 */
public class Test {
    private static final Log log = LogFactoryImpl.getLog(Test.class);

    public static void main(String args[]) throws UnsupportedEncodingException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        JcmProcessLog log = new JcmProcessLog();
        ProcessDao processDao = context.getBean(ProcessDao.class);
        JcmProcess process = processDao.getById("mdacctcpr");
        System.out.println(process.getWorkType());
        process.setCurrentDate(new Date(new java.util.Date().getTime()));
        System.out.println(process.getCurrentDate());
        System.out.println(processDao.saveOrUpdate(process));
        log.setId(BigDecimal.valueOf(1234567890));
        ProceeLogDao dao = context.getBean(ProceeLogDao.class);
        System.out.println("end......");
    }

}
