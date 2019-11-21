package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.ScheduleUserPOMapper;
import cn.gson.oasys.model.po.ScheduleUserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ScheduleTest {
    @Resource
    private ScheduleUserPOMapper scheduleUserPOMapper;
    @Test
    public void scheduleTest(){
        ScheduleUserPO scheduleUserPO = new ScheduleUserPO();
        scheduleUserPO.setUserId(2L);
        scheduleUserPO.setRcId(10L);
        scheduleUserPOMapper.insertSelective(scheduleUserPO);
    }
}
