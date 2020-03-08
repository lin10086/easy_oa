package cn.gson.oasys.modelV2.po;

import java.util.Date;

public class DiscussListPO {
    private Long discussId;

    private Integer attachmentId;

    private Date createTime;

    private Long statusId;

    private String title;

    private Long typeId;

    private Integer visitNum;

    private Long discussUserId;

    private Long voteId;

    private Date modifyTime;

    private String content;

    public Long getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Long discussId) {
        this.discussId = discussId;
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public Integer getVisitNum() {
        return visitNum;
    }

    public void setVisitNum(Integer visitNum) {
        this.visitNum = visitNum;
    }

    public Long getDiscussUserId() {
        return discussUserId;
    }

    public void setDiscussUserId(Long discussUserId) {
        this.discussUserId = discussUserId;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
        DiscussListPO other = (DiscussListPO) that;
        return (this.getDiscussId() == null ? other.getDiscussId() == null : this.getDiscussId().equals(other.getDiscussId()))
            && (this.getAttachmentId() == null ? other.getAttachmentId() == null : this.getAttachmentId().equals(other.getAttachmentId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getVisitNum() == null ? other.getVisitNum() == null : this.getVisitNum().equals(other.getVisitNum()))
            && (this.getDiscussUserId() == null ? other.getDiscussUserId() == null : this.getDiscussUserId().equals(other.getDiscussUserId()))
            && (this.getVoteId() == null ? other.getVoteId() == null : this.getVoteId().equals(other.getVoteId()))
            && (this.getModifyTime() == null ? other.getModifyTime() == null : this.getModifyTime().equals(other.getModifyTime()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscussId() == null) ? 0 : getDiscussId().hashCode());
        result = prime * result + ((getAttachmentId() == null) ? 0 : getAttachmentId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getVisitNum() == null) ? 0 : getVisitNum().hashCode());
        result = prime * result + ((getDiscussUserId() == null) ? 0 : getDiscussUserId().hashCode());
        result = prime * result + ((getVoteId() == null) ? 0 : getVoteId().hashCode());
        result = prime * result + ((getModifyTime() == null) ? 0 : getModifyTime().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", discussId=").append(discussId);
        sb.append(", attachmentId=").append(attachmentId);
        sb.append(", createTime=").append(createTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", title=").append(title);
        sb.append(", typeId=").append(typeId);
        sb.append(", visitNum=").append(visitNum);
        sb.append(", discussUserId=").append(discussUserId);
        sb.append(", voteId=").append(voteId);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", content=").append(content);
        sb.append("]");
        return sb.toString();
    }
}