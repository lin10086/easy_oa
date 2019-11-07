package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.RolePOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.po.RolePOExample;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;
import cn.gson.oasys.vo.UserVO;
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
        List<Map<String, Object>> mapList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        UserPOExample userPOExample = new UserPOExample();
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        log.info("userPOList={}", userPOList);

        map.put("userPOList", userPOList);
        mapList.add(map);
        log.info("mapList={}", mapList);

        Map<String, Object> map1 = mapList.get(0);
        log.info("map1={}", map1);

        List<UserPO> userPOList1 = (List) map1.get("userPOList");
        log.info("userPOList1={}", userPOList1);
        List<UserPO> userPOList2 = (List) mapList.get(0).get("userPOList");
        log.info("userPOList2={}", userPOList2);

        for (UserPO userPO : userPOList1) {
            String userName = userPO.getUserName();
            log.info("userName={}", userName);

        }
    }

}
