package cn.gson.oasys.model.po;

public class StatusPO {
    private Long statusId;

    private String statusColor;

    private String statusModel;

    private String statusName;

    private Integer sortValue;

    private String sortPrecent;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor == null ? null : statusColor.trim();
    }

    public String getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(String statusModel) {
        this.statusModel = statusModel == null ? null : statusModel.trim();
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName == null ? null : statusName.trim();
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    public String getSortPrecent() {
        return sortPrecent;
    }

    public void setSortPrecent(String sortPrecent) {
        this.sortPrecent = sortPrecent == null ? null : sortPrecent.trim();
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
        StatusPO other = (StatusPO) that;
        return (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getStatusColor() == null ? other.getStatusColor() == null : this.getStatusColor().equals(other.getStatusColor()))
            && (this.getStatusModel() == null ? other.getStatusModel() == null : this.getStatusModel().equals(other.getStatusModel()))
            && (this.getStatusName() == null ? other.getStatusName() == null : this.getStatusName().equals(other.getStatusName()))
            && (this.getSortValue() == null ? other.getSortValue() == null : this.getSortValue().equals(other.getSortValue()))
            && (this.getSortPrecent() == null ? other.getSortPrecent() == null : this.getSortPrecent().equals(other.getSortPrecent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getStatusColor() == null) ? 0 : getStatusColor().hashCode());
        result = prime * result + ((getStatusModel() == null) ? 0 : getStatusModel().hashCode());
        result = prime * result + ((getStatusName() == null) ? 0 : getStatusName().hashCode());
        result = prime * result + ((getSortValue() == null) ? 0 : getSortValue().hashCode());
        result = prime * result + ((getSortPrecent() == null) ? 0 : getSortPrecent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", statusId=").append(statusId);
        sb.append(", statusColor=").append(statusColor);
        sb.append(", statusModel=").append(statusModel);
        sb.append(", statusName=").append(statusName);
        sb.append(", sortValue=").append(sortValue);
        sb.append(", sortPrecent=").append(sortPrecent);
        sb.append("]");
        return sb.toString();
    }
}