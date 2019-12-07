package cn.gson.oasys.vo.factoryvo.systemmenuFactory;

import cn.gson.oasys.model.po.SysMenuPO;
import cn.gson.oasys.vo.systemmenuVO2.SystemMenuVO;

import java.util.ArrayList;
import java.util.List;

public class SystemMenuListFactoryVO {
    public static SystemMenuVO createSystemMenuVO(SysMenuPO sysMenuPO) {
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

    public static List<SystemMenuVO> createSystemMenuVOList(List<SysMenuPO> sysMenuPOList) {
        List<SystemMenuVO> systemMenuVOList = new ArrayList<>();
        for (SysMenuPO sysMenuPO : sysMenuPOList) {
            systemMenuVOList.add(SystemMenuListFactoryVO.createSystemMenuVO(sysMenuPO));
        }
        return systemMenuVOList;
    }
}
