package cn.gson.oasys.modelV2.po;

import java.util.Date;

public class TaskLoggerPO {
    private Long loggerId;

    private Date createTime;

    private String loggerTicking;

    private Long taskId;

    private String username;

    private Integer loggerStatusid;

    public Long getLoggerId() {
        return loggerId;
    }

    public void setLoggerId(Long loggerId) {
        this.loggerId = loggerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLoggerTicking() {
        return loggerTicking;
    }

    public void setLoggerTicking(String loggerTicking) {
        this.loggerTicking = loggerTicking == null ? null : loggerTicking.trim();
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getLoggerStatusid() {
        return loggerStatusid;
    }

    public void setLoggerStatusid(Integer loggerStatusid) {
        this.loggerStatusid = loggerStatusid;
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
        TaskLoggerPO other = (TaskLoggerPO) that;
        return (this.getLoggerId() == null ? other.getLoggerId() == null : this.getLoggerId().equals(other.getLoggerId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLoggerTicking() == null ? other.getLoggerTicking() == null : this.getLoggerTicking().equals(other.getLoggerTicking()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getLoggerStatusid() == null ? other.getLoggerStatusid() == null : this.getLoggerStatusid().equals(other.getLoggerStatusid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLoggerId() == null) ? 0 : getLoggerId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLoggerTicking() == null) ? 0 : getLoggerTicking().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getLoggerStatusid() == null) ? 0 : getLoggerStatusid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loggerId=").append(loggerId);
        sb.append(", createTime=").append(createTime);
        sb.append(", loggerTicking=").append(loggerTicking);
        sb.append(", taskId=").append(taskId);
        sb.append(", username=").append(username);
        sb.append(", loggerStatusid=").append(loggerStatusid);
        sb.append("]");
        return sb.toString();
    }
}