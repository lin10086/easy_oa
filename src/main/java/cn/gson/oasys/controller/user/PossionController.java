package cn.gson.oasys.controller.user;

import java.util.List;

import cn.gson.oasys.ServiceV2.DeptServiceV2;
import cn.gson.oasys.ServiceV2.PositionServiceV2;
import cn.gson.oasys.factory.PositionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;

import javax.annotation.Resource;

@Controller
@RequestMapping("/")
public class PossionController {

    @Autowired
    PositionDao pdao;
    @Autowired
    DeptDao ddao;
    @Resource
    private PositionServiceV2 positionServiceV2;

    @Resource
    private DeptServiceV2 deptServiceV2;
/*
    //第一次进入，用户管理》职位管理（职位列表）
    @RequestMapping("positionmanage")
    public String positionmanage(Model model) {

        List<Position> positions = (List<Position>) pdao.findAll();

        model.addAttribute("positions",positions);

        return "user/positionmanage";
    }



        //点击增加修改进入增加修改页面
    @RequestMapping(value = "positionedit", method = RequestMethod.GET)
    public String positioneditget(@RequestParam(value = "positionid", required = false) Long positionid, Model model) {
        if (positionid != null) {
            //根据职位ID获取职位信息（就是修改）
            Position position = pdao.findOne(positionid);
            System.out.println(position);
            //根据职位里面的部门ID获取部门信息
            Dept dept = ddao.findOne(position.getDeptid());

            model.addAttribute("positiondept", dept);
            model.addAttribute("position", position);
        }
        //获取所有的部门信息
        List<Dept> depts = (List<Dept>) ddao.findAll();
        model.addAttribute("depts", depts);
        return "user/positionedit";
    }

//用户管理》职位管理》增加，修改（
    @RequestMapping(value = "positionedit", method = RequestMethod.POST)
    public String positioneditpost(Position position, Model model) {
        System.out.println(position);
        Position psition2 = pdao.save(position);
        if (psition2 != null) {
            model.addAttribute("success", 1);
            return "/positionmanage";
        }
        model.addAttribute("errormess", "数据插入失败");
        return "user/positionedit";
    }
*/

/*
       //未用到
    @RequestMapping("removeposition")
    public String removeposition(@RequestParam("positionid") Long positionid, Model model) {
        pdao.delete(positionid);
        model.addAttribute("success", 1);
        return "/positionmanage";
    }
*/

    //=====================================


    @RequestMapping("positionmanage")
    public String positionmanage(Model model) {
//        List<Position> positionList = positionServiceV2.getPositionList();
//        model.addAttribute("positions", positionList);
        return "user/positionmanage";
    }


     @RequestMapping(value = "positionedit", method = RequestMethod.GET)
    public String positioneditget(@RequestParam(value = "positionid", required = false) Long positionId, Model model) {
        if (positionId != null) {
//            Position position = positionServiceV2.getPositionByPositionId(positionId);
//            Dept dept = deptServiceV2.getDeptbyDeptId(position.getDeptid());
//            model.addAttribute("positiondept", dept);
//            model.addAttribute("position", position);
        }
//        List<Dept>deptList = deptServiceV2.getDeptList();
//        model.addAttribute("depts", deptList);
        return "user/positionedit";
    }


     @RequestMapping(value = "positionedit", method = RequestMethod.POST)
    public String positioneditpost(Position position, Model model) {
        Integer rows ;
        if(position.getId()==null) {
             rows = positionServiceV2.insertPosition(position);
        }else {
             rows =positionServiceV2.updatePosition(position);
        }
        if (rows == 1) {
            model.addAttribute("success", 1);
            return "/positionmanage";
        }

        model.addAttribute("errormess", "数据插入失败");
        return "user/positionedit";
    }

}
