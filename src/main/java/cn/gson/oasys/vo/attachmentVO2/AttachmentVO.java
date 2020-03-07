package cn.gson.oasys.vo.attachmentVO2;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

//附件表
@ToString
@Data
public class AttachmentVO {
    private Long attachmentId; //附件id

    private Long userVOId;    //用户id 在没有连接外键只是用来
    //查询用户表的

    private String attachmentName;  //附件名字

    private String attachmentPath;  //附件存储路径

    private Long attachmentSize; //附件大小

    private String attachmentType;  //附件类型

    private Date uploadTime;     //附件上传时间

    private String model;          //所属模块

    private String attachmentShuffix; //附件后缀
}
