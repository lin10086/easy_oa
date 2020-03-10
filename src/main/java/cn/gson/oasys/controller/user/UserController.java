package cn.gson.oasys.controller.user;

import java.util.List;

import cn.gson.oasys.serviceV2.deptV2.DeptPOServiceV2;
import cn.gson.oasys.serviceV2.positionV2.PositionPOServiceV2;
import cn.gson.oasys.serviceV2.roleV2.RolePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.modelV2.bo.PageBO;
import cn.gson.oasys.modelV2.po.DeptPO;
import cn.gson.oasys.modelV2.po.PositionPO;
import cn.gson.oasys.modelV2.po.RolePO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.voandfactory.deptVO2.DeptVO;
import cn.gson.oasys.voandfactory.positionVO2.PositionVO;
import cn.gson.oasys.voandfactory.roleVO2.RoleVO;
import cn.gson.oasys.voandfactory.userVO2.UserVO;
import cn.gson.oasys.voandfactory.deptVO2.DeptVOFactory;
import cn.gson.oasys.voandfactory.positionVO2.PositionVOFactory;
import cn.gson.oasys.voandfactory.roleVO2.RoleVOFactory;
import cn.gson.oasys.voandfactory.userVO2.UserVOFactory;
import com.github.pagehelper.util.StringUtil;
import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class UserController {

    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private DeptPOServiceV2 deptPOServiceV2;
    @Resource
    private PositionPOServiceV2 positionPOServiceV2;
    @Resource
    private RolePOServiceV2 rolePOServiceV2;

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
        UserPO userPO = userPOServiceV2.getUserPOByUsername(username);//根据用户名找用户
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
        List<PositionPO> positionPOList = positionPOServiceV2.getPositionPOListByDeptIdAndNameNotLike(deptId);
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
        List<UserPO> userPOList = userPOServiceV2.getUserPOListAllByASCDeptAndIsLock(0);
        List<UserPO> subUserPOList = setUserPage(page, size, userPOList, model);
        List<UserVO> userVOList = userPOServiceV2.getUserVOList(subUserPOList);//userPOList转换为userVOList并补全信息
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
            userPOList = userPOServiceV2.getUserPOListAllByASCDeptAndIsLock(0);
        } else {
            //模糊字查询（部门名，用户名，用户真实名，用户电话，用户角色名）
//            @Query("from User u where u.dept.deptName like %?1% or u.userName like %?1% or u.realName like %?1% or u.userTel like %?1% or u.role.roleName like %?1%")
//            Page<User> findnamelike(String name, Pageable pa);
//            userspage = udao.findnamelike(usersearch, pa);
            //根据用户名或用户真实名模糊查找找用户列表
            userPOList = userPOServiceV2.getUserPOListByUsernameLikeAndRealNameLike(userSearch);
        }
        List<UserPO> subUserPOList = setUserPage(page, size, userPOList, model);
        List<UserVO> userVOList = UserVOFactory.createUserVOListByUserPOList(subUserPOList);
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
        userPOServiceV2.updateUserIsLock(userId);
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
            UserVO userVO = userPOServiceV2.setUserVOByUserId(userId);
            model.addAttribute("where", "xg");
            model.addAttribute("user", userVO);
        }
        //所有部门
        List<DeptPO> deptPOList = deptPOServiceV2.getDeptPOListAll();
        List<DeptVO> deptVOList = DeptVOFactory.createDeptVOListByDeptPOList(deptPOList);
        //所有职位
        List<PositionPO> positionPOList = positionPOServiceV2.getPositionListAll();
        List<PositionVO> positionVOList = PositionVOFactory.createPositionVOListByPositionPOList(positionPOList);
        // 所有角色
        List<RolePO> rolePOList = rolePOServiceV2.getRoleListAll();
        List<RoleVO> roleVOList = RoleVOFactory.createRoleVOListRolePOList(rolePOList);
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
        DeptPO deptPO = deptPOServiceV2.getDeptPOByDeptId(deptId);//部门信息
        userVO.setFatherId(deptPO.getDeptmanager());//设置用户领导
        UserPO userPO = UserVOFactory.createUserPOByUserVO(userVO);
        if (userVO.getUserId() == null) {//新增
            String pinyin = PinyinHelper.convertToPinyinString(userVO.getUserName(), "", PinyinFormat.WITHOUT_TONE);//汉字转拼音
            userPOServiceV2.insertNewUserPO(userPO, deptPO, roleId, positionId, pinyin);//插入新用户
        } else {
            userPOServiceV2.updateUserPO(userPO, isBackPassword, deptId, roleId, positionId);//更新用户信息（可重置密码）
        }
        model.addAttribute("success", 1);
        return "/usermanage";
    }

}
