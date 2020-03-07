package cn.gson.oasys.vo.attendansVO2;

import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.AttendsPO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttendancesVOFactory {

    public static AttendanceVO createAttendancesVOByAttendancesPO(AttendsPO attendsPO) {
        AttendanceVO attendanceVO = new AttendanceVO();
        attendanceVO.setAttendsId(attendsPO.getAttendsId());
        attendanceVO.setAttendsTime(new Timestamp(attendsPO.getAttendsTime().getTime()));
        attendanceVO.setAttendHMtime(attendsPO.getAttendHmtime());
        attendanceVO.setWeekOfDay(attendsPO.getWeekOfday());
        attendanceVO.setAttendsIp(attendsPO.getAttendsIp());
        attendanceVO.setAttendsRemark(attendsPO.getAttendsRemark());
        attendanceVO.setHolidayStart(attendsPO.getHolidayStart());
        attendanceVO.setHolidayDays(attendsPO.getHolidayDays());
        attendanceVO.setStatusId(attendsPO.getStatusId());
        attendanceVO.setTypeId(attendsPO.getTypeId());
        return attendanceVO;
    }

    public static List<AttendanceVO> createAttendancesVOListByAttendancesPOList(List<AttendsPO> attendsPOList) {
        List<AttendanceVO> attendanceVOList = new ArrayList<>();
        for (AttendsPO attendsPO : attendsPOList) {
            attendanceVOList.add(createAttendancesVOByAttendancesPO(attendsPO));
        }
        return attendanceVOList;
    }


}
