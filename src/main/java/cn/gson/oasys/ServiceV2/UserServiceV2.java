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
import cn.gson.oasys.vo.DeptVO;
import cn.gson.oasys.vo.PositionVO;
import cn.gson.oasys.vo.RoleVO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.factoryvo.DeptFactoryVO;
import cn.gson.oasys.vo.factoryvo.PositionFactoryVO;
import cn.gson.oasys.vo.factoryvo.RoleFactoryVO;
import cn.gson.oasys.vo.factoryvo.UserFactoryVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

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


    /**
     * 获取所有用户
     *
     * @return
     */
    public List<UserPO> getUserAll() {
        UserPOExample userPOExample = new UserPOExample();
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        return userPOList;
    }


    /**
     * 把用户的ID和用户的部门对应起来放到map里面
     *
     * @param userPOList
     * @return
     */
    public Map<Long, DeptPO> userPOListIdAndDeptPO(List<UserPO> userPOList) {
        //建立Map集合用于把用户ID和用户的部门对应起来
        Map<Long, DeptPO> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的部门ID
        for (UserPO userPO : userPOList) {
            //根据用户里面的部门ID查询用户的部门信息
            DeptPO deptPO = deptPOMapper.selectByPrimaryKey(userPO.getDeptId());
            //把用户ID和部门对应起来
            map.put(userPO.getUserId(), deptPO);
        }
        return map;
    }

    /**
     * 把用户的ID和用户的职位对应起来放到map里面
     *
     * @param userPOList
     * @return
     */
    public Map<Long, PositionPO> userPOListIdAndPositionPO(List<UserPO> userPOList) {
        //建立Map集合用于把用户ID和用户的职位对应起来
        Map<Long, PositionPO> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的职位ID
        for (UserPO userPO : userPOList) {
            PositionPO positionPO = positionPOMapper.selectByPrimaryKey(userPO.getPositionId());
            map.put(userPO.getUserId(), positionPO);
        }
        return map;
    }

    /**
     * 把用户的ID和用户的角色对应起来放到map里面
     *
     * @param userPOList
     * @return
     */
    public Map<Long, RolePO> userPOListIdAndRolePO(List<UserPO> userPOList) {
        //建立Map集合用于把用户ID和用户的角色对应起来
        Map<Long, RolePO> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的角色ID
        for (UserPO userPO : userPOList) {
            //根据用户里面的角色ID查询用户的角色信息
            RolePO rolePO = rolePOMapper.selectByPrimaryKey(userPO.getRoleId());
            //把用户ID和角色对应起来
            map.put(userPO.getUserId(), rolePO);
        }
        return map;
    }

    //把用户的ID和用户的部门对应起来放到map里面
    public Map<Long, Dept> userIdAndDept(List<UserPO> userPOList) {
        Map<Long, Dept> map = new HashMap<>();
        for (UserPO userPO : userPOList) {
            DeptPO deptPO = deptPOMapper.selectByPrimaryKey(userPO.getDeptId());
            Dept dept = DeptFactory.create(deptPO);
            map.put(userPO.getUserId(), dept);
        }
        return map;
    }


    /**
     * 根据用户ID获取userPO
     *
     * @param userId 用户ID
     * @return
     */
    public UserPO getUserPOByUserId(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        return userPO;
    }

    //通过用户名查找用户
    public UserPO getUserPOByUsername(String username) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserNameEqualTo(username);
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        return userPOList.get(0);
    }

    //更新userPO里面的，部门ID和职位ID
    public void updateUserPO(Long userId, Long deptVOId, long positionVOId) {
        UserPO userPO = new UserPO();
        userPO.setDeptId(deptVOId);
        userPO.setPositionId(positionVOId);
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdEqualTo(userId);
        userPOMapper.updateByExampleSelective(userPO, userPOExample);
    }

    //更新用户的职位信息
    public void updateUserPOPositionId(Long userPOId, Long positionId) {
        UserPO userPO = new UserPO();
        userPO.setUserId(userPOId);
        userPO.setPositionId(positionId);
        userPOMapper.updateByPrimaryKeySelective(userPO);
    }

    //更新用户isLock字段
    public void updateUserIsLock(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        userPO.setUserId(userId);
        userPO.setIsLock(1);
        userPOMapper.updateByPrimaryKeySelective(userPO);
    }

    //根据部门表里的deptmanager（实际上是用户ID）查找用户信息
    public UserPO getUserBydeptManager(Long deptManager) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(deptManager);
        return userPO;
    }

    /**
     * 根据部门获取用户列表
     *
     * @param deptId
     * @return userPOList
     */
    public List<UserPO> getUserByDeptId(Long deptId) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andDeptIdEqualTo(deptId);
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

    /* //根据用户ID查询到用户,根据用户里面的部门ID，职位ID，角色ID，查询用户的部门，职位，角色，返回用户（里面信息都有）
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
     }*/
    //二次修改：根据用户ID查询到用户,根据用户里面的部门ID，职位ID，角色ID，查询用户的部门，职位，角色，返回用户（里面信息都有）

    /**
     * 根据用户ID找到用户信息并补全userVO里面的部门，职位，角色信息(单个用户）
     *
     * @param userId 用户ID
     * @return
     */
    public UserVO setUserVOByUserId(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        DeptPO deptPO = deptPOMapper.selectByPrimaryKey(userPO.getDeptId());
        DeptVO deptVO = DeptFactoryVO.createDeptVO(deptPO);
        PositionPO positionPO = positionPOMapper.selectByPrimaryKey(userPO.getPositionId());
        PositionVO positionVO = PositionFactoryVO.createPositionVO(positionPO);
        RolePO rolePO = rolePOMapper.selectByPrimaryKey(userPO.getRoleId());
        RoleVO roleVO = RoleFactoryVO.createRoleVO(rolePO);

        UserVO userVO = UserFactoryVO.createUserVO(userPO);
        userVO.setDeptVO(deptVO);
        userVO.setPositionVO(positionVO);
        userVO.setRoleVO(roleVO);
        return userVO;
    }

    //插入 部门，职位，角色
    public void insertUserAll(UserPO userPO, DeptVO deptVO, PositionVO positionVO, RoleVO roleVO, Long fatherId, String pinyin, String password) {
        userPO.setDeptId(deptVO.getDeptId());
        userPO.setPositionId(positionVO.getPositionId());
        userPO.setRoleId(roleVO.getRoleId());
        userPO.setFatherId(fatherId);
        userPO.setPinyin(pinyin);
        userPO.setPassword(password);

        userPOMapper.insertSelective(userPO);


    }

    //更新用户信息
    public void updateUserVOAll(UserVO userVO, boolean isbackpassword, DeptVO deptVO, RoleVO roleVO, PositionVO positionVO) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userVO.getUserId());

        userPO.setUserId(userVO.getUserId());
        userPO.setUserTel(userVO.getUserTel());
        userPO.setUserTel(userVO.getUserTel());
        userPO.setRealName(userVO.getRealName());
        userPO.setEamil(userVO.getUserEmail());
        userPO.setAddress(userVO.getUserAddress());
        userPO.setUserEdu(userVO.getUserEdu());
        userPO.setUserSchool(userVO.getUserSchool());
        userPO.setUserIdcard(userVO.getUserIdCard());
        userPO.setBank(userVO.getBank());
        userPO.setThemeSkin(userVO.getThemeSkin());
        userPO.setSalary(Float.valueOf(userVO.getSalary()));
        userPO.setFatherId(deptVO.getDeptManager());
        if (isbackpassword) {
            userPO.setPassword("123456");
        }
        userPO.setDeptId(deptVO.getDeptId());
        userPO.setRoleId(roleVO.getRoleId());
        userPO.setPositionId(positionVO.getPositionId());
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


    /**
     * 根据用户ID找用户名
     *
     * @param userId 用户id
     * @return
     */
    public String getUsernameByUserId(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        String username = userPO.getUserName();
        return username;

    }

    /**
     * 根据上司ID找下属用户列表
     *
     * @param fatherId
     * @return
     */
    public List<UserPO> getUserPOListByFatherId(Long fatherId) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andFatherIdEqualTo(fatherId);
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        return userPOList;
    }

    /**
     * 根据上司ID找下属用户ID
     *
     * @param fatherId
     * @return
     */
    public List<Long> getUserPOIdListByFatherId(Long fatherId) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andFatherIdEqualTo(fatherId);
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        List<Long> userIdList = new ArrayList<>();
        for (UserPO userPO : userPOList) {
            userIdList.add(userPO.getUserId());
        }
        return userIdList;
    }

}
