package cn.gson.oasys.vo.mailVO2;

import cn.gson.oasys.vo.attachmentVO2.AttachmentVO;
import cn.gson.oasys.vo.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class InMailListVO {
    private Long mailId;//邮件id(mail_id)

    private Long mailType;//邮件类型（mail_type,通知，公告，邮件）

    private Long mailStatusId;//邮件状态（mail_status_id,一般，紧急，重要）

    private UserVO mailUserVOId;//发件人id(mail_in_push_user_id)

    private String mailTitle;//邮件主题(mail_title)

    private String content;//邮件内容(mail_content)

    private String inReceiver;//接收人（in_receiver可以是多个）

    private AttachmentVO mailFile;//邮件附件id(mail_file_id)

    private Date mailCreateTime;//邮件创建时间(mail_create_time)

    private MailNumberVO mailNumberId;//外部邮件账号id(mail_number_id)

    private Boolean del=false;//(mail_del)

    private Boolean push=false;//mail_push

    private Boolean star=false;//mail_star

    private Long inmail;

    private String huizhuan;
}
