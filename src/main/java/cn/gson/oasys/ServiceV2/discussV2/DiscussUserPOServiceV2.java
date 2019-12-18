package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.LoveDiscussUserPOMapper;
import cn.gson.oasys.model.po.DiscussListPO;
import cn.gson.oasys.model.po.LoveDiscussUserPO;
import cn.gson.oasys.model.po.LoveDiscussUserPOExample;
import cn.gson.oasys.model.po.UserPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DiscussUserPOServiceV2 {
    @Resource
    private LoveDiscussUserPOMapper loveDiscussUserPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;


    /**
     * 根据讨论表ID在中间表找讨论的用户
     *
     * @param discussListPO
     * @return
     */
    public Set<UserPO> getSetUserPOByDiscussListPOId(DiscussListPO discussListPO) {
        LoveDiscussUserPOExample loveDiscussUserPOExample = new LoveDiscussUserPOExample();
        loveDiscussUserPOExample.createCriteria().andDiscussIdEqualTo(discussListPO.getDiscussId());
        List<LoveDiscussUserPO> loveDiscussUserPOS = loveDiscussUserPOMapper.selectByExample(loveDiscussUserPOExample);
        Set<UserPO> userPOSet = new HashSet<>();
        for (LoveDiscussUserPO loveDiscussUserPO : loveDiscussUserPOS) {
            userPOSet.add(userServiceV2.getUserPOByUserId(loveDiscussUserPO.getUserId()));
        }
        return userPOSet;
    }

}
