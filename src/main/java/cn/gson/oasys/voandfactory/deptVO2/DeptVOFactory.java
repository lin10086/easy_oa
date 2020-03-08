package cn.gson.oasys.voandfactory.deptVO2;

import cn.gson.oasys.modelV2.po.DeptPO;

import java.util.ArrayList;
import java.util.List;

public class DeptVOFactory {

    public static DeptVO createDeptVOByDeptPO(DeptPO deptPO) {
        DeptVO deptVO = new DeptVO();
        deptVO.setDeptId(deptPO.getDeptId());
        deptVO.setDeptManager(deptPO.getDeptmanager());
        deptVO.setDeptAddress(deptPO.getDeptAddr());
        deptVO.setDeptFax(deptPO.getDeptFax());
        deptVO.setDeptName(deptPO.getDeptName());
        deptVO.setDeptTel(deptPO.getDeptTel());
        deptVO.setDeptEmail(deptPO.getEmail());
        deptVO.setStartTime(deptPO.getStartTime());
        deptVO.setEndTime(deptPO.getEndTime());
        return deptVO;
    }

    public static List<DeptVO> createDeptVOListByDeptPOList(List<DeptPO> deptPOList) {
        List<DeptVO> deptVOList = new ArrayList<>();
        for (DeptPO deptPO : deptPOList) {
            DeptVO deptVO = DeptVOFactory.createDeptVOByDeptPO(deptPO);
            deptVOList.add(deptVO);
        }
        return deptVOList;
    }
}
