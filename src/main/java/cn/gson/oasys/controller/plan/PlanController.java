package cn.gson.oasys.controller.plan;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.DeptPOServiceV2;
import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypePOServiceV2;
import cn.gson.oasys.ServiceV2.UserPOServiceV2;
import cn.gson.oasys.ServiceV2.mailV2.MailServiceV2;
import cn.gson.oasys.ServiceV2.planV2.PlanListServiceV2;
import cn.gson.oasys.ServiceV2.planV2.PlanServiceV2;
import cn.gson.oasys.ServiceV2.AttachmentServiceV2;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.DeptVO;
import cn.gson.oasys.vo.SelectVO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.factoryvo.DeptFactoryVO;
import cn.gson.oasys.vo.factoryvo.UserFactoryVO;
import cn.gson.oasys.vo.factoryvo.planFactory.PlanListVOFactory;
import cn.gson.oasys.vo.planVO2.PlanListVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.gson.oasys.common.StringtoDate;
import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.controller.attendce.AttendceController;
import cn.gson.oasys.model.dao.notedao.AttachmentDao;
import cn.gson.oasys.model.dao.plandao.PlanDao;
import cn.gson.oasys.model.dao.plandao.Planservice;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.dao.user.UserService;
import cn.gson.oasys.services.file.FileServices;

@Controller
@RequestMapping("/")
public class PlanController {

    @Autowired
    PlanDao planDao;
    @Autowired
    Planservice planservice;
    @Autowired
    TypeDao typeDao;
    @Autowired
    StatusDao statusDao;
    @Autowired
    FileServices fServices;
    @Autowired
    UserDao userDao;
    @Autowired
    UserService userService;
    @Autowired
    AttachmentDao attachmentDao;


    Date startDate, endDate;
    String choose2;
    Logger log = LoggerFactory.getLogger(getClass());
    // 格式转化导入
    DefaultConversionService service = new DefaultConversionService();

   /* @RequestMapping("plandelete")
    public String DSAGec(HttpServletRequest request, HttpSession session) {
        long realuserid = Long.valueOf(session.getAttribute("userId") + "");
        long pid = Long.valueOf(request.getParameter("pid"));
        long userid = planDao.findOne(pid).getUser().getUserId();
        if (userid == realuserid) {
            planservice.delete(pid);
            return "redirect:/planview";
        } else {
            System.out.println("没有权限");
            return "redirect:/notlimit";
        }

    }*/

/*
	// 计划管理
	@RequestMapping(value="planview", method = RequestMethod.GET)
	public String test(Model model, HttpSession session, 
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "baseKey", required = false) String baseKey,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "time", required = false) String time,
			@RequestParam(value = "icon", required = false) String icon) {
		System.out.println("11"+baseKey);
		sortpaging(model, session, page, baseKey, type, status, time, icon);
		return "plan/planview";
	}
*/


   /* @RequestMapping(value = "planviewtable", method = RequestMethod.GET)
    public String testdd(Model model, HttpSession session,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon) {
        System.out.println("222" + baseKey);
        sortpaging(model, session, page, baseKey, type, status, time, icon);
        return "plan/planviewtable";
    }*/

  /*  // 计划报表
    @RequestMapping("myplan")
    public String test2(HttpServletRequest request, Model model, HttpSession session,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "baseKey", required = false) String baseKey) {
        plantablepaging(request, model, session, page, baseKey);
        return "plan/plantable";
    }*/

   /* // 真正的报表
    @RequestMapping("realplantable")
    public String test23(HttpServletRequest request, Model model, HttpSession session,
                         @RequestParam(value = "pid", required = false) String pid,
                         @RequestParam(value = "comment", required = false) String comment,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey) {
        System.out.println("pid的" + pid);
        plantablepaging(request, model, session, page, baseKey);
        if (!StringUtils.isEmpty(pid)) {
            Plan plan = planDao.findOne(Long.valueOf(pid));
            if (plan.getPlanComment() == null)
                plan.setPlanComment(comment);
            else
                plan.setPlanComment(plan.getPlanComment() + comment);
            planDao.save(plan);
        }
        return "plan/realplantable";
    }*/

	

