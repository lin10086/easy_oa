package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.DeptFactory;
import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.po.DeptPO;

import cn.gson.oasys.model.po.DeptPOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class DeptServiceV2 {
    @Resource
    DeptPOMapper deptPOMapper;

    //通过部门ID查找部门信息,并返回本身的部门
    public Dept getDeptbyDeptId(Long deptId) {
        DeptPO deptPO = deptPOMapper.selectByPrimaryKey(deptId);
        Dept dept = DeptFactory.create(deptPO);
        return dept;
    }

    //获取所有的部门信息（部门列表）
    public List<Dept> getDeptList() {
        DeptPOExample deptPOExample = new DeptPOExample();
        List<DeptPO> deptPOList = deptPOMapper.selectByExample(deptPOExample);
        List<Dept> deptList = DeptFactory.create(deptPOList);
        return deptList;
    }

    //  更新或插入部门信息
    public Dept updateDept(Dept dept) {
        DeptPO deptPO = new DeptPO();
        deptPO.setDeptId(dept.getDeptId());
        deptPO.setDeptName(dept.getDeptName());
        deptPO.setDeptTel(dept.getDeptTel());
        deptPO.setDeptFax(dept.getDeptFax());
        deptPO.setEmail(dept.getEmail());
        deptPO.setDeptAddr(dept.getDeptAddr());
        if (dept.getDeptId() != null) {
            deptPOMapper.updateByPrimaryKeySelective(deptPO);
        } else {
            deptPOMapper.insert(deptPO);
        }
        Dept dept1 = DeptFactory.create(deptPO);
        return dept1;
    }

}

