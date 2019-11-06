package cn.gson.oasys.ServiceV2.noticeServiceV2;

import cn.gson.oasys.ServiceV2.DeptServiceV2;
import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.NoticeListPOMapper;
import cn.gson.oasys.mappers.NoticeUserRelationPOMapper;
import cn.gson.oasys.model.entity.notice.NoticesList;
import cn.gson.oasys.model.po.NoticeListPO;
import cn.gson.oasys.model.po.NoticeListPOExample;
import cn.gson.oasys.model.po.NoticeUserRelationPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.noticeV2.NoticeListVO;
import com.github.pagehelper.PageHelper;
import org.hibernate.annotations.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

@Service
public class InfrommanageServiceV2 {
    @Resource
    private NoticeListPOMapper noticeListPOMapper;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private DeptServiceV2 deptServiceV2;
    @Resource
    private NoticeUserRelationPOMapper noticeUserRelationPOMapper;

    /**
     * 根据用户ID找管理公告
     *
     * @param page
     * @param userId
     * @return
     */
    public List<NoticeListPO> noticeListManageList(int page, Long userId) {
        int size = 10;
        PageHelper.startPage(page, size);
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
        noticeListPOExample.setOrderByClause("is_top desc,modify_time desc");
        noticeListPOExample.createCriteria().andUserIdEqualTo(userId);
        List<NoticeListPO> noticeListManageList = noticeListPOMapper.selectByExample(noticeListPOExample);
        return noticeListManageList;
    }

    // 封装
    public List<Map<String, Object>> encapsulationNoticeList(List<NoticeListPO> noticeListPOList) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < noticeListPOList.size(); i++) {

            Map<String, Object> result = new HashMap<>();
            result.put("noticeId", noticeListPOList.get(i).getNoticeId());//公告ID
            result.put("typename", typeServiceV2.getTypeNameByTypeId(noticeListPOList.get(i).getTypeId()));//根据公告类型ID获取公告类型名
            result.put("statusname", statusServiceV2.getStatusPOByStatusId(noticeListPOList.get(i).getStatusId()).getStatusName());// 根据公告状态ID获取公告状态名
            result.put("statuscolor", statusServiceV2.getStatusPOByStatusId(noticeListPOList.get(i).getStatusId()).getStatusColor());//根据公告状态ID获取公告状态颜色
            result.put("title", noticeListPOList.get(i).getTitle());//获取公告管理的标题
            result.put("noticeTime", new Timestamp(noticeListPOList.get(i).getNoticeTime().getTime()));//获取发布公告的时间
            result.put("top", noticeListPOList.get(i).getIsTop() == 0 ? false : true);//通知是否置顶(默认为0不置顶）
            result.put("url", noticeListPOList.get(i).getUrl());//获取通知内的链接
            result.put("username", userServiceV2.getUserPOByUserId(noticeListPOList.get(i).getUserId()).getUserName());//根据通知的用户ID找用户名
            result.put("deptname", deptServiceV2.getDeptPOByUserId(noticeListPOList.get(i).getUserId()).getDeptName());//根据通知的用户ID找部门名
            list.add(result);
        }
        return list;

    }

    /**
     * 根据通知公告表ID找通知公告
     *
     * @param noticeId
     * @return
     */
    public NoticeListPO getNoticeListPOByNoticeListPOId(Long noticeId) {
        NoticeListPO noticeListPO = noticeListPOMapper.selectByPrimaryKey(noticeId);
        return noticeListPO;
    }

    /**
     * 更新通知表信息
     *
     * @param session
     * @param menu
     */
    public void updateNoticeListPO(HttpSession session, NoticeListVO menu,Long userId) {
        Long menuId = (Long) session.getAttribute("noticeId"); // 获取进入编辑界面的menuID值
        NoticeListPO noticeListPO = noticeListPOMapper.selectByPrimaryKey(menuId);
        noticeListPO.setContent(menu.getContent());
        noticeListPO.setIsTop(menu.getTop() == false ? 0 : 1);
        noticeListPO.setModifyTime(new Timestamp(new Date().getTime()));
        noticeListPO.setStatusId(menu.getStatusId());
        noticeListPO.setTitle(menu.getTitle());
        noticeListPO.setTypeId(menu.getTypeId());
        noticeListPO.setUrl(menu.getUrl());
        noticeListPO.setUserId(userId);
        session.removeAttribute("noticeId");
        noticeListPOMapper.updateByPrimaryKeySelective(noticeListPO);


    }

    /**
     * 插入通知表信息
     *
     * @param menu
     * @param userId
     */
    public NoticeListPO insertNoticeListPO(NoticeListVO menu, Long userId) {
        NoticeListPO noticeListPO = new NoticeListPO();
        noticeListPO.setUserId(userId);
        noticeListPO.setNoticeTime(new Timestamp(new Date().getTime()));
        noticeListPO.setContent(menu.getContent());
        noticeListPO.setIsTop(menu.getTop() == false ? 0 : 1);
        noticeListPO.setModifyTime(new Timestamp(new Date().getTime()));
        noticeListPO.setStatusId(menu.getStatusId());
        noticeListPO.setTitle(menu.getTitle());
        noticeListPO.setTypeId(menu.getTypeId());
        noticeListPO.setUrl(menu.getUrl());
        noticeListPOMapper.insertSelective(noticeListPO);
        return noticeListPO;



    }
    public void insertNoticeUserRelation(NoticeListPO noticeListPO,Long fatherId){
        List<UserPO> userPOList =userServiceV2.getUserPOListByFatherId(fatherId);

        for (UserPO userPO : userPOList) {
            NoticeUserRelationPO noticeUserRelationPO = new NoticeUserRelationPO();
            noticeUserRelationPO.setIsRead(0);
            noticeUserRelationPO.setRelatinUserId(userPO.getUserId());
            noticeUserRelationPO.setRelatinNoticeId(noticeListPO.getNoticeId());
            noticeUserRelationPOMapper.insertSelective(noticeUserRelationPO);
        }

    }
}
