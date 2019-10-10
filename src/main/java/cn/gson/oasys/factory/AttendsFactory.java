package cn.gson.oasys.factory;

import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.AttendsPO;
import cn.gson.oasys.model.po.UserPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AttendsFactory {


    /**
     * @param userPO自己定义的用户实体类
     * @param attendsPO自己定义的考勤列表实体类
     * @return 本身的考勤列表实体类
     */
    public static Attends create(UserPO userPO, AttendsPO attendsPO) {

        Attends attends = new Attends();
        attends.setUser(UserFactory.create(userPO));

        attends.setTypeId(attendsPO.getTypeId());
        attends.setAttendsId(attendsPO.getAttendsId());
        //ftl 时间显示使用了Timestamp机制
        attends.setAttendsTime(new Timestamp(attendsPO.getAttendsTime().getTime()));
        attends.setAttendsIp(attendsPO.getAttendsIp());
        attends.setAttendsRemark(attendsPO.getAttendsRemark());
        attends.setStatusId(attendsPO.getStatusId());
        attends.setAttendsRemark(attendsPO.getAttendsRemark());
        attends.setStatusId(attendsPO.getStatusId());
        attends.setTypeId(attendsPO.getTypeId());
        attends.setHolidayDays(attendsPO.getHolidayDays());
        attends.setAttendHmtime(attendsPO.getAttendHmtime());
        attends.setWeekOfday(attendsPO.getWeekOfday());
        attends.setHolidayStart(attendsPO.getHolidayStart());


        return attends;
    }


    public static List<Attends> create(List<UserPO> userPOList, List<AttendsPO> attendsPOList) {
        List<Attends> attendsList = new ArrayList<>();
        for (AttendsPO attendsPO : attendsPOList) {
            for (UserPO userPO : userPOList) {
                if (attendsPO.getAttendsUserId().equals(userPO.getUserId())) {
                    attendsList.add(AttendsFactory.create(userPO, attendsPO));
                }
            }
        }
        return attendsList;
    }

    //一个用户对应多个考勤
    //在考勤列表里面取出属于用户自己的考勤
    public static  List<User> createAttends(List<UserPO> userPOList, List<AttendsPO>attendsPOList) {
        List<User>userList = UserFactory.create(userPOList);
        List<Attends>attendsList = AttendsFactory.create(userPOList,attendsPOList);

        for (User user : userList) {
            //用户考勤
            Set<Attends>attendsSet = new HashSet<>();
            for (Attends attends : attendsList) {
                if (user.getUserId().equals(attends.getUser().getUserId())) {
                    attendsSet.add(attends);
                }
            }
            //把用户自己的考勤放到用户里面
            user.setaSet(attendsSet);
        }

        return userList;
    }


}