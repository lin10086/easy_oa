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
        return user;
    }


    public static List<User> create(List<UserPO> userPOList) {
        List<User> userList = new ArrayList<>();
        for (UserPO userPO : userPOList) {
            userList.add(UserFactory.create(userPO));
        }
        return userList;
    }

}



