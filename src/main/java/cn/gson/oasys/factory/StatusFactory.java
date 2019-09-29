package cn.gson.oasys.factory;

import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.StatusPO;
import cn.gson.oasys.model.po.TypePO;
import cn.gson.oasys.model.po.UserPO;

import java.util.ArrayList;
import java.util.List;

public class StatusFactory {
    public static SystemStatusList create(StatusPO statusPO){
        SystemStatusList systemStatusList = new SystemStatusList();
        systemStatusList.setStatusId(statusPO.getStatusId());
        systemStatusList.setStatusColor(statusPO.getStatusColor());
        systemStatusList.setStatusModel(statusPO.getStatusModel());
        systemStatusList.setStatusName(statusPO.getStatusName());
        systemStatusList.setStatusPrecent(statusPO.getSortPrecent());
        systemStatusList.setStatusSortValue(statusPO.getSortValue());
        return systemStatusList;
    }
    public static List<SystemStatusList>createStatus(List<StatusPO>statusPOList){
        List<SystemStatusList>statusLists = new ArrayList<>();

        for(int i=0;i<=statusPOList.size();i++){
           statusLists.add(StatusFactory.create(statusPOList.get(i)));
        }
        return statusLists;
    }

}
