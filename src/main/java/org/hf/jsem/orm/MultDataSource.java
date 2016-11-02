package org.hf.jsem.orm;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by adramer on 2016/10/31.
 */
public class MultDataSource extends AbstractRoutingDataSource {
    private static final ThreadLocal<String> dataSourceKeys= new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSourceKey){
        dataSourceKeys.set(dataSourceKey);
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKeys.get();
    }
}
