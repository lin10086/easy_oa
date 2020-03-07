package cn.gson.oasys.serviceV2.systemV2;

import cn.gson.oasys.serviceV2.rolemanage.RolePowerListServiceV2;
import cn.gson.oasys.mappers.SysMenuPOMapper;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.systemmenuVO2.SystemMenuListFactoryVO;
import cn.gson.oasys.vo.roleVO2.RolePowerMenuVO;
import cn.gson.oasys.vo.systemmenuVO2.SystemMenuVO;
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
     * 更新或插入菜单信息
     *
     * @param sysMenuPO 菜单信息
     * @return
     */
    public SysMenuPO insertOrUpdateSysMenuPOId(SysMenuPO sysMenuPO) {
        if (sysMenuPO.getMenuId() != null) {
            sysMenuPOMapper.updateByPrimaryKeySelective(sysMenuPO);
        } else {
            sysMenuPOMapper.insertSelective(sysMenuPO);
        }
        return sysMenuPO;
    }

    /**
     * 根据菜单ID删除菜单删除菜单信息
     *
     * @param menuId 菜单ID
     */
    public void deleteSysMenuPOBySysMenuPOId(Long menuId) {
        sysMenuPOMapper.deleteByPrimaryKey(menuId);
    }


    /**
     * 根据菜单ID该变自己的排序值
     *
     * @param menuId 菜单ID
     * @param num    1上移或-1下移
     * @param sortId 排序值
     * @return
     */
    public Integer updateSystemMenuIdBySortId(Long menuId, Integer num, Integer sortId) {
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andMenuIdEqualTo(menuId);
        SysMenuPO sysMenuPO = new SysMenuPO();
        sysMenuPO.setSortId(sortId - num);
        Integer rows = sysMenuPOMapper.updateByExampleSelective(sysMenuPO, sysMenuPOExample);
        return rows;
    }

    /**
     * 该变其他排序值
     *
     * @param parentId 父级ID
     * @param num      上移下移
     * @param sortId   排序值
     * @return
     */
    public Integer updateSystemMenuIdBySortIdAndParentId(Long parentId, Integer num, Integer sortId) {
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdEqualTo(parentId).andSortIdEqualTo(sortId - num);
        SysMenuPO sysMenuPO = new SysMenuPO();
        sysMenuPO.setSortId(sortId);
        Integer rows = sysMenuPOMapper.updateByExampleSelective(sysMenuPO, sysMenuPOExample);
        return rows;
    }

    /**
     * 所有的父级菜单
     */
    public List<SystemMenuVO> oneSysMenuVOListAll(Long parentId) {
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdEqualTo(parentId);//parentId是0就是父级菜单
        sysMenuPOExample.setOrderByClause("sort_id ASC");
        List<SysMenuPO> oneSysMenuPOListAll = sysMenuPOMapper.selectByExample(sysMenuPOExample);
        List<SystemMenuVO> oneSysMenuVOListAll = SystemMenuListFactoryVO.createSystemMenuVOList(oneSysMenuPOListAll);
        return oneSysMenuVOListAll;
    }

    /**
     * 所有的子菜单
     */
    public List<SystemMenuVO> twoSysMenuVOListAll(Long parentId) {
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdNotEqualTo(parentId);//parentId不是0就是父级菜单
        sysMenuPOExample.setOrderByClause("sort_id ASC");
        List<SysMenuPO> twoSysMenuPOListAll = sysMenuPOMapper.selectByExample(sysMenuPOExample);
        List<SystemMenuVO> twoSysMenuVOListAll = SystemMenuListFactoryVO.createSystemMenuVOList(twoSysMenuPOListAll);
        return twoSysMenuVOListAll;
    }

    /**
     * 根据菜单名模糊查找菜单(范围：所有菜单）
     *
     * @param name 模糊字
     * @return
     */
    public List<SystemMenuVO> getSystemMenuVOListByMenuNameLikeAll(String name) {
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andMenuNameLike("%" + name + "%");
        List<SysMenuPO> sysMenuPOListAll = sysMenuPOMapper.selectByExample(sysMenuPOExample);
        List<SystemMenuVO> sysMenuVOListAll = SystemMenuListFactoryVO.createSystemMenuVOList(sysMenuPOListAll);
        return sysMenuVOListAll;
    }

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
        List<RolePowerListPO> rolePowerListPOS = rolePowerListServiceV2.getRolePowerListPOSByRoleId(roleId);//根据角色ID找出的角色权限信息
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
     * 根据菜单ID找菜单信息
     *
     * @param menuId 菜单ID
     * @return
     */
    public SysMenuPO getSystemMenuPOByMenuId(Long menuId) {
        SysMenuPO sysMenuPO = sysMenuPOMapper.selectByPrimaryKey(menuId);
        return sysMenuPO;
    }


    /**
     * 找可见角色的父级菜单
     *
     * @param parentId 父级ID
     * @param roleId   角色ID
     * @param isShow   是否可见
     * @return
     */
    public List<RolePowerMenuVO> getSysMenuPOListByParentByIsShow(Long parentId, Long roleId, Boolean isShow, HttpServletRequest request) {
        //根据角色ID和是否可见找角色权限列表
        List<RolePowerListPO> rolePowerListPOS = rolePowerListServiceV2.getRolePowerListPOSByRoleIdAndIsShow(roleId, isShow);
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdEqualTo(parentId).andIsShowEqualTo(isShow == false ? 0 : 1);
        sysMenuPOExample.setOrderByClause("sort_id ASC");
        List<SysMenuPO> sysMenuPOList = sysMenuPOMapper.selectByExample(sysMenuPOExample);//根据菜单的父级ID和是否可见找出可见的菜单的信息
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
        if (parentId.equals(0L)) {
            request.setAttribute("oneMenuAll", rolePowerMenuVOS);
        }
        return rolePowerMenuVOS;

    }

    /**
     * 模糊查找找可见角色的父级菜单
     *
     * @param parentId
     * @param roleId
     * @param isShow
     * @param request
     * @param name
     * @return
     */
    public List<RolePowerMenuVO> getSysMenuPOListByParentByIsShowAndMenuNameLike(Long parentId, Long roleId, Boolean isShow, HttpServletRequest request, String name) {
        List<RolePowerListPO> rolePowerListPOS = rolePowerListServiceV2.getRolePowerListPOSByRoleIdAndIsShow(roleId, isShow);//根据角色ID找出的角色信息
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdEqualTo(parentId).andIsShowEqualTo(isShow == false ? 0 : 1).andMenuNameLike("%" + name + "%");
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
        request.setAttribute("oneMenuAll", rolePowerMenuVOS);
        return rolePowerMenuVOS;

    }


    /**
     * 找可见角色的子菜单
     *
     * @param parentId
     * @param roleId
     * @param isShow
     * @return
     */
    public List<RolePowerMenuVO> getSysMenuPOListBySonIsShow(Long parentId, Long roleId, Boolean isShow, HttpServletRequest request) {
        List<RolePowerListPO> rolePowerListPOS = rolePowerListServiceV2.getRolePowerListPOSByRoleIdAndIsShow(roleId, isShow);//根据角色ID找出的角色信息
        SysMenuPOExample sysMenuPOExample = new SysMenuPOExample();
        sysMenuPOExample.createCriteria().andParentIdNotEqualTo(parentId);
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
        request.setAttribute("twoMenuAll", rolePowerMenuVOS);
        return rolePowerMenuVOS;
    }


}
