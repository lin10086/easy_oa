package cn.gson.oasys.user;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Test
    public void getList() {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);
        log.info("list1={}", list1);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(3);
        list2.add(5);
        log.info("list2={}", list2);
        list.addAll(list1);
        log.info("list={}", list);
        list.addAll(list2);
        log.info("list={}", list);
        list.removeAll(list1);
        log.info("list={}", list);

    }
}
