package cn.gson.oasys.service;

import cn.gson.oasys.serviceV2.attendansV2.AttendanceServiceV2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceServiceTest {

    @Resource
    AttendanceServiceV2 attendanceServiceV2;

//    @Test
//    public void queryPage() {
//        PageBO page = new PageBO();
//        QueryAttendsBO queryAttendsBO = new QueryAttendsBO();
//        queryAttendsBO.setUserIds(Lists.newArrayList(14L, 15L, 16L, 26L));
//        queryAttendsBO.setAttendDayStart(DateUtils.addYears(new Date(), -2));
//        queryAttendsBO.setAttendDayEnd(new Date());
//        queryAttendsBO.setAttendTypes(Lists.newArrayList(8L, 9L));
//        queryAttendsBO.setAttendStatus(Lists.newArrayList(10L, 11L, 12L));
//        List<AttendsPO> attendsPOList = attendanceServiceV2.queryAttend(queryAttendsBO, page);
//        log.info("attendsPOList={}", attendsPOList);
//    }

    @Test
    public void getIp() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        String ip = inetAddress.getHostAddress();//主机IP
        String hostName = inetAddress.getHostName();//主机名
        log.info("ip={},hostName={}", ip, hostName);
//        INFO - ip=127.0.0.1,hostName=MacBook-Pro.local
    }

    @Test
    public void stringAndDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss EE");

        Date date = new Date();
        String dateStr = sdf.format(date);
        log.info("dateStr={}", dateStr);

    }

    @Test
    public void string() {

        double d = 1100.10;
        String dou = String.valueOf(d);
        System.out.println(dou);
    }

}
