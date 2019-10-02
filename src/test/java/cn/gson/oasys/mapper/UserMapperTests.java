package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.UserMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.entity.UserEntity;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTests {

    @Resource
    UserMapper userMapper;
    @Resource
    UserPOMapper userPOMapper;


//    List<UserPO> list = null;
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
    public void selectFatherUserIds() {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andFatherIdEqualTo(5l);

        List<UserPO> list = userPOMapper.selectByExample(userPOExample);
        log.info("selectFatherUserIds: list={}", list);

    }

    @Test
    public void selectFatherUserIdPO() {
        UserPO userPO = userPOMapper.selectByPrimaryKey(14L);
        log.info("selectUserIdPO: list={}", userPO);
    }

    @Test
    public void selectUsersIdsIn() {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdIn(Lists.newArrayList(14L, 15L, 16L, 26L));
        List<UserPO> list = userPOMapper.selectByExample(userPOExample);
        log.info("selectUsersIdsIn: list={}", list);
    }

    @Test
    public void selectUsersIdBetween() {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdBetween(14L, 15L);
        List<UserPO> list = userPOMapper.selectByExample(userPOExample);
        log.info("selectUsersIdBetween: list={}", list);
    }

    @Test
    public void selectUsersIdInAndBetween() {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdIn(Lists.newArrayList(14L, 28L))
                .andFatherIdBetween(5L, 7L);
        List<UserPO> list = userPOMapper.selectByExample(userPOExample);

        log.info("selectUsersIdInAndBetween: list={}", list);
    }

    @Test
    public void selectUsersIdInOrBetweenPage() {
        UserPOExample userPOExample = new UserPOExample();
        //条件1
//        userPOExample.createCriteria().andUserIdIn(Lists.newArrayList(14L, 28L));

        //条件2
//        UserPOExample.Criteria criteria2 = userPOExample.createCriteria().andFatherIdBetween(5L, 7L);
        //或关系
//        userPOExample.or(criteria2);

        PageHelper.startPage(1, 20);
        List<UserPO> list = userPOMapper.selectByExample(userPOExample);


        PageInfo<UserPO> pageInfo = new PageInfo<>(list);
        List<Long> ids = new ArrayList<>();

        for (UserPO userPO : list) {
            ids.add(userPO.getUserId());
        }
        log.info("total={},list={}", pageInfo.getTotal(), list);
        log.info("selectUsersIdInOrBetweenPage: ids={}", ids);
        log.info("pageInfo.getList()={}", pageInfo.getList());
    }

    @Test
    public void deleteUser() {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdEqualTo(40L);

        Integer rows = userPOMapper.deleteByExample(userPOExample);
        log.info("deleteUser: rows={}", rows);
    }

    @Test
    public void insertUser() {
        UserPO userPO = new UserPO();
        userPO.setAddress("陕西西安");
        userPO.setBank("新增用户2");
        //支队设置的字段进行插入
        Integer rows = userPOMapper.insertSelective(userPO);
        log.info("insertUser:rows={}", rows);
    }

    //    updateByPrimaryKeySelective会对字段进行判断再更新(如果为Null就忽略更新)，如果你只想更新某一字段，可以用这个方法
    @Test
    public void updateByPrimaryKeySelective() {
        UserPO userPO = new UserPO();
        userPO.setUserId(37L);
        userPO.setEamil("9999@qq.com");
        userPO.setSalary(2222.2F);
        userPO.setBank("更新的");
        userPO.setAddress("西安");
        //如果字段是null值则不能更新
        Integer rows = userPOMapper.updateByPrimaryKeySelective(userPO);
        log.info("updateByPrimaryKeySelective: rows={}", rows);
    }

    //    updateByPrimaryKey对你注入的字段全部更新，如果为字段不更新，数据库的值就为null
    @Test
    public void updateByPrimaryKey() {
        UserPO userPO = new UserPO();
//        userPO.setUserId(37L);
        userPO.setEamil("5678@qq.com");
        userPO.setBirth(new Date());
        Integer rows = userPOMapper.updateByPrimaryKey(userPO);
        log.info("updateByPrimaryKey: rows={}", rows);
    }

    @Test
    public void updateByExampleSelective() {
        //目标信息
        UserPO userPO = new UserPO();
        userPO.setBank("新的");
        //条件
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andFatherIdEqualTo(7L);
        Integer rows = userPOMapper.updateByExampleSelective(userPO, userPOExample);
        log.info("updateByExampleSelective: rows={}", rows);
    }


}
