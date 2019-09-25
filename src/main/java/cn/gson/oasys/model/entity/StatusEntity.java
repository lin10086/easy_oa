package cn.gson.oasys.model.entity;

public class StatusEntity {
    private Integer statusId;
    private String statusColor;
    private String statusModel;
    private String statusName;
    private Integer sortValue;
    private String sortPrecent;

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusColor() {
        return statusColor;
    }

    public void setStatusColor(String statusColor) {
        this.statusColor = statusColor;
    }

    public String getStatusModel() {
        return statusModel;
    }

    public void setStatusModel(String statusModel) {
        this.statusModel = statusModel;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
        this.sortPrecent = sortPrecent;
    }

    @Override
    public String toString() {
        return "StatusEntity{" +
                "statusId=" + statusId +
                ", statusColor='" + statusColor + '\'' +
                ", statusModel='" + statusModel + '\'' +
                ", statusName='" + statusName + '\'' +
                ", sortValue=" + sortValue +
                ", sortPrecent='" + sortPrecent + '\'' +
                '}';
    }
}

