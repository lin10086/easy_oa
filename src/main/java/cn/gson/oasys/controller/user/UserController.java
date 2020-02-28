package cn.gson.oasys.controller.user;

import java.util.List;
import java.util.Map;

import cn.gson.oasys.ServiceV2.DeptPOServiceV2;
import cn.gson.oasys.ServiceV2.PositionPOServiceV2;
import cn.gson.oasys.ServiceV2.RoleServiceV2;
import cn.gson.oasys.ServiceV2.UserPOServiceV2;
import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.DeptVO;
import cn.gson.oasys.vo.PositionVO;
import cn.gson.oasys.vo.RoleVO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.factoryvo.DeptFactoryVO;
import cn.gson.oasys.vo.factoryvo.PositionFactoryVO;
import cn.gson.oasys.vo.factoryvo.RoleFactoryVO;
import cn.gson.oasys.vo.factoryvo.UserFactoryVO;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.gson.oasys.model.dao.roledao.RoleDao;
import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.dao.user.UserDao;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class UserController {

    @Resource
    private UserPOServiceV2 userServiceV2;
    @Resource
    private DeptPOServiceV2 deptServiceV2;
    @Resource
    private PositionPOServiceV2 positionServiceV2;
    @Resource
    private RoleServiceV2 roleServiceV2;

    /**
     * ----------
     *
     * @return
     */
    @RequestMapping("userlogmanage")
    public String userLogManage() {
        return "user/userlogmanage";
    }


    /**
     * ------
     * 看根据用户名找到的用户是否存在
     *
     * @param username 用户名
     * @return
     */
    @RequestMapping("useronlyname")
    @ResponseBody
    public boolean userOnlyName(@RequestParam("username") String username) {
        UserPO userPO = userServiceV2.getUserPOByUsername(username);//根据用户名找用户
        if (userPO == null) {
            return true;
        }
        return false;
    }

    /**
     * ------
     * 根据职位名name不是以经理结尾和部门ID找职位列表
     *
     * @param deptId 部门ID
     * @return
     */
    @RequestMapping("selectdept")
    @ResponseBody
    public List<PositionPO> selectDept(@RequestParam("selectdeptid") Long deptId) {
        List<PositionPO> positionPOList = positionServiceV2.getPositionPOListByDeptIdAndNameNotLike(deptId);
        return positionPOList;
    }


    /**
     * 用户管理主页面
     *
     * @param model
     * @param page  第几页
     * @param size  每页显示几条数据
     * @return
     */
    @RequestMapping("usermanage")
    public String userManage(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size) {
        //根据部门升序分页，可用的用户
        List<UserPO> userPOList = userServiceV2.getUserPOListAllByASCDeptAndIsLock(0);
        List<UserPO> subUserPOList = setUserPage(page, size, userPOList, model);
        List<UserVO> userVOList = userServiceV2.getUserVOList(subUserPOList);//userPOList转换为userVOList并补全信息
        model.addAttribute("users", userVOList);
        model.addAttribute("url", "usermanagepaging");
        return "user/usermanage";
    }


    /**
     * 用户分页
     *
     * @param page       第几页
     * @param size       每页大小
     * @param userPOList 用户列表
     * @param model
     * @return
     */
    public List<UserPO> setUserPage(int page, int size, List<UserPO> userPOList, Model model) {
        PageBO pageBO = new PageBO(page, size);//获取pageBO
        pageBO.setTotalCount(userPOList.size());//设置总页数
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();//本页开始的条数（包括）
        int end = pageBO.getPageNo() * pageBO.getPageSize();//本业结束的条数（不包括）
        if (end > userPOList.size()) {//end不能大于总条数
            end = userPOList.size();
        }
        List<UserPO> subUserPOList = userPOList.subList(start, end);//获取子串
        model.addAttribute("page", pageBO);
        return subUserPOList;
    }

    /**
     * @param model
     * @param page       第几页
     * @param size       每页几条
     * @param userSearch 模糊字
     * @return
     */
    @RequestMapping("usermanagepaging")
    public String userPaging(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                             @RequestParam(value = "size", defaultValue = "10") int size,
                             @RequestParam(value = "usersearch", required = false) String userSearch) {
        //根据部门升序分页，可用的用户
        List<UserPO> userPOList;
        if (StringUtil.isEmpty(userSearch)) {
            userPOList = userServiceV2.getUserPOListAllByASCDeptAndIsLock(0);
        } else {
            //模糊字查询（部门名，用户名，用户真实名，用户电话，用户角色名）
//            @Query("from User u where u.dept.deptName like %?1% or u.userName like %?1% or u.realName like %?1% or u.userTel like %?1% or u.role.roleName like %?1%")
//            Page<User> findnamelike(String name, Pageable pa);
//            userspage = udao.findnamelike(usersearch, pa);
            //根据用户名或用户真实名模糊查找找用户列表
            userPOList = userServiceV2.getUserPOListByUsernameLikeAndRealNameLike(userSearch);
        }
        List<UserPO> subUserPOList = setUserPage(page, size, userPOList, model);
        List<UserVO> userVOList = UserFactoryVO.createUserVOList(subUserPOList);
        model.addAttribute("users", userVOList);
        model.addAttribute("url", "usermanagepaging");

        return "user/usermanagepaging";
    }

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @param model
     * @return
     */
    @RequestMapping("deleteuser")
    public String deleteuser(@RequestParam("userid") Long userId, Model model) {
        userServiceV2.updateUserIsLock(userId);
        model.addAttribute("success", 1);
        return "/usermanage";
    }


    /**
     * 获取增加和修改单内容
     *
     * @param userId 用户ID
     * @param model
     * @return
     */
    @RequestMapping(value = "useredit", method = RequestMethod.GET)
    public String userEditGet(@RequestParam(value = "userid", required = false) Long userId, Model model) {
        if (userId != null) {
            //有userID代表修改,获取用户信息
            UserVO userVO = userServiceV2.setUserVOByUserId(userId);
            model.addAttribute("where", "xg");
            model.addAttribute("user", userVO);
        }
        //所有部门
        List<DeptPO> deptPOList = deptServiceV2.getDeptPOListAll();
        List<DeptVO> deptVOList = DeptFactoryVO.createDeptVOList(deptPOList);
        //所有职位
        List<PositionPO> positionPOList = positionServiceV2.getPositionListAll();
        List<PositionVO> positionVOList = PositionFactoryVO.createPositionVOList(positionPOList);
        // 所有角色
        List<RolePO> rolePOList = roleServiceV2.getRoleListAll();
        List<RoleVO> roleVOList = RoleFactoryVO.createRoleVOList(rolePOList);
        model.addAttribute("depts", deptVOList);
        model.addAttribute("positions", positionVOList);
        model.addAttribute("roles", roleVOList);
        return "user/edituser";
    }

    /**
     * 保存新增或修改信息
     *
     * @param userVO         页面提交的用户信息
     * @param deptId         部门ID
     * @param positionId     职位ID
     * @param roleId         角色ID
     * @param isBackPassword 是否重置密码
     * @param model
     * @return
     * @throws PinyinException 汉字转换拼音异常
     */
    @RequestMapping(value = "useredit", method = RequestMethod.POST)
    public String userEditPost(UserVO userVO,
                               @RequestParam("deptId") Long deptId,
                               @RequestParam("positionId") Long positionId,
                               @RequestParam("roleId") Long roleId,
                               @RequestParam(value = "isBackPassword", required = false) boolean isBackPassword,
                               Model model) throws PinyinException {
        DeptPO deptPO = deptServiceV2.getDeptPOByDeptId(deptId);//部门信息
        userVO.setFatherId(deptPO.getDeptmanager());//设置用户领导
        UserPO userPO = UserFactoryVO.createUserPO(userVO);
        if (userVO.getUserId() == null) {//新增
            String pinyin = PinyinHelper.convertToPinyinString(userVO.getUserName(), "", PinyinFormat.WITHOUT_TONE);
            userServiceV2.insertNewUserPO(userPO, deptPO, roleId, positionId, pinyin);
        } else {
            userServiceV2.updateUserPO(userPO, isBackPassword, deptId, roleId, positionId);
        }
        model.addAttribute("success", 1);
        return "/usermanage";
    }

}
