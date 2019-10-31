package cn.gson.oasys.ServiceV2.processV2;

import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.mappers.ProcessListPOMapper;
import cn.gson.oasys.mappers.ReviewedPOMapper;
import cn.gson.oasys.model.po.ProcessListPO;
import cn.gson.oasys.model.po.ProcessListPOExample;
import cn.gson.oasys.model.po.ReviewedPO;
import cn.gson.oasys.model.po.ReviewedPOExample;
import cn.gson.oasys.services.system.TypeService;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.processVO.ProcessAuditVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    public List<ProcessAuditVO> getProcessAuditVOByProcessPOAndReviewedPO(UserVO userVO, Boolean bo) {
        ProcessListPOExample processListPOExample = new ProcessListPOExample();
        List<ProcessListPO> processListPOList = processListPOMapper.selectByExample(processListPOExample);

        ReviewedPOExample reviewedPOExample = new ReviewedPOExample();
        reviewedPOExample.createCriteria().andUserIdEqualTo(userVO.getUserId()).andDelEqualTo(bo == false ? 0 : 1);
        reviewedPOExample.setOrderByClause("status_id");
        List<ReviewedPO> reviewedPOList = reviewedPOMapper.selectByExample(reviewedPOExample);

        List<ProcessAuditVO> processAuditVOList = new ArrayList<>();
        for (ProcessListPO processListPO : processListPOList) {
            for (ReviewedPO reviewedPO : reviewedPOList) {
                if (processListPO.getProcessId() == reviewedPO.getProId() && reviewedPO.getUserId() == userVO.getUserId()) {
                    ProcessAuditVO processAuditVO = new ProcessAuditVO();
                    processAuditVO.setProcessId(processListPO.getProcessId());
                    processAuditVO.setTypeName(processListPO.getTypeName());
                    processAuditVO.setProcessName(processListPO.getProcessName());
                    processAuditVO.setUserName(userServiceV2.getUsernameByUserId(processListPO.getProcessUserId()));
                    processAuditVO.setApplyTime(processListPO.getApplyTime());
                    processAuditVO.setDeeplyId(processListPO.getDeeplyId());
                    processAuditVO.setStatusId(reviewedPO.getStatusId());
                    processAuditVOList.add(processAuditVO);
                }
            }
        }
        return processAuditVOList;

    }
}
