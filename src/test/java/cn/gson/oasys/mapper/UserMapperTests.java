package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.UserMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.entity.UserEntity;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Resource
    UserMapper userMapper;
    @Resource
    UserPOMapper userPOMapper;

    UserPOExample userPOExample = new UserPOExample();
    List<UserPO> list = null;
//    @Test
//    public void selectFatherUserIds(){
//        Integer fatherId=5;
//        List<UserEntity> users=userMapper.selectFatherUserIds(fatherId);
//
//        for(UserEntity user:users) {
//            System.out.println(user);
//        }
//    }
    ;

//    @Test
//    public void selectFatherUserId(){
//        Integer fatherId=5;
//        UserEntity user=userMapper.selectFatherUserId(fatherId);
//            System.out.println(user);
//    }

    @Test
    public void selectUserIdPO() {
        UserPO userPO = userPOMapper.selectByPrimaryKey(5L);
        log.info("selectUserIdPO: list={}", userPO);
    }

    @Test
    public void seletcFatherUserIds() {
//        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andFatherIdEqualTo(5l);

        List<UserPO> list = userPOMapper.selectByExample(userPOExample);
        log.info("seletcFatherUserIds: list={}", list);

    }

    @Test
    public void selectFatherUserIdPO() {
        UserPO userPO = userPOMapper.selectByPrimaryKey(14L);
        log.info("selectUserIdPO: list={}", userPO);
    }

    @Test
    public void selectUsersidsIn() {
        userPOExample.createCriteria().andUserIdIn(Lists.newArrayList(14L, 15L, 16L, 26L));
        list = userPOMapper.selectByExample(userPOExample);
        log.info("list={}", list);
    }

    @Test
    public void selectUsersIdBwteen() {
        userPOExample.createCriteria().andUserIdBetween(14L, 15L);
        list = userPOMapper.selectByExample(userPOExample);
        log.info("list={}", list);
    }

    @Test
    public void selectUsersIdInAndBwteen() {
        userPOExample.createCriteria().andUserIdIn(Lists.newArrayList(14L, 28L))
                .andFatherIdBetween(5L, 7L);
        list = userPOMapper.selectByExample(userPOExample);

        log.info("list={}", list);
    }

    @Test
    public void selectUsersIdInOrBwteen() {
        UserPOExample userPOExample = new UserPOExample();
        //条件1
        userPOExample.createCriteria().andUserIdIn(Lists.newArrayList(14L, 28L));

        //条件2
        UserPOExample.Criteria criteria2 = userPOExample.createCriteria().andFatherIdBetween(5L, 7L);
        //或关系
        userPOExample.or(criteria2);

        List<UserPO> list = userPOMapper.selectByExample(userPOExample);

        log.info("list={}", list);
    }
}
