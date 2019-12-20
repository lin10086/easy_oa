package cn.gson.oasys.vo.dicussVO;

import cn.gson.oasys.vo.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Data
@ToString
public class ReplyListVO {
    private Long replyId;//reply_id

    private Date replayTime;     //回复时间replay_time

    private String content;     //内容

    private UserVO userVO;//reply_user_id

    private DiscussListVO discussListVO;//discuss_id

    private Set<UserVO> userVOSet;//aoa_love_user

    private Set<CommentListVO> commentListVOS;//reply


}
