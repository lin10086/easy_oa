package cn.gson.oasys.model.po;

import java.util.Date;

public class TrafficPO {
    private Long trafficId;

    private String departName;

    private Date departTime;

    private String reachName;

    private String seatType;

    private Double trafficMoney;

    private String trafficName;

    private Long evemoneyId;

    private Long userName;

    public Long getTrafficId() {
        return trafficId;
    }

    public void setTrafficId(Long trafficId) {
        this.trafficId = trafficId;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName == null ? null : departName.trim();
    }

    public Date getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Date departTime) {
        this.departTime = departTime;
    }

    public String getReachName() {
        return reachName;
    }

    public void setReachName(String reachName) {
        this.reachName = reachName == null ? null : reachName.trim();
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType == null ? null : seatType.trim();
    }

    public Double getTrafficMoney() {
        return trafficMoney;
    }

    public void setTrafficMoney(Double trafficMoney) {
        this.trafficMoney = trafficMoney;
    }

    public String getTrafficName() {
        return trafficName;
    }

    public void setTrafficName(String trafficName) {
        this.trafficName = trafficName == null ? null : trafficName.trim();
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
        TrafficPO other = (TrafficPO) that;
        return (this.getTrafficId() == null ? other.getTrafficId() == null : this.getTrafficId().equals(other.getTrafficId()))
            && (this.getDepartName() == null ? other.getDepartName() == null : this.getDepartName().equals(other.getDepartName()))
            && (this.getDepartTime() == null ? other.getDepartTime() == null : this.getDepartTime().equals(other.getDepartTime()))
            && (this.getReachName() == null ? other.getReachName() == null : this.getReachName().equals(other.getReachName()))
            && (this.getSeatType() == null ? other.getSeatType() == null : this.getSeatType().equals(other.getSeatType()))
            && (this.getTrafficMoney() == null ? other.getTrafficMoney() == null : this.getTrafficMoney().equals(other.getTrafficMoney()))
            && (this.getTrafficName() == null ? other.getTrafficName() == null : this.getTrafficName().equals(other.getTrafficName()))
            && (this.getEvemoneyId() == null ? other.getEvemoneyId() == null : this.getEvemoneyId().equals(other.getEvemoneyId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTrafficId() == null) ? 0 : getTrafficId().hashCode());
        result = prime * result + ((getDepartName() == null) ? 0 : getDepartName().hashCode());
        result = prime * result + ((getDepartTime() == null) ? 0 : getDepartTime().hashCode());
        result = prime * result + ((getReachName() == null) ? 0 : getReachName().hashCode());
        result = prime * result + ((getSeatType() == null) ? 0 : getSeatType().hashCode());
        result = prime * result + ((getTrafficMoney() == null) ? 0 : getTrafficMoney().hashCode());
        result = prime * result + ((getTrafficName() == null) ? 0 : getTrafficName().hashCode());
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
        sb.append(", trafficId=").append(trafficId);
        sb.append(", departName=").append(departName);
        sb.append(", departTime=").append(departTime);
        sb.append(", reachName=").append(reachName);
        sb.append(", seatType=").append(seatType);
        sb.append(", trafficMoney=").append(trafficMoney);
        sb.append(", trafficName=").append(trafficName);
        sb.append(", evemoneyId=").append(evemoneyId);
        sb.append(", userName=").append(userName);
        sb.append("]");
        return sb.toString();
    }
}