package cn.gson.oasys.mapper;

import cn.gson.oasys.factory.UserFactory;
import cn.gson.oasys.mappers.AttendanceMapper;
import cn.gson.oasys.mappers.AttendsPOMapper;
import cn.gson.oasys.model.entity.AttendanceEntity;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.AttendsPO;
import cn.gson.oasys.model.po.AttendsPOExample;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;
import freemarker.template.utility.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public void selectAttendIdPO() {
        AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(14L);
        log.info("selectUserIdPO: list={}", attendsPO);
    }


    @Test
    public void selectUserIdPOExample() {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria()
                .andAttendsIdEqualTo(14L);
        List<AttendsPO> list = attendsPOMapper.selectByExample(attendsPOExample);
//       AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(14L);

        log.info("selectUserIdPO: list={}", list);
//        log.info("selectUserIdPO: attendPO={}", attendsPO);
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
//    @Test
//    public void findByUserOrderByTypeIdDesc(){
//        AttendsPOExample attendsPOExample = new AttendsPOExample();
//        attendsPOExample.createCriteria().andAttendsUserIdIn(Lists.newArrayList(14L,15L,16L,26L));
//
//        attendsPOExample.createCriteria().
//
//    }


    @Test
    public void selectUserIdPOExampleOrderBy() {
        AttendsPOExample attendsPOExample = new AttendsPOExample();

        attendsPOExample.createCriteria()
                .andAttendsUserIdIn(Lists.newArrayList(14L, 15L, 16L, 26L));

        attendsPOExample.setOrderByClause("type_id DESC");

        List<AttendsPO> list = attendsPOMapper.selectByExample(attendsPOExample);
        AttendsPO attendsPO = list.get(0);
        log.info("attendsPo={}",attendsPO);
//        log.info("selectUserIdPOExampleOrderBy: list={}", list);
    }

    //目的：查找当月（从数据库获取时间与页面获取到的时间比较）用户（ID）下班（类型）次数，
    @Test
    public void countMonthOffnumPO() {
       /* Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");

        String s = simpleDateFormat.format(date);
        log.info("s={}", s);*/

     /*   String s1 = new SimpleDateFormat("yyyy-MM").format(new Date());
        log.info("s1={}",s1);*/

        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andTypeIdEqualTo(9L)
                .andAttendsUserIdEqualTo(14L);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        log.info("attendsPOList={}", attendsPOList);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        String month = "2019-10";
        int i = 0;
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();
            log.info("date={}", date);
            String str = simpleDateFormat.format(date);
            log.info("str={}", str);
            if (month.equals(str)) {
                i++;
            }
        }
            log.info("i={}", i);


    }


}
