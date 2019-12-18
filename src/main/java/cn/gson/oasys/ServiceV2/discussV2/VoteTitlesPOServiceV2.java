package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.mappers.VoteTitlesPOMapper;
import cn.gson.oasys.model.po.VoteTitlesPO;
import cn.gson.oasys.model.po.VoteTitlesPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VoteTitlesPOServiceV2 {
    @Resource
    private VoteTitlesPOMapper voteTitlesPOMapper;

    /**
     * 根据投票表ID找投票标题集合
     *
     * @param voteId 投票表ID
     * @return
     */
    public List<VoteTitlesPO> getVoteTitlesPOByVoteId(Long voteId) {
        VoteTitlesPOExample voteTitlesPOExample = new VoteTitlesPOExample();
        voteTitlesPOExample.createCriteria().andVoteIdEqualTo(voteId);
        List<VoteTitlesPO> voteTitlesPOS = voteTitlesPOMapper.selectByExample(voteTitlesPOExample);
        return voteTitlesPOS;
    }

}
