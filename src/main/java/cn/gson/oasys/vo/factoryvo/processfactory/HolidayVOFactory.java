package cn.gson.oasys.vo.factoryvo.processfactory;

import cn.gson.oasys.model.po.HolidayPO;
import cn.gson.oasys.vo.processV2.HolidayVO;

import java.util.ArrayList;
import java.util.List;

public class HolidayVOFactory {
    public static HolidayVO createHolidayVO(HolidayPO holidayPO) {
        HolidayVO holidayVO = new HolidayVO();
        holidayVO.setHolidayId(holidayPO.getHolidayId());
        holidayVO.setTypeId(holidayPO.getTypeId());
        holidayVO.setLeaveDays(holidayPO.getLeaveDays());
//    private ProcessListVO processListVO;//流程主表ID（pro_id）
        holidayVO.setPersonnelAdvice(holidayPO.getPersonnelAdvice());
        holidayVO.setManagerAdvice(holidayPO.getManagerAdvice());
        return holidayVO;
    }

    public static List<HolidayVO> createHolidayVOList(List<HolidayPO> holidayPOList) {
        List<HolidayVO> holidayVOList = new ArrayList<>();
        for (HolidayPO holidayPO : holidayPOList) {
            holidayVOList.add(HolidayVOFactory.createHolidayVO(holidayPO));
        }
        return holidayVOList;
    }
}










