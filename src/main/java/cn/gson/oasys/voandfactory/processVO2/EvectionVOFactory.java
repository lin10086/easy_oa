package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.EvectionPO;

import java.util.ArrayList;
import java.util.List;

public class EvectionVOFactory {

    public static EvectionVO createEvectionVO(EvectionPO evectionPO) {
        EvectionVO evectionVO = new EvectionVO();
        evectionVO.setEvectionId(evectionPO.getEvectionId());
        evectionVO.setTypeId(evectionPO.getTypeId());
        evectionVO.setPersonnelAdvice(evectionPO.getPersonnelAdvice());
//        private ProcessListVO ProcessListVO;//主表pro_id
        evectionVO.setManagerAdvice(evectionPO.getManagerAdvice());
        return evectionVO;
    }

    public static List<EvectionVO> createEvectionVOList(List<EvectionPO> evectionPOList) {
        List<EvectionVO> evectionVOList = new ArrayList<>();
        for (EvectionPO evectionPO : evectionPOList) {
            evectionVOList.add(EvectionVOFactory.createEvectionVO(evectionPO));
        }
        return evectionVOList;
    }


}
