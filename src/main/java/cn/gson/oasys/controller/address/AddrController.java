package cn.gson.oasys.controller.address;

import java.io.IOException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cn.gson.oasys.ServiceV2.*;
import cn.gson.oasys.ServiceV2.directormanageV2.DirectorManageServiceAllV2;
import cn.gson.oasys.ServiceV2.directormanageV2.DirectorPOServiceV2;
import cn.gson.oasys.ServiceV2.mailV2.MailServiceV2;
import cn.gson.oasys.ServiceV2.directormanageV2.DirectorUserPOServiceV2;
import cn.gson.oasys.model.bo.PageBO;
import cn.gson.oasys.model.po.*;
import cn.gson.oasys.vo.DeptVO;
import cn.gson.oasys.vo.PositionVO;
import cn.gson.oasys.vo.RoleVO;
import cn.gson.oasys.vo.UserVO;
import cn.gson.oasys.vo.addressVO2.DirectorUserVO;
import cn.gson.oasys.vo.addressVO2.DirectorUserVOFactory;
import cn.gson.oasys.vo.addressVO2.DirectorVO;
import cn.gson.oasys.vo.addressVO2.DirectoryVOFactory;
import cn.gson.oasys.vo.factoryvo.DeptFactoryVO;
import cn.gson.oasys.vo.factoryvo.PositionFactoryVO;
import cn.gson.oasys.vo.factoryvo.RoleFactoryVO;
import cn.gson.oasys.vo.factoryvo.UserFactoryVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;

import cn.gson.oasys.common.formValid.BindingResultVOUtil;
import cn.gson.oasys.common.formValid.ResultEnum;
import cn.gson.oasys.common.formValid.ResultVO;
import cn.gson.oasys.mappers.AddressMapper;
import cn.gson.oasys.model.dao.address.AddressDao;
import cn.gson.oasys.model.dao.address.AddressUserDao;
import cn.gson.oasys.model.dao.notedao.AttachService;
import cn.gson.oasys.model.dao.notedao.AttachmentDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.entity.note.Director;
import cn.gson.oasys.model.entity.note.DirectorUser;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.services.address.AddreddUserService;
import cn.gson.oasys.services.address.AddressService;
import cn.gson.oasys.services.file.FileServices;
import cn.gson.oasys.services.mail.MailServices;
import cn.gson.oasys.services.process.ProcessService;

@Controller
@RequestMapping("/")
public class AddrController {

    @Autowired
    AddressDao addressDao;
    @Autowired
    AddressService addressService;
    @Autowired
    UserDao uDao;
    @Autowired
    AddreddUserService addressUserService;
    @Autowired
    AddressMapper am;
    @Autowired
    AddressUserDao auDao;
    @Autowired
    ProcessService proservice;
    @Autowired
    FileServices fileServices;
    @Autowired
    AttachService attachService;
    @Autowired
    AttachmentDao atDao;
    @Autowired
    private MailServices mservice;
    @Autowired
    private AttachmentDao AttDao;

    /*	*//**
     * 通讯录管理
     * @param userId
     * @param model
     * @param page
     * @param size
     * @return
     *//*
	@RequestMapping("addrmanage")
	public String addrmanage(@SessionAttribute("userId") Long userId,Model model,
			@RequestParam(value="page",defaultValue="0") int page,
			@RequestParam(value="size",defaultValue="10") int size
			) {
		User user=uDao.findOne(userId);
		Set<String> catalogs=auDao.findByUser(user);
		Pageable pa=new PageRequest(page, size,new Sort(Direction.ASC, "dept"));
		Page<User> userspage=uDao.findAll(pa);
		List<User> users=userspage.getContent();
		List<DirectorUser> nothandles=auDao.findByUserAndShareuserNotNullAndHandle(user,false);
		model.addAttribute("count", nothandles.size());
		model.addAttribute("catalogs", catalogs);
		model.addAttribute("users", users);
		model.addAttribute("page", userspage);
		model.addAttribute("url", "inaddresspaging");
		return "address/addrmanage";
	}
	*/

    /*  *//**
     * 查看内部联系人
     *//*
    @RequestMapping("inmessshow")
    public String inMessShow(Model model, @RequestParam(value = "userId") Long userId) {
        User user = uDao.findOne(userId);
        model.addAttribute("user", user);
        return "address/inmessshow";
    }*/
    /*
     *//**
     * 内部通讯录表格，并处理分页
     *
     * @return
     *//*
    @RequestMapping("inaddresspaging")
    public String inAddress(@RequestParam(value = "page", defaultValue = "0") int page, Model model,
                            @RequestParam(value = "size", defaultValue = "10") int size,
                            @RequestParam(value = "baseKey", required = false) String baseKey,
                            @RequestParam(value = "alph", defaultValue = "ALL") String alph
    ) {
        Page<User> userspage = null;
        Pageable pa = new PageRequest(page, size);
        if (StringUtils.isEmpty(baseKey)) {
            if ("ALL".equals(alph)) {
                userspage = uDao.findAll(pa);
            } else {
                userspage = uDao.findByPinyinLike(alph + "%", pa);
            }
        } else {
            if ("ALL".equals(alph)) {
                userspage = uDao.findUsers("%" + baseKey + "%", baseKey + "%", pa);
            } else {
                userspage = uDao.findSelectUsers("%" + baseKey + "%", alph + "%", pa);
            }
        }
        if (!StringUtils.isEmpty(baseKey)) {
            model.addAttribute("baseKey", baseKey);
            model.addAttribute("sort", "&alph=" + alph + "&baseKey=" + baseKey);
        } else {
            model.addAttribute("sort", "&alph=" + alph);
        }
        List<User> users = userspage.getContent();
        model.addAttribute("users", users);
        model.addAttribute("page", userspage);
        model.addAttribute("url", "inaddresspaging");
        return "address/inaddrss";
    }*/

