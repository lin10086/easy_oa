package cn.gson.oasys.model.po;

import java.util.Date;

public class InMailListPO {
    private Long mailId;

    private Date mailCreateTime;

    private Long mailFileId;

    private String mailTitle;

    private Long mailType;

    private Long mailInPushUserId;

    private String inReceiver;

    private Long mailStatusId;

    private Long mailNumberId;

    private Integer mailDel;

    private Integer mailPush;

    private Integer mailStar;

    private String mailContent;

    public Long getMailId() {
        return mailId;
    }

    public void setMailId(Long mailId) {
        this.mailId = mailId;
    }

    public Date getMailCreateTime() {
        return mailCreateTime;
    }

    public void setMailCreateTime(Date mailCreateTime) {
        this.mailCreateTime = mailCreateTime;
    }

    public Long getMailFileId() {
        return mailFileId;
    }

    public void setMailFileId(Long mailFileId) {
        this.mailFileId = mailFileId;
    }

    public String getMailTitle() {
        return mailTitle;
    }

    public void setMailTitle(String mailTitle) {
        this.mailTitle = mailTitle == null ? null : mailTitle.trim();
    }

    public Long getMailType() {
        return mailType;
    }

    public void setMailType(Long mailType) {
        this.mailType = mailType;
    }

    public Long getMailInPushUserId() {
        return mailInPushUserId;
    }

    public void setMailInPushUserId(Long mailInPushUserId) {
        this.mailInPushUserId = mailInPushUserId;
    }

    public String getInReceiver() {
        return inReceiver;
    }

    public void setInReceiver(String inReceiver) {
        this.inReceiver = inReceiver == null ? null : inReceiver.trim();
    }

    public Long getMailStatusId() {
        return mailStatusId;
    }

    public void setMailStatusId(Long mailStatusId) {
        this.mailStatusId = mailStatusId;
    }

    public Long getMailNumberId() {
        return mailNumberId;
    }

    public void setMailNumberId(Long mailNumberId) {
        this.mailNumberId = mailNumberId;
    }

    public Integer getMailDel() {
        return mailDel;
    }

    public void setMailDel(Integer mailDel) {
        this.mailDel = mailDel;
    }

    public Integer getMailPush() {
        return mailPush;
    }

    public void setMailPush(Integer mailPush) {
        this.mailPush = mailPush;
    }

    public Integer getMailStar() {
        return mailStar;
    }

    public void setMailStar(Integer mailStar) {
        this.mailStar = mailStar;
    }

    public String getMailContent() {
        return mailContent;
    }

    public void setMailContent(String mailContent) {
        this.mailContent = mailContent == null ? null : mailContent.trim();
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
        InMailListPO other = (InMailListPO) that;
        return (this.getMailId() == null ? other.getMailId() == null : this.getMailId().equals(other.getMailId()))
            && (this.getMailCreateTime() == null ? other.getMailCreateTime() == null : this.getMailCreateTime().equals(other.getMailCreateTime()))
            && (this.getMailFileId() == null ? other.getMailFileId() == null : this.getMailFileId().equals(other.getMailFileId()))
            && (this.getMailTitle() == null ? other.getMailTitle() == null : this.getMailTitle().equals(other.getMailTitle()))
            && (this.getMailType() == null ? other.getMailType() == null : this.getMailType().equals(other.getMailType()))
            && (this.getMailInPushUserId() == null ? other.getMailInPushUserId() == null : this.getMailInPushUserId().equals(other.getMailInPushUserId()))
            && (this.getInReceiver() == null ? other.getInReceiver() == null : this.getInReceiver().equals(other.getInReceiver()))
            && (this.getMailStatusId() == null ? other.getMailStatusId() == null : this.getMailStatusId().equals(other.getMailStatusId()))
            && (this.getMailNumberId() == null ? other.getMailNumberId() == null : this.getMailNumberId().equals(other.getMailNumberId()))
            && (this.getMailDel() == null ? other.getMailDel() == null : this.getMailDel().equals(other.getMailDel()))
            && (this.getMailPush() == null ? other.getMailPush() == null : this.getMailPush().equals(other.getMailPush()))
            && (this.getMailStar() == null ? other.getMailStar() == null : this.getMailStar().equals(other.getMailStar()))
            && (this.getMailContent() == null ? other.getMailContent() == null : this.getMailContent().equals(other.getMailContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMailId() == null) ? 0 : getMailId().hashCode());
        result = prime * result + ((getMailCreateTime() == null) ? 0 : getMailCreateTime().hashCode());
        result = prime * result + ((getMailFileId() == null) ? 0 : getMailFileId().hashCode());
        result = prime * result + ((getMailTitle() == null) ? 0 : getMailTitle().hashCode());
        result = prime * result + ((getMailType() == null) ? 0 : getMailType().hashCode());
        result = prime * result + ((getMailInPushUserId() == null) ? 0 : getMailInPushUserId().hashCode());
        result = prime * result + ((getInReceiver() == null) ? 0 : getInReceiver().hashCode());
        result = prime * result + ((getMailStatusId() == null) ? 0 : getMailStatusId().hashCode());
        result = prime * result + ((getMailNumberId() == null) ? 0 : getMailNumberId().hashCode());
        result = prime * result + ((getMailDel() == null) ? 0 : getMailDel().hashCode());
        result = prime * result + ((getMailPush() == null) ? 0 : getMailPush().hashCode());
        result = prime * result + ((getMailStar() == null) ? 0 : getMailStar().hashCode());
        result = prime * result + ((getMailContent() == null) ? 0 : getMailContent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mailId=").append(mailId);
        sb.append(", mailCreateTime=").append(mailCreateTime);
        sb.append(", mailFileId=").append(mailFileId);
        sb.append(", mailTitle=").append(mailTitle);
        sb.append(", mailType=").append(mailType);
        sb.append(", mailInPushUserId=").append(mailInPushUserId);
        sb.append(", inReceiver=").append(inReceiver);
        sb.append(", mailStatusId=").append(mailStatusId);
        sb.append(", mailNumberId=").append(mailNumberId);
        sb.append(", mailDel=").append(mailDel);
        sb.append(", mailPush=").append(mailPush);
        sb.append(", mailStar=").append(mailStar);
        sb.append(", mailContent=").append(mailContent);
        sb.append("]");
        return sb.toString();
    }
}