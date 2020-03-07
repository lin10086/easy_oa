package cn.gson.oasys.vo.statusVO2;

import cn.gson.oasys.model.po.StatusPO;

import java.util.ArrayList;
import java.util.List;

public class StatusVOFactory {

    public static StatusVO createStatusVOByStatusPO(StatusPO statusPO) {
        StatusVO statusVO = new StatusVO();
        statusVO.setStatusId(statusPO.getStatusId());
        statusVO.setStatusColor(statusPO.getStatusColor());
        statusVO.setStatusModel(statusPO.getStatusModel());
        statusVO.setStatusName(statusPO.getStatusName());
        statusVO.setStatusPercent(statusPO.getSortPrecent());
        statusVO.setStatusSortValue(statusPO.getSortValue());
        return statusVO;
    }

    public static List<StatusVO> createStatusVOListByStatusPOList(List<StatusPO> statusPOList) {
        List<StatusVO> statusVOList = new ArrayList<>();
        for (StatusPO statusPO : statusPOList) {
            statusVOList.add(StatusVOFactory.createStatusVOByStatusPO(statusPO));
        }
        return statusVOList;
    }
}
