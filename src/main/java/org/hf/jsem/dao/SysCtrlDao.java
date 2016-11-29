package org.hf.jsem.dao;

import org.hf.jsem.entity.ScmsSysCtrl;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by adramer on 2016/11/18.
 */
@Repository
public class SysCtrlDao extends BaseDao<ScmsSysCtrl, String> {
    @Override
    public String getNamespace() {
        return ScmsSysCtrlMapper.class.getCanonicalName();
    }
}
