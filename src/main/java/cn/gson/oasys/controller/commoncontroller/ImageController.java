package cn.gson.oasys.controller.commoncontroller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.PostConstruct;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/")
public class ImageController {
    //	@Value("${img.rootpath}")
    private String rootpath;
    private String userRootPath;

    @PostConstruct
    public void UserpanelController() {
        try {
//            rootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources/attachment");
            rootpath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources/static");
            userRootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources");

        } catch (IOException e) {
            System.out.println("获取项目路径异常");
        }
    }
    @RequestMapping("image/**")
    public void image(Model model, HttpServletResponse response, @SessionAttribute("userId") Long userId, HttpServletRequest request)
            throws Exception {
        String projectPath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        System.out.println(projectPath);
        String startpath = new String(URLDecoder.decode(request.getRequestURI(), "utf-8"));

        String path = startpath.replace("/image", "static/images/user");

        File f = new File(userRootPath, path);

        ServletOutputStream sos = response.getOutputStream();
        FileInputStream input = new FileInputStream(f.getPath());
        byte[] data = new byte[(int) f.length()];
        IOUtils.readFully(input, data);
        // 将文件流输出到浏览器
        IOUtils.write(data, sos);
        input.close();
        sos.close();
    }
}
