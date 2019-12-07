package cn.gson.oasys.ServiceV2.rolemanage;

import cn.gson.oasys.mappers.RolePowerListPOMapper;
import cn.gson.oasys.model.entity.role.Rolepowerlist;
import cn.gson.oasys.model.po.RolePowerListPO;
import cn.gson.oasys.model.po.RolePowerListPOExample;
import cn.gson.oasys.model.po.SysMenuPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RolePowerListServiceV2 {
    @Resource
    private RolePowerListPOMapper rolePowerListPOMapper;

    /**
     * 根据角色ID和菜单ID插入角色权限信息
     *
     * @param sysMenuPOList
     * @param rolePOId
     */
    public void insertRolePowerListPO(List<SysMenuPO> sysMenuPOList, Long rolePOId) {
        for (SysMenuPO sysMenuPO : sysMenuPOList) {
            RolePowerListPO rolePowerListPO = new RolePowerListPO();
            rolePowerListPO.setMenuId(sysMenuPO.getMenuId());
            rolePowerListPO.setRoleId(rolePOId);
            rolePowerListPO.setIsShow(0);
            rolePowerListPOMapper.insertSelective(rolePowerListPO);
        }
    }

    /**
     * 更新角色表的权限
     *
     * @param rolePowerListPO
     * @param check
     */
    public void updateRolePowerListPO(RolePowerListPO rolePowerListPO, int check) {
        rolePowerListPO.setIsShow(check);
        rolePowerListPOMapper.updateByPrimaryKeySelective(rolePowerListPO);
    }


    /**
     * 根据角色ID找角色的权限信息
     *
     * @param roleId 角色ID
     * @return
     */
    public List<RolePowerListPO> getRolePowerListPOSByRoleId(Long roleId) {
        RolePowerListPOExample rolePowerListPOExample = new RolePowerListPOExample();
        rolePowerListPOExample.createCriteria().andRoleIdEqualTo(roleId);
        List<RolePowerListPO> rolePowerListPOS = rolePowerListPOMapper.selectByExample(rolePowerListPOExample);
        return rolePowerListPOS;
    }

    /**
     * 根据角色ID和菜单ID找角色权限
     *
     * @param roleId
     * @param menuId
     * @return
     */
    public RolePowerListPO getRolePowerListPOSByRoleIdAndMenuId(Long roleId, Long menuId) {
        RolePowerListPOExample rolePowerListPOExample = new RolePowerListPOExample();
        rolePowerListPOExample.createCriteria().andRoleIdEqualTo(roleId).andMenuIdEqualTo(menuId);
        List<RolePowerListPO> rolePowerListPOS = rolePowerListPOMapper.selectByExample(rolePowerListPOExample);
        if (rolePowerListPOS.size() > 0) {
            return rolePowerListPOS.get(0);
        }
        return null;
    }
}