	/*// 我的编辑
	@RequestMapping("planedit")
	public String test3(HttpServletRequest request, Model model) {
		long pid = Long.valueOf(request.getParameter("pid"));
		if (!StringUtils.isEmpty(request.getAttribute("errormess"))) {
			request.setAttribute("errormess", request.getAttribute("errormess"));
			request.setAttribute("plan", request.getAttribute("plan2"));
		} else if (!StringUtils.isEmpty(request.getAttribute("success"))) {
			request.setAttribute("success", request.getAttribute("success"));
			request.setAttribute("plan", request.getAttribute("plan2"));
		}
		// 新建
		if (pid == -1) {
			model.addAttribute("plan", null);
			model.addAttribute("pid", pid);
		} else if (pid > 0) {
			Plan plan = planDao.findOne(pid);
			model.addAttribute("plan", plan);
			model.addAttribute("pid", pid);
		}

		typestatus(model);
		return "plan/planedit";
	}*/


//    @RequestMapping(value = "plansave", method = RequestMethod.GET)
//    public void Datagr() {
//    }

   /* @RequestMapping(value = "plansave", method = RequestMethod.POST)
    public String testMess(@RequestParam("file") MultipartFile file, HttpServletRequest req, @Valid Plan plan2,
                           BindingResult br) throws IllegalStateException, IOException {
        service.addConverter(new StringtoDate());
        // 格式化开始日期和结束日期
        Date start = service.convert(plan2.getStartTime(), Date.class);
        Date end = service.convert(plan2.getEndTime(), Date.class);
        Attachment att = null;
        Long attid = null;
        Plan plan = null;

        HttpSession session = req.getSession();
        long userid = Long.valueOf(session.getAttribute("userId") + "");
        User user = userDao.findOne(userid);

        // 获取到类型和状态id
        String type = req.getParameter("type");
        String status = req.getParameter("status");
        long typeid = typeDao.findByTypeModelAndTypeName("aoa_plan_list", type).getTypeId();
        long statusid = statusDao.findByStatusModelAndStatusName("aoa_plan_list", status).getStatusId();
        long pid = Long.valueOf(req.getParameter("pid") + "");

        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
        }
        // 校验通过，下面写自己的逻辑业务
        else {
            if (!StringUtils.isEmpty(session.getAttribute("getId"))) {
                System.out.println("验证通过，进入狗太了");
            }
            // 新建
            if (pid == -1) {
                if (!file.isEmpty()) {
                    att = (Attachment) fServices.savefile(file, user, null, false);
                    attid = att.getAttachmentId();
                } else if (file.isEmpty())
                    attid = null;

                plan = new Plan(typeid, statusid, attid, start, end, new Date(), plan2.getTitle(), plan2.getLabel(),
                        plan2.getPlanContent(), plan2.getPlanSummary(), null, user);
                planDao.save(plan);
            }
            if (pid > 0) {
                plan = planDao.findOne(pid);
                if (plan.getAttachId() == null) {
                    if (!file.isEmpty()) {
                        att = (Attachment) fServices.savefile(file, user, null, false);
                        attid = att.getAttachmentId();
                        plan.setAttachId(attid);
                        planDao.save(plan);
                    }
                }
                if (plan.getAttachId() != null)
                    fServices.updateatt(file, user, null, plan.getAttachId());
                planservice.updateplan(typeid, statusid, start, end, plan2.getTitle(), plan2.getLabel(),
                        plan2.getPlanContent(), plan2.getPlanSummary(), pid);

            }
            req.setAttribute("success", "后台验证成功");
        }
        req.setAttribute("plan2", plan2);
        return "forward:/planedit";
    }
*/
/*
	private void typestatus(Model model) {
		List<SystemTypeList> type = (List<SystemTypeList>) typeDao.findByTypeModel("aoa_plan_list");
		List<SystemStatusList> status = (List<SystemStatusList>) statusDao.findByStatusModel("aoa_plan_list");
		model.addAttribute("typelist", type);
		model.addAttribute("statuslist", status);
	}
	*/
/*	private void sortpaging(Model model, HttpSession session, int page, String baseKey, String type, String status,
			String time, String icon) {
		new AttendceController().setModelSomething(baseKey, type, status, time, icon, model);
		Long userid = Long.valueOf(session.getAttribute("userId") + "");
		User user = userDao.findOne(userid);
		Page<Plan> page2 = planservice.paging(page, baseKey, userid, type, status, time);
		typestatus(model);
		model.addAttribute("plist", page2.getContent());
		model.addAttribute("page", page2);
		model.addAttribute("url", "planviewtable");
	}
*/
   /* //计划报表
    private void plantablepaging(HttpServletRequest request, Model model, HttpSession session, int page,
                                 String baseKey) {
        List<SystemTypeList> type = (List<SystemTypeList>) typeDao.findByTypeModel("aoa_plan_list");
        List<SystemStatusList> status = (List<SystemStatusList>) statusDao.findByStatusModel("aoa_plan_list");
        List<Plan> plans = new ArrayList<>();
        // 利用set过滤掉重复的plan_user_id 因为set不能重复
        Set<Long> number = new HashSet();
        Plan plan2;
        long typeid = 13;
        Long choose;
        service.addConverter(new StringtoDate());
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        System.out.println(starttime + ";" + endtime);
        Date start = service.convert(starttime, Date.class);
        Date end = service.convert(endtime, Date.class);
        String choose1 = request.getParameter("choose");
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
        if (choose1 == null || choose1.length() == 0)
            choose = 1l;
        else
            choose = Long.valueOf(choose1);
        if (choose == 1) {
            typeid = 13l;
        }
        if (choose == 2) {
            typeid = 14l;
        }
        if (choose == 3) {
            typeid = 15l;
        }
        pList = (List<Plan>) planDao.findAll();
        Long userid = Long.valueOf(session.getAttribute("userId") + "");
        Page<User> uListpage = userService.findmyemployuser(page, baseKey, userid);
        for (Plan plan : pList) {
            number.add(plan.getUser().getUserId());
        }
        System.out.println(number);
        // 找到相对应的计划记录
        for (Long num : number) {
            plan2 = planDao.findlatest(start, end, num, typeid);
            if (plan2 != null)
                plans.add(plan2);
        }
        System.out.println("有没有plan" + plans);
        // 将用户名和list绑定在一起
        Map<String, Plan> uMap = new HashMap<>();
        for (User user : uListpage) {
            if (plans.size() == 0)
                uMap.put(user.getUserName(), null);
            for (Plan plan : plans) {
                if (Objects.equals(user.getUserId(), plan.getUser().getUserId())) {
                    uMap.put(user.getUserName(), plan);
                    break;
                } else {
                    uMap.put(user.getUserName(), null);
                }
            }
            System.out.println("map" + uMap);
        }
        System.out.println(uListpage.getContent());

        //记住开始时间和结束时间以及选择
        model.addAttribute("starttime", starttime);
        model.addAttribute("endtime", endtime);
        model.addAttribute("choose", choose1);

        model.addAttribute("uMap", uMap);
        model.addAttribute("type", type);
        model.addAttribute("status", status);
        model.addAttribute("plans", plans);
        model.addAttribute("plist", pList);
        model.addAttribute("ulist", uListpage.getContent());
        model.addAttribute("page", uListpage);
        model.addAttribute("url", "realplantable");
    }*/

