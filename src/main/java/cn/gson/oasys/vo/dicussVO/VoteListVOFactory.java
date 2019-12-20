package cn.gson.oasys.vo.dicussVO;

import cn.gson.oasys.model.po.VoteListPO;

public class VoteListVOFactory {
    public static VoteListVO createVoteListVOByVoteListPO(VoteListPO voteListPO) {
        VoteListVO voteListVO = new VoteListVO();
        voteListVO.setVoteId(voteListPO.getVoteId());
        voteListVO.setEndTime(voteListPO.getEndTime());
        voteListVO.setSelectOne(voteListPO.getSelectone());
        voteListVO.setStartTime(voteListPO.getStartTime());
        return voteListVO;
    }
}
