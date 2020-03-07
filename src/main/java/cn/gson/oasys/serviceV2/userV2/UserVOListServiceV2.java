package cn.gson.oasys.serviceV2.userV2;

import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.userVO2.UserVO;
import cn.gson.oasys.vo.deptVO2.DeptVOFactory;
import cn.gson.oasys.vo.planVO2.PositionVOFactory;
import cn.gson.oasys.vo.roleVO2.RoleVOFactory;
import cn.gson.oasys.vo.userVO2.UserFactoryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserVOListServiceV2 {
    @Resource
    private UserPOServiceV2 userPOServiceV2;

    /**
     * 补全所有用户的部门，职位，角色信息
     *
     * @return
     */
    public List<UserVO> setUserVOList() {
        List<UserPO> userPOList = userPOServiceV2.getUserAll();//获取所有用户
        List<UserVO> userVOList = UserFactoryVO.createUserVOList(userPOList);
        //补全用户里面的信息（部门，职位，角色）
        Map<Long, DeptPO> longDeptPOMap = userPOServiceV2.userPOListIdAndDeptPO(userPOList);
        Map<Long, PositionPO> longPositionPOMap = userPOServiceV2.userPOListIdAndPositionPO(userPOList);
        Map<Long, RolePO> longRolePOMap = userPOServiceV2.userPOListIdAndRolePO(userPOList);
        for (UserVO userVO : userVOList) {
            userVO.setDeptVO(DeptVOFactory.createDeptVOByDeptPO(longDeptPOMap.get(userVO.getUserId())));
            userVO.setPositionVO(PositionVOFactory.createPositionVOByPositionPO(longPositionPOMap.get(userVO.getUserId())));
            userVO.setRoleVO(RoleVOFactory.createRoleVO(longRolePOMap.get(userVO.getUserId())));
        }
        return userVOList;
    }

}
