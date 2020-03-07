package cn.gson.oasys.serviceV2.deptV2;

import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.serviceV2.planV2.PlanServiceV2;
import cn.gson.oasys.mappers.DeptPOMapper;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.po.*;

import cn.gson.oasys.vo.deptVO2.DeptVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DeptPOServiceV2 {
    @Resource
    private DeptPOMapper deptPOMapper;
    @Resource
    private PositionPOMapper positionPOMapper;
    @Resource
    private UserPOMapper userPOMapper;
    @Resource
    private UserPOServiceV2 userPOServiceV2;
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

    /**
     * @param oldDeptVO
     * @return
     */
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


    /**
     * 根据部门ID删除部门信息
     *
     * @param deleteDeptId 部门ID
     */
    public void deleteDeptPOByDeptId(Long deleteDeptId) {
        deptPOMapper.deleteByPrimaryKey(deleteDeptId);
    }


    /**
     * @param positionPOList
     * @param deleteDeptId
     */
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
     * 根据部门名模糊找部门信息（获取其中的IDS）
     *
     * @param selectDeptName
     * @return
     */
    public List<Long> getDeptPOIdsByDeptNameLike(String selectDeptName) {
        DeptPOExample deptPOExample = new DeptPOExample();
        deptPOExample.createCriteria().andDeptNameLike("%" + selectDeptName + "%");
        List<DeptPO> deptPOList = deptPOMapper.selectByExample(deptPOExample);
        List<Long> deptIds = new ArrayList<>();
        if (deptPOList.size() > 0) {
            for (DeptPO deptPO : deptPOList) {
                deptIds.add(deptPO.getDeptId());
            }
        }
        return deptIds;
    }
}

