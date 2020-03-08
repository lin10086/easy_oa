package cn.gson.oasys.voandfactory.userVO2;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class UserLoginRecordVO {
    private Long id;    //用户登录记录表表id

    private String ipAddr;    //ip地址

    private Date loginTime;    //登陆时间

    private String sessionId;    //session id

    private String browser;    //使用浏览器

    private UserVO userVO;
}
