package cn.gson.oasys.controller.user;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.DeptPOServiceV2;
import cn.gson.oasys.ServiceV2.PositionPOServiceV2;
import cn.gson.oasys.ServiceV2.UserPOServiceV2;
import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.DeptVO;
import cn.gson.oasys.vo.PositionVO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.factoryvo.DeptFactoryVO;
import cn.gson.oasys.vo.factoryvo.PositionFactoryVO;
import cn.gson.oasys.vo.factoryvo.UserFactoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.dao.user.UserDao;

@Slf4j
@Controller
@RequestMapping("/")
public class DeptController {

    @Resource
    private PositionPOMapper positionPOMapper;
    @Resource
    private DeptPOServiceV2 deptServiceV2;
    @Resource
    private PositionPOServiceV2 positionServiceV2;
    @Resource
    private UserPOServiceV2 userServiceV2;

    /**
     * 进入用户管理》部门管理
     *
     * @param model
     * @return
     */
    @RequestMapping("deptmanage")
    public String deptManage(Model model) {
        //所有的部门列表
        List<DeptPO> deptPOList = deptServiceV2.getDeptPOListAll();
        List<DeptVO> deptVOList = DeptFactoryVO.createDeptVOList(deptPOList);
        model.addAttribute("depts", deptVOList);
        return "user/deptmanage";
    }

    /**
     * 用户管理》部门管理》删除
     * 要删除部门，先删除部门里的职位
     *
     * @param deleteDeptId 要删除的部门ID
     * @return
     */
    @RequestMapping("deleteDept")
    public String deleteDept(@RequestParam("deleteDeptId") Long deleteDeptId) {
//        根据部门ID获取部门里的职位列表
        List<PositionPO> positionPOList = positionServiceV2.getPositionPOByDeptId(deleteDeptId);
        //删除部门里的职位
        for (PositionPO positionPO : positionPOList) {
            positionPOMapper.deleteByPrimaryKey(positionPO.getPositionId());
        }
//        根据部门ID删除部门
        deptServiceV2.deleteDeptPOByDeptId(deleteDeptId);
        return "/deptmanage";
    }

    /**
     * 负责获取修改页面信息的，跳转到修改信息页面只需要get请求
     *
     * @param deptId 部门ID
     * @param model
     * @return
     */
    @RequestMapping(value = "deptedit", method = RequestMethod.GET)
    public String changeDept(@RequestParam(value = "deptId", required = false) Long deptId, Model model) {
        if (deptId != null) {
            //根据部门ID获取部门信息
            DeptPO deptPO = deptServiceV2.getDeptPOByDeptId(deptId);
            DeptVO deptVO = DeptFactoryVO.createDeptVO(deptPO);
            model.addAttribute("dept", deptVO);
        }
        return "user/deptedit";
    }

    /**
     * 用户管理》部门管理》新增,修改。获取修改后的信息进行保存
     *
     * @param deptVO 修改后的部门信息
     * @param xg
     * @param br
     * @param model
     * @return
     */
    @RequestMapping(value = "deptedit", method = RequestMethod.POST)
    public String addOrUpdateDept(@Valid DeptVO deptVO, @RequestParam("xg") String xg, BindingResult br, Model model) {
        if (!br.hasErrors()) {
            Integer rows = deptServiceV2.updateOrInsertDept(deptVO);
            if (rows == 1) {
                model.addAttribute("success", 1);
                return "/deptmanage";
            }
        }
        //有错误
        model.addAttribute("errormess", "错误！~");
        return "user/deptedit";
    }


