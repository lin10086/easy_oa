package cn.gson.oasys;

import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.model.po.UserPO;
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
@SpringBootTest
@RunWith(SpringRunner.class)
public class MapTest {
    @Resource
    private UserServiceV2 userServiceV2;

    @Test
    public void ListTest() {
        List<Long> longList = new ArrayList<>();
        List<UserPO> userPOList = userServiceV2.getUserAll();
//        for (UserPO userPO : userPOList) {
//            longList.add(userPO.getUserId());
//        }
        userPOList.forEach(userPO -> longList.add(userPO.getUserId()));
        log.info("longList={}", longList);
        Map<Long, Long> map = new HashMap<>();
        Long i = 0L;
        for (UserPO userPO : userPOList) {
            map.put(i++, userPO.getUserId());
        }

        for (Long key : map.keySet()) {
            log.info("key={},value={}", key, map.get(key));
        }

        map.forEach((key, value) -> {
            log.info("key={},value={}", key, map.get(key));
        });

    }

    @Test
    public void MapTest() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "第一个");
        map.put(2, "第二个");
        map.put(3, "第三个");
        map.put(4, "第四个");
        map.put(5, "第五个");
//        for (Integer key : map.keySet()) {
//            log.info("key={},value={}", key, map.get(key));
//        }
        map.forEach((key, value) -> {
            log.info("key={},value={}", key, map.get(key));
        });
    }
}
