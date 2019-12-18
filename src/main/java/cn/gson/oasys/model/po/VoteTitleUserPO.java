package cn.gson.oasys.model.po;

public class VoteTitleUserPO {
    private Long voteTitleUserId;

    private Long voteId;

    private Long userId;

    private Long titleId;

    public Long getVoteTitleUserId() {
        return voteTitleUserId;
    }

    public void setVoteTitleUserId(Long voteTitleUserId) {
        this.voteTitleUserId = voteTitleUserId;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTitleId() {
        return titleId;
    }

    public void setTitleId(Long titleId) {
        this.titleId = titleId;
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
        VoteTitleUserPO other = (VoteTitleUserPO) that;
        return (this.getVoteTitleUserId() == null ? other.getVoteTitleUserId() == null : this.getVoteTitleUserId().equals(other.getVoteTitleUserId()))
            && (this.getVoteId() == null ? other.getVoteId() == null : this.getVoteId().equals(other.getVoteId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTitleId() == null ? other.getTitleId() == null : this.getTitleId().equals(other.getTitleId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVoteTitleUserId() == null) ? 0 : getVoteTitleUserId().hashCode());
        result = prime * result + ((getVoteId() == null) ? 0 : getVoteId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTitleId() == null) ? 0 : getTitleId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", voteTitleUserId=").append(voteTitleUserId);
        sb.append(", voteId=").append(voteId);
        sb.append(", userId=").append(userId);
        sb.append(", titleId=").append(titleId);
        sb.append("]");
        return sb.toString();
    }
}