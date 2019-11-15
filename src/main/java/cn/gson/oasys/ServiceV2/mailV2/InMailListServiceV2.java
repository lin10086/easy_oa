package cn.gson.oasys.ServiceV2.mailV2;

import cn.gson.oasys.mappers.InMailListPOMapper;
import cn.gson.oasys.model.po.InMailListPO;
import cn.gson.oasys.model.po.InMailListPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InMailListServiceV2 {
    @Resource
    private InMailListPOMapper inMailListPOMapper;

    /**
     * 根据是否删除，发件人ID，是否推送
     *
     * @param push
     * @param del
     * @param userId
     * @return
     */
    public List<InMailListPO> getInMailListPOListByPushAndDelAndUserId(Boolean push, Boolean del, Long userId) {
        InMailListPOExample inMailListPOExample = new InMailListPOExample();
        inMailListPOExample.createCriteria().andMailDelEqualTo(del == false ? 0 : 1).andMailInPushUserIdEqualTo(userId).andMailPushEqualTo(push == false ? 0 : 1);
        List<InMailListPO> inMailListPOList = inMailListPOMapper.selectByExample(inMailListPOExample);
        return inMailListPOList;
    }

    /**
     * 根据创建时间降序（内部邮件）
     *
     * @return
     */
    public List<InMailListPO> getInMailListPOByMailCreateTimeDESC() {
        InMailListPOExample inMailListPOExample = new InMailListPOExample();
        inMailListPOExample.setOrderByClause("mail_create_time DESC");
        List<InMailListPO> inMailListPOList = inMailListPOMapper.selectByExample(inMailListPOExample);
        return inMailListPOList;

    }

    public List<InMailListPO> getInMailListPOByMailCreateTimeDESCAndUserIdAndPushAndDel(Long userId, Boolean push, Boolean del) {
        InMailListPOExample inMailListPOExample = new InMailListPOExample();
        inMailListPOExample.setOrderByClause("mail_create_time DESC");
        inMailListPOExample.createCriteria().andMailPushEqualTo(push == false ? 0 : 1).andMailInPushUserIdEqualTo(userId).andMailDelEqualTo(del == false ? 0 : 1);
        List<InMailListPO> inMailListPOList = inMailListPOMapper.selectByExample(inMailListPOExample);
        return inMailListPOList;

    }

    /**
     * 根据内部邮件ID找邮件
     *
     * @param mailId 内部邮件ID
     * @return
     */
    public InMailListPO getInMailListPOByInMailListPOId(Long mailId) {
        InMailListPO inMailListPO = inMailListPOMapper.selectByPrimaryKey(mailId);
        return inMailListPO;
    }

    /**
     * 更新内部邮件表的del
     *
     * @param inMailListPO
     */
    public void updateInMailListPODel(InMailListPO inMailListPO) {
        inMailListPO.setMailDel(1);
        inMailListPOMapper.updateByPrimaryKeySelective(inMailListPO);
    }

    /**
     * 根据内部邮件ID删除邮件
     *
     * @param mailId
     */
    public void deleteInMailListPO(Long mailId) {
        inMailListPOMapper.deleteByPrimaryKey(mailId);
    }

}
