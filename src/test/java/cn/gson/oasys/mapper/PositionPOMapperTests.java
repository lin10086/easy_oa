package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.PositionPOMapper;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.modelV2.po.PositionPO;
import cn.gson.oasys.modelV2.po.PositionPOExample;
import cn.gson.oasys.voandfactory.positionVO2.PositionVO;
import cn.gson.oasys.voandfactory.positionVO2.PositionVOFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class PositionPOMapperTests {
    @Resource
    private PositionPOMapper positionPOMapper;

    @Test
    public void getPositionList() {
        PositionPOExample positionPOExample = new PositionPOExample();
        positionPOExample.createCriteria().andDeptidEqualTo(1L)
                .andNameLike("%经理");
        List<PositionPO> positionPOList = positionPOMapper.selectByExample(positionPOExample);
        List<PositionVO> positionList = PositionVOFactory.createPositionVOListByPositionPOList(positionPOList);
        log.info("positionList={}", positionList);
    }
}
