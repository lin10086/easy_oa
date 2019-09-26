package cn.gson.oasys.model.po;

import java.util.Date;

public class AttendsPO {
    private Long attendsId;

    private String attendsIp;

    private String attendsRemark;

    private Date attendsTime;

    private Long statusId;

    private Long typeId;

    private Long attendsUserId;

    private String attendHmtime;

    private String weekOfday;

    private Double holidayDays;

    private Date holidayStart;

    public Long getAttendsId() {
        return attendsId;
    }

    public void setAttendsId(Long attendsId) {
        this.attendsId = attendsId;
    }

    public String getAttendsIp() {
        return attendsIp;
    }

    public void setAttendsIp(String attendsIp) {
        this.attendsIp = attendsIp == null ? null : attendsIp.trim();
    }

    public String getAttendsRemark() {
        return attendsRemark;
    }

    public void setAttendsRemark(String attendsRemark) {
        this.attendsRemark = attendsRemark == null ? null : attendsRemark.trim();
    }

    public Date getAttendsTime() {
        return attendsTime;
    }

    public void setAttendsTime(Date attendsTime) {
        this.attendsTime = attendsTime;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getAttendsUserId() {
        return attendsUserId;
    }

    public void setAttendsUserId(Long attendsUserId) {
        this.attendsUserId = attendsUserId;
    }

    public String getAttendHmtime() {
        return attendHmtime;
    }

    public void setAttendHmtime(String attendHmtime) {
        this.attendHmtime = attendHmtime == null ? null : attendHmtime.trim();
    }

    public String getWeekOfday() {
        return weekOfday;
    }

    public void setWeekOfday(String weekOfday) {
        this.weekOfday = weekOfday == null ? null : weekOfday.trim();
    }

    public Double getHolidayDays() {
        return holidayDays;
    }

    public void setHolidayDays(Double holidayDays) {
        this.holidayDays = holidayDays;
    }

    public Date getHolidayStart() {
        return holidayStart;
    }

    public void setHolidayStart(Date holidayStart) {
        this.holidayStart = holidayStart;
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
        AttendsPO other = (AttendsPO) that;
        return (this.getAttendsId() == null ? other.getAttendsId() == null : this.getAttendsId().equals(other.getAttendsId()))
            && (this.getAttendsIp() == null ? other.getAttendsIp() == null : this.getAttendsIp().equals(other.getAttendsIp()))
            && (this.getAttendsRemark() == null ? other.getAttendsRemark() == null : this.getAttendsRemark().equals(other.getAttendsRemark()))
            && (this.getAttendsTime() == null ? other.getAttendsTime() == null : this.getAttendsTime().equals(other.getAttendsTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getAttendsUserId() == null ? other.getAttendsUserId() == null : this.getAttendsUserId().equals(other.getAttendsUserId()))
            && (this.getAttendHmtime() == null ? other.getAttendHmtime() == null : this.getAttendHmtime().equals(other.getAttendHmtime()))
            && (this.getWeekOfday() == null ? other.getWeekOfday() == null : this.getWeekOfday().equals(other.getWeekOfday()))
            && (this.getHolidayDays() == null ? other.getHolidayDays() == null : this.getHolidayDays().equals(other.getHolidayDays()))
            && (this.getHolidayStart() == null ? other.getHolidayStart() == null : this.getHolidayStart().equals(other.getHolidayStart()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttendsId() == null) ? 0 : getAttendsId().hashCode());
        result = prime * result + ((getAttendsIp() == null) ? 0 : getAttendsIp().hashCode());
        result = prime * result + ((getAttendsRemark() == null) ? 0 : getAttendsRemark().hashCode());
        result = prime * result + ((getAttendsTime() == null) ? 0 : getAttendsTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getAttendsUserId() == null) ? 0 : getAttendsUserId().hashCode());
        result = prime * result + ((getAttendHmtime() == null) ? 0 : getAttendHmtime().hashCode());
        result = prime * result + ((getWeekOfday() == null) ? 0 : getWeekOfday().hashCode());
        result = prime * result + ((getHolidayDays() == null) ? 0 : getHolidayDays().hashCode());
        result = prime * result + ((getHolidayStart() == null) ? 0 : getHolidayStart().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attendsId=").append(attendsId);
        sb.append(", attendsIp=").append(attendsIp);
        sb.append(", attendsRemark=").append(attendsRemark);
        sb.append(", attendsTime=").append(attendsTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", typeId=").append(typeId);
        sb.append(", attendsUserId=").append(attendsUserId);
        sb.append(", attendHmtime=").append(attendHmtime);
        sb.append(", weekOfday=").append(weekOfday);
        sb.append(", holidayDays=").append(holidayDays);
        sb.append(", holidayStart=").append(holidayStart);
        sb.append("]");
        return sb.toString();
    }
}