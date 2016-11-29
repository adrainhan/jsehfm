package org.hf.jsem.serviceImp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hf.jsem.dao.JcmProcessMapper;
import org.hf.jsem.dao.ProcessDao;
import org.hf.jsem.entity.JcmProcess;
import org.hf.jsem.entity.JcmProcessExample;
import org.hf.jsem.serviceI.JcmProcessServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by adramer on 2016/10/25.
 */
@Service
public class JcmProcessService implements JcmProcessServiceI {
    @Autowired
    private ProcessDao processDao;


    public JcmProcess getByPk(String key) {
        return this.processDao.getById(key);
    }

    public void saveOrUpdate(JcmProcess process) {
        JcmProcess pro = this.processDao.getById(process.getWorkType());
        if (pro == null) {
            this.processDao.save(process);
        } else {
            this.processDao.updateSelective(process);
        }


        this.processDao.saveOrUpdate(process);
    }

}
