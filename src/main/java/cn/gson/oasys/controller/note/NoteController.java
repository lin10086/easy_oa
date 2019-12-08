package cn.gson.oasys.controller.note;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.*;
import cn.gson.oasys.ServiceV2.fileV2.FileServiceV2;
import cn.gson.oasys.ServiceV2.noteV2.CatalogPOServiceV2;
import cn.gson.oasys.ServiceV2.noteV2.NoteListPOServiceV2;
import cn.gson.oasys.ServiceV2.noteV2.NoteServiceV2;
import cn.gson.oasys.ServiceV2.noteV2.ReceiverNotePOServiceV2;
import cn.gson.oasys.mappers.NoteListPOMapper;
import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.factoryvo.UserFactoryVO;
import cn.gson.oasys.vo.noteVO.NoteListVO;
import org.apache.commons.io.IOUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.util.StringUtil;

import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.MapToList;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.model.dao.notedao.AttachmentDao;
import cn.gson.oasys.model.dao.notedao.CatalogDao;
import cn.gson.oasys.model.dao.notedao.CatalogService;
import cn.gson.oasys.model.dao.notedao.NoteDao;
import cn.gson.oasys.model.dao.notedao.NoteService;
import cn.gson.oasys.model.dao.notedao.NoteUserDao;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.user.DeptDao;
import cn.gson.oasys.model.dao.user.PositionDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.note.Attachment;
import cn.gson.oasys.model.entity.note.Catalog;
import cn.gson.oasys.model.entity.note.Note;
import cn.gson.oasys.model.entity.system.SystemStatusList;
import cn.gson.oasys.model.entity.system.SystemTypeList;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.file.FileServices;
import cn.gson.oasys.services.process.ProcessService;

