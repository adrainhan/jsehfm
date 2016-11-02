package org.hf.jsem.orm;

/**
 * Created by adramer on 2016/11/1.
 * 用于定义多数据原的值，保存成键值对
 */
public enum DataSourceSelector {
    SCUH("suchDataSource"), JCM("jcmDataSource");
    private String dataSource;

    private DataSourceSelector(String dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String toString() {
        return String.valueOf(this.dataSource);
    }

}
