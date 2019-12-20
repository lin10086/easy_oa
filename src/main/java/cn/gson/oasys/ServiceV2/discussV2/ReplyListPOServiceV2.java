package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.mappers.ReplyListPOMapper;
import cn.gson.oasys.model.po.CommentListPO;
import cn.gson.oasys.model.po.ReplyListPO;
import cn.gson.oasys.model.po.ReplyListPOExample;
import freemarker.template.utility.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyListPOServiceV2 {
    @Resource
    private ReplyListPOMapper replyListPOMapper;
    @Resource
    private CommentListPOServiceV2 commentListPOServiceV2;
    @Resource
    private ReplyListUserPOServiceV2 replyListUserPOServiceV2;

    /**
     * 插入一条回复信息
     *
     * @param replyListPO 回复信息
     */
    public void insertReplyListPOByReplyListPO(ReplyListPO replyListPO) {
        replyListPOMapper.insertSelective(replyListPO);
    }

    /**
     * 根据回复表ID删除回复表信息
     *
     * @param replyListPOId 回复表ID
     */
    public void deleteReplyListPOByReplyListPOId(Long replyListPOId) {
        List<CommentListPO> commentListPOS = commentListPOServiceV2.getCommentListPOSByReplyPO(replyListPOId);
        for (CommentListPO commentListPO : commentListPOS) {
            commentListPOServiceV2.deleteCommentListPOByCommentListPOId(commentListPO.getCommentId());
        }
        //还应该删除回复点赞表信息
        replyListUserPOServiceV2.deleteLoveReplyUserPOByReplyPOId(replyListPOId);
        replyListPOMapper.deleteByPrimaryKey(replyListPOId);
    }

    /**
     * 根据讨论表ID找回复列表并排序
     *
     * @param discussId 讨论表ID
     * @return
     */
    public List<ReplyListPO> getReplyListPOSByDiscussIdAndCreateTimeSort(Long discussId, Long selectSort) {
        ReplyListPOExample replyListPOExample = getReplyListPOExampleByReplayTime(selectSort);
        replyListPOExample.createCriteria().andDiscussIdEqualTo(discussId);
        List<ReplyListPO> replyListPOS = replyListPOMapper.selectByExampleWithBLOBs(replyListPOExample);
        return replyListPOS;
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
        List<ReplyListPO> replyListPOS = replyListPOMapper.selectByExampleWithBLOBs(replyListPOExample);
        return replyListPOS;
    }

    /**
     * 根据讨论表ID和用户ID找回复表信息
     *
     * @param discussId 讨论表ID
     * @param userId    用户ID
     * @return
     */
    public List<ReplyListPO> getReplyListPOSByDiscussIdAndUserId(Long discussId, Long userId, Long selectSort) {
        ReplyListPOExample replyListPOExample = getReplyListPOExampleByReplayTime(selectSort);
        replyListPOExample.createCriteria().andDiscussIdEqualTo(discussId).andReplyUserIdEqualTo(userId);
        List<ReplyListPO> replyListPOS = replyListPOMapper.selectByExampleWithBLOBs(replyListPOExample);
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

    /**
     * 根据selectSort是否存在是否==1按照是回复时间排序
     *
     * @param selectSort
     * @return
     */
    public ReplyListPOExample getReplyListPOExampleByReplayTime(Long selectSort) {
        ReplyListPOExample replyListPOExample = new ReplyListPOExample();
        if (!StringUtils.isEmpty(selectSort) && selectSort == 1) {
            replyListPOExample.setOrderByClause("replay_time DESC");
        } else {
            replyListPOExample.setOrderByClause("replay_time ASC");
        }
        return replyListPOExample;
    }

}
