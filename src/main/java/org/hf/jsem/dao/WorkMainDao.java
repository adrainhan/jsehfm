package org.hf.jsem.dao;

import org.hf.jsem.entity.SscfWorkMain;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by adramer on 2016/11/1.
 */
@Repository
public class WorkMainDao extends BaseDao<SscfWorkMain,Long> {
    @Override
    public String getNamespace() {
        return SscfWorkMainMapper.class.getCanonicalName();
    }
}
