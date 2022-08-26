package com.atguigu.pojo;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 4;

    private Integer pageNo;
    private Integer pageSize = PAGE_SIZE;
    // number of records
    private Integer pageCount;
    // number of pages
    private Integer pageTotal;

    private String url;
    private List<T> items;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageCount, Integer pageTotal, String url, List<T> items) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.pageCount = pageCount;
        this.pageTotal = pageTotal;
        this.url = url;
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            this.pageNo = 1;
        } else if (pageNo > this.pageTotal) {
            this.pageNo = this.pageTotal;
        } else {
            this.pageNo = pageNo;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", pageCount=" + pageCount +
                ", pageTotal=" + pageTotal +
                ", url='" + url + '\'' +
                ", items=" + items +
                '}';
    }
}
