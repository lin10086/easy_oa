package cn.gson.oasys;

import cn.gson.oasys.mappers.ReplyListPOMapper;
import cn.gson.oasys.model.po.ReplyListPO;
import cn.gson.oasys.model.po.ReplyListPOExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyListPOTest {
    @Resource
    private ReplyListPOMapper replyListPOMapper;

    @Test
    public void getReplyListPOSByDiscussId() {
        ReplyListPOExample replyListPOExample = new ReplyListPOExample();
        replyListPOExample.createCriteria().andDiscussIdEqualTo(1L);
        List<ReplyListPO> replyListPOS = replyListPOMapper.selectByExample(replyListPOExample);
        log.info("replyListPOS={}", replyListPOS);
    }

    @Test
    public void getReplyListPOSByReplyListPOId() {
        ReplyListPOExample replyListPOExample = new ReplyListPOExample();
        replyListPOExample.createCriteria().andDiscussIdEqualTo(1L);
        List<ReplyListPO> replyListPOS = replyListPOMapper.selectByExampleWithBLOBs(replyListPOExample);
        log.info("replyListPOS={}", replyListPOS);
    }

    @Test
    public void getReplyListPOSByReplyTime() {
        ReplyListPOExample replyListPOExample = new ReplyListPOExample();
        replyListPOExample.createCriteria().andReplayTimeGreaterThanOrEqualTo(new Date());
        List<ReplyListPO> replyListPOS = replyListPOMapper.selectByExampleWithBLOBs(replyListPOExample);
        log.info("replyListPOS={}", replyListPOS);
    }

}
