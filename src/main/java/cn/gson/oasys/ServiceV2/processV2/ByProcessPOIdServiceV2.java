package cn.gson.oasys.ServiceV2.processV2;

import cn.gson.oasys.mappers.*;
import cn.gson.oasys.model.po.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ByProcessPOIdServiceV2 {
    @Resource
    private BursementPOMapper bursementPOMapper;
    @Resource
    private EvectionPOMapper evectionPOMapper;
    @Resource
    private OvertimePOMapper overtimePOMapper;
    @Resource
    private HolidayPOMapper holidayPOMapper;
    @Resource
    private RegularPOMapper regularPOMapper;
    @Resource
    private ResignPOMapper resignPOMapper;

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
        resignPOExample.createCriteria().andResignIdEqualTo(processPOId);
        ResignPO resignPO = resignPOMapper.selectByExample(resignPOExample).get(0);
        return resignPO;
    }

}
