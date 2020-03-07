package cn.gson.oasys.vo.attendansVO2;

import cn.gson.oasys.vo.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class AttendanceVO {

    private Long attendsId;//考勤ID

    private String attendsIp;//考勤表ID

    private String attendsRemark;//考勤备注

    private Date attendsTime;//考勤时间

    private Long statusId;//状态id，46请假47出差

    private Long typeId;//类型id，8上班9下班

    private UserVO userVO;//考勤用户

    private String attendHMtime;//考勤时分

    private String weekOfDay;//星期几

    private Double holidayDays;//请假天数

    private Date holidayStart;//请假开始时间
}
