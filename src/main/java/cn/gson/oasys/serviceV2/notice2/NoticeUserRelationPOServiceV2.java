package cn.gson.oasys.serviceV2.notice2;

import cn.gson.oasys.mappers.NoticeUserRelationPOMapper;
import cn.gson.oasys.modelV2.po.NoticeUserRelationPO;
import cn.gson.oasys.modelV2.po.NoticeUserRelationPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeUserRelationPOServiceV2 {
    @Resource
    private NoticeUserRelationPOMapper noticeUserRelationPOMapper;

    /**
     * 通知与用户中间关联表，多一个字段，是否已读（告诉下属用户还有通知未读）
     *
     * @param relationId 公告通知表ID
     * @param userId     下属用户ID
     */
    public void insertNoticeUserRelationPO(Long relationId, Long userId) {
        NoticeUserRelationPO noticeUserRelationPO = new NoticeUserRelationPO();
        noticeUserRelationPO.setIsRead(0);//设置未读
        noticeUserRelationPO.setRelationUserId(userId);//下属用户ID
        noticeUserRelationPO.setRelationNoticeId(relationId);//通知公告ID
        noticeUserRelationPOMapper.insertSelective(noticeUserRelationPO);
    }


    /**
     * 根据关联表ID删除关联表信息
     *
     * @param noticeUserRelationPOId 通知用户关联表ID
     */
    public void deleteNoticeUserRelationPOByNoticeUserRelationPOId(Long noticeUserRelationPOId) {
        noticeUserRelationPOMapper.deleteByPrimaryKey(noticeUserRelationPOId);
    }

    /**
     * 根据通知主表ID删除通知用户关系表信息
     *
     * @param relationNoticeId 通知表ID
     */
    public void deleteNoticeUserRelationPOByRelationNoticeId(Long relationNoticeId) {
        NoticeUserRelationPOExample noticeUserRelationPOExample = new NoticeUserRelationPOExample();
        noticeUserRelationPOExample.createCriteria().andRelationNoticeIdEqualTo(relationNoticeId);
        noticeUserRelationPOMapper.deleteByExample(noticeUserRelationPOExample);
    }

    /**
     * 根据登录人ID在关联表找关联表信息,并根据是否已读升序
     *
     * @param userId
     * @return
     */
    public List<NoticeUserRelationPO> getNoticeUserRelationPOListByRelationUserIdOrderIsReadASC(Long userId) {
        NoticeUserRelationPOExample noticeUserRelationPOExample = new NoticeUserRelationPOExample();
        noticeUserRelationPOExample.setOrderByClause("is_read ASC");
        noticeUserRelationPOExample.createCriteria().andRelationUserIdEqualTo(userId);
        List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationPOMapper.selectByExample(noticeUserRelationPOExample);
        return noticeUserRelationPOList;
    }


    /**
     * 根据公告ID找关联表信息
     *
     * @param noticeId
     * @return
     */
    public List<NoticeUserRelationPO> getNoticeUserRelationPOListByNoticeId(Long noticeId) {
        NoticeUserRelationPOExample userRelationPOExample = new NoticeUserRelationPOExample();
        userRelationPOExample.createCriteria().andRelationNoticeIdEqualTo(noticeId);
        List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationPOMapper.selectByExample(userRelationPOExample);
        return noticeUserRelationPOList;
    }

    /**
     * 根据通知主表ID和登录人ID找关联表信息
     *
     * @param userId
     * @param noticeId
     * @return
     */
    public NoticeUserRelationPO getNoticeUserRelationPOByNoticeIdAndUserId(Long userId, Long noticeId) {
        NoticeUserRelationPOExample noticeUserRelationPOExample = new NoticeUserRelationPOExample();
        noticeUserRelationPOExample.createCriteria().andRelationNoticeIdEqualTo(noticeId).andRelationUserIdEqualTo(userId);
        List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationPOMapper.selectByExample(noticeUserRelationPOExample);
        if (noticeUserRelationPOList.size() > 0) {
            return noticeUserRelationPOList.get(0);
        } else {
            return null;
        }
    }


    /**
     * 根据用户和是否已读找中间表信息
     *
     * @param userId 用户id
     * @param isRead 是否已读
     * @return
     */
    public List<NoticeUserRelationPO> getNoticeUserRelationPOByIsReadAndUserId(Long userId, Boolean isRead) {
        NoticeUserRelationPOExample noticeUserRelationPOExample = new NoticeUserRelationPOExample();
        noticeUserRelationPOExample.createCriteria().andRelationUserIdEqualTo(userId).andIsReadEqualTo(isRead == false ? 0 : 1);
        List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationPOMapper.selectByExample(noticeUserRelationPOExample);
        return noticeUserRelationPOList;
    }
}
