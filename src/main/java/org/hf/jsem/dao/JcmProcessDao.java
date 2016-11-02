package org.hf.jsem.dao;

import org.hf.jsem.entity.JcmProcess;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by adramer on 2016/11/1.
 */
@Repository
public class JcmProcessDao extends BaseDao<JcmProcess, String> {

    @Override
    public String getNamespace() {
        return JcmProcessMapper.class.getCanonicalName();
    }
}
