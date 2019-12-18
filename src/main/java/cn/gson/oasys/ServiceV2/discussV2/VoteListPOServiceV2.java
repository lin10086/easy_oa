package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.mappers.VoteListPOMapper;
import cn.gson.oasys.model.po.VoteListPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VoteListPOServiceV2 {
    @Resource
    private VoteListPOMapper voteListPOMapper;

    /**
     * 根据投票表ID找投票信息
     *
     * @param voteListPOId 投票表ID
     * @return
     */
    public VoteListPO getVoteListPOByVoteListPOId(Long voteListPOId) {
        VoteListPO voteListPO = voteListPOMapper.selectByPrimaryKey(voteListPOId);
        return voteListPO;
    }

}
