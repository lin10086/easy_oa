package cn.gson.oasys.service;

import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.mappers.RolePOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Resource
    private UserPOMapper userPOMapper;
    @Resource
    private DeptPOMapper deptPOMapper;
    @Resource
    private PositionPOMapper positionPOMapper;
    @Resource
    private RolePOMapper rolePOMapper;
    
}
