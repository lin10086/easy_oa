package cn.gson.oasys.ServiceV2.systemV2;

import cn.gson.oasys.ServiceV2.rolemanage.RolePowerListServiceV2;
import cn.gson.oasys.mappers.SysMenuPOMapper;
import cn.gson.oasys.model.entity.role.Rolemenu;
import cn.gson.oasys.model.entity.system.SystemMenu;
import cn.gson.oasys.model.po.RolePowerListPO;
import cn.gson.oasys.model.po.RolePowerListPOExample;
import cn.gson.oasys.model.po.SysMenuPO;
import cn.gson.oasys.model.po.SysMenuPOExample;
import cn.gson.oasys.vo.roleVO2.RolePowerMenuVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class SystemMenuServiceV2 {
    @Resource
    private SysMenuPOMapper sysMenuPOMapper;
    @Resource
    private RolePowerListServiceV2 rolePowerListServiceV2;

    /**
     * 获取所有菜单
     *
     * @return
     */
    public List<SysMenuPO> getSysMenuPOAll() {
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        List<SysMenuPO> sysMenuPOList = sysMenuPOMapper.selectByExample(sysMenuPOExample);
        return sysMenuPOList;
    }

    /**
     * 找角色的父级菜单
     *
     * @param parentId
     * @param roleId
     * @return
     */
    public List<RolePowerMenuVO> getSysMenuPOListByParentAll(Long parentId, Long roleId) {
        List<RolePowerListPO> rolePowerListPOS = rolePowerListServiceV2.getRolePowerListPOSByRoleId(roleId);//根据角色ID找出的角色信息
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdEqualTo(parentId);
        sysMenuPOExample.setOrderByClause("sort_id ASC");
        List<SysMenuPO> sysMenuPOList = sysMenuPOMapper.selectByExample(sysMenuPOExample);//根据菜单的父级ID找出的信息

        List<RolePowerMenuVO> rolePowerMenuVOS = new ArrayList<>();
        for (RolePowerListPO rolePowerListPO : rolePowerListPOS) {
            for (SysMenuPO sysMenuPO : sysMenuPOList) {
                if (rolePowerListPO.getMenuId().equals(sysMenuPO.getMenuId())) {
                    RolePowerMenuVO rolePowerMenuVO = new RolePowerMenuVO();
                    rolePowerMenuVO.setMenuId(sysMenuPO.getMenuId());
                    rolePowerMenuVO.setMenuName(sysMenuPO.getMenuName());
                    rolePowerMenuVO.setMenuUrl(sysMenuPO.getMenuUrl());
                    rolePowerMenuVO.setShow(sysMenuPO.getIsShow() == 0 ? false : true);
                    rolePowerMenuVO.setParentId(sysMenuPO.getParentId());
                    rolePowerMenuVO.setMenuIcon(sysMenuPO.getMenuIcon());
                    rolePowerMenuVO.setSortId(sysMenuPO.getSortId());
                    rolePowerMenuVO.setMenuGrade(sysMenuPO.getMenuGrade());
                    rolePowerMenuVO.setCheck(rolePowerListPO.getIsShow() == 0 ? false : true);
                    rolePowerMenuVOS.add(rolePowerMenuVO);
                }
            }
        }
        return rolePowerMenuVOS;

    }


    /**
     * 找角色的子菜单
     *
     * @param parentId
     * @param roleId
     * @return
     */
    public List<RolePowerMenuVO> getSysMenuPOListBySonAll(Long parentId, Long roleId) {
        List<RolePowerListPO> rolePowerListPOS = rolePowerListServiceV2.getRolePowerListPOSByRoleId(roleId);//根据角色ID找出的角色信息
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdNotEqualTo(parentId);//唯一不同的
        sysMenuPOExample.setOrderByClause("sort_id ASC");
        List<SysMenuPO> sysMenuPOList = sysMenuPOMapper.selectByExample(sysMenuPOExample);//根据菜单的父级ID找出的信息

        List<RolePowerMenuVO> rolePowerMenuVOS = new ArrayList<>();
        for (RolePowerListPO rolePowerListPO : rolePowerListPOS) {
            for (SysMenuPO sysMenuPO : sysMenuPOList) {
                if (rolePowerListPO.getMenuId().equals(sysMenuPO.getMenuId())) {
                    RolePowerMenuVO rolePowerMenuVO = new RolePowerMenuVO();
                    rolePowerMenuVO.setMenuId(sysMenuPO.getMenuId());
                    rolePowerMenuVO.setMenuName(sysMenuPO.getMenuName());
                    rolePowerMenuVO.setMenuUrl(sysMenuPO.getMenuUrl());
                    rolePowerMenuVO.setShow(sysMenuPO.getIsShow() == 0 ? false : true);
                    rolePowerMenuVO.setParentId(sysMenuPO.getParentId());
                    rolePowerMenuVO.setMenuIcon(sysMenuPO.getMenuIcon());
                    rolePowerMenuVO.setSortId(sysMenuPO.getSortId());
                    rolePowerMenuVO.setMenuGrade(sysMenuPO.getMenuGrade());
                    rolePowerMenuVO.setCheck(rolePowerListPO.getIsShow() == 0 ? false : true);
                    rolePowerMenuVOS.add(rolePowerMenuVO);
                }
            }
        }
        return rolePowerMenuVOS;

    }


    /**
     * 父级菜单
     */
    public List<SysMenuPO> oneSysMenuPOListAll(Long parentId) {
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdEqualTo(parentId);
        sysMenuPOExample.setOrderByClause("sort_id ASC");
        List<SysMenuPO> oneSysMenuPOListAll = sysMenuPOMapper.selectByExample(sysMenuPOExample);
        return oneSysMenuPOListAll;
    }

    /**
     * 子菜单
     */
    public List<SysMenuPO> twoSysMenuPOListAll(Long parentId) {
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdNotEqualTo(parentId);
        sysMenuPOExample.setOrderByClause("sort_id ASC");
        List<SysMenuPO> twoSysMenuPOListAll = sysMenuPOMapper.selectByExample(sysMenuPOExample);
        return twoSysMenuPOListAll;
    }

    /**
     * 根据菜单ID找菜单信息
     *
     * @param menuId 菜单ID
     * @return
     */
    public SysMenuPO getSysMenuPOByMenuId(Long menuId) {
        SysMenuPO sysMenuPO = sysMenuPOMapper.selectByPrimaryKey(menuId);
        return sysMenuPO;
    }


}
