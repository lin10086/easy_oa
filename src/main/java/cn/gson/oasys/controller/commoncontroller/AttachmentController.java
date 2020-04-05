package cn.gson.oasys.controller.commoncontroller;

import cn.gson.oasys.modelV2.po.AttachmentListPO;
import cn.gson.oasys.serviceV2.attachmentV2.AttachmentServiceV2;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/")
public class AttachmentController {
    @Resource
    AttachmentServiceV2 attachmentServiceV2;

    private String attachmentRootPath;
    private String userRootPath;

    @PostConstruct
    public void UserpanelController() {
        try {
            attachmentRootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources/static/attachment");
            userRootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources");
        } catch (IOException e) {
            System.out.println("获取项目路径异常");
        }
    }

    /**
     * 下载文件
     *
     * @param response
     * @param fileId
     */
    @RequestMapping("file")
    public void downFile(HttpServletResponse response, @RequestParam("fileid") Long fileId) {
        try {
            //获取附件信息
            AttachmentListPO attachmentListPO = attachmentServiceV2.getAttachmentListPOByAttachmentListPOId(fileId);
            //附件的全路径
            File file = new File(attachmentRootPath, attachmentListPO.getAttachmentPath());
            response.setContentLength(Integer.parseInt(attachmentListPO.getAttachmentSize()));
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(attachmentListPO.getAttachmentName().getBytes("UTF-8"), "ISO8859-1"));
//            写文件
            attachmentServiceV2.writeFile(response, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片预览
     *
     * @param model
     * @param response
     * @param userId
     * @param request
     * @throws IOException
     */
    @RequestMapping("show/**")
    public void image(Model model, HttpServletResponse response, @SessionAttribute("userId") Long userId, HttpServletRequest request)
            throws IOException {

        String startpath = new String(URLDecoder.decode(request.getRequestURI(), "utf-8"));

        String path = startpath.replace("/show", "");

        File f = new File(attachmentRootPath, path);
        System.out.println(f.getAbsolutePath());
        ServletOutputStream sos = response.getOutputStream();
        FileInputStream input = new FileInputStream(f.getPath());
        byte[] data = new byte[(int) f.length()];
        IOUtils.readFully(input, data);
//        将文件流输出到浏览器
        IOUtils.write(data, sos);
        input.close();
        sos.close();
    }


    /**
     * 下载文件
     *
     * @param response
     * @param fileid
     *//*
    @RequestMapping("file")
    public void downFile(HttpServletResponse response, @RequestParam("fileid") Long fileid) {
        try {
            Attachment attd = AttDao.findOne(fileid);
            File file = new File(rootpath, attd.getAttachmentPath());
            response.setContentLength(attd.getAttachmentSize().intValue());
            response.setContentType(attd.getAttachmentType());
            response.setHeader("Content-Disposition", "attachment;filename=" + new String(attd.getAttachmentName().getBytes("UTF-8"), "ISO8859-1"));
            proservice.writeFile(response, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    */
    /**
     * 图片预览
     *
     * @param model
     * @param response
     * @param userId
     * @param request
     * @throws IOException
     *//*
    @RequestMapping("show/**")
    public void image(Model model, HttpServletResponse response, @SessionAttribute("userId") Long userId, HttpServletRequest request)
            throws IOException {

        String startpath = new String(URLDecoder.decode(request.getRequestURI(), "utf-8"));

        String path = startpath.replace("/show", "");

        File f = new File(rootpath, path);
        System.out.println(f.getAbsolutePath());
        ServletOutputStream sos = response.getOutputStream();
        FileInputStream input = new FileInputStream(f.getPath());
        byte[] data = new byte[(int) f.length()];
        IOUtils.readFully(input, data);
         将文件流输出到浏览器
        IOUtils.write(data, sos);
        input.close();
        sos.close();
    }
*/

}
