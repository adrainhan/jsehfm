package org.hf.jsem.dao;

import org.hf.jsem.entity.JcmProcessLog;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by adramer on 2016/11/18.
 */
@Repository
public class ProceeLogDao extends BaseDao<JcmProcessLog, BigDecimal> {
    @Override
    public String getNamespace() {
        return JcmProcessLogMapper.class.getCanonicalName();
    }
}
