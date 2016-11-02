package org.hf.jsem.orm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by adramer on 2016/10/25.
 */
public class PageList<E> extends ArrayList<E> implements Serializable {
    private static final long serialVersionUID = 1412759446332294208L;

    /** 分页大小 */
    private int rows;
    /** 页码 */
    private int page;
    /** 总记录数 */
    private int total;

    public PageList() {
    }

    public PageList(Collection<? extends E> c) {
        super(c);
    }

    public PageList(int page, int rows, int total) {
        this.page = page;
        this.rows = rows;
        this.total = total;
    }

    public PageList(Collection<? extends E> c, int page, int rows, int total) {
        super(c);
        this.page = page;
        this.rows = rows;
        this.total = total;
    }

    public PageList(Paginator p) {
        this.page = p.getPage();
        this.rows = p.getRows();
        this.total = p.getTotal();
    }

    public PageList(Collection<? extends E> c, Paginator p) {
        super(c);
        this.page = p.getPage();
        this.rows = p.getRows();
        this.total = p.getTotal();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * 得到分页器，通过Paginator可以得到总页数等值
     *
     * @return
     */
    public Paginator getPaginator() {
        return new Paginator(page, rows, total);
    }

}
