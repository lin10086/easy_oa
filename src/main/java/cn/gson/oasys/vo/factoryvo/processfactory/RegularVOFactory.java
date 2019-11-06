package cn.gson.oasys.vo.factoryvo.processfactory;

import cn.gson.oasys.model.po.RegularPO;
import cn.gson.oasys.vo.processV2.RegularVO;

import java.util.ArrayList;
import java.util.List;

public class RegularVOFactory {
    public static RegularVO createRegularVO(RegularPO regularPO) {
        RegularVO regularVO = new RegularVO();
        regularVO.setRegularId(regularPO.getRegularId());
        regularVO.setExperience(regularPO.getExperience());
        regularVO.setUnderstand(regularPO.getUnderstand());
        regularVO.setPullulate(regularPO.getPullulate());
        regularVO.setDeficiency(regularPO.getDeficiency());
        regularVO.setDobetter(regularPO.getDobetter());
        regularVO.setDays(regularPO.getDays());
        regularVO.setPersonnelAdvice(regularPO.getPersonnelAdvice());
        regularVO.setAdvice(regularPO.getAdvice());
        regularVO.setManagerAdvice(regularPO.getManagerAdvice());
//        private ProcessListVO processListVO;//流程主表ID（pro_id）
        return regularVO;
    }

    public static List<RegularVO> createRegularVOList(List<RegularPO> regularPOListr) {
        List<RegularVO> regularVOList = new ArrayList<>();
        for (RegularPO regularPO : regularPOListr) {
            regularVOList.add(RegularVOFactory.createRegularVO(regularPO));
        }
        return regularVOList;
    }
}
