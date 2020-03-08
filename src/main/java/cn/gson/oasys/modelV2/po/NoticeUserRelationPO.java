package cn.gson.oasys.modelV2.po;

public class NoticeUserRelationPO {
    private Long relatinId;

    private Integer isRead;

    private Long relatinNoticeId;

    private Long relatinUserId;

    public Long getRelatinId() {
        return relatinId;
    }

    public void setRelatinId(Long relatinId) {
        this.relatinId = relatinId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Long getRelatinNoticeId() {
        return relatinNoticeId;
    }

    public void setRelatinNoticeId(Long relatinNoticeId) {
        this.relatinNoticeId = relatinNoticeId;
    }

    public Long getRelatinUserId() {
        return relatinUserId;
    }

    public void setRelatinUserId(Long relatinUserId) {
        this.relatinUserId = relatinUserId;
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
        return (this.getRelatinId() == null ? other.getRelatinId() == null : this.getRelatinId().equals(other.getRelatinId()))
            && (this.getIsRead() == null ? other.getIsRead() == null : this.getIsRead().equals(other.getIsRead()))
            && (this.getRelatinNoticeId() == null ? other.getRelatinNoticeId() == null : this.getRelatinNoticeId().equals(other.getRelatinNoticeId()))
            && (this.getRelatinUserId() == null ? other.getRelatinUserId() == null : this.getRelatinUserId().equals(other.getRelatinUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRelatinId() == null) ? 0 : getRelatinId().hashCode());
        result = prime * result + ((getIsRead() == null) ? 0 : getIsRead().hashCode());
        result = prime * result + ((getRelatinNoticeId() == null) ? 0 : getRelatinNoticeId().hashCode());
        result = prime * result + ((getRelatinUserId() == null) ? 0 : getRelatinUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", relatinId=").append(relatinId);
        sb.append(", isRead=").append(isRead);
        sb.append(", relatinNoticeId=").append(relatinNoticeId);
        sb.append(", relatinUserId=").append(relatinUserId);
        sb.append("]");
        return sb.toString();
    }
}