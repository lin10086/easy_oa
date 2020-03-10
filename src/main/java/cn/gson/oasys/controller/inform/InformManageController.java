package cn.gson.oasys.controller.inform;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.gson.oasys.model.entity.notice.NoticeUserRelation;
import cn.gson.oasys.model.entity.notice.NoticesList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.modelV2.bo.CommonalityService;
import cn.gson.oasys.modelV2.bo.PageInformation;
import cn.gson.oasys.serviceV2.notice2.NoticePOServiceV2;
import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.notice2.NoticeServiceV2;
import cn.gson.oasys.serviceV2.notice2.NoticeUserRelationPOServiceV2;
import cn.gson.oasys.modelV2.po.*;
import cn.gson.oasys.serviceV2.userV2.UserServiceV2;
import cn.gson.oasys.voandfactory.noticeVO2.NoticeListVO;
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

    @Resource
    private NoticeServiceV2 noticeServiceV2;
    @Resource
    private NoticePOServiceV2 noticePOServiceV2;
    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private StatusPOServiceV2 statusPOServiceV2;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private NoticeUserRelationPOServiceV2 noticeUserRelationPOServiceV2;
    @Resource
    private PageInformation pageInformation;
    @Resource
    private CommonalityService commonalityService;

    /**
     * 通知管理界面
     *
     * @return
     */
    @RequestMapping("infrommanage")
    public String inform(@RequestParam(value = "page", defaultValue = "1") int page, @SessionAttribute("userId") Long userId, Model model) {
//        根据用户ID找通知公告列表,并根据是否置顶修改时间排序
        List<NoticeListPO> noticeListPOS = noticePOServiceV2.noticeListPOSByUserIdOrderIsTopDESCAndModifyTimeDESC(userId);
        List<NoticeListPO> subNoticeListPOS = pageInformation.getNoticeListPOSPage(page, 10, noticeListPOS, model);
        List<Map<String, Object>> list = noticeServiceV2.encapsulationNoticeList(subNoticeListPOS);//封装通知表的信息
        model.addAttribute("list", list);
        //设置变量，需要load的url；
        model.addAttribute("url", "infrommanagepaging");
        return "inform/informmanage";
    }

    /**
     * 通知管理界面分页，排序
     *
     * @return
     */
    @RequestMapping("infrommanagepaging")
    public String inform(@RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon,
                         @SessionAttribute("userId") Long userId,
                         Model model) {
        commonalityService.setSomething(baseKey, type, status, time, icon, model);
        //根据用户ID找通知公告列表,并根据是否置顶修改时间排序
        List<NoticeListPO> noticeListPOS = noticeServiceV2.noticeListPOSByUserIdAndOrders(userId, baseKey, type, status, time);
        List<NoticeListPO> subNoticeListPOS = pageInformation.getNoticeListPOSPage(page, 10, noticeListPOS, model);
        List<Map<String, Object>> list = noticeServiceV2.encapsulationNoticeList(subNoticeListPOS);//封装通知表的信息
        model.addAttribute("url", "infrommanagepaging");
        model.addAttribute("list", list);
        return "inform/informtable";
    }


    /**
     * 通知界面新增修改
     */
    @RequestMapping("informedit")
    public String informEdit(HttpServletRequest req, HttpSession session, Model model) {
        session.removeAttribute("noticeId");// 移除上次session里面的通知主表ID
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("inform");//根据类型模型找类型列表
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("inform");//根据状态模型找状态列表
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
            NoticeListPO noticeListPO = noticeServiceV2.getNoticeListPOByNoticeListPOId(noticeId);//根据通知表ID找通知表信息
            model.addAttribute("noticeList", noticeListPO);//设置通知表信息
            model.addAttribute("top", noticeListPO.getIsTop() == 0 ? false : true);//是否置顶
            model.addAttribute("typeName", typePOServiceV2.getTypePOByTypeId(noticeListPO.getTypeId()).getTypeName());//类型名
            model.addAttribute("statusName", statusPOServiceV2.getStatusPOByStatusId(noticeListPO.getStatusId()).getStatusName()); //状态名
            session.setAttribute("noticeId", noticeId);//把通知表ID放进session里面
        }
        return "inform/informedit";
    }

    /**
     * 系统管理表单验证
     *
     * @param req
     * @param noticeListVO
     * @param br           后台校验表单数据，不通过则回填数据，显示错误信息；通过则直接执行业务，例如新增、编辑等；
     * @return
     */
    @RequestMapping("informcheck")
    public String informCheck(HttpServletRequest req, @Valid NoticeListVO noticeListVO, BindingResult br) {
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
            // 下面的info信息是打印出详细的信息
            log.info("getData:{}", res.getData());
            log.info("getCode:{}", res.getCode());
            log.info("getMsg:{}", res.getMsg());
        } else {// 校验通过，下面写自己的逻辑业务
            // 判断是否从编辑界面进来的，前面有"session.setAttribute("getId",getId);",在这里获取，并remove掉；
            if (!StringUtils.isEmpty(session.getAttribute("noticeId"))) {
//                更新通知表信息（即修改）
                noticeServiceV2.updateNoticeListPO(session, noticeListVO, userId);
            } else {
//                新增即插入一条通知主表信息
                NoticeListPO noticeListPO = noticeServiceV2.insertNoticeListPOByNoticeListVOAndUserId(noticeListVO, userId);
                List<UserPO> userPOList = userPOServiceV2.getUserPOListByFatherId(userId);
                for (UserPO userPO : userPOList) {
                    //新公告给下属用户，标记为未读
                    noticeUserRelationPOServiceV2.insertNoticeUserRelationPO(noticeListPO.getNoticeId(), userPO.getUserId());
                }
            }
            // 执行业务代码
            req.setAttribute("success", "后台验证成功");
        }
        return "forward:/informedit";
    }


    /**
     * 公告管理和公告列表的查看
     */
    @RequestMapping("informshow")
    public String informShow(HttpServletRequest req, Model model) {
        Long noticeId = Long.parseLong(req.getParameter("id"));//获取通知公告ID
        //如果read不存在就带表查看的是通知管理的查看
        if (!StringUtils.isEmpty(req.getParameter("read"))) {
            // read存在就代表是通知列表的查看
            if (("0").equals(req.getParameter("read"))) {
                //0代表是通知列表的信息未读
                Long relationId = Long.parseLong(req.getParameter("relationId"));//通知用户关联列表的ID
                //更新关联表信息，把未读改为已读
                noticeServiceV2.updateNoticeUserRelationInIsRead(relationId);
            }
        }
        NoticeListPO noticeListPO = noticeServiceV2.getNoticeListPOByNoticeListPOId(noticeId);//根据通知主表ID找通知主表信息
        UserPO userPO = userPOServiceV2.getUserPOByUserId(noticeListPO.getUserId());//根据通知主表里的发布人ID找发布人信息
        //（页面需要：标题，发布人名，发布时间，发布内容，链接）
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
    public String informDelete(HttpSession session, HttpServletRequest req) {
        Long noticeId = Long.parseLong(req.getParameter("id"));//通知公告的ID
        Long userId = Long.parseLong(session.getAttribute("userId") + "");//从 session中获取登录人ID
        NoticeListPO noticeListPO = noticeServiceV2.getNoticeListPOByNoticeListPOId(noticeId);//根据通知公告ID找通知公告
        if (!Objects.equals(userId, noticeListPO.getUserId())) {
            //如果登录人ID和发布人ID不通则不能删除(没用，因为这里显示的就是根据登录人ID在通知主表找属于登录人管理的通告信息信息，既然显示了那登录ID和通知表ID肯定是相同的）
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        //删除发布的通知（先删除附表的，即发布给下属的通知）
        noticeServiceV2.deleteNoticeListPO(noticeId);
        return "redirect:/infrommanage";
    }
}
