package cn.gson.oasys.controller.mail;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.StatusServiceV2;
import cn.gson.oasys.ServiceV2.TypeServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.ServiceV2.mailV2.InMailListServiceV2;
import cn.gson.oasys.ServiceV2.mailV2.MailNumberServiceV2;
import cn.gson.oasys.ServiceV2.mailV2.MailReciverServiceV2;
import cn.gson.oasys.ServiceV2.mailV2.MailServiceV2;
import cn.gson.oasys.ServiceV2.processServiceV2.AttachmentServiceV2;
import cn.gson.oasys.ServiceV2.processServiceV2.ProcessServiceV2;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.factoryvo.AttachmentFactoryVO;
import cn.gson.oasys.vo.factoryvo.UserFactoryVO;
import cn.gson.oasys.vo.factoryvo.mailFactory.MailNumberVOFactory;
import cn.gson.oasys.vo.mailVO2.InMailListVO;
import cn.gson.oasys.vo.mailVO2.MailNumberVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;

import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.model.dao.maildao.InMailDao;
import cn.gson.oasys.model.dao.maildao.MailnumberDao;
import cn.gson.oasys.model.dao.maildao.MailreciverDao;
import cn.gson.oasys.model.dao.notedao.AttachmentDao;
import cn.gson.oasys.model.dao.roledao.RoleDao;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.mail.Pagemail;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.mail.MailServices;
import cn.gson.oasys.services.process.ProcessService;

@Controller
@RequestMapping("/")
public class MailController {


    @Autowired
    private MailnumberDao mndao;

    @Autowired
    private StatusDao sdao;
    @Autowired
    private TypeDao tydao;
    @Autowired
    private UserDao udao;
    @Autowired
    private DeptDao ddao;
    @Autowired
    private RoleDao rdao;
    @Autowired
    private PositionDao pdao;
    @Autowired
    private InMailDao imdao;
    @Autowired
    private MailreciverDao mrdao;
    @Autowired
    private AttachmentDao AttDao;
    @Autowired
    private MailServices mservice;
    @Autowired
    private ProcessService proservice;

    /**
     * 账号管理
     */
	/*@RequestMapping("accountmanage")
	public String account(@SessionAttribute("userId") Long userId, Model model,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size){
		// 通过邮箱建立用户id找用户对象
		User tu = udao.findOne(userId);

		Page<Mailnumber> pagelist=mservice.index(page, size, tu, null,model);
		List<Map<String, Object>> list=mservice.up(pagelist);

		model.addAttribute("account", list);
		model.addAttribute("page", pagelist);
		model.addAttribute("url", "mailpaixu");
		return "mail/mailmanage";
	}*/

    /**
     * 新增账号
     * 修改账号
     */
   /* @RequestMapping("addaccount")
    public String add(@SessionAttribute("userId") Long userId, Model model, HttpServletRequest req) {
        // 通过用户id找用户
        User tu = udao.findOne(userId);

        Mailnumber mailn = null;
        if (StringUtil.isEmpty(req.getParameter("id"))) {
            List<SystemTypeList> typelist = tydao.findByTypeModel("aoa_mailnumber");
            List<SystemStatusList> statuslist = sdao.findByStatusModel("aoa_mailnumber");
            model.addAttribute("typelist", typelist);
            model.addAttribute("statuslist", statuslist);

            if (!StringUtil.isEmpty((String) req.getAttribute("errormess"))) {
                mailn = (Mailnumber) req.getAttribute("mail");
                req.setAttribute("errormess", req.getAttribute("errormess"));
                model.addAttribute("mails", mailn);
                model.addAttribute("type", tydao.findname(mailn.getMailType()));
                model.addAttribute("status", sdao.findname(mailn.getStatus()));

            } else if (!StringUtil.isEmpty((String) req.getAttribute("success"))) {
                mailn = (Mailnumber) req.getAttribute("mail");
                req.setAttribute("success", "fds");
                model.addAttribute("mails", mailn);
                model.addAttribute("type", tydao.findname(mailn.getMailType()));
                model.addAttribute("status", sdao.findname(mailn.getStatus()));
            }
        } else {

            Long id = Long.parseLong(req.getParameter("id"));
            Mailnumber mailnum = mndao.findOne(id);
            model.addAttribute("type", tydao.findname(mailnum.getMailType()));
            model.addAttribute("status", sdao.findname(mailnum.getStatus()));
            model.addAttribute("mails", mailnum);


        }
        model.addAttribute("username", tu.getUserName());
        return "mail/addaccounts";
    }*/

    /**
     * 存邮箱账号
     *//*
    @RequestMapping("saveaccount")
    public String save(HttpServletRequest request, @Valid Mailnumber mail, BindingResult br, @SessionAttribute("userId") Long userId) {
        User tu = udao.findOne(userId);
        request.setAttribute("mail", mail);
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            request.setAttribute("errormess", list.get(0).toString());

            System.out.println("list错误的实体类信息：" + mail);
            System.out.println("list错误详情:" + list);
            System.out.println("list错误第一条:" + list.get(0));
            System.out.println("啊啊啊错误的信息——：" + list.get(0).toString());
        } else {
            if (Objects.isNull(mail.getMailNumberId())) {
                mail.setMailUserId(tu);
                mail.setMailCreateTime(new Date());
                mndao.save(mail);
            } else {
                Mailnumber mails = mndao.findOne(mail.getMailNumberId());
                mails.setMailType(mail.getMailType());
                mails.setStatus(mail.getStatus());
                mails.setMailDes(mail.getMailDes());
                mails.setMailAccount(mail.getMailAccount());
                mails.setPassword(mail.getPassword());
                mails.setMailUserName(mail.getMailUserName());
                mndao.save(mails);
            }
            request.setAttribute("success", "执行成功！");
        }
        return "forward:/addaccount";
    }
*/

    /**
     * 删除邮箱账号
     */
   /* @RequestMapping("dele")
    public String edit(HttpServletRequest request, @SessionAttribute("userId") Long userId) {
        //得到账号id
        Long accountid = Long.parseLong(request.getParameter("id"));
        Mailnumber mail = mndao.findOne(accountid);
        if (mail.getMailUserId().getUserId().equals(userId)) {
            mservice.dele(accountid);
        } else {
            return "redirect:/notlimit";
        }
        System.out.println("ffffffff");
        return "redirect:/accountmanage";
    }*/
    //=========================================

