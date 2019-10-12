package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.DeptFactory;
import cn.gson.oasys.factory.PositionFactory;
import cn.gson.oasys.factory.UserFactory;
import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceV2 {
    @Resource
   private UserPOMapper userPOMapper;
    @Resource
    private DeptPOMapper deptPOMapper;
    @Resource
    private PositionPOMapper positionPOMapper;

    //找到该管理员下面的所有用户并且分页
    public List<UserPO> findUserAndPageByFatherId(int page, long fatherId) {

        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andFatherIdEqualTo(fatherId);


        PageHelper.startPage(page, 10);
//查询到的下属用户,已经分页
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);

//        List<User> userList = UserFactory.create(userPOList);
//        PageInfo pageInfo = new PageInfo(userList);
//        log.info("total={}, pageInfo={},list={}", pageInfo.getTotal(), pageInfo, userList);
        return userPOList;
    }


    //把用户的ID和用户的部门对应起来放到map里面
    public Map<Long, Dept> userIdAndDept(List<UserPO>userPOList) {
        //建立Map集合用于把用户ID和用户的部门对应起来
        Map<Long, Dept> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的部门ID
        for (UserPO userPO:userPOList) {
            //根据用户里面的部门ID查询用户的部门信息
            DeptPO deptPO = deptPOMapper.selectByPrimaryKey(userPO.getDeptId());
            //把自己定义的用户部门的信息转换成人家的用户部门信息
            Dept dept = DeptFactory.create(deptPO);
            //把用户ID和部门对应起来
            map.put(userPO.getUserId(), dept);
        }
        return map;
    }

    //把用户的ID和用户的职位对应起来放到map里面
    public Map<Long, Position> userIdAndPosition(List<UserPO>userPOList) {
        //建立Map集合用于把用户ID和用户的职位对应起来
        Map<Long, Position> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的职位ID
        for (UserPO userPO:userPOList) {
            //根据用户里面的部门ID查询用户的部门信息
            PositionPO positionPO = positionPOMapper.selectByPrimaryKey(userPO.getPositionId());
            //把自己定义的用户职位的信息转换成人家的用户职位信息
            Position position = PositionFactory.create(positionPO);
            //把用户ID和职位对应起来
            map.put(userPO.getUserId(), position);
        }
        return map;
    }


    //根据用户ID获取userPO
    public UserPO getUserPOByUserId(Long userId){
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        return userPO;
    }
    //根据用户ID查找用户信息并转换为本身的用户
    public User getUserByUserId(Long userId){
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        User user = UserFactory.create(userPO);
        return user;
    }


    //更新用户信息（把刚用户的部门和职位的信息保存到用户里面)
    public void updateUser(Long userId,Dept dept,Position position){

        UserPO userPO = new UserPO();
        userPO.setDeptId(dept.getDeptId());
        userPO.setPositionId(position.getId());
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdEqualTo(userId);
        userPOMapper.updateByExampleSelective(userPO,userPOExample);
    }
    //根据部门表里的deptmanager（实际上是用户ID）查找用户信息
    public User getUserBydeptManager(Dept dept){

        UserPO userPO = userPOMapper.selectByPrimaryKey(dept.getDeptmanager());
        User user = UserFactory.create(userPO);
        return user;
    }

    /**
     * 根据部门获取用户列表
     * @param dept
     * @return userPOList
     */
    public List<UserPO> getUserByDeptId(Dept dept){
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andDeptIdEqualTo(dept.getDeptId());
        List<UserPO>userPOList = userPOMapper.selectByExample(userPOExample);

        return userPOList;
    }

}
