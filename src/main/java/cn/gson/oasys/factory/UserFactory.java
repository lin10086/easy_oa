package cn.gson.oasys.factory;

import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;

import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    public static List<Long> createIds(List<User> userList) {
        List<Long> ids = new ArrayList<>();

        for (User user : userList) {
            ids.add(user.getUserId());
        }
        if (ids.size() == 0) {
            ids.add(0L);
        }
        return ids;
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


    public static List<User> create(List<UserPO> userPO) {

        List<User>userList = new ArrayList<>();
        for(int i=0;i<=userPO.size();i++){
            userList.add(UserFactory.create(userPO.get(i)));
        }
        return userList;
    }
}



