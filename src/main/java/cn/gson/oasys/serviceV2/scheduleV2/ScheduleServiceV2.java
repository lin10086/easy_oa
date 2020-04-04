package cn.gson.oasys.serviceV2.scheduleV2;

import cn.gson.oasys.modelV2.po.SchedulePO;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.voandfactory.scheduleVO2.ScheduleListVO;
import cn.gson.oasys.voandfactory.scheduleVO2.ScheduleListVOFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ScheduleServiceV2 {
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private ScheduleListPOServiceV2 scheduleListServiceV2;
    @Resource
    private ScheduleUserPOServiceV2 scheduleUserServiceV2;

    public List<ScheduleListVO> scheduleListVOS(Long userId) {
        Set<SchedulePO> aboutSchedulePOSet = new HashSet<>();//总的日程
        List<SchedulePO> mySchedulePOList = scheduleListServiceV2.getSchedulePOListByUserId(userId);//根据日程归属人找日程
        List<SchedulePO> otherSchedulePOList = scheduleUserServiceV2.getSchedulePOList(userId);//根据日程归属人找属于自己的日程信息

        for (SchedulePO schedulePO : mySchedulePOList) {
            aboutSchedulePOSet.add(schedulePO);
        }
        for (SchedulePO schedulePO : otherSchedulePOList) {
            aboutSchedulePOSet.add(schedulePO);
        }
        List<SchedulePO> aboutSchedulePOList = new ArrayList<>(aboutSchedulePOSet);//set转list
        List<ScheduleListVO> scheduleListVOS = ScheduleListVOFactory.createScheduleListVOListBySchedulePOList(aboutSchedulePOList);
        for (ScheduleListVO scheduleListVO : scheduleListVOS) {
            for (SchedulePO schedulePO : aboutSchedulePOList) {
                if (scheduleListVO.getRcId().equals(schedulePO.getRcId())) {
                    String username = userPOServiceV2.getUserPOByUserId(schedulePO.getUserId()).getUserName();
                    scheduleListVO.setUsername(username);
                }
            }

        }
        return scheduleListVOS;
    }

}
