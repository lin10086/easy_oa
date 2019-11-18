package cn.gson.oasys.ServiceV2.mailV2;

import cn.gson.oasys.mappers.MailNumberPOMapper;
import cn.gson.oasys.model.po.MailNumberPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MailNumberServiceV2 {
    @Resource
    private MailNumberPOMapper mailNumberPOMapper;

    /**
     * 根据邮箱账号ID找邮箱
     *
     * @param mailNumberPOId
     * @return
     */
    public MailNumberPO getMailNumberPOByMailNumberPOId(Long mailNumberPOId) {
        MailNumberPO mailNumberPO = mailNumberPOMapper.selectByPrimaryKey(mailNumberPOId);
        return mailNumberPO;
    }
}
