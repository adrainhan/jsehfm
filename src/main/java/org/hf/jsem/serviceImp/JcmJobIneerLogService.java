package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.JobIneerLogDao;
import org.hf.jsem.entity.JcmJobInnerLog;
import org.hf.jsem.serviceI.JcmJobIneerLogServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adramer on 2016/11/28.
 */
@Service
public class JcmJobIneerLogService implements JcmJobIneerLogServerI {
    @Autowired
    private JobIneerLogDao ineerLogDao;


    public void saveOrUpdate(JcmJobInnerLog log) {
        JcmJobInnerLog innerLog = this.ineerLogDao.getById(log.getId());
        if (innerLog == null) {
            this.ineerLogDao.save(log);
        } else {
            this.ineerLogDao.updateSelective(log);
        }
    }
}
