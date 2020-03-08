package cn.gson.oasys.serviceV2.scheduleV2;

import cn.gson.oasys.mappers.ScheduleUserPOMapper;
import cn.gson.oasys.modelV2.po.SchedulePO;
import cn.gson.oasys.modelV2.po.ScheduleUserPO;
import cn.gson.oasys.modelV2.po.ScheduleUserPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleUserServiceV2 {
    @Resource
    private ScheduleUserPOMapper scheduleUserPOMapper;
    @Resource
    private ScheduleListServiceV2 scheduleListServiceV2;

    /**
     * 根据日程表id和接收人id插入日程关联表
     *
     * @param schedulePOId
     * @param userId
     */
    public void insertScheduleUserPO(Long schedulePOId, Long userId) {
        ScheduleUserPO scheduleUserPO = new ScheduleUserPO();
        scheduleUserPO.setRcId(schedulePOId);
        scheduleUserPO.setUserId(userId);
        scheduleUserPOMapper.insertSelective(scheduleUserPO);
    }

    /**
     * 根据日程id删除日程用户关联表信息
     *
     * @param schedulePOId
     */
    public void deleteScheduleUserPO(Long schedulePOId) {
        ScheduleUserPOExample scheduleUserPOExample = new ScheduleUserPOExample();
        scheduleUserPOExample.createCriteria().andRcIdEqualTo(schedulePOId);
        scheduleUserPOMapper.deleteByExample(scheduleUserPOExample);
    }

    /**
     * 根据日程归属人找属于自己的日程信息
     *
     * @param userId
     * @return
     */
    public List<SchedulePO> getSchedulePOList(Long userId) {
        List<SchedulePO> schedulePOList = new ArrayList<>();
        ScheduleUserPOExample scheduleUserPOExample = new ScheduleUserPOExample();
        scheduleUserPOExample.createCriteria().andUserIdEqualTo(userId);
        List<ScheduleUserPO> scheduleUserPOList = scheduleUserPOMapper.selectByExample(scheduleUserPOExample);
        for (ScheduleUserPO scheduleUserPO : scheduleUserPOList) {
            schedulePOList.add(scheduleListServiceV2.getSchedulePOBySchedulePOId(scheduleUserPO.getRcId()));
        }
        return schedulePOList;
    }

}
