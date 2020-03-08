package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.HolidayPO;

import java.util.ArrayList;
import java.util.List;

public class HolidayVOFactory {
    public static HolidayVO createHolidayVOByHolidayPO(HolidayPO holidayPO) {
        HolidayVO holidayVO = new HolidayVO();
        holidayVO.setHolidayId(holidayPO.getHolidayId());
        holidayVO.setTypeId(holidayPO.getTypeId());
        holidayVO.setLeaveDays(holidayPO.getLeaveDays());
//    private ProcessListVO processListVO;//流程主表ID（pro_id）
        holidayVO.setPersonnelAdvice(holidayPO.getPersonnelAdvice());
        holidayVO.setManagerAdvice(holidayPO.getManagerAdvice());
        return holidayVO;
    }

    public static List<HolidayVO> createHolidayVOListByHolidayPOList(List<HolidayPO> holidayPOList) {
        List<HolidayVO> holidayVOList = new ArrayList<>();
        for (HolidayPO holidayPO : holidayPOList) {
            holidayVOList.add(HolidayVOFactory.createHolidayVOByHolidayPO(holidayPO));
        }
        return holidayVOList;
    }
}










