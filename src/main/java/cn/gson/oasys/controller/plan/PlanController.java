package cn.gson.oasys.controller.plan;

import cn.gson.oasys.common.StringtoDate;
import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.controller.attendce.AttendancesController;
import cn.gson.oasys.modelV2.bo.PageInformation;
import cn.gson.oasys.modelV2.po.*;
import cn.gson.oasys.serviceV2.attachmentV2.AttachmentServiceV2;
import cn.gson.oasys.serviceV2.deptV2.DeptPOServiceV2;
import cn.gson.oasys.serviceV2.planV2.PlanListPOServiceV2;
import cn.gson.oasys.serviceV2.planV2.PlanServiceV2;
import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.voandfactory.deptVO2.DeptVO;
import cn.gson.oasys.voandfactory.deptVO2.DeptVOFactory;
import cn.gson.oasys.voandfactory.planVO2.PlanListVO;
import cn.gson.oasys.voandfactory.planVO2.PlanListVOFactory;
import cn.gson.oasys.voandfactory.userVO2.UserVO;
import cn.gson.oasys.voandfactory.userVO2.UserVOFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping("/")
public class PlanController {

    Date startDate, endDate;
    String choose2;
    // 格式转化导入
    DefaultConversionService defaultConversionService = new DefaultConversionService();

    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private PlanServiceV2 planServiceV2;
    @Resource
    private PlanListPOServiceV2 planListPOServiceV2;
    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private StatusPOServiceV2 statusPOServiceV2;
    @Resource
    private DeptPOServiceV2 deptPOServiceV2;
    @Resource
    private AttachmentServiceV2 attachmentServiceV2;
    @Resource
    PageInformation pageInformation;

