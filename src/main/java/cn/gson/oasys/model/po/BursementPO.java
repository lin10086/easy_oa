package cn.gson.oasys.model.po;

import java.util.Date;

public class BursementPO {
    private Long bursementId;

    private Double allMoney;

    private Integer allinvoices;

    private Date burseTime;

    private String financialAdvice;

    private String managerAdvice;

    private String name;

    private Long typeId;

    private Long operationName;

    private Long proId;

    private Long userName;

    public Long getBursementId() {
        return bursementId;
    }

    public void setBursementId(Long bursementId) {
        this.bursementId = bursementId;
    }

    public Double getAllMoney() {
        return allMoney;
    }

    public void setAllMoney(Double allMoney) {
        this.allMoney = allMoney;
    }

    public Integer getAllinvoices() {
        return allinvoices;
    }

    public void setAllinvoices(Integer allinvoices) {
        this.allinvoices = allinvoices;
    }

    public Date getBurseTime() {
        return burseTime;
    }

    public void setBurseTime(Date burseTime) {
        this.burseTime = burseTime;
    }

    public String getFinancialAdvice() {
        return financialAdvice;
    }

    public void setFinancialAdvice(String financialAdvice) {
        this.financialAdvice = financialAdvice == null ? null : financialAdvice.trim();
    }

    public String getManagerAdvice() {
        return managerAdvice;
    }

    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getOperationName() {
        return operationName;
    }

    public void setOperationName(Long operationName) {
        this.operationName = operationName;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
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
        BursementPO other = (BursementPO) that;
        return (this.getBursementId() == null ? other.getBursementId() == null : this.getBursementId().equals(other.getBursementId()))
            && (this.getAllMoney() == null ? other.getAllMoney() == null : this.getAllMoney().equals(other.getAllMoney()))
            && (this.getAllinvoices() == null ? other.getAllinvoices() == null : this.getAllinvoices().equals(other.getAllinvoices()))
            && (this.getBurseTime() == null ? other.getBurseTime() == null : this.getBurseTime().equals(other.getBurseTime()))
            && (this.getFinancialAdvice() == null ? other.getFinancialAdvice() == null : this.getFinancialAdvice().equals(other.getFinancialAdvice()))
            && (this.getManagerAdvice() == null ? other.getManagerAdvice() == null : this.getManagerAdvice().equals(other.getManagerAdvice()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getOperationName() == null ? other.getOperationName() == null : this.getOperationName().equals(other.getOperationName()))
            && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBursementId() == null) ? 0 : getBursementId().hashCode());
        result = prime * result + ((getAllMoney() == null) ? 0 : getAllMoney().hashCode());
        result = prime * result + ((getAllinvoices() == null) ? 0 : getAllinvoices().hashCode());
        result = prime * result + ((getBurseTime() == null) ? 0 : getBurseTime().hashCode());
        result = prime * result + ((getFinancialAdvice() == null) ? 0 : getFinancialAdvice().hashCode());
        result = prime * result + ((getManagerAdvice() == null) ? 0 : getManagerAdvice().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getOperationName() == null) ? 0 : getOperationName().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", bursementId=").append(bursementId);
        sb.append(", allMoney=").append(allMoney);
        sb.append(", allinvoices=").append(allinvoices);
        sb.append(", burseTime=").append(burseTime);
        sb.append(", financialAdvice=").append(financialAdvice);
        sb.append(", managerAdvice=").append(managerAdvice);
        sb.append(", name=").append(name);
        sb.append(", typeId=").append(typeId);
        sb.append(", operationName=").append(operationName);
        sb.append(", proId=").append(proId);
        sb.append(", userName=").append(userName);
        sb.append("]");
        return sb.toString();
    }
}