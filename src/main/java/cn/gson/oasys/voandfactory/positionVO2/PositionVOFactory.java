package cn.gson.oasys.voandfactory.positionVO2;

import cn.gson.oasys.modelV2.po.PositionPO;

import java.util.ArrayList;
import java.util.List;

public class PositionVOFactory {

    public static PositionVO createPositionVOByPositionPO(PositionPO positionPO) {
        PositionVO positionVO = new PositionVO();
        positionVO.setPositionId(positionPO.getPositionId());
        positionVO.setPositionName(positionPO.getName());
        positionVO.setPositionLevel(positionPO.getLevel());
        positionVO.setPositionDescription(positionPO.getDescribtion());
        positionVO.setDeptId(positionPO.getDeptid());
        return positionVO;
    }

    public static List<PositionVO> createPositionVOListByPositionPOList(List<PositionPO> positionPOList) {
        List<PositionVO> positionVOList = new ArrayList<>();
        for (PositionPO positionPO : positionPOList) {
            positionVOList.add(PositionVOFactory.createPositionVOByPositionPO(positionPO));
        }
        return positionVOList;
    }

    //把VO转换为PO
    public static PositionPO createPositionPOByPositionVO(PositionVO positionVO) {
        PositionPO positionPO = new PositionPO();
        positionPO.setPositionId(positionVO.getPositionId());
        positionPO.setDeptid(positionVO.getDeptId());
        positionPO.setLevel(positionVO.getPositionLevel());
        positionPO.setName(positionVO.getPositionName());
        positionPO.setDescribtion(positionVO.getPositionDescription());
        return positionPO;
    }
}
