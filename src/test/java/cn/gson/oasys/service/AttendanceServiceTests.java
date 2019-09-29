package cn.gson.oasys.service;

import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.bo.QueryAttendsBO;
import cn.gson.oasys.model.po.AttendsPO;
import cn.gson.oasys.services.attendance.AttendanceServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceServiceTests {

    @Resource
    AttendanceServiceV2 attendanceServiceV2;

    @Test
    public void queryPage() {
        PageBO page = new PageBO();
        QueryAttendsBO queryAttendsBO = new QueryAttendsBO();
        queryAttendsBO.setUserIds(Lists.newArrayList(14L, 15L, 16L, 26L));
        queryAttendsBO.setAttendDayStart(DateUtils.addYears(new Date(), -2));
        queryAttendsBO.setAttendDayEnd(new Date());
        queryAttendsBO.setAttendTypes(Lists.newArrayList(8L, 9L));
        queryAttendsBO.setAttendStatus(Lists.newArrayList(10L, 11L, 12L));
        List<AttendsPO> attendsPOList = attendanceServiceV2.queryAttend(queryAttendsBO, page);
        log.info("attendsPOList={}", attendsPOList);
    }

}
