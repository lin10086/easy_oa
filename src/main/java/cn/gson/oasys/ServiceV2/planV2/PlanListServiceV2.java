package cn.gson.oasys.ServiceV2.planV2;

import cn.gson.oasys.mappers.PlanListPOMapper;
import cn.gson.oasys.model.po.PlanListPO;
import cn.gson.oasys.model.po.PlanListPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanListServiceV2 {
    @Resource
    private PlanListPOMapper planListPOMapper;

    /**
     * 根据用户id找用户在根据记录创建时间排序模糊查询未完成
     *
     * @param userId
     * @return
     */
//    public List<PlanListPO> getPlanListPOSByUserId(Long userId) {
//        PlanListPOExample planListPOExample = new PlanListPOExample();
//        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
//        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
//
//        return planListPOS;
//    }

//    public List<PlanListPO> getPlanListPOSByUserIdAndBaseKey(String basekey, List<PlanListPO>planListPOS) {
//        PlanListPOExample planListPOExample = new PlanListPOExample();
//
//        List<PlanListPO> planListPOList = planListPOMapper.selectByExample(planListPOExample);
//
//        return planListPOS;
//    }

    /**
     * 根据用户id找用户在根据类型排序
     * @param typeId
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOSByUserIdAndTypeId(String typeId, Long userId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
        planListPOExample.setOrderByClause(typeId);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据用户id找用户在根据记录状态排序
     * @param statusId
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOSByUserIdAndStatusId(String statusId, Long userId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
        planListPOExample.setOrderByClause(statusId);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     *根据用户id找用户在根据记录创建时间排序
     * @param createTime
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOByUserIdAndCreateTime(String createTime, Long userId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
        planListPOExample.setOrderByClause(createTime);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

}
