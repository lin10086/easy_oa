package cn.gson.oasys.ServiceV2.noticeServiceV2;

import cn.gson.oasys.ServiceV2.DeptServiceV2;
import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.NoticeListPOMapper;
import cn.gson.oasys.model.entity.notice.NoticesList;
import cn.gson.oasys.model.po.NoticeListPO;
import cn.gson.oasys.model.po.NoticeListPOExample;
import cn.gson.oasys.vo.noticeV2.NoticeListVO;
import com.github.pagehelper.PageHelper;
import org.hibernate.annotations.Source;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


}
