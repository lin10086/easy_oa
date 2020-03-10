package cn.gson.oasys.serviceV2.userV2;

import cn.gson.oasys.modelV2.po.UserPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceV2 {
    @Resource
    private UserPOServiceV2 userPOServiceV2;

    /**
     * 根据用户列表获取用户Id
     *
     * @param userPOList 用户列表
     * @return
     */
    public List<Long> getUserIdsByUserPOList(List<UserPO> userPOList) {
        List<Long> userIds = new ArrayList<>();
        for (UserPO userPO : userPOList) {
            userIds.add(userPO.getUserId());
        }
        if (userIds.size() == 0) {
            userIds.add(0L);
        }
        return userIds;
    }
}
