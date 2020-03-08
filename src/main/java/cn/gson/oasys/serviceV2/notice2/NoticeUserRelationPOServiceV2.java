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
     * 根据公告ID找关联表信息
     *
     * @param noticeId
     * @return
     */
    public List<NoticeUserRelationPO> getNoticeUserRelationPOListByNoticeId(Long noticeId) {
        NoticeUserRelationPOExample userRelationPOExample = new NoticeUserRelationPOExample();
        userRelationPOExample.createCriteria().andRelatinNoticeIdEqualTo(noticeId);
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
        noticeUserRelationPOExample.createCriteria().andRelatinNoticeIdEqualTo(noticeId).andRelatinUserIdEqualTo(userId);
        NoticeUserRelationPO noticeUserRelationPO = noticeUserRelationPOMapper.selectByExample(noticeUserRelationPOExample).get(0);
        return noticeUserRelationPO;
    }

    /**
     * 根据关联表ID删除关联表信息
     *
     * @param noticeUserRelationPOId
     */
    public void deleteNoticeUserRelationPOByNoticeUserRelationPOId(Long noticeUserRelationPOId) {
        noticeUserRelationPOMapper.deleteByPrimaryKey(noticeUserRelationPOId);
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
        noticeUserRelationPOExample.createCriteria().andRelatinUserIdEqualTo(userId).andIsReadEqualTo(isRead == false ? 0 : 1);
        List<NoticeUserRelationPO> noticeUserRelationPOList = noticeUserRelationPOMapper.selectByExample(noticeUserRelationPOExample);
        return noticeUserRelationPOList;
    }
}