    /* *//**
     * 邮件管理主页
     *
     * @return
     *//*
    @RequestMapping("mail")
    public String index(@SessionAttribute("userId") Long userId, Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        //查找用户
        User user = udao.findOne(userId);
        //查找未读邮件
        List<Mailreciver> noreadlist = mrdao.findByReadAndDelAndReciverId(false, false, user);
        //查找创建了但是却没有发送的邮件
        List<Inmaillist> nopushlist = imdao.findByPushAndDelAndMailUserid(false, false, user);
        //查找发件条数
        List<Inmaillist> pushlist = imdao.findByPushAndDelAndMailUserid(true, false, user);
        //查找收件箱删除的邮件条数
        List<Mailreciver> rubbish = mrdao.findByDelAndReciverId(true, user);
        //分页及查找
        Page<Pagemail> pagelist = mservice.recive(page, size, user, null, "收件箱");
        List<Map<String, Object>> maillist = mservice.mail(pagelist);

        model.addAttribute("page", pagelist);
        model.addAttribute("maillist", maillist);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("noread", noreadlist.size());
        model.addAttribute("nopush", nopushlist.size());
        model.addAttribute("push", pushlist.size());
        model.addAttribute("rubbish", rubbish.size());
        model.addAttribute("mess", "收件箱");
        model.addAttribute("sort", "&title=收件箱");
        return "mail/mail";
    }
*/

    /**
     * 邮件管理的收，发，草，垃圾
     */
 /*   @RequestMapping("amail")
    public String index3(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pa = new PageRequest(page, size);
        User mu = udao.findOne(userId);
        String mess = req.getParameter("title");

        Page<Pagemail> pagelist = null;
        Page<Inmaillist> pagemail = null;
        List<Map<String, Object>> maillist = null;
        if (("收件箱").equals(mess)) {
            //分页及查找
            pagelist = mservice.recive(page, size, mu, null, mess);
            maillist = mservice.mail(pagelist);
        } else if (("发件箱").equals(mess)) {
            pagemail = mservice.inmail(page, size, mu, null, mess);
            maillist = mservice.maillist(pagemail);
        } else if (("草稿箱").equals(mess)) {
            pagemail = mservice.inmail(page, size, mu, null, mess);
            maillist = mservice.maillist(pagemail);
        } else {
            //垃圾箱
            //分页及查找
            pagelist = mservice.recive(page, size, mu, null, mess);
            maillist = mservice.mail(pagelist);
        }
        if (!Objects.isNull(pagelist)) {
            model.addAttribute("page", pagelist);
        } else {
            model.addAttribute("page", pagemail);
        }
        model.addAttribute("sort", "&title=" + mess);
        model.addAttribute("maillist", maillist);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", mess);
        return "mail/allmail";
    }

*/

    /**
     * 邮箱管理的类型（邮件，通知，公告）
     */
  /*  @RequestMapping("mailtitle")
    public String serch(@SessionAttribute("userId") Long userId, Model model, HttpServletRequest req,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        User user = udao.findOne(userId);
        String title = req.getParameter("title");
        String val = null;
        Page<Pagemail> pagelist = null;
        Page<Inmaillist> pagemail = null;
        List<Map<String, Object>> maillist = null;

        if (!StringUtil.isEmpty(req.getParameter("val"))) {
            val = req.getParameter("val");
        }
        if (("收件箱").equals(title)) {
            pagelist = mservice.recive(page, size, user, val, title);
            maillist = mservice.mail(pagelist);

        } else if (("发件箱").equals(title)) {

            pagemail = mservice.inmail(page, size, user, val, title);
            maillist = mservice.maillist(pagemail);
        } else if (("草稿箱").equals(title)) {

            pagemail = mservice.inmail(page, size, user, val, title);
            maillist = mservice.maillist(pagemail);
        } else {
            //垃圾箱
            pagelist = mservice.recive(page, size, user, val, title);
            maillist = mservice.mail(pagelist);
        }

        if (!Objects.isNull(pagelist)) {
            model.addAttribute("page", pagelist);
        } else {
            model.addAttribute("page", pagemail);
        }
        if (val != null) {
            model.addAttribute("sort", "&title=" + title + "&val=" + val);
        } else {
            model.addAttribute("sort", "&title=" + title);
        }
        model.addAttribute("maillist", maillist);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";
    }

*/

    /**
     * 写信
     */
/*    @RequestMapping("wmail")
    public String index2(Model model, @SessionAttribute("userId") Long userId, HttpServletRequest request,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        User mu = udao.findOne(userId);
        //得到编辑过来的id
        String id = null;
        if (!StringUtil.isEmpty(request.getParameter("id"))) {
            id = request.getParameter("id");
        }
        //回复那边过来的
        String huifu = null;
        if (!StringUtil.isEmpty(id)) {
            Long lid = Long.parseLong(id);
            //找到这条邮件
            Inmaillist mail = imdao.findOne(lid);
            if (!StringUtil.isEmpty(request.getParameter("huifu"))) {
                huifu = request.getParameter("huifu");
                model.addAttribute("title", huifu + mail.getMailTitle());
                model.addAttribute("content", mail.getContent());
            } else {
                model.addAttribute("title", mail.getMailTitle());
                model.addAttribute("content", mail.getContent());
            }
            model.addAttribute("status", sdao.findOne(mail.getMailStatusid()));
            model.addAttribute("type", tydao.findOne(mail.getMailType()));
            model.addAttribute("id", "回复");
        } else {
            List<SystemTypeList> typelist = tydao.findByTypeModel("aoa_in_mail_list");
            List<SystemStatusList> statuslist = sdao.findByStatusModel("aoa_in_mail_list");
            model.addAttribute("typelist", typelist);
            model.addAttribute("statuslist", statuslist);
            model.addAttribute("id", "新发");
        }
        //查看该用户所创建的有效邮箱账号
        List<Mailnumber> mailnum = mndao.findByStatusAndMailUserId(1L, mu);
        proservice.user(page, size, model);
        model.addAttribute("mailnum", mailnum);

        return "mail/wirtemail";
    }
*/

