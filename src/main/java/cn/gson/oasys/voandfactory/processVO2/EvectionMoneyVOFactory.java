package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.EvectionMoneyPO;

import java.util.ArrayList;
import java.util.List;

public class EvectionMoneyVOFactory {

    public static EvectionMoneyVO createEvectionMoneyVO(EvectionMoneyPO evectionMoneyPO) {
        EvectionMoneyVO evectionMoneyVO = new EvectionMoneyVO();
        evectionMoneyVO.setEvectionMoneyId(evectionMoneyPO.getEvectionmoneyId());
        evectionMoneyVO.setMoney(evectionMoneyPO.getMoney());
        evectionMoneyVO.setName(evectionMoneyPO.getName());
        evectionMoneyVO.setManagerAdvice(evectionMoneyPO.getManagerAdvice());
        evectionMoneyVO.setFinancialAdvice(evectionMoneyPO.getFinancialAdvice());
//        private ProcessList proId;//主表ID（pro_id）
        evectionMoneyVO.setPro(evectionMoneyPO.getProId());
        return evectionMoneyVO;
    }

    public static List<EvectionMoneyVO> createEvectionMoneyVOList(List<EvectionMoneyPO> evectionMoneyPOList) {
        List<EvectionMoneyVO> evectionMoneyVOList = new ArrayList<>();
        for (EvectionMoneyPO evectionMoneyPO : evectionMoneyPOList) {
            evectionMoneyVOList.add(EvectionMoneyVOFactory.createEvectionMoneyVO(evectionMoneyPO));
        }
        return evectionMoneyVOList;
    }

}
