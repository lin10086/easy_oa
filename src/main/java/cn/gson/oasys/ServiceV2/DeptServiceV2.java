package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.ServiceV2.planV2.PlanServiceV2;
import cn.gson.oasys.factory.DeptFactory;
import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.po.*;

import cn.gson.oasys.vo.DeptVO;
import cn.gson.oasys.vo.factoryvo.DeptFactoryVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DeptServiceV2 {
    @Resource
    private DeptPOMapper deptPOMapper;
    @Resource
    private PositionPOMapper positionPOMapper;
    @Resource
    private UserPOMapper userPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private PlanServiceV2 planServiceV2;


    /**
     * 获取所有的部门信息（部门列表）
     *
     * @return
     */
    public List<DeptPO> getDeptPOListAll() {
        DeptPOExample deptPOExample = new DeptPOExample();
        List<DeptPO> deptPOList = deptPOMapper.selectByExample(deptPOExample);
        return deptPOList;
    }

    //通过部门ID查找部门信息
    public DeptPO getDeptPOByDeptId(Long deptId) {
        DeptPO deptPO = deptPOMapper.selectByPrimaryKey(deptId);
        return deptPO;
    }


    //  更新或插入部门信息
    public Integer updateOrInsertDept(DeptVO oldDeptVO) {
        DeptPO deptPO = new DeptPO();
        deptPO.setDeptId(oldDeptVO.getDeptId());
        deptPO.setDeptName(oldDeptVO.getDeptName());
        deptPO.setDeptTel(oldDeptVO.getDeptTel());
        deptPO.setDeptFax(oldDeptVO.getDeptFax());
        deptPO.setEmail(oldDeptVO.getDeptEmail());
        deptPO.setDeptAddr(oldDeptVO.getDeptAddress());
        Integer rows;
        if (oldDeptVO.getDeptId() != null) {
            rows = deptPOMapper.updateByPrimaryKeySelective(deptPO);
        } else {
            rows = deptPOMapper.insert(deptPO);
        }
        return rows;
    }

    //根据部门ID删除部门信息
    public void deleteDeptVOByDeptId(List<PositionPO> positionPOList, Long deleteDeptId) {
        for (PositionPO positionPO : positionPOList) {
            positionPOMapper.deleteByPrimaryKey(positionPO.getPositionId());
        }
        deptPOMapper.deleteByPrimaryKey(deleteDeptId);
    }

    //更新部门领导信息
    public void updateDeptManage(Long deptPOId, Long newManageId) {
        DeptPO deptPO = new DeptPO();
        deptPO.setDeptId(deptPOId);
        deptPO.setDeptmanager(newManageId);
        deptPOMapper.updateByPrimaryKeySelective(deptPO);
    }

    /**
     * 根据用户ID找部门名
     *
     * @param userId 用户ID
     * @return
     */
    public String getDeptNameByUserId(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        DeptPO deptPO = deptPOMapper.selectByPrimaryKey(userPO.getDeptId());
        String deptName = deptPO.getDeptName();
        return deptName;
    }

    /**
     * 根据用户ID找部门信息
     *
     * @param userId 用户ID
     * @return 部门信息
     */
    public DeptPO getDeptPOByUserId(Long userId) {
        UserPO userPO = userPOMapper.selectByPrimaryKey(userId);
        DeptPO deptPO = deptPOMapper.selectByPrimaryKey(userPO.getDeptId());
        return deptPO;
    }

    /**
     * 根据部门名找部门id
     *
     * @param selectDeptName
     * @return
     */
    public Long getDeptPOIdByDeptName(String selectDeptName) {
        DeptPOExample deptPOExample = new DeptPOExample();
        deptPOExample.createCriteria().andDeptNameEqualTo(selectDeptName);
        List<DeptPO> deptPOList = deptPOMapper.selectByExample(deptPOExample);
        return deptPOList.get(0).getDeptId();//因为部门名是下拉选选择的所以存在不用判断
    }
}