    /**
     * 删除邮件@SessionAttribute("userId") Long userId
     */
   /* @RequestMapping("alldelete")
    public String delete(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        //查找用户
        User user = udao.findOne(userId);
        String title = req.getParameter("title");
        Page<Pagemail> pagelist = null;
        Page<Inmaillist> pagemail = null;
        List<Map<String, Object>> maillist = null;
        //得到删除id
        String ids = req.getParameter("ids");
        if (("收件箱").equals(title)) {

            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该用户联系邮件的中间记录
                Mailreciver mailr = mrdao.findbyReciverIdAndmailId(user, Long.parseLong(st.nextToken()));
                if (!Objects.isNull(mailr)) {
                    //把删除的字段改为1
                    mailr.setDel(true);
                    mrdao.save(mailr);
                } else {
                    return "redirect:/notlimit";
                }
            }
            //分页及查找
            pagelist = mservice.recive(page, size, user, null, title);
            maillist = mservice.mail(pagelist);
        } else if (("发件箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该邮件
                Inmaillist inmail = imdao.findByMailUseridAndMailId(user, Long.parseLong(st.nextToken()));
                if (!Objects.isNull(inmail)) {
                    //把删除的字段改为1
                    inmail.setDel(true);
                    imdao.save(inmail);
                } else {
                    return "redirect:/notlimit";
                }
            }
            pagemail = mservice.inmail(page, size, user, null, title);
            maillist = mservice.maillist(pagemail);
        } else if (("草稿箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该邮件
                Inmaillist inmail = imdao.findByMailUseridAndMailId(user, Long.parseLong(st.nextToken()));
                if (!Objects.isNull(inmail)) {
                    imdao.delete(inmail);
                } else {
                    return "redirect:/notlimit";
                }
            }
            pagemail = mservice.inmail(page, size, user, null, title);
            maillist = mservice.maillist(pagemail);
        } else {
            //垃圾箱
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                Long mailid = Long.parseLong(st.nextToken());
                //查看中间表关于这条邮件的del字段
                List<Boolean> dellist = mrdao.findbyMailId(mailid);

                //判断中间表中关于这条邮件是否还有del字段为false的
                if (dellist.contains(false)) {
                    Mailreciver mailr = mrdao.findbyReciverIdAndmailId(user, mailid);
                    if (!Objects.isNull(mailr)) {
                        mrdao.delete(mailr);
                    } else {
                        return "redirect:/notlimit";
                    }
                } else {
                    Inmaillist imail = imdao.findOne(mailid);
                    //判断这条邮件的del字段是为true
                    if (imail.getDel().equals(true)) {
                        List<Mailreciver> mreciver = mrdao.findByMailId(mailid);
                        //循环删除关于这条邮件的所有中间表信息
                        for (Mailreciver mailreciver : mreciver) {
                            mrdao.delete(mailreciver);
                        }
                        imdao.delete(imail);
                    } else {
                        //这条邮件的del字段为false，则删除中间表信息
                        Mailreciver mailr = mrdao.findbyReciverIdAndmailId(user, mailid);
                        if (!Objects.isNull(mailr)) {
                            mrdao.delete(mailr);
                        } else {
                            return "redirect:/notlimit";
                        }
                    }
                }
            }
            pagelist = mservice.recive(page, size, user, null, title);
            maillist = mservice.mail(pagelist);
        }

        if (!Objects.isNull(pagelist)) {
            model.addAttribute("page", pagelist);
        } else {
            model.addAttribute("page", pagemail);
        }
        model.addAttribute("maillist", maillist);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";

    }
    */

    /**
     * 查看邮件
     *//*
    @RequestMapping("smail")
    public String index4(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model) {
        User mu = udao.findOne(userId);
        //邮件id
        Long id = Long.parseLong(req.getParameter("id"));
        //title
        String title = req.getParameter("title");
        //找到中间表信息
        if (("收件箱").equals(title) || ("垃圾箱").equals(title)) {
            Mailreciver mailr = mrdao.findbyReciverIdAndmailId(mu, id);
            mailr.setRead(true);
            mrdao.save(mailr);
        }

        //找到该邮件信息
        Inmaillist mail = imdao.findOne(id);
        String filetype = null;
        if (!Objects.isNull(mail.getMailFileid())) {
            String filepath = mail.getMailFileid().getAttachmentPath();
            System.out.println(filepath);
            if (mail.getMailFileid().getAttachmentType().startsWith("image")) {

                filetype = "img";
            } else {
                filetype = "appli";

            }
            model.addAttribute("filepath", filepath);
            model.addAttribute("filetype", filetype);
        }
        User pushuser = udao.findOne(mail.getMailUserid().getUserId());
        model.addAttribute("pushname", pushuser.getUserName());
        model.addAttribute("mail", mail);
        model.addAttribute("mess", title);
        model.addAttribute("file", mail.getMailFileid());

        return "mail/seemail";
    }
*/
//------------------------------------------------------------------------------------------------

    /*

     */
/**
 * 批量查看
 *//*

    @RequestMapping("watch")
    public String watch(@SessionAttribute("userId") Long userId, Model model, HttpServletRequest req,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        User user = udao.findOne(userId);
        String title = req.getParameter("title");
        String ids = req.getParameter("ids");
        Page<Pagemail> pagelist = null;
        List<Map<String, Object>> maillist = null;
        if (("收件箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该用户联系邮件的中间记录
                Mailreciver mailr = mrdao.findbyReciverIdAndmailId(user, Long.parseLong(st.nextToken()));
                if (mailr.getRead().equals(false)) {
                    mailr.setRead(true);
                } else {
                    mailr.setRead(false);
                }
                mrdao.save(mailr);
            }
            //分页及查找
            pagelist = mservice.recive(page, size, user, null, title);
        } else {
            //垃圾箱
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该用户联系邮件的中间记录
                Mailreciver mailr = mrdao.findbyReciverIdAndmailId(user, Long.parseLong(st.nextToken()));
                if (mailr.getRead().equals(false)) {
                    mailr.setRead(true);
                } else {
                    mailr.setRead(false);
                }
                mrdao.save(mailr);
            }
            //分页及查找
            pagelist = mservice.recive(page, size, user, null, title);
        }
        maillist = mservice.mail(pagelist);

        model.addAttribute("page", pagelist);
        model.addAttribute("maillist", maillist);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";
    }

    */
/**
 * 批量标星
 *//*

    @RequestMapping("star")
    public String star(@SessionAttribute("userId") Long userId, Model model, HttpServletRequest req,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "10") int size) {
        User user = udao.findOne(userId);
        String title = req.getParameter("title");
        String ids = req.getParameter("ids");
        Page<Pagemail> pagelist = null;
        Page<Inmaillist> pagemail = null;
        List<Map<String, Object>> maillist = null;

        if (("收件箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {

                //找到该用户联系邮件的中间记录
                Mailreciver mailr = mrdao.findbyReciverIdAndmailId(user, Long.parseLong(st.nextToken()));
                if (mailr.getStar().equals(false)) {
                    mailr.setStar(true);
                } else {
                    mailr.setStar(false);
                }
                mrdao.save(mailr);
            }
            //分页及查找
            pagelist = mservice.recive(page, size, user, null, title);
            maillist = mservice.mail(pagelist);
        } else if (("发件箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该邮件
                Inmaillist inmail = imdao.findByMailUseridAndMailId(user, Long.parseLong(st.nextToken()));
                if (inmail.getStar().equals(false)) {
                    inmail.setStar(true);
                } else {
                    inmail.setStar(false);
                }
                imdao.save(inmail);
            }
            pagemail = mservice.inmail(page, size, user, null, title);
            maillist = mservice.maillist(pagemail);
        } else if (("草稿箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该邮件
                Inmaillist inmail = imdao.findByMailUseridAndMailId(user, Long.parseLong(st.nextToken()));
                if (inmail.getStar().equals(false)) {
                    inmail.setStar(true);
                } else {
                    inmail.setStar(false);
                }
                imdao.save(inmail);
            }
            pagemail = mservice.inmail(page, size, user, null, title);
            maillist = mservice.maillist(pagemail);
        } else {
            //垃圾箱
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该用户联系邮件的中间记录
                Mailreciver mailr = mrdao.findbyReciverIdAndmailId(user, Long.parseLong(st.nextToken()));
                if (mailr.getStar().equals(false)) {
                    mailr.setStar(true);
                } else {
                    mailr.setStar(false);
                }
                mrdao.save(mailr);
            }
            //分页及查找
            pagelist = mservice.recive(page, size, user, null, title);
            maillist = mservice.mail(pagelist);
        }

        if (!Objects.isNull(pagelist)) {
            model.addAttribute("page", pagelist);
        } else {
            model.addAttribute("page", pagemail);
        }
        model.addAttribute("maillist", maillist);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";
    }
*/


