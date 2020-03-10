package cn.gson.oasys.controller.inform;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.gson.oasys.modelV2.bo.CommonalityService;
import cn.gson.oasys.modelV2.bo.PageInformation;
import cn.gson.oasys.modelV2.po.NoticeListPO;
import cn.gson.oasys.modelV2.po.NoticeUserRelationPO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.serviceV2.notice2.NoticeServiceV2;
import cn.gson.oasys.serviceV2.notice2.NoticeUserRelationPOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.gson.oasys.mappers.NoticeMapper;
import cn.gson.oasys.model.entity.notice.NoticesList;
import cn.gson.oasys.services.inform.InformRelationService;
import cn.gson.oasys.services.inform.InformService;

@Controller
@RequestMapping("/")
public class InformListController {

    @Resource
    private CommonalityService commonalityService;
    @Resource
    private NoticeServiceV2 noticeServiceV2;
    @Resource
    private PageInformation pageInformation;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private NoticeUserRelationPOServiceV2 noticeUserRelationPOServiceV2;

    /**
     * 通知列表
     *
     * @return
     */
    @RequestMapping("infromlist")
    public String informList(HttpSession session, HttpServletRequest req, Model model,
                             @RequestParam(value = "page", defaultValue = "1") int page) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");//登录人ID
        //通知列表信息
        List<Map<String, Object>> mapList = noticeServiceV2.getNoticeUserRelationAndNoticeListPO(userId);
        List<Map<String, Object>> subMapList = pageInformation.getMapListPage(page, 10, mapList, model);
        model.addAttribute("url", "informlistpaging");
        model.addAttribute("list", subMapList);
        return "inform/informlist";
    }

    /**
     * 通知列表的分页
     */
    @RequestMapping("informlistpaging")
    public String informListPaging(@RequestParam(value = "page", defaultValue = "1") int page,
                                   @RequestParam(value = "baseKey", required = false) String baseKey,
                                   @RequestParam(value = "type", required = false) Integer type,
                                   @RequestParam(value = "status", required = false) Integer status,
                                   @RequestParam(value = "time", required = false) Integer time,
                                   @RequestParam(value = "icon", required = false) String icon,
                                   @SessionAttribute("userId") Long userId,
                                   Model model, HttpServletRequest req) {
        commonalityService.setSomething(baseKey, type, status, time, icon, model);
        List<Map<String, Object>> mapList = noticeServiceV2.getNoticeUserRelationAndNoticeListPO(userId);
        List<Map<String, Object>> subMapList = pageInformation.getMapListPage(page, 10, mapList, model);
        model.addAttribute("url", "informlistpaging");
        model.addAttribute("list", subMapList);
        return "inform/informlistpaging";

    }

    /**
     * 转发
     *
     * @param userId   用户ID
     * @param noticeId 通知主表ID
     * @return
     */
    @RequestMapping("forwardother")
    public String forwardOther(@SessionAttribute("userId") Long userId, @RequestParam(value = "noticeId") Long noticeId) {
        List<UserPO> userPOList = userPOServiceV2.getUserPOListByFatherId(userId);//根据用户ID获取它的下属用户列表
        NoticeListPO noticeListPO = noticeServiceV2.getNoticeListPOByNoticeListPOId(noticeId);//根据通知公告表ID找通知公告
        for (UserPO userPO : userPOList) {
            noticeUserRelationPOServiceV2.insertNoticeUserRelationPO(noticeListPO.getNoticeId(), userPO.getUserId());
        }
        return "redirect:/infromlist";
    }

    /**
     * 通知列表删除
     *
     * @param req
     * @param session
     * @return
     */
    @RequestMapping("informlistdelete")
    public String informListDelete(HttpServletRequest req, HttpSession session) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");//获取登录人ID
        Long noticeId = Long.parseLong(req.getParameter("id"));//获取通知主表ID
        //根据通知主表ID和登录人ID找关联表信息
        NoticeUserRelationPO noticeUserRelationPO = noticeUserRelationPOServiceV2.getNoticeUserRelationPOByNoticeIdAndUserId(userId, noticeId);
        if (Objects.isNull(noticeUserRelationPO)) {
            //也不可能存在，因为现实的信息就是登录人的ID和通知主表ID找到的
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        noticeUserRelationPOServiceV2.deleteNoticeUserRelationPOByNoticeUserRelationPOId(noticeUserRelationPO.getRelationId());
        return "forward:/infromlist";
    }


}
