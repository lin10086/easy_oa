package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.mappers.CommentListPOMapper;
import cn.gson.oasys.model.po.CommentListPO;
import cn.gson.oasys.model.po.CommentListPOExample;
import cn.gson.oasys.model.po.ReplyListPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentListPOServiceV2 {
    @Resource
    private CommentListPOMapper commentListPOMapper;

    /**
     * 插入一条评论
     *
     * @param commentListPO 评论信息
     */
    public void insertCommentListPOByCommentListPO(CommentListPO commentListPO) {
        commentListPOMapper.insertSelective(commentListPO);
    }

    /**
     * 根据回复IDs找评论ID
     *
     * @param replyIds 评论IDS
     * @return
     */
    public List<CommentListPO> getCommentListPOSByReplyIdIn(List<Long> replyIds) {
        CommentListPOExample commentListPOExample = new CommentListPOExample();
        commentListPOExample.createCriteria().andReplyIdIn(replyIds);
        List<CommentListPO> commentListPOS = commentListPOMapper.selectByExample(commentListPOExample);
        return commentListPOS;
    }

    /**
     * 根据回复表ID找评论表
     *
     * @param replyListPO
     * @return
     */
    public List<CommentListPO> getCommentListPOSByReplyPOId(ReplyListPO replyListPO) {
        CommentListPOExample commentListPOExample = new CommentListPOExample();
        commentListPOExample.createCriteria().andReplyIdEqualTo(replyListPO.getReplyId());
        List<CommentListPO> commentListPOS = commentListPOMapper.selectByExample(commentListPOExample);
        return commentListPOS;
    }

}
