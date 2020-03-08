package cn.gson.oasys.modelV2.po;

public class RegularPO {
    private Long regularId;

    private String advice;

    private String deficiency;

    private String dobetter;

    private String experience;

    private String personnelAdvice;

    private String pullulate;

    private String understand;

    private Long proId;

    private String managerAdvice;

    private Integer days;

    public Long getRegularId() {
        return regularId;
    }

    public void setRegularId(Long regularId) {
        this.regularId = regularId;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public String getDeficiency() {
        return deficiency;
    }

    public void setDeficiency(String deficiency) {
        this.deficiency = deficiency == null ? null : deficiency.trim();
    }

    public String getDobetter() {
        return dobetter;
    }

    public void setDobetter(String dobetter) {
        this.dobetter = dobetter == null ? null : dobetter.trim();
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience == null ? null : experience.trim();
    }

    public String getPersonnelAdvice() {
        return personnelAdvice;
    }

    public void setPersonnelAdvice(String personnelAdvice) {
        this.personnelAdvice = personnelAdvice == null ? null : personnelAdvice.trim();
    }

    public String getPullulate() {
        return pullulate;
    }

    public void setPullulate(String pullulate) {
        this.pullulate = pullulate == null ? null : pullulate.trim();
    }

    public String getUnderstand() {
        return understand;
    }

    public void setUnderstand(String understand) {
        this.understand = understand == null ? null : understand.trim();
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

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
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
        RegularPO other = (RegularPO) that;
        return (this.getRegularId() == null ? other.getRegularId() == null : this.getRegularId().equals(other.getRegularId()))
            && (this.getAdvice() == null ? other.getAdvice() == null : this.getAdvice().equals(other.getAdvice()))
            && (this.getDeficiency() == null ? other.getDeficiency() == null : this.getDeficiency().equals(other.getDeficiency()))
            && (this.getDobetter() == null ? other.getDobetter() == null : this.getDobetter().equals(other.getDobetter()))
            && (this.getExperience() == null ? other.getExperience() == null : this.getExperience().equals(other.getExperience()))
            && (this.getPersonnelAdvice() == null ? other.getPersonnelAdvice() == null : this.getPersonnelAdvice().equals(other.getPersonnelAdvice()))
            && (this.getPullulate() == null ? other.getPullulate() == null : this.getPullulate().equals(other.getPullulate()))
            && (this.getUnderstand() == null ? other.getUnderstand() == null : this.getUnderstand().equals(other.getUnderstand()))
            && (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
            && (this.getManagerAdvice() == null ? other.getManagerAdvice() == null : this.getManagerAdvice().equals(other.getManagerAdvice()))
            && (this.getDays() == null ? other.getDays() == null : this.getDays().equals(other.getDays()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRegularId() == null) ? 0 : getRegularId().hashCode());
        result = prime * result + ((getAdvice() == null) ? 0 : getAdvice().hashCode());
        result = prime * result + ((getDeficiency() == null) ? 0 : getDeficiency().hashCode());
        result = prime * result + ((getDobetter() == null) ? 0 : getDobetter().hashCode());
        result = prime * result + ((getExperience() == null) ? 0 : getExperience().hashCode());
        result = prime * result + ((getPersonnelAdvice() == null) ? 0 : getPersonnelAdvice().hashCode());
        result = prime * result + ((getPullulate() == null) ? 0 : getPullulate().hashCode());
        result = prime * result + ((getUnderstand() == null) ? 0 : getUnderstand().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getManagerAdvice() == null) ? 0 : getManagerAdvice().hashCode());
        result = prime * result + ((getDays() == null) ? 0 : getDays().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", regularId=").append(regularId);
        sb.append(", advice=").append(advice);
        sb.append(", deficiency=").append(deficiency);
        sb.append(", dobetter=").append(dobetter);
        sb.append(", experience=").append(experience);
        sb.append(", personnelAdvice=").append(personnelAdvice);
        sb.append(", pullulate=").append(pullulate);
        sb.append(", understand=").append(understand);
        sb.append(", proId=").append(proId);
        sb.append(", managerAdvice=").append(managerAdvice);
        sb.append(", days=").append(days);
        sb.append("]");
        return sb.toString();
    }
}