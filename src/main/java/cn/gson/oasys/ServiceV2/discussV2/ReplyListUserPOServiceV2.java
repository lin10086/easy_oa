package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.ServiceV2.UserServiceV2;
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
    private UserServiceV2 userServiceV2;

    /**
     * 根据回复ID找用户（去重）
     *
     * @param replyListPO 根据回复信息获取回复ID
     * @return
     */
    public Set<UserPO> getUserPOSetByReplyListPOId(ReplyListPO replyListPO) {
        LoveReplyUserPOExample loveReplyUserPOExample = new LoveReplyUserPOExample();
        loveReplyUserPOExample.createCriteria().andReplyIdEqualTo(replyListPO.getReplyId());
        List<LoveReplyUserPO> loveReplyUserPOS = loveReplyUserPOMapper.selectByExample(loveReplyUserPOExample);
        Set<UserPO> userPOSet = new HashSet<>();
        for (LoveReplyUserPO loveReplyUserPO : loveReplyUserPOS) {
            userPOSet.add(userServiceV2.getUserPOByUserId(loveReplyUserPO.getUserId()));
        }
        return userPOSet;
    }
}
