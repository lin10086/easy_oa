package cn.gson.oasys.model.bo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author fuwuzhou
 * @version 1.0
 * @Date 2018/10/20
 */
public class PageBO implements Cloneable {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageBO.class);

    public static final int DEFAULT_PAGE_SIZE = 10;//默认10条

    public static final int DEFAULT_PAGE = 1;//默认第一页

    private int pageNo = DEFAULT_PAGE;//当前页数

    private int pageSize = DEFAULT_PAGE_SIZE;//每页的记录数量

    private long totalCount = 0;//总记录数量

    private int totalPageCount = 1;//总页数

    /**
     * 是否是第一页
     *
     * @return
     */
    public boolean isFirstPage() {
        if (pageNo == 1) {
            return true;
        }
        return false;
    }

    /**
     * 是否是最后一页
     *
     * @return
     */
    public boolean isLastPage() {
        if (pageNo == totalPageCount) {
            return true;
        }
        return false;
    }

    /**
     * 是否有上一页
     *
     * @return
     */
    public boolean prePage() {
        if (pageNo == 1) {
            return false;
        }
        return true;
    }

    /**
     * 是否有下一页
     *
     * @return
     */
    public boolean nextPage() {
        if (pageNo == totalPageCount) {
            return false;
        }
        return true;
    }


    public PageBO() {
    } //构造器

    public PageBO(Integer currentPageNo) {
        this.pageNo = currentPageNo;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public PageBO(Integer currentPageNo, Integer pageSize) {
        this.pageNo = currentPageNo;
        this.pageSize = pageSize == null ? DEFAULT_PAGE_SIZE : pageSize;
    }

    public PageBO(Integer currentPageNo, Integer pageSize, Integer totalCount) {
        this.pageNo = currentPageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    /**
     * 总页数
     *
     * @return
     */
    public long getTotalPageCount() {
        calculateTotalPageCount();
        return totalPageCount;
    }

    public void calculateTotalPageCount() {
        if (pageSize == 0) {
            return;
        }
        totalPageCount = (int) totalCount / pageSize;
        if (totalCount % pageSize > 0) {
            totalPageCount++;
        }

        // 校正页码
        if (pageNo > totalPageCount) {
            pageNo = totalPageCount;
        }
        if (pageNo < 1) {
            pageNo = 1;
        }
    }

    /**
     * 每页的记录数量.
     *
     * @return
     */
    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 当前页的页号,序号从1开始.
     *
     * @return
     */
    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int page) {
        this.pageNo = page;
    }

    /**
     * 总记录数量.
     *
     * @return
     */
    public long getTotalCount() {
        return totalCount;
    }


    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        // 计算总页数
        calculateTotalPageCount();
    }

    public static long getDefaultPage() {
        return DEFAULT_PAGE;
    }

    public static long getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    @Override
    public Object clone() {
        Object page = null;
        try {
            page = super.clone();
        } catch (CloneNotSupportedException e) {
            LOGGER.error("clone has error", e);
        }
        return page;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPageCount=" + totalPageCount +
                '}';
    }
}
