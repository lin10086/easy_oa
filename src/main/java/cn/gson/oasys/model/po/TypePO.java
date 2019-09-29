package cn.gson.oasys.model.po;

public class TypePO {
    private Long typeId;

    private String typeColor;

    private String typeModel;

    private String typeName;

    private Integer sortValue;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeColor() {
        return typeColor;
    }

    public void setTypeColor(String typeColor) {
        this.typeColor = typeColor == null ? null : typeColor.trim();
    }

    public String getTypeModel() {
        return typeModel;
    }

    public void setTypeModel(String typeModel) {
        this.typeModel = typeModel == null ? null : typeModel.trim();
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
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
        TypePO other = (TypePO) that;
        return (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getTypeColor() == null ? other.getTypeColor() == null : this.getTypeColor().equals(other.getTypeColor()))
            && (this.getTypeModel() == null ? other.getTypeModel() == null : this.getTypeModel().equals(other.getTypeModel()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getSortValue() == null ? other.getSortValue() == null : this.getSortValue().equals(other.getSortValue()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getTypeColor() == null) ? 0 : getTypeColor().hashCode());
        result = prime * result + ((getTypeModel() == null) ? 0 : getTypeModel().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getSortValue() == null) ? 0 : getSortValue().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", typeId=").append(typeId);
        sb.append(", typeColor=").append(typeColor);
        sb.append(", typeModel=").append(typeModel);
        sb.append(", typeName=").append(typeName);
        sb.append(", sortValue=").append(sortValue);
        sb.append("]");
        return sb.toString();
    }
}