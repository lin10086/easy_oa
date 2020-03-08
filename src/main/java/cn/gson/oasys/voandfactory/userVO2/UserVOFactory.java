package cn.gson.oasys.voandfactory.userVO2;

import cn.gson.oasys.modelV2.po.UserPO;

import java.util.ArrayList;
import java.util.List;

public class UserVOFactory {

    public static UserVO createUserVOByUserPO(UserPO userPO) {
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
        userVO.setBirth(userPO.getBirth());
        userVO.setIsLock(userPO.getIsLock());
        userVO.setPinyin(userPO.getPinyin());
        userVO.setSex(userPO.getSex());
        userVO.setUserSign(userPO.getUserSign());
        userVO.setHireTime(userPO.getHireTime());
        userVO.setHoliday(userPO.getHoliday());
        userVO.setSalary((userPO.getSalary().intValue()) + "");
        return userVO;
    }

    public static List<UserVO> createUserVOListByUserPOList(List<UserPO> userPOList) {
        List<UserVO> userVOList = new ArrayList<>();
        for (UserPO userPO : userPOList) {
            userVOList.add(UserVOFactory.createUserVOByUserPO(userPO));
        }
        return userVOList;
    }

    //把VO转换为PO
    public static UserPO createUserPOByUserVO(UserVO userVO) {
        UserPO userPO = new UserPO();
        userPO.setUserIdcard(userVO.getUserIdCard());
        userPO.setUserSchool(userVO.getUserSchool());
        userPO.setUserTel(userVO.getUserTel());
        userPO.setPassword(userVO.getPassword());
        userPO.setPinyin(userVO.getPinyin());
        userPO.setUserName(userVO.getUserName());
        userPO.setUserId(userVO.getUserId());
        userPO.setEamil(userVO.getUserEmail());
        userPO.setBank(userVO.getBank());
        userPO.setPassword(userVO.getPassword());
        userPO.setAddress(userVO.getUserAddress());
        userPO.setRealName(userVO.getRealName());
        userPO.setFatherId(userVO.getFatherId());
        userPO.setThemeSkin(userVO.getThemeSkin());
        userPO.setUserEdu(userVO.getUserEdu());
        userPO.setUserTel(userVO.getUserTel());
        userPO.setBirth(userVO.getBirth());
        userPO.setImgPath(userVO.getImgPath());
        userPO.setBirth(userVO.getBirth());
        userPO.setIsLock(userVO.getIsLock());
        userPO.setPinyin(userVO.getPinyin());
        userPO.setSex(userVO.getSex());
        userPO.setUserSign(userVO.getUserSign());
        userPO.setHireTime(userVO.getHireTime());
        userPO.setHoliday(userVO.getHoliday());
        userPO.setSalary(Float.valueOf(userVO.getSalary()));
        userPO.setSuperman(userVO.getSuperman() == false ? 0 : 1);
        return userPO;
    }

}

