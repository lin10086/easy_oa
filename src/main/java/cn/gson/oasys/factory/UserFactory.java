package cn.gson.oasys.factory;

import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.AttendsPO;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;

import javax.annotation.Resource;
import java.util.*;

public class UserFactory {
    @Resource
    DeptPOMapper deptPOMapper;

    public static List<Long> getUserIds(List<User> userList) {
        List<Long> userIds = new ArrayList<>();
        for (User user : userList) {
            userIds.add(user.getUserId());
        }
        if (userIds.size() == 0) {
            userIds.add(0L);
        }
        return userIds;
    }

    public static User create(UserPO userPO) {
        User user = new User();

        user.setUserName(userPO.getUserName());
        user.setUserId(userPO.getUserId());
        user.setEamil(userPO.getEamil());
        user.setBank(userPO.getBank());
        user.setPassword(userPO.getPassword());
        user.setAddress(userPO.getAddress());
        user.setIdCard(userPO.getUserIdcard());
        user.setRealName(userPO.getRealName());
        user.setFatherId(userPO.getFatherId());
        user.setSchool(userPO.getUserSchool());
        user.setThemeSkin(userPO.getThemeSkin());
        user.setUserEdu(userPO.getUserEdu());
        user.setUserTel(userPO.getUserTel());
        user.setBirth(userPO.getBirth());
        user.setImgPath(userPO.getImgPath());
        user.setBirth(userPO.getBirth());
        user.setIsLock(userPO.getIsLock());
        user.setPinyin(userPO.getPinyin());
        user.setSex(userPO.getSex());
        user.setUserSign(userPO.getUserSign());
        user.setHireTime(userPO.getHireTime());
        user.setHoliday(userPO.getHoliday());
        user.setDept();
        return user;
    }


    public static List<User> create(List<UserPO> userPOList) {
        List<User> userList = new ArrayList<>();
        for (UserPO userPO : userPOList) {
            userList.add(UserFactory.create(userPO));
        }
        return userList;
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

}



