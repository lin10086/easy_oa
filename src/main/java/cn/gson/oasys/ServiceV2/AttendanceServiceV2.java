package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.AttendsFactory;
import cn.gson.oasys.factory.TypeFactory;
import cn.gson.oasys.factory.UserFactory;
import cn.gson.oasys.mappers.AttendsPOMapper;
import cn.gson.oasys.mappers.StatusPOMapper;
import cn.gson.oasys.mappers.TypePOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.bo.QueryAttendsBO;
import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class AttendanceServiceV2 {

    @Resource
    private UserPOMapper userPOMapper;
    @Resource
    private AttendsPOMapper attendsPOMapper;
    @Resource
    private StatusPOMapper statusPOMapper;
    @Resource
    private TypePOMapper typePOMapper;


    public List<AttendsPO> queryAttend(QueryAttendsBO queryAttendsBO, PageBO pageBO) {
        //从session里面获取用户ID
        //创建Long类型的集合ids用于存放查询到的用户ID
        List<Long> ids = new ArrayList<>();
        //把类型状态列表设置到请求对象里面

        queryAttendsBO.setAttendStatus(getAttendStatus());
        queryAttendsBO.setAttendTypes(getAttendType());
        //根据下属用户ID，类型，状态，时间来分页查询，把结果放到考勤页面里面
        return queryPage(queryAttendsBO, pageBO);
    }

    // 分页
    public List<AttendsPO> queryPage(QueryAttendsBO queryAttendsBO, PageBO pageBO) {
        PageHelper.startPage(pageBO.getPageNo(), pageBO.getPageSize());
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        AttendsPOExample.Criteria criteria = attendsPOExample.createCriteria();

        if (queryAttendsBO.getAttendDayStart() != null && queryAttendsBO.getAttendDayEnd() != null) {
            criteria.andAttendsTimeBetween(queryAttendsBO.getAttendDayStart(), queryAttendsBO.getAttendDayEnd());
        }

        if (queryAttendsBO.getAttendTypes() != null && queryAttendsBO.getAttendTypes().size() > 1) {
            criteria.andTypeIdIn(queryAttendsBO.getAttendTypes());
        }
        if (queryAttendsBO.getAttendStatus() != null && queryAttendsBO.getAttendStatus().size() > 1) {
            criteria.andStatusIdIn(queryAttendsBO.getAttendStatus());
        }

        if (queryAttendsBO.getUserIds() != null && queryAttendsBO.getUserIds().size() > 1) {
            criteria.andAttendsUserIdIn(queryAttendsBO.getUserIds());
        }
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        PageInfo pageInfo = new PageInfo(attendsPOList);
        pageBO.setTotalCount(pageInfo.getTotal());
        log.info("total={}, pageInfo={},list={}", pageInfo.getTotal(), pageInfo, attendsPOList);
        return attendsPOList;
    }

    //单个用户分页
    public List<Attends> attendancePage(int page, Long userId) {
        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdEqualTo(userId);
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);

        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andAttendsUserIdEqualTo(userId);
        PageHelper.startPage(page, 10);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        List<Attends> attendsList = AttendsFactory.create(userPOList, attendsPOList);
        return attendsList;
    }

    private List<Long> getAttendStatus() {
        //TODO 获取考勤状态
        //参考：List<StatusEntity> status = statusMapper.selectStatusModel("aoa_attends_list");
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelEqualTo("aoa_attends_list");
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        List<Long> statusList = new ArrayList<>();
        for (StatusPO statusPO : statusPOList) {
            statusList.add(statusPO.getStatusId());

        }
        return statusList;
    }

    //根据考勤的模型获取考勤类型ID列表
    private List<Long> getAttendType() {
        //TODO 获取考勤类型
        //List<TypeEntity> type = typeMapper.selectTypeModel("aoa_attends_list");
        TypePOExample typePOExample = new TypePOExample();
        typePOExample.createCriteria().andTypeModelEqualTo("aoa_attends_list");
        List<TypePO> typePOList = typePOMapper.selectByExample(typePOExample);
        List<Long> typeList = new ArrayList<>();
        for (TypePO typePO : typePOList) {
            typeList.add(typePO.getTypeId());
        }
        return typeList;
    }

    //根据用户ID返回用户信息
    private UserPO getUserById(Long userId) {
        return userPOMapper.selectByPrimaryKey(userId);
    }

    //根据用户用上司的ID返回下属用户
    private List<UserPO> getUsersByFatherId(Long fatherUserId) {
        UserPOExample userPOExample = new UserPOExample();
        //TODO 条件
        userPOExample.createCriteria().andFatherIdEqualTo(fatherUserId);

        return userPOMapper.selectByExample(userPOExample);
    }

    //获取一周的考勤
    public List<Attends> findOneWeekV2(Date startdate, Date enddate, List<User> userList) {
        if (startdate == null && enddate == null) {
            return new ArrayList<>();
        }

        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andAttendsTimeBetween(startdate, enddate)
                .andAttendsUserIdIn(UserFactory.getUserIds(userList));
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);

        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andUserIdIn(UserFactory.getUserIds(userList));
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);
        List<Attends> attendsList = AttendsFactory.create(userPOList, attendsPOList);

        return attendsList;

    }

    //获取单个用户的月下班次数
    public Integer userCountOffWork(String month, Long userId) {
        if (month == null) {
            return 0;
        }
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andTypeIdEqualTo(9L)
                .andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
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

    //获取单个用户的月上班次数
    public Integer userCountToWork(String month, Long userId) {
        if (month == null) {
            return 0;
        }
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andTypeIdEqualTo(8L)
                .andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
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

    //获取用户月上班正常，迟到，早退 的次数
    public Integer userCountStatusNum(String month, Long statusId, Long userId) {
        if (month == null) {
            return 0;
        }
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andStatusIdEqualTo(statusId)
                .andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
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

    //获取用户月请假，出差次数
    public Integer userCountTypeNum(String month, Long typeId, Long userId) {
        if (month == null) {
            return 0;
        }
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andTypeIdEqualTo(typeId)
                .andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
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

    //用户当天的考勤次数
    public Integer countAttendance(String nowdate, Long userId) {

        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int i = 0;
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();
            String str = simpleDateFormat.format(date);
            if (nowdate.equals(str)) {
                i++;
            }

        }
        return i;
    }

    //获取用户当天下班的考勤ID
    public Long userAttendanceId(String nowdate, Long stypeId, Long userId) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andStatusIdEqualTo(stypeId)
                .andAttendsUserIdEqualTo(userId);
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Long attendanceId = null;
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();
            String str = simpleDateFormat.format(date);
            if (nowdate.equals(str)) {
                attendanceId = attendsPO.getAttendsId();
            }
        }
        return attendanceId;
    }

    //根据考勤ID修改时间，时分，状态
    public void updateTimeV2(Date date, String hourmin, Long statusId, Long aid) {

        AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(aid);
        attendsPO.setAttendsTime(new Date());
        attendsPO.setAttendHmtime(hourmin);
        attendsPO.setStatusId(statusId);

    }

    //根据类型ID找类型名
    public String typeName(Long typeId) {
        TypePO typePO = typePOMapper.selectByPrimaryKey(typeId);
        SystemTypeList systemTypeList = TypeFactory.create(typePO);
        String typeName = systemTypeList.getTypeName();
        return typeName;
    }

    //显示当天的最新记录(考勤表的用户ID和时间降序取第一个）
    public Attends attends(String nowdate, Long userId, UserPO userPO) {
        AttendsPOExample attendsPOExample = new AttendsPOExample();
        attendsPOExample.createCriteria().andAttendsUserIdEqualTo(userId);
        attendsPOExample.setOrderByClause(nowdate + "DESC");
        List<AttendsPO> attendsPOList = attendsPOMapper.selectByExample(attendsPOExample);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        List<Long> longList = null;
        for (AttendsPO attendsPO : attendsPOList) {
            Date date = attendsPO.getAttendsTime();
            String str = simpleDateFormat.format(date);
            if (nowdate.equals(str)) {
                longList.add(attendsPO.getAttendsId());
            }
        }
        Long attendanceId = longList.get(0);
        AttendsPO attendsPO = attendsPOMapper.selectByPrimaryKey(attendanceId);
        Attends attends = AttendsFactory.create(userPO, attendsPO);

        return attends;
    }

    //考勤管理里面的删除
    public void deleteUserAttendanceByAid(Long aid) {
        attendsPOMapper.deleteByPrimaryKey(aid);
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
}
