package cn.gson.oasys.ServiceV2.fileV2;

import cn.gson.oasys.ServiceV2.AttachmentServiceV2;
import cn.gson.oasys.ServiceV2.UserServiceV2;
import cn.gson.oasys.mappers.AttachmentListPOMapper;
import cn.gson.oasys.mappers.FileListPOMapper;
import cn.gson.oasys.mappers.FilePathPOMapper;
import cn.gson.oasys.model.entity.file.FileList;
import cn.gson.oasys.model.entity.file.FilePath;
import cn.gson.oasys.model.po.AttachmentListPO;
import cn.gson.oasys.model.po.FileListPO;
import cn.gson.oasys.model.po.FilePathPO;
import cn.gson.oasys.model.po.UserPO;
import cn.gson.oasys.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.*;
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
    private AttachmentServiceV2 attachmentServiceV2;
    @Resource
    private UserServiceV2 userServiceV2;
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
            filename = onlyname(filename, nowpath.getPathId(), shuffix, 1, true);
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
     * @param pathId  路径id
     * @param shuffix
     * @param num
     * @return
     */
    public String onlyname(String name, Long pathId, String shuffix, int num, boolean isfile) {
        Object f = null;
        if (isfile) {
            //根据文件名和路径id找文件
            f = fileListServiceV2.getFileListPOByFileNameAndPathId(name, pathId);
        } else {
            //根据路径名和父id找路径
            f = filePathServiceV2.getFilePathPOByFilePathNameAndParentId(pathId, name);
        }
        if (f != null) {
            int num2 = num - 1;
            if (shuffix == null) {
                name = name.replace("(" + num2 + ")", "") + "(" + num + ")";
            } else {
                name = name.replace("." + shuffix, "").replace("(" + num2 + ")", "") + "(" + num + ")" + "." + shuffix;
            }
            num += 1;
            return onlyname(name, pathId, shuffix, num, isfile);
        }
        return name;
    }


    //修改附件
    public Integer updateattchment(MultipartFile file, UserVO userVO, FilePathPO nowpathPO, long attachmentId) throws IllegalStateException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath, simpleDateFormat.format(new Date()));

        File savepath = new File(root, userVO.getUserName());
        //System.out.println(savePath.getPath());

        if (!savepath.exists()) {
            savepath.mkdirs();
        }
        if (!file.isEmpty()) {
            String shuffix = FilenameUtils.getExtension(file.getOriginalFilename());
            log.info("shuffix:{}", shuffix);
            String newFileName = UUID.randomUUID().toString().toLowerCase() + "." + shuffix;
            File targetFile = new File(savepath, newFileName);
            file.transferTo(targetFile);


            return attachmentServiceV2.updateAttachmentListPO(file.getOriginalFilename(),
                    targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""), shuffix, file.getSize(),
                    file.getContentType(), new Date(), attachmentId);
        }
        return 0;
    }

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
            List<FilePathPO> filePathPOList = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(pathId, 0L);
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
     * 根据文件ids更新文件的isShare字段
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


    /**
     * 重命名业务方法
     *
     * @param name      从前端接收的修改名字
     * @param reNameFp  要修改的文件id或文件夹id
     * @param nowPathId 文件夹路径id
     * @param isFile    是不是文件
     */
    public void rename(String name, Long reNameFp, Long nowPathId, boolean isFile) {
        if (isFile) {
            //文件名修改
            FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(reNameFp);//根据要修改的文件id找文件
            String newName = onlyname(name, fileListPO.getPathId(), fileListPO.getFileShuffix(), 1, isFile);//新名字
            fileListServiceV2.updateFileListPOFileName(fileListPO, newName);// 更新文件名字
        } else {
            //文件夹名修改
            FilePathPO updateFilePathPO = filePathServiceV2.getFilePathPOByPathId(reNameFp);//根据要修改的文件夹id找文件夹路径
            FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(nowPathId);//文件夹的路径id找文件夹路径信息
            String newName = onlyname(name, filePathPO.getPathId(), null, 1, false);
            filePathServiceV2.updateFilePathPOPathName(newName, updateFilePathPO);//根据文件夹新名字和要更新的文件夹路径信息修改文件夹名
        }
    }



    /* */

    /**
     * 复制和移动
     *
     * @param fromWhere 1为移动  2 为复制
     */
    @Transactional
    public void moveAndCopy(List<Long> mcFileIds, List<Long> mcPathIds, Long toPathId, boolean fromWhere, Long userId) {
        FilePathPO topath = filePathServiceV2.getFilePathPOByPathId(toPathId);
        if (fromWhere) {//移动
            if (!mcFileIds.isEmpty()) {
                for (Long mcFileId : mcFileIds) {
                    FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(mcFileId);
                    String fileName = onlyname(fileListPO.getFileName(), topath.getPathId(), fileListPO.getFileShuffix(), 1, true);
                    fileListPO.setPathId(topath.getPathId());
                    fileListPO.setFileName(fileName);
                    fileListPOMapper.updateByPrimaryKeySelective(fileListPO);
                }
            }
            if (!mcPathIds.isEmpty()) {
                for (Long mcPathId : mcPathIds) {
                    FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(mcPathId);
                    String name = onlyname(filePathPO.getPathName(), toPathId, null, 1, false);
                    filePathPO.setParentId(toPathId);
                    filePathPO.setPathName(name);
                    filePathPOMapper.updateByPrimaryKeySelective(filePathPO);
                }
            }
        } else {//复制
            if (!mcFileIds.isEmpty()) {
                for (Long mcFileId : mcFileIds) {
                    FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(mcFileId);
                    copyFile(fileListPO, topath, true);
                }
            }
            if (!mcPathIds.isEmpty()) {
                for (Long mcPathId : mcPathIds) {
                    copyPath(mcPathId, toPathId, true, userId);
                }
            }
        }
    }

    public void copyPath(Long mcPathId, Long toPathId, boolean isFirst, Long userId) {
        FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(mcPathId);
        FilePathPO copyPath = new FilePathPO();
        copyPath.setParentId(toPathId);
        String copyPathName = filePathPO.getPathName();
        if (isFirst) {
            copyPathName = "拷贝 " + filePathPO.getPathName().replace("拷贝 ", "");
        }
        copyPath.setPathName(copyPathName);
        copyPath.setPathUserId(userId);
        filePathPOMapper.insertSelective(filePathPO);

        //这一个文件夹下的文件的复制
        List<FileListPO> filelists = fileListServiceV2.getFileListPOByFilePathIdAndIsTrash(filePathPO.getPathId());
        for (FileListPO fileList : filelists) {
            copyFile(fileList, copyPath, false);
        }
        List<FilePathPO> filePathPOList = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(filePathPO.getPathId(), 0L);

        if (!filePathPOList.isEmpty()) {
            for (FilePathPO filepathson : filePathPOList) {
                copyPath(filepathson.getPathId(), copyPath.getPathId(), false, userId);
            }
        }

    }

    /**
     * 文件复制
     *
     * @param fileListPO
     */
    public void copyFile(FileListPO fileListPO, FilePathPO toPathPO, boolean isFileIn) {
        File s = getFile(fileListPO.getFilePath());
        UserPO userPO = userServiceV2.getUserPOByUserId(fileListPO.getFileUserId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath, simpleDateFormat.format(new Date()));
        File savepath = new File(root, userPO.getUserName());
        if (!savepath.exists()) {
            savepath.mkdirs();
        }
        String shuffix = fileListPO.getFileShuffix();
        log.info("shuffix:{}", shuffix);
        String newFileName = UUID.randomUUID().toString().toLowerCase() + "." + shuffix;
        File t = new File(savepath, newFileName);
        copyFileIo(s, t);

        FileListPO fileListPO1 = new FileListPO();
        String fileName = "";
        if (isFileIn) {
            fileName = "拷贝 " + fileListPO.getFileName().replace("拷贝 ", "");
        } else {
            fileName = fileListPO.getFileName();
        }
        fileName = onlyname(fileName, toPathPO.getPathId(), shuffix, 1, true);
        fileListPO1.setFileName(fileName);
        fileListPO1.setFilePath(t.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""));
        fileListPO1.setFileShuffix(shuffix);
        fileListPO1.setSize(fileListPO.getSize());
        fileListPO1.setUploadTime(new Date());
        fileListPO1.setPathId(toPathPO.getPathId());
        fileListPO1.setContentType(fileListPO.getContentType());
        fileListPO1.setFileUserId(userPO.getUserId());
        fileListPOMapper.insertSelective(fileListPO1);
    }

    /**
     * 得到文件
     *
     * @param filepath
     * @return
     */
    public File getFile(String filepath) {
        return new File(this.rootPath, filepath);
    }


    /**
     * 本地文件复制
     *
     * @param s
     * @param t
     */
    public void copyFileIo(File s, File t) {
        InputStream fis = null;
        OutputStream fos = null;

        try {
            fis = new BufferedInputStream(new FileInputStream(s));
            fos = new BufferedOutputStream(new FileOutputStream(t));
            byte[] buf = new byte[2048];
            int i;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 移动复制文件树点击加载
     *
     * @param mctoId
     * @param mcPathIds
     * @return
     */
    public List<FilePathPO> mcpathload(Long mctoId, List<Long> mcPathIds) {
        List<FilePathPO> showsonpath = new ArrayList<>();
        List<FilePathPO> sonpaths = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(mctoId, 0L);
        for (FilePathPO sonpath : sonpaths) {
            boolean nosame = true;
            for (Long mcPathId : mcPathIds) {
                if (sonpath.getPathId().equals(mcPathId)) {
                    nosame = false;
                    break;
                }
            }
            if (nosame) {
                showsonpath.add(sonpath);
            }
        }
        return showsonpath;
    }


    /**
     * 根据文件id 批量 删除文件  同时删除 数据库以及本地文件
     *
     * @param fileIds
     */
    @Transactional
    public void deleteFile(List<Long> fileIds) {
        for (Long fileId : fileIds) {
            FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(fileId);
//            FileList filelist = fldao.findOne(fileid);

            File file = new File(this.rootPath, fileListPO.getFilePath());
            if (file.exists() && file.isFile()) {
                fileListServiceV2.deleteFileListPOByFileListPOId(fileId);//删除数据库文件
                System.out.println("现在删除" + fileListPO.getFileName() + "本地文件    >>>>>>>>>");
                file.delete();
            }
        }
    }

    /**
     * 根据文件夹id 批量删除 文件夹    并删除此路径下的所有文件以及文件夹
     *
     * @param pathIds
     */
    @Transactional
    public void deletePath(List<Long> pathIds) {
        for (Long pathId : pathIds) {
            FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(pathId);//根据路径id找路径信息
            List<FileListPO> fileListPOS = fileListServiceV2.getFileListPOByFilePathId(filePathPO.getPathId());//根据文件路径id找文件
//			System.out.println("第一个文件夹："+filepath);
            //首先删除此文件夹下的文件
            if (!fileListPOS.isEmpty()) {
//				System.out.println("找到第一个文件夹下的文件不为空！~~~");
                List<Long> fileIds = new ArrayList<>();
                for (FileListPO fileListPO : fileListPOS) {
                    fileIds.add(fileListPO.getFileId());
                }
                deleteFile(fileIds);
            }

            //然后删除此文件夹下的文件夹
            List<FilePathPO> filePathPOS = filePathServiceV2.getFilePathPOByParentId(pathId);
            if (!filePathPOS.isEmpty()) {
                List<Long> pathIds2 = new ArrayList<>();
                for (FilePathPO filePathPO1 : filePathPOS) {
                    pathIds2.add(filePathPO1.getPathId());
                }
                deletePath(pathIds2);
            }
            filePathServiceV2.deleteFilePathPOByPathId(pathId);
        }
    }


    /**
     * 文件还原
     *
     * @param checkFileIds 文件的ids
     * @param userId       用户id
     */
    @Transactional
    public void filereturnback(List<Long> checkFileIds, Long userId) {
        FilePathPO filePathPO = filePathServiceV2.getFilePathPOByUserIdAndParentId(userId, 1L);
        for (Long checkFileId : checkFileIds) {
            FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(checkFileId);
            if (userId != null) {
                String name = onlyname(fileListPO.getFileName(), filePathPO.getPathId(), fileListPO.getFileShuffix(), 1, true);
                fileListPO.setPathId(filePathPO.getPathId());
                fileListPO.setFileName(name);
            }
            fileListPO.setFileIstrash(0L);
            fileListPOMapper.updateByPrimaryKeySelective(fileListPO);
        }

    }


    /**
     * 文件夹还原
     *
     * @param pathIds 路径ids
     * @param userId  用户id
     */
    public void pathreturnback(List<Long> pathIds, Long userId) {
        for (Long pathId : pathIds) {
            FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(pathId);
            System.out.println("第一个文件夹：" + filePathPO);
            //首先将此文件夹下的文件还原
            List<FileListPO> fileListPOS = fileListServiceV2.getFileListPOByFilePathId(pathId);
            if (!fileListPOS.isEmpty()) {
                System.out.println("找到第一个文件夹下的文件不为空！~~~");
                System.out.println(fileListPOS);
                List<Long> fileIds = new ArrayList<>();
                for (FileListPO fileListPO : fileListPOS) {
                    fileIds.add(fileListPO.getFileId());
                }
                filereturnback(fileIds, null);
            }
            System.out.println("此文件夹内的文件还原成功");
            System.out.println("然后将此文件夹下的文件夹还原");
            //然后将此文件夹下的文件夹还原
            List<FilePathPO> filePathPOS = filePathServiceV2.getFilePathPOByParentId(pathId);
            if (!filePathPOS.isEmpty()) {
                System.out.println("此文件夹下还有文件夹");
                List<Long> pathIds2 = new ArrayList<>();
                for (FilePathPO filePathPO1 : filePathPOS) {
                    pathIds2.add(filePathPO1.getPathId());
                }
                System.out.println("pathids2" + pathIds2);
                System.out.println("接下来尽心递归调用");
                pathreturnback(pathIds2, null);
            }
            System.out.println("此文件夹下再无文件夹");
            if (userId != null) {
                System.out.println("userid不为空表示是第一次进入的文件夹 现在还原");
                FilePathPO filePathPO1 = filePathServiceV2.getFilePathPOByUserIdAndParentId(userId, 1L);
                String name = onlyname(filePathPO.getPathName(), filePathPO1.getPathId(), null, 1, false);
                filePathPO.setPathName(name);
                filePathPO.setParentId(filePathPO1.getPathId());
            }
            System.out.println("还原成功");

            filePathPO.setPathIstrash(0L);
            filePathPOMapper.updateByPrimaryKeySelective(filePathPO);
        }
    }


}
