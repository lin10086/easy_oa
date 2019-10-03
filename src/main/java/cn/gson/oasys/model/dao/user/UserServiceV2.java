package cn.gson.oasys.model.dao.user;

import cn.gson.oasys.factory.DeptFactory;
import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.model.po.UserPOExample;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UserServiceV2 {
    @Resource
    UserPOMapper userPOMapper;
    @Resource
    DeptPOMapper deptPOMapper;

    //找到该管理员下面的所有用户并且分页
    public List<UserPO> findUserAndPageByFatherId(int page, long fatherId) {

        UserPOExample userPOExample = new UserPOExample();
        userPOExample.createCriteria().andFatherIdEqualTo(fatherId);


        PageHelper.startPage(page, 10);
//查询到的下属用户,已经分页
        List<UserPO> userPOList = userPOMapper.selectByExample(userPOExample);

//        List<User> userList = UserFactory.create(userPOList);
//        PageInfo pageInfo = new PageInfo(userList);
//        log.info("total={}, pageInfo={},list={}", pageInfo.getTotal(), pageInfo, userList);
        return userPOList;
    }

    //把用户的ID和用户的部门对应起来放到map里面
    public Map<Long, Dept> userIdAndDept(List<UserPO>userPOList) {
        //获取用户们的ID

        //建立Map集合用于把用户ID和用户的部门对应起来
        Map<Long, Dept> map = new HashMap<>();
        //遍历自己定义的用户，从中获取用户所在的部门ID
        for (UserPO userPO:userPOList) {
            //根据用户里面的部门ID查询用户的部门信息
            DeptPO deptPO = deptPOMapper.selectByPrimaryKey(userPO.getDeptId());
            //把自己定义的用户部门的信息转换成人家的用户部门信息
            Dept dept = DeptFactory.create(deptPO);
            //把用户ID和部门对应起来
            map.put(userPO.getUserId(), dept);
        }
        return map;
    }

}
