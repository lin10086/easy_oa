package cn.gson.oasys.factory;

import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.po.DeptPO;

import java.util.ArrayList;
import java.util.List;

public class DeptFactory {
    //把自己的部门DeptPO转换成本身的部门Dept
    public static Dept create(DeptPO deptPO){
        Dept dept = new Dept();

        dept.setDeptId(deptPO.getDeptId());
        dept.setDeptmanager(deptPO.getDeptmanager());
        dept.setDeptAddr(deptPO.getDeptAddr());
        dept.setDeptFax(deptPO.getDeptFax());
        dept.setDeptName(deptPO.getDeptName());
        dept.setDeptTel(deptPO.getDeptTel());
        dept.setEmail(deptPO.getEmail());
        dept.setStartTime(deptPO.getStartTime());
        dept.setEndTime(deptPO.getEndTime());
        return dept;
    }

    public static List<Dept> create(List<DeptPO>deptPOList){
        List<Dept>deptList = new ArrayList<>();
        for(DeptPO deptPO : deptPOList){
            deptList.add(DeptFactory.create(deptPO));
        }
        return deptList;
    }

}