    /**
     * 点击人事调动会进入部门的详细信息列表
     *
     * @param deptId 部门ID
     * @param model
     * @return
     */
    @RequestMapping("readDept")
    public String readDept(@RequestParam(value = "deptId") Long deptId, Model model) {
        DeptPO deptPO = deptServiceV2.getDeptPOByDeptId(deptId);//根据部门ID获取部门信息
        DeptVO deptVO = DeptFactoryVO.createDeptVO(deptPO);
        //领导信息
        UserVO deptVOManage = null;
        //部门领导是否存在
        if (deptPO.getDeptmanager() != null) {
            //获取到的用户信息没有部门，职位信息，目前只需要他的职位信息
            UserPO deptManage = userServiceV2.getUserBydeptManager(deptPO.getDeptmanager());//部门领导的用户信息
            deptVOManage = UserFactoryVO.createUserVO(deptManage);
            model.addAttribute("deptVOManage", deptVOManage);
        }
        //获取部门列表
        List<DeptPO> deptPOList = deptServiceV2.getDeptPOListAll();
        List<DeptVO> deptVOList = DeptFactoryVO.createDeptVOList(deptPOList);
        //根据职位名name不是以经理结尾的（返回职位列表，所有部门）
        List<PositionPO> positionPOList = positionServiceV2.getPositionPOListByDeptIdAndNameNotLike("%经理");
        List<PositionVO> positionVOList = PositionFactoryVO.createPositionVOList(positionPOList);
        //同一个部门的用户(即用户的部门ID相同）
        List<UserPO> userPOList = userServiceV2.getUserByDeptId(deptId);
        List<UserVO> userVOList = UserFactoryVO.createUserVOList(userPOList);

        Map<Long, DeptPO> deptMap = userServiceV2.userPOListIdAndDeptPO(userPOList);
        Map<Long, PositionPO> positionMap = userServiceV2.userPOListIdAndPositionPO(userPOList);
        //职位不是以经理结尾的用户列表
        List<UserVO> formalUser = new ArrayList<>();
        for (UserVO deptUser : userVOList) {
            deptUser.setDeptVO(DeptFactoryVO.createDeptVO(deptMap.get(deptUser.getUserId())));
            deptUser.setPositionVO(PositionFactoryVO.createPositionVO(positionMap.get(deptUser.getUserId())));
            PositionVO positionVO = deptUser.getPositionVO();
            if (!positionVO.getPositionName().endsWith("经理")) {
                formalUser.add(deptUser);
            }
        }
        model.addAttribute("positions", positionVOList);//所有部门的非经理职位
        model.addAttribute("depts", deptVOList);//所有的部门列表
        model.addAttribute("deptUser", formalUser);//此部门的非经理用户列表
        model.addAttribute("dept", deptVO);//此部门信息
        model.addAttribute("isRead", 1);
        return "user/deptread";
    }


    /**
     * 人事调动里面的人事调动，部门和职位的改变
     *
     * @param positionId   职位ID
     * @param changeDeptId 改变后的部门ID
     * @param userId       用户ID
     * @param deptId       部门ID
     * @param model
     * @return
     */
    @RequestMapping("deptAndPositionChange")
    public String deptAndPositionChange(@RequestParam("positionId") Long positionId,
                                        @RequestParam("changeDeptId") Long changeDeptId,
                                        @RequestParam("userId") Long userId,
                                        @RequestParam("deptId") Long deptId,
                                        Model model) {
//        根据用户ID更新userPO里面的，部门ID和职位ID
        userServiceV2.updateUserPOInDeptIdAndPositionIdByUserId(userId, changeDeptId, positionId);
        model.addAttribute("deptId", deptId);
        return "/readDept";
    }


    /**
     * 人事调动里面的部门经理的更换
     *
     * @param changePositionId 要去的新职位ID
     * @param changeDeptId     要去的部门ID
     * @param oldManageId      老经理ID
     * @param newManageId      新经理ID
     * @param deptId           现在的部门ID
     * @param model
     * @return
     */
    @RequestMapping("deptManagerChange")
    public String deptManagerChange(@RequestParam(value = "changePositionId", required = false) Long changePositionId,
                                    @RequestParam(value = "changeDeptId", required = false) Long changeDeptId,
                                    @RequestParam(value = "oldManageId", required = false) Long oldManageId,
                                    @RequestParam(value = "newManageId", required = false) Long newManageId,
                                    @RequestParam("deptId") Long deptId,
                                    Model model) {

        if (oldManageId != null) {//部门的老领导是否存在
            //查询老领导的用户信息
            UserPO oldUserPOManage = userServiceV2.getUserPOByUserId(oldManageId);
            //老经理的职位信息
            PositionPO oldPositionPO = positionServiceV2.getPositionPOByPositionId(oldUserPOManage.getPositionId());
            //更新老经理信息（老经理ID，要去的部门ID，要去的职位ID）
            userServiceV2.updateUserPOInDeptIdAndPositionIdByUserId(oldManageId, changeDeptId, changePositionId);
            if (newManageId != null) {//新领导是否存在
                //根据部门ID更新领导ID
                deptServiceV2.updateDeptManage(deptId, newManageId);
                //更新用户的职位信息
                userServiceV2.updateUserPOPositionId(newManageId, oldPositionPO.getPositionId());
            } else {
                deptServiceV2.updateDeptManage(deptId, null);
            }
        } else {
//            根据职位名name不是以经理结尾的（返回职位列表）
            PositionPO manage = positionServiceV2.getPositionPOListByDeptIdAndNameLike(deptId).get(0);
            //根据部门ID更新部门领导（部门ID，新领导ID）
            deptServiceV2.updateDeptManage(deptId, newManageId);
            //更新用户的职位信息（新领导ID，职位ID）
            userServiceV2.updateUserPOPositionId(newManageId, manage.getPositionId());
        }
        model.addAttribute("deptId", deptId);
        return "/readDept";
    }

}
