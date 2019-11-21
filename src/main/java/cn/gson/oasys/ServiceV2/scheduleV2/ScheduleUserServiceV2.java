package cn.gson.oasys.ServiceV2.scheduleV2;

import cn.gson.oasys.mappers.ScheduleUserPOMapper;
import cn.gson.oasys.model.po.ScheduleUserPO;
import cn.gson.oasys.model.po.ScheduleUserPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ScheduleUserServiceV2 {
    @Resource
    private ScheduleUserPOMapper scheduleUserPOMapper;

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

}
