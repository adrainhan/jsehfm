package org.hf.jsem.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by adramer on 2016/10/25.
 * 排序的列 for PageRequest.getSortInfos()
 */
public class SortInfo implements Serializable {

    public static final String ASC = "ASC";
    public static final String DESC = "DESC";

    private static final long serialVersionUID = 6959974032209696722L;

    private String columnName;
    private String sortOrder;

    public SortInfo() {
    }

    public SortInfo(String columnName, String sortOrder) {
        super();
        this.columnName = columnName;
        this.sortOrder = sortOrder;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public static List<SortInfo> parseSortColumns(String sortColumns) {
        if (sortColumns == null) {
            return Collections.emptyList();
        }

        List<SortInfo> results = new ArrayList<SortInfo>();
        String[] sortSegments = sortColumns.trim().split(",");
        for (int i = 0; i < sortSegments.length; i++) {
            String sortSegment = sortSegments[i];
            String[] array = sortSegment.split("\\s+");

            SortInfo sortInfo = new SortInfo();
            sortInfo.setColumnName(array[0]);
            sortInfo.setSortOrder(array.length == 2 ? array[1] : null);
            results.add(sortInfo);
        }
        return results;
    }

    public String toString() {
        return columnName + (sortOrder == null ? "" : " " + sortOrder);
    }
}