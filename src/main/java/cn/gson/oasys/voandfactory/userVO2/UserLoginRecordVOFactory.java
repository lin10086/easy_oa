package cn.gson.oasys.voandfactory.userVO2;

import cn.gson.oasys.modelV2.po.UserLoginRecordPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户登录记录的转化工程
 */
public class UserLoginRecordVOFactory {
    public static UserLoginRecordVO createUserLoginRecordVOBYUserLoginRecordPO(UserLoginRecordPO userLoginRecordPO) {
        UserLoginRecordVO userLoginRecordVO = new UserLoginRecordVO();
        userLoginRecordVO.setId(userLoginRecordPO.getRecordId());
        userLoginRecordVO.setBrowser(userLoginRecordPO.getBrowser());
        userLoginRecordVO.setIpAddr(userLoginRecordPO.getIpAddr());
        userLoginRecordVO.setLoginTime(new Timestamp(userLoginRecordPO.getLoginTime().getTime()));
        userLoginRecordVO.setSessionId(userLoginRecordPO.getSessionId());
        return userLoginRecordVO;
    }

    public static List<UserLoginRecordVO> createUserLoginRecordVOListByUserLoginRecordPOList(List<UserLoginRecordPO> userLoginRecordPOList) {
        List<UserLoginRecordVO> userLoginRecordVOList = new ArrayList<>();
        for (UserLoginRecordPO userLoginRecordPO : userLoginRecordPOList) {
            userLoginRecordVOList.add(UserLoginRecordVOFactory.createUserLoginRecordVOBYUserLoginRecordPO(userLoginRecordPO));
        }
        return userLoginRecordVOList;
    }
}
