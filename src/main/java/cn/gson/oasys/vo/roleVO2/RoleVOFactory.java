package cn.gson.oasys.vo.roleVO2;

import cn.gson.oasys.model.po.RolePO;

import java.util.ArrayList;
import java.util.List;

public class RoleVOFactory {

    public static RoleVO createRoleVO(RolePO rolePO){
        RoleVO roleVO = new RoleVO();
        roleVO.setRoleId(rolePO.getRoleId());
        roleVO.setRoleName(rolePO.getRoleName());
        roleVO.setRoleValue(rolePO.getRoleValue());
        return roleVO;
    }
    public static List<RoleVO>createRoleVOList(List<RolePO>rolePOList){
        List<RoleVO>roleVOList = new ArrayList<>();
        for(RolePO rolePO: rolePOList){
            roleVOList.add(RoleVOFactory.createRoleVO(rolePO));
        }
        return roleVOList;
    }
}
