package cn.gson.oasys.vo.dicussVO;

import cn.gson.oasys.model.entity.discuss.VoteTitles;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.Set;

@Data
@ToString
public class VoteListVO {
    private Long voteId;                //主键id,vote_id

    private Date startTime;//投票开始时间start_time

    private Date endTime;//投票结束时间end_time

    private Integer selectOne;                //单选和多选

    private DiscussListVO discussListVO;//voteList

    private Set<VoteTitleVO> voteTitleVOS;//voteList

}