@Controller
@RequestMapping("/")
public class NoteController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileServices fs;
    @Autowired
    private NoteDao noteDao;
    @Autowired
    private NoteService NoteService;
    @Autowired
    private CatalogDao catalogDao;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private TypeDao typeDao;
    @Autowired
    private StatusDao statusDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AttachmentDao attDao;
    @Autowired
    private NoteUserDao noteUserDao;
    @Autowired
    private ProcessService pservice;
    @Autowired
    private DeptDao ddao;
    @Autowired
    private PositionDao pdao;

    Attachment att;
    List<Note> noteList;
    List<Catalog> cataloglist = new ArrayList<Catalog>();
    List<SystemTypeList> type;
    List<SystemStatusList> status;

    /*	// 笔记主界面
	@RequestMapping(value = "noteview", method = RequestMethod.GET)
	public String test(Model model, HttpServletRequest request, HttpSession session,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "baseKey", required = false) String baseKey,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "time", required = false) String time,
			@RequestParam(value = "icon", required = false) String icon) {
		Long userid = Long.parseLong(session.getAttribute("userId") + "");
		cataloglist = (List<Catalog>) catalogDao.findcatauser(userid);
		setSomething(baseKey, type, status, time, icon, model,null,null);
		Page<Note> upage=NoteService.sortpage(page, baseKey, userid,null,null,null, type, status, time);
		model.addAttribute("sort", "&userid="+userid);
		paging(model, upage);
		typestatus(request);
		model.addAttribute("url", "notewrite");
		model.addAttribute("calist", cataloglist);
		return "note/noteview";
	}*/

    /*private void typestatus(HttpServletRequest request) {
        type = (List<SystemTypeList>) typeDao.findByTypeModel("aoa_note_list");
        status = (List<SystemStatusList>) statusDao.findByStatusModel("aoa_note_list");
        request.setAttribute("typelist", type);
        request.setAttribute("statuslist", status);
    }*/

   /* //分页
    private void paging(Model model, Page<Note> upage) {
        model.addAttribute("nlist", upage.getContent());
        model.addAttribute("page", upage);
//		model.addAttribute("url", "notewrite");
    }*/

  /*  public void setSomething(String baseKey, String type, String status, String time, String icon, Model model, Long cataid, Long typeid) {
        if (!StringUtils.isEmpty(icon)) {
            model.addAttribute("icon", icon);
            if (!StringUtils.isEmpty(type)) {
                model.addAttribute("type", type);
                setthree("type", type, icon, model, cataid, typeid);
            }
            if (!StringUtils.isEmpty(status)) {
                model.addAttribute("status", status);
                setthree("status", status, icon, model, cataid, typeid);
            }
            if (!StringUtils.isEmpty(time)) {
                model.addAttribute("time", time);
                setthree("time", time, icon, model, cataid, typeid);
            }

        }
        if (StringUtils.isEmpty(icon)) {
            //目录类型查找
            if (!StringUtils.isEmpty(cataid) && !StringUtils.isEmpty(typeid))
                model.addAttribute("sort", "&id=" + cataid + "&typeid=" + typeid);
            //目录单纯查找
            if (!StringUtils.isEmpty(cataid) && StringUtils.isEmpty(typeid))
                model.addAttribute("sort", "&id=" + cataid);
            //单纯类型查找
            if (StringUtils.isEmpty(cataid) && !StringUtils.isEmpty(typeid))
                model.addAttribute("sort", "&typeid=" + typeid);
        }

        if (!StringUtils.isEmpty(baseKey) && StringUtils.isEmpty(cataid)) {
            model.addAttribute("sort", "&baseKey=" + baseKey);
        }
        if (!StringUtils.isEmpty(baseKey) && !StringUtils.isEmpty(cataid)) {
            model.addAttribute("sort", "&baseKey=" + baseKey + "&id=" + cataid);
        }

    }*/


   /* private void setthree(String x, String name, String icon, Model model, Long cataid, Long typeid) {
        //单纯根据目录
        if (!StringUtils.isEmpty(cataid) && StringUtils.isEmpty(typeid))
            model.addAttribute("sort", "&" + x + "=" + name + "&icon=" + icon + "&id=" + cataid);
        //单纯的根据类型
        if (StringUtils.isEmpty(cataid) && !StringUtils.isEmpty(typeid))
            model.addAttribute("sort", "&" + x + "=" + name + "&icon=" + icon + "&typeid=" + typeid);
        //根据目录和类型
        if (!StringUtils.isEmpty(cataid) && !StringUtils.isEmpty(typeid))
            model.addAttribute("sort", "&" + x + "=" + name + "&icon=" + icon + "&id=" + cataid + "&typeid=" + typeid);
        else if (StringUtils.isEmpty(cataid) && StringUtils.isEmpty(typeid))
            model.addAttribute("sort", "&" + x + "=" + name + "&icon=" + icon);
    }*/

   /* // 编辑
    @RequestMapping(value = "noteedit")
    public String test4(HttpServletRequest Request, HttpSession session, Model model,
                        @RequestParam(value = "page", defaultValue = "0") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        //验证的重载
        if (!StringUtils.isEmpty(Request.getAttribute("errormess"))) {
            Request.setAttribute("errormess", Request.getAttribute("errormess"));
            Request.setAttribute("note", Request.getAttribute("note2"));
        } else if (!StringUtils.isEmpty(Request.getAttribute("success"))) {
            Request.setAttribute("success", Request.getAttribute("success"));
            Request.setAttribute("note", Request.getAttribute("note2"));
        }
        // 目录
        long userid = Long.valueOf(session.getAttribute("userId") + "");

        cataloglist = (List<Catalog>) catalogDao.findcatauser(userid);
        //将根目录放在第一
        if (cataloglist.size() == 0)
            cataloglist.add(catalogDao.findOne(33l));
        else
            cataloglist.set(0, catalogDao.findOne(33l));

        System.out.println("目录" + cataloglist);
        // 用户 就是联系人
        List<User> users = (List<User>) userDao.findAll();
        String nId = Request.getParameter("id");
        if (nId.contains("cata")) {
            //从目录编辑那里进来的
            String newnid = nId.substring(4, nId.length());
            long ca = Long.valueOf(newnid);
            Catalog cate = catalogDao.findOne(ca);
            Request.setAttribute("cata", cate);
            Request.setAttribute("note", null);
            Request.setAttribute("id", -3);
        } else {
            Long nid = Long.valueOf(nId);
            // 新建
            if (nid == -1) {
                Request.setAttribute("note", null);
                // 新建id
                Request.setAttribute("id", nid);
            }

            // 修改
            else if (nid > 0) {
                Note note = noteDao.findOne(nid);
                long ca = Long.valueOf(note.getCatalogId());
                Catalog cate = catalogDao.findOne(ca);
                Request.setAttribute("cata", cate);
                Request.setAttribute("note", note);
                // 修改id
                Request.setAttribute("id", nid);
            }
            // Request.setAttribute("id", nid);
        }
        userget(page, size, model);

        Request.setAttribute("users", users);
        Request.setAttribute("calist", cataloglist);
        typePOListAndStatusPOList(Request);
        return "note/noteedit";
    }*/

   /*public void userget(int page, int size, Model model) {
        Pageable pa = new PageRequest(page, size);
        //查看用户并分页
        Page<User> pageuser = userDao.findAll(pa);
        List<User> userlist = pageuser.getContent();
        // 查询部门表
        Iterable<Dept> deptlist = ddao.findAll();
        // 查职位表
        Iterable<Position> poslist = pdao.findAll();
        model.addAttribute("page", pageuser);
        model.addAttribute("emplist", userlist);
        model.addAttribute("deptlist", deptlist);
        model.addAttribute("poslist", poslist);
        model.addAttribute("url", "namereceive");
    }*/

  /*  // post请求 添加类型
    @RequestMapping(value = "noteview", method = RequestMethod.POST)
    public String test3332(HttpServletRequest request, @Param("title") String title, HttpSession session) {
        int flag = 0;
        Long userid = Long.parseLong(session.getAttribute("userId") + "");
        User user = userDao.findOne(userid);
        String catalogName = request.getParameter("name");
        if (catalogName != null) {
            List<String> catanamelist = catalogDao.findcataname(userid);
            for (String caname : catanamelist) {
                if (caname.contains("(") && caname.contains(")"))
                    caname = caname.substring(0, caname.indexOf("("));
                if (caname.equals(catalogName)) {
                    flag++;
                }
            }
            if (flag == 0)
                catalogDao.save(new Catalog(catalogName, user));
            if (flag > 0)
                catalogDao.save(new Catalog(catalogName + "(" + flag + ")", user));
        }
        return "redirect:/noteview";
    }*/

    /*  // 保存的post方法（笔记新建）
      @RequestMapping(value = "notesave", method = RequestMethod.POST)
      public String testdfddf(@RequestParam("file") MultipartFile file, @Valid Note note2, BindingResult br,
                              HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
          Note note = null;
          Long attid = null;
          Set<User> userss = null;
          Long userid = Long.parseLong(session.getAttribute("userId") + "");
          User user = userDao.findOne(userid);
          Long nid = Long.valueOf(request.getParameter("id"));
          // 接下来就是获取的数据
          String catalogname = request.getParameter("catalogname");
          String catalogName = catalogname.substring(1, catalogname.length());
          long catalogId = catalogDao.findByCatalogName(catalogName);
          String typename = request.getParameter("type");
          long typeId = typeDao.findByTypeModelAndTypeName("aoa_note_list", typename).getTypeId();
          String statusName = request.getParameter("status");
          long statusId = statusDao.findByStatusModelAndStatusName("aoa_note_list", statusName).getStatusId();

          // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
          ResultVO res = BindingResultVOUtil.hasErrors(br);
          if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
              List<Object> list = new MapToList<>().mapToList(res.getData());
              request.setAttribute("errormess", list.get(0).toString());
          } else {
              // nid为-1就是新建或者是从某个目录新建
              if (nid == -1 || nid == -3) {
                  // 判断文件是否为空
                  if (!file.isEmpty()) {
                      att = (Attachment) fs.savefile(file, user, null, false);
                      attid = att.getAttachmentId();
                  } else if (file.isEmpty())
                      attid = null;

                  // 0l表示新建的时候默认为没有收藏
                  note = new Note(note2.getTitle(), note2.getContent(), catalogId, typeId, statusId, attid, new Date(),
                          0l);
                  // 判断是否共享
                  if (request.getParameter("receiver") != null && (request.getParameter("receiver").trim().length() > 0)) {
                      userss = new HashSet<>();
                      String receivers = request.getParameter("receiver");
                      note.setReceiver(receivers);

                      String[] receiver = receivers.split(";");
                      // 先绑定自己再
                      userss.add(user);
                      // 再绑定其他人
                      for (String re : receiver) {
                          System.out.println(re);
                          User user2 = userDao.findid(re);
                          if (user2 == null) {
                          } else
                              userss.add(user2);
                      }

                  } else {
                      // 保存为该用户的笔记 绑定用户id
                      userss = new HashSet<>();
                      userss.add(user);
                  }
              }
              // nid大于0就是修改某个对象
              if (nid > 0) {
                  note = noteDao.findOne(nid);
                  if (note.getAttachId() == null) {
                      if (!file.isEmpty()) {
                          att = (Attachment) fs.savefile(file, user, null, false);
                          attid = att.getAttachmentId();
                          note.setAttachId(attid);
                          noteDao.save(note);
                      }
                  }
                  if (note.getAttachId() != null)
                      fs.updateatt(file, user, null, note.getAttachId());

                  // 判断是否共享
                  if (request.getParameter("receiver") != null && (request.getParameter("receiver").trim().length() > 0)) {
                      userss = new HashSet<>();
                      String receivers = request.getParameter("receiver");
                      note.setReceiver(receivers);

                      String[] receiver = receivers.split(";");
                      // 先绑定自己再
                      userss.add(user);
                      // 再绑定其他人
                      for (String re : receiver) {
                          System.out.println(re);
                          User user2 = userDao.findid(re);
                          if (user2 == null) {
                          } else
                              userss.add(user2);
                      }

                  } else {
                      // 保存为该用户的笔记 绑定用户id
                      userss = new HashSet<>();
                      userss.add(user);
                  }
                  NoteService.updatenote(catalogId, typeId, statusId, note2.getTitle(), note2.getContent(), nid);
              }
              request.setAttribute("success", "后台验证成功");
          }
          // 设置创建人
          note.setCreatemanId(userid);
          note.setUserss(userss);
          noteDao.save(note);
          request.setAttribute("note2", note2);
          return "forward:/noteedit";
      }
    */

     /*  // 笔记删除
    @RequestMapping("notedelete")
    public String testrw(Model model, HttpServletRequest request, HttpSession session) {
        long realuserId = Long.valueOf(session.getAttribute("userId") + "");
        String nid = request.getParameter("nid");
        long noteid = Long.valueOf(nid);
        Noteuser u = noteDao.finduserid(noteid, realuserId);
        if (u != null) {
            notedelete(realuserId, noteid);
            return "redirect:/noteview";
        } else {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";

        }

    }*/

  /*  private void notedelete(long realuserId, long noteid) {
        //删除共享笔记就是只删除中间表noteid对应的那个userid
        Note note = noteDao.findOne(noteid);
        if (note.getTypeId() == 7) {
            noteUserDao.delete(noteUserDao.findid(noteid, realuserId));
        }
        //如果笔记的类型不是共享类型的就直接删除
        else
            NoteService.delete(noteid);
    }*/

  /*  // 笔记批量删除
    @RequestMapping("notesomedelete")
    public String dsafds(HttpServletRequest request, HttpSession session) {
        long realuserId = Long.valueOf(session.getAttribute("userId") + "");
        String sum = request.getParameter("sum");
        String[] strings = sum.split(";");
        for (String s : strings) {
            long noteids = Long.valueOf(s);
            notedelete(realuserId, noteids);
        }
        return "redirect:/noteview";
    }*/

  /*  // 显示具体信息
    @RequestMapping("noteinfo")
    public String test3(@Param("id") String id, HttpServletRequest Request, HttpServletResponse response,
                        HttpSession session) throws IOException {
        Attachment attachment = null;
        FileInputStream fis = null;
        OutputStream os = null;
        Long nid = Long.valueOf(id);
        Note note = noteDao.findOne(nid);
        User user = userDao.findOne(note.getCreatemanId());
        if (note.getAttachId() != null) {
            att = attDao.findByAttachmentId(note.getAttachId());
            Request.setAttribute("att", att);
        }
        Request.setAttribute("note", note);
        Request.setAttribute("user", user);
        return "note/noteinfo";
    }

    // 下载文件
    @RequestMapping("down")
    public void dsaf(HttpServletResponse response, HttpServletRequest request) {
        if (StringUtils.isEmpty(request.getParameter("paid")) || request.getParameter("paid") == null
                || request.getParameter("paid").length() == 0) {
        } else {
            Long paid = Long.valueOf(request.getParameter("paid"));
            att = attDao.findByAttachmentId(paid);
        }
        if (StringUtils.isEmpty(request.getParameter("nid")) || request.getParameter("nid") == null
                || request.getParameter("nid").length() == 0) {
        } else {
            Long nid = Long.valueOf(request.getParameter("nid"));
            Note note = noteDao.findOne(nid);
            att = attDao.findByAttachmentId(note.getAttachId());
        }
        File file = fs.get(att);
        System.out.println(file.getAbsolutePath());
        try {
            // 在浏览器里面显示
            response.setContentLength(att.getAttachmentSize().intValue());
            response.setContentType(att.getAttachmentType());
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(att.getAttachmentName().getBytes("UTF-8"), "ISO8859-1"));
            ServletOutputStream sos = response.getOutputStream();
            byte[] data = new byte[att.getAttachmentSize().intValue()];
            IOUtils.readFully(new FileInputStream(file), data);
            IOUtils.write(data, sos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

   /* // 收藏
    @RequestMapping("collect")
    public String dsaf(Model model, HttpServletRequest request,
                       HttpSession session, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "baseKey", required = false) String baseKey
            , @RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "status", required = false) String status,
                       @RequestParam(value = "time", required = false) String time,
                       @RequestParam(value = "icon", required = false) String icon) {
        Long userid = Long.valueOf(session.getAttribute("userId") + "");
        String id = request.getParameter("id");
        String iscollected = request.getParameter("iscollected");
        NoteService.updatecollect(Long.valueOf(iscollected), Long.valueOf(id));
        setSomething(baseKey, type, status, time, icon, model, null, null);
        Page<Note> upage = NoteService.sortpage(page, null, userid, null, null, null, type, status, time);
        model.addAttribute("url", "notewrite");
        paging(model, upage);
        model.addAttribute("sort", "&userid=" + userid);
        typePOListAndStatusPOList(request);
        return "note/notewrite";
    }*/

    // 收藏查询
   /* @RequestMapping("collectfind")
    public String dsafdsf(Model model, HttpServletRequest request, @RequestParam("iscollect") String iscollected, @RequestParam("cata") Long cid,
                          HttpSession session, @RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "baseKey", required = false) String baseKey
            , @RequestParam(value = "type", required = false) String type,
                          @RequestParam(value = "status", required = false) String status,
                          @RequestParam(value = "time", required = false) String time,
                          @RequestParam(value = "icon", required = false) String icon
    ) {
        if (cid == -2)
            cid = null;
        Long userid = Long.valueOf(session.getAttribute("userId") + "");
        long collect = Long.valueOf(iscollected);

        System.out.println("收集" + collect);
        if (collect == 1) {
            setSomething(baseKey, type, status, time, icon, model, cid, null);
            Page<Note> upage = NoteService.sortpage(page, null, userid, collect, cid, null, type, status, time);
            model.addAttribute("url", "collectfind");
//            paging(model, upage);
            //获得数据之后就将cid重新设置
            if (cid == null)
                cid = -2l;
            model.addAttribute("sort", "&iscollect=" + collect + "&cata=" + cid);
            model.addAttribute("sort2", "&iscollect=" + collect + "&cata=" + cid);
            model.addAttribute("collect", 0);
        } else if (collect == 0) {
            setSomething(baseKey, type, status, time, icon, model, cid, null);
            Page<Note> upage = NoteService.sortpage(page, null, userid, null, cid, null, type, status, time);
            model.addAttribute("url", "notewrite");
//            paging(model, upage);
            model.addAttribute("sort", "&userid=" + userid);
            model.addAttribute("sort2", "&userid=" + userid);
            model.addAttribute("collect", 1);
        }

        typePOListAndStatusPOList(request);

        return "note/notewrite";
    }*/

   /* //查找目录
    @RequestMapping("notecata")
    public String sadf(Model model, HttpServletRequest request, HttpSession session,
                       @RequestParam("id") String cid,
                       @RequestParam(value = "page", defaultValue = "0") int page,
                       @RequestParam(value = "baseKey", required = false) String baseKey
            , @RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "status", required = false) String status,
                       @RequestParam(value = "time", required = false) String time,
                       @RequestParam(value = "icon", required = false) String icon) {
        Long userid = Long.parseLong(session.getAttribute("userId") + "");
        model.addAttribute("catalog", "&id=" + cid);
        //不为-2就是按照目录查找
        if (!request.getParameter("id").equals("-2")) {
            Long id = Long.valueOf(cid);
            setSomething(baseKey, type, status, time, icon, model, id, null);
            Page<Note> upage = NoteService.sortpage(page, baseKey, userid, null, id, null, type, status, time);
            request.setAttribute("sort2", "&id=" + cid);
//            paging(model, upage);
            model.addAttribute("url", "notecata");
            ////为-2就是按照最近查找
        }
        typePOListAndStatusPOList(request);
        return "note/notewrite";
    }*/

   /* // 目录删除
    @RequestMapping("catadelete")
    public String testrwd(Model model, HttpServletRequest request, HttpSession session) {
        long realuserId = Long.valueOf(session.getAttribute("userId") + "");
        String cid = request.getParameter("cid");
        long catalogid = Long.valueOf(cid);
		Page<Note> upage= NoteService.paging(page, null, null, null, catalogid, null);
		paging(model, upage);
        noteList = noteDao.findByCatalogId(catalogid, realuserId);
        // 没有做级联删除 先删除目录下的笔记 再删除目录
        for (Note note : noteList) {
            NoteService.delete(note.getNoteId());
        }
        catalogService.delete(catalogid);

        return "redirect:/noteview";
    }*/

    /*// 查找类型
    @RequestMapping("notetype")
    public String test43(Model model, HttpServletRequest request, @RequestParam("typeid") Long tid, @RequestParam("id") Long cid, HttpSession session, @RequestParam(value = "page", defaultValue = "0") int page
            , @RequestParam(value = "baseKey", required = false) String baseKey, @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon
    ) {
        Long userid = Long.valueOf(session.getAttribute("userId") + "");
        System.out.println(tid);
        if (cid == -2)
            cid = null;
        System.out.println("目录" + cid);
        setSomething(baseKey, type, status, time, icon, model, cid, tid);
        Page<Note> upage = NoteService.sortpage(page, baseKey, userid, null, cid, tid, type, status, time);
        System.out.println(upage.getContent());
        //获得数据之后就将cid重新设置
        if (cid == null)
            cid = -2l;
        request.setAttribute("sort2", "&id=" + cid + "&typeid=" + tid);
        paging(model, upage);
        model.addAttribute("url", "notetype");
        typePOListAndStatusPOList(request);
        return "note/notewrite";
    }*/

  /*  // 显示表格所有
    @RequestMapping(value = "notewrite", method = RequestMethod.GET)
    public String test33(Model model, HttpServletRequest request, HttpSession session,
                         @RequestParam(value = "page", defaultValue = "0") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon) {
        Long userid = Long.parseLong(session.getAttribute("userId") + "");

        setSomething(baseKey, type, status, time, icon, model, null, null);
        Page<Note> upage = NoteService.sortpage(page, baseKey, userid, null, null, null, type, status, time);
        typePOListAndStatusPOList(request);
        if (baseKey != null) {
            //如果有搜索关键字那么就记住它
            request.setAttribute("sort", "&baseKey=" + baseKey);
        }
        //没有就默认查找所有
        else
            request.setAttribute("sort", "&userid=" + userid);
       paging(model, upage);
        model.addAttribute("url", "notewrite");
        return "note/notewrite";
    }*/

    // 保存的get方法
    @RequestMapping(value = "notesave", method = RequestMethod.GET)
    public void testdfd(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
    }


  /*  @RequestMapping("namereceive")
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
                pageuser = userDao.findByFatherId(userId, pa);
            } else {
                // 查询名字模糊查询员工
                pageuser = userDao.findbyFatherId(name, userId, pa);
            }

        } else {
            System.out.println("222");
            if (StringUtil.isEmpty(name)) {
                //查看用户并分页
                pageuser = userDao.findAll(pa);
            } else {
                pageuser = userDao.findbyUserNameLike(name, pa);
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
        model.addAttribute("url", "namereceive");

        return "common/noterecivers";

    }*/


    //	===================================================
    @Resource
    private CatalogPOServiceV2 catalogPOServiceV2;
    @Resource
    private NoteListPOServiceV2 noteListPOServiceV2;
    @Resource
    private NoteServiceV2 noteServiceV2;
    @Resource
    private ReceiverNotePOServiceV2 receiverNotePOServiceV2;
    @Resource
    private TypeServiceV2 typeServiceV2;
    @Resource
    private StatusServiceV2 statusServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;
    @Resource
    private DeptServiceV2 deptServiceV2;
    @Resource
    private PositionServiceV2 positionServiceV2;
    @Resource
    private FileServiceV2 fileServiceV2;
    @Resource
    private NoteListPOMapper noteListPOMapper;
    @Resource
    private AttachmentServiceV2 attachmentServiceV2;

    // 笔记主界面
    @RequestMapping(value = "noteview", method = RequestMethod.GET)
    public String noteView(Model model, HttpServletRequest request, HttpSession session,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "baseKey", required = false) String baseKey,
                           @RequestParam(value = "type", required = false) String type,
                           @RequestParam(value = "status", required = false) String status,
                           @RequestParam(value = "time", required = false) String time,
                           @RequestParam(value = "icon", required = false) String icon) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        List<CatalogPO> catalogPOS = catalogPOServiceV2.getCatalogPOByUserId(userId);//根据用户id获取用户的目录信息（即笔记下面的目录）
        setSomething(baseKey, type, status, time, icon, model, null, null);
        List<NoteListPO> noteListPOS = noteServiceV2.sortPage(baseKey, userId, null, null, null, type, status, time);
        paging(model, noteListPOS, page);
        typePOListAndStatusPOList(request);//request是为了设置模型
        model.addAttribute("url", "notewrite");
        model.addAttribute("sort", "&userid=" + userId);
        model.addAttribute("calist", catalogPOS);
        return "note/noteview";
    }

    public void setSomething(String baseKey, String type, String status, String time, String icon, Model model, Long cataid, Long typeid) {
        if (!StringUtils.isEmpty(icon)) {
            model.addAttribute("icon", icon);
            if (!StringUtils.isEmpty(type)) {
                model.addAttribute("type", type);
                setthree("type", type, icon, model, cataid, typeid);
            }
            if (!StringUtils.isEmpty(status)) {
                model.addAttribute("status", status);
                setthree("status", status, icon, model, cataid, typeid);
            }
            if (!StringUtils.isEmpty(time)) {
                model.addAttribute("time", time);
                setthree("time", time, icon, model, cataid, typeid);
            }
        }
        if (StringUtils.isEmpty(icon)) {
            //目录类型查找
            if (!StringUtils.isEmpty(cataid) && !StringUtils.isEmpty(typeid))
                model.addAttribute("sort", "&id=" + cataid + "&typeid=" + typeid);
            //目录单纯查找
            if (!StringUtils.isEmpty(cataid) && StringUtils.isEmpty(typeid))
                model.addAttribute("sort", "&id=" + cataid);
            //单纯类型查找
            if (StringUtils.isEmpty(cataid) && !StringUtils.isEmpty(typeid))
                model.addAttribute("sort", "&typeid=" + typeid);
        }

        if (!StringUtils.isEmpty(baseKey) && StringUtils.isEmpty(cataid)) {
            model.addAttribute("sort", "&baseKey=" + baseKey);
        }
        if (!StringUtils.isEmpty(baseKey) && !StringUtils.isEmpty(cataid)) {
            model.addAttribute("sort", "&baseKey=" + baseKey + "&id=" + cataid);
        }
    }

    private void setthree(String x, String name, String icon, Model model, Long cataid, Long typeid) {
        //单纯根据目录
        if (!StringUtils.isEmpty(cataid) && StringUtils.isEmpty(typeid))
            model.addAttribute("sort", "&" + x + "=" + name + "&icon=" + icon + "&id=" + cataid);
        //单纯的根据类型
        if (StringUtils.isEmpty(cataid) && !StringUtils.isEmpty(typeid))
            model.addAttribute("sort", "&" + x + "=" + name + "&icon=" + icon + "&typeid=" + typeid);
        //根据目录和类型
        if (!StringUtils.isEmpty(cataid) && !StringUtils.isEmpty(typeid))
            model.addAttribute("sort", "&" + x + "=" + name + "&icon=" + icon + "&id=" + cataid + "&typeid=" + typeid);
        else if (StringUtils.isEmpty(cataid) && StringUtils.isEmpty(typeid))
            model.addAttribute("sort", "&" + x + "=" + name + "&icon=" + icon);
    }

    /**
     * 分页
     *
     * @param model
     * @param noteListPOS 笔记列表
     * @param page        第几页
     */
    private void paging(Model model, List<NoteListPO> noteListPOS, int page) {
        for (NoteListPO noteListPO : noteListPOS) {
            noteListPO.setCreateTime(new Timestamp(noteListPO.getCreateTime().getTime()));
        }
        PageBO pageBO = new PageBO(page);
        pageBO.setTotalCount(noteListPOS.size());//设置总页数
        int star = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (noteListPOS.size() < end) {
            end = noteListPOS.size();
        }
        List<NoteListPO> subList = noteListPOS.subList(star, end);
        model.addAttribute("nlist", subList);
        model.addAttribute("page", pageBO);
    }

    /**
     * 获取笔记的类型列表和状态的列表
     *
     * @param request 为了设置模型
     */
    private void typePOListAndStatusPOList(HttpServletRequest request) {
        List<TypePO> typePOList = typeServiceV2.getTypePOByTypeModel("aoa_note_list");
        List<StatusPO> statusPOList = statusServiceV2.getStatusPOByStatusModel("aoa_note_list");
        request.setAttribute("typelist", typePOList);
        request.setAttribute("statuslist", statusPOList);
    }

    // 编辑（新建，修改）
    @RequestMapping(value = "noteedit")
    public String noteEdit(HttpServletRequest Request, HttpSession session, Model model,
                           @RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size) {
        //验证的重载
        if (!StringUtils.isEmpty(Request.getAttribute("errormess"))) {
            Request.setAttribute("errormess", Request.getAttribute("errormess"));
            Request.setAttribute("note", Request.getAttribute("note2"));
        } else if (!StringUtils.isEmpty(Request.getAttribute("success"))) {
            Request.setAttribute("success", Request.getAttribute("success"));
            Request.setAttribute("note", Request.getAttribute("note2"));
        }
        // 目录
        long userId = Long.valueOf(session.getAttribute("userId") + "");
        List<CatalogPO> catalogPOList = catalogPOServiceV2.getCatalogPOByUserId(userId);//根据用id找目录列表
        //将根目录放在第一
        if (catalogPOList.size() == 0) {
            catalogPOList.add(catalogPOServiceV2.getCatalogPOByCatalogId(33L));
        } else {
            catalogPOList.add(0, catalogPOServiceV2.getCatalogPOByCatalogId(33L));
        }
        // 用户 就是联系人
        List<UserPO> userPOListAll = userServiceV2.getUserAll();//获取所有用户列表
        String nId = Request.getParameter("id");
        if (nId.contains("cata")) {
            //从目录编辑那里进来的
            String newnid = nId.substring(4, nId.length());
            long ca = Long.valueOf(newnid);
            CatalogPO catalogPO = catalogPOServiceV2.getCatalogPOByCatalogId(ca);//目录信息
            Request.setAttribute("cata", catalogPO);
            Request.setAttribute("note", null);
            Request.setAttribute("id", -3);
        } else {
            Long nid = Long.valueOf(nId);
            // 新建
            if (nid == -1) {
                Request.setAttribute("note", null);
                // 新建id
                Request.setAttribute("id", nid);//nid=-1
            } else if (nid > 0) {// 修改直接获取笔记id
                NoteListPO noteListPO = noteListPOServiceV2.getNoteListPOByNoteId(nid);
                long ca = Long.valueOf(noteListPO.getCatalogId());//目录id
                CatalogPO catalogPO = catalogPOServiceV2.getCatalogPOByCatalogId(ca);//目录信息
                Request.setAttribute("cata", catalogPO);
                Request.setAttribute("note", noteListPO);
                Request.setAttribute("id", nid);//笔记id
            }
        }
        getUser(page, size, model);
        Request.setAttribute("users", userPOListAll);//所有用户列表
        Request.setAttribute("calist", catalogPOList);//用户的目录列表
        typePOListAndStatusPOList(Request);
        return "note/noteedit";
    }

    /**
     * 用户分页
     *
     * @param page  第几页，默认为0
     * @param size  每页大小
     * @param model
     */
    public void getUser(int page, int size, Model model) {
        List<UserPO> userPOListAll = userServiceV2.getUserAll();//所有用户
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(userPOListAll.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (userPOListAll.size() < end) {
            end = userPOListAll.size();
        }
        List<UserPO> subUserPOList = userPOListAll.subList(start, end);//用户的页面信息
        List<DeptPO> deptListAll = deptServiceV2.getDeptPOListAll();//所有的部门信息
        List<PositionPO> positionPOList = positionServiceV2.getPositionListAll();//所有的职位信息

        model.addAttribute("page", pageBO);
        model.addAttribute("emplist", subUserPOList);
        model.addAttribute("deptlist", deptListAll);
        model.addAttribute("poslist", positionPOList);
        model.addAttribute("url", "namereceive");
    }


    /**
     * 保存的新建，修改的方法（笔记新建,修改）
     *
     * @param file    附件
     * @param note2   前端的填写的笔记信息
     * @param br
     * @param request
     * @param session
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping(value = "notesave", method = RequestMethod.POST)
    public String noteSave(@RequestParam("file") MultipartFile file, @Valid NoteListVO note2, BindingResult br,
                           HttpServletRequest request, HttpSession session) throws IllegalStateException, IOException {
        NoteListPO noteListPO = new NoteListPO();//为插入或更新数据库笔记
        Long attachId = null;
        Set<UserPO> userPOS = null;
        AttachmentListPO attachmentListPO = null;
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        UserPO userPO = userServiceV2.getUserPOByUserId(userId);//用户信息
        Long nid = Long.valueOf(request.getParameter("id"));//获取笔记ID用户判断是新增还是修改
        String catalogname = request.getParameter("catalogname");//获取目录名
        String catalogName = catalogname.substring(1);//去掉符号后的目录名
        long catalogId = catalogDao.findByCatalogName(catalogName);//根据目录名获取目录id
        String typename = request.getParameter("type");//获取类型名
        long typeId = typeDao.findByTypeModelAndTypeName("aoa_note_list", typename).getTypeId();//根据类型名和类型迷行获取类型ID
        String statusName = request.getParameter("status");//获取状态名
        long statusId = statusDao.findByStatusModelAndStatusName("aoa_note_list", statusName).getStatusId();//根据状态名和状态模型获取状态ID

        // 这里返回ResultVO对象，如果校验通过，ResultEnum.SUCCESS.getCode()返回的值为200；否则就是没有通过；
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            List<Object> list = new MapToList<>().mapToList(res.getData());
            request.setAttribute("errormess", list.get(0).toString());
        } else {
            // nid为-1就是新建或者是从某个目录新建
            if (nid == -1 || nid == -3) {
                // 判断文件是否为空
                if (!file.isEmpty()) {
                    attachmentListPO = (AttachmentListPO) fileServiceV2.saveFile(file, userPO, null, false);
                    attachId = attachmentListPO.getAttachmentId();
                } else if (file.isEmpty())
                    attachId = null;
                // 0l表示新建的时候默认为没有收藏
                noteListPO.setTitle(note2.getTitle());
                noteListPO.setContent(note2.getContent());
                noteListPO.setCatalogId(catalogId);
                noteListPO.setTypeId(typeId);
                noteListPO.setStatusId(statusId);
                noteListPO.setAttachId(attachId);
                noteListPO.setCreateTime(new Date());
                noteListPO.setIsCollected(0L);
                // 判断是否共享
                if (request.getParameter("receiver") != null && (request.getParameter("receiver").trim().length() > 0)) {
                    userPOS = new HashSet<>();
                    String receivers = request.getParameter("receiver");//共享人名
                    noteListPO.setReceiver(receivers);
                    String[] receiver = receivers.split(";");
                    // 先绑定自己
                    userPOS.add(userPO);
                    // 再绑定其他人
                    for (String receiverName : receiver) {
                        UserPO userPO2 = userServiceV2.getUserPOByUsername(receiverName);
                        if (userPO2 != null) {
                            userPOS.add(userPO2);
                        }
                    }
                } else {//未分享
                    // 保存为该用户的笔记 绑定用户id
                    userPOS = new HashSet<>();
                    userPOS.add(userPO);
                }
            }
            // nid大于0就是修改某个对象
            if (nid > 0) {
                noteListPO = noteListPOServiceV2.getNoteListPOByNoteId(nid);
                if (noteListPO.getAttachId() == null) {
                    if (!file.isEmpty()) {
                        attachmentListPO = (AttachmentListPO) fileServiceV2.saveFile(file, userPO, null, false);//上传并插入附件
                        attachId = attachmentListPO.getAttachmentId();
                        noteListPO.setAttachId(attachId);
                        noteListPOMapper.updateByPrimaryKey(noteListPO);//更新笔记信息
                    }
                }
                if (noteListPO.getAttachId() != null) {
                    fileServiceV2.updateattchment(file, UserFactoryVO.createUserVO(userPO), null, noteListPO.getAttachId());
                }
                // 判断是否共享
                if (request.getParameter("receiver") != null && (request.getParameter("receiver").trim().length() > 0)) {
                    userPOS = new HashSet<>();
                    String receivers = request.getParameter("receiver");//获取分享人的名字
                    noteListPO.setReceiver(receivers);// 设置分享人的名字
                    String[] receiver = receivers.split(";");
                    // 先绑定自己再
                    userPOS.add(userPO);
                    // 再绑定其他人
                    for (String receiverName : receiver) {
                        UserPO userPO2 = userServiceV2.getUserPOByUsername(receiverName);
                        if (userPO2 != null) {
                            userPOS.add(userPO2);
                        }
                    }
                } else {
                    // 保存为该用户的笔记 绑定用户id
                    userPOS = new HashSet<>();
                    userPOS.add(userPO);
                }
                noteListPO.setCatalogId(catalogId);
                noteListPO.setTypeId(typeId);
                noteListPO.setStatusId(statusId);
                noteListPO.setTitle(note2.getTitle());
                noteListPO.setContent(note2.getContent());
                noteListPO.setNoteId(nid);
            }
            request.setAttribute("success", "后台验证成功");
        }
        // 设置创建人
        noteListPO.setCreatemanId(userId);
        NoteListPO noteListPO1 = noteListPOServiceV2.insertOrUpdateNoteListPOBy(noteListPO, nid);
        for (UserPO userPO1 : userPOS) {
            receiverNotePOServiceV2.insertReceiverNotePOByNoteIdAndUserId(userPO1.getUserId(), noteListPO1.getNoteId());
        }
        request.setAttribute("note2", note2);//前端接收的笔记信息
        return "forward:/noteedit";
    }


    /**
     * 删除笔记
     *
     * @param userId 用户ID
     * @param noteId 笔记id
     */
    private void notedelete(long userId, long noteId) {
        //删除共享笔记就是只删除中间表noteid对应的那个userid
        NoteListPO noteListPO = noteListPOServiceV2.getNoteListPOByNoteId(noteId);//笔记信息
        Long receiverNotePOId = receiverNotePOServiceV2.getReceiverNotePOByUserIdAndNoteId(userId, noteId).getId();
        if (noteListPO.getTypeId() == 7) {//共享笔记
            receiverNotePOServiceV2.deleteReceiverNotePOByReceiverNotePO(receiverNotePOId);
        } else {
            receiverNotePOServiceV2.deleteReceiverNotePOByReceiverNotePO(receiverNotePOId);//先删除用户关联表的信息
            //如果笔记的类型不是共享类型的就直接删除
            noteListPOServiceV2.deleteNoteListPOByNoteListPOId(noteId);
        }
    }

    // 笔记删除
    @RequestMapping("notedelete")
    public String noteDelete(Model model, HttpServletRequest request, HttpSession session) {
        long userId = Long.valueOf(session.getAttribute("userId") + "");
        Long noteId = Long.valueOf(request.getParameter("nid"));
        //根据用户ID和笔记ID找关联表信息
        ReceiverNotePO receiverNotePO = receiverNotePOServiceV2.getReceiverNotePOByUserIdAndNoteId(userId, noteId);
        if (receiverNotePO != null) {//该笔记还在分享
            notedelete(userId, noteId);
            return "redirect:/noteview";
        } else {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";

        }

    }

    // 笔记批量删除
    @RequestMapping("notesomedelete")
    public String noteSomeDelete(HttpServletRequest request, HttpSession session) {
        long userId = Long.valueOf(session.getAttribute("userId") + "");
        String noteIds = request.getParameter("sum");
        String[] strings = noteIds.split(";");
        for (String stringNoteId : strings) {
            long noteId = Long.valueOf(stringNoteId);
            notedelete(userId, noteId);
        }
        return "redirect:/noteview";
    }

    // 显示具体信息
    @RequestMapping("noteinfo")
    public String noteInfo(@Param("id") String id, HttpServletRequest Request) {
        Long noteId = Long.valueOf(id);//笔记ID
        NoteListPO noteListPO = noteListPOServiceV2.getNoteListPOByNoteId(noteId);//笔记信息
        UserPO userPO = userServiceV2.getUserPOByUserId(noteListPO.getCreatemanId()); // 笔记创建人信息
        if (noteListPO.getAttachId() != null) {
            AttachmentListPO attachmentListPO = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(noteListPO.getAttachId());//附件信息
            Request.setAttribute("att", attachmentListPO);
        }
        noteListPO.setCreateTime(new Timestamp(noteListPO.getCreateTime().getTime()));//设置时间格式
        Request.setAttribute("note", noteListPO);
        Request.setAttribute("user", userPO);
        return "note/noteinfo";
    }

    // 下载文件
    @RequestMapping("down")
    public void down(HttpServletResponse response, HttpServletRequest request) {
        AttachmentListPO attachmentListPO = null;
//        if (StringUtils.isEmpty(request.getParameter("paid")) || request.getParameter("paid") == null
//                || request.getParameter("paid").length() == 0) {
        if (StringUtils.isEmpty(request.getParameter("attrid")) || request.getParameter("attrid") == null
                || request.getParameter("attrid").length() == 0) {
        } else {
            Long attachmentListPOId = Long.valueOf(request.getParameter("attrid"));
            attachmentListPO = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(attachmentListPOId);//附件信息
        }
        if (StringUtils.isEmpty(request.getParameter("nid")) || request.getParameter("nid") == null
                || request.getParameter("nid").length() == 0) {
        } else {
            Long noteId = Long.valueOf(request.getParameter("nid"));
            NoteListPO noteListPO = noteListPOServiceV2.getNoteListPOByNoteId(noteId);//笔记信息
            attachmentListPO = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(noteListPO.getAttachId());
        }
        File file = fileServiceV2.getFile(attachmentListPO.getAttachmentPath());
        try {
            // 在浏览器里面显示
            response.setContentLength(Integer.valueOf(attachmentListPO.getAttachmentSize()));//设置大小
            response.setContentType(attachmentListPO.getAttachmentType());//设置格式
            response.setHeader("Content-Disposition",
                    "attachment;filename=" + new String(attachmentListPO.getAttachmentName().getBytes("UTF-8"), "ISO8859-1"));
            ServletOutputStream sos = response.getOutputStream();
            byte[] data = new byte[Integer.valueOf(attachmentListPO.getAttachmentSize())];
            IOUtils.readFully(new FileInputStream(file), data);
            IOUtils.write(data, sos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 收藏
    @RequestMapping("collect")
    public String collect(Model model, HttpServletRequest request,
                          HttpSession session, @RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "baseKey", required = false) String baseKey,
                          @RequestParam(value = "type", required = false) String type,
                          @RequestParam(value = "status", required = false) String status,
                          @RequestParam(value = "time", required = false) String time,
                          @RequestParam(value = "icon", required = false) String icon) {
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        String noteId = request.getParameter("id");//笔记id
        String isCollected = request.getParameter("iscollected");
        noteListPOServiceV2.updateNoteListPOByCollected(Long.valueOf(isCollected), Long.valueOf(noteId));
        setSomething(baseKey, type, status, time, icon, model, null, null);
        List<NoteListPO> noteListPOS = noteServiceV2.sortPage(null, userId, null, null, null, type, status, time);
        model.addAttribute("url", "notewrite");
        paging(model, noteListPOS, page);
        model.addAttribute("sort", "&userid=" + userId);
        typePOListAndStatusPOList(request);
        return "note/notewrite";
    }

    // 收藏查询
    @RequestMapping("collectfind")
    public String collectFind(Model model, HttpServletRequest request,
                              @RequestParam("iscollect") String iscollected,
                              @RequestParam("cata") Long cid,
                              HttpSession session,
                              @RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "baseKey", required = false) String baseKey,
                              @RequestParam(value = "type", required = false) String type,
                              @RequestParam(value = "status", required = false) String status,
                              @RequestParam(value = "time", required = false) String time,
                              @RequestParam(value = "icon", required = false) String icon) {
        if (cid == -2) {//目录ID
            cid = null;
        }
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        long collected = Long.valueOf(iscollected);//是否收藏

        if (collected == 1) {//收藏
            setSomething(baseKey, type, status, time, icon, model, cid, null);
            List<NoteListPO> noteListPOS = noteServiceV2.sortPage(null, userId, collected, cid, null, type, status, time);
            model.addAttribute("url", "collectfind");
            paging(model, noteListPOS, page);
            //获得数据之后就将cid重新设置
            if (cid == null)
                cid = -2l;
            model.addAttribute("sort", "&iscollect=" + collected + "&cata=" + cid);
            model.addAttribute("sort2", "&iscollect=" + collected + "&cata=" + cid);
            model.addAttribute("collect", 0);
        } else if (collected == 0) {//不收藏
            setSomething(baseKey, type, status, time, icon, model, cid, null);
            List<NoteListPO> noteListPOS = noteServiceV2.sortPage(null, userId, null, cid, null, type, status, time);
            model.addAttribute("url", "notewrite");
            paging(model, noteListPOS, page);
            model.addAttribute("sort", "&userid=" + userId);
            model.addAttribute("sort2", "&userid=" + userId);
            model.addAttribute("collect", 1);
        }
        typePOListAndStatusPOList(request);
        return "note/notewrite";
    }

    // post请求 添加类型（添加目录）
    @RequestMapping(value = "noteview", method = RequestMethod.POST)
    public String addCatalogName(HttpServletRequest request, @Param("title") String title, HttpSession session) {
        int flag = 0;
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        String catalogName = request.getParameter("name");//新增的目录名
        if (catalogName != null) {
            List<String> catanamelist = catalogDao.findcataname(userId);//用户的目录列表
            for (String caname : catanamelist) {
                if (caname.contains("(") && caname.contains(")")) {//如果名字包含（）
                    caname = caname.substring(0, caname.indexOf("("));//去点括号的真实名
                }
                if (caname.equals(catalogName)) {
                    flag++;
                }
            }
            if (flag == 0) {
                CatalogPO catalogPO = new CatalogPO();
                catalogPO.setCatalogName(catalogName);
                catalogPO.setCataUserId(userId);
                catalogPOServiceV2.insertCatalogPO(catalogPO);
            }
            if (flag > 0) {
                CatalogPO catalogPO = new CatalogPO();
                catalogPO.setCatalogName(catalogName + "(" + flag + ")");
                catalogPO.setCataUserId(userId);
                catalogPOServiceV2.insertCatalogPO(catalogPO);
            }
        }
        return "redirect:/noteview";
    }

    //查找目录
    @RequestMapping("notecata")
    public String noteCatalogFind(Model model, HttpServletRequest request, HttpSession session,
                                  @RequestParam("id") String cid,
                                  @RequestParam(value = "page", defaultValue = "1") int page,
                                  @RequestParam(value = "baseKey", required = false) String baseKey,
                                  @RequestParam(value = "type", required = false) String type,
                                  @RequestParam(value = "status", required = false) String status,
                                  @RequestParam(value = "time", required = false) String time,
                                  @RequestParam(value = "icon", required = false) String icon) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        model.addAttribute("catalog", "&id=" + cid);//目录ID
        //不为-2就是按照目录查找（为-2就是按照最近查找）
        if (!request.getParameter("id").equals("-2")) {
            Long catalogId = Long.valueOf(cid);
            setSomething(baseKey, type, status, time, icon, model, catalogId, null);
            List<NoteListPO> noteListPOS = noteServiceV2.sortPage(baseKey, userId, null, catalogId, null, type, status, time);
            request.setAttribute("sort2", "&id=" + cid);
            paging(model, noteListPOS, page);
            model.addAttribute("url", "notecata");
        }
        typePOListAndStatusPOList(request);
        return "note/notewrite";
    }

    // 目录删除
    @RequestMapping("catadelete")
    public String catalogDelete(Model model, HttpServletRequest request, HttpSession session) {
        long userId = Long.valueOf(session.getAttribute("userId") + "");
        long catalogId = Long.valueOf(request.getParameter("cid"));
        List<NoteListPO> noteListPOS = noteServiceV2.sortPage(null, userId, null, catalogId, null, null, null, null);
        paging(model, noteListPOS, 0);
        for (NoteListPO noteListPO : noteListPOS) {
            Long receiverNotePOId = receiverNotePOServiceV2.getReceiverNotePOByUserIdAndNoteId(userId, noteListPO.getNoteId()).getId();
            receiverNotePOServiceV2.deleteReceiverNotePOByReceiverNotePO(receiverNotePOId);
            noteListPOServiceV2.deleteNoteListPOByNoteListPOId(noteListPO.getNoteId());
        }
        catalogPOServiceV2.deleteCatalogPOByCatalogId(catalogId);
        return "redirect:/noteview";
    }

    // 查找类型
    @RequestMapping("notetype")
    public String test43(Model model, HttpServletRequest request,
                         @RequestParam("typeid") Long tid,
                         @RequestParam("id") Long cid, HttpSession session,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon) {
        Long userId = Long.valueOf(session.getAttribute("userId") + "");
        if (cid == -2) {
            cid = null;
        }
        setSomething(baseKey, type, status, time, icon, model, cid, tid);
        List<NoteListPO> noteListPOS = noteServiceV2.sortPage(baseKey, userId, null, cid, tid, type, status, time);
        //获得数据之后就将cid重新设置
        if (cid == null) {
            cid = -2l;
        }
        request.setAttribute("sort2", "&id=" + cid + "&typeid=" + tid);
        paging(model, noteListPOS, page);
        model.addAttribute("url", "notetype");
        typePOListAndStatusPOList(request);
        return "note/notewrite";
    }

    // 显示表格所有
    @RequestMapping(value = "notewrite", method = RequestMethod.GET)
    public String test33(Model model, HttpServletRequest request, HttpSession session,
                         @RequestParam(value = "page", defaultValue = "1") int page,
                         @RequestParam(value = "baseKey", required = false) String baseKey,
                         @RequestParam(value = "type", required = false) String type,
                         @RequestParam(value = "status", required = false) String status,
                         @RequestParam(value = "time", required = false) String time,
                         @RequestParam(value = "icon", required = false) String icon) {
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        setSomething(baseKey, type, status, time, icon, model, null, null);
        List<NoteListPO> noteListPOS = noteServiceV2.sortPage(baseKey, userId, null, null, null, type, status, time);
        typePOListAndStatusPOList(request);
        if (baseKey != null) {
            //如果有搜索关键字那么就记住它
            request.setAttribute("sort", "&baseKey=" + baseKey);
        } else {//没有就默认查找所有
            request.setAttribute("sort", "&userid=" + userId);
        }
        paging(model, noteListPOS, page);
        model.addAttribute("url", "notewrite");
        return "note/notewrite";
    }

    @RequestMapping("namereceive")
    public String nameReceive(Model model, HttpServletRequest req, @SessionAttribute("userId") Long userId,
                              @RequestParam(value = "page", defaultValue = "") int page,
                              @RequestParam(value = "size", defaultValue = "10") int size) {
        String name = null;
        String qufen = null;
        List<UserPO> userPOList = null;
        if (!StringUtil.isEmpty(req.getParameter("title"))) {
            name = req.getParameter("title").trim();
        }
        if (!StringUtil.isEmpty(req.getParameter("qufen"))) {
            qufen = req.getParameter("qufen").trim();
            if (StringUtil.isEmpty(name)) {
                userPOList = userServiceV2.getUserPOListByFatherId(userId);// 查询部门下面的员工
            } else {
                userPOList = userServiceV2.getUserPOListByFatherIdAndUsernameLikeAndRealNameLike(userId, name);// 查询名字模糊查询员工
            }
        } else {
            if (StringUtil.isEmpty(name)) {
                userPOList = userServiceV2.getUserAll();//查看所有用户
            } else {
                userPOList = userServiceV2.getUserPOListByUsernameLikeAndRealNameLike(name);
            }
        }
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(userPOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (userPOList.size() < end) {
            end = userPOList.size();
        }
        List<UserPO> subUserPOList = userPOList.subList(start, end);//用户的页面信息
        List<DeptPO> deptPOListAll = deptServiceV2.getDeptPOListAll();//部门信息
        List<PositionPO> positionPOListAll = positionServiceV2.getPositionListAll();// 职位表
        model.addAttribute("emplist", subUserPOList);
        model.addAttribute("page", pageBO);
        model.addAttribute("deptlist", deptPOListAll);
        model.addAttribute("poslist", positionPOListAll);
        model.addAttribute("url", "namereceive");
        return "common/noterecivers";
    }

}
