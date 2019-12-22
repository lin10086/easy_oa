package cn.gson.oasys.ServiceV2.scheduleV2;

import cn.gson.oasys.ServiceV2.UserPOServiceV2;
import cn.gson.oasys.model.po.SchedulePO;
import cn.gson.oasys.vo.factoryvo.ScheduleFactory.ScheduleListVOFactory;
import cn.gson.oasys.vo.scheduleVO2.ScheduleListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleServiceV2 {
    @Resource
    private UserPOServiceV2 userServiceV2;
    @Resource
    private ScheduleListServiceV2 scheduleListServiceV2;
    @Resource
    private ScheduleUserServiceV2 scheduleUserServiceV2;

    public List<ScheduleListVO> scheduleListVOS(Long userId) {
//        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
//        List<UserPO> userPOList = new ArrayList<>();
//        userPOList.add(userPO);
        List<SchedulePO> aboutSchedulePOList = new ArrayList<>();//总的日程
        List<SchedulePO> mySchedulePOList = scheduleListServiceV2.getSchedulePOListByUserId(userId);//根据日程归属人找日程
        List<SchedulePO> otherSchedulePOList = scheduleUserServiceV2.getSchedulePOList(userId);//根据日程归属人找属于自己的日程信息

        for (SchedulePO schedulePO : mySchedulePOList) {
            aboutSchedulePOList.add(schedulePO);
        }
        for (SchedulePO schedulePO : otherSchedulePOList) {
            aboutSchedulePOList.add(schedulePO);
        }


        List<ScheduleListVO> scheduleListVOS = ScheduleListVOFactory.createScheduleListVOList(aboutSchedulePOList);
        for (ScheduleListVO scheduleListVO : scheduleListVOS) {
            for (SchedulePO schedulePO : aboutSchedulePOList) {
                String username = userServiceV2.getUserPOByUserId(schedulePO.getUserId()).getUserName();
                scheduleListVO.setUsername(username);
            }

        }

        return scheduleListVOS;
    }


}
