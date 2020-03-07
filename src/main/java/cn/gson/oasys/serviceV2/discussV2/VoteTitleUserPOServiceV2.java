package cn.gson.oasys.serviceV2.discussV2;

import cn.gson.oasys.mappers.VoteTitleUserPOMapper;
import cn.gson.oasys.model.po.VoteTitleUserPO;
import cn.gson.oasys.model.po.VoteTitleUserPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VoteTitleUserPOServiceV2 {
    @Resource
    private VoteTitleUserPOMapper voteTitleUserPOMapper;

    /**
     * 插入一条投票信息（即在投票，标题，用户中间表插入一条信息）
     *
     * @param voteTitleUserPO
     */
    public void insertVoteTitleUserPOByVoteTitleUserPO(VoteTitleUserPO voteTitleUserPO) {
        voteTitleUserPOMapper.insertSelective(voteTitleUserPO);
    }

    /**
     * 在用户投票的标题表中查找所有的同一标题的集合（即投票标题相同）
     *
     * @param voteTitleId 投票标题ID
     * @return
     */
    public List<VoteTitleUserPO> getVoteTitleUserPOSByVoteTitleId(Long voteTitleId) {
        VoteTitleUserPOExample voteTitleUserPOExample = new VoteTitleUserPOExample();
        voteTitleUserPOExample.createCriteria().andTitleIdEqualTo(voteTitleId);
        List<VoteTitleUserPO> voteTitleUserPOS = voteTitleUserPOMapper.selectByExample(voteTitleUserPOExample);
        return voteTitleUserPOS;
    }


    /**
     * 在用户投票的标题表中查找所有的同一投票的集合
     *
     * @param voteId 投票ID
     * @return
     */
    public List<VoteTitleUserPO> getVoteTitleUserPOSByVoteId(Long voteId) {
        VoteTitleUserPOExample voteTitleUserPOExample = new VoteTitleUserPOExample();
        voteTitleUserPOExample.createCriteria().andVoteIdEqualTo(voteId);
        List<VoteTitleUserPO> voteTitleUserPOS = voteTitleUserPOMapper.selectByExample(voteTitleUserPOExample);
        return voteTitleUserPOS;
    }

    /**
     * 在用户投票的标题表中查找所有的同一标题和同一用户的（即投票标题相同）
     *
     * @param voteTitleId 投票标题ID
     * @param userId      用户ID
     * @return
     */
    public VoteTitleUserPO getVoteTitleUserPOByVoteTitleIdAndUserId(Long voteTitleId, Long userId) {
        VoteTitleUserPOExample voteTitleUserPOExample = new VoteTitleUserPOExample();
        voteTitleUserPOExample.createCriteria().andTitleIdEqualTo(voteTitleId).andUserIdEqualTo(userId);
        List<VoteTitleUserPO> voteTitleUserPOS = voteTitleUserPOMapper.selectByExample(voteTitleUserPOExample);
        if (voteTitleUserPOS.size() == 0) {
            return null;
        }
        return voteTitleUserPOS.get(0);
    }
}
