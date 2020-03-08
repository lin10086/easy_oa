package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.modelV2.po.UserPOExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        PageInfo<UserPO> userPOPageInfo = new PageInfo<>(userPOList);
        Long total = userPOPageInfo.getTotal();
        log.info("userPOList={},total={}", userPOList, total);
    }

    @Test
    public void getUserPO() {
        List<Map<String, UserPO>> mapList = new ArrayList<>();
        Map<String, UserPO> map = new HashMap<>();
        UserPOExample userPOExample = new UserPOExample();
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        for (UserPO userPO : userPOList) {
            map.put("userPO", userPO);
            mapList.add(map);
        }
        log.info("mapList={}", mapList);
        for (Map<String, UserPO> map1 : mapList) {
            log.info("map1.get(\"userPO\")={}",map1.get("userPO"));
        }

    }

}
