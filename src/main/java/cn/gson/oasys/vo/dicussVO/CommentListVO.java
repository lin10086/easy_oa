package cn.gson.oasys.vo.dicussVO;

import cn.gson.oasys.vo.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class CommentListVO {
    private Long commentId;//comment_id

    private Date time; //发布时间

    private String comment;//发布内容

    private UserVO userVO;//comment_user_id

    private ReplyListVO reply;//reply_id
}
