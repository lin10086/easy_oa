package cn.gson.oasys.modelV2.po;

public class OvertimePO {
    private Long overtimeId;

    private Long typeId;

    private Long proId;

    private String personnelAdvice;

    private String managerAdvice;

    public Long getOvertimeId() {
        return overtimeId;
    }

    public void setOvertimeId(Long overtimeId) {
        this.overtimeId = overtimeId;
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

    public String getPersonnelAdvice() {
        return personnelAdvice;
    }

    public void setPersonnelAdvice(String personnelAdvice) {
        this.personnelAdvice = personnelAdvice == null ? null : personnelAdvice.trim();
    }

    public String getManagerAdvice() {
        return managerAdvice;
    }

    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
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
        OvertimePO other = (OvertimePO) that;
        return (this.getOvertimeId() == null ? other.getOvertimeId() == null : this.getOvertimeId().equals(other.getOvertimeId()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
            && (this.getPersonnelAdvice() == null ? other.getPersonnelAdvice() == null : this.getPersonnelAdvice().equals(other.getPersonnelAdvice()))
            && (this.getManagerAdvice() == null ? other.getManagerAdvice() == null : this.getManagerAdvice().equals(other.getManagerAdvice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOvertimeId() == null) ? 0 : getOvertimeId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getPersonnelAdvice() == null) ? 0 : getPersonnelAdvice().hashCode());
        result = prime * result + ((getManagerAdvice() == null) ? 0 : getManagerAdvice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", overtimeId=").append(overtimeId);
        sb.append(", typeId=").append(typeId);
        sb.append(", proId=").append(proId);
        sb.append(", personnelAdvice=").append(personnelAdvice);
        sb.append(", managerAdvice=").append(managerAdvice);
        sb.append("]");
        return sb.toString();
    }
}