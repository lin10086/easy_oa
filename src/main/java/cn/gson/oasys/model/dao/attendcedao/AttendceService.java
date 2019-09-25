package cn.gson.oasys.model.dao.attendcedao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.gson.oasys.common.StringtoDate;
import cn.gson.oasys.model.dao.system.StatusDao;
import cn.gson.oasys.model.dao.system.TypeDao;
import cn.gson.oasys.model.dao.user.UserDao;
import cn.gson.oasys.model.dao.user.UserService;
import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.user.User;

@Service
@Transactional
public class AttendceService {

    @Autowired
    AttendceDao attendceDao;
    @Autowired
    AttendceService attendceService;
    @Autowired
    UserDao uDao;
    @Autowired
    UserService userService;
    @Autowired
    TypeDao typeDao;
    @Autowired
    StatusDao statusDao;

    List<Attends> alist;
    List<User> uList;
    Date start, end;
    String month_;
    // 格式转化导入
    DefaultConversionService service = new DefaultConversionService();


    // 删除
    public Integer delete(long aid) {
        return attendceDao.delete(aid);
    }

    // 更改考勤时间
    public Integer updatetime(Date date, String hourmin, Long statusIdlong, long attid) {
        return attendceDao.updateatttime(date, hourmin, statusIdlong, attid);
    }

    // 更新备注
    public Integer updatereamrk(String attendsRemark, long attendsId) {
        return attendceDao.updateremark(attendsRemark, attendsId);
    }

    //查找在这个时间段的每个用户的考勤
//	public Page<Attends> findoneweekatt(int page, String baseKey, Date start,Date end, List<Long> user) {
//		Pageable pa =new PageRequest(page, 10);
//		if (!StringUtils.isEmpty(baseKey)) {
//			// 模糊查询
//		}else{
//			return attendceDao.findoneweek(start, end, user, pa);
//		}
//		return null;
//		
//	}

    // 分页
    public Page<Attends> paging(int page, String baseKey, List<Long> user, Object type, Object status, Object time) {
        Pageable pa = new PageRequest(page, 10);
        if (!StringUtils.isEmpty(baseKey)) {
            // 模糊查询
            return attendceDao.findsomemohu(baseKey, user, pa);
        }
        if (!StringUtils.isEmpty(type)) {
            if (type.toString().equals("0")) {
                //降序
                return attendceDao.findByUserOrderByTypeIdDesc(user, pa);
            } else {
                System.out.println("22");
                //升序
                return attendceDao.findByUserOrderByTypeIdAsc(user, pa);
            }
        }
        if (!StringUtils.isEmpty(status)) {
            if (status.toString().equals("0")) {
                return attendceDao.findByUserOrderByStatusIdDesc(user, pa);
            } else {
                return attendceDao.findByUserOrderByStatusIdAsc(user, pa);
            }
        }
        if (!StringUtils.isEmpty(time)) {
            if (time.toString().equals("0")) {
                return attendceDao.findByUserOrderByAttendsTimeDesc(user, pa);
            } else {
                return attendceDao.findByUserOrderByAttendsTimeAsc(user, pa);
            }
        } else {
            return attendceDao.findByUserOrderByAttendsTimeDesc(user, pa);
        }
    }

    // 单个用户分页
    public Page<Attends> singlepage(int page, String baseKey, long userid, Object type, Object status, Object time) {
        Pageable pa = new PageRequest(page, 10);
        //0为降序 1为升序
        if (!StringUtils.isEmpty(baseKey)) {
            // 查询
            System.out.println(baseKey);
            attendceDao.findonemohu(baseKey, userid, pa);
        }
        if (!StringUtils.isEmpty(type)) {
            if (type.toString().equals("0")) {
                //降序
                return attendceDao.findByUserOrderByTypeIdDesc(userid, pa);
            } else {
                //升序
                return attendceDao.findByUserOrderByTypeIdAsc(userid, pa);
            }
        }
        if (!StringUtils.isEmpty(status)) {
            if (status.toString().equals("0")) {
                return attendceDao.findByUserOrderByStatusIdDesc(userid, pa);
            } else {
                return attendceDao.findByUserOrderByStatusIdAsc(userid, pa);
            }
        }
        if (!StringUtils.isEmpty(time)) {
            if (time.toString().equals("0")) {
                return attendceDao.findByUserOrderByAttendsTimeDesc(userid, pa);
            } else {
                return attendceDao.findByUserOrderByAttendsTimeAsc(userid, pa);
            }
        } else {
            // 第几页 以及页里面数据的条数
            return attendceDao.findByUserOrderByAttendsTimeDesc(userid, pa);
        }

    }

    //考勤周报表分页
    public void weektablepaging(HttpServletRequest request, HttpSession session, int page, String baseKey) {
        //获取开始时间
        String starttime = request.getParameter("starttime");
        //获取结束时间
        String endtime = request.getParameter("endtime");
        // 格式转化
        service.addConverter(new StringtoDate());
        //第一个类型表示原类型，第二个类型表示目标类型，然后里面定义了一个convert方法，
        //将原类型对象作为参数传入进行转换之后返回目标类型对象
        //Date.class获取Date中的一个对象
        Date startdate = service.convert(starttime, Date.class);
        Date enddate = service.convert(endtime, Date.class);

        //用来查找该用户下面管理的所有用户信息
        //获取用户的ID
        Long userId = Long.parseLong(session.getAttribute("userId") + "");
        List<Long> ids = new ArrayList<>();
        //获取userId下的所有用户的信息
        Page<User> userspage = userService.findmyemployuser(page, baseKey, userId);
        for (User user : userspage) {
            //遍历所有用户信息并把用户ID加到ids中
            ids.add(user.getUserId());
        }
        if (ids.size() == 0) {
            ids.add(0L);
        }

        //找到某个管理员下面的所有用户的信息 保证传过来的是正确的数据 分页之后可以使用全局变量来
        //记住开始和结束日期
        if (startdate != null && enddate != null) {
            start = startdate;
            end = enddate;
        }
        if (startdate == null && enddate == null)
            startdate = start;
        enddate = end;
        System.out.println("再次获取" + startdate + "结束" + enddate);
        //把一周的靠勤的考勤放到alist 里面
        List<Attends> alist = attendceDao.findoneweek(startdate, enddate, ids);
        for (User user : userspage) {
            Set<Attends> attenceset = new HashSet<>();

            for (Attends attence : alist) {
                if (Objects.equals(attence.getUser().getUserId(), user.getUserId())) {
                    attenceset.add(attence);
                }
            }
            user.setaSet(attenceset);
        }
        String[] weekday = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        request.setAttribute("ulist", userspage.getContent());
        request.setAttribute("page", userspage);
        request.setAttribute("weekday", weekday);
        request.setAttribute("url", "realweektable");
    }


}
