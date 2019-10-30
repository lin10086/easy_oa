package cn.gson.oasys.model.po;

public class EvectionMoneyPO {
    private Long evectionmoneyId;

    private String financialAdvice;

    private String managerAdvice;

    private Double money;

    private String name;

    private Long proId;

    private Integer pro;

    public Long getEvectionmoneyId() {
        return evectionmoneyId;
    }

    public void setEvectionmoneyId(Long evectionmoneyId) {
        this.evectionmoneyId = evectionmoneyId;
    }

    public String getFinancialAdvice() {
        return financialAdvice;
    }

    public void setFinancialAdvice(String financialAdvice) {
        this.financialAdvice = financialAdvice == null ? null : financialAdvice.trim();
    }

    public String getManagerAdvice() {
        return managerAdvice;
    }

    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public Integer getPro() {
        return pro;
    }

    public void setPro(Integer pro) {
        this.pro = pro;
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
        EvectionMoneyPO other = (EvectionMoneyPO) that;
        return (this.getEvectionmoneyId() == null ? other.getEvectionmoneyId() == null : this.getEvectionmoneyId().equals(other.getEvectionmoneyId()))
            && (this.getFinancialAdvice() == null ? other.getFinancialAdvice() == null : this.getFinancialAdvice().equals(other.getFinancialAdvice()))
            && (this.getManagerAdvice() == null ? other.getManagerAdvice() == null : this.getManagerAdvice().equals(other.getManagerAdvice()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
            && (this.getPro() == null ? other.getPro() == null : this.getPro().equals(other.getPro()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEvectionmoneyId() == null) ? 0 : getEvectionmoneyId().hashCode());
        result = prime * result + ((getFinancialAdvice() == null) ? 0 : getFinancialAdvice().hashCode());
        result = prime * result + ((getManagerAdvice() == null) ? 0 : getManagerAdvice().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getPro() == null) ? 0 : getPro().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", evectionmoneyId=").append(evectionmoneyId);
        sb.append(", financialAdvice=").append(financialAdvice);
        sb.append(", managerAdvice=").append(managerAdvice);
        sb.append(", money=").append(money);
        sb.append(", name=").append(name);
        sb.append(", proId=").append(proId);
        sb.append(", pro=").append(pro);
        sb.append("]");
        return sb.toString();
    }
}