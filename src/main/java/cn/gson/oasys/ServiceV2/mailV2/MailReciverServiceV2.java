package cn.gson.oasys.ServiceV2.mailV2;

import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.mappers.MailReciverPOMapper;
import cn.gson.oasys.model.po.MailReciverPO;
import cn.gson.oasys.model.po.MailReciverPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MailReciverServiceV2 {
    @Resource
    private MailReciverPOMapper mailReciverPOMapper;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;

    /**
     * 根据用户和是否已读是否删除找中间表
     *
     * @param read
     * @param del
     * @param userId
     * @return
     */
    public List<MailReciverPO> getMailReciverPOByReadAndDelAndUserId(Boolean read, Boolean del, Long userId) {
        MailReciverPOExample mailReciverPOExample = new MailReciverPOExample();
        mailReciverPOExample.createCriteria().andIsDelEqualTo(read == false ? 0 : 1).andIsReadEqualTo(del == false ? 0 : 1).andMailReciverIdEqualTo(userId);
        List<MailReciverPO> mailReciverPOList = mailReciverPOMapper.selectByExample(mailReciverPOExample);
        return mailReciverPOList;
    }

    /**
     * 找已删除的条数
     *
     * @param del
     * @param userId
     * @return
     */
    public List<MailReciverPO> getDelMailReciverPOList(Boolean del, Long userId) {
        MailReciverPOExample mailReciverPOExample = new MailReciverPOExample();
        mailReciverPOExample.createCriteria().andIsDelEqualTo(del == false ? 0 : 1).andMailReciverIdEqualTo(userId);
        List<MailReciverPO> mailReciverPOList = mailReciverPOMapper.selectByExample(mailReciverPOExample);
        return mailReciverPOList;
    }


    /**
     * 在中间表根据邮件ID找是否删除
     *
     * @param mailId
     * @return
     */
    public List<Boolean> getDelByMailReciverPOId(Long mailId) {
        MailReciverPOExample mailReciverPOExample = new MailReciverPOExample();
        mailReciverPOExample.createCriteria().andMailIdEqualTo(mailId);
        List<MailReciverPO> mailReciverPOList = mailReciverPOMapper.selectByExample(mailReciverPOExample);
        List<Boolean> list = new ArrayList<>();
        for (MailReciverPO mailReciverPO : mailReciverPOList) {
            list.add(mailReciverPO.getIsDel() == 0 ? false : true);
        }
        return list;
    }

    /**
     * 收件箱邮件
     *
     * @param del
     * @param userId
     * @return
     */
    public List<MailReciverPO> getMailReciverPO(Boolean del, Long userId) {
        MailReciverPOExample mailReciverPOExample = new MailReciverPOExample();
        mailReciverPOExample.setOrderByClause("mail_create_time DESC");
        mailReciverPOExample.createCriteria().andIsDelEqualTo(del == false ? 0 : 1).andMailReciverIdEqualTo(userId);
        List<MailReciverPO> mailReciverPOList = mailReciverPOMapper.selectByExample(mailReciverPOExample);
        return mailReciverPOList;
    }


    /**
     * 根据用户id的和是否已读进行排序
     *
     * @param userId
     * @return
     */
    public List<MailReciverPO> getMailReciverPOByReadASC(Long userId) {
        MailReciverPOExample mailReciverPOExample = new MailReciverPOExample();
        mailReciverPOExample.setOrderByClause("is_read ASC");
        mailReciverPOExample.createCriteria().andMailReciverIdEqualTo(userId);
        List<MailReciverPO> mailReciverPOList = mailReciverPOMapper.selectByExample(mailReciverPOExample);
        return mailReciverPOList;
    }

    /**
     * 在中间表根据用户ID和邮件ID找中间表信息
     *
     * @param userId
     * @param mailId
     * @return
     */
    public MailReciverPO getMailReciverPOByMailIdAndUserId(Long userId, Long mailId) {
        MailReciverPOExample mailReciverPOExample = new MailReciverPOExample();
        mailReciverPOExample.createCriteria().andMailReciverIdEqualTo(userId).andMailIdEqualTo(mailId);
        List<MailReciverPO> mailReciverPOList = mailReciverPOMapper.selectByExample(mailReciverPOExample);
        return mailReciverPOList.get(0);
    }

    /**
     * 修改邮件中间表的del字段
     *
     * @param mailReciverPO
     */
    public void updateMailReciverPODel(MailReciverPO mailReciverPO) {
        mailReciverPO.setIsDel(1);
        mailReciverPOMapper.updateByPrimaryKeySelective(mailReciverPO);
    }

    /**
     * 修改邮件中间表的read字段
     *
     * @param mailReciverPO
     */
    public void updateMailReciverPORead(MailReciverPO mailReciverPO,Integer read) {
        mailReciverPO.setIsRead(read);
        mailReciverPOMapper.updateByPrimaryKeySelective(mailReciverPO);

    }
    /**
     * 修改邮件中间表的str字段
     *
     * @param mailReciverPO
     */
    public void updateMailReciverPOStar(MailReciverPO mailReciverPO,Integer star) {
        mailReciverPO.setIsStar(star);
        mailReciverPOMapper.updateByPrimaryKeySelective(mailReciverPO);

    }

    /**
     * 根据中间表ID删除中间信息
     *
     * @param mailReciverPOId
     */
    public void deleteMailReciverPO(Long mailReciverPOId) {
        mailReciverPOMapper.deleteByPrimaryKey(mailReciverPOId);
    }

    /**
     * 根据邮件ID找中间列表
     *
     * @param mailId
     * @return
     */
    public List<MailReciverPO> getMailReciverPOByMailId(Long mailId) {
        MailReciverPOExample mailReciverPOExample = new MailReciverPOExample();
        mailReciverPOExample.createCriteria().andMailIdEqualTo(mailId);
        List<MailReciverPO> mailReciverPOList = mailReciverPOMapper.selectByExample(mailReciverPOExample);
        return mailReciverPOList;
    }

    /**
     * 插入邮件中间表
     *
     * @param mailId
     * @param userId
     */
    public void insertMailReciverPO(Long mailId, Long userId) {
        MailReciverPO mailReciverPO = new MailReciverPO();
        mailReciverPO.setIsRead(0);
        mailReciverPO.setIsDel(0);
        mailReciverPO.setIsStar(0);
        mailReciverPO.setMailId(mailId);
        mailReciverPO.setMailReciverId(userId);
        mailReciverPOMapper.insertSelective(mailReciverPO);
    }
}
