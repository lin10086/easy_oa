package cn.gson.oasys.ServiceV2.processServiceV2;

import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.mappers.ProcessListPOMapper;
import cn.gson.oasys.mappers.ReviewedPOMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户处理流程审核的VO业务
 */
@Service
public class ProcessAuditVOServiceV2 {
    @Resource
    private ProcessListPOMapper processListPOMapper;
    @Resource
    private ReviewedPOMapper reviewedPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private ReviewedServiceV2 reviewedServiceV2;




}