    //==============================================
    @Resource
    private UserPOServiceV2 userServiceV2;
    @Resource
    private PlanServiceV2 planServiceV2;
    @Resource
    private PlanListServiceV2 planListServiceV2;
    @Resource
    private TypePOServiceV2 typeServiceV2;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private DeptPOServiceV2 deptServiceV2;
    @Resource
    private MailServiceV2 mailServiceV2;
    @Resource
    private AttachmentServiceV2 attachmentServiceV2;


    // 计划管理
 /*   @RequestMapping(value = "planview", method = RequestMethod.GET)
    public String test(Model model, HttpSession session,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "baseKey", required = false) String baseKey,
                       SelectVO selectVO,
                       @RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "status", required = false) String status,
                       @RequestParam(value = "time", required = false) String time,
                       @RequestParam(value = "icon", required = false) String icon) {
        System.out.println("11" + baseKey);
        sortpaging(model, session, page, baseKey, type, status, time, icon, selectVO);
        return "plan/planview";
    }
*/


    // 模糊搜索
  /*  @RequestMapping(value = "planviewtable", method = RequestMethod.GET)
    public String testdd(Model model, HttpSession session,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon) {
        System.out.println("222" + baseKey);
        sortpaging(model, session, page, baseKey, type, status, time, icon);
        return "plan/planviewtable";
    }*/

