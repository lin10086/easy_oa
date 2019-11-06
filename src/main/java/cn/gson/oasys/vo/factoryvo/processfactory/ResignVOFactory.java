package cn.gson.oasys.vo.factoryvo.processfactory;

import cn.gson.oasys.model.po.ResignPO;
import cn.gson.oasys.vo.processV2.ResignVO;

import java.util.ArrayList;
import java.util.List;

public class ResignVOFactory {
    public static ResignVO createResignVO(ResignPO resignPO) {
        ResignVO resignVO = new ResignVO();
        resignVO.setResignId(resignPO.getResignId());
        resignVO.setSuggest(resignPO.getSuggest());
        resignVO.setFinish(resignPO.getIsFinish());
//    private UserVO handUserVO; //工作交接人员
        resignVO.setNoFinish(resignPO.getNofinish());
        resignVO.setFinancialAdvice(resignPO.getFinancialAdvice());
        resignVO.setPersonnelAdvice(resignPO.getPersonnelAdvice());
        resignVO.setManagerAdvice(resignPO.getManagerAdvice());
//    private ProcessListVO processListVO;//流程主表ID（pro_id)
//    private String nameUser;//审核人员
//    private String handUser;//交接人员名
        return resignVO;
    }

    public static List<ResignVO> createResignVOList(List<ResignPO> resignPOList) {
        List<ResignVO> resignVOList = new ArrayList<>();
        for (ResignPO resignPO : resignPOList) {
            resignVOList.add(ResignVOFactory.createResignVO(resignPO));
        }
        return resignVOList;
    }


}
