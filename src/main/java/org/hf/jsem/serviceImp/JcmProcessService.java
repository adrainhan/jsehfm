package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.JcmProcessDao;
import org.hf.jsem.dao.JcmProcessMapper;
import org.hf.jsem.entity.JcmProcess;
import org.hf.jsem.entity.JcmProcessExample;
import org.hf.jsem.serviceI.JcmProcessServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adramer on 2016/10/25.
 */
@Service("jcmProcessService")
public class JcmProcessService  {
    private JcmProcessDao processDao;

    @Autowired
    public void setProcessDao(JcmProcessDao processDao) {
        this.processDao = processDao;
    }


    public JcmProcess getByPk(String key) {
        if (key != null && key.length()>0 ) {
            return processDao.getById(key);
        } else {
            throw new NullPointerException("未获取到需要查询的任务编码，任务编码值为空！");
        }
    }
}
