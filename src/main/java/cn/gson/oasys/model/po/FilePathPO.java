package cn.gson.oasys.model.po;

public class FilePathPO {
    private Long pathId;

    private Long parentId;

    private String pathName;

    private Long pathUserId;

    private Long pathIstrash;

    public Long getPathId() {
        return pathId;
    }

    public void setPathId(Long pathId) {
        this.pathId = pathId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName == null ? null : pathName.trim();
    }

    public Long getPathUserId() {
        return pathUserId;
    }

    public void setPathUserId(Long pathUserId) {
        this.pathUserId = pathUserId;
    }

    public Long getPathIstrash() {
        return pathIstrash;
    }

    public void setPathIstrash(Long pathIstrash) {
        this.pathIstrash = pathIstrash;
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
        FilePathPO other = (FilePathPO) that;
        return (this.getPathId() == null ? other.getPathId() == null : this.getPathId().equals(other.getPathId()))
                && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
                && (this.getPathName() == null ? other.getPathName() == null : this.getPathName().equals(other.getPathName()))
                && (this.getPathUserId() == null ? other.getPathUserId() == null : this.getPathUserId().equals(other.getPathUserId()))
                && (this.getPathIstrash() == null ? other.getPathIstrash() == null : this.getPathIstrash().equals(other.getPathIstrash()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPathId() == null) ? 0 : getPathId().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getPathName() == null) ? 0 : getPathName().hashCode());
        result = prime * result + ((getPathUserId() == null) ? 0 : getPathUserId().hashCode());
        result = prime * result + ((getPathIstrash() == null) ? 0 : getPathIstrash().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pathId=").append(pathId);
        sb.append(", parentId=").append(parentId);
        sb.append(", pathName=").append(pathName);
        sb.append(", pathUserId=").append(pathUserId);
        sb.append(", pathIstrash=").append(pathIstrash);
        sb.append("]");
        return sb.toString();
    }
}