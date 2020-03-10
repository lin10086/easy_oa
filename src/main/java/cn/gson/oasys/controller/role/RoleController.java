package cn.gson.oasys.controller.role;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.gson.oasys.serviceV2.roleV2.RolePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.rolemanage.RolePowerListServiceV2;
import cn.gson.oasys.serviceV2.systemV2.SystemMenuServiceV2;
import cn.gson.oasys.modelV2.bo.PageBO;
import cn.gson.oasys.modelV2.po.RolePO;
import cn.gson.oasys.modelV2.po.RolePowerListPO;
import cn.gson.oasys.modelV2.po.SysMenuPO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.voandfactory.roleVO2.RoleVO;
import cn.gson.oasys.voandfactory.roleVO2.RolePowerMenuVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;

/**
 * 角色列表》角色管理
 */
@Controller
@RequestMapping("/")
public class RoleController {

    @Resource
    private RolePOServiceV2 rolePOServiceV2;
    @Resource
    private SystemMenuServiceV2 systemMenuServiceV2;
    @Resource
    private RolePowerListServiceV2 rolePowerListServiceV2;
    @Resource
    private UserPOServiceV2 userPOServiceV2;

    /**
     * 角色管理主页面
     *
     * @param page 第几页
     * @param size 每页大小
     * @return
     */
    @RequestMapping("rolemanage")
    public String roleManage(@RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             Model model) {
        List<RolePO> rolePOList = rolePOServiceV2.getRoleListAll();//所有角色信息
        getRolePOListPage(page, size, rolePOList, model);
        return "role/rolemanage";
    }

    /**
     * 角色列表的分页信息
     *
     * @param page       第几页
     * @param size       每页大小
     * @param rolePOList 角色列表
     * @param model
     * @return
     */
    private List<RolePO> getRolePOListPage(int page, int size, List<RolePO> rolePOList, Model model) {
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(rolePOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > rolePOList.size()) {
            end = rolePOList.size();
        }
        List<RolePO> subRolePOList = rolePOList.subList(start, end);
        model.addAttribute("page", pageBO);
        model.addAttribute("rolelist", subRolePOList);
        model.addAttribute("url", "roleser");
        return subRolePOList;
    }

    /**
     * 模糊搜索
     */
    @RequestMapping("roleser")
    public String roleLike(HttpServletRequest req, Model model,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size) {
        List<RolePO> rolePOList;
        String val = null;//搜索输入的内容
        if (!StringUtil.isEmpty(req.getParameter("val"))) {
            val = req.getParameter("val").trim();
        }

        if (!StringUtil.isEmpty(val)) {
            rolePOList = rolePOServiceV2.getRoleListByRoleNameLike(val);
            model.addAttribute("sort", "&val=" + val);//记录了模糊字，&val用于连接页码和模糊字
        } else {
            rolePOList = rolePOServiceV2.getRoleListAll();
        }
        getRolePOListPage(page, size, rolePOList, model);
        return "role/roletable";
    }

    /**
     * 进入新增或修改角色
     *
     * @return
     */
    @RequestMapping("addrole")
    public String addRole(HttpServletRequest req, Model model) {
        RolePO rolePO = new RolePO();
        if (!StringUtil.isEmpty(req.getParameter("id"))) {
            Long rolePOId = Long.parseLong(req.getParameter("id"));
            rolePO = rolePOServiceV2.getRoleByRoleId(rolePOId);
        }
        model.addAttribute("role", rolePO);
        return "role/addrole";
    }

