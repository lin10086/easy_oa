package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.RoleFactory;
import cn.gson.oasys.mappers.RolePOMapper;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.RolePOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class RoleServiceV2 {
    @Resource
    private RolePOMapper rolePOMapper;
    public List<Role> getRoleList(){
        RolePOExample rolePOExample = new RolePOExample();
        List<RolePO>rolePOList = rolePOMapper.selectByExample(rolePOExample);
        List<Role>roleList = RoleFactory.create(rolePOList);
        return roleList;
    }
//根据角色ID获取角色信息
    public Role getRoleByRoleId(Long roleId){
        RolePO rolePO = rolePOMapper.selectByPrimaryKey(roleId);
        Role role =RoleFactory.create(rolePO);
        return role;
    }
}
