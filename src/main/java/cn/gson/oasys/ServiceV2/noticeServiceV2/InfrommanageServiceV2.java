package cn.gson.oasys.ServiceV2.noticeServiceV2;

import cn.gson.oasys.ServiceV2.*;
import cn.gson.oasys.mappers.NoticeListPOMapper;
import cn.gson.oasys.mappers.NoticeUserRelationPOMapper;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.noticeVO2.NoticeListVO;
import com.github.pagehelper.PageHelper;
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
    @Resource
    private NoticeUserRelationServiceV2 noticeUserRelationServiceV2;

    /**
     * 根据用户ID找通知公告
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
     * 插入通知主表信息
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

    /**
     * 根据通知主表ID删除通知表信息
     *
     * @param noticeId 通知表ID
     */
    public void deleteNoticeListPO(Long noticeId) {
        NoticeUserRelationPOExample noticeUserRelationPOExample = new NoticeUserRelationPOExample();
        noticeUserRelationPOExample.createCriteria().andRelatinNoticeIdEqualTo(noticeId);
        noticeUserRelationPOMapper.deleteByExample(noticeUserRelationPOExample);//先删除附表
        noticeListPOMapper.deleteByPrimaryKey(noticeId);
    }

    /**
     * 通知与用户中间关联表，多一个字段，是否已读（告诉下属用户还有通知为读）
     *
     * @param noticeListPO 公告通知
     * @param fatherId     上司ID
     */
    public void insertNoticeUserRelation(NoticeListPO noticeListPO, Long fatherId) {
        List<UserPO> userPOList = userServiceV2.getUserPOListByFatherId(fatherId);

        for (UserPO userPO : userPOList) {
            NoticeUserRelationPO noticeUserRelationPO = new NoticeUserRelationPO();
            noticeUserRelationPO.setIsRead(0);
            noticeUserRelationPO.setRelatinUserId(userPO.getUserId());
            noticeUserRelationPO.setRelatinNoticeId(noticeListPO.getNoticeId());
            noticeUserRelationPOMapper.insertSelective(noticeUserRelationPO);
        }
    }

    /**
     * 更新通知关联表信息（把未读改为已读）
     *
     * @param relationId 通知用户是否已读表ID
     */
    public void updateNoticeUserRelation(Long relationId) {
        NoticeUserRelationPO noticeUserRelationPO = noticeUserRelationPOMapper.selectByPrimaryKey(relationId);//根据关联表ID查出关联表信息
        noticeUserRelationPO.setIsRead(1);//0未读1已读
        noticeUserRelationPOMapper.updateByPrimaryKeySelective(noticeUserRelationPO);
    }

    public List<Map<String, Object>> getNoticeUserRelation(Long userId) {
        List<Map<String, Object>> list = new ArrayList<>();
        NoticeUserRelationPOExample noticeUserRelationPOExample = new NoticeUserRelationPOExample();
        noticeUserRelationPOExample.createCriteria().andRelatinUserIdEqualTo(userId);
        // 根据登录人ID在关联表找关联表信息
        List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationPOMapper.selectByExample(noticeUserRelationPOExample);
        for (NoticeUserRelationPO noticeUserRelationPO : noticeUserRelationPOList) {
            Map<String, Object> map = new HashMap<>();
            //根据关联表中的通知主表ID找通知主表信息
            NoticeListPO noticeListPO = noticeListPOMapper.selectByPrimaryKey(noticeUserRelationPO.getRelatinNoticeId());
            map.put("status", statusServiceV2.getStatusPOByStatusId(noticeListPO.getStatusId()).getStatusName());
            map.put("type", typeServiceV2.getTypePOByTypeId(noticeListPO.getTypeId()).getTypeName());
            map.put("statusColor", statusServiceV2.getStatusPOByStatusId(noticeListPO.getStatusId()).getStatusColor());
            map.put("userName", userServiceV2.getUserPOByUserId(noticeListPO.getUserId()).getUserName());
            map.put("deptName", deptServiceV2.getDeptPOByUserId(noticeListPO.getUserId()).getDeptName());
            map.put("contain", this.isForward(noticeListPO.getNoticeId(), noticeUserRelationPO.getRelatinUserId()));
            map.put("is_read", noticeUserRelationPO.getIsRead());
            map.put("notice_time", new Timestamp(noticeListPO.getNoticeTime().getTime()));
            map.put("is_top", noticeListPO.getIsTop());
            map.put("title", noticeListPO.getTitle());
            map.put("url", noticeListPO.getUrl());
            map.put("notice_id", noticeListPO.getNoticeId());
            map.put("relatin_id", noticeUserRelationPO.getRelatinId());
            list.add(map);
        }
        return list;
    }

    // 封装对象，将List<Map<String, Object>>中的值进行封装，例如type_id封装成相对应的名字
//    public List<Map<String, Object>> setNoticeListPOList(List<NoticeListPO> noticeListPOList) {
//        List<Map<String,Object>> mapList = new ArrayList<>();
//        Map<String,Object>map = new HashMap<>();
//        for (NoticeListPO noticeListPO : noticeListPOList) {
//            map.put("status",statusServiceV2.getStatusPOByStatusId(noticeListPO.getStatusId()).getStatusName());
//            map.put("type", typeServiceV2.getTypePOByTypeId(noticeListPO.getTypeId()).getTypeName());
//            map.put("statusColor", statusServiceV2.getStatusPOByStatusId(noticeListPO.getStatusId()).getStatusColor());
//            map.put("userName", userServiceV2.getUserPOByUserId(noticeListPO.getUserId()).getUserName());
//            map.put("deptName", deptServiceV2.getDeptPOByUserId(noticeListPO.getUserId()).getDeptName());
//            map.put("contain",this.isForward(noticeListPO.getNoticeId(), noticeListPO.getUserId()));
//        }
//        return mapList;
//    }

    /**
     * 用户判断是否已经转发了
     *
     * @param noticeId
     * @param userId
     * @return
     */
    private int isForward(Long noticeId, Long userId) {
        int count = 1;
        if (userServiceV2.getUserPOListByFatherId(userId).size() > 0) {
            List<Long> userListId = userServiceV2.getUserPOIdListByFatherId(userId);
            if (noticeUserRelationServiceV2.getNoticeUserRelationPOListByNoticeId(noticeId) != null) {
                List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationServiceV2.getNoticeUserRelationPOListByNoticeId(noticeId);

                for (NoticeUserRelationPO noticeUserRelationPO : noticeUserRelationPOList) {
                    if (userListId.contains(noticeUserRelationPO.getRelatinUserId())) {
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

}
