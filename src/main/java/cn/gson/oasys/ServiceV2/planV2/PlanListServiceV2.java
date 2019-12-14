package cn.gson.oasys.ServiceV2.planV2;

import cn.gson.oasys.ServiceV2.DeptServiceV2;
import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.PlanListPOMapper;
import cn.gson.oasys.model.po.PlanListPO;
import cn.gson.oasys.model.po.PlanListPOExample;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PlanListServiceV2 {
    @Resource
    private PlanListPOMapper planListPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private DeptServiceV2 deptServiceV2;
    @Resource
    private PlanServiceV2 planServiceV2;

    /**
     * 根据用户id找用户在根据记录创建时间排序模糊查询未完成
     *
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOSByUserIdAndBaseKey(Long userId, String baseKey) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId).andLabelLike("%" + baseKey + "%");
        PlanListPOExample.Criteria criteria1 = planListPOExample.createCriteria().andTitleLike("%" + baseKey + "%").andPlanUserIdEqualTo(userId);

        //根据类型名模糊查找
        List<Long> longList = typeServiceV2.getTypePOIdByTypeNameLike("%" + baseKey + "%");
        PlanListPOExample.Criteria criteria2 = planListPOExample.createCriteria().andPlanUserIdEqualTo(userId).
                andTypeIdIn(longList);
        //根据状态名模糊查找
        PlanListPOExample.Criteria criteria3 = planListPOExample.createCriteria().andPlanUserIdEqualTo(userId).
                andStatusIdIn(statusServiceV2.getStatusPOIdListByStatusNameLike("%" + baseKey + "%"));
        if (criteria1 != null) {
            planListPOExample.or(criteria1);
        }
        if (longList.size() > 0) {
            planListPOExample.or(criteria2);

        }
        if (statusServiceV2.getStatusPOIdListByStatusNameLike("%" + baseKey + "%").size() > 0) {
            planListPOExample.or(criteria3);
        }
//        PlanListPOExample.Criteria criteria3 = planListPOExample.createCriteria().andLabelLike("%" + baseKey + "%");
//        planListPOExample.or().andLabelLike("%" + baseKey + "%");
//        planListPOExample.or().andTitleLike("%" + baseKey + "%");

        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据用户id找计划列表
     *
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOSByUserId(Long userId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据用户id找用户在根据类型排序
     *
     * @param typeId
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOSByUserIdAndTypeId(String typeId, Long userId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
        planListPOExample.setOrderByClause(typeId);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据用户id找用户在根据记录状态排序
     *
     * @param statusId
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOSByUserIdAndStatusId(String statusId, Long userId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
        planListPOExample.setOrderByClause(statusId);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据用户id找用户在根据记录创建时间排序
     *
     * @param createTime
     * @param userId
     * @return
     */
    public List<PlanListPO> getPlanListPOByUserIdAndCreateTime(String createTime, Long userId) {
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andPlanUserIdEqualTo(userId);
        planListPOExample.setOrderByClause(createTime);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据类型名模糊查询
     *
     * @param selectTypeName
     * @return
     */
    public List<PlanListPO> getPlanListPOSByTypeName(int page, String selectTypeName) {
        List<Long> longList = typeServiceV2.getTypePOIdByTypeNameLike(selectTypeName);
        PageHelper.startPage(page, 10);
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andTypeIdIn(longList);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;

    }

    /**
     * 根据状态名模糊查找
     *
     * @param page
     * @param selectStatusName
     * @return
     */
    public List<PlanListPO> getPlanListPOByStatusNameLike(int page, String selectStatusName) {
        List<Long> longList = statusServiceV2.getStatusPOIdListByStatusNameLike(selectStatusName);
        PageHelper.startPage(page, 10);
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andStatusIdIn(longList);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 查询在开始时间和结束时间之间的计划
     *
     * @param page
     * @param selectStartTime
     * @param selectEndTime
     * @return
     */
    public List<PlanListPO> getPlanListPOByCreateTimeBetween(int page, String selectStartTime, String selectEndTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = simpleDateFormat.parse(selectStartTime);
        Date endTime = simpleDateFormat.parse(selectEndTime);
        PageHelper.startPage(page, 10);
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andCreateTimeBetween(startTime, endTime);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 发布时间大于或等于开始时间
     *
     * @param page
     * @param selectStartTime
     * @return
     */
    public List<PlanListPO> getPlanListPOByCreateTimeGreaterThanOrEqualTo(int page, String selectStartTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = simpleDateFormat.parse(selectStartTime);
        PageHelper.startPage(page, 10);
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andCreateTimeGreaterThanOrEqualTo(startTime);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 发布时间小于或等于开始时间
     *
     * @param page
     * @param selectEndTime
     * @return
     */
    public List<PlanListPO> getPlanListPOByCreateTimeLessThanOrEqualTo(int page, String selectEndTime) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date endTime = simpleDateFormat.parse(selectEndTime);
        PageHelper.startPage(page, 10);
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andCreateTimeLessThanOrEqualTo(endTime);
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }


    /**
     * 根据部门名模糊查询
     *
     * @param page
     * @param selectDeptName
     * @return
     */
//    public List<PlanListPO> getPlanListPOByDeptNameLike(int page, String selectDeptName) {
////        PageHelper.startPage(page, 10);
//        PlanListPOExample planListPOExample = new PlanListPOExample();
//        List<Long> longList = deptServiceV2.getDeptPOListDeptNameLike(selectDeptName);
//        for (Long list : longList){
//        List<> = userServiceV2.getUserByDeptId(list);
//
//        }
//        planListPOExample.createCriteria().andPlanUserIdEqualTo(longList);
//        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
//        return planListPOS;
//
//    }

    /**
     * 根据标题模糊查询
     *
     * @param page
     * @param selectTitle
     * @return
     */
    public List<PlanListPO> getPlanListPOByTitleLike(int page, String selectTitle) {
        PageHelper.startPage(page, 10);
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andTitleLike("%" + selectTitle + "%");
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    /**
     * 根据标签名模糊查询
     *
     * @param page
     * @param selectLabel
     * @return
     */
    public List<PlanListPO> getPlanListPOByLabelLike(int page, String selectLabel) {
        PageHelper.startPage(page, 10);
        PlanListPOExample planListPOExample = new PlanListPOExample();
        planListPOExample.createCriteria().andLabelLike("%" + selectLabel + "%");
        List<PlanListPO> planListPOS = planListPOMapper.selectByExample(planListPOExample);
        return planListPOS;
    }

    //根据部门名找出部门id，在根据部门id找出这个部门下的用户id，在和计划的发布人id相同，则是这个部门的计划

    /**
     * 根据部门名找出这个部门的计划
     *
     * @param page
     * @param selectDeptName
     * @return
     */
    public List<PlanListPO> getPlanListPOBySelectDeptName(int page, String selectDeptName) {
        Long deptId = deptServiceV2.getDeptPOIdsByDeptNameLike(selectDeptName).get(0);//根据部门名找部门id
        List<Long> userIds = userServiceV2.getUserPOIdsByDeptPOId(deptId);//根据部门id找这个部门用户ids
        List<PlanListPO> planListPOSAll = planServiceV2.getPlanListPOSAll();//所有计划
        PageHelper.startPage(page, 10);
        List<PlanListPO> otherPlanListPOS = new ArrayList<>();//这个部门的计划
        for (PlanListPO planListPO : planListPOSAll) {
            for (Long userId : userIds) {
                if (planListPO.getPlanUserId().equals(userId)) {
                    otherPlanListPOS.add(planListPO);
                }
            }
        }
        return otherPlanListPOS;
    }

    /**
     * 根据用户名模糊查找用户的计划
     *
     * @param page
     * @param username
     * @return
     */
    public List<PlanListPO> getPlanListPOSBySelectUsername(int page, String username) {
        List<Long> userIds = userServiceV2.getUserIdsByUsernameLike(username);
        List<PlanListPO> planListPOSAll = planServiceV2.getPlanListPOSAll();// 所有计划
        PageHelper.startPage(page, 10);
        List<PlanListPO> otherPlanListPOS = new ArrayList<>();//存用户的计划
        for (PlanListPO planListPO : planListPOSAll) {
            for (Long userId : userIds) {
                if (userId.equals(planListPO.getPlanUserId())) {
                    otherPlanListPOS.add(planListPO);
                }
            }
        }
        return otherPlanListPOS;
    }

}
