package cn.gson.oasys.serviceV2.attendansV2;

import cn.gson.oasys.mappers.AttendsPOMapper;
import cn.gson.oasys.mappers.TypePOMapper;
import cn.gson.oasys.modelV2.po.*;
import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.voandfactory.attendansVO2.AttendancesVO;
import cn.gson.oasys.voandfactory.attendansVO2.AttendancesVOFactory;
import cn.gson.oasys.voandfactory.userVO2.UserVOFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AttendanceServiceV2 {

    @Resource
    private AttendsPOMapper attendsPOMapper;
    @Resource
    private TypePOMapper typePOMapper;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private AttendancesPOService attendancesPOService;

    /**
     * 考勤分页
     *
     * @param baseKey 模糊字
     * @param userIds 下属用户ID集合
     * @param type    类型
     * @param status  状态
     * @param time    时间
     * @return
     */
    public List<AttendsPO> attendancesPage(String baseKey, List<Long> userIds, Object type, Object status, Object time) {
        if (!StringUtils.isEmpty(baseKey)) {
            // 模糊查询
            return attendancesPOService.getAttendancesPOListByUserIdsOrderAttendancesTimeDESC(userIds);
        }
        if (!StringUtils.isEmpty(type)) {
            if (type.toString().equals("0")) {
                //类型降序
                return attendancesPOService.getAttendancesPOListByUserIdsOrderTypeIdDESC(userIds);
            } else {
                //类型升序
                return attendancesPOService.getAttendancesPOListByUserIdsOrderTypeIdASC(userIds);
            }
        }
        if (!StringUtils.isEmpty(status)) {
            if (status.toString().equals("0")) {
                //状态降序
                return attendancesPOService.getAttendancesPOListByUserIdsOrderStatusIdDESC(userIds);
            } else {
                //状态升序
                return attendancesPOService.getAttendancesPOListByUserIdsOrderStatusIdASC(userIds);
            }
        }
        if (!StringUtils.isEmpty(time)) {
            if (time.toString().equals("0")) {
                //时间降序
                return attendancesPOService.getAttendancesPOListByUserIdsOrderAttendancesTimeDESC(userIds);
            } else {
                //时间升序
                return attendancesPOService.getAttendancesPOListByUserIdsOrderAttendancesTimeASC(userIds);
            }
        } else {
            //都不存在按时间降序排列
            return attendancesPOService.getAttendancesPOListByUserIdsOrderAttendancesTimeDESC(userIds);
        }
    }


    /**
     * 获取一周的考勤
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param userIds   下属用户ID集合
     * @return
     */
    public List<AttendsPO> findOneWeek(Date startDate, Date endDate, List<Long> userIds) {
        if (startDate == null && endDate == null) {
            return new ArrayList<>();
        }
        List<AttendsPO> attendsPOList = attendancesPOService.getAttendancesPOByUserIdInAndAttendancesTimeBetween(startDate, endDate, userIds);
        return attendsPOList;
    }

    /**
     * 获取单个用户的月上下班次数（类型ID，9为下班，8上班）
     *
     * @param month  月份
     * @param userId 用户ID
     * @param typeId 类型ID
     * @return
     */

    public Integer userCountOffWorkOrToWorkOrLeaveOrEvection(String month, Long userId, Long typeId) {
        if (month == null) {
            return 0;
        }
        List<AttendsPO> attendsPOList = attendancesPOService.getAttendancesPOListByUserIdAndTypeId(userId, typeId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        int i = 0;
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();//获取考勤时间
            String str = simpleDateFormat.format(date);//考勤的年月
            if (str.equals(month)) {
                i++;
            }
        }
        return i;
    }


    /**
     * 获取用户月上班正常，迟到，早退 的次数
     *
     * @param month
     * @param statusId
     * @param userId
     * @return
     */
    public Integer userCountStatusNum(String month, Long statusId, Long userId) {
        if (month == null) {
            return 0;
        }
        List<AttendsPO> attendsPOList = attendancesPOService.getAttendancesPOListByUserIdAndStatusId(userId, statusId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        int i = 0;
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();
            String str = simpleDateFormat.format(date);
            if (str.equals(month)) {
                i++;
            }
        }
        return i;
    }


    /**
     * 用户当天的考勤次数
     *
     * @param nowDate 现在时间(年月日）
     * @param userId  用户ID
     * @return
     */
    public Integer countAttendance(String nowDate, Long userId) {
        List<AttendsPO> attendsPOList = attendancesPOService.getAttendancesPOListByUserId(userId);//根据用户ID找用户的考勤列表
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int i = 0;
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();//考勤时间
            String str = simpleDateFormat.format(date);//用户考勤时间（年月日）
            if (nowDate.equals(str)) {
                i++;
            }
        }
        return i;
    }


    /**
     * 获取用户当天的考勤信息
     *
     * @param nowDate 现在时间
     * @param typeId  状态ID
     * @param userId  用户ID
     * @return
     */
    public AttendsPO getUserNowDateAttendancePO(String nowDate, Long typeId, Long userId) {
        List<AttendsPO> attendsPOList = attendancesPOService.getAttendancesPOListByUserIdAndTypeId(userId, typeId);//根据用户ID和类型ID找用户的考勤
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();
            String str = simpleDateFormat.format(date);
            if (nowDate.equals(str)) {
                return attendsPO;
            }
        }
        return null;
    }

    /**
     * 显示当天的最新记录(考勤表的用户ID和时间降序取第一个）
     *
     * @param nowDate 现在的年月日
     * @param
     * @return
     */
    public AttendsPO getNewAttendancePOByUserId(String nowDate, Long userId) {
        //根据用户ID和考勤时间降序获取用户的考勤列表(用户的考勤列表）
        List<AttendsPO> attendsPOList = attendancesPOService.getAttendancePOListByUserIdAndAttendanceTimeDESC(userId);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();//考勤时间
            String str = simpleDateFormat.format(date);//考勤日期
            if (nowDate.equals(str)) {
                return attendsPO;
            }
        }
        return null;
    }


    /**
     * 插入考勤
     *
     * @param typeName      流程主表的类型名
     * @param processListPO
     */
    public void insertAttendsPO(String typeName, ProcessListPO processListPO) {
        AttendsPO attendsPO = new AttendsPO();
        attendsPO.setHolidayDays((double) processListPO.getProcseeDays());
        attendsPO.setHolidayStart(processListPO.getStartTime());
        attendsPO.setAttendsUserId(processListPO.getProcessUserId());
        if (("请假申请").equals(typeName)) {
            attendsPO.setTypeId(46L);
        } else if (("出差申请").equals(typeName)) {
            attendsPO.setTypeId(47L);
        }
        attendsPOMapper.insertSelective(attendsPO);
    }

    //查找某用户某天最新记录用来显示用户最新的类型和考勤时间（考勤表的用户ID，考勤时间）
