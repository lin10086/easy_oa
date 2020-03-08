package cn.gson.oasys.modelV2.po;

import java.util.Date;

public class SchedulePO {
    private Long rcId;

    private Date createTime;

    private Date endTime;

    private String filedescribe;

    private Integer isRemind;

    private Date startTime;

    private Long statusId;

    private String title;

    private Long typeId;

    private Long userId;

    private String miaoshu;

    private Integer isreminded;

    public Long getRcId() {
        return rcId;
    }

    public void setRcId(Long rcId) {
        this.rcId = rcId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getFiledescribe() {
        return filedescribe;
    }

    public void setFiledescribe(String filedescribe) {
        this.filedescribe = filedescribe == null ? null : filedescribe.trim();
    }

    public Integer getIsRemind() {
        return isRemind;
    }

    public void setIsRemind(Integer isRemind) {
        this.isRemind = isRemind;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMiaoshu() {
        return miaoshu;
    }

    public void setMiaoshu(String miaoshu) {
        this.miaoshu = miaoshu == null ? null : miaoshu.trim();
    }

    public Integer getIsreminded() {
        return isreminded;
    }

    public void setIsreminded(Integer isreminded) {
        this.isreminded = isreminded;
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
        SchedulePO other = (SchedulePO) that;
        return (this.getRcId() == null ? other.getRcId() == null : this.getRcId().equals(other.getRcId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getFiledescribe() == null ? other.getFiledescribe() == null : this.getFiledescribe().equals(other.getFiledescribe()))
            && (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getMiaoshu() == null ? other.getMiaoshu() == null : this.getMiaoshu().equals(other.getMiaoshu()))
            && (this.getIsreminded() == null ? other.getIsreminded() == null : this.getIsreminded().equals(other.getIsreminded()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRcId() == null) ? 0 : getRcId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getFiledescribe() == null) ? 0 : getFiledescribe().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMiaoshu() == null) ? 0 : getMiaoshu().hashCode());
        result = prime * result + ((getIsreminded() == null) ? 0 : getIsreminded().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", rcId=").append(rcId);
        sb.append(", createTime=").append(createTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", filedescribe=").append(filedescribe);
        sb.append(", isRemind=").append(isRemind);
        sb.append(", startTime=").append(startTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", title=").append(title);
        sb.append(", typeId=").append(typeId);
        sb.append(", userId=").append(userId);
        sb.append(", miaoshu=").append(miaoshu);
        sb.append(", isreminded=").append(isreminded);
        sb.append("]");
        return sb.toString();
    }
}