package net.s.anli2.common.utils;

import java.util.List;

public class Pager<T> {
    private int count;
    private int pageNo;//第几页
    private int pageSize;//每一页的显示数量
    private int pageCount;//总的页数

    private List<T> objects;

    private boolean isFirst;
    private boolean isLast;

    private int FirstPage;
    private int LastPage;
    public Pager() {
    }

    public Pager(int count, int pageNo, int pageSize, List<T> objects) {
        this.count = count;
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.objects = objects;
        this.pageCount = (count/pageSize) + ((count%pageSize!=0)?1:0);
        FirstPage = 1;
        LastPage = pageCount;
        isFirst = (pageNo == FirstPage);
        isLast = (pageNo == LastPage);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getObjects() {
        return objects;
    }

    public void setObjects(List<T> objects) {
        this.objects = objects;
    }

    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    public boolean isLast() {
        return isLast;
    }

    public void setLast(boolean last) {
        isLast = last;
    }

    public int getFirstPage() {
        return FirstPage;
    }

    public void setFirstPage(int firstPage) {
        FirstPage = firstPage;
    }

    public int getLastPage() {
        return LastPage;
    }

    public void setLastPage(int lastPage) {
        LastPage = lastPage;
    }
}
