package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.model.po.PositionPO;
import cn.gson.oasys.model.po.PositionPOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PositionPOServiceV2 {
    @Resource
    PositionPOMapper positionPOMapper;

    /**
     * 获取所有的职位列表
     *
     * @return
     */
    public List<PositionPO> getPositionListAll() {
        PositionPOExample positionPOExample = new PositionPOExample();
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        return positionPOList;
    }

    /**
     * 根据部门ID获取职位信息
     *
     * @param deptId
     * @return
     */
    public List<PositionPO> getPositionPOByDeptId(Long deptId) {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andDeptidEqualTo(deptId);
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        return positionPOList;
    }

    /**
     * 根据职位ID获取职位信息
     *
     * @param positionId
     * @return
     */
    public PositionPO getPositionPOByPositionId(Long positionId) {
        PositionPO positionPO = positionPOMapper.selectByPrimaryKey(positionId);
        return positionPO;
    }

    /**
     * 职位名不是name结尾的（返回职位列表）
     *
     * @return
     */
    public List<PositionPO> getPositionPOListByNameNotLike(String name) {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andNameNotLike(name);
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        return positionPOList;
    }


    /**
     * 根据职位名name不是以经理结尾和部门ID找职位列表
     *
     * @param deptId 部门ID
     * @return
     */
    public List<PositionPO> getPositionPOListByDeptIdAndNameNotLike(Long deptId) {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andNameNotLike("%经理").andDeptidEqualTo(deptId);
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        return positionPOList;
    }

    /**
     * 根据职位名模糊查找职位（获取找到的位置IDS）
     *
     * @param baseKey 模糊字
     * @return
     */
    public List<Long> getPositionIdsByPositionNameLike(String baseKey) {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andNameLike("%" + baseKey + "%");
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        List<Long> positionIds = new ArrayList<>();
        if (positionPOList.size() > 0) {
            for (PositionPO positionPO : positionPOList) {
                positionIds.add(positionPO.getPositionId());
            }
        }
        return positionIds;
    }


    /**
     * 插入或更新一个职位
     *
     * @param positionPO 职位信息
     * @return
     */
    public Integer insertOrUpdatePositionPO(PositionPO positionPO) {
        Integer rows = null;
        if (positionPO.getPositionId() == null) {
            rows = positionPOMapper.insert(positionPO);
        } else {
            rows = positionPOMapper.updateByPrimaryKeySelective(positionPO);
        }
        return rows;
    }

    /**
     * 根据职位ID删除职位
     *
     * @param positionId 职位ID
     */
    public void deletePosition(Long positionId) {
        positionPOMapper.deleteByPrimaryKey(positionId);
    }

}
