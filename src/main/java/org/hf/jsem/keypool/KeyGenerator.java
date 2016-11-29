package org.hf.jsem.keypool;

import org.hf.jsem.dao.JcmKeyMapper;
import org.hf.jsem.entity.JcmKey;
import org.hf.jsem.entity.JcmKeyExample;
import org.hf.jsem.orm.DataSourceSelector;
import org.hf.jsem.orm.MultDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by adramer on 2016/11/9.
 */
@Component
public class KeyGenerator {
    private final int catchSize = 1000;
    private Map<String, Key> keys = new HashMap<String, Key>();
    @Autowired
    private JcmKeyMapper keyMapper;
    private final String lock = "lock";


    public Long getKeyByTableName(String tableName) {
        if (tableName == null || tableName.length() == 0) throw new NullPointerException("传入的参数tableName为空");

        return getKey(tableName.toLowerCase());
    }

    private Long getKey(String tableName) {
        if (!keys.containsKey(tableName)) {
            createKey(tableName);
        }
        return pullKey(keys.get(tableName));

    }

    private void createKey(String tableName) {
        synchronized (this.lock) {
            Key key = new Key();
            key.setName(tableName);
            JcmKey jcmKey = null;
            jcmKey = this.keyMapper.selectByPrimaryKey(tableName.toLowerCase());
            if (jcmKey == null) {
                jcmKey = new JcmKey();
                key.setNextValue(1);
                key.setMaxKey(this.catchSize);
                jcmKey = new JcmKey();
                jcmKey.setTableName(tableName.toLowerCase());
                jcmKey.setKey(BigDecimal.valueOf(this.catchSize));
                this.keyMapper.insert(jcmKey);
            } else {
                key.setNextValue(jcmKey.getKey().longValue());
                key.setMaxKey(key.getNextValue() + this.catchSize);
                jcmKey.setKey(BigDecimal.valueOf(key.getMaxKey()));
                this.keyMapper.updateByPrimaryKey(jcmKey);
            }
            this.keys.put(tableName, key);
            this.lock.notify();
        }

    }

    private Long pullKey(Key key) {
        synchronized (key) {
            if (key.getNextValue() + 1 == key.getMaxKey()) {
                key.setMaxKey(key.getMaxKey() + this.catchSize);
                JcmKey jcmKey = new JcmKey();
                jcmKey.setTableName(key.getName());
                jcmKey.setKey(BigDecimal.valueOf(key.getMaxKey()));
                this.keyMapper.updateByPrimaryKey(jcmKey);
            }
            key.setNextValue(key.getNextValue() + 1);
            key.notify();
        }

        return (key.getNextValue() * 10 + 9);
    }


}
