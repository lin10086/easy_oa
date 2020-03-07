package cn.gson.oasys.vo.addressVO2;

import cn.gson.oasys.model.po.DirectorUsersPO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DirectorUserVOFactory {

    public static DirectorUserVO createDirectorUserVOByDirectorUserPO(DirectorUsersPO directorUsersPO) {
        DirectorUserVO directorUserVO = new DirectorUserVO();
        directorUserVO.setDirectorUserId(directorUsersPO.getDirectorUsersId());
        directorUserVO.setCatalogName(directorUsersPO.getCatelogName());
        directorUserVO.setHandle(directorUsersPO.getIsHandle() == 0 ? false : true);
        directorUserVO.setShareTime(new Timestamp(directorUsersPO.getSharetime().getTime()));
        return directorUserVO;
    }

    public static List<DirectorUserVO> createDirectorUserVOSByDirectorUserPOS(List<DirectorUsersPO> directorUsersPOS) {
        List<DirectorUserVO> directorUserVOS = new ArrayList<>();
        for (DirectorUsersPO directorUsersPO : directorUsersPOS) {
            directorUserVOS.add(DirectorUserVOFactory.createDirectorUserVOByDirectorUserPO(directorUsersPO));
        }
        return directorUserVOS;
    }

}
