package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.UserMapper;
import cn.gson.oasys.model.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Resource
    UserMapper userMapper;


    @Test
    public void selectFatherUserId(){
        Integer fatherId=5;
        List<UserEntity> users=userMapper.selectFatherUserId(5);
        for(UserEntity user:users) {
            System.out.println(user);
        }
    }
}
