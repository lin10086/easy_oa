package cn.gson.oasys.ServiceV2.userV2;

import cn.gson.oasys.mappers.UserLogPOMapper;
import cn.gson.oasys.model.po.UserLogPO;
import cn.gson.oasys.model.po.UserLogPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserLogServiceV2 {
    @Resource
    private UserLogPOMapper userLogPOMapper;

    public List<UserLogPO> getUserLogByUserId(Long userId) {
        UserLogPOExample userLogPOExample = new UserLogPOExample();
        userLogPOExample.setOrderByClause("log_time DESC");
        userLogPOExample.createCriteria().andUserIdEqualTo(userId);
        List<UserLogPO> userLogPOList = userLogPOMapper.selectByExample(userLogPOExample);
        return userLogPOList;
    }
}
