package cn.gson.oasys.factory;

import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.PositionPOExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class PositionFactory {
    public static Position create(PositionPO positionPO){
        Position position =new Position();
        position.setId(positionPO.getPositionId());
        position.setName(positionPO.getName());
        position.setLevel(positionPO.getLevel());
        position.setDescribtion(positionPO.getDescribtion());
        position.setDeptid(positionPO.getDeptid());
        return position;
    }

    public  static List<Position> create(List<PositionPO>positionPOList){
        List<Position>positionList = new ArrayList<>();
        for(PositionPO positionPO : positionPOList){
            positionList.add(PositionFactory.create(positionPO));
        }
        return positionList;
    }

}
