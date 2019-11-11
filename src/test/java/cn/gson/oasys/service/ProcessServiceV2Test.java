package cn.gson.oasys.service;

import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.ProcessListPOMapper;
import cn.gson.oasys.mappers.ReviewedPOMapper;
import cn.gson.oasys.mappers.UserPOMapper;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.processV2.ProcessAuditVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProcessServiceV2Test {

    /**
     * 用户处理流程审核的VO业务
     */
    @Resource
    private ProcessListPOMapper processListPOMapper;
    @Resource
    private ReviewedPOMapper reviewedPOMapper;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private UserPOMapper userPOMapper;

    @Test
    public void getProcessAuditVOByProcessPOAndReviewedPO() {
        ProcessListPOExample processListPOExample = new ProcessListPOExample();
        List<ProcessListPO> processListPOList = processListPOMapper.selectByExample(processListPOExample);

        ReviewedPOExample reviewedPOExample = new ReviewedPOExample();
        reviewedPOExample.createCriteria().andUserIdEqualTo(3L).andDelEqualTo(0);
        reviewedPOExample.setOrderByClause("status_id");
        List<ReviewedPO> reviewedPOList = reviewedPOMapper.selectByExample(reviewedPOExample);

        List<ProcessAuditVO> processAuditVOList = new ArrayList<>();
        for (ProcessListPO processListPO : processListPOList) {
            for (ReviewedPO reviewedPO : reviewedPOList) {
                if (processListPO.getProcessId() == reviewedPO.getProId() && reviewedPO.getUserId() == 3) {
                    ProcessAuditVO processAuditVO = new ProcessAuditVO();
                    processAuditVO.setTypeName(processListPO.getTypeName());
                    processAuditVO.setProcessName(processListPO.getProcessName());
                    processAuditVO.setUserName(userServiceV2.getUsernameByUserId(processListPO.getProcessUserId()));
                    processAuditVO.setApplyTime(processListPO.getApplyTime());
                    processAuditVO.setExigenceName(processListPO.getDeeplyId());
                    processAuditVO.setStatusId(reviewedPO.getStatusId());
                    processAuditVOList.add(processAuditVO);
                }
            }
        }
        log.info("processAuditVOList={}", processAuditVOList);

    }

    @Test
    public void processPOList() {
        PageHelper.startPage(0,10);
        UserPOExample userPOExample = new UserPOExample();
        List<UserPO>userPOList = userPOMapper.selectByExample(userPOExample);
        PageInfo pageInfo = new PageInfo(userPOList);
        log.info("pageInfo={}",pageInfo);


    }
}


