package cn.gson.oasys.modelV2.po;

import java.util.Date;

public class DirectorUsersPO {
    private Long directorUsersId;

    private String catelogName;

    private Integer isHandle;

    private Long directorId;

    private Long userId;

    private Long shareUserId;

    private Date sharetime;

    public Long getDirectorUsersId() {
        return directorUsersId;
    }

    public void setDirectorUsersId(Long directorUsersId) {
        this.directorUsersId = directorUsersId;
    }

    public String getCatelogName() {
        return catelogName;
    }

    public void setCatelogName(String catelogName) {
        this.catelogName = catelogName == null ? null : catelogName.trim();
    }

    public Integer getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(Integer isHandle) {
        this.isHandle = isHandle;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShareUserId() {
        return shareUserId;
    }

    public void setShareUserId(Long shareUserId) {
        this.shareUserId = shareUserId;
    }

    public Date getSharetime() {
        return sharetime;
    }

    public void setSharetime(Date sharetime) {
        this.sharetime = sharetime;
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
        DirectorUsersPO other = (DirectorUsersPO) that;
        return (this.getDirectorUsersId() == null ? other.getDirectorUsersId() == null : this.getDirectorUsersId().equals(other.getDirectorUsersId()))
            && (this.getCatelogName() == null ? other.getCatelogName() == null : this.getCatelogName().equals(other.getCatelogName()))
            && (this.getIsHandle() == null ? other.getIsHandle() == null : this.getIsHandle().equals(other.getIsHandle()))
            && (this.getDirectorId() == null ? other.getDirectorId() == null : this.getDirectorId().equals(other.getDirectorId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getShareUserId() == null ? other.getShareUserId() == null : this.getShareUserId().equals(other.getShareUserId()))
            && (this.getSharetime() == null ? other.getSharetime() == null : this.getSharetime().equals(other.getSharetime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDirectorUsersId() == null) ? 0 : getDirectorUsersId().hashCode());
        result = prime * result + ((getCatelogName() == null) ? 0 : getCatelogName().hashCode());
        result = prime * result + ((getIsHandle() == null) ? 0 : getIsHandle().hashCode());
        result = prime * result + ((getDirectorId() == null) ? 0 : getDirectorId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getShareUserId() == null) ? 0 : getShareUserId().hashCode());
        result = prime * result + ((getSharetime() == null) ? 0 : getSharetime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", directorUsersId=").append(directorUsersId);
        sb.append(", catelogName=").append(catelogName);
        sb.append(", isHandle=").append(isHandle);
        sb.append(", directorId=").append(directorId);
        sb.append(", userId=").append(userId);
        sb.append(", shareUserId=").append(shareUserId);
        sb.append(", sharetime=").append(sharetime);
        sb.append("]");
        return sb.toString();
    }
}