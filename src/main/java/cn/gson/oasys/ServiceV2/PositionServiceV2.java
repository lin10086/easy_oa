package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.PositionFactory;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.PositionPOExample;
import cn.gson.oasys.vo.PositionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class PositionServiceV2 {
    @Resource
    PositionPOMapper positionPOMapper;

    /**
     * 获取所有的职位列表
     *
     * @return
     */
    public List<PositionPO> getPositionList() {
        PositionPOExample positionPOExample = new PositionPOExample();
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        return positionPOList;
    }

    //根据部门ID获取职位信息
    public List<PositionPO> getPositionPOByDeptId(Long deptId) {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andDeptidEqualTo(deptId);
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        return positionPOList;
    }

    //根据职位ID获取职位信息
    public PositionPO getPositionByPositionId(Long positionId) {
        PositionPO positionPO = positionPOMapper.selectByPrimaryKey(positionId);
        return positionPO;
    }

    //职位名name不是以经理结尾的（返回职位列表）
    public List<PositionPO> getPositionPOListByDeptIdAndNameNotLike() {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andNameNotLike("%经理");
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        return positionPOList;
    }

    // 根据部门ID（1L)和职位名name不是以经理结尾的（返回职位列表）
    public List<PositionPO> getPositionPOListByDeptIdAndNameLike(Long deptId) {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andNameNotLike("%经理").andDeptidEqualTo(deptId);
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        return positionPOList;
    }

    //插入或更新一个职位
    public Integer insertOrUpdatePositionPO(PositionPO positionPO) {
        Integer rows = null;
        if (positionPO.getPositionId() == null) {
            rows = positionPOMapper.insert(positionPO);
        } else {
            rows = positionPOMapper.updateByPrimaryKeySelective(positionPO);
        }
        return rows;
    }


}