    /*   *//**
     * 外部通讯录
     *
     * @return
     *//*
    @RequestMapping("outaddresspaging")
    public String outAddress(@RequestParam(value = "pageNum", defaultValue = "1") int page, Model model,
                             @RequestParam(value = "baseKey", required = false) String baseKey,
                             @RequestParam(value = "outtype", required = false) String outtype,
                             @RequestParam(value = "alph", defaultValue = "ALL") String alph,
                             @SessionAttribute("userId") Long userId) {
        PageHelper.startPage(page, 10);
        List<Map<String, Object>> directors = am.allDirector(userId, alph, outtype, baseKey);
        List<Map<String, Object>> adds = addressService.fengzhaung(directors);
        PageInfo<Map<String, Object>> pageinfo = new PageInfo<>(directors);
        if (!StringUtils.isEmpty(outtype)) {
            model.addAttribute("outtype", outtype);
        }
        Pageable pa = new PageRequest(0, 10);

        Page<User> userspage = uDao.findAll(pa);
        List<User> users = userspage.getContent();
        model.addAttribute("modalurl", "modalpaging");
        model.addAttribute("modalpage", userspage);
        model.addAttribute("users", users);
        model.addAttribute("userId", userId);
        model.addAttribute("baseKey", baseKey);
        model.addAttribute("directors", adds);
        model.addAttribute("page", pageinfo);
        model.addAttribute("url", "outaddresspaging");
        return "address/outaddrss";
    }
   */
    /*  *//**
     * 查看外部联系人
     *//*
    @RequestMapping("outmessshow")
    public String outMessShow(Model model, @RequestParam("director") Long director, @SessionAttribute("userId") Long userId) {
        Director d = addressDao.findOne(director);
        User user = uDao.findOne(userId);
        DirectorUser du = auDao.findByDirectorAndUser(d, user);
        if (Objects.isNull(d) || Objects.isNull(du)) {
            System.out.println("权限不匹配，不能操作");
            return "redirect:/notlimit";
        }
        if (d.getAttachment() != null) {
            model.addAttribute("imgpath", atDao.findOne(d.getAttachment()).getAttachmentPath());
        } else {
            model.addAttribute("imgpath", "/timg.jpg");
        }
        model.addAttribute("d", d);

        return "address/outmessshow";
    }
*/


    /*  *//**
     * 编辑
     *
     * @return
     *//*
    @RequestMapping("addaddress")
    public String addAddress(HttpServletRequest req, @RequestParam(value = "did", required = false) Long did, HttpSession session,
                             @SessionAttribute("userId") Long userId, Model model) {
        User user = uDao.findOne(userId);
        Set<String> calogs = auDao.findByUser(user);
        model.addAttribute("calogs", calogs);
        if (!StringUtils.isEmpty(did)) {
            Director director = addressDao.findOne(did);
            System.out.println();
            if (Objects.isNull(director) || !Objects.equals(director.getMyuser().getUserId(), userId)) {
                System.out.println("权限不匹配，不能操作");
                return "redirect:/notlimit";
            }
            DirectorUser du = auDao.findByDirectorAndUser(director, user);
            model.addAttribute("director", director);
            model.addAttribute("du", du);
            session.setAttribute("did", did);
        }
        return "address/addressedit";
    }
*/

    /* *//**
     * 保存外部联系人
     *
     * @throws IOException
     * @throws IllegalStateException
     *//*
    @RequestMapping("saveaddress")
    public String saveAddress(@Valid Director director, DirectorUser directorUser, BindingResult br, @RequestParam("file") MultipartFile file, HttpSession session,
                              Model model, @SessionAttribute("userId") Long userId, HttpServletRequest req) throws PinyinException, IllegalStateException, IOException {

        User user = uDao.findOne(userId);
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            System.out.println("输入信息有误！");
        } else {
            String pinyin = PinyinHelper.convertToPinyinString(director.getUserName(), "", PinyinFormat.WITHOUT_TONE);
            director.setPinyin(pinyin);
            director.setMyuser(user);
            if (!StringUtils.isEmpty(session.getAttribute("did"))) {
                *//*修改*//*

                Long did = Long.parseLong(session.getAttribute("did") + "");
                Director di = addressDao.findOne(did);
                director.setDirectorId(di.getDirectorId());
                director.setAttachment(di.getAttachment());
                DirectorUser dc = auDao.findByDirectorAndUser(director, user);
                directorUser.setDirectorUserId(dc.getDirectorUserId());
                session.removeAttribute("did");
            }
            //试一下
            if (file.getSize() > 0) {
                Attachment attaid = mservice.upload(file, user);
                attaid.setModel("aoa_bursement");
                Attachment att = AttDao.save(attaid);
                *//*Attachment att= (Attachment) fileServices.savefile(file, user, null, false);*//*
                director.setAttachment(att.getAttachmentId());
            }

            directorUser.setHandle(true);
            directorUser.setDirector(director);
            directorUser.setUser(user);
            addressService.sava(director);
            addressUserService.save(directorUser);
        }
        return "redirect:/addrmanage";
    }*/

