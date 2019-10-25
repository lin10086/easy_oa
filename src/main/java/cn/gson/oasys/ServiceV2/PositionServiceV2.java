package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.PositionFactory;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.DeptPO;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.PositionPOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class PositionServiceV2 {
    @Resource
    PositionPOMapper positionPOMapper;

    //获取所有的职位列表
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

    //根据职位ID获取职位信息并转换为本身的职位信息
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

    //插入一个职位
    public Integer insertPosition(Position position) {
        PositionPO positionPO = new PositionPO();
        positionPO.setPositionId(position.getId());
        positionPO.setName(position.getName());
        positionPO.setLevel(position.getLevel());
        positionPO.setDeptid(position.getDeptid());
        positionPO.setDescribtion(position.getDescribtion());
        Integer rows = positionPOMapper.insert(positionPO);
        return rows;
    }

    //更新职位（知道职位的ID更改职位信息）
    public Integer updatePosition(Position position) {
        PositionPO positionPO = new PositionPO();
        positionPO.setPositionId(position.getId());
        positionPO.setName(position.getName());
        positionPO.setLevel(position.getLevel());
        positionPO.setDeptid(position.getDeptid());
        positionPO.setDescribtion(position.getDescribtion());
        Integer rows = positionPOMapper.updateByPrimaryKeySelective(positionPO);
        return rows;
    }
}
