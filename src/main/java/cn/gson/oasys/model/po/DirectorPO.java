package cn.gson.oasys.model.po;

public class DirectorPO {
    private Long directorId;

    private String address;

    private String companyNumber;

    private String email;

    private Integer imagePath;

    private String phoneNumber;

    private String pinyin;

    private String remark;

    private String sex;

    private String userName;

    private Long userId;

    private String companyname;

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber == null ? null : companyNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getImagePath() {
        return imagePath;
    }

    public void setImagePath(Integer imagePath) {
        this.imagePath = imagePath;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname == null ? null : companyname.trim();
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
        DirectorPO other = (DirectorPO) that;
        return (this.getDirectorId() == null ? other.getDirectorId() == null : this.getDirectorId().equals(other.getDirectorId()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getCompanyNumber() == null ? other.getCompanyNumber() == null : this.getCompanyNumber().equals(other.getCompanyNumber()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getImagePath() == null ? other.getImagePath() == null : this.getImagePath().equals(other.getImagePath()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getPinyin() == null ? other.getPinyin() == null : this.getPinyin().equals(other.getPinyin()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCompanyname() == null ? other.getCompanyname() == null : this.getCompanyname().equals(other.getCompanyname()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDirectorId() == null) ? 0 : getDirectorId().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getCompanyNumber() == null) ? 0 : getCompanyNumber().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getImagePath() == null) ? 0 : getImagePath().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getPinyin() == null) ? 0 : getPinyin().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCompanyname() == null) ? 0 : getCompanyname().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", directorId=").append(directorId);
        sb.append(", address=").append(address);
        sb.append(", companyNumber=").append(companyNumber);
        sb.append(", email=").append(email);
        sb.append(", imagePath=").append(imagePath);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", pinyin=").append(pinyin);
        sb.append(", remark=").append(remark);
        sb.append(", sex=").append(sex);
        sb.append(", userName=").append(userName);
        sb.append(", userId=").append(userId);
        sb.append(", companyname=").append(companyname);
        sb.append("]");
        return sb.toString();
    }
}