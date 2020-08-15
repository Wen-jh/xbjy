package com.wjh.model;

import java.util.List;

public class PageEntity<T> {
    private List<T> data;
    private Integer totalPage;
    private Integer currPage;
    private Integer pageSize=5;
    private Integer totalCount;
    private Integer startIndex;
    private Integer endIndex;
    private Integer numNav=3;
    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {

        this.startIndex = startIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(Integer endIndex) {
        this.endIndex = endIndex;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
        this.startIndex = (this.currPage - 1) / numNav * numNav + 1;
        this.endIndex = (this.currPage - 1) / numNav * numNav + numNav;
        if (this.endIndex > this.totalPage) {
            this.endIndex = this.totalPage;
        }
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