//    @Query(nativeQuery = true, value = "SELECT * from aoa_attends_list a WHERE DATE_format(a.attends_time,'%Y-%m-%d') like %?1% and a.attends_user_id=?2 ORDER  BY a.attends_time DESC  LIMIT 1")
//    Attends findlastest(String date, long userid);
    public AttendsPO getAttendsPOByAttendsUserIdAndAttendsTimeDESCFrontFirst(Long userId) {
        // 显示用户当天最新的记录
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowDate = sdf.format(date);
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andAttendsUserIdEqualTo(userId);
        attendsPOExample.setOrderByClause("attends_time DESC");
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        for (AttendsPO attendsPO : attendsPOList) {
            String attendsPOTime;
            if (attendsPO.getAttendsTime() != null) {
                attendsPOTime = sdf.format(attendsPO.getAttendsTime());
            } else {
                attendsPOTime = sdf.format(new Date());
            }
            if (nowDate.equals(attendsPOTime)) {
                return attendsPO;
            }
        }
        return null;
    }


    /**
     * 设置考勤里面的考勤信息
     *
     * @param attendsPOList 考勤列表信息
     * @return
     */
    public List<AttendancesVO> getAttendancesVOListByAttendancesPOList(List<AttendsPO> attendsPOList) {
        List<AttendancesVO> attendanceVOList = AttendancesVOFactory.createAttendancesVOListByAttendancesPOList(attendsPOList);
        for (AttendsPO attendsPO : attendsPOList) {
            for (AttendancesVO attendanceVO : attendanceVOList) {
                if (attendsPO.getAttendsId().equals(attendanceVO.getAttendsId())) {
                    attendanceVO.setUserVO(UserVOFactory.createUserVOByUserPO(userPOServiceV2.getUserPOByUserId(attendsPO.getAttendsUserId())));
                }
            }
        }
        return attendanceVOList;
    }
}
