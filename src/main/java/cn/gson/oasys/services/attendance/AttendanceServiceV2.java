package cn.gson.oasys.services.attendance;

import cn.gson.oasys.mappers.*;
import cn.gson.oasys.model.bo.AttendsBO;
import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.bo.QueryAttendsBO;
import cn.gson.oasys.model.entity.StatusEntity;
import cn.gson.oasys.model.entity.TypeEntity;
import cn.gson.oasys.model.entity.UserEntity;
import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import freemarker.template.utility.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
        List<AttendsPO> list = attendsPOMapper.selectByExample(attendsPOExample);
        PageInfo pageInfo = new PageInfo(list);
        pageBO.setTotalCount(pageInfo.getTotal());
        log.info("total={}, pageInfo={},list={}", pageInfo.getTotal(), pageInfo, list);
        return list;
    }
    //
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


}