    /*  *//**
     * 账号各种排序
     * 和查询
     *//*
    @RequestMapping("mailpaixu")
    public String paixu(HttpServletRequest request, @SessionAttribute("userId") Long userId, Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        // 通过发布人id找用户
        User tu = udao.findOne(userId);
        //得到传过来的值
        String val = null;
        if (!StringUtil.isEmpty(request.getParameter("val"))) {

            val = request.getParameter("val");
        }
        Page<Mailnumber> pagelist = mservice.index(page, size, tu, val, model);
        List<Map<String, Object>> list = mservice.up(pagelist);
        model.addAttribute("account", list);
        model.addAttribute("page", pagelist);
        model.addAttribute("url", "mailpaixu");

        return "mail/mailtable";
    }*/


    /**
     * 发送邮件
     *
     * @throws IOException
     * @throws IllegalStateException
     */
   /* @RequestMapping("pushmail")
    public String push(@RequestParam("file") MultipartFile file, HttpServletRequest request, @Valid Inmaillist mail, BindingResult br, @SessionAttribute("userId") Long userId) throws IllegalStateException, IOException {
        User tu = udao.findOne(userId);

        String name = null;
        Attachment attaid = null;
        Mailnumber number = null;
        StringTokenizer st = null;
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            request.setAttribute("errormess", list.get(0).toString());
        } else {
            if (!StringUtil.isEmpty(request.getParameter("fasong"))) {
                name = request.getParameter("fasong");
            }
            if (!StringUtil.isEmpty(name)) {
                if (!StringUtil.isEmpty(file.getOriginalFilename())) {
                    attaid = mservice.upload(file, tu);
                    attaid.setModel("mail");
                    AttDao.save(attaid);
                }
                //发送成功
                mail.setPush(true);

            } else {
                //存草稿
                mail.setInReceiver(null);
            }
            mail.setMailFileid(attaid);
            mail.setMailCreateTime(new Date());
            mail.setMailUserid(tu);
            if (!mail.getInmail().equals(0)) {
                number = mndao.findOne(mail.getInmail());
                mail.setMailNumberid(number);
            }
            //存邮件
            Inmaillist imail = imdao.save(mail);
            if (!StringUtil.isEmpty(name)) {
                if (mservice.isContainChinese(mail.getInReceiver())) {
                    // 分割任务接收人
                    StringTokenizer st2 = new StringTokenizer(mail.getInReceiver(), ";");
                    while (st2.hasMoreElements()) {
                        User reciver = udao.findid(st2.nextToken());
                        Mailreciver mreciver = new Mailreciver();
                        mreciver.setMailId(imail);
                        mreciver.setReciverId(reciver);
                        mrdao.save(mreciver);
                    }
                } else {
                    if (mail.getInReceiver().contains(";")) {
                        st = new StringTokenizer(mail.getInReceiver(), ";");
                    } else {
                        st = new StringTokenizer(mail.getInReceiver(), "；");
                    }
                    while (st.hasMoreElements()) {
                        if (!StringUtil.isEmpty(file.getOriginalFilename())) {
                            mservice.pushmail(number.getMailAccount(), number.getPassword(), st.nextToken(), number.getMailUserName(), mail.getMailTitle(),
                                    mail.getContent(), attaid.getAttachmentPath(), attaid.getAttachmentName());
                        } else {
                            mservice.pushmail(number.getMailAccount(), number.getPassword(), st.nextToken(), number.getMailUserName(), mail.getMailTitle(),
                                    mail.getContent(), null, null);
                        }
                    }
                }

            }
        }
        return "redirect:/mail";
    }
*/

    /**
     * 用户姓名查找
     */
    @RequestMapping("names")
    public String serch(Model model, HttpServletRequest req, @SessionAttribute("userId") Long userId,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pa = new PageRequest(page, size);
        String name = null;
        String qufen = null;
        Page<User> pageuser = null;
        List<User> userlist = null;

        if (!StringUtil.isEmpty(req.getParameter("title"))) {
            name = req.getParameter("title").trim();
        }
        if (!StringUtil.isEmpty(req.getParameter("qufen"))) {
            qufen = req.getParameter("qufen").trim();

            System.out.println("111");
            if (StringUtil.isEmpty(name)) {
                // 查询部门下面的员工
                pageuser = udao.findByFatherId(userId, pa);
            } else {
                // 查询名字模糊查询员工
                pageuser = udao.findbyFatherId(name, userId, pa);
            }

        } else {
            System.out.println("222");
            if (StringUtil.isEmpty(name)) {
                //查看用户并分页
                pageuser = udao.findAll(pa);
            } else {
                pageuser = udao.findbyUserNameLike(name, pa);
            }
        }
        userlist = pageuser.getContent();
        // 查询部门表
        Iterable<Dept> deptlist = ddao.findAll();
        // 查职位表
        Iterable<Position> poslist = pdao.findAll();
        model.addAttribute("emplist", userlist);
        model.addAttribute("page", pageuser);
        model.addAttribute("deptlist", deptlist);
        model.addAttribute("poslist", poslist);
        model.addAttribute("url", "names");

        return "common/recivers";

    }

