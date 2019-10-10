package cn.gson.oasys.controller.user;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.DeptServiceV2;
import cn.gson.oasys.ServiceV2.PositionServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.factory.DeptFactory;
import cn.gson.oasys.factory.UserFactory;
import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;

@Controller
@RequestMapping("/")
public class DeptController {

    @Autowired
    DeptDao deptdao;
    @Autowired
    UserDao udao;
    @Autowired
    PositionDao pdao;
    @Resource
    private DeptPOMapper deptPOMapper;
    @Resource
    private  UserPOMapper userPOMapper;
    @Resource
    private PositionPOMapper positionPOMapper;
    @Resource
    private DeptServiceV2 deptServiceV2;
    @Resource
    private PositionServiceV2 positionServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;

    /**
     * 第一次进入部门管理页面
     *
     * @return
     */
	/*
	@RequestMapping("deptmanage")
	public String deptmanage(Model model) {
		List<Dept> depts = (List<Dept>) deptdao.findAll();
		System.out.println(depts);
		model.addAttribute("depts",depts);
		return "user/deptmanage";
	}
*/
    //自己写的，第一次进入部门管理
    @RequestMapping("deptmanage")
    public String deptmanage(Model model) {
        List<Dept>deptList = deptServiceV2.getDeptList();
        model.addAttribute("depts", deptList);
        return "user/deptmanage";
    }

    //用户管理》部门管理》新增，修改

    @RequestMapping(value = "deptedit", method = RequestMethod.POST)
    public String adddept(@Valid Dept dept, @RequestParam("xg") String xg, BindingResult br, Model model) {
        System.out.println(br.hasErrors());
        System.out.println(br.getFieldError());
        if (!br.hasErrors()) {
            System.out.println("没有错误");
            Dept adddept = deptdao.save(dept);
            if ("add".equals(xg)) {
                System.out.println("新增拉");
                Position jinli = new Position();
                jinli.setDeptid(adddept.getDeptId());
                jinli.setName("经理");
                Position wenyuan = new Position();
                wenyuan.setDeptid(adddept.getDeptId());
                wenyuan.setName("文员");
                pdao.save(jinli);
                pdao.save(wenyuan);
            }
            if (adddept != null) {
                System.out.println("插入成功");
                model.addAttribute("success", 1);
                return "/deptmanage";
            }
        }
        System.out.println("有错误");
        model.addAttribute("errormess", "错误！~");
        return "user/deptedit";
    }

/*
    @RequestMapping(value = "deptedit", method = RequestMethod.GET)
    public String changedept(@RequestParam(value = "dept", required = false) Long deptId, Model model) {
        if (deptId != null) {
            Dept dept = deptdao.findOne(deptId);
            model.addAttribute("dept", dept);
        }
        return "user/deptedit";
    }
*/

//自己写的，通过部门ID获取部门信息
    @RequestMapping(value = "deptedit", method = RequestMethod.GET)
    public String changedept(@RequestParam(value = "dept", required = false) Long deptId, Model model) {
        if (deptId != null) {
            Dept dept = deptServiceV2.getDeptbyDeptId(deptId);
            model.addAttribute("dept", dept);
        }
        return "user/deptedit";
    }
/*
    @RequestMapping("readdept")
    public String readdept(@RequestParam(value = "deptid") Long deptId, Model model) {
        Dept dept = deptdao.findOne(deptId);
        User deptmanage = null;
        if (dept.getDeptmanager() != null) {
            deptmanage = udao.findOne(dept.getDeptmanager());
            model.addAttribute("deptmanage", deptmanage);
        }
        List<Dept> depts = (List<Dept>) deptdao.findAll();
        //根据部门ID（1L)和职位名name是以经理结尾的（返回职位列表）
        List<Position> positions = pdao.findByDeptidAndNameNotLike(1L, "%经理");
        System.out.println(deptmanage);
        List<User> formaluser = new ArrayList<>();
        //根据部门获取用户列表（是这个部门的用户）
        List<User> deptusers = udao.findByDept(dept);

        for (User deptuser : deptusers) {
        //从用户里面获取用户的职位信息
            Position position = deptuser.getPosition();
            System.out.println(deptuser.getRealName() + ":" + position.getName());
            if (!position.getName().endsWith("经理")) {
                formaluser.add(deptuser);
            }
        }
        System.out.println(deptusers);
        model.addAttribute("positions", positions);
        model.addAttribute("depts", depts);
        model.addAttribute("deptuser", formaluser);

        model.addAttribute("dept", dept);
        model.addAttribute("isread", 1);

        return "user/deptread";

    }
  */

//自己的，人事调动

