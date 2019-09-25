package cn.gson.oasys.mapper;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.gson.oasys.mappers.AttendanceMapper;
import cn.gson.oasys.mappers.UserMapper;
import cn.gson.oasys.model.entity.AttendanceEntity;
import cn.gson.oasys.model.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttendanceTests {

    @Resource
    private AttendanceMapper attendanceMapper;


    @Test
    public void selectUserId(){
        List<AttendanceEntity>list=attendanceMapper.selectUserId(14);

        System.out.println(list);
    }
    @Test
    public void selectuserids(){
                  List<Integer>ids=new ArrayList<>();
              ids.add(14);
              ids.add(15);
              ids.add(16);
              ids.add(26);
        List<AttendanceEntity>list=attendanceMapper.selectUserIds(ids);
        for(AttendanceEntity attend:list){
            System.out.println(attend);
        }

    }

}
