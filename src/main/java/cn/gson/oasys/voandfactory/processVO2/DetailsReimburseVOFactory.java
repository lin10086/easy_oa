package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.DetailsbursePO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DetailsReimburseVOFactory {
    public static DetailsReimburseVO createDetailsReimburseVOByDetailsbursePO(DetailsbursePO detailsbursePO) {
        DetailsReimburseVO detailsBurseVO = new DetailsReimburseVO();
        detailsBurseVO.setDetailsReimburseVOId(detailsbursePO.getDetailsburseId());
        detailsBurseVO.setDescript(detailsbursePO.getDescript());
        detailsBurseVO.setDetailMoney(detailsbursePO.getDetailmoney());
        detailsBurseVO.setInvoices(detailsbursePO.getInvoices());
        detailsBurseVO.setProduceTime(new Timestamp(detailsbursePO.getProduceTime().getTime()));
        detailsBurseVO.setSubject(detailsbursePO.getSubject());
        //关联费用报销表bursement
        return detailsBurseVO;
    }

    public static List<DetailsReimburseVO> createDetailsReimburseVOListByDetailsbursePOList(List<DetailsbursePO> detailsbursePOList) {
        List<DetailsReimburseVO> detailsBurseVOList = new ArrayList<>();
        for (DetailsbursePO detailsbursePO : detailsbursePOList) {
            detailsBurseVOList.add(DetailsReimburseVOFactory.createDetailsReimburseVOByDetailsbursePO(detailsbursePO));
        }
        return detailsBurseVOList;
    }
}
