package cn.gson.oasys.model.po;

import java.util.Date;

public class PlanListPO {
    private Long planId;

    private Date createTime;

    private Date endTime;

    private String label;

    private String planComment;

    private String planContent;

    private String planSummary;

    private Date startTime;

    private Long statusId;

    private String title;

    private Long typeId;

    private Long planUserId;

    private Long attachId;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getPlanComment() {
        return planComment;
    }

    public void setPlanComment(String planComment) {
        this.planComment = planComment == null ? null : planComment.trim();
    }

    public String getPlanContent() {
        return planContent;
    }

    public void setPlanContent(String planContent) {
        this.planContent = planContent == null ? null : planContent.trim();
    }

    public String getPlanSummary() {
        return planSummary;
    }

    public void setPlanSummary(String planSummary) {
        this.planSummary = planSummary == null ? null : planSummary.trim();
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

    public Long getPlanUserId() {
        return planUserId;
    }

    public void setPlanUserId(Long planUserId) {
        this.planUserId = planUserId;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
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
        PlanListPO other = (PlanListPO) that;
        return (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
            && (this.getPlanComment() == null ? other.getPlanComment() == null : this.getPlanComment().equals(other.getPlanComment()))
            && (this.getPlanContent() == null ? other.getPlanContent() == null : this.getPlanContent().equals(other.getPlanContent()))
            && (this.getPlanSummary() == null ? other.getPlanSummary() == null : this.getPlanSummary().equals(other.getPlanSummary()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getPlanUserId() == null ? other.getPlanUserId() == null : this.getPlanUserId().equals(other.getPlanUserId()))
            && (this.getAttachId() == null ? other.getAttachId() == null : this.getAttachId().equals(other.getAttachId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        result = prime * result + ((getPlanComment() == null) ? 0 : getPlanComment().hashCode());
        result = prime * result + ((getPlanContent() == null) ? 0 : getPlanContent().hashCode());
        result = prime * result + ((getPlanSummary() == null) ? 0 : getPlanSummary().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getPlanUserId() == null) ? 0 : getPlanUserId().hashCode());
        result = prime * result + ((getAttachId() == null) ? 0 : getAttachId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", planId=").append(planId);
        sb.append(", createTime=").append(createTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", label=").append(label);
        sb.append(", planComment=").append(planComment);
        sb.append(", planContent=").append(planContent);
        sb.append(", planSummary=").append(planSummary);
        sb.append(", startTime=").append(startTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", title=").append(title);
        sb.append(", typeId=").append(typeId);
        sb.append(", planUserId=").append(planUserId);
        sb.append(", attachId=").append(attachId);
        sb.append("]");
        return sb.toString();
    }
}