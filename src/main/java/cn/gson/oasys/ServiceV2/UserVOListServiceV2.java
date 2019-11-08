package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.RolePO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.factoryvo.DeptFactoryVO;
import cn.gson.oasys.vo.factoryvo.PositionFactoryVO;
import cn.gson.oasys.vo.factoryvo.RoleFactoryVO;
import cn.gson.oasys.vo.factoryvo.UserFactoryVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserVOListServiceV2 {
    @Resource
    private UserServiceV2 userServiceV2;

    /**
     * 补全所有用户的部门，职位，角色信息
     *
     * @return
     */
    public List<UserVO> setUserVOList() {
        List<UserPO> userPOList = userServiceV2.getUserAll();//获取所有用户
        List<UserVO> userVOList = UserFactoryVO.createUserVOList(userPOList);
        //补全用户里面的信息（部门，职位，角色）
        Map<Long, DeptPO> longDeptPOMap = userServiceV2.userPOListIdAndDeptPO(userPOList);
        Map<Long, PositionPO> longPositionPOMap = userServiceV2.userPOListIdAndPositionPO(userPOList);
        Map<Long, RolePO> longRolePOMap = userServiceV2.userPOListIdAndRolePO(userPOList);
        for (UserVO userVO : userVOList) {
            userVO.setDeptVO(DeptFactoryVO.createDeptVO(longDeptPOMap.get(userVO.getUserId())));
            userVO.setPositionVO(PositionFactoryVO.createPositionVO(longPositionPOMap.get(userVO.getUserId())));
            userVO.setRoleVO(RoleFactoryVO.createRoleVO(longRolePOMap.get(userVO.getUserId())));
        }
        return userVOList;
    }

}
