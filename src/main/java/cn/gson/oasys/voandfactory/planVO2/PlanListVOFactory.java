package cn.gson.oasys.voandfactory.planVO2;

import cn.gson.oasys.modelV2.po.PlanListPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PlanListVOFactory {
    public static PlanListVO createPlanListVOByPlanListPO(PlanListPO planListPO) {
        PlanListVO planListVO = new PlanListVO();
        planListVO.setPlanId(planListPO.getPlanId());
        planListVO.setTypeId(planListPO.getTypeId());
        planListVO.setStatusId(planListPO.getStatusId());
        planListVO.setAttachmentId(planListPO.getAttachId());
        planListVO.setStartTime(new Timestamp(planListPO.getStartTime().getTime()));
        planListVO.setEndTime(new Timestamp(planListPO.getEndTime().getTime()));
        planListVO.setCreateTime(new Timestamp(planListPO.getCreateTime().getTime()));
        planListVO.setTitle(planListPO.getTitle());
        planListVO.setLabel(planListPO.getLabel());
        planListVO.setPlanContent(planListPO.getPlanContent());
        planListVO.setPlanSummary(planListPO.getPlanSummary());
        planListVO.setPlanComment(planListPO.getPlanComment());
        return planListVO;
    }

    public static List<PlanListVO> createPlanListVOSByPlanListPOS(List<PlanListPO> planListPOS) {
        List<PlanListVO> planListVOS = new ArrayList<>();
        for (PlanListPO planListPO : planListPOS) {
            planListVOS.add(PlanListVOFactory.createPlanListVOByPlanListPO(planListPO));
        }
        return planListVOS;
    }
}
