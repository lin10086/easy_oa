package cn.gson.oasys.model.po;

import java.util.Date;

public class DetailsbursePO {
    private Long detailsburseId;

    private String descript;

    private Double detailmoney;

    private Integer invoices;

    private Date produceTime;

    private String subject;

    private Long bursmentId;

    public Long getDetailsburseId() {
        return detailsburseId;
    }

    public void setDetailsburseId(Long detailsburseId) {
        this.detailsburseId = detailsburseId;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }

    public Double getDetailmoney() {
        return detailmoney;
    }

    public void setDetailmoney(Double detailmoney) {
        this.detailmoney = detailmoney;
    }

    public Integer getInvoices() {
        return invoices;
    }

    public void setInvoices(Integer invoices) {
        this.invoices = invoices;
    }

    public Date getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(Date produceTime) {
        this.produceTime = produceTime;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public Long getBursmentId() {
        return bursmentId;
    }

    public void setBursmentId(Long bursmentId) {
        this.bursmentId = bursmentId;
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
        DetailsbursePO other = (DetailsbursePO) that;
        return (this.getDetailsburseId() == null ? other.getDetailsburseId() == null : this.getDetailsburseId().equals(other.getDetailsburseId()))
            && (this.getDescript() == null ? other.getDescript() == null : this.getDescript().equals(other.getDescript()))
            && (this.getDetailmoney() == null ? other.getDetailmoney() == null : this.getDetailmoney().equals(other.getDetailmoney()))
            && (this.getInvoices() == null ? other.getInvoices() == null : this.getInvoices().equals(other.getInvoices()))
            && (this.getProduceTime() == null ? other.getProduceTime() == null : this.getProduceTime().equals(other.getProduceTime()))
            && (this.getSubject() == null ? other.getSubject() == null : this.getSubject().equals(other.getSubject()))
            && (this.getBursmentId() == null ? other.getBursmentId() == null : this.getBursmentId().equals(other.getBursmentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDetailsburseId() == null) ? 0 : getDetailsburseId().hashCode());
        result = prime * result + ((getDescript() == null) ? 0 : getDescript().hashCode());
        result = prime * result + ((getDetailmoney() == null) ? 0 : getDetailmoney().hashCode());
        result = prime * result + ((getInvoices() == null) ? 0 : getInvoices().hashCode());
        result = prime * result + ((getProduceTime() == null) ? 0 : getProduceTime().hashCode());
        result = prime * result + ((getSubject() == null) ? 0 : getSubject().hashCode());
        result = prime * result + ((getBursmentId() == null) ? 0 : getBursmentId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", detailsburseId=").append(detailsburseId);
        sb.append(", descript=").append(descript);
        sb.append(", detailmoney=").append(detailmoney);
        sb.append(", invoices=").append(invoices);
        sb.append(", produceTime=").append(produceTime);
        sb.append(", subject=").append(subject);
        sb.append(", bursmentId=").append(bursmentId);
        sb.append("]");
        return sb.toString();
    }
}