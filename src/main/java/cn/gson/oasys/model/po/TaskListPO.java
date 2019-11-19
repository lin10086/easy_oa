package cn.gson.oasys.model.po;

import java.util.Date;

public class TaskListPO {
    private Long taskId;

    private String comment;

    private Date endTime;

    private Integer isCancel;

    private Integer isTop;

    private Date modifyTime;

    private Date publishTime;

    private Date starTime;

    private Integer statusId;

    private String taskDescribe;

    private String ticking;

    private String title;

    private Long typeId;

    private Long taskPushUserId;

    private String reciverlist;

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Integer getIsTop() {
        return isTop;
    }

    public void setIsTop(Integer isTop) {
        this.isTop = isTop;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getTaskDescribe() {
        return taskDescribe;
    }

    public void setTaskDescribe(String taskDescribe) {
        this.taskDescribe = taskDescribe == null ? null : taskDescribe.trim();
    }

    public String getTicking() {
        return ticking;
    }

    public void setTicking(String ticking) {
        this.ticking = ticking == null ? null : ticking.trim();
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

    public Long getTaskPushUserId() {
        return taskPushUserId;
    }

    public void setTaskPushUserId(Long taskPushUserId) {
        this.taskPushUserId = taskPushUserId;
    }

    public String getReciverlist() {
        return reciverlist;
    }

    public void setReciverlist(String reciverlist) {
        this.reciverlist = reciverlist == null ? null : reciverlist.trim();
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
        TaskListPO other = (TaskListPO) that;
        return (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getIsCancel() == null ? other.getIsCancel() == null : this.getIsCancel().equals(other.getIsCancel()))
            && (this.getIsTop() == null ? other.getIsTop() == null : this.getIsTop().equals(other.getIsTop()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getStarTime() == null ? other.getStarTime() == null : this.getStarTime().equals(other.getStarTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getTaskDescribe() == null ? other.getTaskDescribe() == null : this.getTaskDescribe().equals(other.getTaskDescribe()))
            && (this.getTicking() == null ? other.getTicking() == null : this.getTicking().equals(other.getTicking()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getTaskPushUserId() == null ? other.getTaskPushUserId() == null : this.getTaskPushUserId().equals(other.getTaskPushUserId()))
            && (this.getReciverlist() == null ? other.getReciverlist() == null : this.getReciverlist().equals(other.getReciverlist()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getIsCancel() == null) ? 0 : getIsCancel().hashCode());
        result = prime * result + ((getIsTop() == null) ? 0 : getIsTop().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getStarTime() == null) ? 0 : getStarTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getTaskDescribe() == null) ? 0 : getTaskDescribe().hashCode());
        result = prime * result + ((getTicking() == null) ? 0 : getTicking().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getTaskPushUserId() == null) ? 0 : getTaskPushUserId().hashCode());
        result = prime * result + ((getReciverlist() == null) ? 0 : getReciverlist().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", taskId=").append(taskId);
        sb.append(", comment=").append(comment);
        sb.append(", endTime=").append(endTime);
        sb.append(", isCancel=").append(isCancel);
        sb.append(", isTop=").append(isTop);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", publishTime=").append(publishTime);
        sb.append(", starTime=").append(starTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", taskDescribe=").append(taskDescribe);
        sb.append(", ticking=").append(ticking);
        sb.append(", title=").append(title);
        sb.append(", typeId=").append(typeId);
        sb.append(", taskPushUserId=").append(taskPushUserId);
        sb.append(", reciverlist=").append(reciverlist);
        sb.append("]");
        return sb.toString();
    }
}