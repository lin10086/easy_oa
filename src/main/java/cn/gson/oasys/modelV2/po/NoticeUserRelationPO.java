package cn.gson.oasys.modelV2.po;

public class NoticeUserRelationPO {
    private Long relationId;

    private Integer isRead;

    private Long relationNoticeId;

    private Long relationUserId;

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Long getRelationNoticeId() {
        return relationNoticeId;
    }

    public void setRelationNoticeId(Long relationNoticeId) {
        this.relationNoticeId = relationNoticeId;
    }

    public Long getRelationUserId() {
        return relationUserId;
    }

    public void setRelationUserId(Long relationUserId) {
        this.relationUserId = relationUserId;
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
        NoticeUserRelationPO other = (NoticeUserRelationPO) that;
        return (this.getRelationId() == null ? other.getRelationId() == null : this.getRelationId().equals(other.getRelationId()))
            && (this.getIsRead() == null ? other.getIsRead() == null : this.getIsRead().equals(other.getIsRead()))
            && (this.getRelationNoticeId() == null ? other.getRelationNoticeId() == null : this.getRelationNoticeId().equals(other.getRelationNoticeId()))
            && (this.getRelationUserId() == null ? other.getRelationUserId() == null : this.getRelationUserId().equals(other.getRelationUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelationId() == null) ? 0 : getRelationId().hashCode());
        result = prime * result + ((getIsRead() == null) ? 0 : getIsRead().hashCode());
        result = prime * result + ((getRelationNoticeId() == null) ? 0 : getRelationNoticeId().hashCode());
        result = prime * result + ((getRelationUserId() == null) ? 0 : getRelationUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", relationId=").append(relationId);
        sb.append(", isRead=").append(isRead);
        sb.append(", relationNoticeId=").append(relationNoticeId);
        sb.append(", relationUserId=").append(relationUserId);
        sb.append("]");
        return sb.toString();
    }
}