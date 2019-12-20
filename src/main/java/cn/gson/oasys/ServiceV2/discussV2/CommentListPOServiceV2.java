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
     * 根据评论ID删除评论信息
     *
     * @param commentListPOId
     */
    public void deleteCommentListPOByCommentListPOId(Long commentListPOId) {
        commentListPOMapper.deleteByPrimaryKey(commentListPOId);
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
     * @param replyListPOId
     * @return
     */
    public List<CommentListPO> getCommentListPOSByReplyPO(Long replyListPOId) {
        CommentListPOExample commentListPOExample = new CommentListPOExample();
        commentListPOExample.createCriteria().andReplyIdEqualTo(replyListPOId);
        List<CommentListPO> commentListPOS = commentListPOMapper.selectByExample(commentListPOExample);
        return commentListPOS;
    }

}
