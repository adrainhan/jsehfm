package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.SysCtrlDao;
import org.hf.jsem.serviceI.SystemConfigServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * Created by adramer on 2016/11/28.
 */
@Service
public class SystemConfigService implements SystemConfigServiceI {
    @Autowired
    private SysCtrlDao sysCtrlDao;

    public Date getSystemDate() {
        return this.sysCtrlDao.getById("000").getCurPrcsDate();
    }
}
