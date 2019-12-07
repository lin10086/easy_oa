package cn.gson.oasys.controller.role;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.RoleServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.ServiceV2.rolemanage.RolePowerListServiceV2;
import cn.gson.oasys.ServiceV2.systemV2.SystemMenuServiceV2;
import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.RolePowerListPO;
import cn.gson.oasys.model.po.SysMenuPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.RoleVO;
import cn.gson.oasys.vo.roleVO2.RolePowerMenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;

import cn.gson.oasys.model.dao.IndexDao;
import cn.gson.oasys.model.dao.roledao.RoleDao;
import cn.gson.oasys.model.dao.roledao.RolepowerlistDao;

import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.role.Rolemenu;
import cn.gson.oasys.model.entity.role.Rolepowerlist;
import cn.gson.oasys.model.entity.system.SystemMenu;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.role.RoleService;
import cn.gson.oasys.services.system.MenuSysService;

@Controller
@RequestMapping("/")
public class RoleController {

    @Autowired
    private RoleDao rdao;
    @Autowired
    private MenuSysService menuService;
    @Autowired
    private UserDao udao;
    @Autowired
    private IndexDao iDao;
    @Autowired
    private RoleService rservice;
    @Autowired
    private RolepowerlistDao rpdao;


    /**
     * 角色管理
     * @return
     */
/*	@RequestMapping("rolemanage")
	public ModelAndView index(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "10") int size){
		Pageable pa=new PageRequest(page, size);
		ModelAndView mav=new ModelAndView("role/rolemanage");
		Page<Role> pagerole=rdao.findAll(pa);
		List<Role>  rolelist=pagerole.getContent();
		mav.addObject("page", pagerole);
		mav.addObject("rolelist", rolelist);
		mav.addObject("url", "roleser");
		return mav;
	}*/

    /**
     * 进入新增角色
     *
     * @return
     */
   /* @RequestMapping("addrole")
    public String index3(HttpServletRequest req, Model model) {
        String id = null;
        Role role = new Role();

        if (!StringUtil.isEmpty(req.getParameter("id"))) {
            id = req.getParameter("id");
            Long lid = Long.parseLong(id);
            role = rdao.findOne(lid);

        }
        model.addAttribute("role", role);
        return "role/addrole";
    }*/

    /**
     * 新增，修改角色确定
     *
     * @return
     */
 /*   @RequestMapping("modifyrole")
    public String index4(HttpServletRequest req, @Valid Role role, BindingResult br) {
        String id = null;
        if (!StringUtil.isEmpty(req.getParameter("id"))) {
            id = req.getParameter("id");
        }
        if (!StringUtil.isEmpty(id)) {
            Long lid = Long.parseLong(id);
            Role roles = rdao.findOne(lid);
            roles.setRoleName(role.getRoleName());
            rdao.save(roles);

        } else {
            Role rolep = rdao.save(role);
            List<SystemMenu> menulist = iDao.findall();
            rservice.index(menulist, rolep);
        }
        return "redirect:/rolemanage";
    }*/

    /**
     * 设定角色权限
     *
     * @return
     */
/*   @RequestMapping("roleset")
    public String index2(HttpServletRequest req, Model model) {

        Long roleid = Long.parseLong(req.getParameter("id"));

        Role role = rdao.findOne(roleid);
        List<Rolemenu> oneMenuAll = rpdao.findbyparentall(0L, roleid);//14
        List<Rolemenu> twoMenuAll = rpdao.findbyparents(0L, roleid);//34

        model.addAttribute("oneMenuAll", oneMenuAll);
        model.addAttribute("twoMenuAll", twoMenuAll);
        model.addAttribute("roleid", roleid);
        model.addAttribute("rolename", role.getRoleName());
        return "role/roleset";

    }*/

    /**
     * 权限设定
     *//*
    @RequestMapping("powerss")
    public @ResponseBody
    Boolean power(HttpServletRequest req) {
        Long roleid = Long.parseLong(req.getParameter("roleid"));
        String content = req.getParameter("content").trim();
        Long menuid = Long.parseLong(req.getParameter("menuid"));
        Rolepowerlist rolepower = rpdao.findbyroleidandmenuid(roleid, menuid);
        System.out.println(rolepower);
        if (content.equals("选中")) {
            rolepower.setCheck(true);
            System.out.println("xuanzhong");
        } else {
            rolepower.setCheck(false);
            System.out.println("not ok");
        }

        rservice.sava(rolepower);
        return true;
    }
*/

    /*  *//**
     * 删除
     *//*
    @RequestMapping("deshan")
    public String index5(HttpServletRequest req, Model model, HttpSession session) {
        String userId = ((String) session.getAttribute("userId")).trim();
        Long userid = Long.parseLong(userId);
        User user = udao.findOne(userid);
        String id = null;
        if (!StringUtil.isEmpty(req.getParameter("id"))) {
            id = req.getParameter("id");

        }
        Long lid = Long.parseLong(id);
        if (user.getSuperman().equals(true)) {
            List<User> useist = udao.findrole(lid);
            if (useist.size() > 0) {
                model.addAttribute("error", "此角色下还有职员，不允许删除。");
                return "common/proce";
            } else {
                Role r = rdao.findOne(lid);
                rdao.delete(r);
            }
        } else {
            model.addAttribute("error", "只有超级管理员才能操作。");
            return "common/proce";
        }
        return null;
    }*/
    /* */
    /**
     * 条件查询
     *//*
    @RequestMapping("roleser")
    public String roleser(HttpServletRequest req, Model model,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pa = new PageRequest(page, size);
        Page<Role> pagerole = null;
        List<Role> rolelist = null;
        String val = null;


        if (!StringUtil.isEmpty(req.getParameter("val"))) {
            val = req.getParameter("val").trim();
        }

        if (!StringUtil.isEmpty(val)) {
            pagerole = rdao.findbyrolename(val, pa);
            model.addAttribute("sort", "&val=" + val);
        } else {
            pagerole = rdao.findAll(pa);
        }
        rolelist = pagerole.getContent();
        model.addAttribute("page", pagerole);
        model.addAttribute("rolelist", rolelist);
        model.addAttribute("url", "roleser");
        return "role/roletable";
    }*/


