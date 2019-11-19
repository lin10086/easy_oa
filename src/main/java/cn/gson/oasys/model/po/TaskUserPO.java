package cn.gson.oasys.model.po;

public class TaskUserPO {
    private Long pkId;

    private Long statusId;

    private Long taskId;

    private Long taskReciveUserId;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTaskReciveUserId() {
        return taskReciveUserId;
    }

    public void setTaskReciveUserId(Long taskReciveUserId) {
        this.taskReciveUserId = taskReciveUserId;
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
        TaskUserPO other = (TaskUserPO) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getTaskReciveUserId() == null ? other.getTaskReciveUserId() == null : this.getTaskReciveUserId().equals(other.getTaskReciveUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getTaskReciveUserId() == null) ? 0 : getTaskReciveUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", statusId=").append(statusId);
        sb.append(", taskId=").append(taskId);
        sb.append(", taskReciveUserId=").append(taskReciveUserId);
        sb.append("]");
        return sb.toString();
    }
}