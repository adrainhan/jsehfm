package org.hf.jsem.dao;

import org.hf.jsem.entity.SscfWorkMain;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by adramer on 2016/11/29.
 */
@Repository
public class WorkmainDao extends BaseDao<SscfWorkMain, BigDecimal> {
    @Override
    public String getNamespace() {
        return SscfWorkMainMapper.class.getCanonicalName();
    }
}
