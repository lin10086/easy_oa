package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.DetailsbursePO;
import cn.gson.oasys.vo.DetailsBurseVO;

import java.util.ArrayList;
import java.util.List;

public class DetailsBurseFactoryVO {
    public static DetailsBurseVO createDetailsBurseVO(DetailsbursePO detailsbursePO) {
        DetailsBurseVO detailsBurseVO = new DetailsBurseVO();
        detailsBurseVO.setDetailsBurseId(detailsbursePO.getDetailsburseId());
        detailsBurseVO.setDescript(detailsbursePO.getDescript());
        detailsBurseVO.setDetailMoney(detailsbursePO.getDetailmoney());
        detailsBurseVO.setInvoices(detailsbursePO.getInvoices());
        detailsBurseVO.setProduceTime(detailsbursePO.getProduceTime());
        detailsBurseVO.setSubject(detailsbursePO.getSubject());
        //关联费用报销表bursement
        return detailsBurseVO;
    }

    public static List<DetailsBurseVO> createDetailsBurseVOList(List<DetailsbursePO> detailsbursePOList) {
        List<DetailsBurseVO> detailsBurseVOList = new ArrayList<>();
        for (DetailsbursePO detailsbursePO : detailsbursePOList) {
            detailsBurseVOList.add(DetailsBurseFactoryVO.createDetailsBurseVO(detailsbursePO));
        }
        return detailsBurseVOList;
    }
}
