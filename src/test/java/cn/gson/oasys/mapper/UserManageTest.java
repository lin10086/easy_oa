package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.RolePOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.po.RolePOExample;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
public class UserManageTest {
    @Resource
    private UserPOMapper userPOMapper;

    @Test
    public void ASCDeptIsLock() {
        PageHelper.startPage(0, 10);
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andIsLockEqualTo(0);
        userPOExample.setOrderByClause("role_id");
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);

        PageInfo<UserPO>userPOPageInfo = new PageInfo<>(userPOList);
        Long total =userPOPageInfo.getTotal();
        log.info("userPOList={},total={}", userPOList,total);
    }

}
