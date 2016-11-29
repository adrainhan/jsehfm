package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.ProceeLogDao;
import org.hf.jsem.entity.JcmProcessLog;
import org.hf.jsem.serviceI.JcmPorcessLogSercieI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by adramer on 2016/11/21.
 */
@Service
public class JcmPorcessLogSercie implements JcmPorcessLogSercieI {
    @Autowired
    private ProceeLogDao proceeLogDao;

    public void saveOrUPdate(JcmProcessLog log) {
        JcmProcessLog processLog = this.proceeLogDao.getById(log.getId());
        if (processLog == null) {
            this.proceeLogDao.save(log);
        } else {
            this.proceeLogDao.updateSelective(log);
        }
        this.proceeLogDao.saveOrUpdate(log);
    }
}
