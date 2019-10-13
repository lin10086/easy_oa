package cn.gson.oasys.factory;

import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.po.RolePO;

import java.util.ArrayList;
import java.util.List;

public class RoleFactory {
    //角色工厂:把自己定义的角色转换为本来的角色
    public static Role create(RolePO rolePO){
        Role role = new Role();
        role.setRoleId(rolePO.getRoleId());
        role.setRoleName(rolePO.getRoleName());
        role.setRoleValue(rolePO.getRoleValue());
        return role;
    }

    public static List<Role> create(List<RolePO>rolePOList){
        List<Role>roleList = new ArrayList<>();
        for(RolePO rolePO : rolePOList){
            roleList.add(RoleFactory.create(rolePO));
        }
        return roleList;
    }
}