    /*   *//**
     * 进入分享联系人的模态框分页
     *//*
    @RequestMapping("modalshare")
    public String modalShare(@RequestParam(value = "page", defaultValue = "0") int page, Model model,
                             @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pa = new PageRequest(0, 10);
        Page<User> userspage = uDao.findAll(pa);
        List<User> users = userspage.getContent();
        model.addAttribute("modalurl", "modalpaging");
        model.addAttribute("modalpage", userspage);
        model.addAttribute("users", users);
        return "address/modalshare";
    }*/
    /*

     */
/**
 * 分享消息的业务controller
 *//*

    @RequestMapping("shareother")
    public String shareOther(@SessionAttribute("userId") Long userId, @RequestParam(value = "directors[]") Long[] directors,
                             Model model,
                             @RequestParam(value = "sharedirector") Long sharedirector) {
        User user = uDao.findOne(userId);
        Director director = addressDao.findOne(sharedirector);
        List<User> users = new ArrayList<>();
        List<DirectorUser> dus = new ArrayList<>();
        for (int i = 0; i < directors.length; i++) {
            User shareuser = uDao.findOne(directors[i]);
            System.out.println("分享的用户:" + shareuser);
            DirectorUser du = auDao.findByDirectorAndUser(director, shareuser);
            if (Objects.isNull(du)) {
                System.out.println("没找到该对象、进行保存保存");
                DirectorUser dir = new DirectorUser();
                dir.setUser(shareuser);
                dir.setShareuser(user);
                dir.setDirector(director);
                dus.add(dir);
            } else {
                System.out.println("该用户已存在该联系人，不用重复保存！");
                users.add(shareuser);
            }
        }
        for (DirectorUser directorUser : dus) {
            System.out.println("中间表：" + directorUser);
        }
        for (User u : users) {
            System.out.println("已存有该联系人的用户：" + u);
        }
        addressUserService.savaList(dus);
        if (users.size() > 0) {
            model.addAttribute("users", users);
            return "address/userhas";
        }
        return "address/sharesuccess";
    }

*/
    /*
     *//**
     * 分享模态框的分页
     *//*
  @RequestMapping("modalpaging")
    public String modalPaging(@RequestParam(value = "page", defaultValue = "0") int page, Model model,
                              @RequestParam(value = "size", defaultValue = "10") int size,
                              @RequestParam(value = "baseKey", required = false) String baseKey) {
        Pageable pa = new PageRequest(page, size);
        Page<User> userspage = null;
        List<User> users = null;
        if (!StringUtils.isEmpty(baseKey)) {
            System.out.println(baseKey);
            userspage = uDao.findUsers("%" + baseKey + "%", baseKey + "%", pa);
            model.addAttribute("baseKey", baseKey);
            model.addAttribute("sort", "&baseKey=" + baseKey);
        } else {
            userspage = uDao.findAll(pa);
        }
        users = userspage.getContent();
        model.addAttribute("modalurl", "modalpaging");
        model.addAttribute("modalpage", userspage);
        model.addAttribute("users", users);
        return "address/shareuser";
    }*/
    /*

     */
/**
 * 用户删除某个外部通讯录联系人
 *//*

    @RequestMapping("deletedirector")
    public String deleteDirector(@SessionAttribute("userId") Long userId, Model model, @RequestParam(value = "did", required = false) Long did) {
        DirectorUser du = auDao.findOne(did);
        Director director = du.getDirector();
        List<DirectorUser> dires = auDao.findByDirector(director);
        User user = uDao.findOne(userId);
        if (!Objects.equals(du.getUser().getUserId(), userId)) {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        List<DirectorUser> dus = auDao.findByCatalogNameAndUser(du.getCatalogName(), user);
        if (dus.size() > 1) {
            addressUserService.deleteObj(du);
            if (dires.size() == 1) {
                addressService.deleteDirector(du.getDirector());
                System.out.println("最后一个拥有的用户删掉了该联系人，即删掉该联系人的信息");
            }
        } else {
            */
    /*当size=1时，说明这是最后一位拥有*//*

            du.setDirector(null);
            addressUserService.save(du);
            if (dires.size() == 1) {
                addressService.deleteDirector(director);
                System.out.println("最后一个拥有的用户删掉了该联系人，即删掉该联系人的信息");
            }

        }

        return "redirect:/outaddresspaging";
    }
*/

    /* *//**
     * addtypename
     * 增加外部分类名称
     *//*
    @RequestMapping("addtypename")
    public String addTypename(@RequestParam(value = "typename", required = false) String typename,
                              @RequestParam(value = "oldtypename", required = false) String oldtypename,
                              @SessionAttribute("userId") Long userId, Model model) {
        System.out.println("进来这个了么？");
        User user = uDao.findOne(userId);
        if (oldtypename != null) {
            List<DirectorUser> dus = auDao.findByCatalogNameAndUser(oldtypename, user);
            for (DirectorUser directorUser : dus) {
                directorUser.setCatalogName(typename);
            }
            addressUserService.savaList(dus);
        } else {
            DirectorUser dc = new DirectorUser(user, typename);
            addressUserService.save(dc);
        }
        Set<String> catalogs = auDao.findByUser(user);
        System.out.println(catalogs);
        model.addAttribute("catalogs", catalogs);
        return "address/addtypename";
    }*/

    /*   *//**
     * 删除分类名称
     *//*
    @RequestMapping("deletetypename")
    public String deletetypename(@RequestParam(value = "typename") String typename, @SessionAttribute("userId") Long userId) {
        User user = uDao.findOne(userId);
        List<DirectorUser> dus = auDao.findByCatalogNameAndUser(typename, user);
        for (DirectorUser directorUser : dus) {
            directorUser.setCatalogName(null);
        }
        addressUserService.savaList(dus);
        return "redirect:/outaddresspaging";
    }*/

    /* *//**
     * 我分享的消息界面
     *//*
    @RequestMapping("mesharemess")
    public String meShareMess(@RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(value = "size", defaultValue = "5") int size,
                              @RequestParam(value = "baseKey", required = false) String baseKey,
                              Model model, @SessionAttribute("userId") Long userId
    ) {
        User user = uDao.findOne(userId);
        Pageable pa = new PageRequest(page, size, new Sort(Direction.DESC, "sharetime"));
        Page<DirectorUser> duspage = auDao.findByShareuser(user, pa);
        if (!StringUtils.isEmpty(baseKey)) {
            duspage = auDao.findBaseKey("%" + baseKey + "%", user, pa);
            model.addAttribute("sort", "&baseKey=" + baseKey);
        } else {
            duspage = auDao.findByShareuser(user, pa);
        }

        List<DirectorUser> dus = duspage.getContent();
        model.addAttribute("page", duspage);
        model.addAttribute("dus", dus);
        model.addAttribute("url", "mesharemess");
        return "address/mesharemess";
    }*/


