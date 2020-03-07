package cn.gson.oasys.factory;

import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.UserPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserFactory {

    /**
     * 把userPO转换为user
     *
     * @param userPO
     * @return
     */
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
        user.setBirth(new Timestamp(userPO.getBirth().getTime()));
        user.setIsLock(userPO.getIsLock());
        user.setPinyin(userPO.getPinyin());
        user.setSex(userPO.getSex());
        user.setUserSign(userPO.getUserSign());
        user.setHireTime(userPO.getHireTime());
        user.setHoliday(userPO.getHoliday());

        user.setSalary((userPO.getSalary().intValue()) + "");
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



