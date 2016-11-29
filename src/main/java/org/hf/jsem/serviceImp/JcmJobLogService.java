package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.JcmJobLogDao;
import org.hf.jsem.entity.JcmJobLog;
import org.hf.jsem.serviceI.JcmJobLogServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by adramer on 2016/11/21.
 */
@Service
public class JcmJobLogService implements JcmJobLogServiceI {
    @Autowired
    private JcmJobLogDao jcmJobLogDao;


}
