package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.DiscussListPOMapper;
import cn.gson.oasys.model.po.DiscussListPO;
import cn.gson.oasys.model.po.DiscussListPOExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class SortTest {
    @Resource
    private DiscussListPOMapper discussListPOMapper;


}

