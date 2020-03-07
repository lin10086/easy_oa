package cn.gson.oasys.serviceV2.discussV2;

import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.mappers.LoveReplyUserPOMapper;
import cn.gson.oasys.model.po.LoveReplyUserPO;
import cn.gson.oasys.model.po.LoveReplyUserPOExample;
import cn.gson.oasys.model.po.ReplyListPO;
import cn.gson.oasys.model.po.UserPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ReplyListUserPOServiceV2 {
    @Resource
    private LoveReplyUserPOMapper loveReplyUserPOMapper;
    @Resource
    private UserPOServiceV2 userPOServiceV2;

    /**
     * 根据用户ID和回复ID在回复用户点赞表插入一条信息（即点赞）
     *
     * @param userId    用户ID
     * @param replyPOId 回复ID
     */
    public void insertLoveReplyUserPOByUserIdAndReplyPOId(Long userId, Long replyPOId) {
        LoveReplyUserPO loveReplyUserPO = new LoveReplyUserPO();
        loveReplyUserPO.setReplyId(replyPOId);
        loveReplyUserPO.setUserId(userId);
        loveReplyUserPOMapper.insertSelective(loveReplyUserPO);
    }

    /**
     * 根据用户ID和回复ID在回复用户点赞表找出信息，再根据回复点赞表ID删除信息(取消点赞）
     *
     * @param userId    用户ID
     * @param replyPOId 回复ID
     */
    public void deleteLoveReplyUserPOByUserIdAndReplyPOId(Long userId, Long replyPOId) {
        LoveReplyUserPOExample loveReplyUserPOExample = new LoveReplyUserPOExample();
        loveReplyUserPOExample.createCriteria().andUserIdEqualTo(userId).andReplyIdEqualTo(replyPOId);
        List<LoveReplyUserPO> loveReplyUserPOS = loveReplyUserPOMapper.selectByExample(loveReplyUserPOExample);
        loveReplyUserPOMapper.deleteByPrimaryKey(loveReplyUserPOS.get(0).getReplyUserId());
    }

    /**
     * 删除此回复的所有点赞（当删除此回复时）
     *
     * @param replyPOId
     */
    public void deleteLoveReplyUserPOByReplyPOId(Long replyPOId) {
        LoveReplyUserPOExample loveReplyUserPOExample = new LoveReplyUserPOExample();
        loveReplyUserPOExample.createCriteria().andReplyIdEqualTo(replyPOId);
        List<LoveReplyUserPO> loveReplyUserPOS = loveReplyUserPOMapper.selectByExample(loveReplyUserPOExample);
        for (LoveReplyUserPO loveReplyUserPO : loveReplyUserPOS) {
            loveReplyUserPOMapper.deleteByPrimaryKey(loveReplyUserPO.getReplyUserId());
        }
    }

    /**
     * 根据回复ID找用户（去重）
     *
     * @param replyListPO 根据回复信息获取回复ID
     * @return
     */
    public Set<UserPO> getUserVOSetByReplyListPO(ReplyListPO replyListPO) {
        LoveReplyUserPOExample loveReplyUserPOExample = new LoveReplyUserPOExample();
        loveReplyUserPOExample.createCriteria().andReplyIdEqualTo(replyListPO.getReplyId());
        List<LoveReplyUserPO> loveReplyUserPOS = loveReplyUserPOMapper.selectByExample(loveReplyUserPOExample);
        Set<UserPO> userPOSet = new HashSet<>();
        for (LoveReplyUserPO loveReplyUserPO : loveReplyUserPOS) {
            userPOSet.add(userPOServiceV2.getUserPOByUserId(loveReplyUserPO.getUserId()));
        }
        return userPOSet;
    }
}
