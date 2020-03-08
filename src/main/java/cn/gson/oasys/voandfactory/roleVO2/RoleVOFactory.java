package cn.gson.oasys.voandfactory.roleVO2;

import cn.gson.oasys.modelV2.po.RolePO;

import java.util.ArrayList;
import java.util.List;

public class RoleVOFactory {

    public static RoleVO createRoleVOByRolePO(RolePO rolePO){
        RoleVO roleVO = new RoleVO();
        roleVO.setRoleId(rolePO.getRoleId());
        roleVO.setRoleName(rolePO.getRoleName());
        roleVO.setRoleValue(rolePO.getRoleValue());
        return roleVO;
    }
    public static List<RoleVO> createRoleVOListRolePOList(List<RolePO>rolePOList){
        List<RoleVO>roleVOList = new ArrayList<>();
        for(RolePO rolePO: rolePOList){
            roleVOList.add(RoleVOFactory.createRoleVOByRolePO(rolePO));
        }
        return roleVOList;
    }
}
