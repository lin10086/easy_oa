package cn.gson.oasys;

import cn.gson.oasys.serviceV2.userV2.UserPOServiceV2;
import cn.gson.oasys.modelV2.bo.PageBO;
import cn.gson.oasys.modelV2.po.UserPO;
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
public class PageBOTest {
    @Resource
    private UserPOServiceV2 userPOServiceV2;

    @Test
    public void getPageBOUser() {
//        PageBO pageBO = new PageBO(0,10);
//        PageHelper.startPage(pageBO.getPageNo(), pageBO.getPageSize());
        List<UserPO> userPOList = userPOServiceV2.getUserAll();
        log.info("userPOList={}", userPOList);
        PageBO pageBO = new PageBO(3);
        int star = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (userPOList.size() < end) {
            end = userPOList.size();
        }
        pageBO.setTotalCount(userPOList.size());
        List<UserPO> subList = userPOList.subList(star, end);
        log.info("subList={}", subList);
        log.info("totalPageCount={}", pageBO.getTotalPageCount());
        log.info("isFirst={},isLastPage={},pageNo={}", pageBO.isFirstPage(), pageBO.isLastPage(), pageBO.getPageNo());
        log.info("prePage={}", pageBO.prePage());//是否有上一页
        log.info("nextPage={}", pageBO.nextPage());//是否有下一页
        log.info("pageBO={}", pageBO);
//        PageInfo pageInfo = new PageInfo(userPOList);
//        log.info("pageInfo={}", pageInfo);
//        log.info("total={}", pageInfo.getTotal());
    }
}
