package cn.gson.oasys.modelV2.bo;

import cn.gson.oasys.modelV2.po.AttendsPO;
import cn.gson.oasys.modelV2.po.NoticeListPO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.serviceV2.attendansV2.AttendanceServiceV2;
import cn.gson.oasys.voandfactory.attendansVO2.AttendancesVO;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class PageInformation {
    @Resource
    private AttendanceServiceV2 attendanceServiceV2;

    /**
     * 考勤分页信息
     *
     * @param page
     * @param size
     * @param attendsPOList
     * @param request
     * @return
     */
    public List<AttendancesVO> getAttendancesVOListPage(int page, int size, List<AttendsPO> attendsPOList, HttpServletRequest request) {
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(attendsPOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (end > attendsPOList.size()) {
            end = attendsPOList.size();
        }
        List<AttendsPO> subAttendsPOList = attendsPOList.subList(start, end);
        List<AttendancesVO> attendanceVOList = attendanceServiceV2.getAttendancesVOListByAttendancesPOList(subAttendsPOList);
        //把考勤页面的引用page2放到请求对象的page中
        request.setAttribute("page", pageBO);
        return attendanceVOList;
    }

    /**
     * 用户分页
     *
     * @param page
     * @param size
     * @param userPOList
     * @param request
     * @return
     */
    public List<UserPO> getUserPOListPage(int page, int size, List<UserPO> userPOList, HttpServletRequest request) {
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(userPOList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (userPOList.size() < end) {
            end = userPOList.size();
        }
        List<UserPO> subUserPOList = userPOList.subList(start, end);//用户的页面信息
        request.setAttribute("page", pageBO);
        return subUserPOList;
    }

    /**
     * 对通知公告列表进行分页
     *
     * @param page
     * @param size
     * @param noticeListPOS
     * @param model
     * @return
     */
    public List<NoticeListPO> getNoticeListPOSPage(int page, int size, List<NoticeListPO> noticeListPOS, Model model) {
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(noticeListPOS.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (noticeListPOS.size() < end) {
            end = noticeListPOS.size();
        }
        List<NoticeListPO> subNoticeListPOS = noticeListPOS.subList(start, end);
        model.addAttribute("page", pageBO);
        return subNoticeListPOS;
    }

    /**
     * 对通知和通知用户关联表整合进行分页
     *
     * @param page
     * @param size
     * @param mapList
     * @param model
     * @return
     */
    public List<Map<String, Object>> getMapListPage(int page, int size, List<Map<String, Object>> mapList, Model model) {
        PageBO pageBO = new PageBO(page, size);
        pageBO.setTotalCount(mapList.size());
        int start = (pageBO.getPageNo() - 1) * pageBO.getPageSize();
        int end = pageBO.getPageNo() * pageBO.getPageSize();
        if (mapList.size() < end) {
            end = mapList.size();
        }
        List<Map<String, Object>> subMapList = mapList.subList(start, end);
        model.addAttribute("page", pageBO);
        return subMapList;
    }


}
