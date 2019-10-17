package cn.gson.oasys.model.po;

import java.util.Date;

public class AttachmentListPO {
    private Long attachmentId;

    private String attachmentName;

    private String attachmentPath;

    private String attachmentShuffix;

    private String attachmentSize;

    private String attachmentType;

    private String model;

    private Date uploadTime;

    private String userId;

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName == null ? null : attachmentName.trim();
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath == null ? null : attachmentPath.trim();
    }

    public String getAttachmentShuffix() {
        return attachmentShuffix;
    }

    public void setAttachmentShuffix(String attachmentShuffix) {
        this.attachmentShuffix = attachmentShuffix == null ? null : attachmentShuffix.trim();
    }

    public String getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(String attachmentSize) {
        this.attachmentSize = attachmentSize == null ? null : attachmentSize.trim();
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType == null ? null : attachmentType.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
        AttachmentListPO other = (AttachmentListPO) that;
        return (this.getAttachmentId() == null ? other.getAttachmentId() == null : this.getAttachmentId().equals(other.getAttachmentId()))
            && (this.getAttachmentName() == null ? other.getAttachmentName() == null : this.getAttachmentName().equals(other.getAttachmentName()))
            && (this.getAttachmentPath() == null ? other.getAttachmentPath() == null : this.getAttachmentPath().equals(other.getAttachmentPath()))
            && (this.getAttachmentShuffix() == null ? other.getAttachmentShuffix() == null : this.getAttachmentShuffix().equals(other.getAttachmentShuffix()))
            && (this.getAttachmentSize() == null ? other.getAttachmentSize() == null : this.getAttachmentSize().equals(other.getAttachmentSize()))
            && (this.getAttachmentType() == null ? other.getAttachmentType() == null : this.getAttachmentType().equals(other.getAttachmentType()))
            && (this.getModel() == null ? other.getModel() == null : this.getModel().equals(other.getModel()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttachmentId() == null) ? 0 : getAttachmentId().hashCode());
        result = prime * result + ((getAttachmentName() == null) ? 0 : getAttachmentName().hashCode());
        result = prime * result + ((getAttachmentPath() == null) ? 0 : getAttachmentPath().hashCode());
        result = prime * result + ((getAttachmentShuffix() == null) ? 0 : getAttachmentShuffix().hashCode());
        result = prime * result + ((getAttachmentSize() == null) ? 0 : getAttachmentSize().hashCode());
        result = prime * result + ((getAttachmentType() == null) ? 0 : getAttachmentType().hashCode());
        result = prime * result + ((getModel() == null) ? 0 : getModel().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attachmentId=").append(attachmentId);
        sb.append(", attachmentName=").append(attachmentName);
        sb.append(", attachmentPath=").append(attachmentPath);
        sb.append(", attachmentShuffix=").append(attachmentShuffix);
        sb.append(", attachmentSize=").append(attachmentSize);
        sb.append(", attachmentType=").append(attachmentType);
        sb.append(", model=").append(model);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}