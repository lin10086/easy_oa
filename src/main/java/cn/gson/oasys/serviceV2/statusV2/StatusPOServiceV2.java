package cn.gson.oasys.serviceV2.statusV2;

import cn.gson.oasys.mappers.StatusPOMapper;
import cn.gson.oasys.model.po.StatusPO;
import cn.gson.oasys.model.po.StatusPOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StatusPOServiceV2 {
    @Resource
    private StatusPOMapper statusPOMapper;

    /**
     * 插入或更新状态信息
     *
     * @param statusPO 状态信息
     */
    public void insertOrUpdateStatusPOByStatusId(StatusPO statusPO) {
        if (statusPO.getStatusId() != null) {
            statusPOMapper.updateByPrimaryKeySelective(statusPO);
        } else {
            statusPOMapper.insertSelective(statusPO);
        }
    }

    /**
     * 根据状态ID删除状态信息
     *
     * @param statusId 状态ID
     */
    public void deleteStatusPOByStatusId(Long statusId) {
        statusPOMapper.deleteByPrimaryKey(statusId);
    }


    /**
     * 根据状态模型找状态列表
     *
     * @param statusModel 状态模型
     * @return
     */
    public List<StatusPO> getStatusPOByStatusModel(String statusModel) {
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelEqualTo(statusModel);
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        return statusPOList;
    }


    /**
     * 根据模糊状态名找状态id
     *
     * @param selectStatusName 状态名
     * @return
     */
    public List<Long> getStatusPOIdListByStatusNameLike(String selectStatusName) {
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusNameLike("%" + selectStatusName + "%");
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        List<Long> longList = new ArrayList<>();
        for (StatusPO statusPO : statusPOList) {
            longList.add(statusPO.getStatusId());
        }
        return longList;
    }


    /**
     * 根据状态模型和状态名找状态
     *
     * @param statusModel 状态模型
     * @param statusName  状态名
     * @return
     */
    public StatusPO getStatusPOByTypeModelAndStatusName(String statusModel, String statusName) {
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelEqualTo(statusModel).andStatusNameEqualTo(statusName);
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        return statusPOList.get(0);

    }

    /**
     * 根据类型名或类型模型模糊查询
     *
     * @param name 模糊字
     * @return
     */
    public List<StatusPO> getStatusPOListByTypeModelLikeOrStatusNameLike(String name) {
        StatusPOExample statusPOExample = new StatusPOExample();
        statusPOExample.createCriteria().andStatusModelLike("%" + name + "%");
        StatusPOExample.Criteria criteria = statusPOExample.createCriteria().andStatusNameLike("%" + name + "%");
        statusPOExample.or(criteria);
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        return statusPOList;
    }

    /**
     * 根据状态ID找状态
     *
     * @param statusId 状态ID
     * @return
     */
    public StatusPO getStatusPOByStatusId(Long statusId) {
        StatusPO statusPO = statusPOMapper.selectByPrimaryKey(statusId);
        return statusPO;
    }

    /**
     * 获取所有状态
     *
     * @return
     */
    public List<StatusPO> getStatusPOListAll() {
        StatusPOExample statusPOExample = new StatusPOExample();
        List<StatusPO> statusPOList = statusPOMapper.selectByExample(statusPOExample);
        return statusPOList;
    }

    /**
     * 根据考勤模型获取考勤状态ID集合
     *
     * @return
     */
    private List<Long> getStatusIdsByStatusModel() {
        List<StatusPO> statusPOList = getStatusPOByStatusModel("aoa_attends_list");
        List<Long> statusIds = new ArrayList<>();
        for (StatusPO statusPO : statusPOList) {
            statusIds.add(statusPO.getStatusId());
        }
        return statusIds;
    }


}
