package cn.gson.oasys.ServiceV2.mailV2;

import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.mappers.MailNumberPOMapper;
import cn.gson.oasys.model.dao.maildao.InMailDao;
import cn.gson.oasys.model.dao.maildao.MailnumberDao;
import cn.gson.oasys.model.dao.maildao.MailreciverDao;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.entity.mail.Inmaillist;
import cn.gson.oasys.model.entity.mail.Pagemail;
import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.mailV2.MailNumberV2;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
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
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private MailReciverServiceV2 mailReciverServiceV2;
    @Resource
    private InMailListServiceV2 inMailListServiceV2;

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


    /**
     * 收件箱(垃圾箱）
     */
    public List<Pagemail> recive(int page, int size, Long userId, String title) {

        PageHelper.startPage(page, size);
        List<Pagemail> pageMailList = new ArrayList<>();
//        List<StatusPO> statusPOList = statusServiceV2.getStatusPOByTypeModel("aoa_in_mail_list");
//        List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("aoa_in_mail_list");
        List<MailReciverPO> mailReciverPOList = null;
        if ("收件箱".equals(title)) {
            mailReciverPOList = mailReciverServiceV2.getDelMailReciverPOList(false, userId);
        } else {
            //垃圾箱
            mailReciverPOList = mailReciverServiceV2.getDelMailReciverPOList(true, userId);
        }
        List<InMailListPO> inMailListPOList = inMailListServiceV2.getInMailListPOByMailCreateTimeDESC();
        for (MailReciverPO mailReciverPO : mailReciverPOList) {
            for (InMailListPO inMailListPO : inMailListPOList) {
                if (mailReciverPO.getMailId().equals(inMailListPO.getMailId())) {
                    Pagemail pagemail = new Pagemail();
                    pagemail.setRead(mailReciverPO.getIsRead() == 0 ? false : true);//是否已读
                    pagemail.setStar(mailReciverPO.getIsStar() == 0 ? false : true);//是否星标
                    pagemail.setMailType(inMailListPO.getMailType());//邮件类型
                    pagemail.setMailId(inMailListPO.getMailId());//邮件ID
                    pagemail.setMailStatusid(inMailListPO.getMailStatusId());//邮件的状态ID
                    pagemail.setMailTitle(inMailListPO.getMailTitle());// 邮件主题
                    pagemail.setInReceiver(inMailListPO.getInReceiver());// 发件人
                    pagemail.setMailFileid(inMailListPO.getMailFileId());//邮件的附件ID
                    pagemail.setMailCreateTime(inMailListPO.getMailCreateTime());//邮件的创建时间
                    pageMailList.add(pagemail);
                }
            }
        }
        return pageMailList;
    }

    /**
     * 封装Pagemail
     */
    public List<Map<String, Object>> mail(List<Pagemail> pageMailList) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Pagemail pagemail : pageMailList) {
            Map<String, Object> result = new HashMap<>();
            String typeName = typeServiceV2.getTypePOByTypeId(pagemail.getMailType()).getTypeName();//邮件的类型
            StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(pagemail.getMailStatusid());
            result.put("typeName", typeName);//类型名
            result.put("statusName", statusPO.getStatusName());// 状态名
            result.put("statusColor", statusPO.getStatusColor());//状态颜色
            result.put("star", pagemail.getStar());// 是否星标
            result.put("read", pagemail.getRead());//是否已读
            result.put("time", new Timestamp(pagemail.getMailCreateTime().getTime()));//创建时间
            result.put("receive", pagemail.getInReceiver());//接收人
            result.put("title", pagemail.getMailTitle());//邮件主题
            result.put("mailId", pagemail.getMailId());//邮件ID
            result.put("fileId", pagemail.getMailFileid());//邮件的附件ID
            list.add(result);
        }
        return list;
    }

    /**
     * 发件箱
     */
    public List<InMailListPO> inmail(int page, int size, Long userId, String title) {
        PageHelper.startPage(page, size);
        List<InMailListPO> inMailListPOList = null;
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOByTypeModel("aoa_in_mail_list");
        List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("aoa_in_mail_list");
        if ("发件箱".equals(title)) {
            inMailListPOList = inMailListServiceV2.getInMailListPOByMailCreateTimeDESCAndUserIdAndPushAndDel(userId, true, false);
        } else {
//            草稿箱
            inMailListPOList = inMailListServiceV2.getInMailListPOByMailCreateTimeDESCAndUserIdAndPushAndDel(userId, false, false);

        }
        return inMailListPOList;

    }

    /**
     * 发件箱封装
     */
    public List<Map<String, Object>> maillist(List<InMailListPO> inMailListPOList) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (InMailListPO inMailListPO : inMailListPOList) {
            Map<String, Object> result = new HashMap<>();
            String typeName = typeServiceV2.getTypePOByTypeId(inMailListPO.getMailType()).getTypeName();
            StatusPO statusPO = statusServiceV2.getStatusPOByStatusId(inMailListPO.getMailStatusId());
            result.put("typeName", typeName);//类型名
            result.put("statusName", statusPO.getStatusName());//状态名
            result.put("statusColor", statusPO.getStatusColor());//状态颜色
            result.put("star", inMailListPO.getMailStar() == 0 ? false : true);//是否星标
            result.put("read", true);//  是否已读
            result.put("time", new Timestamp(inMailListPO.getMailCreateTime().getTime()));//创建时间
            result.put("receive", inMailListPO.getInReceiver());//发件人ID
            result.put("title", inMailListPO.getMailTitle());//邮件主题
            result.put("mailId", inMailListPO.getMailId());//邮件ID
            result.put("fileId", inMailListPO.getMailFileId());//附件ID
            list.add(result);

        }
        return list;
    }

    /**
     * 根据用户ID和状态找邮箱账号
     *
     * @param userId
     * @param statusId
     * @return
     */
    public List<MailNumberPO> getMailNumberPOListByStatusAndMailUserId(Long userId, Long statusId) {
        MailNumberPOExample mailNumberPOExample = new MailNumberPOExample();
        mailNumberPOExample.createCriteria().andMailNumUserIdEqualTo(userId).andStatusEqualTo(statusId);
        List<MailNumberPO> mailNumberPOList = mailNumberPOMapper.selectByExample(mailNumberPOExample);
        return mailNumberPOList;
    }

}
