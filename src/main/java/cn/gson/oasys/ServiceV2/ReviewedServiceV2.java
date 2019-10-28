package cn.gson.oasys.ServiceV2;

import cn.gson.oasys.mappers.ReviewedPOMapper;
import cn.gson.oasys.model.po.ReviewedPO;
import cn.gson.oasys.vo.ProcessListVO;
import cn.gson.oasys.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Slf4j
@Service
public class ReviewedServiceV2 {

    @Resource
    ReviewedPOMapper reviewedPOMapper;
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
