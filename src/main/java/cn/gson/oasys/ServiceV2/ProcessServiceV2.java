package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.SubjectFactory;
import cn.gson.oasys.factory.UserFactory;
import cn.gson.oasys.mappers.SubjectPOMapper;
import cn.gson.oasys.model.entity.process.Subject;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.DeptVO;
import cn.gson.oasys.vo.PositionVO;
import cn.gson.oasys.vo.TypeVO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.factoryvo.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ProcessServiceV2 {

    @Resource
    private SubjectPOMapper subjectPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private DeptServiceV2 deptServiceV2;
    @Resource
    private PositionServiceV2 positionServiceV2;

    //根据parent_id查找费用科目列表
    public List<SubjectPO> getSubjectByParentId(Long parentId) {
        SubjectPOExample subjectPOExample = new SubjectPOExample();
        subjectPOExample.createCriteria().andParentIdEqualTo(parentId);
        List<SubjectPO> subjectPOList = subjectPOMapper.selectByExample(subjectPOExample);
        return subjectPOList;
    }

    //根据parent_id查找费用科目列表
    public List<SubjectPO> getSubjectByParentIdNot(Long parentId) {
        SubjectPOExample subjectPOExample = new SubjectPOExample();
        subjectPOExample.createCriteria().andParentIdNotEqualTo(parentId);
        List<SubjectPO> subjectPOList = subjectPOMapper.selectByExample(subjectPOExample);
        return subjectPOList;
    }


    //    	 公用
    public void publicX6(Model model, Long userId, int page1, int size) {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        PageHelper.startPage(page1, size);
        List<UserPO> userPOList = userServiceV2.getUserAll();
        PageInfo page = new PageInfo(userPOList);

        List<UserVO> userVOList = UserFactoryVO.createUserVOList(userPOList);

        Map<Long, DeptPO> longDeptPOMap = userServiceV2.userIdAndDeptPO(userPOList);
        Map<Long, PositionPO> longPositionPOMap = userServiceV2.userIdAndPositionPO(userPOList);
        Map<Long, RolePO> longRolePOMap = userServiceV2.userIdAndRolePO(userPOList);
        for (UserVO userVO : userVOList) {
            userVO.setDeptVO(DeptFactoryVO.createDeptVO(longDeptPOMap.get(userVO.getUserId())));
            userVO.setPositionVO(PositionFactoryVO.createPositionVO(longPositionPOMap.get(userVO.getUserId())));
            userVO.setRoleVO(RoleFactoryVO.createRoleVO(longRolePOMap.get(userVO.getUserId())));
        }
        List<TypePO> typePOList = typeServiceV2.getSystemTypeListByTypeModel("aoa_process_list");
        List<TypeVO> typeVOList = TypeFactoryVO.createTypeVOList(typePOList);

        List<DeptPO> deptPOList = deptServiceV2.getDeptPOList();
        List<DeptVO>deptVOList = DeptFactoryVO.createDeptVOList(deptPOList);

        List<PositionPO> positionPOList = positionServiceV2.getPositionList();
        List<PositionVO>positionVOList = PositionFactoryVO.createPositionVOList(positionPOList);

        model.addAttribute("page", page);
        model.addAttribute("emplist", userVOList);
        model.addAttribute("deptlist", deptVOList);
        model.addAttribute("poslist", positionVOList);
        model.addAttribute("url", "names");
        model.addAttribute("username", userPO.getUserName());
        model.addAttribute("harrylist", typeVOList);
    }
}
