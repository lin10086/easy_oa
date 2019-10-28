package cn.gson.oasys.model.po;

import java.util.Date;

public class ReviewedPO {
    private Long reviewedId;

    private String advice;

    private Date reviewedTime;

    private Long statusId;

    private Long proId;

    private Long userId;

    private Integer del;

    public Long getReviewedId() {
        return reviewedId;
    }

    public void setReviewedId(Long reviewedId) {
        this.reviewedId = reviewedId;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public Date getReviewedTime() {
        return reviewedTime;
    }

    public void setReviewedTime(Date reviewedTime) {
        this.reviewedTime = reviewedTime;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDel() {
        return del;
    }

    public void setDel(Integer del) {
        this.del = del;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ReviewedPO other = (ReviewedPO) that;
        return (this.getReviewedId() == null ? other.getReviewedId() == null : this.getReviewedId().equals(other.getReviewedId()))
            && (this.getAdvice() == null ? other.getAdvice() == null : this.getAdvice().equals(other.getAdvice()))
            && (this.getReviewedTime() == null ? other.getReviewedTime() == null : this.getReviewedTime().equals(other.getReviewedTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDel() == null ? other.getDel() == null : this.getDel().equals(other.getDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReviewedId() == null) ? 0 : getReviewedId().hashCode());
        result = prime * result + ((getAdvice() == null) ? 0 : getAdvice().hashCode());
        result = prime * result + ((getReviewedTime() == null) ? 0 : getReviewedTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDel() == null) ? 0 : getDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reviewedId=").append(reviewedId);
        sb.append(", advice=").append(advice);
        sb.append(", reviewedTime=").append(reviewedTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", proId=").append(proId);
        sb.append(", userId=").append(userId);
        sb.append(", del=").append(del);
        sb.append("]");
        return sb.toString();
    }
}