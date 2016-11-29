package org.hf.jsem.dao;

import org.hf.jsem.entity.JcmJobLog;
import org.hf.jsem.entity.JcmJobLogExample;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by adramer on 2016/11/21.
 */
@Repository
public class JcmJobLogDao extends BaseDao<JcmJobLog, Long> {
    @Override
    public String getNamespace() {
        return JcmJobLogExample.class.getCanonicalName();
    }
}
