package cn.gson.oasys.vo.factoryvo.mailFactory;

import cn.gson.oasys.model.po.MailNumberPO;
import cn.gson.oasys.vo.mailV2.MailNumberVO;

import java.util.ArrayList;
import java.util.List;

public class MailNumberVOFactory {
    public static MailNumberVO createMailNumberVOByMailNumberPO(MailNumberPO mailNumberPO) {
        MailNumberVO mailNumberVO = new MailNumberVO();
        mailNumberVO.setMailNumberId(mailNumberPO.getMailNumberId());
        mailNumberVO.setMailType(mailNumberPO.getMailType());
        mailNumberVO.setStatus(mailNumberPO.getStatus());
        mailNumberVO.setMailUserName(mailNumberPO.getMailUserName());
        mailNumberVO.setMailCreateTime(mailNumberPO.getMailCreateTime());
        mailNumberVO.setMailAccount(mailNumberPO.getMailAccount());
        mailNumberVO.setPassword(mailNumberPO.getPassword());
        mailNumberVO.setMailDes(mailNumberPO.getMailDes());
        return mailNumberVO;
    }

    public static List<MailNumberVO> createMailNumberVOListByMailNumberPOList(List<MailNumberPO> mailNumberPOList) {
        List<MailNumberVO> mailNumberVOList = new ArrayList<>();
        for (MailNumberPO mailNumberPO : mailNumberPOList) {
            mailNumberVOList.add(MailNumberVOFactory.createMailNumberVOByMailNumberPO(mailNumberPO));
        }
        return mailNumberVOList;
    }

}
