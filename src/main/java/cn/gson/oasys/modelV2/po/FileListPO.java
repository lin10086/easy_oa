package cn.gson.oasys.modelV2.po;

import java.util.Date;

public class FileListPO {
    private Long fileId;

    private String fileName;

    private String filePath;

    private String fileShuffix;

    private String contentType;

    private String model;

    private Long pathId;

    private Long size;

    private Date uploadTime;

    private Long fileUserId;

    private Long fileIstrash;

    private Long fileIsshare;

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileShuffix() {
        return fileShuffix;
    }

    public void setFileShuffix(String fileShuffix) {
        this.fileShuffix = fileShuffix == null ? null : fileShuffix.trim();
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType == null ? null : contentType.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Long getPathId() {
        return pathId;
    }

    public void setPathId(Long pathId) {
        this.pathId = pathId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Long getFileUserId() {
        return fileUserId;
    }

    public void setFileUserId(Long fileUserId) {
        this.fileUserId = fileUserId;
    }

    public Long getFileIstrash() {
        return fileIstrash;
    }

    public void setFileIstrash(Long fileIstrash) {
        this.fileIstrash = fileIstrash;
    }

    public Long getFileIsshare() {
        return fileIsshare;
    }

    public void setFileIsshare(Long fileIsshare) {
        this.fileIsshare = fileIsshare;
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
        FileListPO other = (FileListPO) that;
        return (this.getFileId() == null ? other.getFileId() == null : this.getFileId().equals(other.getFileId()))
            && (this.getFileName() == null ? other.getFileName() == null : this.getFileName().equals(other.getFileName()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getFileShuffix() == null ? other.getFileShuffix() == null : this.getFileShuffix().equals(other.getFileShuffix()))
            && (this.getContentType() == null ? other.getContentType() == null : this.getContentType().equals(other.getContentType()))
            && (this.getModel() == null ? other.getModel() == null : this.getModel().equals(other.getModel()))
            && (this.getPathId() == null ? other.getPathId() == null : this.getPathId().equals(other.getPathId()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getUploadTime() == null ? other.getUploadTime() == null : this.getUploadTime().equals(other.getUploadTime()))
            && (this.getFileUserId() == null ? other.getFileUserId() == null : this.getFileUserId().equals(other.getFileUserId()))
            && (this.getFileIstrash() == null ? other.getFileIstrash() == null : this.getFileIstrash().equals(other.getFileIstrash()))
            && (this.getFileIsshare() == null ? other.getFileIsshare() == null : this.getFileIsshare().equals(other.getFileIsshare()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getFileId() == null) ? 0 : getFileId().hashCode());
        result = prime * result + ((getFileName() == null) ? 0 : getFileName().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getFileShuffix() == null) ? 0 : getFileShuffix().hashCode());
        result = prime * result + ((getContentType() == null) ? 0 : getContentType().hashCode());
        result = prime * result + ((getModel() == null) ? 0 : getModel().hashCode());
        result = prime * result + ((getPathId() == null) ? 0 : getPathId().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getUploadTime() == null) ? 0 : getUploadTime().hashCode());
        result = prime * result + ((getFileUserId() == null) ? 0 : getFileUserId().hashCode());
        result = prime * result + ((getFileIstrash() == null) ? 0 : getFileIstrash().hashCode());
        result = prime * result + ((getFileIsshare() == null) ? 0 : getFileIsshare().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", fileId=").append(fileId);
        sb.append(", fileName=").append(fileName);
        sb.append(", filePath=").append(filePath);
        sb.append(", fileShuffix=").append(fileShuffix);
        sb.append(", contentType=").append(contentType);
        sb.append(", model=").append(model);
        sb.append(", pathId=").append(pathId);
        sb.append(", size=").append(size);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", fileUserId=").append(fileUserId);
        sb.append(", fileIstrash=").append(fileIstrash);
        sb.append(", fileIsshare=").append(fileIsshare);
        sb.append("]");
        return sb.toString();
    }
}