    /**
     * 恢复删除
     *//*
    @RequestMapping("refresh")
    public String refresh(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size) {
        //查找用户
        User user = udao.findOne(userId);
        String title = req.getParameter("title");
        Page<Pagemail> pagelist = null;
        List<Map<String, Object>> maillist = null;
        //得到恢复删除id
        String ids = req.getParameter("ids");

        StringTokenizer st = new StringTokenizer(ids, ",");
        while (st.hasMoreElements()) {
            //找到该用户联系邮件的中间记录
            Mailreciver mailr = mrdao.findbyReciverIdAndmailId(user, Long.parseLong(st.nextToken()));
            if (!Objects.isNull(mailr)) {
                mailr.setDel(false);
                mrdao.save(mailr);
            } else {
                return "redirect:/notlimit";
            }
        }
        //分页及查找
        pagelist = mservice.recive(page, size, user, null, title);
        maillist = mservice.mail(pagelist);
        model.addAttribute("page", pagelist);
        model.addAttribute("maillist", maillist);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);

        return "mail/mailbody";

    }*/
    //===========================================

    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private MailServiceV2 mailServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private MailReciverServiceV2 mailReciverServiceV2;
    @Resource
    private InMailListServiceV2 inMailListServiceV2;
    @Resource
    private ProcessServiceV2 processServiceV2;
    @Resource
    private AttachmentServiceV2 attachmentServiceV2;
    @Resource
    private MailNumberServiceV2 mailNumberServiceV2;

    /**
     * 账号管理
     */
    @RequestMapping("accountmanage")
    public String account(@SessionAttribute("userId") Long userId, Model model,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size) {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        PageHelper.startPage(page, size);
        List<MailNumberPO> mailNumberPOList = mailNumberServiceV2.getMailNumberPOListByUserId(userPO);
        PageInfo pageInfo = new PageInfo(mailNumberPOList);
        List<Map<String, Object>> mapList = mailNumberServiceV2.encapsulationMailNumberPO(mailNumberPOList);
        model.addAttribute("mapList", mapList);
        model.addAttribute("page", pageInfo);
        model.addAttribute("url", "mailpaixu");
        return "mail/mailmanage";
    }

    /**
     * 新增账号,修改账号页面
     */
    @RequestMapping("addaccount")
    public String add(@SessionAttribute("userId") Long userId, Model model, HttpServletRequest req) {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        model.addAttribute("username", userPO.getUserName());

        MailNumberPO mailNumberPO = null;
        if (StringUtil.isEmpty(req.getParameter("id"))) {
            List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("aoa_mailnumber");
            List<StatusPO> statusPOList = statusServiceV2.getStatusPOByStatusModel("aoa_mailnumber");
            model.addAttribute("typePOList", typePOList);
            model.addAttribute("statusPOList", statusPOList);

           /* if (!StringUtil.isEmpty((String) req.getAttribute("errormess"))) {
                mailn = (Mailnumber) req.getAttribute("mail");
                req.setAttribute("errormess", req.getAttribute("errormess"));
                model.addAttribute("mails", mailn);
                model.addAttribute("type", tydao.findname(mailn.getMailType()));
                model.addAttribute("status", sdao.findname(mailn.getStatus()));

            } else if (!StringUtil.isEmpty((String) req.getAttribute("success"))) {
                mailn = (Mailnumber) req.getAttribute("mail");
                req.setAttribute("success", "fds");
                model.addAttribute("mails", mailn);
                model.addAttribute("type", tydao.findname(mailn.getMailType()));
                model.addAttribute("status", sdao.findname(mailn.getStatus()));
            }*/

        } else {
            Long id = Long.parseLong(req.getParameter("id"));
            MailNumberPO mailNumberPO1 = mailNumberServiceV2.getMailNumberPOByMailNumberPOId(id);
            model.addAttribute("typeName", typeServiceV2.getTypePOByTypeId(mailNumberPO1.getMailNumUserId()).getTypeName());
            model.addAttribute("statusName", statusServiceV2.getStatusPOByStatusId(mailNumberPO1.getStatus()).getStatusName());
            model.addAttribute("mails", mailNumberPO1);
        }
        return "mail/addaccounts";
    }

    /**
     * 存邮箱账号
     */
    @RequestMapping("saveaccount")
    public String save(HttpServletRequest request, @Valid MailNumberVO mailNumberV2, BindingResult br, @SessionAttribute("userId") Long userId) {
        request.setAttribute("mail", mailNumberV2);
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            request.setAttribute("errormess", list.get(0).toString());
            System.out.println("list错误的实体类信息：" + mailNumberV2);
            System.out.println("list错误详情:" + list);
            System.out.println("list错误第一条:" + list.get(0));
            System.out.println("啊啊啊错误的信息——：" + list.get(0).toString());
        } else {
            mailNumberServiceV2.insertOrUpdateMailNumberPO(mailNumberV2, userId);
            request.setAttribute("success", "执行成功！");
        }
        return "forward:/addaccount";
    }

    /**
     * 删除账号
     */
    @RequestMapping("delete")
    public String edit(HttpServletRequest request, @SessionAttribute("userId") Long userId) {
        //得到账号id
        Long mailNumberPOId = Long.parseLong(request.getParameter("id"));
        MailNumberPO mailNumberPO = mailNumberServiceV2.getMailNumberPOByMailNumberPOId(mailNumberPOId);
        if (mailNumberPO.getMailNumUserId().equals(userId)) {
            mailNumberServiceV2.deleteMailNumberPO(mailNumberPO.getMailNumberId());
        } else {
            return "redirect:/notlimit";
        }
        return "redirect:/accountmanage";
    }
