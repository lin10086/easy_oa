package cn.gson.oasys.voandfactory.dicussVO2;

import cn.gson.oasys.voandfactory.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Data
@ToString
public class DiscussListVO {
    private Long discussId; //主键id

    private Long typeId; //类型id(type_id)

    private Long statusId; //状态id(status_id)

    private Date createTime; //创建时间create_time

    private Date modifyTime; //修改时间modify_time

    private Integer visitNum; //访问量visit_num

    private Integer attachmentId;  //附件id没有外键为了查找方便attachment_id

    private String title;    //标题

    private String content;   //内容

    private UserVO userVO;        //讨论归属人discuss_user_id

    private VoteListVO voteList;    // 投票id,vote_id

    private Set<ReplyListVO> replyListVOS;//discuss


    private Set<UserVO> userVOSet;//aoa_love_discuss_user

}
