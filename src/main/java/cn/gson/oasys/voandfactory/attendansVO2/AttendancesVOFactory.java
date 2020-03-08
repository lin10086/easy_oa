package cn.gson.oasys.voandfactory.attendansVO2;

import cn.gson.oasys.modelV2.po.AttendsPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AttendancesVOFactory {

    public static AttendancesVO createAttendancesVOByAttendancesPO(AttendsPO attendsPO) {
        AttendancesVO attendanceVO = new AttendancesVO();
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

    public static List<AttendancesVO> createAttendancesVOListByAttendancesPOList(List<AttendsPO> attendsPOList) {
        List<AttendancesVO> attendanceVOList = new ArrayList<>();
        for (AttendsPO attendsPO : attendsPOList) {
            attendanceVOList.add(createAttendancesVOByAttendancesPO(attendsPO));
        }
        return attendanceVOList;
    }


}
