package com.wjh.model;

public class PagingUtil {

    //当前页数据 传进来
    private Object data;
    //总页数
    private Integer totalPage;
    //当前页 传进来
    private Integer currPage;
    //页大小
    private Integer pageSize = 5;
    //总记录数 传进来
    private Integer totalCount;
    //导航起始页
    private Integer startPage;
    //导航末尾页
    private Integer endPage;
    //导航个数
    private Integer numNav = 3;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
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
        this.startPage = (this.currPage - 1) / numNav * numNav + 1;
        this.endPage = (this.currPage - 1) / numNav * numNav + numNav;
        if (this.endPage > this.totalPage) {
            this.endPage = this.totalPage;
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
        Integer i = this.totalCount / this.pageSize;
        if (this.totalCount % this.pageSize > 0) {
            i += 1;
        }
        this.totalPage = i;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getNumNav() {
        return numNav;
    }

    public void setNumNav(Integer numNav) {
        this.numNav = numNav;
        this.startPage = (this.currPage - 1) / numNav * numNav + 1;
        this.endPage = (this.currPage - 1) / numNav * numNav + numNav;
        if (this.endPage > this.totalPage) {
            this.endPage = this.totalPage;
        }
    }
}
