package cn.gson.oasys.modelV2.bo;

import cn.gson.oasys.modelV2.po.AttendsPO;
import cn.gson.oasys.modelV2.po.UserPO;
import cn.gson.oasys.serviceV2.attendansV2.AttendanceServiceV2;
import cn.gson.oasys.voandfactory.attendansVO2.AttendancesVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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


}
