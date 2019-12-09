package cn.gson.oasys.controller.system;


import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.model.po.StatusPO;
import cn.gson.oasys.vo.StatusVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/")
public class StatusSysController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private StatusServiceV2 statusServiceV2;

    /**
     * 状态表格界面
     *
     * @param req
     * @return
     */
    @RequestMapping("testsysstatus")
    public String testsysstatus(HttpServletRequest req) {
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOListAll();//获取所有状态
        req.setAttribute("statusList", statusPOList);
        return "systemcontrol/statusmanage";
    }

    /**
     * 删除方法
     */
    @RequestMapping("deletestatus")
    public String deleteStatus(HttpServletRequest req) {
        Long statusId = Long.parseLong(req.getParameter("id"));
        statusServiceV2.deleteStatusPOByStatusId(statusId);
        return "forward:/testsysstatus";
    }

    /**
     * 状态编辑界面
     *
     * @param req
     * @return
     */
    @RequestMapping("statusedit")
    public String typeEdit(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getParameter("statusid"))) {
            Long statusId = Long.parseLong(req.getParameter("statusid"));
            StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(statusId);
            req.setAttribute("status", statusPO);
            HttpSession session = req.getSession();
            session.setAttribute("statusid", statusId);
        }
        return "systemcontrol/statusedit";
    }

    /**
     * 系统管理表单验证
     *
     * @param req
     * @param statusVO
     * @param br       后台校验表单数据，不通过则回填数据，显示错误信息；通过则直接执行业务，例如新增、编辑等；
     * @return
     */
    @RequestMapping("statuscheck")
    public String testMess(HttpServletRequest req, @Valid StatusVO statusVO, BindingResult br) {
        req.setAttribute("menuObj", statusVO);
        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {// 校验失败
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
        } else {// 校验通过，下面写自己的逻辑业务
            HttpSession session = req.getSession();
            // 判断是否从编辑界面进来的，前面有"session.setAttribute("getId",getId);",在这里获取，并remove掉；
            if (!StringUtils.isEmpty(session.getAttribute("statusid"))) {
                Long menuId = (Long) session.getAttribute("statusid"); // 获取进入编辑界面的menuID值
                statusVO.setStatusId(menuId);
                session.removeAttribute("statusid");
            }
            // 执行业务代码
            StatusPO statusPO = new StatusPO();
            statusPO.setStatusId(statusVO.getStatusId());
            statusPO.setStatusName(statusVO.getStatusName());
            statusPO.setStatusColor(statusVO.getStatusColor());
            statusPO.setSortPrecent(statusVO.getStatusPercent());
            statusPO.setSortValue(statusVO.getStatusSortValue());
            statusPO.setStatusModel(statusVO.getStatusModel());
            statusServiceV2.insertOrUpdateStatusPOByStatusId(statusPO);
            req.setAttribute("success", "后台验证成功");
        }
        return "systemcontrol/statusedit";
    }

    /**
     * 查找状态表格
     *
     * @param req
     * @return
     */
    @RequestMapping("statustable")
    public String statusTable(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getParameter("name"))) {
            String name = req.getParameter("name");
            List<StatusPO> statusPOList = statusServiceV2.getStatusPOListByTypeModelLikeAndStatusNameLike(name);
            req.setAttribute("statusList", statusPOList);
        } else {
            List<StatusPO> statusPOList = statusServiceV2.getStatusPOListAll();
            req.setAttribute("statusList", statusPOList);
        }
        return "systemcontrol/statustable";
    }

    /**
     * 查看状态界面
     *
     * @param req
     * @return
     */
    @RequestMapping("lookstatus")
    public String lookStatus(HttpServletRequest req) {
        if (!StringUtils.isEmpty(req.getParameter("statusid"))) {
            Long statusId = Long.parseLong(req.getParameter("statusid"));
            StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(statusId);
            req.setAttribute("status", statusPO);
        }
        return "systemcontrol/lookstatus";
    }

}
