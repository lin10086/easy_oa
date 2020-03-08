package cn.gson.oasys.modelV2.po;

public class VoteTitlesPO {
    private Long titleId;

    private String color;

    private String title;

    private Long voteId;

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
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
        VoteTitlesPO other = (VoteTitlesPO) that;
        return (this.getTitleId() == null ? other.getTitleId() == null : this.getTitleId().equals(other.getTitleId()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getVoteId() == null ? other.getVoteId() == null : this.getVoteId().equals(other.getVoteId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTitleId() == null) ? 0 : getTitleId().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getVoteId() == null) ? 0 : getVoteId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", titleId=").append(titleId);
        sb.append(", color=").append(color);
        sb.append(", title=").append(title);
        sb.append(", voteId=").append(voteId);
        sb.append("]");
        return sb.toString();
    }
}