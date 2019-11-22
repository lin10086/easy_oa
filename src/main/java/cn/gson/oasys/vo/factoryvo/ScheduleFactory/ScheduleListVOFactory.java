package cn.gson.oasys.vo.factoryvo.ScheduleFactory;

import cn.gson.oasys.model.po.SchedulePO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.scheduleVO2.ScheduleListVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduleListVOFactory {
    public static ScheduleListVO createSchedulePO(SchedulePO schedulePO) {
        ScheduleListVO scheduleListVO = new ScheduleListVO();
        scheduleListVO.setRcId(schedulePO.getRcId());
        scheduleListVO.setTypeId(schedulePO.getTypeId());
        scheduleListVO.setStatusId(schedulePO.getStatusId());
        scheduleListVO.setStartTime(new Timestamp(schedulePO.getStartTime().getTime()));
        scheduleListVO.setEndTime(new Timestamp(schedulePO.getEndTime().getTime()));
        scheduleListVO.setCreateTime(new Timestamp(schedulePO.getCreateTime().getTime()));
        scheduleListVO.setTitle(schedulePO.getTitle());
        scheduleListVO.setDescribe(schedulePO.getMiaoshu());
        scheduleListVO.setIsRemind(schedulePO.getIsRemind() == 0 ? false : true);
        scheduleListVO.setIsreminded(schedulePO.getIsreminded() == 0 ? false : true);
        return scheduleListVO;
    }

    public static List<ScheduleListVO> createScheduleListVOList(List<SchedulePO> schedulePOList) {
        List<ScheduleListVO> scheduleListVOList = new ArrayList<>();
        for (SchedulePO schedulePO : schedulePOList) {
            scheduleListVOList.add(ScheduleListVOFactory.createSchedulePO(schedulePO));
        }
        return scheduleListVOList;

    }
}
