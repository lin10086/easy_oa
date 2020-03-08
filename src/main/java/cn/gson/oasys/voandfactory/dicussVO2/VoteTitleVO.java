package cn.gson.oasys.voandfactory.dicussVO2;

import lombok.Data;
import lombok.ToString;

import java.util.Set;

@Data
@ToString
public class VoteTitleVO {
    private Long titleId;//title_id

    private String title;                //投票标题

    private String color;                //进度条颜色

    private Set<VoteTitleUserVO> voteTitleUserVOS;

    private VoteListVO voteListVO;            //关联投标表      投票vote_id
}
