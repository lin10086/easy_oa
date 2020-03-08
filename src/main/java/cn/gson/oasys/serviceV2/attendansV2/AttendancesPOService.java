package cn.gson.oasys.serviceV2.attendansV2;

import cn.gson.oasys.mappers.AttendsPOMapper;
import cn.gson.oasys.modelV2.po.AttendsPO;
import cn.gson.oasys.modelV2.po.AttendsPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class AttendancesPOService {
    @Resource
    private AttendsPOMapper attendsPOMapper;

    /**
     * 签到插入考勤时间
     *
     * @param typeId        类型ID
     * @param statusId      状态ID
     * @param date          时间
     * @param hourMin       时分
     * @param weekOfDay     周几
     * @param attendancesIp 考勤IP
     * @param userId        用户ID
     */
    public void insertAttendancesPO(Long typeId, Long statusId, Date date, String hourMin, String weekOfDay, String attendancesIp, Long userId) {
        AttendsPO attendsPO = new AttendsPO();
        attendsPO.setTypeId(typeId);
        attendsPO.setStatusId(statusId);
        attendsPO.setAttendsTime(date);
        attendsPO.setAttendHmtime(hourMin);
        attendsPO.setWeekOfday(weekOfDay);
        attendsPO.setAttendsIp(attendancesIp);
        attendsPO.setAttendsUserId(userId);
        attendsPOMapper.insertSelective(attendsPO);
    }


    /**
     * 根据考勤ID删除考勤
     *
     * @param aid 考勤ID
     */
    public void deleteAttendancesPOByAttendancesId(Long aid) {
        attendsPOMapper.deleteByPrimaryKey(aid);
    }


    /**
     * 根据考勤ID修改时间，时分，状态,ip
     *
     * @param date          日期
     * @param hourMin       时分
     * @param statusId      状态ID
     * @param aid           考勤ID
     * @param attendancesIp 考勤IP
     */
    public void updateTimeAndStatusIdAndIp(Date date, String hourMin, Long statusId, Long aid, String attendancesIp) {
        AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(aid);
        attendsPO.setAttendsTime(date);
        attendsPO.setAttendHmtime(hourMin);
        attendsPO.setStatusId(statusId);
        attendsPO.setAttendsIp(attendancesIp);
        attendsPOMapper.updateByPrimaryKeySelective(attendsPO);
    }

    /**
     * 更新考勤备注和考勤状态
     *
     * @param remark        备注信息
     * @param statusId      状态ID
     * @param attendancesId 考勤ID
     */
    public void updateAttendancesByRemarkAndStatusId(String remark, Long statusId, Long attendancesId) {
        AttendsPO attendsPO = new AttendsPO();
        attendsPO.setAttendsId(attendancesId);
        attendsPO.setAttendsRemark(remark);
        attendsPO.setStatusId(statusId);
        attendsPOMapper.updateByPrimaryKeySelective(attendsPO);
    }

    /**
     * 根据考勤ID找考勤列表
     *
     * @param attendancesId 考勤ID
     * @return
     */
    public AttendsPO getAttendancesPOByAttendancesId(Long attendancesId) {
        AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(attendancesId);
        return attendsPO;
    }

    /**
     * 根据用户ID找用户的考勤列表
     *
     * @param userId 用户ID
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserId(Long userId) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ID和类型ID找用户的考勤
     *
     * @param userId 用户ID
     * @param typeId 类型ID
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserIdAndTypeId(Long userId, Long typeId) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andTypeIdEqualTo(typeId)
                .andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ID和状态ID找用户的考勤
     *
     * @param userId   用户ID
     * @param statusId 状态ID
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserIdAndStatusId(Long userId, Long statusId) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andStatusIdEqualTo(statusId)
                .andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ID和考勤时间降序获取用户的考勤列表
     *
     * @param userId 用户ID
     * @return
     */
    public List<AttendsPO> getAttendancePOListByUserIdAndAttendanceTimeDESC(Long userId) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andAttendsUserIdEqualTo(userId);
        attendsPOExample.setOrderByClause("attends_time DESC");
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ids获取用户的考勤列表并根据考勤时间降序排列
     *
     * @param userIds 用户ids
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserIdsOrderAttendancesTimeDESC(List<Long> userIds) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.setOrderByClause("attends_time DESC");
        attendsPOExample.createCriteria().andAttendsUserIdIn(userIds);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ids获取用户的考勤列表并根据考勤时间降序排列
     *
     * @param userIds 用户ids
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserIdsOrderAttendancesTimeASC(List<Long> userIds) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.setOrderByClause("attends_time ASC");
        attendsPOExample.createCriteria().andAttendsUserIdIn(userIds);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ids获取用户的考勤列表并根据考勤类型降序排列
     *
     * @param userIds 用户ids
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserIdsOrderTypeIdDESC(List<Long> userIds) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.setOrderByClause("type_id DESC");
        attendsPOExample.createCriteria().andAttendsUserIdIn(userIds);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ids获取用户的考勤列表并根据考勤类型升序排列
     *
     * @param userIds 用户ids
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserIdsOrderTypeIdASC(List<Long> userIds) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.setOrderByClause("type_id ASC");
        attendsPOExample.createCriteria().andAttendsUserIdIn(userIds);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ids获取用户的考勤列表并根据考勤状态降序排列
     *
     * @param userIds 用户ids
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserIdsOrderStatusIdDESC(List<Long> userIds) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.setOrderByClause("status_id DESC");
        attendsPOExample.createCriteria().andAttendsUserIdIn(userIds);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }

    /**
     * 根据用户ids获取用户的考勤列表并根据考勤状态升序排列
     *
     * @param userIds 用户ids
     * @return
     */
    public List<AttendsPO> getAttendancesPOListByUserIdsOrderStatusIdASC(List<Long> userIds) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.setOrderByClause("status_id ASC");
        attendsPOExample.createCriteria().andAttendsUserIdIn(userIds);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }


    /**
     * 获取下属用户的一周考勤
     *
     * @return
     */
    public List<AttendsPO> getAttendancesPOByUserIdInAndAttendancesTimeBetween(Date startDate, Date endDate, List<Long> userIds) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andAttendsTimeBetween(startDate, endDate)
                .andAttendsUserIdIn(userIds);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        return attendsPOList;
    }
}
