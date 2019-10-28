package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.BursementPO;
import cn.gson.oasys.vo.BursementVO;

import java.util.ArrayList;
import java.util.List;

public class BursementFactoryVO {
    public static BursementVO createBursementVO(BursementPO bursementPO) {
        BursementVO bursementVO = new BursementVO();

        bursementVO.setBursementId(bursementPO.getBursementId());
        bursementVO.setAllinvoices(bursementPO.getAllinvoices());
        bursementVO.setAllMoney(bursementPO.getAllMoney());
        bursementVO.setBurseTime(bursementPO.getBurseTime());
        bursementVO.setFinancialAdvice(bursementPO.getFinancialAdvice());
        bursementVO.setManagerAdvice(bursementPO.getManagerAdvice());
        bursementVO.setName(bursementPO.getName());
        bursementVO.setTypeId(bursementPO.getTypeId());
        bursementVO.setFinancialAdvice(bursementPO.getFinancialAdvice());

        //审核人员名
        //承担主体
        //费用报销明细表
        //主表
        //报销人员
        //证明人
        return bursementVO;
    }

    public static List<BursementVO> createBursementVOList(List<BursementPO> bursementPOList) {
        List<BursementVO> bursementVOList = new ArrayList<>();
        for (BursementPO bursementPO : bursementPOList) {
            bursementVOList.add(BursementFactoryVO.createBursementVO(bursementPO));
        }
        return bursementVOList;
    }
}