    /*  *//**
     * 修改用户下面的外部分类
     * 根据老分类找到所有的中间表的集合
     * 再循环修改新分类名字
     *
     * @param typename
     * @param oldtypename
     * @param userId
     * @return
     *//*
    @RequestMapping("changetypename")
    public String changeTypeName(@RequestParam(value = "typename") String typename,
                                 @RequestParam(value = "oldtypename") String oldtypename,
                                 @SessionAttribute("userId") Long userId) {
        User user = uDao.findOne(userId);
        List<DirectorUser> dus = auDao.findByCatalogNameAndUser(oldtypename, user);
        for (DirectorUser directorUser : dus) {
            directorUser.setCatalogName(typename);
        }
        addressUserService.savaList(dus);
        return "redirect:/outaddresspaging";

    }


    *//**
     * 分享给我的消息的界面
     *//*
    @RequestMapping("sharemess")
    public String shareMess(@RequestParam(value = "page", defaultValue = "0") int page,
                            @RequestParam(value = "size", defaultValue = "5") int size,
                            @RequestParam(value = "baseKey", required = false) String baseKey,
                            @RequestParam(value = "catalog", required = false) String catalog,
                            @RequestParam(value = "duid", required = false) Long duid,
                            Model model, @SessionAttribute("userId") Long userId) {
        User user = uDao.findOne(userId);
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Direction.ASC, "handle"));
        orders.add(new Order(Direction.DESC, "sharetime"));
        Sort sort = new Sort(orders);
        Pageable pa = new PageRequest(page, size, sort);
        Page<DirectorUser> duspage = auDao.findByShareuser(user, pa);
        if (!StringUtils.isEmpty(duid)) {
            DirectorUser du = auDao.findOne(duid);
            System.out.println();
            du.setCatalogName(catalog);
            du.setHandle(true);
            addressUserService.save(du);
        }
        if (!StringUtils.isEmpty(baseKey)) {
            duspage = auDao.findBaseKey("%" + baseKey + "%", user, pa);
            model.addAttribute("sort", "&baseKey=" + baseKey);
        } else {
            duspage = auDao.findByUserAndShareuserNotNull(user, pa);
        }
        Set<String> catalogs = auDao.findByUser(user);
        System.out.println(catalogs);
        model.addAttribute("catalogs", catalogs);
        List<DirectorUser> dus = duspage.getContent();
        model.addAttribute("page", duspage);
        model.addAttribute("dus", dus);
        model.addAttribute("url", "sharemess");
        return "address/sharemess";
    }
*/

    /**
     * 将外部通讯录联系人改变分类；
     */
    @RequestMapping("changethistype")
    public @ResponseBody
    Boolean changeType(@RequestParam(value = "did") Long did, @SessionAttribute("userId") Long userId, @RequestParam(value = "catalog") String catalog) {
        System.out.println("did:" + did);
        System.out.println("catalog:" + catalog);
        User user = uDao.findOne(userId);
        Director d = addressDao.findOne(did);
        DirectorUser du = auDao.findByDirectorAndUser(d, user);
        du.setCatalogName(catalog);
        addressUserService.save(du);
        System.out.println("执行成功！");
        return true;
    }


    //============================================
    @Resource
    private UserPOServiceV2 UserPOServiceV2;
    @Resource
    private DirectorUserPOServiceV2 directorUserPOServiceV2;
    @Resource
    private DeptPOServiceV2 DeptPOServiceV2;
    @Resource
    private PositionPOServiceV2 PositionPOServiceV2;
    @Resource
    private RoleServiceV2 roleServiceV2;
    @Resource
    private DirectorManageServiceAllV2 directorManageServiceAllV2;
    @Resource
    private DirectorPOServiceV2 directorPOServiceV2;
    @Resource
    private AttachmentServiceV2 attachmentServiceV2;
    @Resource
    private MailServiceV2 mailServiceV2;

