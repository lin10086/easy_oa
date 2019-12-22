package cn.gson.oasys.ServiceV2.userV2;

import cn.gson.oasys.mappers.UserLogPOMapper;
import cn.gson.oasys.model.entity.user.LoginRecord;
import cn.gson.oasys.model.entity.user.UserLog;
import cn.gson.oasys.model.po.UserLogPO;
import cn.gson.oasys.model.po.UserLogPOExample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@Service
public class UserLogServiceV2 {
    @Resource
    private UserLogPOMapper userLogPOMapper;

    /**
     * 根据用户的登陆信息找用户的登陆信息 并根据登录时间降序(取前10条）
     *
     * @param userId 用户ID
     * @return
     */
    public List<UserLogPO> getUserLogByUserIdAndLogTimeDESCFrontTen(Long userId) {
        UserLogPOExample userLogPOExample = new UserLogPOExample();
        userLogPOExample.setOrderByClause("log_time DESC");
        userLogPOExample.createCriteria().andUserIdEqualTo(userId);
        List<UserLogPO> userLogPOList = userLogPOMapper.selectByExample(userLogPOExample);
        for (UserLogPO userLogPO : userLogPOList) {
            userLogPO.setLogTime(new Timestamp(userLogPO.getLogTime().getTime()));
        }
        int end;
        if (userLogPOList.size() > 10) {
            end = 10;
        } else {
            end = userLogPOList.size();
        }
        List<UserLogPO> subUserLogPOList = userLogPOList.subList(0, end);
        return subUserLogPOList;
    }

    public List<UserLogPO> userLogPOListByBaseKeyAndUserIdAndTime(String baseKey, Long userId, Object time) {
        if (!StringUtils.isEmpty(baseKey)) {//模糊
            //模糊查询
//            @Query("from UserLog u where u.user.userId=?1 and (u.title like %?2% or DATE_format(u.logTime,'%Y-%m-%d ') like %?2% or u.ipAddr like %?2%) order by u.logTime DESC")
//            Page<UserLog> findbasekey(long userid,String baseKey,Pageable pa);

            UserLogPOExample userLogPOExample = new UserLogPOExample();
            userLogPOExample.setOrderByClause("log_time DESC");
            userLogPOExample.createCriteria().andUserIdEqualTo(userId).andTitleLike(baseKey);
            UserLogPOExample.Criteria criteria2 = userLogPOExample.createCriteria().andUserIdEqualTo(userId).andIpAddrLike(baseKey);
            userLogPOExample.or(criteria2);
            List<UserLogPO> userLogPOList = userLogPOMapper.selectByExample(userLogPOExample);
            return userLogPOList;
        }//0为降序 1为升序
        if (!StringUtils.isEmpty(time)) {
            if (time.toString().equals("0")) {
                UserLogPOExample userLogPOExample = new UserLogPOExample();
                userLogPOExample.setOrderByClause("log_time DESC");
                userLogPOExample.createCriteria().andUserIdEqualTo(userId);
                List<UserLogPO> userLogPOList = userLogPOMapper.selectByExample(userLogPOExample);
                return userLogPOList;
            }
            if (time.toString().equals("1")) {
                UserLogPOExample userLogPOExample = new UserLogPOExample();
                userLogPOExample.setOrderByClause("log_time ASC");
                userLogPOExample.createCriteria().andUserIdEqualTo(userId);
                List<UserLogPO> userLogPOList = userLogPOMapper.selectByExample(userLogPOExample);
                return userLogPOList;
            }
        } else {
            UserLogPOExample userLogPOExample = new UserLogPOExample();
            userLogPOExample.setOrderByClause("log_time DESC");
            userLogPOExample.createCriteria().andUserIdEqualTo(userId);
            List<UserLogPO> userLogPOList = userLogPOMapper.selectByExample(userLogPOExample);
            return userLogPOList;
        }
        return null;

    }

}
