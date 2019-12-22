package cn.gson.oasys.ServiceV2.taskV2;

import cn.gson.oasys.mappers.TaskListPOMapper;
import cn.gson.oasys.model.po.TaskListPO;
import cn.gson.oasys.model.po.TaskListPOExample;
import cn.gson.oasys.model.po.UserPO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class TaskListServiceV2 {
    @Resource
    private TaskListPOMapper taskListPOMapper;

    /**
     * 根据任务ID修改状态ID
     *
     * @param taskId
     * @param statusId
     * @return
     */
    public Integer updateTaskListPOStatus(Long taskId, Long statusId) {
        TaskListPO taskListPO = taskListPOMapper.selectByPrimaryKey(taskId);
        taskListPO.setStatusId(statusId.intValue());
        Integer rows = taskListPOMapper.updateByPrimaryKeySelective(taskListPO);
        return rows;
    }


    /**
     * 根据是否取消，状态ID进行排序和任务ID是否在（根据用户找到的任务ID里面）
     *
     * @param taskIdList
     * @return
     */
    public List<TaskListPO> getTaskListPOBySortAndTaskIdIn(List<Long> taskIdList) {
        TaskListPOExample taskListPOExample = new TaskListPOExample();
        taskListPOExample.setOrderByClause("is_cancel ASC,status_id ASC");
        taskListPOExample.createCriteria().andTaskIdIn(taskIdList);
        List<TaskListPO> taskListPOList = taskListPOMapper.selectByExample(taskListPOExample);
        return taskListPOList;
    }

    /**
     * 根据类型ID和任务ID是否在（根据用户找到的任务ID里面）
     *
     * @param taskIdList
     * @param typeId
     * @return
     */
    public List<TaskListPO> getTaskListPOByTypeIdAndTaskIdIn(List<Long> taskIdList, Long typeId) {
        TaskListPOExample taskListPOExample = new TaskListPOExample();
        taskListPOExample.createCriteria().andTaskIdIn(taskIdList).andTypeIdEqualTo(typeId);
        List<TaskListPO> taskListPOList = taskListPOMapper.selectByExample(taskListPOExample);
        return taskListPOList;
    }

    /**
     * 根据状态ID和任务ID是否在（根据用户找到的任务ID里面）
     *
     * @param taskIdList
     * @param statusId
     * @return
     */
    public List<TaskListPO> getTaskListPOByStatusIdAndTaskIdIn(List<Long> taskIdList, Integer statusId) {
        TaskListPOExample taskListPOExample = new TaskListPOExample();
        taskListPOExample.createCriteria().andTaskIdIn(taskIdList).andStatusIdEqualTo(statusId);
        List<TaskListPO> taskListPOList = taskListPOMapper.selectByExample(taskListPOExample);
        return taskListPOList;
    }

    /**
     * 根据任务是否取消和任务ID是否在（根据用户找到的任务ID里面）
     *
     * @param taskIdList
     * @param cancel
     * @return
     */
    public List<TaskListPO> getTaskListPOBycancelAndTaskIdIn(List<Long> taskIdList, Boolean cancel) {
        TaskListPOExample taskListPOExample = new TaskListPOExample();
        taskListPOExample.createCriteria().andTaskIdIn(taskIdList).andIsCancelEqualTo(cancel == false ? 0 : 1);
        List<TaskListPO> taskListPOList = taskListPOMapper.selectByExample(taskListPOExample);
        return taskListPOList;
    }

    /**
     * 根据任务发布人和任务ID是否在（根据用户找到的任务ID里面）
     *
     * @param taskIdList
     * @param userPO
     * @return
     */
    public List<TaskListPO> getTaskListPOByUserPOIdAndTaskIdIn(List<Long> taskIdList, UserPO userPO) {
        TaskListPOExample taskListPOExample = new TaskListPOExample();
        taskListPOExample.createCriteria().andTaskIdIn(taskIdList).andTaskPushUserIdEqualTo(userPO.getUserId());
        List<TaskListPO> taskListPOList = taskListPOMapper.selectByExample(taskListPOExample);
        return taskListPOList;
    }

    /**
     * 根据任务标题和任务ID是否在（根据用户找到的任务ID里面）
     *
     * @param taskIdList
     * @param title
     * @return
     */
    public List<TaskListPO> getTaskListPOByTitleLikeAndTaskIdIn(List<Long> taskIdList, String title) {
        TaskListPOExample taskListPOExample = new TaskListPOExample();
        taskListPOExample.createCriteria().andTaskIdIn(taskIdList).andTitleLike("%" + title + "%");
        List<TaskListPO> taskListPOList = taskListPOMapper.selectByExample(taskListPOExample);
        return taskListPOList;
    }

    /**
     * 根据任务结束后反馈部位空找任务列表
     *
     * @return
     */
    public List<TaskListPO> getTaskListPOByTickingIsNotNull() {
        TaskListPOExample taskListPOExample = new TaskListPOExample();
        taskListPOExample.createCriteria().andTickingIsNotNull();
        List<TaskListPO> taskListPOList = taskListPOMapper.selectByExample(taskListPOExample);
        return taskListPOList;
    }


    /**
     * 根据任务表ID找任务信息
     *
     * @param taskListPOId
     * @return
     */
    public TaskListPO getTaskListPOByTaskListPOId(Long taskListPOId) {
        TaskListPO taskListPO = taskListPOMapper.selectByPrimaryKey(taskListPOId);
        return taskListPO;
    }


    /**
     * 根据状态ID和用户ID找任务列表
     *
     * @param statusId 状态ID 7为以完成
     * @param userId   用户ID
     * @return
     */
    public List<TaskListPO> getTaskListPOByStatusIdAndUserId(Integer statusId, Long userId) {
        //查找任务完成的用户
//        @Query(nativeQuery=true, value="SELECT COUNT(*) from aoa_task_list where aoa_task_list.status_id=?1 and aoa_task_list.task_push_user_id=?2 ")
//        Integer countfinish(Long status,Long userid);

        TaskListPOExample taskListPOExample = new TaskListPOExample();
        taskListPOExample.createCriteria().andStatusIdEqualTo(statusId).andTaskPushUserIdEqualTo(userId);
        List<TaskListPO> taskListPOList = taskListPOMapper.selectByExample(taskListPOExample);
        return taskListPOList;
    }

}
