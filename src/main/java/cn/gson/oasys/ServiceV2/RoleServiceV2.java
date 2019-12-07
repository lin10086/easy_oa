package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.RoleFactory;
import cn.gson.oasys.mappers.RolePOMapper;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.role.Rolepowerlist;
import cn.gson.oasys.model.entity.system.SystemMenu;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.RolePOExample;
import cn.gson.oasys.model.po.SysMenuPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class RoleServiceV2 {
    @Resource
    private RolePOMapper rolePOMapper;

    /**
     * 插入角色信息
     *
     * @param rolePO
     */
    public void insertRolePO(RolePO rolePO) {
        rolePOMapper.insertSelective(rolePO);
    }

    /**
     * 根据角色ID删除角色信息
     *
     * @param roleId
     */
    public void deleteRolePOByRoleId(Long roleId) {
        rolePOMapper.deleteByPrimaryKey(roleId);
    }

    /**
     * 修改角色信息
     *
     * @param rolePO
     */
    public RolePO updateOrInsertRolePO(RolePO rolePO, Long rolePOId) {
        if (rolePOId != null) {// id存在就更新
            rolePOMapper.updateByPrimaryKeySelective(rolePO);
            return rolePO;
        } else {
            rolePOMapper.insertSelective(rolePO);
            return rolePO;
        }
    }

    /**
     * 获取所有角色列表
     *
     * @return
     */
    public List<RolePO> getRoleListAll() {
        RolePOExample rolePOExample = new RolePOExample();
        List<RolePO> rolePOList = rolePOMapper.selectByExample(rolePOExample);
        return rolePOList;
    }

    /**
     * 根据角色名模糊查找角色列表
     *
     * @param val
     * @return
     */
    public List<RolePO> getRoleListByRoleNameLike(String val) {
        RolePOExample rolePOExample = new RolePOExample();
        rolePOExample.createCriteria().andRoleNameLike("%" + val + "%");
        List<RolePO> rolePOList = rolePOMapper.selectByExample(rolePOExample);
        return rolePOList;
    }


    /**
     * 根据角色ID获取角色信息
     *
     * @param roleId 角色ID
     * @return
     */
    public RolePO getRoleByRoleId(Long roleId) {
        RolePO rolePO = rolePOMapper.selectByPrimaryKey(roleId);
        return rolePO;
    }


}
