package cn.gson.oasys.serviceV2.notice2;

import cn.gson.oasys.mappers.NoticeListPOMapper;
import cn.gson.oasys.modelV2.po.NoticeListPO;
import cn.gson.oasys.modelV2.po.NoticeListPOExample;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticePOServiceV2 {
    @Resource
    private NoticeListPOMapper noticeListPOMapper;

    /**
     * 根据通知公告ID找通知公告信息,并根据是否置顶修改时间排序
     *
     * @param noticeId 通知公告ID
     * @return
     */
    public NoticeListPO getNoticeListPOByNoticeIdOrderIsTopDESCAndModifyTimeDESC(Long noticeId) {
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
        noticeListPOExample.setOrderByClause("is_top desc,modify_time desc");
        noticeListPOExample.createCriteria().andNoticeIdEqualTo(noticeId);
        List<NoticeListPO> noticeListPOS = noticeListPOMapper.selectByExample(noticeListPOExample);
        return noticeListPOS.get(0);
    }

    public List<NoticeListPO> getNoticeListPOSByNoticeIdOrderIsTopDESCAndModifyTimeDESCOrOrders(Long noticeId, String baseKey, Integer type, Integer status, Integer time) {
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
        if (baseKey != null) {
            noticeListPOExample.createCriteria().andTitleLike("%" + baseKey + "%").andNoticeIdEqualTo(noticeId);
        } else {
            noticeListPOExample.createCriteria().andNoticeIdEqualTo(noticeId);

        }
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
        } else {
            str = "is_top desc,modify_time desc";
        }
        noticeListPOExample.setOrderByClause(str);
        List<NoticeListPO> noticeListPOS = noticeListPOMapper.selectByExample(noticeListPOExample);
        return noticeListPOS;
    }

    /**
     * 根据用户ID找通知公告列表,并根据是否置顶修改时间排序
     *
     * @param userId 用户ID
     * @return
     */
    public List<NoticeListPO> noticeListPOSByUserIdOrderIsTopDESCAndModifyTimeDESC(Long userId) {
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
        noticeListPOExample.setOrderByClause("is_top desc,modify_time desc");
        noticeListPOExample.createCriteria().andUserIdEqualTo(userId);
        List<NoticeListPO> noticeListPOS = noticeListPOMapper.selectByExample(noticeListPOExample);
        return noticeListPOS;
    }

    /**
     * 根据用户ID和通知标题模糊找通知公告列表,并根据是否置顶修改时间排序
     *
     * @param userId  用户ID
     * @param baseKey 模糊字
     * @return
     */
    public List<NoticeListPO> noticeListPOSByUserIdAndTitleLikeOrderIsTopDESCAndModifyTimeDESC(Long userId, String baseKey) {
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
        noticeListPOExample.setOrderByClause("is_top desc,modify_time desc");
        noticeListPOExample.createCriteria().andUserIdEqualTo(userId).andTitleLike("%" + baseKey + "%");
        List<NoticeListPO> noticeListPOS = noticeListPOMapper.selectByExample(noticeListPOExample);
        return noticeListPOS;
    }

    /**
     * 根据用户ID找用户通知列表，并根据特定的顺序排列
     *
     * @param userId 用户ID
     * @param orders 排序条件
     * @return
     */
    public List<NoticeListPO> noticeListPOSByUserIdAndOrders(Long userId, String orders) {
        NoticeListPOExample noticeListPOExample = new NoticeListPOExample();
        noticeListPOExample.setOrderByClause(orders);
        noticeListPOExample.createCriteria().andUserIdEqualTo(userId);
        List<NoticeListPO> noticeListPOS = noticeListPOMapper.selectByExample(noticeListPOExample);
        return noticeListPOS;
    }

}
