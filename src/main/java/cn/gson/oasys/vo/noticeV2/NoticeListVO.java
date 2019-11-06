package cn.gson.oasys.vo.noticeV2;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class NoticeListVO {
    private Long noticeId; // 通知id

    private Long userId; // 用户id

    private Long typeId; // 类型id

    private Long statusId; // 状态id

    private String title; // 通知标题

    private String content; // 通知内容

    private String url; // 通知内的链接

    private Boolean top = false; // 该调通知是否置顶

    private Date noticeTime; // 发布通知的时间

    private Date modifyTime = new Date(); // 修改时间

}
