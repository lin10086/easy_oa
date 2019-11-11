package cn.gson.oasys.ServiceV2.processServiceV2;

import cn.gson.oasys.mappers.*;
import cn.gson.oasys.model.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ByProcessPOIdServiceV2 {
    @Resource
    private BursementPOMapper bursementPOMapper;
    @Resource
    private EvectionPOMapper evectionPOMapper;
    @Resource
    private EvectionMoneyPOMapper evectionMoneyPOMapper;
    @Resource
    private OvertimePOMapper overtimePOMapper;
    @Resource
    private HolidayPOMapper holidayPOMapper;
    @Resource
    private RegularPOMapper regularPOMapper;
    @Resource
    private ResignPOMapper resignPOMapper;
    @Resource
    private ReviewedPOMapper reviewedPOMapper;

    /**
     * 根据流程主表ID查询消费表信息
     *
     * @param processPOId 流程主表ID
     * @return
     */
    public BursementPO getBursementPOByProcessPOId(Long processPOId) {
        BursementPOExample bursementPOExample = new BursementPOExample();
        bursementPOExample.createCriteria().andProIdEqualTo(processPOId);
        BursementPO bursementPO = bursementPOMapper.selectByExample(bursementPOExample).get(0);
        return bursementPO;
    }

    /**
     * 根据流程主表ID查询出差表信息
     *
     * @param processPOId 流程主表ID
     * @return
     */
    public EvectionPO getEvectionPOByProcessPOId(Long processPOId) {
        EvectionPOExample evectionPOExample = new EvectionPOExample();
        evectionPOExample.createCriteria().andProIdEqualTo(processPOId);
        EvectionPO evectionPO = evectionPOMapper.selectByExample(evectionPOExample).get(0);
        return evectionPO;
    }

    /**
     * 根据主表ID找出差消费表ID
     *
     * @param processPOId 流程主表ID
     * @return
     */
    public EvectionMoneyPO getEvectionMoneyPOByProcessPOId(Long processPOId) {
        EvectionMoneyPOExample evectionMoneyPOExample = new EvectionMoneyPOExample();
        evectionMoneyPOExample.createCriteria().andProIdEqualTo(processPOId);
        EvectionMoneyPO evectionMoneyPO = evectionMoneyPOMapper.selectByExample(evectionMoneyPOExample).get(0);
        return evectionMoneyPO;
    }

    /**
     * 根据流程主表ID查询加班申请表信息
     *
     * @param processPOId 流程主表ID
     * @return
     */
    public OvertimePO getOvertimePOByProcessPOId(Long processPOId) {
        OvertimePOExample overtimePOExample = new OvertimePOExample();
        overtimePOExample.createCriteria().andProIdEqualTo(processPOId);
        OvertimePO overtimePO = overtimePOMapper.selectByExample(overtimePOExample).get(0);
        return overtimePO;
    }

    /**
     * 根据流程主表ID查询请假申请表信息
     *
     * @param processPOId 流程主表ID
     * @return
     */
    public HolidayPO getHolidayPOByProcessPOId(Long processPOId) {
        HolidayPOExample holidayPOExample = new HolidayPOExample();
        holidayPOExample.createCriteria().andProIdEqualTo(processPOId);
        HolidayPO holidayPO = holidayPOMapper.selectByExample(holidayPOExample).get(0);
        return holidayPO;
    }

    /**
     * 根据流程主表ID查询转正申请表信息
     *
     * @param processPOId 流程主表ID
     * @return
     */
    public RegularPO getRegularPOByProcessPOId(Long processPOId) {
        RegularPOExample regularPOExample = new RegularPOExample();
        regularPOExample.createCriteria().andProIdEqualTo(processPOId);
        RegularPO regularPO = regularPOMapper.selectByExample(regularPOExample).get(0);
        return regularPO;
    }

    /**
     * 根据流程主表ID查询离职申请表信息
     *
     * @param processPOId 流程主表ID
     * @return
     */
    public ResignPO getResignPOByProcessPOId(Long processPOId) {
        ResignPOExample resignPOExample = new ResignPOExample();
        resignPOExample.createCriteria().andProIdEqualTo(processPOId);
        ResignPO resignPO = resignPOMapper.selectByExample(resignPOExample).get(0);
        return resignPO;
    }

    /**
     * 根据流程主表ID和审核人ID找审核表
     *
     * @param processPOId 流程主表ID
     * @param userId      审核人ID
     * @return
     */
    public ReviewedPO getReviewedPOByProcessPOIdAndUserId(Long processPOId, Long userId) {
        ReviewedPOExample reviewedPOExample = new ReviewedPOExample();
        reviewedPOExample.createCriteria().andProIdEqualTo(processPOId).andUserIdEqualTo(userId);
        List<ReviewedPO> reviewedPOList = reviewedPOMapper.selectByExample(reviewedPOExample);
        return reviewedPOList.get(0);
    }

    /**
     * 根据审核时间非空和主表ID找审核列表
     *
     * @param processPOId
     * @return
     */
    public List<ReviewedPO> getReviewedPOListByReviewedTimeNotNullAndProcessId(Long processPOId) {

        ReviewedPOExample reviewedPOExample = new ReviewedPOExample();
        reviewedPOExample.createCriteria().andReviewedTimeIsNotNull().andProIdEqualTo(processPOId);
        List<ReviewedPO> reviewedPOList = reviewedPOMapper.selectByExample(reviewedPOExample);
        return reviewedPOList;
    }
}
