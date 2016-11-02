package org.hf.jsem.dao;

import org.hf.jsem.entity.SscfChannel;
import org.hf.jsem.orm.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * Created by adramer on 2016/11/1.
 */
@Repository
public class ChannelDao extends BaseDao<SscfChannel, String> {
    @Override
    public String getNamespace() {
        return SscfChannelMapper.class.getCanonicalName();
    }
}