    //==========================================
    @Resource
    private RoleServiceV2 roleServiceV2;
    @Resource
    private SystemMenuServiceV2 systemMenuServiceV2;
    @Resource
    private RolePowerListServiceV2 rolePowerListServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;

    /**
     * 角色管理主页面
     *
     * @param page 第几页
     * @param size 每页大小
     * @return
     */
    @RequestMapping("rolemanage")
    public ModelAndView roleManage(@RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "size", defaultValue = "10") int size) {
        ModelAndView mav = new ModelAndView("role/rolemanage");
        List<RolePO> rolePOList = roleServiceV2.getRoleListAll();//所有角色信息
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(rolePOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > rolePOList.size()) {
            end = rolePOList.size();
        }
        List<RolePO> subRolePOList = rolePOList.subList(start, end);
        mav.addObject("page", pageBO);
        mav.addObject("rolelist", subRolePOList);
        mav.addObject("url", "roleser");
        return mav;
    }

    private void getRolePOListPage(int page, int size, List<RolePO> rolePOList, Model model) {
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
            rolePO = roleServiceV2.getRoleByRoleId(rolePOId);
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
            rolePOId = Long.parseLong(req.getParameter("id"));
        }
        if (rolePOId != null) {
            RolePO rolePO = roleServiceV2.getRoleByRoleId(rolePOId);
            rolePO.setRoleName(roleVO.getRoleName());
            rolePO.setRoleValue(roleVO.getRoleValue());
            roleServiceV2.updateOrInsertRolePO(rolePO, rolePOId);
        } else {
            RolePO rolePO = new RolePO();
            rolePO.setRoleName(roleVO.getRoleName());
            rolePO.setRoleValue(roleVO.getRoleValue());
            RolePO newRolePO = roleServiceV2.updateOrInsertRolePO(rolePO, null);
            List<SysMenuPO> sysMenuPOList = systemMenuServiceV2.getSysMenuPOAll();
            rolePowerListServiceV2.insertRolePowerListPO(sysMenuPOList, newRolePO.getRoleId());
        }

        return "redirect:/rolemanage";
    }

    /**
     * 设定角色权限
     *
     * @return
     */
    @RequestMapping("roleset")
    public String roleSet(HttpServletRequest req, Model model) {
        Long roleId = Long.parseLong(req.getParameter("id"));
        RolePO rolePO = roleServiceV2.getRoleByRoleId(roleId);
        List<RolePowerMenuVO> oneRolePowerMenuVO = systemMenuServiceV2.getSysMenuPOListByParentAll(0L, roleId);
        List<RolePowerMenuVO> twoRolePowerMenuVO = systemMenuServiceV2.getSysMenuPOListBySonAll(0L, roleId);

        model.addAttribute("oneMenuAll", oneRolePowerMenuVO);//一级菜单
        model.addAttribute("twoMenuAll", twoRolePowerMenuVO);//二级菜单
        model.addAttribute("roleid", roleId);//角色名
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
        String content = req.getParameter("content").trim();
        Long menuId = Long.parseLong(req.getParameter("menuid"));//菜单ID
        RolePowerListPO rolePowerListPO = rolePowerListServiceV2.getRolePowerListPOSByRoleIdAndMenuId(roleId, menuId);
        int check;
        if (content.equals("选中")) {
            check = 1;
        } else {
            check = 0;
        }
        rolePowerListServiceV2.updateRolePowerListPO(rolePowerListPO, check);
        return true;
    }

    /**
     * 删除
     */
    @RequestMapping("deshan")
    public String deleteRole(HttpServletRequest req, Model model, HttpSession session) {
        Long userId = Long.parseLong(((String) session.getAttribute("userId")).trim());
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        Long roleId = null;
        if (!StringUtil.isEmpty(req.getParameter("id"))) {
            roleId = Long.parseLong(req.getParameter("id"));
        }
        Boolean isSuperman = userPO.getSuperman() == 0 ? false : true;//是否是超级管理员
        if (isSuperman.equals(true)) {//只有超级管理员才能删除角色信息
            List<UserPO> userPOList = userServiceV2.getUserPoListByRoleId(roleId);//根据角色ID找用户列表
            if (userPOList.size() > 0) {
                model.addAttribute("error", "此角色下还有职员，不允许删除。");
                return "common/proce";
            } else {
                //角色下没有职员，则可以直接删除角色
                roleServiceV2.deleteRolePOByRoleId(roleId);
            }
        } else {
            model.addAttribute("error", "只有超级管理员才能操作。");
            return "common/proce";
        }
        return null;
    }

    /**
     * 条件查询
     */
    @RequestMapping("roleser")
    public String roleLike(HttpServletRequest req, Model model,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size) {
        List<RolePO> rolePOList = null;
        String val = null;//搜索输入的内容
        if (!StringUtil.isEmpty(req.getParameter("val"))) {
            val = req.getParameter("val").trim();
        }

        if (!StringUtil.isEmpty(val)) {
            rolePOList = roleServiceV2.getRoleListByRoleNameLike(val);
            model.addAttribute("sort", "&val=" + val);//记录了模糊字，&val用于连接页码和模糊字
        } else {
            rolePOList = roleServiceV2.getRoleListAll();
        }
        getRolePOListPage(page, size, rolePOList, model);
        return "role/roletable";
    }

}
