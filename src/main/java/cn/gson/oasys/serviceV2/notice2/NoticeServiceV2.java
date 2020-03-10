package cn.gson.oasys.serviceV2.notice2;

import cn.gson.oasys.mappers.NoticeListPOMapper;
import cn.gson.oasys.mappers.NoticeUserRelationPOMapper;
import cn.gson.oasys.modelV2.po.*;
import cn.gson.oasys.serviceV2.deptV2.DeptPOServiceV2;
import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.voandfactory.noticeVO2.NoticeListVO;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.*;

@Service
public class NoticeServiceV2 {
    
    @Resource
    private NoticeListPOMapper noticeListPOMapper;
    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private StatusPOServiceV2 statusPOServiceV2;
    @Resource
    private DeptPOServiceV2 deptPOServiceV2;
    @Resource
    private NoticeUserRelationPOMapper noticeUserRelationPOMapper;
    @Resource
    private NoticeUserRelationPOServiceV2 noticeUserRelationPOServiceV2;
    @Resource
    private NoticePOServiceV2 noticePOServiceV2;

    /**
     * 封装通知列表
     *
     * @param noticeListPOList 通知列表
     * @return
     */
    public List<Map<String, Object>> encapsulationNoticeList(List<NoticeListPO> noticeListPOList) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < noticeListPOList.size(); i++) {
            Map<String, Object> result = new HashMap<>();
            result.put("noticeId", noticeListPOList.get(i).getNoticeId());//公告ID
            result.put("typename", typePOServiceV2.getTypePOByTypeId(noticeListPOList.get(i).getTypeId()).getTypeName());//根据公告类型ID获取公告类型名
            result.put("statusname", statusPOServiceV2.getStatusPOByStatusId(noticeListPOList.get(i).getStatusId()).getStatusName());// 根据公告状态ID获取公告状态名
            result.put("statuscolor", statusPOServiceV2.getStatusPOByStatusId(noticeListPOList.get(i).getStatusId()).getStatusColor());//根据公告状态ID获取公告状态颜色
            result.put("title", noticeListPOList.get(i).getTitle());//获取公告管理的标题
            result.put("noticeTime", new Timestamp(noticeListPOList.get(i).getNoticeTime().getTime()));//获取发布公告的时间
            result.put("top", noticeListPOList.get(i).getIsTop() == 0 ? false : true);//通知是否置顶(默认为0不置顶）
            result.put("url", noticeListPOList.get(i).getUrl());//获取通知内的链接
            result.put("username", userPOServiceV2.getUserPOByUserId(noticeListPOList.get(i).getUserId()).getUserName());//根据通知的用户ID找用户名
            result.put("deptname", deptPOServiceV2.getDeptPOByUserId(noticeListPOList.get(i).getUserId()).getDeptName());//根据通知的用户ID找部门名
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
     * @param noticeListVO 从页面获取的信息
     */
    public void updateNoticeListPO(HttpSession session, NoticeListVO noticeListVO, Long userId) {
        Long noticeId = (Long) session.getAttribute("noticeId"); // 获取进入编辑界面的noticeId值
        NoticeListPO noticeListPO = noticeListPOMapper.selectByPrimaryKey(noticeId);
        noticeListPO.setContent(noticeListVO.getContent());
        noticeListPO.setIsTop(noticeListVO.getTop() == false ? 0 : 1);
        noticeListPO.setModifyTime(new Timestamp(new Date().getTime()));
        noticeListPO.setStatusId(noticeListVO.getStatusId());
        noticeListPO.setTitle(noticeListVO.getTitle());
        noticeListPO.setTypeId(noticeListVO.getTypeId());
        noticeListPO.setUrl(noticeListVO.getUrl());
        noticeListPO.setUserId(userId);
        session.removeAttribute("noticeId");
        noticeListPOMapper.updateByPrimaryKeySelective(noticeListPO);
    }

    /**
     * 根据页面获取到的信息插入通知主表信息
     *
     * @param menu
     * @param userId
     */
    public NoticeListPO insertNoticeListPOByNoticeListVOAndUserId(NoticeListVO menu, Long userId) {
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

    /**
     * 插入一条新的通知
     *
     * @param userId
     * @return
     */
    public NoticeListPO insertNoticeListPOByUserId(Long userId) {
        NoticeListPO noticeListPO = new NoticeListPO();
        noticeListPO.setTypeId(11l);
        noticeListPO.setStatusId(15l);
        noticeListPO.setTitle("您有一个日程即将开始");
        noticeListPO.setUrl("/daycalendar");
        noticeListPO.setUserId(userId);
        noticeListPO.setNoticeTime(new Date());
        noticeListPOMapper.insertSelective(noticeListPO);
        return noticeListPO;
    }

    /**
     * 根据通知主表ID删除通知表信息
     *
     * @param noticeId 通知表ID
     */
    public void deleteNoticeListPO(Long noticeId) {
        noticeUserRelationPOServiceV2.deleteNoticeUserRelationPOByRelationNoticeId(noticeId);//根据主表ID删除关系表信息
        noticeListPOMapper.deleteByPrimaryKey(noticeId);
    }


    /**
     * 更新通知关联表信息（把未读改为已读）
     *
     * @param relationId 通知用户是否已读表ID
     */
    public void updateNoticeUserRelationInIsRead(Long relationId) {
        NoticeUserRelationPO noticeUserRelationPO = noticeUserRelationPOMapper.selectByPrimaryKey(relationId);//根据关联表ID查出关联表信息
        noticeUserRelationPO.setIsRead(1);//0未读1已读
        noticeUserRelationPOMapper.updateByPrimaryKeySelective(noticeUserRelationPO);
    }

    /**
     * 获取通知主表和通知用户关联表并进行封装
     *
     * @param userId 用户ID
     * @return
     */
    public List<Map<String, Object>> getNoticeUserRelationAndNoticeListPO(Long userId) {
        List<Map<String, Object>> list = new ArrayList<>();
//        根据登录人ID在关联表找关联表信息,并根据是否已读升序
        List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationPOServiceV2.getNoticeUserRelationPOListByRelationUserIdOrderIsReadASC(userId);
        for (NoticeUserRelationPO noticeUserRelationPO : noticeUserRelationPOList) {
            Map<String, Object> map = new HashMap<>();
            //根据通知公告ID找通知公告信息,并根据是否置顶修改时间排序
            NoticeListPO noticeListPO = noticePOServiceV2.getNoticeListPOByNoticeIdOrderIsTopDESCAndModifyTimeDESC(noticeUserRelationPO.getRelationNoticeId());
            map.put("status", statusPOServiceV2.getStatusPOByStatusId(noticeListPO.getStatusId()).getStatusName());//状态名
            map.put("type", typePOServiceV2.getTypePOByTypeId(noticeListPO.getTypeId()).getTypeName());//类型名
            map.put("statusColor", statusPOServiceV2.getStatusPOByStatusId(noticeListPO.getStatusId()).getStatusColor());//状态颜色
            map.put("userName", userPOServiceV2.getUserPOByUserId(noticeListPO.getUserId()).getUserName());//用户名
            map.put("deptName", deptPOServiceV2.getDeptPOByUserId(noticeListPO.getUserId()).getDeptName());//部门名
            map.put("contain", this.isForward(noticeListPO.getNoticeId(), noticeUserRelationPO.getRelationUserId()));//
            map.put("is_read", noticeUserRelationPO.getIsRead());//是否已读
            map.put("notice_time", new Timestamp(noticeListPO.getNoticeTime().getTime()));//发布是时间
            map.put("is_top", noticeListPO.getIsTop());//是否置顶
            map.put("title", noticeListPO.getTitle());//通知标题
            map.put("url", noticeListPO.getUrl());//通知路径
            map.put("notice_id", noticeListPO.getNoticeId());//通知ID
            map.put("relatin_id", noticeUserRelationPO.getRelationId());// 通知用户关系表ID
            list.add(map);
        }
        return list;
    }

    /**
     * 用户判断是否已经转发了
     *
     * @param noticeId
     * @param userId
     * @return
     */
    private int isForward(Long noticeId, Long userId) {
        int count = 1;
        if (userPOServiceV2.getUserPOListByFatherId(userId).size() > 0) {//判断是否有下属用户
            List<Long> userListId = userPOServiceV2.getUserPOIdListByFatherId(userId);//下属用户ID集合
            if (noticeUserRelationPOServiceV2.getNoticeUserRelationPOListByNoticeId(noticeId) != null) {
                List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationPOServiceV2.getNoticeUserRelationPOListByNoticeId(noticeId);
                for (NoticeUserRelationPO noticeUserRelationPO : noticeUserRelationPOList) {
                    if (userListId.contains(noticeUserRelationPO.getRelationUserId())) {
                        //下属用户ID包含了公告关联表用户ID，已经有此公告了已经转发了
                        count = 2;
                    }
                }
                if (count != 2) {
                    count = 3;
                }
            }

        }
        return count;
    }


    /**
     * 根据用户ID和各种排序找通知列表
     *
     * @param userId  用户ID
     * @param baseKey 模糊字
     * @param type    类型
     * @param status  状态
     * @param time    修改时间
     * @return
     */
    public List<NoticeListPO> noticeListPOSByUserIdAndOrders(Long userId, String baseKey, String type, String status, String time) {
        String str = null;
        if (!StringUtils.isEmpty(type)) {//根据类型排序
            if ("1".equals(type)) {
                str = "type_id DESC";
            } else {
                str = "type_id ASC";
            }
        } else if (!StringUtils.isEmpty(status)) {//根据状态排序
            if ("1".equals(status)) {
                str = "status_id DESC";
            } else {
                str = "status_id ASC";
            }
        } else if (!StringUtils.isEmpty(time)) {//根据时间排序
            if ("1".equals(time)) {
                str = "modify_time DESC";
            } else {
                str = "modify_time ASC";
            }
        } else if (!StringUtils.isEmpty(baseKey)) {
            return noticePOServiceV2.noticeListPOSByUserIdAndTitleLikeOrderIsTopDESCAndModifyTimeDESC(userId, baseKey);
        }
        return noticePOServiceV2.noticeListPOSByUserIdAndOrders(userId, str);
    }


}
