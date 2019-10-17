package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.UserVO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class UserFactoryVO {

    public static UserVO createUserVO(UserPO userPO) {
        UserVO userVO = new UserVO();
        userVO.setUserName(userPO.getUserName());
        userVO.setUserId(userPO.getUserId());
        userVO.setUserEmail(userPO.getEamil());
        userVO.setBank(userPO.getBank());
        userVO.setPassword(userPO.getPassword());
        userVO.setUserAddress(userPO.getAddress());
        userVO.setUserIdCard(userPO.getUserIdcard());
        userVO.setRealName(userPO.getRealName());
        userVO.setFatherId(userPO.getFatherId());
        userVO.setUserSchool(userPO.getUserSchool());
        userVO.setThemeSkin(userPO.getThemeSkin());
        userVO.setUserEdu(userPO.getUserEdu());
        userVO.setUserTel(userPO.getUserTel());
        userVO.setBirth(userPO.getBirth());
        userVO.setImgPath(userPO.getImgPath());
        userVO.setBirth(new Timestamp(userPO.getBirth().getTime()));
        userVO.setIsLock(userPO.getIsLock());
        userVO.setPinyin(userPO.getPinyin());
        userVO.setSex(userPO.getSex());
        userVO.setUserSign(userPO.getUserSign());
        userVO.setHireTime(userPO.getHireTime());
        userVO.setHoliday(userPO.getHoliday());
        userVO.setSalary((userPO.getSalary().intValue()) + "");
        return userVO;
    }

    public static List<UserVO> createUserVOList(List<UserPO> userPOList) {
        List<UserVO> userVOList = new ArrayList<>();
        for (UserPO userPO : userPOList) {
            userVOList.add(UserFactoryVO.createUserVO(userPO));
        }
        return userVOList;
    }


}

