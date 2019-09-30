package cn.gson.oasys.model.po;

import java.util.Date;

public class DeptPO {
    private Long deptId;

    private String deptAddr;

    private String deptFax;

    private String deptName;

    private String deptTel;

    private String email;

    private Long deptmanager;

    private Date endTime;

    private Date startTime;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr == null ? null : deptAddr.trim();
    }

    public String getDeptFax() {
        return deptFax;
    }

    public void setDeptFax(String deptFax) {
        this.deptFax = deptFax == null ? null : deptFax.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptTel() {
        return deptTel;
    }

    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel == null ? null : deptTel.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getDeptmanager() {
        return deptmanager;
    }

    public void setDeptmanager(Long deptmanager) {
        this.deptmanager = deptmanager;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
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
        DeptPO other = (DeptPO) that;
        return (this.getDeptId() == null ? other.getDeptId() == null : this.getDeptId().equals(other.getDeptId()))
            && (this.getDeptAddr() == null ? other.getDeptAddr() == null : this.getDeptAddr().equals(other.getDeptAddr()))
            && (this.getDeptFax() == null ? other.getDeptFax() == null : this.getDeptFax().equals(other.getDeptFax()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getDeptTel() == null ? other.getDeptTel() == null : this.getDeptTel().equals(other.getDeptTel()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getDeptmanager() == null ? other.getDeptmanager() == null : this.getDeptmanager().equals(other.getDeptmanager()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDeptId() == null) ? 0 : getDeptId().hashCode());
        result = prime * result + ((getDeptAddr() == null) ? 0 : getDeptAddr().hashCode());
        result = prime * result + ((getDeptFax() == null) ? 0 : getDeptFax().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getDeptTel() == null) ? 0 : getDeptTel().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getDeptmanager() == null) ? 0 : getDeptmanager().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", deptId=").append(deptId);
        sb.append(", deptAddr=").append(deptAddr);
        sb.append(", deptFax=").append(deptFax);
        sb.append(", deptName=").append(deptName);
        sb.append(", deptTel=").append(deptTel);
        sb.append(", email=").append(email);
        sb.append(", deptmanager=").append(deptmanager);
        sb.append(", endTime=").append(endTime);
        sb.append(", startTime=").append(startTime);
        sb.append("]");
        return sb.toString();
    }
}