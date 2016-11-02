package org.hf.jsem.dao;

import org.hf.jsem.entity.JcmJobInfo;
import org.hf.jsem.orm.BaseDao;
import org.hf.jsem.orm.DataSourceSelector;
import org.hf.jsem.orm.MultDataSource;
import org.springframework.stereotype.Repository;

/**
 * Created by adramer on 2016/11/1.
 */
@Repository
public class JcmJobInfoDao extends BaseDao<JcmJobInfo,String> {

    @Override
    public String getNamespace() {
        MultDataSource.setDataSourceKey(DataSourceSelector.JCM.toString());
        return JcmJobInfoMapper.class.getCanonicalName();
    }
}
