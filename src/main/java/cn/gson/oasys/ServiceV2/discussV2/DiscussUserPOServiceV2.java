package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.LoveDiscussUserPOMapper;
import cn.gson.oasys.model.po.DiscussListPO;
import cn.gson.oasys.model.po.LoveDiscussUserPO;
import cn.gson.oasys.model.po.LoveDiscussUserPOExample;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.UserVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Iterator;
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
    public Set<UserPO> getUserVOSetByDiscussListPO(DiscussListPO discussListPO) {
        LoveDiscussUserPOExample loveDiscussUserPOExample = new LoveDiscussUserPOExample();
        loveDiscussUserPOExample.createCriteria().andDiscussIdEqualTo(discussListPO.getDiscussId());
        List<LoveDiscussUserPO> loveDiscussUserPOS = loveDiscussUserPOMapper.selectByExample(loveDiscussUserPOExample);
        Set<UserPO> userPOSet = new HashSet<>();
        for (LoveDiscussUserPO loveDiscussUserPO : loveDiscussUserPOS) {
            userPOSet.add(userServiceV2.getUserPOByUserId(loveDiscussUserPO.getUserId()));
        }
        return userPOSet;
    }

    /**
     * 插入一条点赞信息（即点赞）
     *
     * @param userId          用户ID
     * @param discussListPOId 讨论表ID
     */
    public void insertLoveDiscussUserPOByUserIdAndDiscussListPOId(Long userId, Long discussListPOId) {
        LoveDiscussUserPO loveDiscussUserPO = new LoveDiscussUserPO();
        loveDiscussUserPO.setDiscussId(discussListPOId);
        loveDiscussUserPO.setUserId(userId);
        loveDiscussUserPOMapper.insertSelective(loveDiscussUserPO);
    }

    /**
     * 根据讨论ID和用户ID获取讨论点赞表ID，通过点赞表ID删除信息（即取消点赞）
     *
     * @param userId          用户ID
     * @param discussListPOId 讨论ID
     */
    public void deleteLoveDiscussUserPOByUserIdAndDiscussListPOId(Long userId, Long discussListPOId) {
        LoveDiscussUserPOExample loveDiscussUserPOExample = new LoveDiscussUserPOExample();
        loveDiscussUserPOExample.createCriteria().andDiscussIdEqualTo(discussListPOId).andUserIdEqualTo(userId);
        List<LoveDiscussUserPO> loveDiscussUserPOS = loveDiscussUserPOMapper.selectByExample(loveDiscussUserPOExample);
        loveDiscussUserPOMapper.deleteByPrimaryKey(loveDiscussUserPOS.get(0).getDiscussUserId());
    }

    /**
     * 删除此讨论的所有点赞（当删除此讨论时）
     *
     * @param discussListPOId 此讨论的ID
     */
    public void deleteLoveDiscussUserPOByiscussListPOId(Long discussListPOId) {
        LoveDiscussUserPOExample loveDiscussUserPOExample = new LoveDiscussUserPOExample();
        loveDiscussUserPOExample.createCriteria().andDiscussIdEqualTo(discussListPOId);
        List<LoveDiscussUserPO> loveDiscussUserPOS = loveDiscussUserPOMapper.selectByExample(loveDiscussUserPOExample);
        for (LoveDiscussUserPO loveDiscussUserPO : loveDiscussUserPOS) {
            loveDiscussUserPOMapper.deleteByPrimaryKey(loveDiscussUserPO.getDiscussUserId());
        }
    }

}
