package cn.gson.oasys.vo.statusVO2;

import cn.gson.oasys.model.po.StatusPO;

import java.util.ArrayList;
import java.util.List;

public class StatusFactoryVO {
    public static StatusVO createStatusVO(StatusPO statusPO) {
        StatusVO statusVO = new StatusVO();
        statusVO.setStatusId(statusPO.getStatusId());
        statusVO.setStatusName(statusPO.getStatusName());
        statusVO.setStatusSortValue(statusPO.getSortValue());
        statusVO.setStatusModel(statusPO.getStatusModel());
        statusVO.setStatusColor(statusPO.getStatusColor());
        statusVO.setStatusPercent(statusPO.getSortPrecent());
        return statusVO;
    }

    public static List<StatusVO> createStatusVOList(List<StatusPO> statusPOList) {
        List<StatusVO> statusVOList = new ArrayList<>();
        for (StatusPO statusPO : statusPOList) {
            statusVOList.add(StatusFactoryVO.createStatusVO(statusPO));
        }
        return statusVOList;
    }
}