    //   /**
//     * @param model
//     * @param session
//     * @param page
//     * @param baseKey
//     * @param type
//     * @param status
//     * @param time
//     * @param icon
//     */
   /* private void sortpaging(Model model, HttpSession session, int page, String baseKey, String type, String status,
                            String time, String icon) {
        new AttendceController().setModelSomething(baseKey, type, status, time, icon, model);
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        PageHelper.startPage(page, 10);
//        List<PlanListPO> planListPOS = planServiceV2.sortAndGetPlan(page, baseKey, userId, type, status, time);
        List<PlanListPO> planListPOS = planServiceV2.getPlanListPOSAll();
        List<PlanListVO> planListVOS = PlanListVOFactory.createPlanListVOS(planListPOS);
        for (PlanListPO planListPO : planListPOS) {
            for (PlanListVO planListVO : planListVOS) {
                if (planListPO.getPlanId().equals(planListVO.getPlanId())) {
                    UserPO userPO = userServiceV2.getUserPOByUserId(planListPO.getPlanUserId());
                    UserVO userVO = UserFactoryVO.createUserVO(userPO);
                    DeptPO deptPO = deptServiceV2.getDeptPOByDeptId(userPO.getDeptId());
                    DeptVO deptVO = DeptFactoryVO.createDeptVO(deptPO);
                    userVO.setDeptVO(deptVO);
                    planListVO.setUserVO(userVO);
                }
            }
        }
        PageInfo pageInfo = new PageInfo(planListPOS);
        typestatus(model);
        model.addAttribute("plist", planListVOS);
        model.addAttribute("page", pageInfo);
        model.addAttribute("url", "planviewtable");
    }
*/
    private void typestatus(Model model) {
        List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("aoa_plan_list");
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOByStatusModel("aoa_plan_list");
        model.addAttribute("typelist", typePOList);
        model.addAttribute("statuslist", statusPOList);
    }


  /*  // 计划管理>增加或修改
    @RequestMapping("planedit")
    public String test3(HttpServletRequest request, Model model) {
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
        } else if (planId > 0) {
            PlanListPO planListPO = planServiceV2.getPlanListPOByPlanId(planId);
            PlanListVO planListVO = PlanListVOFactory.createPlanListVO(planListPO);
            model.addAttribute("plan", planListVO);
            model.addAttribute("pid", planId);
        }

        typestatus(model);
        return "plan/planedit";
    }
*/
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
    public String testMess(@RequestParam("file") MultipartFile file, HttpServletRequest req, @Valid PlanListVO planListVO,
                           BindingResult br) throws IllegalStateException, IOException {
        service.addConverter(new StringtoDate());
        // 格式化开始日期和结束日期
        log.info("planListVO.getStartTime()={}", planListVO.getStartTime());
        Date start = service.convert(planListVO.getStartTime(), Date.class);
        log.info("start={}", start);
        Date end = service.convert(planListVO.getEndTime(), Date.class);

        AttachmentListPO attachmentListPO = null;
        Long attachmentListPOId = null;
        PlanListPO planListPO = null;
        HttpSession session = req.getSession();
        long userId = Long.valueOf(session.getAttribute("userId") + "");
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);

