package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.UserLoginRecordPOMapper;
import cn.gson.oasys.model.po.UserLoginRecordPO;
import cn.gson.oasys.model.po.UserLoginRecordPOExample;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserLoginRecordTest {
    @Resource
    UserLoginRecordPOMapper userLoginRecordPOMapper;
    @Test
    public void DescAsc(){
        PageHelper.startPage(0,10);
        UserLoginRecordPOExample userLoginRecordPOExample = new UserLoginRecordPOExample();
        userLoginRecordPOExample.createCriteria().andUserIdEqualTo(5L);
        userLoginRecordPOExample.setOrderByClause("login_time DESC");
       List<UserLoginRecordPO>userLoginRecordPOList = userLoginRecordPOMapper.selectByExample(userLoginRecordPOExample);
       log.info("userLoginRecordPOList={}",userLoginRecordPOList);
    }
}
