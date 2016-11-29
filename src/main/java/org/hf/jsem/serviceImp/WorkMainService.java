package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.WorkmainDao;
import org.hf.jsem.entity.SscfWorkMain;
import org.hf.jsem.entity.SscfWorkMainExample;
import org.hf.jsem.serviceI.WorkMainServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;


/**
 * Created by adramer on 2016/11/3.
 */
@Service
public class WorkMainService implements WorkMainServiceI {
    @Autowired
    private WorkmainDao workmainDao;

    public List<SscfWorkMain> getCompareObjBetw(Date currentDate) {
        SscfWorkMainExample example = new SscfWorkMainExample();
        SscfWorkMainExample.Criteria criteria = example.createCriteria();
        criteria.andPrcsDtBetween(new Date(currentDate.getTime() - 1000 * 24 * 3600), new Date(currentDate.getTime() + 1000 *
                24 * 3600));
        return this.workmainDao.findAll(example);
    }
}
