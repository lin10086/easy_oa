package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.UserMapper;
import cn.gson.oasys.model.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    public void selectFatherUserIds(){
        Integer fatherId=5;
        List<UserEntity> users=userMapper.selectFatherUserIds(fatherId);

        for(UserEntity user:users) {
            System.out.println(user);
        }
    }


    @Test
    public void selectFatherUserId(){
        Integer fatherId=5;
        UserEntity user=userMapper.selectFatherUserId(fatherId);
            System.out.println(user);

    }

}
