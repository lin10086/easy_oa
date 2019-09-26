package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.AttendanceMapper;
import cn.gson.oasys.mappers.AttendsPOMapper;
import cn.gson.oasys.model.entity.AttendanceEntity;
import cn.gson.oasys.model.po.AttendsPO;
import cn.gson.oasys.model.po.AttendsPOExample;
import freemarker.template.utility.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceTests {

    @Resource
    private AttendanceMapper attendanceMapper;

    @Resource
    private AttendsPOMapper attendsPOMapper;


    @Test
    public void selectUserId() {
        List<AttendanceEntity> list = attendanceMapper.selectUserId(14);

        System.out.println(list);
    }


    @Test
    public void selectUserIdPO() {
        AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(14L);
        log.info("selectUserIdPO: list={}", attendsPO);
    }


    @Test
    public void selectUserIdPOExample() {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria()
                .andAttendsIdEqualTo(14L);
        List<AttendsPO> list = attendsPOMapper.selectByExample(attendsPOExample);
        log.info("selectUserIdPO: list={}", list);
    }

    @Test
    public void selectUserIdPOExampleOr() {
        AttendsPOExample attendsPOExample = new AttendsPOExample();

        attendsPOExample.createCriteria()
                .andAttendsIdEqualTo(14L);

        AttendsPOExample.Criteria criteria2 = attendsPOExample.createCriteria()
                .andAttendsIdEqualTo(15L);

        attendsPOExample.or(criteria2);
        List<AttendsPO> list = attendsPOMapper.selectByExample(attendsPOExample);
        log.info("selectUserIdPO: list={}", list);
    }


    @Test
    public void selectUserIdPOExampleIn() {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria()
                .andAttendsIdIn(Lists.newArrayList(14L, 15L));
        List<AttendsPO> list = attendsPOMapper.selectByExample(attendsPOExample);
        log.info("selectUserIdPO: list={}", list);
    }

    @Test
    public void selectUserIdPOExampleInBwtween() {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria()
                .andAttendsIdIn(Lists.newArrayList(14L, 15L))
                .andAttendsTimeBetween(DateUtils.addYears(new Date(), -1), new Date());
        List<AttendsPO> list = attendsPOMapper.selectByExample(attendsPOExample);
        log.info("selectUserIdPO: list={}", list);
    }

    @Test
    public void selectuserids() {
        List<Integer> ids = new ArrayList<>();
        ids.add(14);
        ids.add(15);
        ids.add(16);
        ids.add(26);
        List<AttendanceEntity> list = attendanceMapper.selectUserIds(ids);
        for (AttendanceEntity attend : list) {
            System.out.println(attend);
        }

    }

}