    /**
     * 通讯录管理
     *
     * @param userId
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("addrmanage")
    public String addressManage(@SessionAttribute("userId") Long userId, Model model,
                                @RequestParam(value = "page", defaultValue = "1") int page,
                                @RequestParam(value = "size", defaultValue = "10") int size) {
        Set<String> catalogsNameSet = directorUserPOServiceV2.getCatalogNameByUserId(userId);//根据用户ID和目录名非空非""找目录用户信息（从中取出目录名并去重）
        List<UserPO> userPOListAll = UserPOServiceV2.getUserAll();//所有用户
        getSubUserVOList(model, page, size, userPOListAll);
        List<DirectorUsersPO> directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndShareUserNotNullAndHandle(userId, false);
        model.addAttribute("count", directorUsersPOList.size());
        model.addAttribute("catalogs", catalogsNameSet);// 所有去重的目录名
        model.addAttribute("url", "inaddresspaging");
        return "address/addrmanage";
    }

    /**
     * 所有用户分页信息
     *
     * @param model
     * @param page
     * @param size
     */
    public void getSubUserVOList(Model model, int page, int size, List<UserPO> userPOListALl) {
        List<UserVO> userVOListALL = UserFactoryVO.createUserVOList(userPOListALl);
        for (UserPO userPO : userPOListALl) {
            for (UserVO userVO : userVOListALL) {
                if (userPO.getUserId().equals(userVO.getUserId())) {
                    DeptVO deptVO = DeptFactoryVO.createDeptVO(DeptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId()));
                    userVO.setDeptVO(deptVO);
                    PositionVO positionVO = PositionFactoryVO.createPositionVO(PositionPOServiceV2.getPositionPOByPositionId(userPO.getPositionId()));
                    userVO.setPositionVO(positionVO);
                }
            }
        }
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(userVOListALL.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > userVOListALL.size()) {
            end = userVOListALL.size();
        }
        List<UserVO> userVOList = userVOListALL.subList(start, end);
        model.addAttribute("page", pageBO);
        model.addAttribute("users", userVOList);
    }


    /**
     * 查看内部联系人
     */
    @RequestMapping("inmessshow")
    public String inMessShow(Model model, @RequestParam(value = "userId") Long userId) {
        UserPO userPO = UserPOServiceV2.getUserPOByUserId(userId);//登录用户信息
        UserVO userVO = UserFactoryVO.createUserVO(userPO);
        PositionVO positionVO = PositionFactoryVO.createPositionVO(PositionPOServiceV2.getPositionPOByPositionId(userPO.getPositionId()));
        DeptVO deptVO = DeptFactoryVO.createDeptVO(DeptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId()));
        RoleVO roleVO = RoleFactoryVO.createRoleVO(roleServiceV2.getRoleByRoleId(userPO.getRoleId()));
        userVO.setPositionVO(positionVO);
        userVO.setDeptVO(deptVO);
        userVO.setRoleVO(roleVO);
        model.addAttribute("user", userVO);
        return "address/inmessshow";
    }

    /**
     * 内部通讯录表格，并处理分页
     *
     * @return
     */
    @RequestMapping("inaddresspaging")
    public String inAddressPage(@RequestParam(value = "page", defaultValue = "1") int page, Model model,
                                @RequestParam(value = "size", defaultValue = "10") int size,
                                @RequestParam(value = "baseKey", required = false) String baseKey,
                                @RequestParam(value = "alph", defaultValue = "ALL") String alphabet) {
        List<UserPO> userPOList;
        if (StringUtils.isEmpty(baseKey)) {//模糊字是空的
            if ("ALL".equals(alphabet)) {
                userPOList = UserPOServiceV2.getUserAll();//所有用户
            } else {
                userPOList = UserPOServiceV2.getUserByPinyinLike(alphabet);//根据拼音首字母模糊查找用户
            }
        } else {//存在模糊搜索字
            if ("ALL".equals(alphabet)) {
                userPOList = UserPOServiceV2.getUserPOListByUserNameLikeOrUserTelLikeOrDeptNameLikeOrPositionNameLikeOrPinyinLikeAndPinyinLike(baseKey, alphabet);
            } else {
                userPOList = UserPOServiceV2.getUserPOListByUserNameLikeOrUserTelLikeOrDeptNameLikeOrPositionNameLikeOrPinyinLikeAndPinyinLike(baseKey, alphabet);
            }
            //重点*****
//            if ("ALL".equals(alph)) {
//                userspage = uDao.findUsers("%" + baseKey + "%", baseKey + "%", pa);
//            } else {
//                userspage = uDao.findSelectUsers("%" + baseKey + "%", alph + "%", pa);
//            }
        }
        if (!StringUtils.isEmpty(baseKey)) {
            model.addAttribute("baseKey", baseKey);
            model.addAttribute("sort", "&alph=" + alphabet + "&baseKey=" + baseKey);
        } else {
            model.addAttribute("sort", "&alph=" + alphabet);
        }
        getSubUserVOList(model, page, size, userPOList);
        model.addAttribute("url", "inaddresspaging");
        return "address/inaddrss";
    }

    /**
     * 外部通讯录
     *
     * @return
     */
    @RequestMapping("outaddresspaging")
    public String outAddress(@RequestParam(value = "pageNum", defaultValue = "1") int page, Model model,
                             @RequestParam(value = "baseKey", required = false) String baseKey,
                             @RequestParam(value = "outtype", required = false) String outType,
                             @RequestParam(value = "alph", defaultValue = "ALL") String alphabet,
                             @SessionAttribute("userId") Long userId) {
//        List<Map<String, Object>> directors = am.allDirector(userId, alph, outtype, baseKey);
        List<Map<String, Object>> adds = directorManageServiceAllV2.getDirectorPOAndDirectorUserPOPackage(userId, alphabet, outType, baseKey);
        getPage(model, page, 10, adds);

        if (!StringUtils.isEmpty(outType)) {
            model.addAttribute("outtype", outType);
        }
//        List<UserPO> userPOListAll = UserPOServiceV2.getUserAll();//所有用户
//        getSubUserVOList(model, page, 10, userPOListAll);
        model.addAttribute("userId", userId);
        model.addAttribute("baseKey", baseKey);

//        model.addAttribute("modalurl", "modalpaging");
//        model.addAttribute("url", "outaddresspaging");
        return "address/outaddrss";
    }

    /**
     * 外部通讯录分页信息
     *
     * @param model
     * @param page
     * @param size
     * @param list  外部通讯录用户信息
     */
    public void getPage(Model model, int page, int size, List<Map<String, Object>> list) {
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(list.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > list.size()) {
            end = list.size();
        }
        List<Map<String, Object>> subMapList = list.subList(start, end);
        model.addAttribute("page", pageBO);
        model.addAttribute("directors", subMapList);
        model.addAttribute("userVOList", subMapList);
        model.addAttribute("modalurl", "modalpaging");
        model.addAttribute("url", "outaddresspaging");
    }


    /**
     * 查看外部联系人
     *
     * @param model
     * @param directorId 外部通讯录用户ID
     * @param userId     登录人用户ID
     * @return
     */
    @RequestMapping("outmessshow")
    public String outMessShow(Model model, @RequestParam("director") Long directorId, @SessionAttribute("userId") Long userId) {
        UserPO userPO = UserPOServiceV2.getUserPOByUserId(userId);// 登录人信息
        UserVO userVO = UserPOServiceV2.getUserVOByUserPO(userPO);
        DirectorPO directorPO = directorPOServiceV2.getDirectorPOByDirectorPOId(directorId);//外部通讯人信息
        DirectorUsersPO directorUsersPO = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndDirectorPOId(userId, directorId);//根据用户ID和外部用户ID找外部用户信息
        if (Objects.isNull(directorPO) || Objects.isNull(directorUsersPO)) {
            System.out.println("权限不匹配，不能操作");
            return "redirect:/notlimit";
        }
        if (directorPO.getImagePath() != null) {
            String imagePath = attachmentServiceV2.getAttachmentPathByFileId(directorPO.getImagePath().longValue());
//            model.addAttribute("imgpath", imagePath);//还需修改
            model.addAttribute("imgpath", "/timg.jpg");
        } else {
            model.addAttribute("imgpath", "/timg.jpg");
        }
        model.addAttribute("d", directorPO);
        model.addAttribute("userVO", userVO);
        return "address/outmessshow";
    }

    /**
     * 编辑(新建联系人）
     *
     * @return
     */
    @RequestMapping("addaddress")
    public String addAddress(HttpServletRequest req, @RequestParam(value = "did", required = false) Long directorPOId, HttpSession session,
                             @SessionAttribute("userId") Long userId, Model model) {
        Set<String> catalogsNameSet = directorUserPOServiceV2.getCatalogNameByUserId(userId);//根据用户ID和目录名非空非""找目录用户信息（从中取出目录名并去重）        User user = uDao.findOne(userId);
        model.addAttribute("calogs", catalogsNameSet);//外部目录名去重
        if (!StringUtils.isEmpty(directorPOId)) {//修改
            DirectorPO directorPO = directorPOServiceV2.getDirectorPOByDirectorPOId(directorPOId);
            if (Objects.isNull(directorPO) || !Objects.equals(directorPO.getUserId(), userId)) {
                System.out.println("权限不匹配，不能操作");
                return "redirect:/notlimit";
            }
            DirectorUsersPO directorUsersPO = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndDirectorPOId(userId, directorPOId);
            model.addAttribute("director", directorPO);//外部用户信息
            model.addAttribute("du", directorUsersPO);//外部用户关联表信息
            session.setAttribute("did", directorPOId);//外部通讯录ID
        }
        return "address/addressedit";
    }

    /**
     * 保存外部联系人
     *
     * @throws IOException
     * @throws IllegalStateException
     */
    @RequestMapping("saveaddress")
    public String saveAddress(@Valid DirectorVO directorVO, DirectorUserVO directorUserVO, BindingResult br, @RequestParam("file") MultipartFile file, HttpSession session,
                              Model model, @SessionAttribute("userId") Long userId, HttpServletRequest req) throws PinyinException, IllegalStateException, IOException {
        UserPO userPO = UserPOServiceV2.getUserPOByUserId(userId);
        ResultVO res = BindingResultVOUtil.hasErrors(br);
        if (!ResultEnum.SUCCESS.getCode().equals(res.getCode())) {
            System.out.println("输入信息有误！");
        } else {
            String pinyin = PinyinHelper.convertToPinyinString(directorVO.getUserName(), "", PinyinFormat.WITHOUT_TONE);
            DirectorPO directorPO = new DirectorPO();
            directorPO.setPinyin(pinyin);
            directorPO.setUserId(userId);
            directorPO.setUserName(directorVO.getUserName());
            directorPO.setSex(directorVO.getSex());
            directorPO.setPhoneNumber(directorVO.getPhoneNumber());
            directorPO.setRemark(directorVO.getRemark());
            directorPO.setAddress(directorVO.getAddress());
            directorPO.setEmail(directorVO.getEmail());
            directorPO.setCompanyname(directorVO.getCompanyName());
            directorPO.setCompanyNumber(directorVO.getCompanyNumber());
            DirectorUsersPO directorUsersPO = new DirectorUsersPO();
            if (!StringUtils.isEmpty(session.getAttribute("did"))) {//获取外部通讯录ID（directorId）
                /*修改*/
                Long directorId = Long.parseLong(session.getAttribute("did") + "");
                DirectorPO updateDirectorPO = directorPOServiceV2.getDirectorPOByDirectorPOId(directorId);
                directorPO.setDirectorId(directorId);
                directorPO.setImagePath(updateDirectorPO.getImagePath());
                DirectorUsersPO updateDirectorUsersPO = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndDirectorPOId(userId, directorId);
                directorUsersPO.setDirectorUsersId(updateDirectorUsersPO.getDirectorUsersId());//目录用户ID（关联表）
                session.removeAttribute("did");
            }
            //试一下
            if (file.getSize() > 0) {
                AttachmentListPO attachmentListPO = mailServiceV2.uploadAttachmentListPOByUser(file, userPO);
                attachmentListPO.setModel("aoa_bursement");
                attachmentServiceV2.insertAttachmentListPO(attachmentListPO);//插入附件
                directorPO.setImagePath(attachmentListPO.getAttachmentId().intValue());
                /*Attachment att= (Attachment) fileServices.savefile(file, user, null, false);*/
            }
            DirectorPO insertOrUpdateDirectorPO = directorPOServiceV2.insertOrUpdateDirectorPOByDirectorPO(directorPO);
            directorUsersPO.setIsHandle(1);
            directorUsersPO.setDirectorId(insertOrUpdateDirectorPO.getDirectorId());
            directorUsersPO.setUserId(userId);
            directorUsersPO.setCatelogName(directorUserVO.getCatalogName());
            directorUsersPO.setSharetime(new Date());
            directorUserPOServiceV2.insertOrUpdateDirectorUsersPOByDirectorUsersPO(directorUsersPO);
        }
        return "redirect:/addrmanage";
    }

    /**
     * 进入分享联系人的模态框分页
     */
    @RequestMapping("modalshare")
    public String modalShare(@RequestParam(value = "page", defaultValue = "1") int page, Model model,
                             @RequestParam(value = "size", defaultValue = "10") int size) {
        List<UserPO> userPOList = UserPOServiceV2.getUserAll();
        List<UserVO> userVOList = UserFactoryVO.createUserVOList(userPOList);
        for (UserPO userPO : userPOList) {
            for (UserVO userVO : userVOList) {
                if (userPO.getUserId().equals(userVO.getUserId())) {
                    DeptVO deptVO = DeptFactoryVO.createDeptVO(DeptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId()));
                    userVO.setDeptVO(deptVO);
                    PositionVO positionVO = PositionFactoryVO.createPositionVO(PositionPOServiceV2.getPositionPOByPositionId(userPO.getPositionId()));
                    userVO.setPositionVO(positionVO);
                }
            }
        }
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(userVOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > userVOList.size()) {
            end = userVOList.size();
        }
        List<UserVO> subUserVOList = userVOList.subList(start, end);
