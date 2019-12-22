package cn.gson.oasys.ServiceV2.mailV2;

import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypePOServiceV2;
import cn.gson.oasys.mappers.MailNumberPOMapper;
import cn.gson.oasys.model.po.MailNumberPO;
import cn.gson.oasys.model.po.MailNumberPOExample;
import cn.gson.oasys.model.po.StatusPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.mailVO2.MailNumberVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.*;

@Service
public class MailNumberServiceV2 {
    @Resource
    private MailNumberPOMapper mailNumberPOMapper;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private TypePOServiceV2 typeServiceV2;

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

    /**
     * 根据用户ID找邮箱账号
     *
     * @param userPO
     * @return
     */
    public List<MailNumberPO> getMailNumberPOListByUserId(UserPO userPO) {
        MailNumberPOExample mailNumberPOExample = new MailNumberPOExample();
        mailNumberPOExample.createCriteria().andMailNumUserIdEqualTo(userPO.getUserId());
        List<MailNumberPO> mailNumberPOList = mailNumberPOMapper.selectByExample(mailNumberPOExample);
        return mailNumberPOList;
    }

    /**
     * 封装邮箱账号
     *
     * @param mailNumberPOList
     * @return
     */
    public List<Map<String, Object>> encapsulationMailNumberPO(List<MailNumberPO> mailNumberPOList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (MailNumberPO mailNumberPO : mailNumberPOList) {
            Map<String, Object> map = new HashMap<>();
            StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(mailNumberPO.getStatus());
            map.put("mailNumberPOId", mailNumberPO.getMailNumberId());
            map.put("typeName", typeServiceV2.getTypePOByTypeId(mailNumberPO.getMailType()).getTypeName());
            map.put("statusName", statusPO.getStatusName());
            map.put("statusColor", statusPO.getStatusColor());
            map.put("mailNumberPOName", mailNumberPO.getMailUserName());
            map.put("mailCreateTime", new Timestamp(mailNumberPO.getMailCreateTime().getTime()));
            mapList.add(map);
        }
        return mapList;
    }


    /**
     * 插入或更新邮箱
     *
     * @param mailNumberV2
     */
    public void insertOrUpdateMailNumberPO(MailNumberVO mailNumberV2, Long userId) {
        MailNumberPO mailNumberPO = new MailNumberPO();
        mailNumberPO.setMailType(mailNumberV2.getMailType());
        mailNumberPO.setStatus(mailNumberV2.getStatus());
        mailNumberPO.setMailUserName(mailNumberV2.getMailUserName());
        mailNumberPO.setMailAccount(mailNumberV2.getMailAccount());
        mailNumberPO.setPassword(mailNumberV2.getPassword());
        mailNumberPO.setMailDes(mailNumberV2.getMailDes());
        mailNumberPO.setMailNumUserId(userId);
        if (mailNumberV2.getMailNumberId() == null) {
            mailNumberPO.setMailCreateTime(new Date());
            mailNumberPOMapper.insertSelective(mailNumberPO);
        } else {
            mailNumberPO.setMailNumberId(mailNumberV2.getMailNumberId());
            mailNumberPO.setMailCreateTime(mailNumberV2.getMailCreateTime());
            mailNumberPOMapper.updateByPrimaryKeySelective(mailNumberPO);
        }
    }

    /**
     * 根据邮箱账号ID删除邮箱账号
     *
     * @param mailNumberPOId
     */
    public void deleteMailNumberPO(Long mailNumberPOId) {
        mailNumberPOMapper.deleteByPrimaryKey(mailNumberPOId);
    }


    /**
     * 账号 查询
     *
     * @param page
     * @param size
     * @param val
     * @return
     */
    public List<MailNumberPO> selectMailNumberPO(int page, int size, String val, Model model) {
        List<MailNumberPO> mailNumberPOList = null;
        PageHelper.startPage(page, size);
        if (StringUtil.isEmpty(val)) {
            MailNumberPOExample mailNumberPOExample = new MailNumberPOExample();
            mailNumberPOExample.setOrderByClause("status ASC,mail_create_time DESC");
            mailNumberPOList = mailNumberPOMapper.selectByExample(mailNumberPOExample);
        } else {
            MailNumberPOExample mailNumberPOExample = new MailNumberPOExample();
            mailNumberPOExample.setOrderByClause("status ASC,mail_create_time DESC");
            mailNumberPOExample.createCriteria().andMailUserNameLike(val);
            mailNumberPOList = mailNumberPOMapper.selectByExample(mailNumberPOExample);
            model.addAttribute("sort", "&val=" + val);
        }
        return mailNumberPOList;
    }


}
