package cn.gson.oasys.controller.attendanceV2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("v2/")
public class AttendanceControllerV2 {
    @Resource
    AttendanceControllerV2 attendanceControllerV2;

    @RequestMapping("attendceatt")
    public String testdasf(HttpServletRequest request, HttpSession session) {

        return "";
    }


}
