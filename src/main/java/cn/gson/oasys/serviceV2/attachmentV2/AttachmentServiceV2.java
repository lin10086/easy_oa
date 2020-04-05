package cn.gson.oasys.serviceV2.attachmentV2;

import cn.gson.oasys.mappers.AttachmentListPOMapper;
import cn.gson.oasys.modelV2.po.AttachmentListPO;
import cn.gson.oasys.modelV2.po.UserPO;
import com.github.pagehelper.util.StringUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class AttachmentServiceV2 {
    //附件路径
    private String attachmentRootPath;
    //图片路径
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


    @Resource
    private AttachmentListPOMapper attachmentListPOMapper;

    /**
     * 设置附件的model信息并插入附件
     *
     * @param attachmentListPO
     */
    public void insertAttachmentListPOSetModel(AttachmentListPO attachmentListPO, String setModel) {
        attachmentListPO.setModel(setModel);
        attachmentListPOMapper.insertSelective(attachmentListPO);
    }

    /**
     * 插入附件
     *
     * @param attachmentListPO
     */
    public void insertAttachmentListPO(AttachmentListPO attachmentListPO) {
        attachmentListPOMapper.insertSelective(attachmentListPO);
    }


    /**
     * 更新附件
     *
     * @param attachmentName
     * @param attachmentPath
     * @param shuffix
     * @param size
     * @param type
     * @param upTime
     * @param attachmentId
     */
    public Integer updateAttachmentListPO(String attachmentName, String attachmentPath, String shuffix, Long size, String type, Date upTime, Long attachmentId) {
        AttachmentListPO attachmentListPO = new AttachmentListPO();
        attachmentListPO.setAttachmentId(attachmentId);
        attachmentListPO.setAttachmentName(attachmentName);
        attachmentListPO.setAttachmentPath(attachmentPath);
        attachmentListPO.setAttachmentShuffix(shuffix);
        attachmentListPO.setAttachmentSize(size + "");
        attachmentListPO.setAttachmentType(type);
        attachmentListPO.setUploadTime(upTime);
        Integer rows = attachmentListPOMapper.updateByPrimaryKeySelective(attachmentListPO);
        return rows;
    }

    /**
     * 根据附件ID找附件信息
     *
     * @param attachmentListPOId
     * @return
     */
    public AttachmentListPO getAttachmentListPOByAttachmentListPOId(Long attachmentListPOId) {
        AttachmentListPO attachmentListPO = attachmentListPOMapper.selectByPrimaryKey(attachmentListPOId);
        return attachmentListPO;
    }

    /**
     * 根据附件ID找附件存储路径
     *
     * @param attachmentListPOId 附件ID
     * @return
     */
    public String getAttachmentPathByFileId(Long attachmentListPOId) {
        AttachmentListPO attachmentListPO = attachmentListPOMapper.selectByPrimaryKey(attachmentListPOId);
        String attachmentPath = attachmentListPO.getAttachmentPath();
        return attachmentPath;
    }


    /**
     * 上传附件
     *
     * @param file
     * @param applyUserPO 登录人
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public AttachmentListPO uploadAttachmentListPO(MultipartFile file, UserPO applyUserPO) throws IllegalStateException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(attachmentRootPath, simpleDateFormat.format(new Date()));//把年月作为附件路径
        //用当前时间的年月和用户名做文件夹名
        File savePath = new File(root, applyUserPO.getUserName());
        // 文件夹是否存在，不存在就创建
        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        //获取原始文件名
        String fileName = file.getOriginalFilename();
        if (!StringUtil.isEmpty(fileName)) {
            //获取文件后缀名
            String suffix = FilenameUtils.getExtension(fileName);
            //新文件名
            String newFileName = UUID.randomUUID().toString().toLowerCase() + "." + suffix;
            //文件夹 文件名
            File targetFile = new File(savePath, newFileName);
            //上传文件
            file.transferTo(targetFile);
            //保存到数据库的附件路径
            String str = targetFile.getPath().replace(attachmentRootPath, "");

            AttachmentListPO attachmentPO = new AttachmentListPO();
            attachmentPO.setAttachmentName(file.getOriginalFilename());
            attachmentPO.setAttachmentPath(str);
            attachmentPO.setAttachmentShuffix(suffix);
            attachmentPO.setAttachmentSize(file.getSize() + "");
            attachmentPO.setAttachmentType(file.getContentType());
            attachmentPO.setUploadTime(new Date());
            attachmentPO.setUserId(applyUserPO.getUserId() + "");
            return attachmentPO;
        }
        return null;
    }

    /**
     * 上传附件(用户图像）
     *
     * @param file
     * @param applyUserPO 登录人
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public AttachmentListPO uploadAttachmentListPOByUserImg(MultipartFile file, UserPO applyUserPO) throws IllegalStateException, IOException {
        File filePath = new File(userRootPath + "/static/images/user");

        if (!filePath.exists()) {
            filePath.mkdirs();
        }
        File savePath = new File(userRootPath + "/static/images/user");
        String fileSavePath = savePath.getAbsolutePath();
        //获取原始文件名
        String fileName = file.getOriginalFilename();
        if (!StringUtil.isEmpty(fileName)) {
            //获取文件后缀名
            String suffix = FilenameUtils.getExtension(fileName);
            //新文件名
            String newFileName = UUID.randomUUID().toString().toLowerCase() + "." + suffix;
            //文件夹 文件名
            File targetFile = new File(savePath, newFileName);
            file.transferTo(targetFile);

            String str = targetFile.getPath().replace(fileSavePath, "");

            AttachmentListPO attachmentPO = new AttachmentListPO();
            attachmentPO.setAttachmentName(file.getOriginalFilename());
            attachmentPO.setAttachmentPath(str);
            attachmentPO.setAttachmentShuffix(suffix);
            attachmentPO.setAttachmentSize(file.getSize() + "");
            attachmentPO.setAttachmentType(file.getContentType());
            attachmentPO.setUploadTime(new Date());
            attachmentPO.setUserId(applyUserPO.getUserId() + "");
            return attachmentPO;
        }
        return null;
    }

    /**
     * 写文件 方法
     *
     * @param response
     * @param file
     * @throws IOException
     */
    public void writeFile(HttpServletResponse response, File file) {
        ServletOutputStream sos = null;
        FileInputStream aa = null;
        try {
            aa = new FileInputStream(file);
            sos = response.getOutputStream();
            // 读取文件问字节码
            byte[] data = new byte[(int) file.length()];
            IOUtils.readFully(aa, data);
            // 将文件流输出到浏览器
            IOUtils.write(data, sos);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                sos.close();
                aa.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
