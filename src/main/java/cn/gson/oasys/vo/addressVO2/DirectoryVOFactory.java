package cn.gson.oasys.vo.addressVO2;

import cn.gson.oasys.model.po.DirectorPO;
import cn.gson.oasys.model.po.DirectorUsersPO;

import java.util.ArrayList;
import java.util.List;

public class DirectoryVOFactory {
    public static DirectorVO createDirectoryVOByDirectoryPO(DirectorPO directorPO) {
        DirectorVO directorVO = new DirectorVO();
        directorVO.setDirectorId(directorPO.getDirectorId());
        directorVO.setAddress(directorPO.getAddress());
        directorVO.setCompanyName(directorPO.getCompanyname());
        directorVO.setCompanyNumber(directorPO.getCompanyNumber());
        directorVO.setEmail(directorPO.getEmail());
        directorVO.setPinyin(directorPO.getPinyin());
        directorVO.setRemark(directorPO.getRemark());
        directorVO.setSex(directorPO.getSex());
        directorVO.setPhoneNumber(directorPO.getPhoneNumber());
        directorVO.setUserName(directorPO.getUserName());
        if (directorPO.getImagePath() != null) {
            directorVO.setAttachment(directorPO.getImagePath().longValue());
        } else {
            directorVO.setAttachment(null);
        }
        return directorVO;
    }

    public static List<DirectorVO> createDirectoryVOListByDirectoryPOList(List<DirectorPO> directorPOList) {
        List<DirectorVO> directorVOList = new ArrayList<>();
        for (DirectorPO directorPO : directorPOList) {
            directorVOList.add(DirectoryVOFactory.createDirectoryVOByDirectoryPO(directorPO));
        }
        return directorVOList;
    }

}
