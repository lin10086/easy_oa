package cn.gson.oasys.controller.system;

import cn.gson.oasys.serviceV2.roleV2.RoleServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.rolemanage.RolePowerListServiceV2;
import cn.gson.oasys.serviceV2.systemV2.SystemMenuServiceV2;
import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.SysMenuPO;
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

/**
 * 系统管理》菜单管理
 */
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
    private UserPOServiceV2 userPOServiceV2;

    /**
     * 显示菜单管理界面(所有的父菜单和子菜单）
     *
     * @param req
     * @return
     */
    @RequestMapping("testsysmenu")
    public String systemMenuAll(HttpServletRequest req) {
        getOneSystemVOListAndTwoSystemVOList(req);
        return "systemcontrol/menumanage";
    }

    /**
     * 根据菜单名模糊查找菜单(范围：所有菜单）
     */
    @RequestMapping("menutable")
    public String menuTable(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getParameter("name"))) {//模糊字是否存在
            String name = req.getParameter("name");
            List<SystemMenuVO> systemMenuVOListByMenuNameLikeLike = systemMenuServiceV2.getSystemMenuVOListByMenuNameLikeAll(name);//根据菜单名模糊查找
            req.setAttribute("oneMenuAll", systemMenuVOListByMenuNameLikeLike);
        } else {
            getOneSystemVOListAndTwoSystemVOList(req);
        }
        return "systemcontrol/menutable";
    }

    /**
     * 找父级菜单和字菜单
     *
     * @param req
     */
    public void getOneSystemVOListAndTwoSystemVOList(HttpServletRequest req) {
        List<SystemMenuVO> oneSysMenuVOListAll = systemMenuServiceV2.oneSysMenuVOListAll(0L);//所有父菜单
        List<SystemMenuVO> twoSysMenuVOListAll = systemMenuServiceV2.twoSysMenuVOListAll(0L);//所有子菜单
        req.setAttribute("oneMenuAll", oneSysMenuVOListAll);
        req.setAttribute("twoMenuAll", twoSysMenuVOListAll);
    }


    /**
     * 菜单管理的删除
     *
     * @return
     */
    @RequestMapping("deletethis")
    public String deleteSystemMenu(HttpServletRequest req) {
        Long menuId = Long.parseLong(req.getParameter("id"));//菜单ID
        rolePowerListServiceV2.deleteRolePowerListPOByMenuId(menuId);//根据菜单ID删除角色权限信息
        systemMenuServiceV2.deleteSysMenuPOBySysMenuPOId(menuId);//根据菜单ID删除菜单删除菜单信息
        return "forward:/testsysmenu";
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

        List<SystemMenuVO> oneSysMenuVOListAll = systemMenuServiceV2.oneSysMenuVOListAll(0L);//所有父级菜单
        req.setAttribute("parentList", oneSysMenuVOListAll);
        HttpSession session = req.getSession();
        session.removeAttribute("menuId");//菜单ID
        if (!StringUtils.isEmpty(req.getParameter("id"))) {
            Long menuId = Long.parseLong(req.getParameter("id"));//菜单ID
            SysMenuPO sysMenuPO = systemMenuServiceV2.getSystemMenuPOByMenuId(menuId);//根据菜单ID找菜单信息
            if (!StringUtils.isEmpty(req.getParameter("add"))) {//父级菜单中的新增
                String getName = sysMenuPO.getMenuName();//父级菜单名
                req.setAttribute("getAdd", menuId);//菜单ID
                req.setAttribute("getName", getName);//父级菜单名
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
            sysMenuPO.setIsShow(systemMenuVO.getIsShow() == false ? 0 : 1);//菜单是否显示
            sysMenuPO.setMenuGrade(systemMenuVO.getMenuGrade());//权限制分数
            sysMenuPO.setMenuIcon(systemMenuVO.getMenuIcon());//菜单图标
            sysMenuPO.setMenuName(systemMenuVO.getMenuName());//菜单名
            sysMenuPO.setMenuUrl(systemMenuVO.getMenuUrl());//菜单链接
            sysMenuPO.setParentId(systemMenuVO.getParentId());//父级ID
            sysMenuPO.setSortId(systemMenuVO.getSortId());//排序值
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
        Integer num = Integer.parseInt(req.getParameter("num"));//上移1，下移-1
        systemMenuServiceV2.updateSystemMenuIdBySortIdAndParentId(parentId, num, sortId);//改变其他排序值
        systemMenuServiceV2.updateSystemMenuIdBySortId(menuId, num, sortId);//改变自己的排序值
//        systemMenuServiceV2.getSysMenuPOListBySonIsShow(0L, userPO.getRoleId(), true, req);
//        systemMenuServiceV2.getSysMenuPOListByParentByIsShow(0L, userPO.getRoleId(), true, req);
        return "redirect:/testsysmenu";
    }

}