        String typeName = req.getParameter("type");//类型名
        String statusName = req.getParameter("status");//状态名
        Long typeId = typeServiceV2.getTypePOByTypeModelAndTypeName("aoa_plan_list", typeName).getTypeId();//类型id
        Long statusId = statusServiceV2.getStatusPOByTypeModelAndStatusName("aoa_plan_list", statusName).getStatusId();//状态id
        Long planId = Long.valueOf(req.getParameter("pid") + "");//计划id
        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
        } else {
            // 校验通过，下面写自己的逻辑业务
            if (!StringUtils.isEmpty(session.getAttribute("getId"))) {
                System.out.println("验证通过，进入狗太了");
            }
            if (!file.isEmpty()) {//存在附件
                attachmentListPO = mailServiceV2.uploadAttachmentListPO(file, userPO);
                attachmentServiceV2.insertAttachmentListPO(attachmentListPO);
                attachmentListPOId = attachmentListPO.getAttachmentId();
            }
            if (planId == -1) {// 新建
                planListPO = planServiceV2.insertOrUpdatePlanListPO(typeId, statusId, attachmentListPOId, start, end, planListVO, userId);
            }
            if (planId > 0) {
                planListVO.setPlanId(planId);//前后端名称不对称
                planListPO = planServiceV2.insertOrUpdatePlanListPO(typeId, statusId, attachmentListPOId, start, end, planListVO, userId);
            }
            req.setAttribute("success", "后台验证成功");
        }
        req.setAttribute("plan2", planListVO);
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
    public String DSAGec(HttpServletRequest request, HttpSession session) {
        Long loginUserId = Long.valueOf(session.getAttribute("userId") + "");//登录人id
        Long planId = Long.valueOf(request.getParameter("pid"));//计划id
        Long planUserId = planServiceV2.getPlanListPOByPlanId(planId).getPlanUserId();//发布计划人id
        //根据登录用户和发布人用户相同才能删除
        if (loginUserId.equals(planUserId)) {
            planServiceV2.deletePlanListPOByPlanListPOId(planId);

            return "redirect:/planview";
        } else {
            return "redirect:/notlimit";
        }

    }

    //------------------------------------------------
