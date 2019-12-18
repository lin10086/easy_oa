package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.mappers.ReplyListPOMapper;
import cn.gson.oasys.model.po.ReplyListPO;
import cn.gson.oasys.model.po.ReplyListPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyListPOServiceV2 {
    @Resource
    private ReplyListPOMapper replyListPOMapper;

    /**
     * 插入一条回复信息
     *
     * @param replyListPO 回复信息
     */
    public void insertReplyListPOByReplyListPO(ReplyListPO replyListPO) {
        replyListPOMapper.insertSelective(replyListPO);
    }

    /**
     * 根据讨论表ID找回复列表
     *
     * @param discussId 讨论表ID
     * @return
     */
    public List<ReplyListPO> getReplyListPOSByDiscussId(Long discussId) {
        ReplyListPOExample replyListPOExample = new ReplyListPOExample();
        replyListPOExample.createCriteria().andDiscussIdEqualTo(discussId);
        List<ReplyListPO> replyListPOS = replyListPOMapper.selectByExample(replyListPOExample);
        return replyListPOS;
    }

    /**
     * 根据讨论表ID和用户ID找回复表信息
     *
     * @param discussId 讨论表ID
     * @param userId    用户ID
     * @return
     */
    public List<ReplyListPO> getReplyListPOSByDiscussIdAndUserId(Long discussId, Long userId) {
        ReplyListPOExample replyListPOExample = new ReplyListPOExample();
        replyListPOExample.createCriteria().andDiscussIdEqualTo(discussId).andReplyUserIdEqualTo(userId);
        List<ReplyListPO> replyListPOS = replyListPOMapper.selectByExample(replyListPOExample);
        return replyListPOS;
    }

    /**
     * 根据回复表ID找回复信息
     *
     * @param replyListPOId 回复表ID
     * @return
     */
    public ReplyListPO getReplyListPOByReplyListPOId(Long replyListPOId) {
        ReplyListPO replyListPO = replyListPOMapper.selectByPrimaryKey(replyListPOId);
        return replyListPO;
    }

}
