package cn.gson.oasys.controller.inform;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.ServiceV2.noticeServiceV2.InfrommanageServiceV2;
import cn.gson.oasys.ServiceV2.noticeServiceV2.NoticeUserRelationServiceV2;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.noticeVO2.NoticeListVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.mappers.NoticeMapper;
import cn.gson.oasys.model.dao.informdao.InformDao;
import cn.gson.oasys.model.dao.informdao.InformRelationDao;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.services.inform.InformRelationService;
import cn.gson.oasys.services.inform.InformService;

@Controller
@RequestMapping("/")
public class InformManageController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private StatusDao statusDao;

    @Autowired
    private TypeDao typeDao;

    @Autowired
    private InformDao informDao;

    @Autowired
    private InformService informService;

    @Autowired
    private UserDao uDao;

    @Autowired
    private DeptDao deptDao;

    @Autowired
    private InformRelationDao informrelationDao;

    @Autowired
    private InformRelationService informrelationservice;

    @Autowired
    private NoticeMapper nm;

    /**
     * 通知管理面板
     *
     * @return
     */
/*	@RequestMapping("infrommanage")
	public String inform(@RequestParam(value = "page", defaultValue = "0") int page,@SessionAttribute("userId") Long userId,Model model) {
		Page<NoticesList> page2 = informService.pageThis(page,userId);
		List<NoticesList> noticeList=page2.getContent();
		List<Map<String, Object>> list=informService.fengZhuang(noticeList);
		model.addAttribute("list", list);
		model.addAttribute("page", page2);
		//设置变量，需要load的url；
		model.addAttribute("url", "infrommanagepaging");
		return "inform/informmanage";
	}
*/
 /*   @RequestMapping("forwardother")
    public String forwardOther(@SessionAttribute("userId") Long userId, @RequestParam(value = "noticeId") Long noticeId) {
        List<User> users = uDao.findByFatherId(userId);
        NoticesList nl = informDao.findOne(noticeId);
        List<NoticeUserRelation> nurs = new ArrayList<>();
        for (User user : users) {
            nurs.add(new NoticeUserRelation(nl, user, false));
        }
        informrelationservice.saves(nurs);
        return "redirect:/infromlist";
    }
*/
    // demo
//	@RequestMapping("cccc")
//	public @ResponseBody Page<NoticesList> ddd(@RequestParam(value = "page", defaultValue = "0") int page,
//			@RequestParam(value = "size", defaultValue = "10") int size,
//			@RequestParam(value = "baseKey", required = false) String baseKey, @SessionAttribute("userId") Long userId,
//			Model model) {
//		Page<NoticesList> page2 = informService.pageThis(page, size, userId,baseKey,null,null,null);
//		List<NoticesList> noticeList=page2.getContent();
//		Long sum=page2.getTotalElements();
//		int size2=page2.getSize();
//		int pages=page2.getTotalPages();
//		int number=page2.getNumber();
//		model.addAttribute("list", noticeList);
//		model.addAttribute("page", page2);
//		return page2;

    // List<NoticesList> noticeList=informDao.findByUserId(userId);
    // List<NoticesList>
    // noticeList=informDao.findByUserIdAndTopOrderByModifyTimeDesc(userId,
    // true);
    // List<NoticesList>
    // noticeList2=informDao.findByUserIdAndTopOrderByModifyTimeDesc(userId,
    // false);
    // noticeList.addAll(noticeList2);
    // List<Map<String, Object>> list=informService.fengZhuang(noticeList);
    // model.addAttribute("list",list);