    // 计划管理
    @RequestMapping(value = "planview", method = RequestMethod.GET)
    public String planView(Model model, HttpSession session,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "baseKey", required = false) String baseKey,
                           @RequestParam(value = "type", required = false) String type,
                           @RequestParam(value = "status", required = false) String status,
                           @RequestParam(value = "time", required = false) String time,
                           @RequestParam(value = "icon", required = false) String icon) {
        sortPaging(model, session, page, baseKey, type, status, time, icon);
        return "plan/planview";
    }

    private void sortPaging(Model model, HttpSession session, int page, String baseKey, String type, String status,
                            String time, String icon) {
        new AttendancesController().setModelSomething(baseKey, type, status, time, icon, model);
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        List<PlanListPO> planListPOS = planServiceV2.sortAndGetPlanListS(baseKey, userId, type, status, time);
        List<PlanListPO> subPlanListPOS = pageInformation.getPlanListPOSPage(page, 10, planListPOS, model);
        List<PlanListVO> planListVOS = PlanListVOFactory.createPlanListVOSByPlanListPOS(subPlanListPOS);
        for (PlanListPO planListPO : planListPOS) {
            for (PlanListVO planListVO : planListVOS) {
                if (planListPO.getPlanId().equals(planListVO.getPlanId())) {
                    UserPO userPO = userPOServiceV2.getUserPOByUserId(planListPO.getPlanUserId());
                    UserVO userVO = UserVOFactory.createUserVOByUserPO(userPO);
                    DeptPO deptPO = deptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId());
                    DeptVO deptVO = DeptVOFactory.createDeptVOByDeptPO(deptPO);
                    userVO.setDeptVO(deptVO);
                    planListVO.setUserVO(userVO);
                }
            }
        }
        typeAndStatus(model);
        model.addAttribute("plist", planListVOS);
        model.addAttribute("url", "planviewtable");
    }

    private void typeAndStatus(Model model) {
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_plan_list");
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_plan_list");
        model.addAttribute("typelist", typePOList);
        model.addAttribute("statuslist", statusPOList);
    }

    // 模糊搜索即分页
    @RequestMapping(value = "planviewtable", method = RequestMethod.GET)
    public String planViewTable(Model model, HttpSession session,
                                @RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "baseKey", required = false) String baseKey,
                                @RequestParam(value = "type", required = false) String type,
                                @RequestParam(value = "status", required = false) String status,
                                @RequestParam(value = "time", required = false) String time,
                                @RequestParam(value = "icon", required = false) String icon) {
        sortPaging(model, session, page, baseKey, type, status, time, icon);
        return "plaPn/planviewtable";
    }

    // 计划管理>增加或修改
    @RequestMapping("planedit")
    public String planEdit(HttpServletRequest request, Model model) {
        typeAndStatus(model);
        //从planviewtable 页面获取pid(增加=-1和修改>0）
        long planId = Long.valueOf(request.getParameter("pid"));
        if (!StringUtils.isEmpty(request.getAttribute("errormess"))) {
            request.setAttribute("errormess", request.getAttribute("errormess"));
            request.setAttribute("plan", request.getAttribute("plan2"));
        } else if (!StringUtils.isEmpty(request.getAttribute("success"))) {
            request.setAttribute("success", request.getAttribute("success"));
            request.setAttribute("plan", request.getAttribute("plan2"));
        }
        // 新建
        if (planId == -1) {
            model.addAttribute("plan", null);
            model.addAttribute("pid", planId);
            return "plan/planadd";
        } else if (planId > 0) {
            PlanListPO planListPO = planListPOServiceV2.getPlanListPOByPlanId(planId);
            PlanListVO planListVO = PlanListVOFactory.createPlanListVOByPlanListPO(planListPO);
            model.addAttribute("plan", planListVO);
            model.addAttribute("pid", planId);
            return "plan/planedit";
        }
        return null;

    }

    /**
     * 计划管理>增加或修改保存
     *
     * @param file
     * @param req
     * @param planListVO
     * @param br
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping(value = "plansave", method = RequestMethod.POST)
    public String planSave(@RequestParam("file") MultipartFile file, HttpServletRequest req,
                           @Valid PlanListVO planListVO, BindingResult br) throws IllegalStateException, IOException {
        defaultConversionService.addConverter(new StringtoDate());
        // 格式化开始日期和结束日期
        Date start = defaultConversionService.convert(planListVO.getStartTime(), Date.class);
        Date end = defaultConversionService.convert(planListVO.getEndTime(), Date.class);

        AttachmentListPO attachmentListPO = null;
        Long attachmentListPOId = null;
        PlanListPO planListPO = null;
        //获取用户ID在获取用户信息
        HttpSession session = req.getSession();
        long userId = Long.valueOf(session.getAttribute("userId") + "");
        UserPO userPO = userPOServiceV2.getUserPOByUserId(userId);

        String typeName = req.getParameter("type");//类型名
        String statusName = req.getParameter("status");//状态名
        Long typeId = typePOServiceV2.getTypePOByTypeModelAndTypeName("aoa_plan_list", typeName).getTypeId();//类型id
        Long statusId = statusPOServiceV2.getStatusPOByTypeModelAndStatusName("aoa_plan_list", statusName).getStatusId();//状态id
        Long planId = Long.valueOf(req.getParameter("pid") + "");//计划id
        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
        } else {
            // 校验通过，下面写自己的逻辑业务
            if (!StringUtils.isEmpty(session.getAttribute("getId"))) {
                System.out.println("验证通过");
            }
            if (!file.isEmpty()) {
                //存在附件
                attachmentListPO = attachmentServiceV2.uploadAttachmentListPO(file, userPO);
                attachmentServiceV2.insertAttachmentListPO(attachmentListPO);
                attachmentListPOId = attachmentListPO.getAttachmentId();
            }
            if (planId == -1) {// 新建
                planListPO = planServiceV2.insertOrUpdatePlanListPO(typeId, statusId, attachmentListPOId, start, end, planListVO, userId);
            }
            if (planId > 0) {
                planListPO = planServiceV2.insertOrUpdatePlanListPO(typeId, statusId, attachmentListPOId, start, end, planListVO, userId);
            }
            req.setAttribute("success", "后台验证成功");
        }
        req.setAttribute("plan2", planListPO);
        return "forward:/planedit";
    }

    /**
     * 计划管理的删除
     *
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("plandelete")
    public String planDelete(HttpServletRequest request, HttpSession session) {
        //登录人ID
        Long loginUserId = Long.valueOf(session.getAttribute("userId") + "");
        //计划id
        Long planId = Long.valueOf(request.getParameter("pid"));
        //发布计划人id
        Long planUserId = planListPOServiceV2.getPlanListPOByPlanId(planId).getPlanUserId();
        //根据登录用户和发布人用户相同才能删除
        if (loginUserId.equals(planUserId)) {
            planListPOServiceV2.deletePlanListPOByPlanListPOId(planId);
            return "redirect:/planview";
        } else {
            return "redirect:/notlimit";
        }

    }

    // 计划报表
    @RequestMapping("myplan")
    public String myPlan(HttpServletRequest request, Model model, HttpSession session,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey) {
        planTablePaging(request, model, session, page, baseKey);
        return "plan/plantable";
    }

    //    计划报表
    private void planTablePaging(HttpServletRequest request, Model model, HttpSession session, int page,
                                 String baseKey) {
        //根据计划类型模型找类型列表
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_plan_list");
        //根据状态模型找状态列表
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_plan_list");
        model.addAttribute("type", typePOList);
        model.addAttribute("status", statusPOList);

        Set<Long> longSet = new HashSet<>();
        Long typeId = 13L;//默认为日计划
        Long choose;//默认选择

        defaultConversionService.addConverter(new StringtoDate());
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        Date start = defaultConversionService.convert(starttime, Date.class);
        Date end = defaultConversionService.convert(endtime, Date.class);

        String choose1 = request.getParameter("choose");//从前端获取的选择

        //分页的时候记住
        if (start == null && end == null && choose1 == null) {
            start = startDate;
            end = endDate;
            choose1 = choose2;
        }
        if (start != null && end != null && choose1 != null) {
            startDate = start;
            endDate = end;
            choose2 = choose1;
        }
        // 1是日计划2是周计划3是月计划
        if (choose1 == null || choose1.length() == 0) {
            choose = 1l;
        } else {
            choose = Long.valueOf(choose1);
        }
        if (choose == 1) {
            typeId = 13l;//日计划
        }
        if (choose == 2) {
            typeId = 14l;// 周计划
        }
        if (choose == 3) {
            typeId = 15l;//月计划
        }


        List<PlanListPO> planListPOSAll = planServiceV2.getPlanListPOSAll();//所有计划
        Set<Long> userIds = new HashSet();//所有计划的发布用户ID
        for (PlanListPO planListPO1 : planListPOSAll) {
            userIds.add(planListPO1.getPlanUserId());
        }

        List<PlanListPO> planListPOSFirst = new ArrayList<>();//用于添加用户的第一个计划记录
        // 找到用户相对应的根据创建时间降序第一个计划相对应的计划记录
        PlanListPO planListPO;
        for (Long userId : userIds) {
            planListPO = planServiceV2.getPlanListPOByUserIdAndTypeIdAndCreateTime(userId, start, end, typeId);
            if (planListPO != null) {
                planListPOSFirst.add(planListPO);
            }
        }

        // 登录ID
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        //获取下属信息
        List<UserPO> userPOList = userPOServiceV2.getUserPOListByFatherId(userId);
        List<UserPO> subUserPOList = pageInformation.getUserPOListPage(page, 10, userPOList, model);
        List<UserVO> userVOList = UserVOFactory.createUserVOListByUserPOList(subUserPOList);
        for (UserVO userVO : userVOList) {
            for (UserPO userPO : userPOList) {
                if (userPO.getUserId().equals(userVO.getUserId())) {
                    userVO.setDeptVO(DeptVOFactory.createDeptVOByDeptPO(deptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId())));
                }
            }
        }
        Map<String, PlanListPO> uMap = new HashMap<>();// 用户名和计划对应
        for (UserPO userPO : userPOList) {//遍历下属用户
            if (planListPOSFirst.size() == 0) {
                uMap.put(userPO.getUserName(), null);
            }
            for (PlanListPO planListPO1 : planListPOSFirst) {
                //下属用户id和发布计划用户id
                if (Objects.equals(userPO.getUserId(), planListPO1.getPlanUserId())) {
                    uMap.put(userPO.getUserName(), planListPO1);
                    break;
                }
//                else {
//                    uMap.put(userPO.getUserName(), null);
//                }
            }
        }
//可以根据下属用户id找出下属用户发布的计划（根据发布时间降序第一条）（下次改写）
        //记住开始时间和结束时间以及选择
        model.addAttribute("starttime", starttime);
        model.addAttribute("endtime", endtime);
        model.addAttribute("choose", choose1);

        model.addAttribute("uMap", uMap);//用户名和计划对应
        model.addAttribute("plans", planListPOSFirst);//用户的第一条计划
        model.addAttribute("plist", planListPOSAll);//所有计划
        model.addAttribute("ulist", userVOList);//下属用户信息
        model.addAttribute("url", "realplantable");//真正报表信息
    }

    // 真正的报表
    @RequestMapping("realplantable")
    public String realPlanTable(HttpServletRequest request, Model model, HttpSession session,
                                @RequestParam(value = "pid", required = false) String pid,
                                @RequestParam(value = "comment", required = false) String comment,
                                @RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "baseKey", required = false) String baseKey) {
//        Long planId = Long.valueOf(request.getParameter("pid"));
        planTablePaging(request, model, session, page, baseKey);
        if (!StringUtils.isEmpty(pid)) {
            PlanListPO planListPO = planListPOServiceV2.getPlanListPOByPlanId(Long.valueOf(pid));
            if (planListPO.getPlanComment() == null) {
                planListPO.setPlanComment(comment);
            } else {
                planListPO.setPlanComment(planListPO.getPlanComment());
            }
            planServiceV2.updatePlanListPOCommentByPlanListPO(planListPO, comment);
        }
        return "plan/realplantable";
    }

    //模糊查询
    @RequestMapping(value = "dimSelect")
    public String dimSelect(Model model, HttpSession session,
                            @RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "baseKey", required = false) String baseKey,
                            @RequestParam(value = "type", required = false) String type,
                            @RequestParam(value = "status", required = false) String status,
                            @RequestParam(value = "time", required = false) String time,
                            @RequestParam(value = "icon", required = false) String icon) throws ParseException {
        sortPaging(model, session, page, baseKey, type, status, time, icon);
        return "plan/planview";
    }

}
