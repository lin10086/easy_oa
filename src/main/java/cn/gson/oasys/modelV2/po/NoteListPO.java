package cn.gson.oasys.modelV2.po;

import java.util.Date;

public class NoteListPO {
    private Long noteId;

    private String content;

    private Date createTime;

    private Long statusId;

    private String title;

    private Long typeId;

    private Long catalogId;

    private Long attachId;

    private Long isCollected;

    private Long createmanId;

    private String receiver;

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public Long getAttachId() {
        return attachId;
    }

    public void setAttachId(Long attachId) {
        this.attachId = attachId;
    }

    public Long getIsCollected() {
        return isCollected;
    }

    public void setIsCollected(Long isCollected) {
        this.isCollected = isCollected;
    }

    public Long getCreatemanId() {
        return createmanId;
    }

    public void setCreatemanId(Long createmanId) {
        this.createmanId = createmanId;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
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
        NoteListPO other = (NoteListPO) that;
        return (this.getNoteId() == null ? other.getNoteId() == null : this.getNoteId().equals(other.getNoteId()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatusId() == null ? other.getStatusId() == null : this.getStatusId().equals(other.getStatusId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
            && (this.getCatalogId() == null ? other.getCatalogId() == null : this.getCatalogId().equals(other.getCatalogId()))
            && (this.getAttachId() == null ? other.getAttachId() == null : this.getAttachId().equals(other.getAttachId()))
            && (this.getIsCollected() == null ? other.getIsCollected() == null : this.getIsCollected().equals(other.getIsCollected()))
            && (this.getCreatemanId() == null ? other.getCreatemanId() == null : this.getCreatemanId().equals(other.getCreatemanId()))
            && (this.getReceiver() == null ? other.getReceiver() == null : this.getReceiver().equals(other.getReceiver()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getNoteId() == null) ? 0 : getNoteId().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatusId() == null) ? 0 : getStatusId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getCatalogId() == null) ? 0 : getCatalogId().hashCode());
        result = prime * result + ((getAttachId() == null) ? 0 : getAttachId().hashCode());
        result = prime * result + ((getIsCollected() == null) ? 0 : getIsCollected().hashCode());
        result = prime * result + ((getCreatemanId() == null) ? 0 : getCreatemanId().hashCode());
        result = prime * result + ((getReceiver() == null) ? 0 : getReceiver().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", noteId=").append(noteId);
        sb.append(", content=").append(content);
        sb.append(", createTime=").append(createTime);
        sb.append(", statusId=").append(statusId);
        sb.append(", title=").append(title);
        sb.append(", typeId=").append(typeId);
        sb.append(", catalogId=").append(catalogId);
        sb.append(", attachId=").append(attachId);
        sb.append(", isCollected=").append(isCollected);
        sb.append(", createmanId=").append(createmanId);
        sb.append(", receiver=").append(receiver);
        sb.append("]");
        return sb.toString();
    }
}