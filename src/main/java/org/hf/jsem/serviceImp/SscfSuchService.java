package org.hf.jsem.serviceImp;

import org.hf.jsem.dao.SscfSuchMapper;
import org.hf.jsem.orm.DataSourceSelector;
import org.hf.jsem.orm.MultDataSource;
import org.hf.jsem.serviceI.SscfSuchServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by adramer on 2016/11/14.
 */
@Service
public class SscfSuchService implements SscfSuchServiceI {
    @Autowired
    private SscfSuchMapper mapper;


    public Long getSeqByTableName(String tableName) throws Exception {
        if (tableName == null || tableName.length() == 0) throw new Exception("空的表名.......");
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("tableName", tableName);
        this.mapper.getSeqByTableName(result);
        if (Integer.valueOf(result.get("retFlag").toString()) != 0) throw new Exception("数据库后台知错能改错误！");
        return Long.parseLong(result.get("seqValue").toString());
    }
}
