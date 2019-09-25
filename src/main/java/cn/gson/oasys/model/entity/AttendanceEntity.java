package cn.gson.oasys.model.entity;

import cn.gson.oasys.model.entity.user.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class AttendanceEntity {
    private Integer attendsId;
    private Integer typeId; //类型id，8上班9下班
    private Integer statusId; //状态id，46请假47出差
    private Date attendsTime;   //考勤时间
    private String attendHmtime;   //考勤时分
    private String weekOfday;   //星期几
    private String attendsIp;     //登陆ip
    private String attendsRemark;  //考勤备注
    private Date holidayStart;//请假开始时间
    private Double holidayDays;//请假天数
    // private Integer attendsUserId;//考勤用户id
    private UserEntity userEntities;

    public Integer getAttendsId() {
        return attendsId;
    }

    public void setAttendsId(Integer attendsId) {
        this.attendsId = attendsId;
    }

    public UserEntity getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(UserEntity userEntities) {
        this.userEntities = userEntities;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    @Override
    public String toString() {
        return "AttendanceEntity{" +
                "attendsId=" + attendsId +
                ", typeId=" + typeId +
                ", statusId=" + statusId +
                ", attendsTime=" + attendsTime +
                ", attendHmtime='" + attendHmtime + '\'' +
                ", weekOfday='" + weekOfday + '\'' +
                ", attendsIp='" + attendsIp + '\'' +
                ", attendsRemark='" + attendsRemark + '\'' +
                ", holidayStart=" + holidayStart +
                ", holidayDays=" + holidayDays +
                ", userEntities=" + userEntities +
                '}';
    }

    public Date getAttendsTime() {
        return attendsTime;
    }

    public void setAttendsTime(Date attendsTime) {
        this.attendsTime = attendsTime;
    }

    public String getAttendHmtime() {
        return attendHmtime;
    }

    public void setAttendHmtime(String attendHmtime) {
        this.attendHmtime = attendHmtime;
    }

    public String getWeekOfday() {
        return weekOfday;
    }

    public void setWeekOfday(String weekOfday) {
        this.weekOfday = weekOfday;
    }

    public String getAttendsIp() {
        return attendsIp;
    }

    public void setAttendsIp(String attendsIp) {
        this.attendsIp = attendsIp;
    }

    public String getAttendsRemark() {
        return attendsRemark;
    }

    public void setAttendsRemark(String attendsRemark) {
        this.attendsRemark = attendsRemark;
    }

    public Date getHolidayStart() {
        return holidayStart;
    }

    public void setHolidayStart(Date holidayStart) {
        this.holidayStart = holidayStart;
    }

    public Double getHolidayDays() {
        return holidayDays;
    }

    public void setHolidayDays(Double holidayDays) {
        this.holidayDays = holidayDays;
    }

//    public Integer getAttendsUserId() {
//        return attendsUserId;
//    }
//
//    public void setAttendsUserId(Integer attendsUserId) {
//        this.attendsUserId = attendsUserId;
//    }

}
