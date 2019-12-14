package cn.gson.oasys.controller.system;

import cn.gson.oasys.ServiceV2.RoleServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.ServiceV2.rolemanage.RolePowerListServiceV2;
import cn.gson.oasys.ServiceV2.systemV2.SystemMenuServiceV2;
import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.RolePowerListPO;
import cn.gson.oasys.model.po.SysMenuPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.systemmenuVO2.SystemMenuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class MenuSysController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private SystemMenuServiceV2 systemMenuServiceV2;
    @Resource
    private RoleServiceV2 roleServiceV2;
    @Resource
    private RolePowerListServiceV2 rolePowerListServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;

    /**
     * 显示菜单管理界面(所有的父菜单和子菜单）
     *
     * @param req
     * @return
     */
    @RequestMapping("testsysmenu")
    public String systemMenuAll(HttpServletRequest req) {
        List<SystemMenuVO> oneSysMenuVOListAll = systemMenuServiceV2.oneSysMenuVOListAll(0L);//所有父菜单
        List<SystemMenuVO> twoSysMenuVOListAll = systemMenuServiceV2.twoSysMenuVOListAll(0L);//所有子菜单
        req.setAttribute("oneMenuAll", oneSysMenuVOListAll);
        req.setAttribute("twoMenuAll", twoSysMenuVOListAll);
        return "systemcontrol/menumanage";
    }


    /**
     * 菜单管理的编辑界面
     *
     * @param req
     * @return
     */
    @RequestMapping("menuedit")
    public String menuEdit(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getAttribute("errormess"))) {
            req.setAttribute("errormess", req.getAttribute("errormess"));
        }
        if (!StringUtils.isEmpty(req.getAttribute("success"))) {
            req.setAttribute("success", req.getAttribute("success"));
        }

        List<SystemMenuVO> oneSysMenuVOListAll = systemMenuServiceV2.oneSysMenuVOListAll(0L);//父级菜单
        req.setAttribute("parentList", oneSysMenuVOListAll);
        HttpSession session = req.getSession();
        session.removeAttribute("menuId");//菜单ID
        if (!StringUtils.isEmpty(req.getParameter("id"))) {//id存在代表菜单中的修改，新增，删除
            Long menuId = Long.parseLong(req.getParameter("id"));//菜单ID
            SysMenuPO sysMenuPO = systemMenuServiceV2.getSystemMenuPOByMenuId(menuId);//菜单信息
            if (!StringUtils.isEmpty(req.getParameter("add"))) {//父级菜单中的新增
                String getName = sysMenuPO.getMenuName();//父级菜单名
                req.setAttribute("getAdd", menuId);//菜单ID
                req.setAttribute("getName", getName);//菜单名
            } else {//菜单中的修改
                Boolean isShow = sysMenuPO.getIsShow() == 0 ? false : true;

                session.setAttribute("menuId", menuId);//菜单ID
                req.setAttribute("menuObj", sysMenuPO);//菜单信息
                req.setAttribute("isShow", isShow);//菜单信息
            }
        }
        return "systemcontrol/menuedit";
    }

    /**
     * 系统管理表单验证
     *
     * @param req
     * @param systemMenuVO
     * @param br           后台校验表单数据，不通过则回填数据，显示错误信息；通过则直接执行业务，例如新增、编辑等；
     * @return
     */
    @RequestMapping("tablereceive")
    public String tableReceive(HttpServletRequest req, @Valid SystemMenuVO systemMenuVO, BindingResult br) {
        HttpSession session = req.getSession();
        Long menuId = null;
//        req.setAttribute("menuObj", systemMenuVO);
        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        // 校验失败
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
        } else {// 校验通过，下面写自己的逻辑业务
            // 判断是否从编辑界面进来的，前面有"session.setAttribute("getId",getId);",在这里获取，并remove掉；
            SysMenuPO sysMenuPO = new SysMenuPO();
            sysMenuPO.setIsShow(systemMenuVO.getIsShow() == false ? 0 : 1);
            sysMenuPO.setMenuGrade(systemMenuVO.getMenuGrade());
            sysMenuPO.setMenuIcon(systemMenuVO.getMenuIcon());
            sysMenuPO.setMenuName(systemMenuVO.getMenuName());
            sysMenuPO.setMenuUrl(systemMenuVO.getMenuUrl());
            sysMenuPO.setParentId(systemMenuVO.getParentId());
            sysMenuPO.setSortId(systemMenuVO.getSortId());
            if (!StringUtils.isEmpty(session.getAttribute("getId"))) {//修改
                menuId = (Long) session.getAttribute("getId"); // 获取进入编辑界面的menuID值
                systemMenuVO.setMenuId(menuId);
                session.removeAttribute("menuId");
                sysMenuPO.setMenuId(systemMenuVO.getMenuId());
                systemMenuServiceV2.insertOrUpdateSysMenuPOId(sysMenuPO);
            } else {
                //执行新增 的代码；
                SysMenuPO sysMenuPO1 = systemMenuServiceV2.insertOrUpdateSysMenuPOId(sysMenuPO);
                List<RolePO> rolePOListAll = roleServiceV2.getRoleListAll();// 所有角色信息
                for (RolePO rolePO : rolePOListAll) {
                    if (rolePO.getRoleId() == 1) {//超级管理员
                        RolePowerListPO rolePowerListPO = new RolePowerListPO();
                        rolePowerListPO.setRoleId(rolePO.getRoleId());
                        rolePowerListPO.setIsShow(1);
                        rolePowerListPO.setMenuId(sysMenuPO.getMenuId());
                        rolePowerListServiceV2.insertRolePowerListPOByIsShowAndMenuIdAndRoleId(true, sysMenuPO1.getMenuId(), rolePO.getRoleId());
                    } else {
                        rolePowerListServiceV2.insertRolePowerListPOByIsShowAndMenuIdAndRoleId(false, sysMenuPO1.getMenuId(), rolePO.getRoleId());
                    }
                }
            }
            //执行业务代码
            req.setAttribute("success", "后台验证成功");
        }
        return "forward:/menuedit";
    }


    /**
     * 菜单管理的删除
     *
     * @return
     */
    @RequestMapping("deletethis")
    public String deleteSystemMenu(HttpServletRequest req) {
        Long menuId = Long.parseLong(req.getParameter("id"));
        rolePowerListServiceV2.deleteRolePowerListPOByMenuId(menuId);
        systemMenuServiceV2.deleteSysMenuPOBySysMenuPOId(menuId);
        return "forward:/testsysmenu";
    }

    /**
     * 查找菜单
     */
    @RequestMapping("menutable")
    public String menuTable(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getParameter("name"))) {
            //根据菜单名模糊查找
            String name = req.getParameter("name");
            List<SystemMenuVO> systemMenuVOListByMenuNameLikeLike = systemMenuServiceV2.getSystemMenuVOListByMenuNameLike(name);
            req.setAttribute("oneMenuAll", systemMenuVOListByMenuNameLikeLike);
        } else {
            List<SystemMenuVO> oneSysMenuVOListAll = systemMenuServiceV2.oneSysMenuVOListAll(0L);//所有父菜单
            List<SystemMenuVO> twoSysMenuVOListAll = systemMenuServiceV2.twoSysMenuVOListAll(0L);//所有子菜单
            req.setAttribute("oneMenuAll", oneSysMenuVOListAll);
            req.setAttribute("twoMenuAll", twoSysMenuVOListAll);
        }
        return "systemcontrol/menutable";
    }


    /**
     * 改变排序
     *
     * @param req
     * @return
     */
    @RequestMapping("changeSortId")
    public String changeSortId(HttpServletRequest req, @SessionAttribute("userId") Long userId) {
        Long parentId = Long.parseLong(req.getParameter("parentid"));//父级ID
        Long menuId = Long.parseLong(req.getParameter("menuid"));//菜单ID
        Integer sortId = Integer.parseInt(req.getParameter("sortid"));//排序值
        Integer arithNum = Integer.parseInt(req.getParameter("num"));//上移1，下移-1
        systemMenuServiceV2.updateSystemMenuIdBySortIdAndParentId(parentId, arithNum, sortId);
        systemMenuServiceV2.updateSystemMenuIdBySortId(menuId, arithNum, sortId);
//        systemMenuServiceV2.getSysMenuPOListBySonIsShow(0L, userPO.getRoleId(), true, req);
//        systemMenuServiceV2.getSysMenuPOListByParentByIsShow(0L, userPO.getRoleId(), true, req);
        return "redirect:/testsysmenu";
    }

}
