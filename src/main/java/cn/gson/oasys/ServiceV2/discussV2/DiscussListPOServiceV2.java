package cn.gson.oasys.ServiceV2.discussV2;

import cn.gson.oasys.mappers.DiscussListPOMapper;
import cn.gson.oasys.model.po.DiscussListPO;
import cn.gson.oasys.model.po.DiscussListPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DiscussListPOServiceV2 {
    @Resource
    private DiscussListPOMapper discussListPOMapper;


    /**
     * 更新访问量
     *
     * @param discussListPO
     * @return
     */
    public DiscussListPO updateDiscussListPOByVisitNum(DiscussListPO discussListPO) {
        discussListPO.setVisitNum(discussListPO.getVisitNum() + 1);
        discussListPOMapper.updateByPrimaryKeySelective(discussListPO);
        return discussListPO;
    }

    /**
     * 根据标题模糊查询
     *
     * @param title 模糊标题
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByTitleLike(String title) {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.createCriteria().andTitleLike("%" + title + "%");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 查找所有讨论列表
     *
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSAll() {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据讨论归属人和标题模糊字找
     *
     * @param userId
     * @param title
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByDiscussUserIdAndTitleLike(Long userId, String title) {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.createCriteria().andDiscussUserIdEqualTo(userId).andTitleLike("%" + title + "%");
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据讨论归属人查找
     *
     * @param userId 讨论归属人ID
     * @return
     */
    public List<DiscussListPO> getDiscussListPOSByDiscussUserId(Long userId) {
        DiscussListPOExample discussListPOExample = new DiscussListPOExample();
        discussListPOExample.createCriteria().andDiscussUserIdEqualTo(userId);
        List<DiscussListPO> discussListPOS = discussListPOMapper.selectByExample(discussListPOExample);
        return discussListPOS;
    }

    /**
     * 根据讨论ID找讨论表信息
     *
     * @param discussPOId 讨论表ID
     * @return
     */
    public DiscussListPO getDiscussListPOSByDiscussPOId(Long discussPOId) {
        DiscussListPO discussListPO = discussListPOMapper.selectByPrimaryKey(discussPOId);
        return discussListPO;
    }


}
