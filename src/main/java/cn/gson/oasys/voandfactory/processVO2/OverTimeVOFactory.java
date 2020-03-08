package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.OvertimePO;

import java.util.ArrayList;
import java.util.List;

public class OverTimeVOFactory {

    public static OverTimeVO createOverTimeVOByOvertimePO(OvertimePO overtimePO) {
        OverTimeVO overTimeVO = new OverTimeVO();
        overTimeVO.setOvertimeId(overtimePO.getOvertimeId());
        overTimeVO.setTypeId(overtimePO.getTypeId());
//    private ProcessListVO processListVO;//流程主表ID（pro_id）
        overTimeVO.setPersonnelAdvice(overtimePO.getPersonnelAdvice());
        overTimeVO.setManagerAdvice(overtimePO.getManagerAdvice());
        return overTimeVO;
    }

    public static List<OverTimeVO> createOverTimeVOListByOvertimePOList(List<OvertimePO> overtimePOList) {
        List<OverTimeVO> overTimeVOList = new ArrayList<>();
        for (OvertimePO overtimePO : overtimePOList) {
            overTimeVOList.add(OverTimeVOFactory.createOverTimeVOByOvertimePO(overtimePO));
        }
        return overTimeVOList;
    }


}