//	}

    /**
     * 通知管理删除
     */
   /* @RequestMapping("infromdelete")
    public String infromDelete(HttpSession session, HttpServletRequest req) {
        Long noticeId = Long.parseLong(req.getParameter("id"));
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        NoticesList notice = informDao.findOne(noticeId);
        if (!Objects.equals(userId, notice.getUserId())) {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        System.out.println(noticeId);
        informService.deleteOne(noticeId);
        return "redirect:/infrommanage";

    }*/


    /**
     * 通知列表删除
     */
 /*   @RequestMapping("informlistdelete")
    public String informListDelete(HttpServletRequest req, HttpSession session) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        Long noticeId = Long.parseLong(req.getParameter("id"));
        NoticeUserRelation relation = informrelationDao.findByUserIdAndNoticeId(uDao.findOne(userId),
                informDao.findOne(noticeId));
        if (Objects.isNull(relation)) {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        informrelationservice.deleteOne(relation);
        return "forward:/infromlist";
    }
*/

    /**
     * 通知列表
     *
     * @return
     */
  /*  @RequestMapping("infromlist")
    public String infromList(HttpSession session, HttpServletRequest req, Model model,
                             @RequestParam(value = "pageNum", defaultValue = "1") int page) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        PageHelper.startPage(page, 10);
        List<Map<String, Object>> list = nm.findMyNotice(userId);
        PageInfo<Map<String, Object>> pageinfo = new PageInfo<Map<String, Object>>(list);
        List<Map<String, Object>> list2 = informrelationservice.setList(list);
        for (Map<String, Object> map : list2) {
            System.out.println(map);
        }
        model.addAttribute("url", "informlistpaging");
        model.addAttribute("list", list2);
        model.addAttribute("page", pageinfo);
        System.out.println(pageinfo);
        return "inform/informlist";
    }
*/
    /**
     * 编辑通知界面
     */
	/*@RequestMapping("informedit")
	public String infromEdit(HttpServletRequest req, HttpSession session, Model model) {
		session.removeAttribute("noticeId");
		List<SystemTypeList> typeList = typeDao.findByTypeModel("inform");
		List<SystemStatusList> statusList = statusDao.findByStatusModel("inform");
		if (!StringUtils.isEmpty(req.getAttribute("errormess"))) {
			req.setAttribute("errormess", req.getAttribute("errormess"));
		}
		if (!StringUtils.isEmpty(req.getAttribute("success"))) {
			req.setAttribute("success", "数据保存成功");
		}
		req.setAttribute("typeList", typeList);
		req.setAttribute("statusList", statusList);
		if (!StringUtils.isEmpty(req.getParameter("id"))) {
			Long noticeId = Long.parseLong(req.getParameter("id"));
			NoticesList noticeList = informDao.findOne(noticeId);
			model.addAttribute("noticeList", noticeList);
			model.addAttribute("typeName", typeDao.findOne(noticeList.getTypeId()).getTypeName());
			model.addAttribute("statusName", statusDao.findOne(noticeList.getStatusId()).getStatusName());
			session.setAttribute("noticeId", noticeId);
		}

		return "inform/informedit";
	}*/

    /**
     * 详细通知显示
     */
  /*  @RequestMapping("informshow")
    public String informShow(HttpServletRequest req, Model model) {
        Long noticeId = Long.parseLong(req.getParameter("id"));
        if (!StringUtils.isEmpty(req.getParameter("read"))) {
            if (("0").equals(req.getParameter("read"))) {
                Long relationId = Long.parseLong(req.getParameter("relationid"));
                NoticeUserRelation relation = informrelationDao.findOne(relationId);
                relation.setRead(true);
                informrelationservice.save(relation);
            }
        }
        NoticesList notice = informDao.findOne(noticeId);
        User user = uDao.findOne(notice.getUserId());
        model.addAttribute("notice", notice);
        model.addAttribute("userName", user.getUserName());
        return "inform/informshow";
    }
*/

    /**
     * 系统管理表单验证
     *
     * @param req
     * @param menu
     * @param br   后台校验表单数据，不通过则回填数据，显示错误信息；通过则直接执行业务，例如新增、编辑等；
     * @return
     *//*
    @RequestMapping("informcheck")
    public String testMess(HttpServletRequest req, @Valid NoticesList menu, BindingResult br) {
        HttpSession session = req.getSession();
        Long menuId = null;
        req.setAttribute("menuObj", menu);
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        menu.setUserId(userId);

        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        // 校验失败
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
            // 代码调试阶段，下面是错误的相关信息；
            System.out.println("list错误的实体类信息：" + menu);
            System.out.println("list错误详情:" + list);
            System.out.println("list错误第一条:" + list.get(0));
            System.out.println("啊啊啊错误的信息——：" + list.get(0).toString());
            // 下面的info信息是打印出详细的信息
            log.info("getData:{}", res.getData());
            log.info("getCode:{}", res.getCode());
            log.info("getMsg:{}", res.getMsg());
        }
        // 校验通过，下面写自己的逻辑业务
        else {
            // 判断是否从编辑界面进来的，前面有"session.setAttribute("getId",getId);",在这里获取，并remove掉；
            if (!StringUtils.isEmpty(session.getAttribute("noticeId"))) {
                menuId = (Long) session.getAttribute("noticeId"); // 获取进入编辑界面的menuID值
                NoticesList inform = informDao.findOne(menuId);
                menu.setNoticeTime(inform.getNoticeTime());
                menu.setNoticeId(menuId);
                session.removeAttribute("noticeId");
                informService.save(menu);
            } else {
                menu.setNoticeTime(new Date());
                menu.setUserId(userId);
                NoticesList noticeList = informService.save(menu);
                List<User> userList = uDao.findByFatherId(userId);
                for (User user : userList) {
                    informrelationservice.save(new NoticeUserRelation(noticeList, user, false));
                }
            }
            // 执行业务代码
            System.out.println("此操作是正确的");
            req.setAttribute("success", "后台验证成功");
        }
        System.out.println("是否进入最后的实体类信息：" + menu);
        return "forward:/informedit";
    }
*/
    //=======================================================自己改的

    @Resource
    private InfrommanageServiceV2 infromManageServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private NoticeUserRelationServiceV2 noticeUserRelationServiceV2;

    /**
     * 通知管理面板
     *
     * @return
     */
    @RequestMapping("infrommanage")
    public String inform(@RequestParam(value = "page", defaultValue = "0") int page, @SessionAttribute("userId") Long userId, Model model) {
        List<NoticeListPO> noticeListPOList = infromManageServiceV2.noticeListManageList(page, userId);//根据用户ID找通知主表信息并分页排序
        PageInfo pageInfo = new PageInfo(noticeListPOList);
        model.addAttribute("page", pageInfo);
        List<Map<String, Object>> list = infromManageServiceV2.encapsulationNoticeList(noticeListPOList);//封装通表的信息
        model.addAttribute("list", list);
        //设置变量，需要load的url；
        model.addAttribute("url", "infrommanagepaging");
        return "inform/informmanage";
    }

    /**
     * 通知界面新增修改
     */
    @RequestMapping("informedit")
    public String infromEdit(HttpServletRequest req, HttpSession session, Model model) {
        session.removeAttribute("noticeId");// 移除上次session里面的通知主表ID
        List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("inform");//根据类型模型找类型列表
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOByStatusModel("inform");//根据状态模型找状态列表
        if (!StringUtils.isEmpty(req.getAttribute("errormess"))) {
            req.setAttribute("errormess", req.getAttribute("errormess"));
        }
        if (!StringUtils.isEmpty(req.getAttribute("success"))) {
            req.setAttribute("success", "数据保存成功");
        }
        req.setAttribute("typeList", typePOList);//把类型列表设置到请求属性里面
        req.setAttribute("statusList", statusPOList);//把状态列表设置到请求属性里面
        //ID不存在(新增)就返回true
        if (!StringUtils.isEmpty(req.getParameter("id"))) {
            //走到这里就代表ID存在即修改
            Long noticeId = Long.parseLong(req.getParameter("id"));//从前端获取参数ID即通知列表的ID（noticeId)
            NoticeListPO noticeListPO = infromManageServiceV2.getNoticeListPOByNoticeListPOId(noticeId);//根据通知表ID找通知表信息
            model.addAttribute("noticeList", noticeListPO);//设置通知表信息
            model.addAttribute("top", noticeListPO.getIsTop() == 0 ? false : true);//是否置顶
            model.addAttribute("typeName", typeServiceV2.getTypePOByTypeId(noticeListPO.getTypeId()).getTypeName());//类型名
            model.addAttribute("statusName", statusServiceV2.getStatusPOByStatusId(noticeListPO.getStatusId()).getStatusName()); //状态名
            session.setAttribute("noticeId", noticeId);//把通知表ID放进session里面
        }

        return "inform/informedit";
    }

    /**
     * 系统管理表单验证
     *
     * @param req
     * @param noticeListVO
     * @param br   后台校验表单数据，不通过则回填数据，显示错误信息；通过则直接执行业务，例如新增、编辑等；
     * @return
     */
    @RequestMapping("informcheck")
    public String testMess(HttpServletRequest req, @Valid NoticeListVO noticeListVO, BindingResult br) {
        HttpSession session = req.getSession();//获取session信息
        req.setAttribute("menuObj", noticeListVO);//把接收的通知信息放到请求属性里面
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        noticeListVO.setUserId(userId);//把接收表单里面的用户ID设置为登录人的ID

        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        // 校验失败
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            req.setAttribute("errormess", list.get(0).toString());
            // 代码调试阶段，下面是错误的相关信息；
            System.out.println("list错误的实体类信息：" + noticeListVO);
            System.out.println("list错误详情:" + list);
            System.out.println("list错误第一条:" + list.get(0));
            System.out.println("啊啊啊错误的信息——：" + list.get(0).toString());
            // 下面的info信息是打印出详细的信息
            log.info("getData:{}", res.getData());
            log.info("getCode:{}", res.getCode());
            log.info("getMsg:{}", res.getMsg());
        }
        // 校验通过，下面写自己的逻辑业务
        else {
            // 判断是否从编辑界面进来的，前面有"session.setAttribute("getId",getId);",在这里获取，并remove掉；
            if (!StringUtils.isEmpty(session.getAttribute("noticeId"))) {
//                更新通知表信息（即修改）
                infromManageServiceV2.updateNoticeListPO(session, noticeListVO, userId);
            } else {
//                插入通知主表信息
                NoticeListPO noticeListPO = infromManageServiceV2.insertNoticeListPO(noticeListVO, userId);
                //新公告给下属用户，标记为未读
                infromManageServiceV2.insertNoticeUserRelation(noticeListPO, userId);
            }
            // 执行业务代码
            req.setAttribute("success", "后台验证成功");
        }
        return "forward:/informedit";
    }

    /**
     * 查看
     */
    @RequestMapping("informshow")
    public String informShow(HttpServletRequest req, Model model) {
        Long noticeId = Long.parseLong(req.getParameter("id"));//获取参数ID
        //如果read不存在就带表查看的是通知管理的查看
        if (!StringUtils.isEmpty(req.getParameter("read"))) {
            // read存在就代表是通知列表的查看
            if (("0").equals(req.getParameter("read"))) {
                //0代表是通知列表的信息未读
                Long relationId = Long.parseLong(req.getParameter("relationid"));//通知用户关联列表的ID
                //更新关联表信息，把未读改为已读
                infromManageServiceV2.updateNoticeUserRelation(relationId);
            }
        }
        NoticeListPO noticeListPO = infromManageServiceV2.getNoticeListPOByNoticeListPOId(noticeId);//根据通知主表ID找通知主表信息
        UserPO userPO = userServiceV2.getUserPOByUserId(noticeListPO.getUserId());//根据通知主表里的发布人ID找发布人信息
        //（页面需要：标题，发布人名，发布时间，发布内容，链接）
//        model.addAttribute("notice", noticeListPO);//设置通知主表信息
        model.addAttribute("title", noticeListPO.getTitle());//设置发布标题
        model.addAttribute("noticeTime", new Timestamp(noticeListPO.getNoticeTime().getTime()));//设置发布时间
        model.addAttribute("content", noticeListPO.getContent());//设置发布内容
        model.addAttribute("url", noticeListPO.getUrl());//设置发布人的用户名
        model.addAttribute("userName", userPO.getUserName());//设置发布人的用户名
        return "inform/informshow";
    }

    /**
     * 通知管理删除
     */
    @RequestMapping("infromdelete")
    public String infromDelete(HttpSession session, HttpServletRequest req) {
        Long noticeId = Long.parseLong(req.getParameter("id"));//通知公告的ID
        Long userId = Long.parseLong(session.getAttribute("userId") + "");//从 session中获取登录人ID
        NoticeListPO noticeListPO = infromManageServiceV2.getNoticeListPOByNoticeListPOId(noticeId);//根据通知公告ID找通知公告
        if (!Objects.equals(userId, noticeListPO.getUserId())) {
             //如果登录人ID和发布人ID不通则不能删除(没用，因为这里显示的就是根据登录人ID在通知主表找属于登录人管理的通告信息信息，既然显示了那登录ID和通知表ID肯定是相同的）
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        //删除发布的通知（先删除附表的，即发布给下属的通知）
        infromManageServiceV2.deleteNoticeListPO(noticeId);
        return "redirect:/infrommanage";
    }


    /**
     * 通知列表
     *
     * @return
     */
    @RequestMapping("infromlist")
    public String infromList(HttpSession session, HttpServletRequest req, Model model,
                             @RequestParam(value = "pageNum", defaultValue = "1") int page) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");//登录人ID
        PageHelper.startPage(page, 10);
        //通知列表信息
        List<Map<String, Object>> mapList = infromManageServiceV2.getNoticeUserRelation(userId);
        PageInfo pageInfo = new PageInfo(mapList);
        model.addAttribute("url", "informlistpaging");
        model.addAttribute("list", mapList);
        model.addAttribute("page", pageInfo);
        return "inform/informlist";
    }

    //转发
    @RequestMapping("forwardother")
    public String forwardOther(@SessionAttribute("userId") Long userId, @RequestParam(value = "noticeId") Long noticeId) {
        NoticeListPO noticeListPO = infromManageServiceV2.getNoticeListPOByNoticeListPOId(noticeId);
        infromManageServiceV2.insertNoticeUserRelation(noticeListPO, userId);
        return "redirect:/infromlist";
    }


    /**
     * 通知列表删除
     */
    @RequestMapping("informlistdelete")
    public String informListDelete(HttpServletRequest req, HttpSession session) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");//获取登录人ID
        Long noticeId = Long.parseLong(req.getParameter("id"));//获取通知主表ID
        //根据通知主表ID和登录人ID找关联表信息
        NoticeUserRelationPO noticeUserRelationPO = noticeUserRelationServiceV2.getNoticeUserRelationPOByNoticeIdAndUserId(userId, noticeId);
        if (Objects.isNull(noticeUserRelationPO)) {
            //也不可能存在，因为现实的信息就是登录人的ID和通知主表ID找到的
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        noticeUserRelationServiceV2.deleteNoticeUserRelationPOByNoticeUserRelationPOId(noticeUserRelationPO.getRelatinId());
        return "forward:/infromlist";
    }

}
