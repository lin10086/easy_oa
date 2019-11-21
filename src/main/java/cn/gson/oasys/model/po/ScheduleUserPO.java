package cn.gson.oasys.model.po;

public class ScheduleUserPO {
    private Long scheUserId;

    private Long rcId;

    private Long userId;

    public Long getScheUserId() {
        return scheUserId;
    }

    public void setScheUserId(Long scheUserId) {
        this.scheUserId = scheUserId;
    }

    public Long getRcId() {
        return rcId;
    }

    public void setRcId(Long rcId) {
        this.rcId = rcId;
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
        ScheduleUserPO other = (ScheduleUserPO) that;
        return (this.getScheUserId() == null ? other.getScheUserId() == null : this.getScheUserId().equals(other.getScheUserId()))
            && (this.getRcId() == null ? other.getRcId() == null : this.getRcId().equals(other.getRcId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getScheUserId() == null) ? 0 : getScheUserId().hashCode());
        result = prime * result + ((getRcId() == null) ? 0 : getRcId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", scheUserId=").append(scheUserId);
        sb.append(", rcId=").append(rcId);
        sb.append(", userId=").append(userId);
        sb.append("]");
        return sb.toString();
    }
}