package cn.gson.oasys.modelV2.po;

public class HolidayPO {
    private Long holidayId;

    private Integer leaveDays;

    private Long typeId;

    private Long proId;

    private String managerAdvice;

    private String personnelAdvice;

    public Long getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(Long holidayId) {
        this.holidayId = holidayId;
    }

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getManagerAdvice() {
        return managerAdvice;
    }

    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
    }

    public String getPersonnelAdvice() {
        return personnelAdvice;
    }

    public void setPersonnelAdvice(String personnelAdvice) {
        this.personnelAdvice = personnelAdvice == null ? null : personnelAdvice.trim();
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
        HolidayPO other = (HolidayPO) that;
        return (this.getHolidayId() == null ? other.getHolidayId() == null : this.getHolidayId().equals(other.getHolidayId()))
            && (this.getLeaveDays() == null ? other.getLeaveDays() == null : this.getLeaveDays().equals(other.getLeaveDays()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
            && (this.getManagerAdvice() == null ? other.getManagerAdvice() == null : this.getManagerAdvice().equals(other.getManagerAdvice()))
            && (this.getPersonnelAdvice() == null ? other.getPersonnelAdvice() == null : this.getPersonnelAdvice().equals(other.getPersonnelAdvice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHolidayId() == null) ? 0 : getHolidayId().hashCode());
        result = prime * result + ((getLeaveDays() == null) ? 0 : getLeaveDays().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getManagerAdvice() == null) ? 0 : getManagerAdvice().hashCode());
        result = prime * result + ((getPersonnelAdvice() == null) ? 0 : getPersonnelAdvice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", holidayId=").append(holidayId);
        sb.append(", leaveDays=").append(leaveDays);
        sb.append(", typeId=").append(typeId);
        sb.append(", proId=").append(proId);
        sb.append(", managerAdvice=").append(managerAdvice);
        sb.append(", personnelAdvice=").append(personnelAdvice);
        sb.append("]");
        return sb.toString();
    }
}