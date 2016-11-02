package org.hf.jsem.orm;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * Created by adramer on 2016/10/25.
 */
public class PageQuery {
    protected int page = 1;
    protected int rows = 10;

    protected String sort = null;
    protected String order = null;
    protected long total = 0;

    protected boolean countTotal = true;

    public PageQuery() {
    }

    public PageQuery(int page, int rows) {
        this.page = page;
        this.rows = rows;
    }

    public PageQuery(int page, int rows, String sort, String order) {
        this.page = page;
        this.rows = rows;

        this.sort = sort;
        this.order = order;
    }

    /**
     * 获得当前页的页号, 序号从1开始, 默认为1.
     */
    public int getPage() {
        return page;
    }

    /**
     * 设置当前页的页号, 序号从1开始, 低于1时自动调整为1.
     */
    public void setPage(final int page) {
        this.page = page;

        if (page < 1) {
            this.page = 1;
        }
    }

    /**
     * 获得每页的记录数量, 默认为10.
     */
    public int getRows() {
        return rows;
    }

    /**
     * 设置每页的记录数量, 低于1时自动调整为1.
     */
    public void setRows(final int rows) {
        this.rows = rows;

        if (rows < 1) {
            this.rows = 1;
        }
    }

    /**
     * 获得排序字段, 无默认值. 多个排序字段时用','分隔.
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序字段, 多个排序字段时用','分隔.
     */
    public void setSort(final String sort) {
        this.sort = sort;
    }

    /**
     * 获得排序方向, 无默认值.
     */
    public String getOrder() {
        return order;
    }

    /**
     * 总记录数
     *
     * @return
     */
    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    /**
     * 获得排序参数.
     */
    public List<SortInfo> getOrderBys() {
        dealOrder();
        String[] sorts = StringUtils.split(sort, ',');
        String[] orders = StringUtils.split(order, ',');
        Validate.isTrue(sorts.length == orders.length,
                "分页多重排序参数中,排序字段与排序方向的个数不相等");

        List<SortInfo> orderBys = Lists.newArrayList();
        for (int i = 0; i < sorts.length; i++) {
            orderBys.add(new SortInfo(sorts[i], orders[i]));
        }

        return orderBys;
    }

    /**
     * 多个排序字段时，处理每个字段的排序类型
     */
    private void dealOrder() {
        if (this.order != null && !"".equals(this.order.trim())) {
            String lowcaseOrderDir = StringUtils.lowerCase(this.order);

            // 检查order字符串的合法值
            String[] orders = StringUtils.split(lowcaseOrderDir, ',');
            for (String orderStr : orders) {
                if (!StringUtils.equals(SortInfo.DESC, orderStr)
                        && !StringUtils.equals(SortInfo.ASC, orderStr)) {
                    throw new IllegalArgumentException("排序方向" + orderStr
                            + "不是合法值");
                }
            }

            this.order = lowcaseOrderDir;
        }
    }

    /**
     * 是否已设置排序字段,无默认值.
     */
    public boolean isOrderBySetted() {
        return (StringUtils.isNotBlank(sort) && StringUtils.isNotBlank(order));
    }

    /**
     * 是否默认计算总记录数.
     */
    public boolean isCountTotal() {
        return countTotal;
    }

    /**
     * 设置是否默认计算总记录数.
     */
    public void setCountTotal(boolean countTotal) {
        this.countTotal = countTotal;
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置, 序号从0开始.
     */
    public int getOffset() {
        return ((page - 1) * rows);
    }
}
