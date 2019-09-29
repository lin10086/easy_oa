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

    public static final int DEFAULT_PAGESIZE = 20;//默认20条

    public static final int DEFAULT_PAGE = 1;//默认第一页

    private int pageNo = DEFAULT_PAGE;//当前页数

    private int pageSize = DEFAULT_PAGESIZE;//每页的记录数量

    private long totalCount = 0;//总记录数量

    private int totalPageCount = 1;//总页数

    public PageBO() {
    } //构造器

    public PageBO(Integer currentPageNo) {
        this.pageNo = currentPageNo;
        this.pageSize = DEFAULT_PAGESIZE;
    }

    public PageBO(Integer currentPageNo, Integer pageSize) {
        this.pageNo = currentPageNo;
        this.pageSize = pageSize == null ? DEFAULT_PAGESIZE : pageSize;
    }

    public PageBO(Integer currentPageNo, Integer pageSize, Integer totalCount) {
        this.pageNo = currentPageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    /**
     * 总页数.
     *
     * @return
     * @author zhaolei
     * @created 2011-4-22
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
     * @author zhaolei
     * @created 2011-4-22
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
     * @author zhaolei
     * @created 2011-4-22
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
     * @author zhaolei
     * @created 2011-4-22
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

    public static long getDefaultPagesize() {
        return DEFAULT_PAGESIZE;
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