    /**
     * 新增，修改角色确定
     *
     * @return
     */
    @RequestMapping("modifyrole")
    public String modifyOrAddRole(HttpServletRequest req, @Valid RoleVO roleVO, BindingResult br) {
        Long rolePOId = null;
        if (!StringUtil.isEmpty(req.getParameter("id"))) {
            rolePOId = Long.parseLong(req.getParameter("id"));//角色ID
        }
        if (rolePOId != null) {
            RolePO rolePO = rolePOServiceV2.getRoleByRoleId(rolePOId);
            rolePO.setRoleName(roleVO.getRoleName());
            rolePO.setRoleValue(roleVO.getRoleValue());
            rolePOServiceV2.updateOrInsertRolePO(rolePO, rolePOId);//更新角色信息
        } else {
            RolePO rolePO = new RolePO();
            rolePO.setRoleName(roleVO.getRoleName());
            rolePO.setRoleValue(roleVO.getRoleValue());
            RolePO newRolePO = rolePOServiceV2.updateOrInsertRolePO(rolePO, null);//插入角色信息
            List<SysMenuPO> sysMenuPOList = systemMenuServiceV2.getSysMenuPOAll();//所有菜单
            rolePowerListServiceV2.insertRolePowerListPOBySystemMenuPOListAndRolePOId(sysMenuPOList, newRolePO.getRoleId());//插入角色权限信息
        }
        return "redirect:/rolemanage";
    }

    /**
     * 设定角色权限的显示信息
     *
     * @return
     */
    @RequestMapping("roleset")
    public String roleSet(HttpServletRequest req, Model model) {
        Long roleId = Long.parseLong(req.getParameter("id"));
        RolePO rolePO = rolePOServiceV2.getRoleByRoleId(roleId);
        List<RolePowerMenuVO> oneRolePowerMenuVO = systemMenuServiceV2.getSysMenuPOListByParentAll(0L, roleId);
        List<RolePowerMenuVO> twoRolePowerMenuVO = systemMenuServiceV2.getSysMenuPOListBySonAll(0L, roleId);
        model.addAttribute("oneMenuAll", oneRolePowerMenuVO);//一级菜单
        model.addAttribute("twoMenuAll", twoRolePowerMenuVO);//二级菜单
        model.addAttribute("roleid", roleId);//角色ID
        model.addAttribute("rolename", rolePO.getRoleName());//角色名
        return "role/roleset";

    }

    /**
     * 权限设定
     */
    @RequestMapping("powerss")
    @ResponseBody
    public Boolean power(HttpServletRequest req) {
        Long roleId = Long.parseLong(req.getParameter("roleid"));//角色ID
        String content = req.getParameter("content").trim();//是否选中
        Long menuId = Long.parseLong(req.getParameter("menuid"));//菜单ID
//        根据角色ID和菜单ID找角色权限
        RolePowerListPO rolePowerListPO = rolePowerListServiceV2.getRolePowerListPOSByRoleIdAndMenuId(roleId, menuId);
        int check;
        if (content.equals("选中")) {
            check = 1;
        } else {
            check = 0;
        }
        rolePowerListServiceV2.updateRolePowerListPO(rolePowerListPO, check);//更新角色表的权限
        return true;
    }

    /**
     * 删除
     */
    @RequestMapping("deshan")
    public String deleteRole(HttpServletRequest req, Model model, HttpSession session) {
        Long userId = Long.parseLong(((String) session.getAttribute("userId")).trim());//用户ID
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);//用户信息
        Long roleId = null;
        if (!StringUtil.isEmpty(req.getParameter("id"))) {//角色ID是否存在
            roleId = Long.parseLong(req.getParameter("id"));
        }
        Boolean isSuperman = userPO.getSuperman() == 0 ? false : true;//是否是超级管理员
        if (isSuperman.equals(true)) {//只有超级管理员才能删除角色信息
            List<UserPO> userPOList = userPOServiceV2.getUserPoListByRoleId(roleId);//根据角色ID找用户列表
            if (userPOList.size() > 0) {
                model.addAttribute("error", "此角色下还有职员，不允许删除。");
                return "common/proce";
            } else {
                //角色下没有职员，则可以直接删除角色
                rolePOServiceV2.deleteRolePOByRoleId(roleId);
            }
        } else {
            model.addAttribute("error", "只有超级管理员才能操作。");
            return "common/proce";
        }
        return null;
    }


}
