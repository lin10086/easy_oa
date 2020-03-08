package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.ReviewedPO;

import java.util.ArrayList;
import java.util.List;

public class ReviewedVOFactory {

    public static ReviewedVO createReviewedVOByReviewedPO(ReviewedPO reviewedPO){
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

    public static List<ReviewedVO> createReviewedVOListByReviewedPOList(List<ReviewedPO>reviewedPOList){
        List<ReviewedVO>reviewedVOList = new ArrayList<>();
        for(ReviewedPO reviewedPO : reviewedPOList){
            reviewedVOList.add(ReviewedVOFactory.createReviewedVOByReviewedPO(reviewedPO));
        }
        return reviewedVOList;
    }





}
