package cn.gson.oasys.controller.user;

import java.util.List;

import cn.gson.oasys.serviceV2.deptV2.DeptPOServiceV2;
import cn.gson.oasys.serviceV2.positionV2.PositionPOServiceV2;
import cn.gson.oasys.modelV2.po.DeptPO;
import cn.gson.oasys.modelV2.po.PositionPO;
import cn.gson.oasys.voandfactory.deptVO2.DeptVO;
import cn.gson.oasys.voandfactory.positionVO2.PositionVO;
import cn.gson.oasys.voandfactory.deptVO2.DeptVOFactory;
import cn.gson.oasys.voandfactory.positionVO2.PositionVOFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * 用户管理》职位管理控制器
 */
@Controller
@RequestMapping("/")
public class PositionController {

    @Resource
    private PositionPOServiceV2 positionPOServiceV2;
    @Resource
    private DeptPOServiceV2 deptPOServiceV2;

    /**
     * 用户管理》职位管理（显示职位列表）
     *
     * @param model
     * @return
     */
    @RequestMapping("positionmanage")
    public String positionManage(Model model) {
        List<PositionPO> positionPOList = positionPOServiceV2.getPositionListAll();//获取所有职位
        List<PositionVO> positionVOList = PositionVOFactory.createPositionVOListByPositionPOList(positionPOList);
        model.addAttribute("positions", positionVOList);
        return "user/positionmanage";
    }

    /**
     * 用于获取新增或修改的页面信息
     *
     * @param positionId 职位ID
     * @param model
     * @return
     */
    @RequestMapping(value = "positionedit", method = RequestMethod.GET)
    public String positionEditGet(@RequestParam(value = "positionId", required = false) Long positionId, Model model) {
        if (positionId != null) {
            PositionPO positionPO = positionPOServiceV2.getPositionPOByPositionId(positionId);
            PositionVO positionVO = PositionVOFactory.createPositionVOByPositionPO(positionPO);

            DeptPO deptPO = deptPOServiceV2.getDeptPOByDeptId(positionPO.getDeptid());
            DeptVO deptVO = DeptVOFactory.createDeptVOByDeptPO(deptPO);

            model.addAttribute("positionDept", deptVO);
            model.addAttribute("position", positionVO);
        }
        List<DeptPO> deptPOList = deptPOServiceV2.getDeptPOListAll();
        model.addAttribute("depts", deptPOList);
        return "user/positionedit";
    }

    /**
     * @param positionVO 页面提交过来的职位信息
     * @param model
     * @return
     */
    @RequestMapping(value = "positionedit", method = RequestMethod.POST)
    public String positionEditPost(PositionVO positionVO, Model model) {
        PositionPO positionPO = PositionVOFactory.createPositionPOByPositionVO(positionVO);
        Integer rows = positionPOServiceV2.insertOrUpdatePositionPO(positionPO);
        if (rows == 1) {
            model.addAttribute("success", 1);
            return "/positionmanage";
        }
        model.addAttribute("errormess", "数据插入失败");
        return "user/positionedit";
    }

    /**
     * 删除职位
     *
     * @param positionId 职位ID
     * @param model
     * @return
     */
    @RequestMapping("removeposition")
    public String removeposition(@RequestParam("positionid") Long positionId, Model model) {
        positionPOServiceV2.deletePosition(positionId);
        model.addAttribute("success", 1);
        return "/positionmanage";
    }

}
