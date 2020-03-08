package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.modelV2.po.DeptPO;
import cn.gson.oasys.modelV2.po.DeptPOExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class DeptPOMapperTests {

    @Resource
    DeptPOMapper deptPOMapper;

    @Test
    public void selectById(){
        DeptPO deptPO = deptPOMapper.selectByPrimaryKey(5L);
        log.info("electByPrimaryKey deptPO={}",deptPO);
    }
    //查询表里面的所有信息

    @Test
    public void getAll(){

        DeptPOExample deptPOExample =new DeptPOExample();
//        deptPOExample.createCriteria().getAllCriteria();
        List<DeptPO> deptPOList = deptPOMapper.selectByExample(deptPOExample);
        log.info("getAll: deptPOList={}",deptPOList);
    }
}
