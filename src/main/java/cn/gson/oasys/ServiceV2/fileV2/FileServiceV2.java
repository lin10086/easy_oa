package cn.gson.oasys.ServiceV2.fileV2;

import cn.gson.oasys.model.entity.file.FileList;
import cn.gson.oasys.model.entity.file.FilePath;
import cn.gson.oasys.model.entity.note.Attachment;
import cn.gson.oasys.model.entity.user.User;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileServiceV2 {


    private String rootPath;

    @PostConstruct
    public void UserpanelController() {
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources/attachment");
        } catch (IOException e) {
            System.out.println("获取项目路径异常");
        }
    }


    /**
     * 保存文件以及附件
     * @param file
     * @param user
     * @param nowpath
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
   /* public Object savefile(MultipartFile file, User user, FilePath nowpath, boolean isfile) throws IllegalStateException, IOException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath,simpleDateFormat.format(new Date()));

        File savepath = new File(root,user.getUserName());
        //System.out.println(savePath.getPath());

        if (!savepath.exists()) {
            savepath.mkdirs();
        }

        String shuffix = FilenameUtils.getExtension(file.getOriginalFilename());
        log.info("shuffix:{}",shuffix);
        String newFileName = UUID.randomUUID().toString().toLowerCase()+"."+shuffix;
        File targetFile = new File(savepath,newFileName);
        file.transferTo(targetFile);

        if(isfile){
            FileList filelist = new FileList();
            String filename = file.getOriginalFilename();
            filename = onlyname(filename,nowpath,shuffix,1,true);
            filelist.setFileName(filename);
            filelist.setFilePath(targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""));
            filelist.setFileShuffix(shuffix);
            filelist.setSize(file.getSize());
            filelist.setUploadTime(new Date());
            filelist.setFpath(nowpath);
            filelist.setContentType(file.getContentType());
            filelist.setUser(user);
            fldao.save(filelist);
            return filelist;
        }else{
            Attachment attachment=new Attachment();
            attachment.setAttachmentName(file.getOriginalFilename());
            attachment.setAttachmentPath(targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""));
            attachment.setAttachmentShuffix(shuffix);
            attachment.setAttachmentSize(file.getSize());
            attachment.setAttachmentType(file.getContentType());
            attachment.setUploadTime(new Date());
            attachment.setUserId(user.getUserId()+"");
            attachment.setModel("note");
            AttDao.save(attachment);
            return attachment;
        }
    }
*/

    //修改附件
 /*   public Integer updateatt(MultipartFile file,User user,FilePath nowpath,long attid) throws IllegalStateException, IOException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath,simpleDateFormat.format(new Date()));

        File savepath = new File(root,user.getUserName());
        //System.out.println(savePath.getPath());

        if (!savepath.exists()) {
            savepath.mkdirs();
        }
        if(!file.isEmpty()){
            String shuffix = FilenameUtils.getExtension(file.getOriginalFilename());
            log.info("shuffix:{}",shuffix);
            String newFileName = UUID.randomUUID().toString().toLowerCase()+"."+shuffix;
            File targetFile = new File(savepath,newFileName);
            file.transferTo(targetFile);


            return AttachService.updateatt(file.getOriginalFilename(),
                    targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""), shuffix, file.getSize(),
                    file.getContentType(), new Date(), attid);
        }
        return 0;
    }*/


}
