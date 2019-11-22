package cn.gson.oasys.vo.factoryvo.planFactory;

import cn.gson.oasys.model.po.PlanListPO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.planVO2.PlanListVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PlanListVOFactory {
    public static PlanListVO createPlanListVO(PlanListPO planListPO) {
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

    public static List<PlanListVO> createPlanListVOS(List<PlanListPO> planListPOS) {
        List<PlanListVO> planListVOS = new ArrayList<>();
        for (PlanListPO planListPO : planListPOS) {
            planListVOS.add(PlanListVOFactory.createPlanListVO(planListPO));
        }
        return planListVOS;
    }
}
