package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.ReviewedPO;
import cn.gson.oasys.vo.ReviewedVO;

import java.util.ArrayList;
import java.util.List;

public class ReviewedFactoryVO {

    public static ReviewedVO createReviewedVO(ReviewedPO reviewedPO){
        ReviewedVO reviewedVO = new ReviewedVO();
        reviewedVO.setReviewedId(reviewedPO.getReviewedId());
        reviewedVO.setAdvice(reviewedPO.getAdvice());
        reviewedVO.setReviewedTime(reviewedPO.getReviewedTime());
        reviewedVO.setDel(reviewedPO.getDel()==0?false:true);
        reviewedVO.setStatusId(reviewedPO.getStatusId());
        return reviewedVO;
//    private User userId;//审核人（审核人ID）
//    private ProcessList proId;//主表（主表ID）
    }

    public static List<ReviewedVO>createReviewedVOList(List<ReviewedPO>reviewedPOList){
        List<ReviewedVO>reviewedVOList = new ArrayList<>();
        for(ReviewedPO reviewedPO : reviewedPOList){
            reviewedVOList.add(ReviewedFactoryVO.createReviewedVO(reviewedPO));
        }
        return reviewedVOList;
    }





}
