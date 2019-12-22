package cn.gson.oasys.model.po;

import java.util.Date;

public class NotePaperPO {
    private Long notepaperId;

    private Date createTime;

    private String title;

    private Long notepaperUserId;

    private String concent;

    public Long getNotepaperId() {
        return notepaperId;
    }

    public void setNotepaperId(Long notepaperId) {
        this.notepaperId = notepaperId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getNotepaperUserId() {
        return notepaperUserId;
    }

    public void setNotepaperUserId(Long notepaperUserId) {
        this.notepaperUserId = notepaperUserId;
    }

    public String getConcent() {
        return concent;
    }

    public void setConcent(String concent) {
        this.concent = concent == null ? null : concent.trim();
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
        NotePaperPO other = (NotePaperPO) that;
        return (this.getNotepaperId() == null ? other.getNotepaperId() == null : this.getNotepaperId().equals(other.getNotepaperId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getNotepaperUserId() == null ? other.getNotepaperUserId() == null : this.getNotepaperUserId().equals(other.getNotepaperUserId()))
            && (this.getConcent() == null ? other.getConcent() == null : this.getConcent().equals(other.getConcent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNotepaperId() == null) ? 0 : getNotepaperId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getNotepaperUserId() == null) ? 0 : getNotepaperUserId().hashCode());
        result = prime * result + ((getConcent() == null) ? 0 : getConcent().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", notepaperId=").append(notepaperId);
        sb.append(", createTime=").append(createTime);
        sb.append(", title=").append(title);
        sb.append(", notepaperUserId=").append(notepaperUserId);
        sb.append(", concent=").append(concent);
        sb.append("]");
        return sb.toString();
    }
}