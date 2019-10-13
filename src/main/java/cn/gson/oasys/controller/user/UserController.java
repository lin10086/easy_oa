package cn.gson.oasys.controller.user;

import java.util.List;
import java.util.Map;

import cn.gson.oasys.ServiceV2.DeptServiceV2;
import cn.gson.oasys.ServiceV2.PositionServiceV2;
import cn.gson.oasys.ServiceV2.RoleServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.factory.DeptFactory;
import cn.gson.oasys.factory.PositionFactory;
import cn.gson.oasys.factory.RoleFactory;
import cn.gson.oasys.factory.UserFactory;
import cn.gson.oasys.mappers.UserPOSqlProvider;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import cn.gson.oasys.model.dao.roledao.RoleDao;
import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserDao udao;
    @Autowired
    DeptDao ddao;
    @Autowired
    PositionDao pdao;
    @Autowired
    RoleDao rdao;

    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private DeptServiceV2 deptServiceV2;
    @Resource
    private PositionServiceV2 positionServiceV2;
    @Resource
    private RoleServiceV2 roleServiceV2;

    /*
        //第一次进入用户管理》用户管理显示的页面(1)
        @RequestMapping("usermanage")
        public String usermanage(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size) {
              //先排序在分页
            Sort sort = new Sort(new Order(Direction.ASC, "dept"));
            Pageable pa = new PageRequest(page, size, sort);
            Page<User> userspage = udao.findByIsLock(0, pa);
            List<User> users = userspage.getContent();
            model.addAttribute("users", users);
            model.addAttribute("page", userspage);
            model.addAttribute("url", "usermanagepaging");
            return "user/usermanage";
        }

         //删除用户（2）
        @RequestMapping("deleteuser")
        public String deleteuser(@RequestParam("userid") Long userid, Model model) {
        //根据用户ID获取用户信息
            User user = udao.findOne(userid);
        //把isLock设置为1（不可用用户，实际上数据库未删除，只是不显示）
            user.setIsLock(1);

            udao.save(user);

            model.addAttribute("success", 1);
            return "/usermanage";
        }
*/

  /*  //点击修改，增加跳转的页面(3)
    @RequestMapping(value = "useredit", method = RequestMethod.GET)
    public String usereditget(@RequestParam(value = "userid", required = false) Long userid, Model model) {
        if (userid != null) {
            //有userID代表修改
            User user = udao.findOne(userid);
            model.addAttribute("where", "xg");
            model.addAttribute("user", user);
        }
        //没有获取到userID代表新增
        List<Dept> depts = (List<Dept>) ddao.findAll();
        List<Position> positions = (List<Position>) pdao.findAll();
        List<Role> roles = (List<Role>) rdao.findAll();
        model.addAttribute("depts", depts);
        model.addAttribute("positions", positions);
        model.addAttribute("roles", roles);
        return "user/edituser";
    }*/

     /*   //(4)
        @RequestMapping(value = "useredit", method = RequestMethod.POST)
        public String usereditpost(User user,
                                   @RequestParam("deptid") Long deptid,
                                   @RequestParam("positionid") Long positionid,
                                   @RequestParam("roleid") Long roleid,
                                   @RequestParam(value = "isbackpassword", required = false) boolean isbackpassword,
                                   Model model) throws PinyinException {
            Dept dept = ddao.findOne(deptid);
            Position position = pdao.findOne(positionid);
            Role role = rdao.findOne(roleid);
            if (user.getUserId() == null) {
                String pinyin = PinyinHelper.convertToPinyinString(user.getUserName(), "", PinyinFormat.WITHOUT_TONE);
                user.setPinyin(pinyin);
                user.setPassword("123456");
                user.setDept(dept);
                user.setRole(role);
                user.setPosition(position);
                user.setFatherId(dept.getDeptmanager());
                udao.save(user);
            } else {
                User user2 = udao.findOne(user.getUserId());
                user2.setUserTel(user.getUserTel());
                user2.setRealName(user.getRealName());
                user2.setEamil(user.getEamil());
                user2.setAddress(user.getAddress());
                user2.setUserEdu(user.getUserEdu());
                user2.setSchool(user.getSchool());
                user2.setIdCard(user.getIdCard());
                user2.setBank(user.getBank());
                user2.setThemeSkin(user.getThemeSkin());
                user2.setSalary(user.getSalary());
                user2.setFatherId(dept.getDeptmanager());
                if (isbackpassword) {
                    user2.setPassword("123456");
                }
                user2.setDept(dept);
                user2.setRole(role);
                user2.setPosition(position);
                udao.save(user2);
            }
            model.addAttribute("success", 1);
            return "/usermanage";
        }
*/

        //目前未用到
       /* @RequestMapping("userlogmanage")
        public String userlogmanage() {
            return "user/userlogmanage";
        }

        @RequestMapping("usermanagepaging")
        public String userPaging(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "10") int size,
                                 @RequestParam(value = "usersearch", required = false) String usersearch
        ) {
            Sort sort = new Sort(new Order(Direction.ASC, "dept"));
            Pageable pa = new PageRequest(page, size, sort);
            Page<User> userspage = null;
            if (StringUtil.isEmpty(usersearch)) {
                userspage = udao.findByIsLock(0, pa);
            } else {
                System.out.println(usersearch);
                userspage = udao.findnamelike(usersearch, pa);
            }
            List<User> users = userspage.getContent();
            model.addAttribute("users", users);
            model.addAttribute("page", userspage);
            model.addAttribute("url", "usermanagepaging");

            return "user/usermanagepaging";
        }

        @RequestMapping("useronlyname")
        public @ResponseBody
        boolean useronlyname(@RequestParam("username") String username) {
            System.out.println(username);
            User user = udao.findByUserName(username);
            System.out.println(user);
            if (user == null) {
                return true;
            }
            return false;
        }

        @RequestMapping("selectdept")
        public @ResponseBody
        List<Position> selectdept(@RequestParam("selectdeptid") Long deptid) {

            return pdao.findByDeptidAndNameNotLike(deptid, "%经理");
        }
    */
