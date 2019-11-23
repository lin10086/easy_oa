package cn.gson.oasys.ServiceV2.planV2;

import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.PlanListPOMapper;
import cn.gson.oasys.model.po.PlanListPO;
import cn.gson.oasys.model.po.PlanListPOExample;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanListServiceV2 {
    @Resource
    private PlanListPOMapper planListPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private StatusServiceV2 statusServiceV2;

    /**
     * 根据用户id找用户在根据记录创建时间排序模糊查询未完成
     *
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOSByUserIdAndBaseKey(Long userId, String baseKey) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId).andLabelLike("%" + baseKey + "%");
        PlanListPOExample.Criteria criteria1 = planListPOExample.createCriteria().andTitleLike("%" + baseKey + "%").andPlanUserIdEqualTo(userId);

        //根据类型名模糊查找
        List<Long> longList = typeServiceV2.getTypePOIdByTypeName("%" + baseKey + "%");
        PlanListPOExample.Criteria criteria2 = planListPOExample.createCriteria().andPlanUserIdEqualTo(userId).
                andTypeIdIn(longList);
        //根据状态名模糊查找
        PlanListPOExample.Criteria criteria3 = planListPOExample.createCriteria().andPlanUserIdEqualTo(userId).
                andStatusIdIn(statusServiceV2.getStatusPOIdListByStatusName("%" + baseKey + "%"));
        if (criteria1 != null) {
            planListPOExample.or(criteria1);
        }
        if (longList.size() > 0) {
            planListPOExample.or(criteria2);

        }
        if (statusServiceV2.getStatusPOIdListByStatusName("%" + baseKey + "%").size() > 0) {
            planListPOExample.or(criteria3);
        }
//        PlanListPOExample.Criteria criteria3 = planListPOExample.createCriteria().andLabelLike("%" + baseKey + "%");
//        planListPOExample.or().andLabelLike("%" + baseKey + "%");
//        planListPOExample.or().andTitleLike("%" + baseKey + "%");

        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据用户id找计划列表
     *
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOSByUserId(Long userId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据用户id找用户在根据类型排序
     *
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
     *
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
     * 根据用户id找用户在根据记录创建时间排序
     *
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
