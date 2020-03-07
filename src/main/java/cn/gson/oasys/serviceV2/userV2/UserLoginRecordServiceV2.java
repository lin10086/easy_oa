package cn.gson.oasys.serviceV2.userV2;

import cn.gson.oasys.mappers.UserLoginRecordPOMapper;
import cn.gson.oasys.model.po.UserLoginRecordPO;
import cn.gson.oasys.model.po.UserLoginRecordPOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 处理登录记录表的业务
 */
@Service
@Slf4j
public class UserLoginRecordServiceV2 {

    @Resource
    private UserLoginRecordPOMapper userLoginRecordPOMapper;

//    //模糊查询
//    @Query("from LoginRecord u where u.user.userId=?1 and ( DATE_format(u.loginTime,'%Y-%m-%d ') like %?2% or u.ipAddr like %?2%) order by u.loginTime DESC")
//    Page<LoginRecord> findbasekey(long userid, String baseKey, Pageable pa);

    /**
     * 用户管理》在线用户列表（根据时间降序）
     *
     * @param baseKey 模糊字
     * @param userId  用户ID
     * @param time
     * @return
     */
    public List<UserLoginRecordPO> getUserLoginRecordPOSByUserIdAndLoginTimeSortAndBaseKey(String baseKey, Long userId, String time) {
        if (!StringUtils.isEmpty(baseKey)) { //模糊
            UserLoginRecordPOExample userLoginRecordPOExample = new UserLoginRecordPOExample();
            userLoginRecordPOExample.createCriteria().andUserIdEqualTo(userId).andIpAddrLike(baseKey);
            userLoginRecordPOExample.setOrderByClause("login_time DESC");
            List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordPOMapper.selectByExample(userLoginRecordPOExample);
            return userLoginRecordPOList;
        }//0为降序 1为升序
        if (!StringUtils.isEmpty(time)) {
            if (time.equals("0")) {
                UserLoginRecordPOExample userLoginRecordPOExample = new UserLoginRecordPOExample();
                userLoginRecordPOExample.createCriteria().andUserIdEqualTo(userId);
                userLoginRecordPOExample.setOrderByClause("login_time DESC");
                List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordPOMapper.selectByExample(userLoginRecordPOExample);
                return userLoginRecordPOList;
            }
            if (time.equals("1")) {
                UserLoginRecordPOExample userLoginRecordPOExample = new UserLoginRecordPOExample();
                userLoginRecordPOExample.createCriteria().andUserIdEqualTo(userId);
                userLoginRecordPOExample.setOrderByClause("login_time ASC");
                List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordPOMapper.selectByExample(userLoginRecordPOExample);
                return userLoginRecordPOList;
            }
        } else {
            UserLoginRecordPOExample userLoginRecordPOExample = new UserLoginRecordPOExample();
            userLoginRecordPOExample.createCriteria().andUserIdEqualTo(userId);
            userLoginRecordPOExample.setOrderByClause("login_time DESC");
            List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordPOMapper.selectByExample(userLoginRecordPOExample);
            return userLoginRecordPOList;
        }
        return null;

    }


    /**
     * 插入一条用户登录记录
     *
     * @param ip       IP地址
     * @param info     用户使用的浏览器
     * @param date     登录日期
     * @param userPOId 用户ID
     */
    public void insertUserLoginRecord(String ip, String info, Date date, Long userPOId) {
        UserLoginRecordPO userLoginRecordPO = new UserLoginRecordPO();
        userLoginRecordPO.setBrowser(info);
        userLoginRecordPO.setIpAddr(ip);
        userLoginRecordPO.setLoginTime(date);
        userLoginRecordPO.setUserId(userPOId);
        userLoginRecordPOMapper.insertSelective(userLoginRecordPO);
    }

    public int getUserLoginRecordPOByLoginTimeLikeCount(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(calendar.getTime());
//        @Query(nativeQuery=true,value="SELECT COUNT(*) FROM aoa_user_login_record WHERE DATE_FORMAT(aoa_user_login_record.login_time,'%Y-%m-%d')=?1")
//        Integer countlog(String date);
        UserLoginRecordPOExample userLoginRecordPOExample = new UserLoginRecordPOExample();
        List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordPOMapper.selectByExample(userLoginRecordPOExample);
        int count = 0;
        for (UserLoginRecordPO userLoginRecordPO : userLoginRecordPOList) {
            String loginDate = sdf.format(userLoginRecordPO.getLoginTime());
            log.info("loginDate={}", loginDate);
            if (date.equals(loginDate)) {
                count++;
            }
        }
        return count;

    }
}
