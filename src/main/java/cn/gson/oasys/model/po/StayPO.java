package cn.gson.oasys.model.po;

import java.util.Date;

public class StayPO {
    private Long stayId;

    private Integer day;

    private String hotelName;

    private Date leaveTime;

    private String stayCity;

    private Double stayMoney;

    private Date stayTime;

    private Long evemoneyId;

    private Long userName;

    public Long getStayId() {
        return stayId;
    }

    public void setStayId(Long stayId) {
        this.stayId = stayId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getStayCity() {
        return stayCity;
    }

    public void setStayCity(String stayCity) {
        this.stayCity = stayCity == null ? null : stayCity.trim();
    }

    public Double getStayMoney() {
        return stayMoney;
    }

    public void setStayMoney(Double stayMoney) {
        this.stayMoney = stayMoney;
    }

    public Date getStayTime() {
        return stayTime;
    }

    public void setStayTime(Date stayTime) {
        this.stayTime = stayTime;
    }

    public Long getEvemoneyId() {
        return evemoneyId;
    }

    public void setEvemoneyId(Long evemoneyId) {
        this.evemoneyId = evemoneyId;
    }

    public Long getUserName() {
        return userName;
    }

    public void setUserName(Long userName) {
        this.userName = userName;
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
        StayPO other = (StayPO) that;
        return (this.getStayId() == null ? other.getStayId() == null : this.getStayId().equals(other.getStayId()))
            && (this.getDay() == null ? other.getDay() == null : this.getDay().equals(other.getDay()))
            && (this.getHotelName() == null ? other.getHotelName() == null : this.getHotelName().equals(other.getHotelName()))
            && (this.getLeaveTime() == null ? other.getLeaveTime() == null : this.getLeaveTime().equals(other.getLeaveTime()))
            && (this.getStayCity() == null ? other.getStayCity() == null : this.getStayCity().equals(other.getStayCity()))
            && (this.getStayMoney() == null ? other.getStayMoney() == null : this.getStayMoney().equals(other.getStayMoney()))
            && (this.getStayTime() == null ? other.getStayTime() == null : this.getStayTime().equals(other.getStayTime()))
            && (this.getEvemoneyId() == null ? other.getEvemoneyId() == null : this.getEvemoneyId().equals(other.getEvemoneyId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStayId() == null) ? 0 : getStayId().hashCode());
        result = prime * result + ((getDay() == null) ? 0 : getDay().hashCode());
        result = prime * result + ((getHotelName() == null) ? 0 : getHotelName().hashCode());
        result = prime * result + ((getLeaveTime() == null) ? 0 : getLeaveTime().hashCode());
        result = prime * result + ((getStayCity() == null) ? 0 : getStayCity().hashCode());
        result = prime * result + ((getStayMoney() == null) ? 0 : getStayMoney().hashCode());
        result = prime * result + ((getStayTime() == null) ? 0 : getStayTime().hashCode());
        result = prime * result + ((getEvemoneyId() == null) ? 0 : getEvemoneyId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", stayId=").append(stayId);
        sb.append(", day=").append(day);
        sb.append(", hotelName=").append(hotelName);
        sb.append(", leaveTime=").append(leaveTime);
        sb.append(", stayCity=").append(stayCity);
        sb.append(", stayMoney=").append(stayMoney);
        sb.append(", stayTime=").append(stayTime);
        sb.append(", evemoneyId=").append(evemoneyId);
        sb.append(", userName=").append(userName);
        sb.append("]");
        return sb.toString();
    }
}