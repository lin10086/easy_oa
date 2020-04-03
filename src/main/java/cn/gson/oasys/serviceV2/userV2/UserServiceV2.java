package cn.gson.oasys.serviceV2.userV2;

import cn.gson.oasys.modelV2.bo.PageInformation;
import cn.gson.oasys.modelV2.po.DeptPO;
import cn.gson.oasys.modelV2.po.PositionPO;
import cn.gson.oasys.modelV2.po.RolePO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.voandfactory.deptVO2.DeptVOFactory;
import cn.gson.oasys.voandfactory.positionVO2.PositionVOFactory;
import cn.gson.oasys.voandfactory.roleVO2.RoleVOFactory;
import cn.gson.oasys.voandfactory.userVO2.UserVO;
import cn.gson.oasys.voandfactory.userVO2.UserVOFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceV2 {
    @Resource
    private UserPOServiceV2 userPOServiceV2;
    @Resource
    private PageInformation pageInformation;

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


    /**
     * 补全所有用户的部门，职位，角色信息(即通讯录)
     *
     * @return
     */
    public void setUserVOListAllAndPage(Model model, int page, int size) {
        List<UserPO> userPOList = userPOServiceV2.getUserAll();//获取所有用户
        List<UserPO> subUserPOList = pageInformation.getUserPOListPage(page, size, userPOList, model);//对用户进行分页
        List<UserVO> userVOList = UserVOFactory.createUserVOListByUserPOList(subUserPOList);
        //补全用户里面的信息（部门，职位，角色）
        Map<Long, DeptPO> longDeptPOMap = userPOServiceV2.userPOListIdAndDeptPO(subUserPOList);
        Map<Long, PositionPO> longPositionPOMap = userPOServiceV2.userPOListIdAndPositionPO(subUserPOList);
        Map<Long, RolePO> longRolePOMap = userPOServiceV2.userPOListIdAndRolePO(subUserPOList);
        for (UserVO userVO : userVOList) {
            userVO.setDeptVO(DeptVOFactory.createDeptVOByDeptPO(longDeptPOMap.get(userVO.getUserId())));
            userVO.setPositionVO(PositionVOFactory.createPositionVOByPositionPO(longPositionPOMap.get(userVO.getUserId())));
            userVO.setRoleVO(RoleVOFactory.createRoleVOByRolePO(longRolePOMap.get(userVO.getUserId())));
        }
        model.addAttribute("userVOList", userVOList);//用户信息
    }

}
