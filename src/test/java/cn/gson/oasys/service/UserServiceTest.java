package cn.gson.oasys.service;

import cn.gson.oasys.factory.DeptFactory;
import cn.gson.oasys.factory.PositionFactory;
import cn.gson.oasys.factory.RoleFactory;
import cn.gson.oasys.factory.UserFactory;
import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.mappers.RolePOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
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

    @Test
    public void findUserByUserId(){
        UserPO userPO = userPOMapper.selectByPrimaryKey(1L);
        DeptPO deptPO = deptPOMapper.selectByPrimaryKey(userPO.getDeptId());
        Dept dept = DeptFactory.create(deptPO);
        PositionPO positionPO = positionPOMapper.selectByPrimaryKey(userPO.getPositionId());
        Position position = PositionFactory.create(positionPO);
        RolePO rolePO = rolePOMapper.selectByPrimaryKey(userPO.getRoleId());
        Role role = RoleFactory.create(rolePO);
        User user = UserFactory.create(userPO);
        user.setDept(dept);
        user.setPosition(position);
        user.setRole(role);
        log.info("user={}",user);
    }
}