// 计划报表
    @RequestMapping("myplan")
    public String test2(HttpServletRequest request, Model model, HttpSession session,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "baseKey", required = false) String baseKey) {
        plantablepaging(request, model, session, page, baseKey);
        return "plan/plantable";
    }

    //计划报表
    private void plantablepaging(HttpServletRequest request, Model model, HttpSession session, int page,
                                 String baseKey) {
//        String choose2=null;
//        Date startDate = null;
//        Date endDate=null;
        List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("aoa_plan_list");//根据类型模型找类型列表
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOByStatusModel("aoa_plan_list");//根据状态模型找状态列表
        model.addAttribute("type", typePOList);
        model.addAttribute("status", statusPOList);

        Set<Long> longSet = new HashSet<>();
        Long typeId = 13L;//默认为日计划
        Long choose;//默认选择

        service.addConverter(new StringtoDate());
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        Date start = service.convert(starttime, Date.class);
        Date end = service.convert(endtime, Date.class);

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
        Set<Long> number = new HashSet();// 利用set过滤掉重复的plan_user_id 因为set不能重复
        for (PlanListPO planListPO1 : planListPOSAll) {
            number.add(planListPO1.getPlanUserId());//添加所有计划里用户id
        }

        List<PlanListPO> planListPOSFirst = new ArrayList<>();//用于添加用户的第一个计划记录
        // 找到用户相对应的根据创建时间降序第一个计划相对应的计划记录
        PlanListPO planListPO;
        for (Long num : number) {
            planListPO = planServiceV2.getPlanListPOByUserIdAndTypeIdAndCreateTime(num, start, end, typeId);
            if (planListPO != null)
                planListPOSFirst.add(planListPO);
        }

        // 将下属用户名和计划绑定在一起
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        PageHelper.startPage(page, 10);
        List<UserPO> userPOList = userServiceV2.getUserPOListByFatherIdAndUsernameLikeAndRealNameLike(userId, baseKey);//获取下属信息
        List<UserVO> userVOList = UserFactoryVO.createUserVOList(userPOList);
        for (UserVO userVO : userVOList) {
            for (UserPO userPO : userPOList) {
                userVO.setDeptVO(DeptFactoryVO.createDeptVO(deptServiceV2.getDeptPOByDeptId(userPO.getDeptId())));
            }
        }
        PageInfo pageInfo = new PageInfo(userPOList);
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
                } else {
                    uMap.put(userPO.getUserName(), null);
                }
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
        model.addAttribute("page", pageInfo);//分页信息

        model.addAttribute("url", "realplantable");//真正报表信息
    }

    // 真正的报表
    @RequestMapping("realplantable")
    public String test23(HttpServletRequest request, Model model, HttpSession session,
                         @RequestParam(value = "pid", required = false) String pid,
                         @RequestParam(value = "comment", required = false) String comment,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey) {
        plantablepaging(request, model, session, page, baseKey);
        if (!StringUtils.isEmpty(pid)) {
            PlanListPO planListPO = planServiceV2.getPlanListPOByPlanId(Long.valueOf(pid));
            if (planListPO.getPlanComment() == null) {
                planListPO.setPlanComment(comment);
            } else {
                planListPO.setPlanComment(planListPO.getPlanComment());
            }
            planServiceV2.updatePlanListPOCommentByPlanListPO(planListPO, comment);
        }
        return "plan/realplantable";
    }

    //===========================================================
    //二次修改的
    // 计划管理
    @RequestMapping(value = "planview")
    public String test(Model model, HttpSession session,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "baseKey", required = false) String baseKey,
                       SelectVO selectVO,
                       @RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "status", required = false) String status,
                       @RequestParam(value = "time", required = false) String time,
                       @RequestParam(value = "icon", required = false) String icon) throws ParseException {
        System.out.println("11" + baseKey);
        sortpaging(model, session, page, baseKey, type, status, time, icon, selectVO);
        return "plan/planview";
    }


    /**
     * 模糊搜索
     *
     * @param model
     * @param session
     * @param page
     * @param baseKey
     * @param type
     * @param status
     * @param time
     * @param icon
     * @return
     */
  /*  @RequestMapping(value = "planviewtable", method = RequestMethod.GET)
    public String testdd(Model model, HttpSession session,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon) {
        System.out.println("222" + baseKey);
        sortpaging(model, session, page, baseKey, type, status, time, icon);
        return "plan/planviewtable";
    }*/

    //   /**
//     * @param model
//     * @param session
//     * @param page
//     * @param baseKey
//     * @param type
//     * @param status
//     * @param time
//     * @param icon
//     */
   /* private void sortpaging(Model model, HttpSession session, int page, String baseKey, String type, String status,
                            String time, String icon) {
        new AttendceController().setModelSomething(baseKey, type, status, time, icon, model);
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        PageHelper.startPage(page, 10);
//        List<PlanListPO> planListPOS = planServiceV2.sortAndGetPlan(page, baseKey, userId, type, status, time);
        List<PlanListPO> planListPOS = planServiceV2.getPlanListPOSAll();
        List<PlanListVO> planListVOS = PlanListVOFactory.createPlanListVOS(planListPOS);
        for (PlanListPO planListPO : planListPOS) {
            for (PlanListVO planListVO : planListVOS) {
                if (planListPO.getPlanId().equals(planListVO.getPlanId())) {
                    UserPO userPO = userServiceV2.getUserPOByUserId(planListPO.getPlanUserId());
                    UserVO userVO = UserFactoryVO.createUserVO(userPO);
                    DeptPO deptPO = deptServiceV2.getDeptPOByDeptId(userPO.getDeptId());
                    DeptVO deptVO = DeptFactoryVO.createDeptVO(deptPO);
                    userVO.setDeptVO(deptVO);
                    planListVO.setUserVO(userVO);
                }
            }
        }
        PageInfo pageInfo = new PageInfo(planListPOS);
        typestatus(model);
        model.addAttribute("plist", planListVOS);
        model.addAttribute("page", pageInfo);
        model.addAttribute("url", "planviewtable");
    }
*/


