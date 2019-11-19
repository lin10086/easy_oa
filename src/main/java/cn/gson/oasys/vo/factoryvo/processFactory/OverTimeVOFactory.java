package cn.gson.oasys.vo.factoryvo.processFactory;

import cn.gson.oasys.model.po.OvertimePO;
import cn.gson.oasys.vo.processVO2.OverTimeVO;

import java.util.ArrayList;
import java.util.List;

public class OverTimeVOFactory {

    public static OverTimeVO createOverTimeVO(OvertimePO overtimePO) {
        OverTimeVO overTimeVO = new OverTimeVO();
        overTimeVO.setOvertimeId(overtimePO.getOvertimeId());
        overTimeVO.setTypeId(overtimePO.getTypeId());
//    private ProcessListVO processListVO;//流程主表ID（pro_id）
        overTimeVO.setPersonnelAdvice(overtimePO.getPersonnelAdvice());
        overTimeVO.setManagerAdvice(overtimePO.getManagerAdvice());
        return overTimeVO;
    }

    public static List<OverTimeVO> createOverTimeVOList(List<OvertimePO> overtimePOList) {
        List<OverTimeVO> overTimeVOList = new ArrayList<>();
        for (OvertimePO overtimePO : overtimePOList) {
            overTimeVOList.add(OverTimeVOFactory.createOverTimeVO(overtimePO));
        }
        return overTimeVOList;
    }


}
