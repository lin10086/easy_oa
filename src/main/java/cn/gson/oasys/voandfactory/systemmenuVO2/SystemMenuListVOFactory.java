package cn.gson.oasys.voandfactory.systemmenuVO2;

import cn.gson.oasys.modelV2.po.SysMenuPO;

import java.util.ArrayList;
import java.util.List;

public class SystemMenuListVOFactory {
    public static SystemMenuVO createSystemMenuVOBySysMenuPO(SysMenuPO sysMenuPO) {
        SystemMenuVO systemMenuVO = new SystemMenuVO();
        systemMenuVO.setMenuId(sysMenuPO.getMenuId());
        systemMenuVO.setIsShow(sysMenuPO.getIsShow() == 0 ? false : true);
        systemMenuVO.setMenuGrade(sysMenuPO.getMenuGrade());
        systemMenuVO.setMenuIcon(sysMenuPO.getMenuIcon());
        systemMenuVO.setMenuName(sysMenuPO.getMenuName());
        systemMenuVO.setMenuUrl(sysMenuPO.getMenuUrl());
        systemMenuVO.setParentId(sysMenuPO.getParentId());
        systemMenuVO.setSortId(sysMenuPO.getSortId());
        return systemMenuVO;
    }

    public static List<SystemMenuVO> createSystemMenuVOListBySysMenuPOList(List<SysMenuPO> sysMenuPOList) {
        List<SystemMenuVO> systemMenuVOList = new ArrayList<>();
        for (SysMenuPO sysMenuPO : sysMenuPOList) {
            systemMenuVOList.add(SystemMenuListVOFactory.createSystemMenuVOBySysMenuPO(sysMenuPO));
        }
        return systemMenuVOList;
    }
}
