package cn.gson.oasys.ServiceV2.mailV2;

import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.mappers.MailNumberPOMapper;
import cn.gson.oasys.model.dao.maildao.InMailDao;
import cn.gson.oasys.model.dao.maildao.MailnumberDao;
import cn.gson.oasys.model.dao.maildao.MailreciverDao;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.entity.mail.Mailnumber;
import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.mailV2.MailNumberV2;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
@Transactional
public class MailServiceV2 {
    @Autowired
    private StatusDao sdao;
    @Autowired
    private TypeDao tydao;
    @Autowired
    private MailnumberDao mdao;
    @Autowired
    private MailreciverDao mrdao;

    @Autowired
    private InMailDao imdao;

    @Resource
    private MailNumberPOMapper mailNumberPOMapper;
    @Resource
    private StatusServiceV2 statusServiceV2;

    private String rootPath;

    @PostConstruct
    public void UserpanelController() {
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main//resources/attachment");
        } catch (IOException e) {
            System.out.println("获取项目路径异常");
        }
    }

    /**
     * 上传附件
     *
     * @param file
     * @param applyUserPO 登录人
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public AttachmentListPO uploadAttachmentListPO(MultipartFile file, UserPO applyUserPO) throws IllegalStateException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(rootPath, simpleDateFormat.format(new Date()));
        //用当前时间的年月和用户名做文件夹
        File savePath = new File(root, applyUserPO.getUserName());

        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        //获取原始文件名
        String fileName = file.getOriginalFilename();
        if (!StringUtil.isEmpty(fileName)) {
            //获取文件后缀名
            String suffix = FilenameUtils.getExtension(fileName);
            //新文件名
            String newFileName = UUID.randomUUID().toString().toLowerCase() + "." + suffix;
            //文件夹 文件名
            File targetFile = new File(savePath, newFileName);
            file.transferTo(targetFile);

            String str = targetFile.getPath().replace(rootPath, "");

            AttachmentListPO attachmentPO = new AttachmentListPO();
            attachmentPO.setAttachmentName(file.getOriginalFilename());
            attachmentPO.setAttachmentPath(str);//没起作用
            attachmentPO.setAttachmentShuffix(suffix);
            attachmentPO.setAttachmentSize(file.getSize() + "");
            attachmentPO.setAttachmentType(file.getContentType());
            attachmentPO.setUploadTime(new Date());
            attachmentPO.setUserId(applyUserPO.getUserId() + "");
            return attachmentPO;
        }
        return null;
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
            map.put("typeName", tydao.findname(mailNumberPO.getMailType()));
            map.put("statusName", statusPO.getStatusName());
            map.put("statusColor", statusPO.getStatusColor());
            map.put("mailNumberPOName", mailNumberPO.getMailUserName());
            map.put("mailCreateTime", new Timestamp(mailNumberPO.getMailCreateTime().getTime()));
            mapList.add(map);
        }
        return mapList;
    }

    /**
     * 根据邮件ID找邮件列表
     *
     * @param mailNumberPOId
     * @return
     */
    public MailNumberPO getMailNumberPOByMailNumberPOId(Long mailNumberPOId) {
        MailNumberPO mailNumberPO = mailNumberPOMapper.selectByPrimaryKey(mailNumberPOId);
        return mailNumberPO;
    }

    /**
     * 插入或更新邮箱
     *
     * @param mailNumberV2
     */
    public void insertOrUpdateMailNumberPO(MailNumberV2 mailNumberV2, Long userId) {
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


}
