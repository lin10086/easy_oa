package cn.gson.oasys.modelV2.po;

public class ResignPO {
    private Long resignId;

    private String financialAdvice;

    private Boolean isFinish;

    private String nofinish;

    private String personnelAdvice;

    private String suggest;

    private Long handUser;

    private Long proId;

    private String managerAdvice;

    public Long getResignId() {
        return resignId;
    }

    public void setResignId(Long resignId) {
        this.resignId = resignId;
    }

    public String getFinancialAdvice() {
        return financialAdvice;
    }

    public void setFinancialAdvice(String financialAdvice) {
        this.financialAdvice = financialAdvice == null ? null : financialAdvice.trim();
    }

    public Boolean getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(Boolean isFinish) {
        this.isFinish = isFinish;
    }

    public String getNofinish() {
        return nofinish;
    }

    public void setNofinish(String nofinish) {
        this.nofinish = nofinish == null ? null : nofinish.trim();
    }

    public String getPersonnelAdvice() {
        return personnelAdvice;
    }

    public void setPersonnelAdvice(String personnelAdvice) {
        this.personnelAdvice = personnelAdvice == null ? null : personnelAdvice.trim();
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest == null ? null : suggest.trim();
    }

    public Long getHandUser() {
        return handUser;
    }

    public void setHandUser(Long handUser) {
        this.handUser = handUser;
    }

    public Long getProId() {
        return proId;
    }

    public void setProId(Long proId) {
        this.proId = proId;
    }

    public String getManagerAdvice() {
        return managerAdvice;
    }

    public void setManagerAdvice(String managerAdvice) {
        this.managerAdvice = managerAdvice == null ? null : managerAdvice.trim();
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
        ResignPO other = (ResignPO) that;
        return (this.getResignId() == null ? other.getResignId() == null : this.getResignId().equals(other.getResignId()))
            && (this.getFinancialAdvice() == null ? other.getFinancialAdvice() == null : this.getFinancialAdvice().equals(other.getFinancialAdvice()))
            && (this.getIsFinish() == null ? other.getIsFinish() == null : this.getIsFinish().equals(other.getIsFinish()))
            && (this.getNofinish() == null ? other.getNofinish() == null : this.getNofinish().equals(other.getNofinish()))
            && (this.getPersonnelAdvice() == null ? other.getPersonnelAdvice() == null : this.getPersonnelAdvice().equals(other.getPersonnelAdvice()))
            && (this.getSuggest() == null ? other.getSuggest() == null : this.getSuggest().equals(other.getSuggest()))
            && (this.getHandUser() == null ? other.getHandUser() == null : this.getHandUser().equals(other.getHandUser()))
            && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
            && (this.getManagerAdvice() == null ? other.getManagerAdvice() == null : this.getManagerAdvice().equals(other.getManagerAdvice()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResignId() == null) ? 0 : getResignId().hashCode());
        result = prime * result + ((getFinancialAdvice() == null) ? 0 : getFinancialAdvice().hashCode());
        result = prime * result + ((getIsFinish() == null) ? 0 : getIsFinish().hashCode());
        result = prime * result + ((getNofinish() == null) ? 0 : getNofinish().hashCode());
        result = prime * result + ((getPersonnelAdvice() == null) ? 0 : getPersonnelAdvice().hashCode());
        result = prime * result + ((getSuggest() == null) ? 0 : getSuggest().hashCode());
        result = prime * result + ((getHandUser() == null) ? 0 : getHandUser().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getManagerAdvice() == null) ? 0 : getManagerAdvice().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resignId=").append(resignId);
        sb.append(", financialAdvice=").append(financialAdvice);
        sb.append(", isFinish=").append(isFinish);
        sb.append(", nofinish=").append(nofinish);
        sb.append(", personnelAdvice=").append(personnelAdvice);
        sb.append(", suggest=").append(suggest);
        sb.append(", handUser=").append(handUser);
        sb.append(", proId=").append(proId);
        sb.append(", managerAdvice=").append(managerAdvice);
        sb.append("]");
        return sb.toString();
    }
}