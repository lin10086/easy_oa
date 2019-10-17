package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.vo.RoleVO;

import java.util.ArrayList;
import java.util.List;

public class RoleFactoryVO {

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
            roleVOList.add(RoleFactoryVO.createRoleVO(rolePO));
        }
        return roleVOList;
    }
}
