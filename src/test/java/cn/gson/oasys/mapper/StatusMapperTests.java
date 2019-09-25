package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.StatusMapper;
import cn.gson.oasys.model.entity.StatusEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StatusMapperTests {
    @Resource
    StatusMapper statusMapper;
    @Test
    public void statusMapper(){
        //10早退11迟到12早退
        StatusEntity status=statusMapper.selectStatusId(10);
        System.out.println(status);
    }
}
