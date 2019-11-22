package cn.gson.oasys.ServiceV2.planV2;

import cn.gson.oasys.mappers.PlanListPOMapper;
import cn.gson.oasys.model.po.PlanListPO;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlanServiceV2 {
    @Resource
    private PlanListPOMapper planListPOMapper;
    @Resource
    PlanListServiceV2 planListServiceV2;


    //分页
    public List<PlanListPO> sortAndGetPlan(int page, String baseKey, long userId, Object type, Object status, Object time) {
        PageHelper.startPage(page, 10);
//        if(!StringUtils.isEmpty(baseKey)){
//
//            System.out.println("进来了");
//            return planListServiceV2.getPlanListPOSByUserIdAndBaseKey(baseKey,userId);
//        }

        if (!StringUtils.isEmpty(type)) {
            if (type.toString().equals("0")) {
                //降序
                return planListServiceV2.getPlanListPOSByUserIdAndTypeId("type_id DESC", userId);
            } else {
                //升序
                return planListServiceV2.getPlanListPOSByUserIdAndTypeId("type_id ASC", userId);
            }
        }

        if (!StringUtils.isEmpty(status)) {
            if (status.toString().equals("0")) {
                return planListServiceV2.getPlanListPOSByUserIdAndStatusId("status_id DESC", userId);
            } else {
                return planListServiceV2.getPlanListPOSByUserIdAndStatusId("status_id ASC", userId);
            }
        }

        if (!StringUtils.isEmpty(time)) {
            if (time.toString().equals("0")) {
                return planListServiceV2.getPlanListPOByUserIdAndCreateTime("create_time DESC", userId);
            } else {
                return planListServiceV2.getPlanListPOByUserIdAndCreateTime("create_time ASC", userId);
            }
        } else {
            return planListServiceV2.getPlanListPOByUserIdAndCreateTime("create_time DESC", userId);
        }

    }

}
