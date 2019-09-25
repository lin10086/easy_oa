package cn.gson.oasys.model.entity;

public class TypeEntity {
    private Integer typeId;
    private String typeColor;
    private  String typeModel;
    private  String typeName;
    private  Integer sortValue;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeColor() {
        return typeColor;
    }

    public void setTypeColor(String typeColor) {
        this.typeColor = typeColor;
    }

    public String getTypeModel() {
        return typeModel;
    }

    public void setTypeModel(String typeModel) {
        this.typeModel = typeModel;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getSortValue() {
        return sortValue;
    }

    public void setSortValue(Integer sortValue) {
        this.sortValue = sortValue;
    }

    @Override
    public String toString() {
        return "TypeEntity{" +
                "typeId=" + typeId +
                ", typeColor='" + typeColor + '\'' +
                ", typeModel='" + typeModel + '\'' +
                ", typeName='" + typeName + '\'' +
                ", sortValue=" + sortValue +
                '}';
    }
}
