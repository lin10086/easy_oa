package cn.gson.oasys.serviceV2.scheduleV2;

import cn.gson.oasys.mappers.SchedulePOMapper;
import cn.gson.oasys.modelV2.po.SchedulePO;
import cn.gson.oasys.modelV2.po.SchedulePOExample;
import cn.gson.oasys.voandfactory.scheduleVO2.ScheduleListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ScheduleListPOServiceV2 {
    @Resource
    private SchedulePOMapper schedulePOMapper;
    @Resource
    private ScheduleUserPOServiceV2 scheduleUserServiceV2;


    /**
     * 插入或更新日程表
     *
     * @param scheduleListVO 日程信息
     * @param userId         用户ID
     * @return
     */
    public SchedulePO insertOrUpdateSchedulePO(ScheduleListVO scheduleListVO, Long userId) {
        SchedulePO schedulePO = new SchedulePO();
        schedulePO.setUserId(userId);
        schedulePO.setCreateTime(scheduleListVO.getCreateTime());
        schedulePO.setEndTime(scheduleListVO.getEndTime());
        schedulePO.setFiledescribe(scheduleListVO.getDescribe());
        schedulePO.setIsRemind(scheduleListVO.getIsRemind() == false ? 0 : 1);
        schedulePO.setIsreminded(scheduleListVO.getIsreminded() == false ? 0 : 1);
        schedulePO.setMiaoshu(scheduleListVO.getDescribe());
        schedulePO.setStartTime(scheduleListVO.getStartTime());
        schedulePO.setStatusId(scheduleListVO.getStatusId());
        schedulePO.setTitle(scheduleListVO.getTitle());
        schedulePO.setTypeId(scheduleListVO.getTypeId());
        if (scheduleListVO.getRcId() == null) {
            schedulePOMapper.insertSelective(schedulePO);
        } else {
            schedulePO.setRcId(scheduleListVO.getRcId());
            schedulePOMapper.updateByPrimaryKeySelective(schedulePO);
        }
        return schedulePO;
    }

    /**
     * 根据日程表id删除日程信息（先删除关联表信息，在删除主表信息）
     *
     * @param schedulePOId 日程ID
     */
    public void deleteSchedulePO(Long schedulePOId) {
        scheduleUserServiceV2.deleteScheduleUserPO(schedulePOId);
        schedulePOMapper.deleteByPrimaryKey(schedulePOId);
    }

    /**
     * 根据日程所属人找日程列表
     *
     * @param userId 用户ID
     * @return
     */
    public List<SchedulePO> getSchedulePOListByUserId(Long userId) {
        SchedulePOExample schedulePOExample = new SchedulePOExample();
        schedulePOExample.createCriteria().andUserIdEqualTo(userId);
        List<SchedulePO> schedulePOList = schedulePOMapper.selectByExample(schedulePOExample);
        return schedulePOList;
    }

    /**
     * 根据日程表ID找对应日程
     *
     * @param scheduleId
     * @return
     */
    public SchedulePO getSchedulePOBySchedulePOId(Long scheduleId) {
        SchedulePO schedulePO = schedulePOMapper.selectByPrimaryKey(scheduleId);
        return schedulePO;
    }


}
