package org.hf.jsem.dao;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by adramer on 2016/11/21.
 */
@Repository
public class JobInfoDao extends BaseDao<JcmJobInfo, String> {
    @Override
    public String getNamespace() {
        return JcmJobInfoMapper.class.getCanonicalName();
    }
}