//-----------------------------------------------------------
   /* @RequestMapping("dimSelect")
    public String dinSelect(Model model,
                            @RequestParam(value = "page", defaultValue = "0") int page,
                            @RequestParam(value = "selectTypeName", required = false) String selectTypeName) {
        System.out.println(selectTypeName);
        PageHelper.startPage(page, 10);

        List<PlanListPO> planListPOS = planServiceV2.dimSelect(page, selectTypeName);
        List<PlanListVO> planListVOS = PlanListVOFactory.createPlanListVOS(planListPOS);
        for (PlanListPO planListPO : planListPOS) {
            for (PlanListVO planListVO : planListVOS) {
                if (planListPO.getPlanId().equals(planListVO.getPlanId())) {
                    UserPO userPO = userServiceV2.getUserPOByUserId(planListPO.getPlanUserId());
                    UserVO userVO = UserFactoryVO.createUserVO(userPO);
                    DeptPO deptPO = deptServiceV2.getDeptPOByDeptId(userPO.getDeptId());
                    DeptVO deptVO = DeptFactoryVO.createDeptVO(deptPO);
                    userVO.setDeptVO(deptVO);
                    planListVO.setUserVO(userVO);
                }
            }
        }
        PageInfo pageInfo = new PageInfo(planListPOS);
        typestatus(model);
        model.addAttribute("plist", planListVOS);
        model.addAttribute("page", pageInfo);
//        model.addAttribute("url", "planviewtable");
        return "plan/planviewtable";
    }*/

//模糊查询
    @RequestMapping(value = "dimSelect")
    public String dimSelect(Model model, HttpSession session,
                            @RequestParam(value = "page", defaultValue = "0") int page,
                            @RequestParam(value = "baseKey", required = false) String baseKey,
                            SelectVO selectVO,
                            @RequestParam(value = "type", required = false) String type,
                            @RequestParam(value = "status", required = false) String status,
                            @RequestParam(value = "time", required = false) String time,
                            @RequestParam(value = "icon", required = false) String icon) throws ParseException {
        System.out.println("222" + baseKey);
        sortpaging(model, session, page, baseKey, type, status, time, icon, selectVO);
        return "plan/planview";
    }

    //   /**
