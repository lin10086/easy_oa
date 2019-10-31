package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.mappers.ProcessListPOMapper;
import cn.gson.oasys.mappers.ReviewedPOMapper;
import cn.gson.oasys.model.po.ProcessListPO;
import cn.gson.oasys.model.po.ProcessListPOExample;
import cn.gson.oasys.model.po.ReviewedPO;
import cn.gson.oasys.model.po.ReviewedPOExample;
import cn.gson.oasys.vo.ProcessListVO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.processVO.ProcessAuditVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ReviewedServiceV2 {

    @Resource
    private ReviewedPOMapper reviewedPOMapper;
    @Resource
    private ProcessListPOMapper processListPOMapper;
    //插入审核表
    public void insertReviewedVO(UserVO reuser, ProcessListVO processListVO){
        ReviewedPO reviewedPO = new ReviewedPO();
        reviewedPO.setUserId(reuser.getUserId());
        reviewedPO.setStatusId(23L);
        reviewedPO.setDel(0);
        reviewedPO.setReviewedTime(new Date());
        reviewedPO.setProId(processListVO.getProcessId());
        reviewedPOMapper.insert(reviewedPO);
    }

}
