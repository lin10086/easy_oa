package cn.gson.oasys.factory;

import cn.gson.oasys.model.entity.user.LoginRecord;
import cn.gson.oasys.model.po.UserLoginRecordPO;
import cn.gson.oasys.model.po.UserPO;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserLoginRecordFactory {

    //把用户登录记录表转换为原来的用户记录表
    public static LoginRecord create(UserLoginRecordPO userLoginRecordPO, UserPO userPO){
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setUser(UserFactory.create(userPO));
        loginRecord.setId(userLoginRecordPO.getUserId());
        loginRecord.setIpAddr(userLoginRecordPO.getIpAddr());
        loginRecord.setBrowser(userLoginRecordPO.getBrowser());
        //时间格式问题
        loginRecord.setLoginTime(new Timestamp(userLoginRecordPO.getLoginTime().getTime()));
//        loginRecord.setLoginTime(userLoginRecordPO.getLoginTime());
        loginRecord.setSessionId(userLoginRecordPO.getSessionId());
        return loginRecord;
    }
    public static List<LoginRecord>create(List<UserLoginRecordPO>userLoginRecordPOList,List<UserPO>userPOList){
        List<LoginRecord>loginRecordList = new ArrayList<>();
        for (UserLoginRecordPO userLoginRecordPO : userLoginRecordPOList){
            for(UserPO userPO : userPOList){
                if(userLoginRecordPO.getUserId()==userPO.getUserId()){
                    loginRecordList.add(UserLoginRecordFactory.create(userLoginRecordPO,userPO));
                    break;
                }

            }
        }
        return loginRecordList;
    }
}
