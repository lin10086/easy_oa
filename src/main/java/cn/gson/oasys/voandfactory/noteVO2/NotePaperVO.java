package cn.gson.oasys.voandfactory.noteVO2;

import cn.gson.oasys.voandfactory.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class NotePaperVO {
    private Long notepaperId;            //主键notepaper_id

    private String title;                //便签标题

    private String content;             //便签内容

    private UserVO userVO;              //编写便签的用户notepaper_user_id

    private Date createTime;            //便签创建时间create_time
}
