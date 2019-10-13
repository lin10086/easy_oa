package cn.gson.oasys.factory;

import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.UserPO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class UserFactory {
    @Resource
    private UserServiceV2 userServiceV2;

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

    //把userPO转换为user
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

        user.setSalary((userPO.getSalary().intValue())+"");
        return user;
    }

    public static List<User> create(List<UserPO> userPOList) {
        List<User> userList = new ArrayList<>();
        for (UserPO userPO : userPOList) {
            userList.add(UserFactory.create(userPO));
        }
        return userList;
    }

    public static UserPO create(User user) {
        UserPO userPO = new UserPO();
        userPO.setUserIdcard(user.getIdCard());
        userPO.setUserSchool(user.getSchool());
        userPO.setUserTel(user.getUserTel());
        userPO.setPassword(user.getPassword());
        userPO.setPinyin(user.getPinyin());
        userPO.setUserName(user.getUserName());
        userPO.setUserId(user.getUserId());
        userPO.setEamil(user.getEamil());
        userPO.setBank(user.getBank());
        userPO.setPassword(user.getPassword());
        userPO.setAddress(user.getAddress());
        userPO.setUserIdcard(user.getIdCard());
        userPO.setRealName(user.getRealName());
        userPO.setFatherId(user.getFatherId());
        userPO.setUserSchool(user.getSchool());
        userPO.setThemeSkin(user.getThemeSkin());
        userPO.setUserEdu(user.getUserEdu());
        userPO.setUserTel(user.getUserTel());
        userPO.setBirth(user.getBirth());
        userPO.setImgPath(user.getImgPath());
        userPO.setBirth(user.getBirth());
        userPO.setIsLock(user.getIsLock());
        userPO.setPinyin(user.getPinyin());
        userPO.setSex(user.getSex());
        userPO.setUserSign(user.getUserSign());
        userPO.setHireTime(user.getHireTime());
        userPO.setHoliday(user.getHoliday());
        userPO.setSalary(Float.valueOf(user.getSalary()));
        userPO.setSuperman(user.getSuperman()==false?0:1);
        return userPO;
    }

}



