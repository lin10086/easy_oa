package cn.gson.oasys.model.po;

import java.util.Date;

public class ProcessListPO {
    private Long processId;

    private Date applyTime;

    private Long deeplyId;

    private Date endTime;

    private String processName;

    private Integer procseeDays;

    private Integer isChecked;

    private Date startTime;

    private Long statusId;

    private String typeName;

    private Long proFileId;

    private Long processUserId;

    private String shenuser;

    private String processDes;

    public Long getProcessId() {
        return processId;
    }

    public void setProcessId(Long processId) {
        this.processId = processId;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Long getDeeplyId() {
        return deeplyId;
    }

    public void setDeeplyId(Long deeplyId) {
        this.deeplyId = deeplyId;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    public Integer getProcseeDays() {
        return procseeDays;
    }

    public void setProcseeDays(Integer procseeDays) {
        this.procseeDays = procseeDays;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(Integer isChecked) {
        this.isChecked = isChecked;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Long getProFileId() {
        return proFileId;
    }

    public void setProFileId(Long proFileId) {
        this.proFileId = proFileId;
    }

    public Long getProcessUserId() {
        return processUserId;
    }

    public void setProcessUserId(Long processUserId) {
        this.processUserId = processUserId;
    }

    public String getShenuser() {
        return shenuser;
    }

    public void setShenuser(String shenuser) {
        this.shenuser = shenuser == null ? null : shenuser.trim();
    }

    public String getProcessDes() {
        return processDes;
    }

    public void setProcessDes(String processDes) {
        this.processDes = processDes == null ? null : processDes.trim();
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
        ProcessListPO other = (ProcessListPO) that;
        return (this.getProcessId() == null ? other.getProcessId() == null : this.getProcessId().equals(other.getProcessId()))
            && (this.getApplyTime() == null ? other.getApplyTime() == null : this.getApplyTime().equals(other.getApplyTime()))
            && (this.getDeeplyId() == null ? other.getDeeplyId() == null : this.getDeeplyId().equals(other.getDeeplyId()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getProcessName() == null ? other.getProcessName() == null : this.getProcessName().equals(other.getProcessName()))
            && (this.getProcseeDays() == null ? other.getProcseeDays() == null : this.getProcseeDays().equals(other.getProcseeDays()))
            && (this.getIsChecked() == null ? other.getIsChecked() == null : this.getIsChecked().equals(other.getIsChecked()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getProFileId() == null ? other.getProFileId() == null : this.getProFileId().equals(other.getProFileId()))
            && (this.getProcessUserId() == null ? other.getProcessUserId() == null : this.getProcessUserId().equals(other.getProcessUserId()))
            && (this.getShenuser() == null ? other.getShenuser() == null : this.getShenuser().equals(other.getShenuser()))
            && (this.getProcessDes() == null ? other.getProcessDes() == null : this.getProcessDes().equals(other.getProcessDes()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getProcessId() == null) ? 0 : getProcessId().hashCode());
        result = prime * result + ((getApplyTime() == null) ? 0 : getApplyTime().hashCode());
        result = prime * result + ((getDeeplyId() == null) ? 0 : getDeeplyId().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getProcessName() == null) ? 0 : getProcessName().hashCode());
        result = prime * result + ((getProcseeDays() == null) ? 0 : getProcseeDays().hashCode());
        result = prime * result + ((getIsChecked() == null) ? 0 : getIsChecked().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getProFileId() == null) ? 0 : getProFileId().hashCode());
        result = prime * result + ((getProcessUserId() == null) ? 0 : getProcessUserId().hashCode());
        result = prime * result + ((getShenuser() == null) ? 0 : getShenuser().hashCode());
        result = prime * result + ((getProcessDes() == null) ? 0 : getProcessDes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", processId=").append(processId);
        sb.append(", applyTime=").append(applyTime);
        sb.append(", deeplyId=").append(deeplyId);
        sb.append(", endTime=").append(endTime);
        sb.append(", processName=").append(processName);
        sb.append(", procseeDays=").append(procseeDays);
        sb.append(", isChecked=").append(isChecked);
        sb.append(", startTime=").append(startTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", typeName=").append(typeName);
        sb.append(", proFileId=").append(proFileId);
        sb.append(", processUserId=").append(processUserId);
        sb.append(", shenuser=").append(shenuser);
        sb.append(", processDes=").append(processDes);
        sb.append("]");
        return sb.toString();
    }
}