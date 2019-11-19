package cn.gson.oasys.mapper;

import cn.gson.oasys.mappers.MailNumberPOMapper;
import cn.gson.oasys.model.po.MailNumberPO;
import cn.gson.oasys.model.po.MailNumberPOExample;
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
public class MailTest {
    @Resource
    private MailNumberPOMapper mailNumberPOMapper;
    @Test
    public void select(){
        MailNumberPOExample mailNumberPOExample = new MailNumberPOExample();
        mailNumberPOExample.setOrderByClause("status ASC,mail_create_time DESC");
//        mailNumberPOExample.setOrderByClause("mail_create_time DESC");
//        mailNumberPOExample.setOrderByClause("status ASC");
       List<MailNumberPO> mailNumberPOList = mailNumberPOMapper.selectByExample(mailNumberPOExample);
       log.info("mailNumberPOList={}",mailNumberPOList);
    }
}
