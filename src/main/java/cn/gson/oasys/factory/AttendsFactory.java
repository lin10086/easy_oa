package cn.gson.oasys.factory;

import cn.gson.oasys.mappers.AttendsPOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.AttendsPO;
import cn.gson.oasys.model.po.AttendsPOExample;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class AttendsFactory {

    /**
     *
     * @param userPO自己定义的用户实体类
     * @param attendsPO自己定义的考勤列表实体类
     * @return 本身的考勤列表实体类
     */
    public static Attends create(UserPO userPO, AttendsPO attendsPO) {


        Attends attends = new Attends();
        attends.setUser(UserFactory.create(userPO));
        // TODO
        attends.setTypeId(attendsPO.getTypeId());
        attends.setAttendsTime(attendsPO.getAttendsTime());
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

    public static List<Attends> create(List<UserPO>userPOList,List<AttendsPO> attendsPOList) {
        List<Attends>attendsList = new ArrayList<>();
        for(int i=0;i<=attendsPOList.size();i++){
            attendsList.add(AttendsFactory.create(userPOList.get(i),attendsPOList.get(i)));
        }

        return attendsList;
    }

}