//=====================================================

    //(1)
    @RequestMapping("usermanage")
    public String usermanage(Model model, @RequestParam(value = "page", defaultValue = "0") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size) {
        //根据部门升序分页，可用的用户
        List<UserPO> userPOList = userServiceV2.ASCDeptIsLock(page, size);
        List<User> userList = UserFactory.create(userPOList);
        Map<Long, Role> longRoleMap = userServiceV2.userIdAndRole(userPOList);
        Map<Long, Dept> longDeptMap = userServiceV2.userIdAndDept(userPOList);
        for (User user : userList) {
            user.setRole(longRoleMap.get(user.getUserId()));
            user.setDept(longDeptMap.get(user.getUserId()));
        }
        model.addAttribute("users", userList);
        model.addAttribute("page", userList);
        model.addAttribute("url", "usermanagepaging");
        return "user/usermanage";
    }

    //（2）
    @RequestMapping("deleteuser")
    public String deleteuser(@RequestParam("userid") Long userId, Model model) {
        userServiceV2.updateUserIsLock(userId);
        model.addAttribute("success", 1);
        return "/usermanage";

    }

    //(3)
    @RequestMapping(value = "useredit", method = RequestMethod.GET)
    public String usereditget(@RequestParam(value = "userid", required = false) Long userId, Model model) {
        if (userId != null) {
            //有userID代表修改
            //////////(修改部分没有出现保存
            User user = userServiceV2.findUserByUserId(userId);
            model.addAttribute("where", "xg");
            model.addAttribute("user", user);
        }

        List<Dept> deptList = deptServiceV2.getDeptList();
        List<Position> positionList = positionServiceV2.getPositionList();
        List<Role> roleList = roleServiceV2.getRoleList();
        model.addAttribute("depts", deptList);
        model.addAttribute("positions", positionList);
        model.addAttribute("roles", roleList);
        return "user/edituser";
    }


    //处理修改页面（4）
    @RequestMapping(value = "useredit", method = RequestMethod.POST)
    public String usereditpost(User user,
                               @RequestParam("deptid") Long deptId,
                               @RequestParam("positionid") Long positionId,
                               @RequestParam("roleid") Long roleId,
                               @RequestParam(value = "isbackpassword", required = false) boolean isbackpassword,
                               Model model) throws PinyinException {
        Dept dept = deptServiceV2.getDeptbyDeptId(deptId);
        Position position = positionServiceV2.getPositionByPositionId(positionId);
        Role role = roleServiceV2.getRoleByRoleId(roleId);
        if (user.getUserId() == null) {
            String pinyin = PinyinHelper.convertToPinyinString(user.getUserName(), "", PinyinFormat.WITHOUT_TONE);
            UserPO userPO = UserFactory.create(user);
            userServiceV2.insertUserAll(userPO, dept, position, role, dept.getDeptmanager(), pinyin, "123456");
        } else {
            userServiceV2.updateUserAll1(user, isbackpassword, dept, role, position);
        }
        model.addAttribute("success", 1);
        return "/usermanage";
    }

}
