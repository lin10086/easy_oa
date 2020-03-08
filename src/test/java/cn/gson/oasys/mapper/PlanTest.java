package cn.gson.oasys.mapper;

import cn.gson.oasys.serviceV2.planV2.PlanListServiceV2;
import cn.gson.oasys.modelV2.po.PlanListPO;
import com.github.pagehelper.PageInfo;
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
public class PlanTest {

    @Resource
    private PlanListServiceV2 planListServiceV2;

    @Test
    public void PlanTest1() {
        int page = 0;
        List<PlanListPO> planListPOS = planListServiceV2.getPlanListPOSByTypeName(page, "日");
        PageInfo pageInfo = new PageInfo(planListPOS);
        log.info("pageInfo={}", pageInfo);
    }

    @Test
    public void PlanTest2() {
        String start = null;

        Boolean b = start.equals(null);
        log.info("b={}", b);
    }

}
