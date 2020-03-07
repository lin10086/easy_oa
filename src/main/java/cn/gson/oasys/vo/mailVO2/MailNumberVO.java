package cn.gson.oasys.vo.mailVO2;

import cn.gson.oasys.vo.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class MailNumberVO {

    private Long mailNumberId; //邮箱的主键id

    private Long mailType;//邮件账号类型

    private Long status;//邮件状态（是否可用）

    private UserVO mailUserId;//用户id

    private String mailUserName;//用户别名(昵称）

    private Date mailCreateTime;//账号创建时间

    private String mailAccount;//邮件账号

    private String password;//账号授权码

    private String mailDes;//账号信息备注
}
