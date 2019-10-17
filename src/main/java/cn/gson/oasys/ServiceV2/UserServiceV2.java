package cn.gson.oasys.ServiceV2;

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
import cn.gson.oasys.model.po.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
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
    @Resource
    private RolePOMapper rolePOMapper;

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

    //查询所有用户
    public List<UserPO> getUserAll() {
        UserPOExample userPOExample = new UserPOExample();
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        return userPOList;
    }

    //把用户的ID和用户的部门对应起来放到map里面
    public Map<Long, Dept> userIdAndDept(List<UserPO> userPOList) {
        //建立Map集合用于把用户ID和用户的部门对应起来
        Map<Long, Dept> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的部门ID
        for (UserPO userPO : userPOList) {
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
    public Map<Long, Position> userIdAndPosition(List<UserPO> userPOList) {
        //建立Map集合用于把用户ID和用户的职位对应起来
        Map<Long, Position> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的职位ID
        for (UserPO userPO : userPOList) {
            //根据用户里面的部门ID查询用户的部门信息
            PositionPO positionPO = positionPOMapper.selectByPrimaryKey(userPO.getPositionId());
            //把自己定义的用户职位的信息转换成人家的用户职位信息
            Position position = PositionFactory.create(positionPO);
            //把用户ID和职位对应起来
            map.put(userPO.getUserId(), position);
        }
        return map;
    }

    //把用户的ID和用户的角色对应起来放到map里面
    public Map<Long, Role> userIdAndRole(List<UserPO> userPOList) {
        //建立Map集合用于把用户ID和用户的角色对应起来
        Map<Long, Role> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的角色ID
        for (UserPO userPO : userPOList) {
            //根据用户里面的角色ID查询用户的角色信息
            RolePO rolePO = rolePOMapper.selectByPrimaryKey(userPO.getRoleId());
            //把自己定义的用户角色的信息转换成人家的用户角色信息
            Role role = RoleFactory.create(rolePO);
            //把用户ID和角色对应起来
            map.put(userPO.getUserId(), role);
        }
        return map;
    }


    //根据用户ID获取userPO
    public UserPO getUserPOByUserId(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        return userPO;
    }

    //根据用户ID查找用户信息并转换为本身的用户
    public User getUserByUserId(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        User user = UserFactory.create(userPO);
        return user;
    }
//通过用户名查找用户
    public UserPO getUserByUsername(String username){
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserNameEqualTo(username);
        List<UserPO>userPOList  =userPOMapper.selectByExample(userPOExample);
        return userPOList.get(0);
    }

    //更新用户部门ID和职位ID（把刚用户的部门和职位的信息保存到用户里面)
    public void updateUser(Long userId, Dept dept, Position position) {

        UserPO userPO = new UserPO();
        userPO.setDeptId(dept.getDeptId());
        userPO.setPositionId(position.getId());
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdEqualTo(userId);
        userPOMapper.updateByExampleSelective(userPO, userPOExample);
    }

    //更新用户isLock字段
    public void updateUserIsLock(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        userPO.setUserId(userId);
        userPO.setIsLock(1);
        userPOMapper.updateByPrimaryKeySelective(userPO);
    }

    //根据部门表里的deptmanager（实际上是用户ID）查找用户信息
    public User getUserBydeptManager(Dept dept) {

        UserPO userPO = userPOMapper.selectByPrimaryKey(dept.getDeptmanager());
        User user = UserFactory.create(userPO);
        return user;
    }

    /**
     * 根据部门获取用户列表
     *
     * @param dept
     * @return userPOList
     */
    public List<UserPO> getUserByDeptId(Dept dept) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andDeptIdEqualTo(dept.getDeptId());
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);

        return userPOList;
    }

    //根据部门升序，分页，可用户的用户
    public List<UserPO> ASCDeptIsLock(int page, int size) {
        PageHelper.startPage(page, size);
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andIsLockEqualTo(0);
        userPOExample.setOrderByClause("dept_id");
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        return userPOList;
    }

    //根据用户ID查询到用户,根据用户里面的部门ID，职位ID，角色ID，查询用户的部门，职位，角色，返回用户（里面信息都有）
    public User findUserByUserId(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);

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
        return user;
    }

    //更新 部门，职位，角色
    public void insertUserAll(UserPO userPO, Dept dept, Position position, Role role, Long fatherId, String pinyin, String password) {

        userPO.setDeptId(dept.getDeptId());
        userPO.setPositionId(position.getId());
        userPO.setRoleId(role.getRoleId());
        userPO.setFatherId(fatherId);
        userPO.setPinyin(pinyin);
        userPO.setPassword(password);

        userPOMapper.insertSelective(userPO);


    }

    //更新用户信息
    public void updateUserAll1(User user, boolean isbackpassword, Dept dept, Role role, Position position) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(user.getUserId());

        userPO.setUserId(user.getUserId());
        userPO.setUserTel(user.getUserTel());
        userPO.setUserTel(user.getUserTel());
        userPO.setRealName(user.getRealName());
        userPO.setEamil(user.getEamil());
        userPO.setAddress(user.getAddress());
        userPO.setUserEdu(user.getUserEdu());
        userPO.setUserSchool(user.getSchool());
        userPO.setUserIdcard(user.getIdCard());
        userPO.setBank(user.getBank());
        userPO.setThemeSkin(user.getThemeSkin());
        userPO.setSalary(Float.valueOf(user.getSalary()));
        userPO.setFatherId(dept.getDeptmanager());
        if (isbackpassword) {
            userPO.setPassword("123456");
        }
        userPO.setDeptId(dept.getDeptId());
        userPO.setRoleId(role.getRoleId());
        userPO.setPositionId(position.getId());
        userPOMapper.updateByPrimaryKeySelective(userPO);
    }

    public User checkUser(String userName, String password, String userTel) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserNameEqualTo(userName).andPasswordEqualTo(password);
        UserPOExample.Criteria criteria = userPOExample.createCriteria().andUserTelEqualTo(userTel).andPasswordEqualTo(password);
        userPOExample.or(criteria);
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        List<User> userList = UserFactory.create(userPOList);

        if (userList != null && userList.size() >= 1) {
            return userList.get(0);
        }
        return null;
    }

    public UserPO checkUserByUsernameAndPassword(String userName, String password) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andPasswordEqualTo(password)
                .andUserNameEqualTo(userName);
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
//        List<User>userList = UserFactory.create(userPOList);
        if (userPOList != null && userPOList.size() >= 1) {
            return userPOList.get(0);
        }
        return null;
    }


}
