package cn.gson.oasys.serviceV2.mailV2;

import cn.gson.oasys.serviceV2.statusV2.StatusPOServiceV2;
import cn.gson.oasys.serviceV2.typeV2.TypePOServiceV2;
import cn.gson.oasys.mappers.MailNumberPOMapper;
import cn.gson.oasys.model.dao.maildao.InMailDao;
import cn.gson.oasys.model.dao.maildao.MailnumberDao;
import cn.gson.oasys.model.dao.maildao.MailreciverDao;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.entity.mail.Pagemail;
import cn.gson.oasys.modelV2.po.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private StatusPOServiceV2 statusPOServiceV2;
    @Resource
    private TypePOServiceV2 typePOServiceV2;
    @Resource
    private MailReciverPOServiceV2 mailReciverServiceV2;
    @Resource
    private InMailListServiceV2 inMailListServiceV2;
    @Resource
    private MailNumberServiceV2 mailNumberServiceV2;

    private String rootPath;
    private String userRootPath;

    @PostConstruct
    public void UserpanelController() {
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources/static");
            userRootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources");
        } catch (IOException e) {
            System.out.println("获取项目路径异常");
        }
    }





    /**
     * 收件箱(垃圾箱）
     */
    public List<Pagemail> recive(int page, int size, Long userId, String title) {

        PageHelper.startPage(page, size);
        List<Pagemail> pageMailList = new ArrayList<>();
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_in_mail_list");
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_in_mail_list");
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
            String typeName = typePOServiceV2.getTypePOByTypeId(pagemail.getMailType()).getTypeName();//邮件的类型
            StatusPO statusPO = statusPOServiceV2.getStatusPOByStatusId(pagemail.getMailStatusid());
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
        List<StatusPO> statusPOList = statusPOServiceV2.getStatusPOByStatusModel("aoa_in_mail_list");
        List<TypePO> typePOList = typePOServiceV2.getTypePOByTypeModel("aoa_in_mail_list");
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
            String typeName = typePOServiceV2.getTypePOByTypeId(inMailListPO.getMailType()).getTypeName();
            StatusPO statusPO = statusPOServiceV2.getStatusPOByStatusId(inMailListPO.getMailStatusId());
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

    /**
     * 校验中文
     *
     * @param str
     * @return
     */
    public boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 发外部邮件
     *
     * @param account  邮箱账户
     * @param password 授权码
     * @param receiver  接收人
     * @param name     邮箱用户别名
     * @param title    邮件主题
     * @param content  邮件内容
     * @param affix    附件路径
     * @param filename 附件名
     */
    public void pushmail(String account, String password, String receiver,
                         String name, String title, String content, String affix, String filename) {
        String file = null;
        if (!StringUtil.isEmpty(affix)) {
            File root = new File(rootPath, affix);
            file = root.getAbsolutePath();
        }
        // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
        String myEmailAccount = account;
        String myEmailPassword = password;
        // 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
        //qq  smtp.qq.com
        String myEmailSMTPHost = "smtp.qq.com";
        // 收件人邮箱（替换为自己知道的有效邮箱）
        //  String receiveMailAccount = "1533047354@qq.com";
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        // 开启 SSL 安全连接。
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
        final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log
        // 3. 创建一封邮件
        MimeMessage message;
        try {
            message = createMimeMessage(session, myEmailAccount, receiver, name, title, content, file, filename);
            // 4. 根据 Session 获取邮件传输对象
            Transport transport = session.getTransport();
            // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
            transport.connect(myEmailAccount, myEmailPassword);
            // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
            // 7. 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail,
                                                String name, String title, String content, String affix, String filename) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, name, "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, "XX用户", "UTF-8"));

        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject(title, "UTF-8");

        if (!StringUtil.isEmpty(affix)) {

            // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
            Multipart multipart = new MimeMultipart();
            // 设置邮件的文本内容
            BodyPart contentPart = new MimeBodyPart();
            contentPart.setContent(content, "text/html;charset=UTF-8");
            multipart.addBodyPart(contentPart);
            // 添加附件
            BodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(affix);//附件路径
            // 添加附件的内容
            messageBodyPart.setDataHandler(new DataHandler(source));
            // 添加附件的标题
            // 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
            sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
            messageBodyPart.setFileName("=?GBK?B?" + enc.encode(filename.getBytes()) + "?=");
            multipart.addBodyPart(messageBodyPart);

            // 将multipart对象放到message中
            message.setContent(multipart, "text/html;charset=UTF-8");
        } else {
            // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
            message.setContent(content, "text/html;charset=UTF-8");
        }
        // 6. 设置发件时间
        message.setSentDate(new Date());

        // 7. 保存设置
        message.saveChanges();


        return message;
    }


}