//-------------------------------------------

    /**
     * 邮件管理主页
     *
     * @return
     */
    @RequestMapping("mail")
    public String index(@SessionAttribute("userId") Long userId, Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        //中间表信息找未读邮件
        List<MailReciverPO> noReadMailReciverPOList = mailReciverServiceV2.getMailReciverPOByReadAndDelAndUserId(false, false, userId);
        model.addAttribute("noReadSize", noReadMailReciverPOList.size());//没有读的条数（收件箱没有读的条数）
        // 已删除的条数
        List<MailReciverPO> delMailReciverPO = mailReciverServiceV2.getDelMailReciverPOList(true, userId);
        model.addAttribute("dustbinSize", delMailReciverPO.size());//垃圾箱

        //已创建但未发送
        List<InMailListPO> noPushInMailListPOList = inMailListServiceV2.getInMailListPOListByPushAndDelAndUserId(false, false, userId);
        model.addAttribute("noPushSize", noPushInMailListPOList.size());//没有发送的（草稿箱）
        //已经发送的条数
        List<InMailListPO> pushInMailListPOList = inMailListServiceV2.getInMailListPOListByPushAndDelAndUserId(true, false, userId);
        model.addAttribute("pushSize", pushInMailListPOList.size());//（发件箱）

        List<Pagemail> pageMailList = mailServiceV2.recive(page, size, userId, "收件箱");
        PageInfo pageInfo = new PageInfo(pageMailList);
        model.addAttribute("page", pageInfo);
        List<Map<String, Object>> mapList = mailServiceV2.mail(pageMailList);

        model.addAttribute("mapList", mapList);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", "收件箱");
        model.addAttribute("sort", "&title=收件箱");
        return "mail/mail";
    }

    /**
     * 邮件管理的收，发，草，垃圾
     *
     * @param req
     * @param userId
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("amail")
    public String index3(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        PageHelper.startPage(page, size);
        String title = req.getParameter("title");
        List<Pagemail> pagemailList = null;
        List<InMailListPO> inMailListPOList = null;
        List<Map<String, Object>> mapList = null;
        if (("收件箱").equals(title) || ("垃圾箱").equals(title)) {
            pagemailList = mailServiceV2.recive(page, size, userId, title);
            mapList = mailServiceV2.mail(pagemailList);
        } else if (("发件箱").equals(title) || ("草稿箱").equals(title)) {
            inMailListPOList = mailServiceV2.inmail(page, size, userId, title);
            mapList = mailServiceV2.maillist(inMailListPOList);
        }

        if (!Objects.isNull(pagemailList)) {
            model.addAttribute("page", pagemailList);
        } else {
            model.addAttribute("page", inMailListPOList);
        }

        model.addAttribute("sort", "&title=" + title);
        model.addAttribute("mapList", mapList);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/allmail";
    }

    /**
     * 邮箱管理的类型（邮件，通知，公告)
     *
     * @param userId
     * @param model
     * @param req
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("mailtitle")
    public String serch(@SessionAttribute("userId") Long userId, Model model, HttpServletRequest req,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        String title = req.getParameter("title");// (收发草拉）
        String val = null;//(邮件，通知，公告）
        if (!StringUtil.isEmpty(req.getParameter("val"))) {
            val = req.getParameter("val");
        }
        List<Pagemail> pagemailList = null;
        List<Pagemail> pagemailList2 = new ArrayList<>();//过滤后的
        List<InMailListPO> inMailListPOList = null;
        List<InMailListPO> inMailListPOList2 = new ArrayList<>();//过滤后的
        List<Map<String, Object>> mapListAll = null;
        String typeName = null;
        if (("收件箱").equals(title) || ("垃圾箱").equals(title)) {
            pagemailList = mailServiceV2.recive(page, size, userId, title);
            for (Pagemail pagemail : pagemailList) {
                typeName = typeServiceV2.getTypePOByTypeId(pagemail.getMailType()).getTypeName();
                if (val.equals(typeName)) {
                    pagemailList2.add(pagemail);
                }
            }
            mapListAll = mailServiceV2.mail(pagemailList2);
        } else if (("发件箱").equals(title) || ("草稿箱").equals(title)) {
            inMailListPOList = mailServiceV2.inmail(page, size, userId, title);
            for (InMailListPO inMailListPO : inMailListPOList) {
                typeName = typeServiceV2.getTypePOByTypeId(inMailListPO.getMailType()).getTypeName();
                if (val.equals(typeName)) {
                    inMailListPOList2.add(inMailListPO);
                }
            }
            mapListAll = mailServiceV2.maillist(inMailListPOList2);
        }
        if (!Objects.isNull(pagemailList)) {
            model.addAttribute("page", pagemailList);
        } else {
            model.addAttribute("page", inMailListPOList);
        }
        if (val != null) {
            model.addAttribute("sort", "&title=" + title + "&val=" + val);
        } else {
            model.addAttribute("sort", "&title=" + title);
        }
        model.addAttribute("mapList", mapListAll);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";
    }


    /**
     * 写信
     */
    @RequestMapping("wmail")
    public String index2(Model model, @SessionAttribute("userId") Long userId, HttpServletRequest request,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        //得到编辑过来的id
        String id = null;
        if (!StringUtil.isEmpty(request.getParameter("id"))) {
            id = request.getParameter("id");
        }
        //回复那边过来的
        String huifu = null;
        if (!StringUtil.isEmpty(id)) {
            Long mailId = Long.parseLong(id);
            //找到这条邮件
            InMailListPO inMailListPO = inMailListServiceV2.getInMailListPOByInMailListPOId(mailId);
            if (!StringUtil.isEmpty(request.getParameter("huifu"))) {
                huifu = request.getParameter("huifu");
                model.addAttribute("title", huifu + inMailListPO.getMailTitle());//邮件主题
                model.addAttribute("content", inMailListPO.getMailContent());//内容
                model.addAttribute("id", "回复");
            } else {
                //应该是转发的
                model.addAttribute("title", "转发" + inMailListPO.getMailTitle());
                model.addAttribute("content", inMailListPO.getMailContent());
                model.addAttribute("attchmentListPO", attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(inMailListPO.getMailFileId()));
                model.addAttribute("id", "转发");
            }
            model.addAttribute("status", statusServiceV2.getStatusPOByStatusId(inMailListPO.getMailStatusId()));
            model.addAttribute("type", typeServiceV2.getTypePOByTypeId(inMailListPO.getMailType()));
        } else {
            List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("aoa_in_mail_list");
            List<StatusPO> statusPOList = statusServiceV2.getStatusPOByStatusModel("aoa_in_mail_list");
            model.addAttribute("typelist", typePOList);
            model.addAttribute("statuslist", statusPOList);
            model.addAttribute("id", "新发");
        }
        //查看该用户所创建的有效邮箱账号
        List<MailNumberPO> mailNumberPOList = mailServiceV2.getMailNumberPOListByStatusAndMailUserId(userId, 1L);
        processServiceV2.setModel(model, userId, page, size);//通讯录
        model.addAttribute("mailnum", mailNumberPOList);
        return "mail/wirtemail";
    }

    /**
     * 发送邮件
     *
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("pushmail")
    public String push(@RequestParam("file") MultipartFile file, HttpServletRequest request, @Valid InMailListVO inMailListVO, BindingResult br, @SessionAttribute("userId") Long userId) throws IllegalStateException, IOException {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        String name = null;
        AttachmentListPO attachmentListPO = null;
        MailNumberPO mailNumberPO = null;
        StringTokenizer st = null;
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());//map强转为list
            request.setAttribute("errormess", list.get(0).toString());
        } else {
            if (!StringUtil.isEmpty(request.getParameter("fasong"))) {
                name = request.getParameter("fasong");
            }

            if (!StringUtil.isEmpty(file.getOriginalFilename())) {
                attachmentListPO = mailServiceV2.uploadAttachmentListPO(file, userPO);
                attachmentServiceV2.insertAttachmentListPOSetModel(attachmentListPO, "mail");
            }
            if (!StringUtil.isEmpty(name)) {
                //name存在，代表发送
                //修改发送字段为以发送
                inMailListVO.setPush(true);
            } else {
                //存草稿
                inMailListVO.setInReceiver(null);//接收人设置为null
            }
            if (attachmentListPO != null) {
                inMailListVO.setMailFile(AttachmentFactoryVO.createAttachmentVO(attachmentListPO));

            }

            inMailListVO.setMailCreateTime(new Date());
            inMailListVO.setMailUserVOId(UserFactoryVO.createUserVO(userPO));
            if (!inMailListVO.getInmail().equals(0L)) {
                mailNumberPO = mailNumberServiceV2.getMailNumberPOByMailNumberPOId(inMailListVO.getInmail());
                inMailListVO.setMailNumberId(MailNumberVOFactory.createMailNumberVOByMailNumberPO(mailNumberPO));
            }
            //存邮件
            InMailListPO inMailListPO = inMailListServiceV2.insertInMailListPO(inMailListVO);

            if (!StringUtil.isEmpty(name)) {
//                if (mailServiceV2.isContainChinese(inMailListVO.getInReceiver())) {
                // 分割任务接收人
                StringTokenizer st2 = new StringTokenizer(inMailListVO.getInReceiver(), ";");
                while (st2.hasMoreElements()) {
                    UserPO reciverUserPO = userServiceV2.getUserPOByUsername(st2.nextToken());

                    MailReciverPO mailReciverPO = new MailReciverPO();
                    mailReciverPO.setMailId(inMailListPO.getMailId());//在中间表设置邮件ID
                    mailReciverPO.setMailReciverId(reciverUserPO.getUserId());
                    mailReciverServiceV2.insertMailReciverPO(inMailListPO.getMailId(), reciverUserPO.getUserId());
                }
            } else {
                if (inMailListVO.getInReceiver().contains(";")) {
                    st = new StringTokenizer(inMailListVO.getInReceiver(), ";");
                } else {
                    st = new StringTokenizer(inMailListVO.getInReceiver(), "；");
                }
                while (st.hasMoreElements()) {
                    if (!StringUtil.isEmpty(file.getOriginalFilename())) {
                        mailServiceV2.pushmail(mailNumberPO.getMailAccount(), mailNumberPO.getPassword(), st.nextToken(), mailNumberPO.getMailUserName(), inMailListVO.getMailTitle(),
                                inMailListVO.getContent(), attachmentListPO.getAttachmentPath(), attachmentListPO.getAttachmentName());
                    } else {
                        mailServiceV2.pushmail(mailNumberPO.getMailAccount(), mailNumberPO.getPassword(), st.nextToken(), mailNumberPO.getMailUserName(), inMailListVO.getMailTitle(),
                                inMailListVO.getContent(), null, null);
                    }
                }
            }
        }
        return "redirect:/mail";
    }

    /**
     * 删除邮件@SessionAttribute("userId") Long userId
     */
    @RequestMapping("alldelete")
    public String delete(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "size", defaultValue = "10") int size) {
        String title = req.getParameter("title");
        List<Pagemail> pagemailList = null;
        List<InMailListPO> inMailListPOList = null;
        List<Map<String, Object>> mapList = null;
        //得到删除邮件id
        String ids = req.getParameter("ids");
        if (("收件箱").equals(title)) {

            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该用户联系邮件的中间记录
                MailReciverPO mailReciverPO = mailReciverServiceV2.getMailReciverPOByMailIdAndUserId(userId, Long.parseLong(st.nextToken()));
                if (!Objects.isNull(mailReciverPO)) {
                    //把删除的字段改为1
                    mailReciverServiceV2.updateMailReciverPODel(mailReciverPO, 1);
                } else {
                    return "redirect:/notlimit";
                }
            }
            //分页及查找
            pagemailList = mailServiceV2.recive(page, size, userId, title);
            mapList = mailServiceV2.mail(pagemailList);
        } else if (("发件箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该邮件
                InMailListPO inMailListPO = inMailListServiceV2.getInMailListPOByInMailListPOId(Long.parseLong(st.nextToken()));
                if (!Objects.isNull(inMailListPO)) {
                    //把删除的字段改为1
                    inMailListServiceV2.updateInMailListPODel(inMailListPO);
                } else {
                    return "redirect:/notlimit";
                }
            }
            inMailListPOList = mailServiceV2.inmail(page, size, userId, title);
            mapList = mailServiceV2.maillist(inMailListPOList);
        } else if (("草稿箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该邮件
                InMailListPO inMailListPO = inMailListServiceV2.getInMailListPOByInMailListPOId(Long.parseLong(st.nextToken()));
                if (!Objects.isNull(inMailListPO)) {
                    inMailListServiceV2.deleteInMailListPO(inMailListPO.getMailId());
                } else {
                    return "redirect:/notlimit";
                }
            }
            inMailListPOList = mailServiceV2.inmail(page, size, userId, title);
            mapList = mailServiceV2.maillist(inMailListPOList);
        } else {
            //垃圾箱
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                Long mailId = Long.parseLong(st.nextToken());
                //查看中间表关于这条邮件的del字段
                List<Boolean> delList = mailReciverServiceV2.getDelByMailReciverPOId(mailId);
                //判断中间表中关于这条邮件是否还有del字段为false的
                if (delList.contains(false)) {
                    MailReciverPO mailReciverPO = mailReciverServiceV2.getMailReciverPOByMailIdAndUserId(userId, mailId);
                    if (!Objects.isNull(mailReciverPO)) {
                        mailReciverServiceV2.deleteMailReciverPO(mailReciverPO.getPkId());
                    } else {
                        return "redirect:/notlimit";
                    }
                } else {
                    InMailListPO inMailListPO = inMailListServiceV2.getInMailListPOByInMailListPOId(mailId);

                    //判断这条邮件的del字段是为true
                    if (inMailListPO.getMailDel().equals(1)) {
                        List<MailReciverPO> mailReciverPOList = mailReciverServiceV2.getMailReciverPOByMailId(mailId);
                        //循环删除关于这条邮件的所有中间表信息
                        for (MailReciverPO mailReciverPO : mailReciverPOList) {
                            mailReciverServiceV2.deleteMailReciverPO(mailReciverPO.getPkId());
                        }
                        inMailListServiceV2.deleteInMailListPO(mailId);
                    } else {
                        //这条邮件的del字段为false，则删除中间表信息
                        MailReciverPO mailReciverPO = mailReciverServiceV2.getMailReciverPOByMailIdAndUserId(userId, mailId);
                        if (!Objects.isNull(mailReciverPO)) {
                            mailReciverServiceV2.deleteMailReciverPO(mailReciverPO.getPkId());
                        } else {
                            return "redirect:/notlimit";
                        }
                    }
                }
            }
            pagemailList = mailServiceV2.recive(page, size, userId, title);
            mapList = mailServiceV2.mail(pagemailList);
        }

        if (!Objects.isNull(pagemailList)) {
            model.addAttribute("page", pagemailList);
        } else {
            model.addAttribute("page", inMailListPOList);
        }
        model.addAttribute("mapList", mapList);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";

    }

    /**
     * 查看邮件
     */
    @RequestMapping("smail")
    public String index4(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model) {
        Long mailId = Long.parseLong(req.getParameter("id"));//邮件ID
        //title
        String title = req.getParameter("title");

        //找到中间表信息
        if (("收件箱").equals(title) || ("垃圾箱").equals(title)) {
            MailReciverPO mailReciverPO = mailReciverServiceV2.getMailReciverPOByMailIdAndUserId(userId, mailId);
            mailReciverServiceV2.updateMailReciverPORead(mailReciverPO, 1);
        }
        //找到该邮件信息
        InMailListPO inMailListPO = inMailListServiceV2.getInMailListPOByInMailListPOId(mailId);
        String fileType = null;

        if (!Objects.isNull(inMailListPO.getMailFileId())) {
            AttachmentListPO attachmentListPO = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(inMailListPO.getMailFileId());//附件信息
            String filePath = attachmentListPO.getAttachmentPath();
            if (attachmentListPO.getAttachmentType().startsWith("image")) {
                fileType = "img";
            } else {
                fileType = "appli";
            }
            model.addAttribute("filepath", filePath);
            model.addAttribute("filetype", fileType);
            model.addAttribute("attachmentListPO", attachmentListPO);//附件信息
        }
        //发件人信息
        UserPO pushUserPO = userServiceV2.getUserPOByUserId(inMailListPO.getMailInPushUserId());
        model.addAttribute("pushname", pushUserPO.getUserName());//发件人名
        model.addAttribute("mail", inMailListPO);//邮件信息
        model.addAttribute("mailCreateTime", new Timestamp(inMailListPO.getMailCreateTime().getTime()));//邮件的创建时间
        model.addAttribute("mess", title);
        return "mail/seemail";
    }


    /**
     * 批量查看
     */
    @RequestMapping("watch")
    public String watch(@SessionAttribute("userId") Long userId, Model model, HttpServletRequest req,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        String title = req.getParameter("title");
        String ids = req.getParameter("ids");//多个邮件ID
        List<Pagemail> pageMailList = null;
        List<Map<String, Object>> mapList = null;
        if (("收件箱").equals(title) || ("垃圾箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该用户联系邮件的中间记录
                MailReciverPO mailReciverPO = mailReciverServiceV2.getMailReciverPOByMailIdAndUserId(userId, Long.parseLong(st.nextToken()));
                if (mailReciverPO.getIsRead().equals(0)) {
                    mailReciverServiceV2.updateMailReciverPORead(mailReciverPO, 1);
                } else {
                    mailReciverServiceV2.updateMailReciverPORead(mailReciverPO, 0);
                }
            }
            //分页及查找
            pageMailList = mailServiceV2.recive(page, size, userId, title);
        }
        mapList = mailServiceV2.mail(pageMailList);
        model.addAttribute("page", pageMailList);
        model.addAttribute("mapList", mapList);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";
    }

    /**
     * 批量标星
     */
    @RequestMapping("star")
    public String star(@SessionAttribute("userId") Long userId, Model model, HttpServletRequest req,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "size", defaultValue = "10") int size) {
        String title = req.getParameter("title");
        String ids = req.getParameter("ids");
        List<Pagemail> pageMailList = null;
        List<InMailListPO> inMailListPOList = null;
        List<Map<String, Object>> mapList = null;
        if (("收件箱").equals(title) || ("草稿箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该用户联系邮件的中间记录
                MailReciverPO mailReciverPO = mailReciverServiceV2.getMailReciverPOByMailIdAndUserId(userId, Long.parseLong(st.nextToken()));
                if (mailReciverPO.getIsStar().equals(0)) {
                    mailReciverServiceV2.updateMailReciverPOStar(mailReciverPO, 1);
                } else {
                    mailReciverServiceV2.updateMailReciverPOStar(mailReciverPO, 0);
                }
            }
            pageMailList = mailServiceV2.recive(page, size, userId, title);
            mapList = mailServiceV2.mail(pageMailList);
        } else if (("发件箱").equals(title) || ("草稿箱").equals(title)) {
            StringTokenizer st = new StringTokenizer(ids, ",");
            while (st.hasMoreElements()) {
                //找到该邮件
                InMailListPO inMailListPO = inMailListServiceV2.getInMailListPOByInMailListPOId(Long.parseLong(st.nextToken()));
                if (inMailListPO.getMailStar().equals(0)) {
                    inMailListServiceV2.updateInMailListPOStar(inMailListPO, 1);
                }
            }
            inMailListPOList = mailServiceV2.inmail(page, size, userId, title);
            mapList = mailServiceV2.maillist(inMailListPOList);
        }
        if (!Objects.isNull(pageMailList)) {
            model.addAttribute("page", pageMailList);
        } else {
            model.addAttribute("page", inMailListPOList);
        }

        model.addAttribute("mapList", mapList);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";
    }


    /**
     * 恢复删除
     */
    @RequestMapping("refresh")
    public String refresh(HttpServletRequest req, @SessionAttribute("userId") Long userId, Model model,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "size", defaultValue = "10") int size) {
        String title = req.getParameter("title");
        String ids = req.getParameter("ids");
        List<Pagemail> pageMailList = null;
        List<Map<String, Object>> mapList = null;

        StringTokenizer st = new StringTokenizer(ids, ",");
        while (st.hasMoreElements()) {
            //找到该用户联系邮件的中间记录
            MailReciverPO mailReciverPO = mailReciverServiceV2.getMailReciverPOByMailIdAndUserId(userId, Long.parseLong(st.nextToken()));

            if (!Objects.isNull(mailReciverPO)) {
                mailReciverServiceV2.updateMailReciverPODel(mailReciverPO, 0);
            } else {
                return "redirect:/notlimit";
            }
        }
        //分页及查找
        pageMailList = mailServiceV2.recive(page, size, userId, title);
        mapList = mailServiceV2.mail(pageMailList);
        model.addAttribute("page", pageMailList);
        model.addAttribute("mapList", mapList);
        model.addAttribute("url", "mailtitle");
        model.addAttribute("mess", title);
        return "mail/mailbody";

    }

    /**
     * 账号各种排序
     * 和查询
     */
    @RequestMapping("mailpaixu")
    public String paixu(HttpServletRequest request, @SessionAttribute("userId") Long userId, Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);
        //得到传过来的值
        String val = null;
        if (!StringUtil.isEmpty(request.getParameter("val"))) {
            val = request.getParameter("val");
        }
        List<MailNumberPO>mailNumberPOList = mailNumberServiceV2.selectMailNumberPO(page,size,val,model);
        PageInfo pageInfo = new PageInfo(mailNumberPOList);
        List<Map<String, Object>> mapList = mailNumberServiceV2.encapsulationMailNumberPO(mailNumberPOList);
        model.addAttribute("mapList", mapList);
        model.addAttribute("page", pageInfo);
        model.addAttribute("url", "mailpaixu");

        return "mail/mailtable";
    }

}
