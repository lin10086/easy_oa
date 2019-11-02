package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.DetailsbursePO;
import cn.gson.oasys.vo.DetailsReimburseVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DetailsBurseFactoryVO {
    public static DetailsReimburseVO createDetailsBurseVO(DetailsbursePO detailsbursePO) {
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

    public static List<DetailsReimburseVO> createDetailsBurseVOList(List<DetailsbursePO> detailsbursePOList) {
        List<DetailsReimburseVO> detailsBurseVOList = new ArrayList<>();
        for (DetailsbursePO detailsbursePO : detailsbursePOList) {
            detailsBurseVOList.add(DetailsBurseFactoryVO.createDetailsBurseVO(detailsbursePO));
        }
        return detailsBurseVOList;
    }
}
