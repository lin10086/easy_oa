package cn.gson.oasys.ServiceV2.fileV2;

import cn.gson.oasys.mappers.AttachmentListPOMapper;
import cn.gson.oasys.mappers.FileListPOMapper;
import cn.gson.oasys.mappers.FilePathPOMapper;
import cn.gson.oasys.model.entity.file.FileList;
import cn.gson.oasys.model.entity.file.FilePath;
import cn.gson.oasys.model.po.AttachmentListPO;
import cn.gson.oasys.model.po.FileListPO;
import cn.gson.oasys.model.po.FilePathPO;
import cn.gson.oasys.model.po.UserPO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class FileServiceV2 {

    @Resource
    private FilePathServiceV2 filePathServiceV2;
    @Resource
    private FileListServiceV2 fileListServiceV2;
    @Resource
    private FileListPOMapper fileListPOMapper;
    @Resource
    private FilePathPOMapper filePathPOMapper;
    @Resource
    private AttachmentListPOMapper attachmentListPOMapper;

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
     *
     * @param file
     * @param userPO
     * @param nowpath
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public Object saveFile(MultipartFile file, UserPO userPO, FilePathPO nowpath, boolean isfile) throws IllegalStateException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath, simpleDateFormat.format(new Date()));//根目录+日期年月

        File savePath = new File(root, userPO.getUserName());
        System.out.println(savePath.getPath());

        if (!savePath.exists()) {
            savePath.mkdirs();
        }

        String shuffix = FilenameUtils.getExtension(file.getOriginalFilename());//获取文件的扩展名
        log.info("shuffix:{}", shuffix);
        String newFileName = UUID.randomUUID().toString().toLowerCase() + "." + shuffix;
        File targetFile = new File(savePath, newFileName);
        file.transferTo(targetFile);//把文件存在项目里

        if (isfile) {//使用上传
            FileListPO fileListPO = new FileListPO();//新件文件
            String filename = file.getOriginalFilename();// 原始文件名
            filename = onlyname(filename, nowpath, shuffix, 1, true);
            fileListPO.setFileName(filename);//文件名
            fileListPO.setFilePath(targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""));//设置文件路径
            fileListPO.setFileShuffix(shuffix);//文件扩展名
            fileListPO.setSize(file.getSize());//文件大小
            fileListPO.setUploadTime(new Date());//上传时间
            fileListPO.setPathId(nowpath.getPathId());//文件路径id
            fileListPO.setContentType(file.getContentType());//文件类型
            fileListPO.setFileUserId(userPO.getUserId());
            fileListPOMapper.insertSelective(fileListPO);
            return fileListPO;
        } else {
            AttachmentListPO attachmentListPO = new AttachmentListPO();
            attachmentListPO.setAttachmentName(file.getOriginalFilename());
            attachmentListPO.setAttachmentPath(targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""));
            attachmentListPO.setAttachmentShuffix(shuffix);
            attachmentListPO.setAttachmentSize(file.getSize() + "");
            attachmentListPO.setAttachmentType(file.getContentType());
            attachmentListPO.setUploadTime(new Date());
            attachmentListPO.setUserId(userPO.getUserId() + "");
            attachmentListPO.setModel("note");
            attachmentListPOMapper.insertSelective(attachmentListPO);
            return attachmentListPO;
        }
    }

    /**
     * 文件以及路径得同名处理
     *
     * @param name
     * @param filepath
     * @param shuffix
     * @param num
     * @return
     */
    public String onlyname(String name, FilePathPO filepath, String shuffix, int num, boolean isfile) {
        Object f = null;
        if (isfile) {
            //根据文件名和路径id找文件
            f = fileListServiceV2.getFileListPOByFileNameAndPathId(name, filepath.getPathId());
//            f = fldao.findByFileNameAndFpath(name, filepath);
        } else {
            //根据路径名和父id找路径
            f = filePathServiceV2.getFilePathPOByFilePathNameAndParentId(filepath.getPathId(), name);
//            f = fpdao.findByPathNameAndParentId(name, filepath.getId());
        }
        if (f != null) {
            int num2 = num - 1;
            if (shuffix == null) {
                name = name.replace("(" + num2 + ")", "") + "(" + num + ")";
            } else {
                name = name.replace("." + shuffix, "").replace("(" + num2 + ")", "") + "(" + num + ")" + "." + shuffix;
            }
            num += 1;
            return onlyname(name, filepath, shuffix, num, isfile);
        }
        return name;
    }


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

    /**
     * 找当前文件的所有父级附录
     *
     * @param filePathPO
     * @param filePathPOList
     */
    public void allFilePathPOParent(FilePathPO filePathPO, List<FilePathPO> filePathPOList) {
        if (filePathPO.getParentId() != 1L) {
            FilePathPO filePathPO1 = filePathServiceV2.getFilePathPOByPathId(filePathPO.getParentId());//根据路径id找路径信息
            filePathPOList.add(filePathPO1);
            allFilePathPOParent(filePathPO1, filePathPOList);
        }

    }


    /**
     * 根据文件id将文件放入回收站
     *
     * @param fileIds           文件的ids
     * @param setIsTrashHowMany 是否是垃圾文件
     * @param userId            用户id
     */
    @Transactional
    public void trashFile(List<Long> fileIds, Long setIsTrashHowMany, Long userId) {
        for (Long fileId : fileIds) {
            // 根据文件id找出文件
            FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(fileId);
            //把文件路径id设为null,并设置为垃圾文件
            fileListServiceV2.updateFileListPOByIsTrash(userId, setIsTrashHowMany, fileListPO);
        }
    }


    /**
     * 根据文件夹id批量放入回收战
     *
     * @param pathIds           文件路径ids
     * @param setistrashhaomany 是否是垃圾文件
     * @param isFirst
     */
    public void trashPath(List<Long> pathIds, Long setistrashhaomany, boolean isFirst) {
        for (Long pathId : pathIds) {
            FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(pathId);// 根据路径id获取当前的路径信息
            List<FileListPO> fileListPOS = fileListServiceV2.getFileListPOByFilePathId(filePathPO.getPathId());//根据路径id找文件列表
            //首先将此文件夹下的文件放入回收战
            if (!fileListPOS.isEmpty()) {
                List<Long> fileIds = new ArrayList<>();
                for (FileListPO fileListPO : fileListPOS) {
                    fileIds.add(fileListPO.getFileId());
                }
                trashFile(fileIds, 1L, null);
            }
            //然后将此文件夹下的文件夹放入回收战
            List<FilePathPO> filePathPOList = filePathServiceV2.getFilePathPOListByParentId(pathId);
            if (!filePathPOList.isEmpty()) {
//				System.out.println("此文件夹下还有文件夹");
                List<Long> pathIds2 = new ArrayList<>();
                for (FilePathPO filePathPO1 : filePathPOList) {
                    pathIds2.add(filePathPO1.getPathId());
                }
//				System.out.println("接下来尽心递归调用");
                trashPath(pathIds2, 1L, false);
            }
//			System.out.println("此文件下下再无文件夹");
            if (isFirst) {
                filePathPO.setParentId(0L);
            }
            filePathPO.setPathIstrash(setistrashhaomany);
            filePathPOMapper.updateByPrimaryKeySelective(filePathPO);
        }
    }

    /**
     * 根据文件id 批量 删除文件  同时删除 数据库以及本地文件
     *
     * @param fileids
     */
   /* @Transactional
    public void deleteFile(List<Long> fileids){
        for (Long fileid : fileids) {
            FileList filelist = fldao.findOne(fileid);

            File file = new File(this.rootPath,filelist.getFilePath());
            //System.out.println(fileid+":"+file.exists());
            if(file.exists()&&file.isFile()){
                System.out.println("现在删除"+filelist.getFileName()+"数据库存档>>>>>>>>>");
                fldao.delete(fileid);
                System.out.println("现在删除"+filelist.getFileName()+"本地文件    >>>>>>>>>");
                file.delete();
            }
        }
    }*/

    /**
     * 更新文件的isShare字段
     *
     * @param fileIds
     */
    @Transactional
    public void doShare(List<Long> fileIds) {
        for (Long fileId : fileIds) {
            FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(fileId);
            fileListServiceV2.updateFileListPOIsShare(fileListPO);
        }

    }


}