    @RequestMapping("readdept")
    public String readdept(@RequestParam(value = "deptid") Long deptId, Model model) {
        Dept dept = deptServiceV2.getDeptbyDeptId(deptId);

        User deptManage = null;
        if (dept.getDeptmanager() != null) {
            //获取到的用户信息没有部门，职位信息
            deptManage = userServiceV2.getUserBydeptManager(dept);
            model.addAttribute("deptmanage", deptManage);
        }
        List<Dept>deptList = deptServiceV2.getDeptList();
        List<Position>positionList = positionServiceV2.getPositionListByDeptIdAndNameLike();

        List<User> formaluser = new ArrayList<>();
        List<UserPO>userPOList = userServiceV2.getUserByDeptId(dept);

        for (UserPO deptuserPO : userPOList) {
            Position position = positionServiceV2.getPositionByPositionId(deptuserPO.getPositionId());
            System.out.println(deptuserPO.getRealName() + ":" + position.getName());
            User deptuser = UserFactory.create(deptuserPO);
            if (!position.getName().endsWith("经理")) {

                formaluser.add(deptuser);
            }
        }

        model.addAttribute("positions", positionList);
        model.addAttribute("depts", deptList);
        model.addAttribute("deptuser", formaluser);
        model.addAttribute("dept", dept);
        model.addAttribute("isread", 1);

        return "user/deptread";

    }

/*
    @RequestMapping("deptandpositionchange")
    public String deptandpositionchange(@RequestParam("positionid") Long positionid,
                                        @RequestParam("changedeptid") Long changedeptid,
                                        @RequestParam("userid") Long userid,
                                        @RequestParam("deptid") Long deptid,
                                        Model model) {
        //根据用户信息查找用户信息
        User user = udao.findOne(userid);
        Dept changedept = deptdao.findOne(changedeptid);
        //根据职位ID获取职位信息
        Position position = pdao.findOne(positionid);
        user.setDept(changedept);
        user.setPosition(position);
        //更新user,保存设置的信息
        udao.save(user);
        System.out.println(deptid);
        model.addAttribute("deptid", deptid);
        return "/readdept";
    }
*/
    //自己写的
    @RequestMapping("deptandpositionchange")
    public String deptandpositionchange(@RequestParam("positionid") Long positionId,
                                        @RequestParam("changedeptid") Long changedeptId,
                                        @RequestParam("userid") Long userId,
                                        @RequestParam("deptid") Long deptId,
                                        Model model) {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        User user = userServiceV2.getUserByUserId(userId);
        Dept changeDept =deptServiceV2.getDeptbyDeptId(changedeptId);
        Position position =positionServiceV2.getPositionByPositionId(positionId);
        user.setDept(changeDept);
        user.setPosition(position);
        userServiceV2.updateUser(userPO);
        model.addAttribute("deptid", deptId);
        return "/readdept";
    }


    /*
    //删除部门
    @RequestMapping("deletdept")
    public String deletdept(@RequestParam("deletedeptid") Long deletedeptid) {
        //根据部门ID获取部门信息
        Dept dept = deptdao.findOne(deletedeptid);
        //根据部门ID获取职位信息
        List<Position> ps = pdao.findByDeptid(deletedeptid);
        for (Position position : ps) {
            System.out.println(position);
            pdao.delete(position);
        }
        deptdao.delete(dept);
        return "/deptmanage";

    }
*/

    //自己写的
    @RequestMapping("deletdept")
    public String deletdept(@RequestParam("deletedeptid") Long deletedeptid) {
        Dept dept = deptServiceV2.getDeptbyDeptId(deletedeptid);
        List<Position> positionList = positionServiceV2.getPositionByDeptId(deletedeptid);
        for (Position position : positionList) {
            positionPOMapper.deleteByPrimaryKey(position.getId());
        }
        deptPOMapper.deleteByPrimaryKey(dept.getDeptId());
        return "/deptmanage";

    }

/*
    @RequestMapping("deptmanagerchange")
    public String deptmanagerchange(@RequestParam(value = "positionid", required = false) Long positionid,
                                    @RequestParam(value = "changedeptid", required = false) Long changedeptid,
                                    @RequestParam(value = "oldmanageid", required = false) Long oldmanageid,
                                    @RequestParam(value = "newmanageid", required = false) Long newmanageid,
                                    @RequestParam("deptid") Long deptid,
                                    Model model) {
        System.out.println("oldmanageid:" + oldmanageid);
        System.out.println("newmanageid:" + newmanageid);
        Dept deptnow = deptdao.findOne(deptid);
        if (oldmanageid != null) {
            User oldmanage = udao.findOne(oldmanageid);
            Position namage = oldmanage.getPosition();
            Dept changedept = deptdao.findOne(changedeptid);
            Position changeposition = pdao.findOne(positionid);
            oldmanage.setDept(changedept);
            oldmanage.setPosition(changeposition);
            udao.save(oldmanage);
            if (newmanageid != null) {
                User newmanage = udao.findOne(newmanageid);
                newmanage.setPosition(namage);
                deptnow.setDeptmanager(newmanageid);
                deptdao.save(deptnow);
                udao.save(newmanage);
            } else {
                deptnow.setDeptmanager(null);
                deptdao.save(deptnow);
            }
        } else {
            User newmanage = udao.findOne(newmanageid);
            Position manage = pdao.findByDeptidAndNameLike(deptid, "%经理").get(0);
            newmanage.setPosition(manage);
            deptnow.setDeptmanager(newmanageid);
            deptdao.save(deptnow);
            udao.save(newmanage);
        }
        model.addAttribute("deptid", deptid);
        return "/readdept";
    }
    */
}
