package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.DiscussListPOMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SortTest {
    @Resource
    private DiscussListPOMapper discussListPOMapper;


}

