package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.factory.PositionFactory;
import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
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
    public List<Position> getPositionList() {
        PositionPOExample positionPOExample = new PositionPOExample();
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        List<Position> positionList = PositionFactory.create(positionPOList);
        return positionList;
    }

    //根据部门ID获取职位信息(并转换成本身的职位信息）
    public List<Position> getPositionByDeptId(Long deptId) {

        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andDeptidEqualTo(deptId);
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        List<Position> positionList = PositionFactory.create(positionPOList);
        return positionList;
    }

    //根据职位ID获取职位信息并转换为本身的职位信息
    public Position getPositionByPositionId(Long positionId) {
        PositionPOExample positionPOExample = new PositionPOExample();
        PositionPO positionPO = positionPOMapper.selectByPrimaryKey(positionId);
        Position position = PositionFactory.create(positionPO);
        return position;
    }

    //根据部门ID（1L)和职位名name是以经理结尾的（返回职位列表）
    public List<Position> getPositionListByDeptIdAndNameLike() {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andDeptidEqualTo(1L)
                .andNameLike("%经理");
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        List<Position> positionList = PositionFactory.create(positionPOList);
        return positionList;
    }
    //已知用户查找用户的职位信息
//    public Position getPositionByUser(User user){
//        PositionPOExample positionPOExample = new PositionPOExample();
//        positionPOMapper.selectByPrimaryKey(user.)
//    }


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
