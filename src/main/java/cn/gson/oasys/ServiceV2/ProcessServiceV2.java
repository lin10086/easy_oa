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
import cn.gson.oasys.model.po.SubjectPO;
import cn.gson.oasys.model.po.SubjectPOExample;
import cn.gson.oasys.model.po.UserPO;
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
    public List<Subject> getSubjectByParentId(Long parentId) {
        SubjectPOExample subjectPOExample = new SubjectPOExample();
        subjectPOExample.createCriteria().andParentIdEqualTo(parentId);
        List<SubjectPO> subjectPOList = subjectPOMapper.selectByExample(subjectPOExample);
        List<Subject> subjectList = SubjectFactory.createSubjectList(subjectPOList);
        return subjectList;
    }

    //根据parent_id查找费用科目列表
    public List<Subject> getSubjectByParentIdNot(Long parentId) {
        SubjectPOExample subjectPOExample = new SubjectPOExample();
        subjectPOExample.createCriteria().andParentIdNotEqualTo(parentId);
        List<SubjectPO> subjectPOList = subjectPOMapper.selectByExample(subjectPOExample);
        List<Subject> subjectList = SubjectFactory.createSubjectList(subjectPOList);
        return subjectList;
    }


    //    	 公用
    public void index6(Model model, Long userId, int page1, int size) {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        PageHelper.startPage(page1, size);
        List<UserPO> userPOList = userServiceV2.getUserAll();
        PageInfo page = new PageInfo(userPOList);

        List<User> userList = UserFactory.create(userPOList);
        Map<Long, Dept> longDeptMap = userServiceV2.userIdAndDept(userPOList);
        Map<Long,Position>longPositionMap = userServiceV2.userIdAndPosition(userPOList);
        Map<Long, Role>longRoleMap =userServiceV2.userIdAndRole(userPOList);
        for (User user : userList) {
            user.setDept(longDeptMap.get(user.getUserId()));
            user.setPosition(longPositionMap.get(user.getUserId()));
            user.setRole(longRoleMap.get(user.getUserId()));
        }
        List<SystemTypeList> systemTypeLists = typeServiceV2.getSystemTypeListByTypeModel("aoa_process_list");
//        List<Dept> deptList = deptServiceV2.getDeptList();
//        List<Position> positionList = positionServiceV2.getPositionList();
        model.addAttribute("page",page);
        model.addAttribute("emplist", userList);
//        model.addAttribute("deptlist", deptList);
//        model.addAttribute("poslist", positionList);
        model.addAttribute("url", "names");
        model.addAttribute("username", userPO.getUserName());
        model.addAttribute("harrylist", systemTypeLists);
    }
}
