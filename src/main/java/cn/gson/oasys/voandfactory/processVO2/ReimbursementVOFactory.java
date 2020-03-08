package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.BursementPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ReimbursementVOFactory {
    public static ReimbursementVO createReimbursementVOByBursementPO(BursementPO bursementPO) {
        ReimbursementVO bursementVO = new ReimbursementVO();

        bursementVO.setReimbursementId(bursementPO.getBursementId());
        bursementVO.setAllinvoices(bursementPO.getAllinvoices());
        bursementVO.setAllMoney(bursementPO.getAllMoney());
        bursementVO.setReimbursementTime(new Timestamp(bursementPO.getBurseTime().getTime()));
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

    public static List<ReimbursementVO> createReimbursementVOListByBursementPOList(List<BursementPO> bursementPOList) {
        List<ReimbursementVO> bursementVOList = new ArrayList<>();
        for (BursementPO bursementPO : bursementPOList) {
            bursementVOList.add(ReimbursementVOFactory.createReimbursementVOByBursementPO(bursementPO));
        }
        return bursementVOList;
    }
}


