package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.TypeMapper;
import cn.gson.oasys.mappers.UserMapper;
import cn.gson.oasys.model.entity.TypeEntity;
import cn.gson.oasys.model.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeMapperTests {

    @Resource
    TypeMapper typeMapper;


    @Test
    public void selectTypeId(){
        //8上班9下班
       TypeEntity type=typeMapper.selectTypeId(8);
       System.out.println(type);
    }
}
