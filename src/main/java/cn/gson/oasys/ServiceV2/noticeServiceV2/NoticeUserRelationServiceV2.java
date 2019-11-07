package cn.gson.oasys.ServiceV2.noticeServiceV2;

import cn.gson.oasys.mappers.NoticeUserRelationPOMapper;
import cn.gson.oasys.model.po.NoticeUserRelationPO;
import cn.gson.oasys.model.po.NoticeUserRelationPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeUserRelationServiceV2 {
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
}
