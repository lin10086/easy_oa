package cn.gson.oasys.serviceV2.processServiceV2;

import cn.gson.oasys.mappers.ReviewedPOMapper;
import cn.gson.oasys.model.po.ReviewedPO;
import cn.gson.oasys.model.po.ReviewedPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReviewedServiceV2 {
    @Resource
    private ReviewedPOMapper reviewedPOMapper;


    /**
     * 根据审核表里的用户ID找审核列表
     *
     * @param userId
     * @return
     */
    public List<ReviewedPO> getReviewedPOListByUserId(Long userId) {
        ReviewedPOExample reviewedPOExample = new ReviewedPOExample();
        reviewedPOExample.setOrderByClause("status_id DESC");
        reviewedPOExample.createCriteria().andUserIdEqualTo(userId).andDelEqualTo(0);
        List<ReviewedPO> reviewedPOList = reviewedPOMapper.selectByExample(reviewedPOExample);
        return reviewedPOList;
    }
}
