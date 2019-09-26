//package cn.gson.oasys.services.attendance;
//
//import cn.gson.oasys.mappers.StatusMapper;
//import cn.gson.oasys.mappers.TypeMapper;
//import cn.gson.oasys.mappers.UserMapper;
//import cn.gson.oasys.model.entity.StatusEntity;
//import cn.gson.oasys.model.entity.TypeEntity;
//import cn.gson.oasys.model.entity.UserEntity;
//import cn.gson.oasys.model.entity.attendce.Attends;
//import cn.gson.oasys.model.entity.system.SystemStatusList;
//import cn.gson.oasys.model.entity.system.SystemTypeList;
//import cn.gson.oasys.model.entity.user.User;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.ui.Model;
//import org.springframework.util.StringUtils;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import java.util.ArrayList;
//import java.util.List;
//
//public class AttendanceServices {
//
//    @Resource
//    UserMapper userMapper;
//    @Resource
//    TypeMapper typeMapper;
//    @Resource
//    StatusMapper statusMapper;
//
//    List<UserEntity>users;
//
//    public void allsortpaging(HttpServletRequest request, HttpSession session, int page, String baseKey, String type,
//                               String status, String time, String icon, Model model) {
//        //设置model里面的属性
//        setModelSomething(baseKey, type, status, time, icon, model);
//        //从session里面获取用户ID
//        Integer userId = Integer.parseInt(session.getAttribute("userId").toString());
//        //创建Long类型的集合ids用于存放查询到的用户ID
//        List<Integer> ids = new ArrayList<>();
//        //根据上司ID查询到下属用户
//       // List<User> users = uDao.findByFatherId(userId);
//        users=userMapper.selectFatherUserIds(userId);
//        //遍历查询到的 下属用户
//        for (UserEntity user : users) {
//            //获取下属用户的ID并添加到以创建的集合ids中
//            ids.add(user.getUserId());
//        }
//        //如果集合中的size为0说明没有用户，把0添加进去
//        if (ids.size() == 0) {
//            ids.add(0);
//        }
//        //根据上司的ID查询上司的用户信息
//       // User user = uDao.findOne(userId);
//        UserEntity user=userMapper.selectFatherUserId(userId);
//        //把类型状态列表设置到请求对象里面
//        typestatus(request);
//        //根据下属用户ID，类型，状态，时间来分页查询，把结果放到考勤页面里面
//        Page<Attends> page2 = attendceService.paging(page, baseKey, ids,type, status, time);
//        //获取考勤页面的内容放到请求对象的alist里面
//        request.setAttribute("alist", page2.getContent());
//        //把考勤页面的引用page2放到请求对象的page中
//        request.setAttribute("page", page2);
//        //设置请求对象的url为attendcetable
//        request.setAttribute("url", "attendcetable");
//    }
//
//
//    /**
//     * 设置model里面的属性
//     * @param baseKey
//     * @param type考勤类型
//     * @param status考勤状态
//     * @param time考勤时间
//     * @param icon
//     * @param model模型
//     */
//    public void setModelSomething(String baseKey, Object type, Object status, Object time, Object icon, Model model) {
//        if(!StringUtils.isEmpty(icon)){
//            //如果icon不为空把icon添加到model中
//            model.addAttribute("icon", icon);
//            if(!StringUtils.isEmpty(type)){
//                //如果type不为空把type添加到mode中
//                model.addAttribute("type", type);
//                if("1".equals(type)){
//                    model.addAttribute("sort", "&type=1&icon="+icon);
//                }else{
//                    model.addAttribute("sort", "&type=0&icon="+icon);
//                }
//            }
//            if(!StringUtils.isEmpty(status)){
//                //如果状态不为空把状态status添加到mode中
//                model.addAttribute("status", status);
//                if("1".equals(status)){
//                    //如果状态是1把icon添加到mode中
//                    model.addAttribute("sort", "&status=1&icon="+icon);
//                }else{
//                    //如果状态是0把icon添加到mode中
//                    model.addAttribute("sort", "&status=0&icon="+icon);
//                }
//            }
//            if(!StringUtils.isEmpty(time)){
//                model.addAttribute("time", time);
//                if("1".equals(time)){
//                    model.addAttribute("sort", "&time=1&icon="+icon);
//                }else{
//                    model.addAttribute("sort", "&time=0&icon="+icon);
//                }
//            }
//        }
//        if(!StringUtils.isEmpty(baseKey)){
//            model.addAttribute("sort", "&baseKey="+baseKey);
//        }
//    }
//    // 状态类型方法
//    private void typestatus(HttpServletRequest request) {
//        //获取模型里面的类型放到类型列表集合里面
//       // List<SystemTypeList> type = (List<SystemTypeList>) typeDao.findByTypeModel("aoa_attends_list");
//        List<TypeEntity>type=typeMapper.selectTypeModel("aoa_attends_list");
//        //获取模型里面的状态放到状态列表集合里面
//       // List<SystemStatusList> status = (List<SystemStatusList>) statusDao.findByStatusModel("aoa_attends_list");
//        List<StatusEntity> status = statusMapper.selectStatusModel("aoa_attends_list");
//        request.setAttribute("typelist", type);
//        request.setAttribute("statuslist", status);
//    }
//
//    // 分页
//    public Page<Attends> paging(int page, String baseKey, List<Long> user, Object type, Object status, Object time) {
//        Pageable pa =new PageRequest(page, 10);
//        if (!StringUtils.isEmpty(baseKey)) {
//            // 模糊查询
//            return attendceDao.findsomemohu(baseKey, user, pa);
//        }if (!StringUtils.isEmpty(type)) {
//            if(type.toString().equals("0")){
//                //降序
//                return attendceDao.findByUserOrderByTypeIdDesc(user, pa);
//            }else{System.out.println("22");
//                //升序
//                return attendceDao.findByUserOrderByTypeIdAsc(user, pa);
//            }
//        }
//        if (!StringUtils.isEmpty(status)) {
//            if(status.toString().equals("0")){
//                return attendceDao.findByUserOrderByStatusIdDesc(user, pa);
//            }else{
//                return attendceDao.findByUserOrderByStatusIdAsc(user, pa);
//            }
//        }
//        if (!StringUtils.isEmpty(time)) {
//            if(time.toString().equals("0")){
//                return attendceDao.findByUserOrderByAttendsTimeDesc(user, pa);
//            }else{
//                return attendceDao.findByUserOrderByAttendsTimeAsc(user, pa);
//            }
//        }
//        else {
//            return attendceDao.findByUserOrderByAttendsTimeDesc(user, pa);
//        }
//    }
//
//}
