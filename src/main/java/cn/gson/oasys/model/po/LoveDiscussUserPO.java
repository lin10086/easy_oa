package cn.gson.oasys.model.po;

public class LoveDiscussUserPO {
    private Long discussUserId;

    private Long discussId;

    private Long userId;

    public Long getDiscussUserId() {
        return discussUserId;
    }

    public void setDiscussUserId(Long discussUserId) {
        this.discussUserId = discussUserId;
    }

    public Long getDiscussId() {
        return discussId;
    }

    public void setDiscussId(Long discussId) {
        this.discussId = discussId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        LoveDiscussUserPO other = (LoveDiscussUserPO) that;
        return (this.getDiscussUserId() == null ? other.getDiscussUserId() == null : this.getDiscussUserId().equals(other.getDiscussUserId()))
            && (this.getDiscussId() == null ? other.getDiscussId() == null : this.getDiscussId().equals(other.getDiscussId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDiscussUserId() == null) ? 0 : getDiscussUserId().hashCode());
        result = prime * result + ((getDiscussId() == null) ? 0 : getDiscussId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", discussUserId=").append(discussUserId);
        sb.append(", discussId=").append(discussId);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}