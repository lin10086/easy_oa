package cn.gson.oasys.modelV2.po;

import java.util.Date;

public class MailNumberPO {
    private Long mailNumberId;

    private String mailAccount;

    private Date mailCreateTime;

    private String mailDes;

    private Long mailType;

    private String mailUserName;

    private String password;

    private Long status;

    private Long mailNumUserId;

    public Long getMailNumberId() {
        return mailNumberId;
    }

    public void setMailNumberId(Long mailNumberId) {
        this.mailNumberId = mailNumberId;
    }

    public String getMailAccount() {
        return mailAccount;
    }

    public void setMailAccount(String mailAccount) {
        this.mailAccount = mailAccount == null ? null : mailAccount.trim();
    }

    public Date getMailCreateTime() {
        return mailCreateTime;
    }

    public void setMailCreateTime(Date mailCreateTime) {
        this.mailCreateTime = mailCreateTime;
    }

    public String getMailDes() {
        return mailDes;
    }

    public void setMailDes(String mailDes) {
        this.mailDes = mailDes == null ? null : mailDes.trim();
    }

    public Long getMailType() {
        return mailType;
    }

    public void setMailType(Long mailType) {
        this.mailType = mailType;
    }

    public String getMailUserName() {
        return mailUserName;
    }

    public void setMailUserName(String mailUserName) {
        this.mailUserName = mailUserName == null ? null : mailUserName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getMailNumUserId() {
        return mailNumUserId;
    }

    public void setMailNumUserId(Long mailNumUserId) {
        this.mailNumUserId = mailNumUserId;
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
        MailNumberPO other = (MailNumberPO) that;
        return (this.getMailNumberId() == null ? other.getMailNumberId() == null : this.getMailNumberId().equals(other.getMailNumberId()))
            && (this.getMailAccount() == null ? other.getMailAccount() == null : this.getMailAccount().equals(other.getMailAccount()))
            && (this.getMailCreateTime() == null ? other.getMailCreateTime() == null : this.getMailCreateTime().equals(other.getMailCreateTime()))
            && (this.getMailDes() == null ? other.getMailDes() == null : this.getMailDes().equals(other.getMailDes()))
            && (this.getMailType() == null ? other.getMailType() == null : this.getMailType().equals(other.getMailType()))
            && (this.getMailUserName() == null ? other.getMailUserName() == null : this.getMailUserName().equals(other.getMailUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMailNumUserId() == null ? other.getMailNumUserId() == null : this.getMailNumUserId().equals(other.getMailNumUserId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMailNumberId() == null) ? 0 : getMailNumberId().hashCode());
        result = prime * result + ((getMailAccount() == null) ? 0 : getMailAccount().hashCode());
        result = prime * result + ((getMailCreateTime() == null) ? 0 : getMailCreateTime().hashCode());
        result = prime * result + ((getMailDes() == null) ? 0 : getMailDes().hashCode());
        result = prime * result + ((getMailType() == null) ? 0 : getMailType().hashCode());
        result = prime * result + ((getMailUserName() == null) ? 0 : getMailUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMailNumUserId() == null) ? 0 : getMailNumUserId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mailNumberId=").append(mailNumberId);
        sb.append(", mailAccount=").append(mailAccount);
        sb.append(", mailCreateTime=").append(mailCreateTime);
        sb.append(", mailDes=").append(mailDes);
        sb.append(", mailType=").append(mailType);
        sb.append(", mailUserName=").append(mailUserName);
        sb.append(", password=").append(password);
        sb.append(", status=").append(status);
        sb.append(", mailNumUserId=").append(mailNumUserId);
        sb.append("]");
        return sb.toString();
    }
}