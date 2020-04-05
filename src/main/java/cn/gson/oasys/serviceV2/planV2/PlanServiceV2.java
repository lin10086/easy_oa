package cn.gson.oasys.serviceV2.planV2;

import cn.gson.oasys.mappers.PlanListPOMapper;
import cn.gson.oasys.modelV2.po.PlanListPO;
import cn.gson.oasys.modelV2.po.PlanListPOExample;
import cn.gson.oasys.voandfactory.planVO2.PlanListVO;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 计划业务
 */
@Service
public class PlanServiceV2 {
    @Resource
    private PlanListPOMapper planListPOMapper;
    @Resource
    PlanListPOServiceV2 planListPOServiceV2;

    /**
     * 分页，排序
     *
     * @param baseKey 模糊字
     * @param userId  用户ID
     * @param type    类型
     * @param status  状态
     * @param time    时间
     * @return
     */
    public List<PlanListPO> sortAndGetPlanListS(String baseKey, long userId, Object type, Object status, Object time) {
        if (!StringUtils.isEmpty(baseKey)) {
            System.out.println("进来了");
            return planListPOServiceV2.getPlanListPOSByUserIdAndBaseKey(userId, baseKey);
        }

        if (!StringUtils.isEmpty(type)) {
            if (type.toString().equals("0")) {
                //降序
                return planListPOServiceV2.getPlanListPOSByUserIdAndTypeId("type_id DESC", userId);
            } else {
                //升序
                return planListPOServiceV2.getPlanListPOSByUserIdAndTypeId("type_id ASC", userId);
            }
        }

        if (!StringUtils.isEmpty(status)) {
            if (status.toString().equals("0")) {
                return planListPOServiceV2.getPlanListPOSByUserIdAndStatusId("status_id DESC", userId);
            } else {
                return planListPOServiceV2.getPlanListPOSByUserIdAndStatusId("status_id ASC", userId);
            }
        }

        if (!StringUtils.isEmpty(time)) {
            if (time.toString().equals("0")) {
                return planListPOServiceV2.getPlanListPOByUserIdAndCreateTime("create_time DESC", userId);
            } else {
                return planListPOServiceV2.getPlanListPOByUserIdAndCreateTime("create_time ASC", userId);
            }
        } else {
            return planListPOServiceV2.getPlanListPOByUserIdAndCreateTime("create_time DESC", userId);
        }

    }

    public List<PlanListPO> dimSelect(int page, String selectTypeName) {
        List<PlanListPO> planListPOS = new ArrayList<>();
        if (!StringUtils.isEmpty(selectTypeName)) {
            return planListPOServiceV2.getPlanListPOSByTypeName(page, selectTypeName);
        }
        return planListPOS;
    }


    /**


    /**
     * 新增计划
     *
     * @param typeId             类型id
     * @param statusId           状态id
     * @param attachmentListPOId 附近id
     * @param start              开始时间
     * @param end                结束时间
     * @param planListVO         从前端接收的数据
     * @param userId             用户id
     * @return
     */
    public PlanListPO insertOrUpdatePlanListPO(Long typeId, Long statusId, Long attachmentListPOId, Date start, Date end, PlanListVO planListVO, Long userId) {
        PlanListPO planListPO = new PlanListPO();
        planListPO.setTypeId(typeId);
        planListPO.setStatusId(statusId);
        planListPO.setAttachId(attachmentListPOId);
        planListPO.setStartTime(start);
        planListPO.setEndTime(end);
        planListPO.setTitle(planListVO.getTitle());
        planListPO.setLabel(planListVO.getLabel());
        planListPO.setPlanContent(planListVO.getPlanContent());
        planListPO.setPlanSummary(planListVO.getPlanSummary());
        planListPO.setPlanComment(planListVO.getPlanComment());
        planListPO.setPlanUserId(userId);
        planListPO.setCreateTime(new Date());
        if (planListVO.getPlanId() != null) {
            planListPO.setPlanId(planListVO.getPlanId());
            planListPOMapper.updateByPrimaryKeySelective(planListPO);
        } else {
            planListPOMapper.insertSelective(planListPO);
        }
        return planListPO;
    }

    /**
     * 修改计划表的附件id
     *
     * @param attachmentId
     * @param planListPO
     */
    public void updateAttachmentIdByPlanListPO(Long attachmentId, PlanListPO planListPO) {
        planListPO.setAttachId(attachmentId);
        planListPOMapper.updateByPrimaryKeySelective(planListPO);
    }

    /**
     * 更新评价
     *
     * @param planListPO
     * @param comment
     */
    public void updatePlanListPOCommentByPlanListPO(PlanListPO planListPO, String comment) {
        if (planListPO.getPlanComment() == null) {
            planListPO.setPlanComment(comment);
        } else {
            planListPO.setPlanComment(planListPO.getPlanComment() + comment);
        }
        planListPOMapper.updateByPrimaryKeySelective(planListPO);
    }



    /**
     * 找出所有计划并按时间排序
     *
     * @return
     */
    public List<PlanListPO> getPlanListPOSAll() {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.setOrderByClause("create_time DESC");
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据用户id，   创建时间>开始时间，<结束时间，类型id,在根据发布时间降序取第一个
     *
     * @param userId
     * @param startTime
     * @param endTime
     * @param typeId
     * @return
     */
    public PlanListPO getPlanListPOByUserIdAndTypeIdAndCreateTime(Long userId, Date startTime, Date endTime, Long typeId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.setOrderByClause("create_time DESC");
        if (startTime == null || endTime == null) {
            return null;
        }
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId).andCreateTimeBetween(startTime, endTime).andTypeIdEqualTo(typeId);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        if (planListPOS.size() == 0) {
            return null;
        }
        return planListPOS.get(0);
    }


}
