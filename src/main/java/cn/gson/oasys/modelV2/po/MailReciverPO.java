package cn.gson.oasys.modelV2.po;

public class MailReciverPO {
    private Long pkId;

    private Integer isRead;

    private Long mailId;

    private Long mailReciverId;

    private Integer isStar;

    private Integer isDel;

    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public Long getMailId() {
        return mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    public Long getMailReciverId() {
        return mailReciverId;
    }

    public void setMailReciverId(Long mailReciverId) {
        this.mailReciverId = mailReciverId;
    }

    public Integer getIsStar() {
        return isStar;
    }

    public void setIsStar(Integer isStar) {
        this.isStar = isStar;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
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
        MailReciverPO other = (MailReciverPO) that;
        return (this.getPkId() == null ? other.getPkId() == null : this.getPkId().equals(other.getPkId()))
            && (this.getIsRead() == null ? other.getIsRead() == null : this.getIsRead().equals(other.getIsRead()))
            && (this.getMailId() == null ? other.getMailId() == null : this.getMailId().equals(other.getMailId()))
            && (this.getMailReciverId() == null ? other.getMailReciverId() == null : this.getMailReciverId().equals(other.getMailReciverId()))
            && (this.getIsStar() == null ? other.getIsStar() == null : this.getIsStar().equals(other.getIsStar()))
            && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPkId() == null) ? 0 : getPkId().hashCode());
        result = prime * result + ((getIsRead() == null) ? 0 : getIsRead().hashCode());
        result = prime * result + ((getMailId() == null) ? 0 : getMailId().hashCode());
        result = prime * result + ((getMailReciverId() == null) ? 0 : getMailReciverId().hashCode());
        result = prime * result + ((getIsStar() == null) ? 0 : getIsStar().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", isRead=").append(isRead);
        sb.append(", mailId=").append(mailId);
        sb.append(", mailReciverId=").append(mailReciverId);
        sb.append(", isStar=").append(isStar);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}