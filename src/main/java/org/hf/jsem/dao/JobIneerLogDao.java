package org.hf.jsem.dao;

import org.hf.jsem.entity.JcmJobInnerLog;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by adramer on 2016/11/28.
 */
@Repository
public class JobIneerLogDao extends BaseDao<JcmJobInnerLog, BigDecimal> {
    @Override
    public String getNamespace() {
        return JcmJobInnerLogMapper.class.getCanonicalName();
    }
}
