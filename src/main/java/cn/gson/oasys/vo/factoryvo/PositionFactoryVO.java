package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.vo.PositionVO;

import java.util.ArrayList;
import java.util.List;

public class PositionFactoryVO {

    public static PositionVO createPositionVO(PositionPO positionPO){
        PositionVO positionVO =new PositionVO();
        positionVO.setPositionId(positionPO.getPositionId());
        positionVO.setPositionName(positionPO.getName());
        positionVO.setPositionLevel(positionPO.getLevel());
        positionVO.setPositionDescription(positionPO.getDescribtion());
        positionVO.setDeptId(positionPO.getDeptid());
        return positionVO;
    }

    public  static List<PositionVO> createPositionVOList(List<PositionPO>positionPOList){
        List<PositionVO>positionVOList = new ArrayList<>();
        for(PositionPO positionPO : positionPOList){
            positionVOList.add(PositionFactoryVO.createPositionVO(positionPO));
        }
        return positionVOList;
    }
    //把V转换为PO
    public static PositionPO createPositionPO(PositionVO positionVO){
        PositionPO positionPO = new PositionPO();
        positionPO.setPositionId(positionVO.getPositionId());
        positionPO.setDeptid(positionVO.getDeptId());
        positionPO.setLevel(positionVO.getPositionLevel());
        positionPO.setName(positionVO.getPositionName());
        positionPO.setDescribtion(positionVO.getPositionDescription());
        return positionPO;
    }
}