//        model.addAttribute("url", "modalpaging");//找控制器路径
//        model.addAttribute("page", pageBO);
        model.addAttribute("modalurl", "modalpaging");
        model.addAttribute("modalpage", pageBO);
        model.addAttribute("users", subUserVOList);
        return "address/modalshare";
    }


    /**
     * 分享消息的业务controller
     *
     * @param userId       登录ID
     * @param directors    分享的用户IDs
     * @param model
     * @param directorPOId 外部用户ID
     * @return
     */
    @RequestMapping("shareother")
    public String shareOther(@SessionAttribute("userId") Long userId,
                             @RequestParam(value = "directors[]") Long[] directors,
                             Model model,
                             @RequestParam(value = "sharedirector") Long directorPOId) {
        List<UserPO> userPOS = new ArrayList<>();//用户列表
        List<DirectorUsersPO> directorUsersPOS = new ArrayList<>();//外部用户通讯录
        for (int i = 0; i < directors.length; i++) {
            UserPO shareUserPO = UserPOServiceV2.getUserPOByUserId(directors[i]);//被分享用户的信息（接收的用户）
            //分享用户信息和外部用户ID
            DirectorUsersPO directorUsersPO = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndDirectorPOId(directors[i], directorPOId);
            if (Objects.isNull(directorUsersPO)) {
                DirectorUsersPO dir = new DirectorUsersPO();
                dir.setUserId(directors[i]);//被动接收的用户ID
                dir.setShareUserId(userId);//主动分享的用户
                dir.setDirectorId(directorPOId);//被分享的外部用户信息
                dir.setSharetime(new Date());
                dir.setIsHandle(0);//???????????
                directorUsersPOS.add(dir);
            } else {
                userPOS.add(shareUserPO);//该联系人已经存在
            }
        }
        for (DirectorUsersPO directorUsersPO : directorUsersPOS) {
            directorUserPOServiceV2.insertOrUpdateDirectorUsersPOByDirectorUsersPO(directorUsersPO);
        }
        if (userPOS.size() > 0) {
            getSubUserVOList(model, 1, 10, userPOS);
            return "address/userhas";
        }
        return "address/sharesuccess";
    }


    /**
     * 分享模态框的分页
     */
    @RequestMapping("modalpaging")
    public String modalPaging(@RequestParam(value = "page", defaultValue = "1") int page, Model model,
                              @RequestParam(value = "size", defaultValue = "10") int size,
                              @RequestParam(value = "baseKey", required = false) String baseKey) {
        List<UserPO> userPOList = null;
        if (!StringUtils.isEmpty(baseKey)) {
            userPOList = UserPOServiceV2.getUserPOListByUserNameLikeOrUserTelLikeOrDeptNameLikeOrPositionNameLikeOrPinyinLikeAndPinyinLike(baseKey, null);
            model.addAttribute("baseKey", baseKey);
            model.addAttribute("sort", "&baseKey=" + baseKey);
        } else {
            userPOList = UserPOServiceV2.getUserAll();
        }
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(userPOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (userPOList.size() < end) {
            end = userPOList.size();
        }
        List<UserPO> subUserPOList = userPOList.subList(start, end);//用户的页面信息
        List<UserVO> subUserVOList = UserFactoryVO.createUserVOList(subUserPOList);
        for (UserPO userPO : subUserPOList) {
            for (UserVO userVO : subUserVOList) {
                if (userPO.getUserId().equals(userVO.getUserId())) {
                    userVO.setDeptVO(DeptFactoryVO.createDeptVO(DeptPOServiceV2.getDeptPOByDeptId(userPO.getDeptId())));
                    userVO.setPositionVO(PositionFactoryVO.createPositionVO(PositionPOServiceV2.getPositionPOByPositionId(userPO.getPositionId())));
                }
            }
        }

        model.addAttribute("modalurl", "modalpaging");
        model.addAttribute("modalpage", pageBO);
        model.addAttribute("users", subUserVOList);
        return "address/shareuser";
    }


    /**
     * 用户删除某个外部通讯录联系人
     *
     * @param userId
     * @param model
     * @param did    用户目录ID
     * @return
     */
    @RequestMapping("deletedirector")
    public String deleteDirector(@SessionAttribute("userId") Long userId,
                                 Model model,
                                 @RequestParam(value = "did", required = false) Long did) {
        DirectorUsersPO directorUsersPO = directorUserPOServiceV2.getDirectorUsersPOByDirectorUsersPOId(did);//用户目录信息
        DirectorPO directorPO = directorPOServiceV2.getDirectorPOByDirectorPOId(directorUsersPO.getDirectorId());//外部用户信息
        //外部用户在关联表中的所有信息
        List<DirectorUsersPO> directorUsersPOS = directorUserPOServiceV2.getDirectorUsersPOSByDirectorPOId(directorPO.getDirectorId());
        if (!Objects.equals(directorUsersPO.getUserId(), userId)) {
            System.out.println("权限不匹配，不能删除");
            return "redirect:/notlimit";
        }
        List<DirectorUsersPO> directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndCatalogName(userId, directorUsersPO.getCatelogName());
        if (directorUsersPOList.size() > 1) {
            directorUserPOServiceV2.deleteDirectorUsersPOByDirectorUsersPOId(did);
            if (directorUsersPOS.size() == 1) {
                directorPOServiceV2.deleteDirectorPOByDirectorPOId(directorUsersPO.getDirectorId());
            }
        } else {
            directorUsersPO.setDirectorId(null);
            directorUserPOServiceV2.updateDirectorUsersPOByDirectorUsersPO(directorUsersPO);
            if (directorUsersPOS.size() == 1) {
                directorPOServiceV2.deleteDirectorPOByDirectorPOId(directorPO.getDirectorId());
            }
        }
        return "redirect:/outaddresspaging";
    }

    /**
     * 增加外部分类名称
     */
    @RequestMapping("addtypename")
    public String addTypeName(@RequestParam(value = "typename", required = false) String typeName,
                              @RequestParam(value = "oldtypename", required = false) String oldTypeName,
                              @SessionAttribute("userId") Long userId, Model model) {
        if (oldTypeName != null) {
            List<DirectorUsersPO> directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndCatalogName(userId, oldTypeName);
            for (DirectorUsersPO directorUsersPO : directorUsersPOList) {
                directorUsersPO.setCatelogName(typeName);
                directorUserPOServiceV2.updateDirectorUsersPOByDirectorUsersPO(directorUsersPO);
            }
        } else {
            DirectorUsersPO directorUsersPO = new DirectorUsersPO();
            directorUsersPO.setUserId(userId);
            directorUsersPO.setCatelogName(typeName);
            directorUsersPO.setIsHandle(0);
            directorUsersPO.setSharetime(new Date());
            directorUserPOServiceV2.insertOrUpdateDirectorUsersPOByDirectorUsersPO(directorUsersPO);
        }
        Set<String> catalogsNameSet = directorUserPOServiceV2.getCatalogNameByUserId(userId);//根据用户ID和目录名非空非""找目录用户信息（从中取出目录名并去重）
        model.addAttribute("catalogs", catalogsNameSet);
        return "address/addtypename";
    }

    /**
     * 删除分类名称
     */
    @RequestMapping("deletetypename")
    public String deleteTypeName(@RequestParam(value = "typename") String typeName,
                                 @SessionAttribute("userId") Long userId) {
        List<DirectorUsersPO> directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndCatalogName(userId, typeName);
        for (DirectorUsersPO directorUsersPO : directorUsersPOList) {
            directorUsersPO.setCatelogName(null);
            directorUserPOServiceV2.updateDirectorUsersPOByDirectorUsersPO(directorUsersPO);
        }
        return "redirect:/outaddresspaging";
    }

    /**
     * 我分享的消息界面
     */
    @RequestMapping("mesharemess")
    public String meShareMess(@RequestParam(value = "page", defaultValue = "1") int page,
                              @RequestParam(value = "size", defaultValue = "5") int size,
                              @RequestParam(value = "baseKey", required = false) String baseKey,
                              Model model, @SessionAttribute("userId") Long userId) {
        List<DirectorUsersPO> directorUsersPOList;
        if (!StringUtils.isEmpty(baseKey)) {
            directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOSByUserIdAndShareUserIdIsNotNUllAndDirectorUserNameLike(baseKey, userId);
            model.addAttribute("sort", "&baseKey=" + baseKey);
        } else {
            directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOSByShareUserId(userId);
        }
//        if (!StringUtils.isEmpty(baseKey)) {
//            duspage = auDao.findBaseKey("%" + baseKey + "%", user, pa);
//            model.addAttribute("sort", "&baseKey=" + baseKey);
//        } else {
//            duspage = auDao.findByShareuser(user, pa);
//        }
        getDirectorUserPOPage(model, page, size, directorUsersPOList);
        model.addAttribute("url", "mesharemess");
        return "address/mesharemess";
    }

    //对中间表进行分页
    public void getDirectorUserPOPage(Model model, int page, int size, List<DirectorUsersPO> directorUsersPOList) {
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(directorUsersPOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > directorUsersPOList.size()) {
            end = directorUsersPOList.size();
        }
        List<DirectorUsersPO> subDiretorUserPOList = directorUsersPOList.subList(start, end);
        List<DirectorUserVO> subDirectorUserVOList = DirectorUserVOFactory.createDirectorUserVOSByDirectorUserPOS(subDiretorUserPOList);
        for (DirectorUsersPO directorUsersPO : subDiretorUserPOList) {
            for (DirectorUserVO directorUserVO : subDirectorUserVOList) {
                if (directorUsersPO.getDirectorUsersId().equals(directorUserVO.getDirectorUserId())) {
                    DirectorPO directorPO = directorPOServiceV2.getDirectorPOByDirectorPOId(directorUsersPO.getDirectorId());
                    directorUserVO.setDirectorVO(DirectoryVOFactory.createDirectoryVOByDirectoryPO(directorPO));
                    UserPO userPO = UserPOServiceV2.getUserPOByUserId(directorUsersPO.getUserId());
                    UserVO userVO = UserPOServiceV2.getUserVOByUserPO(userPO);
                    directorUserVO.setUserVO(userVO);
                }
            }
        }
        model.addAttribute("page", pageBO);
        model.addAttribute("dus", subDirectorUserVOList);
    }


    /**
     * 修改用户下面的外部分类
     * 根据老分类找到所有的中间表的集合
     * 再循环修改新分类名字
     *
     * @param typeName
     * @param oldTypeName
     * @param userId
     * @return
     */
    @RequestMapping("changetypename")
    public String changeTypeName(@RequestParam(value = "typename") String typeName,
                                 @RequestParam(value = "oldtypename") String oldTypeName,
                                 @SessionAttribute("userId") Long userId) {
        List<DirectorUsersPO> directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOByUserIdAndCatalogName(userId, oldTypeName);
        for (DirectorUsersPO directorUsersPO : directorUsersPOList) {
            directorUsersPO.setCatelogName(typeName);
            directorUserPOServiceV2.updateDirectorUsersPOByDirectorUsersPO(directorUsersPO);
        }
        return "redirect:/outaddresspaging";

    }


    /**
     * 分享给我的消息的界面
     *
     * @param page
     * @param size
     * @param baseKey
     * @param catalog
     * @param directorUsersPOId
     * @param model
     * @param userId
     * @return
     */
    @RequestMapping("sharemess")
    public String shareMess(@RequestParam(value = "page", defaultValue = "1") int page,
                            @RequestParam(value = "size", defaultValue = "5") int size,
                            @RequestParam(value = "baseKey", required = false) String baseKey,
                            @RequestParam(value = "catalog", required = false) String catalog,
                            @RequestParam(value = "duid", required = false) Long directorUsersPOId,
                            Model model, @SessionAttribute("userId") Long userId) {
        List<DirectorUsersPO> directorUsersPOList;
        if (!StringUtils.isEmpty(directorUsersPOId)) {
            DirectorUsersPO directorUsersPO = directorUserPOServiceV2.getDirectorUsersPOByDirectorUsersPOId(directorUsersPOId);
            directorUsersPO.setCatelogName(catalog);
            directorUsersPO.setIsHandle(1);
            directorUserPOServiceV2.insertOrUpdateDirectorUsersPOByDirectorUsersPO(directorUsersPO);
        }
        if (!StringUtils.isEmpty(baseKey)) {
            directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOSByUserIdAndShareUserIdIsNotNUllAndDirectorUserNameLike(baseKey, userId);
            model.addAttribute("sort", "&baseKey=" + baseKey);
        } else {
            directorUsersPOList = directorUserPOServiceV2.getDirectorUsersPOSByUserIdAndShareUserIdIsNotNull(userId);
        }
//        if (!StringUtils.isEmpty(baseKey)) {
//            duspage = auDao.findBaseKey("%" + baseKey + "%", user, pa);
//            model.addAttribute("sort", "&baseKey=" + baseKey);
//        } else {
//            duspage = auDao.findByUserAndShareuserNotNull(user, pa);
//        }
        getDirectorUserPOPage(model, page, size, directorUsersPOList);
        Set<String> catalogsNameSet = directorUserPOServiceV2.getCatalogNameByUserId(userId);//根据用户ID和目录名非空非""找目录用户信息（从中取出目录名并去重）
        model.addAttribute("catalogs", catalogsNameSet);
        model.addAttribute("url", "sharemess");
        return "address/sharemess";
    }


}