//     * @param model
//     * @param session
//     * @param page
//     * @param baseKey
//     * @param type
//     * @param status
//     * @param time
//     * @param icon
//     */
    private void sortpaging(Model model, HttpSession session, int page, String baseKey, String type, String status,
                            String time, String icon, SelectVO selectVO) throws ParseException {
        new AttendceController().setModelSomething(baseKey, type, status, time, icon, model);
        PageHelper.startPage(page, 10);
        List<PlanListPO> planListPOS = null;
        if (selectVO.getSelectTypeName() != null && !("").equals(selectVO.getSelectTypeName())) {
            //根据类型名查找
            planListPOS = planListServiceV2.getPlanListPOSByTypeName(page, selectVO.getSelectTypeName());
        } else if (selectVO.getSelectDeptName() != null && !("").equals(selectVO.getSelectDeptName())) {
            PageHelper.startPage(page, 10);
            //根据部门名查找
            planListPOS = planListServiceV2.getPlanListPOBySelectDeptName(page, selectVO.getSelectDeptName());
        } else if (selectVO.getSelectTitle() != null && !("").equals(selectVO.getSelectTitle())) {
            //根据标题模糊查找
            planListPOS = planListServiceV2.getPlanListPOByTitleLike(page, selectVO.getSelectTitle());
        } else if (selectVO.getSelectPushUsername() != null && !("").equals(selectVO.getSelectPushUsername())) {
            //根据用户名模糊查找
            planListPOS = planListServiceV2.getPlanListPOSBySelectUsername(page, selectVO.getSelectPushUsername());
        } else if (selectVO.getSelectStatusName() != null && !("").equals(selectVO.getSelectStatusName())) {
            //根据状态名查找
            planListPOS = planListServiceV2.getPlanListPOByStatusNameLike(page, selectVO.getSelectStatusName());
        } else if (selectVO.getSelectLabel() != null && !("").equals(selectVO.getSelectLabel())) {
            planListPOS = planListServiceV2.getPlanListPOByLabelLike(page, selectVO.getSelectLabel());
        } else if (selectVO.getSelectStartTime() != null && !("").equals(selectVO.getSelectStartTime()) && selectVO.getSelectEndTime() != null && !("").equals(selectVO.getSelectEndTime())) {
            //开始时间和结束时间都存在（查找在两个时间之间的计划）
            planListPOS = planListServiceV2.getPlanListPOByCreateTimeBetween(page, selectVO.getSelectStartTime(), selectVO.getSelectEndTime());
        } else if (selectVO.getSelectStartTime() != null && !("").equals(selectVO.getSelectStartTime()) && (selectVO.getSelectEndTime() == null || ("").equals(selectVO.getSelectEndTime()))) {
            //只有开始时间没有结束时间
            planListPOS = planListServiceV2.getPlanListPOByCreateTimeGreaterThanOrEqualTo(page, selectVO.getSelectStartTime());
        } else if ((selectVO.getSelectStartTime() == null || ("").equals(selectVO.getSelectStartTime())) && selectVO.getSelectEndTime() != null && !("").equals(selectVO.getSelectEndTime())) {
            //没有开始时间只有结束时间
            planListPOS = planListServiceV2.getPlanListPOByCreateTimeLessThanOrEqualTo(page, selectVO.getSelectEndTime());
        } else {
            //所有计划
            planListPOS = planServiceV2.getPlanListPOSAll();
        }
        List<PlanListVO> planListVOS = PlanListVOFactory.createPlanListVOS(planListPOS);
        for (PlanListPO planListPO : planListPOS) {
            for (PlanListVO planListVO : planListVOS) {
                if (planListPO.getPlanId().equals(planListVO.getPlanId())) {
                    UserPO userPO = userServiceV2.getUserPOByUserId(planListPO.getPlanUserId());
                    UserVO userVO = UserFactoryVO.createUserVO(userPO);
                    DeptPO deptPO = deptServiceV2.getDeptPOByDeptId(userPO.getDeptId());
                    DeptVO deptVO = DeptFactoryVO.createDeptVO(deptPO);
                    userVO.setDeptVO(deptVO);
                    planListVO.setUserVO(userVO);
                }
            }
        }
        PageInfo pageInfo = new PageInfo(planListPOS);
        model.addAttribute("page", pageInfo);
        model.addAttribute("deptPOList", deptServiceV2.getDeptPOListAll());
        typestatus(model);
        model.addAttribute("plist", planListVOS);
//        model.addAttribute("url", "planviewtable");
        model.addAttribute("url", "dimSelect");
    }


    // 计划管理>增加或修改
    @RequestMapping("planedit")
    public String test3(HttpServletRequest request, Model model) {
        typestatus(model);
        long planId = Long.valueOf(request.getParameter("pid"));//从planviewtable 页面获取pid(增加=-1和修改>0）
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
            PlanListPO planListPO = planServiceV2.getPlanListPOByPlanId(planId);
            PlanListVO planListVO = PlanListVOFactory.createPlanListVO(planListPO);
            model.addAttribute("plan", planListVO);
            model.addAttribute("pid", planId);
        return "plan/planedit";
        }
        return null;

    }


}
