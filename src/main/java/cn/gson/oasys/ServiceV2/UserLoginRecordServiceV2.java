package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.mappers.UserLoginRecordPOMapper;
import cn.gson.oasys.model.po.UserLoginRecordPO;
import cn.gson.oasys.model.po.UserLoginRecordPOExample;
import cn.gson.oasys.model.po.UserPO;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserLoginRecordServiceV2 {

    @Resource
    private UserLoginRecordPOMapper userLoginRecordPOMapper;

    //用户管理》在线用户列表（根据时间降序）
    public List<UserLoginRecordPO> userLoginPage(int page, Long userid, String time) {

        PageHelper.startPage(page, 15);
        UserLoginRecordPOExample userLoginRecordPOExample = new UserLoginRecordPOExample();
        userLoginRecordPOExample.createCriteria().andUserIdEqualTo(userid);
        userLoginRecordPOExample.setOrderByClause("login_time DESC");
        List<UserLoginRecordPO> userLoginRecordPOList = userLoginRecordPOMapper.selectByExample(userLoginRecordPOExample);

        return userLoginRecordPOList;

    }

    public void insertUserLoginRecord(String ip, String info, Date date, Long userPOId){
        UserLoginRecordPO userLoginRecordPO = new UserLoginRecordPO();
        userLoginRecordPO.setBrowser(info);
        userLoginRecordPO.setIpAddr(ip);
        userLoginRecordPO.setLoginTime(date);
        userLoginRecordPO.setUserId(userPOId);
        userLoginRecordPOMapper.insertSelective(userLoginRecordPO);

    }
}
