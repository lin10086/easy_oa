package cn.gson.oasys.voandfactory.dicussVO2;

import cn.gson.oasys.voandfactory.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class VoteTitleUserVO {
    private Long voteTitleUserId;//主键ID

    private Long voteId;//投票vote_id

    private VoteTitleVO voteTitleVO;//title_id

    private UserVO userVO;//user_id
}
