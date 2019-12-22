package cn.gson.oasys.ServiceV2.fileV2;

import cn.gson.oasys.ServiceV2.AttachmentServiceV2;
import cn.gson.oasys.ServiceV2.UserPOServiceV2;
import cn.gson.oasys.mappers.AttachmentListPOMapper;
import cn.gson.oasys.mappers.FileListPOMapper;
import cn.gson.oasys.mappers.FilePathPOMapper;
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
    private UserPOServiceV2 userServiceV2;
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
     * @param file    要上传的文件
     * @param userPO  用户信息
     * @param nowpath 上传文件所属文件夹信息
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    public Object saveFile(MultipartFile file, UserPO userPO, FilePathPO nowpath, boolean isfile) throws IllegalStateException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath, simpleDateFormat.format(new Date()));//根目录+日期年月

        File savePath = new File(root, userPO.getUserName());//根目录+日期年月+用户名
        if (!savePath.exists()) {
            savePath.mkdirs();
        }
        String suffix = FilenameUtils.getExtension(file.getOriginalFilename());//获取文件的扩展名
        String newUUIDFileName = UUID.randomUUID().toString().toLowerCase() + "." + suffix;//用UUID生成新的文件名
        File targetFile = new File(savePath, newUUIDFileName);//项目路径+年月+用户名,UUID生成 的文件名
        file.transferTo(targetFile);//把文件存在项目里

        String filename = file.getOriginalFilename();// 原始文件名
        String newFilename = null;
        if (nowpath != null) {
            newFilename = onlyname(filename, nowpath.getPathId(), suffix, 1, true);
        }
        String filePath = targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, "");
        if (isfile) {//使用上传
            FileListPO fileListPO = fileListServiceV2.insertFileListPO(newFilename, filePath, suffix, file.getSize(), nowpath.getPathId(), file.getContentType(), userPO.getUserId());
            return fileListPO;
        } else {
            AttachmentListPO attachmentListPO = new AttachmentListPO();
            attachmentListPO.setAttachmentName(filename);
            attachmentListPO.setAttachmentPath(filePath);
            attachmentListPO.setAttachmentShuffix(suffix);
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
     * @param name    从前端接收的修改名字
     * @param pathId  文件的文件夹id或文件夹的上级文件夹id
     * @param shuffix 文件后缀
     * @param num
     * @return
     */
    public String onlyname(String name, Long pathId, String shuffix, int num, boolean isFile) {
        Object f = null;
        if (isFile) {//是文件
            //根据接收的文件名和要修改的文件夹id找文件
            f = fileListServiceV2.getFileListPOByFileNameAndPathId(name, pathId);
        } else {
            //根据路径名和父id找路径
            f = filePathServiceV2.getFilePathPOByFilePathNameAndParentId(name, pathId);
        }
        if (f != null) {
            int num2 = num - 1;
            if (shuffix == null) {//文件夹
                name = name.replace("(" + num2 + ")", "") + "(" + num + ")";
            } else {//文件
                //先把后缀换成""，再把（num2）换成""，在加上（num)和后缀
//                name = name.replace("." + shuffix, "").replace("(" + num2 + ")", "") + "(" + num + ")" + "." + shuffix;
                name = name.replace("." + shuffix, "").replace("(" + num2 + ")", "") + "(" + num + ")" + "." + shuffix;
            }
            num += 1;
            return onlyname(name, pathId, shuffix, num, isFile);
        }
        return name;
    }


    //修改附件
    public Integer updateattchment(MultipartFile file, UserVO userVO, FilePathPO nowpathPO, long attachmentId) throws IllegalStateException, IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath, simpleDateFormat.format(new Date()));

        File savepath = new File(root, userVO.getUserName());

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
     * @param presentFilePathPO 当前所在文件夹
     * @param filePathPOList    当前文件夹的父级文件夹
     */
    public void allFilePathPOParent(FilePathPO presentFilePathPO, List<FilePathPO> filePathPOList) {
//        presentFilePathPO.getParentId() == 1L 代表用户的根文件夹
        if (presentFilePathPO.getParentId() != 1L) {
            //根据当前文件夹的父级文件夹id找父级文件夹信息
            FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(presentFilePathPO.getParentId());//根据路径id找路径信息
            filePathPOList.add(filePathPO);
            allFilePathPOParent(filePathPO, filePathPOList);
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
     * @param setIsTrashHowMany 是否是垃圾文件
     * @param isFirst
     */
    public void trashPath(List<Long> pathIds, Long setIsTrashHowMany, boolean isFirst) {
        for (Long pathId : pathIds) {
            FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(pathId);// 根据文件夹id获取要操作的文件夹信息
            List<FileListPO> fileListPOS = fileListServiceV2.getFileListPOByFilePathId(filePathPO.getPathId());//根据文件夹id找问价夹下的文件列表
            //首先将此文件夹下的文件放入回收战
            if (!fileListPOS.isEmpty()) {
                List<Long> fileIds = new ArrayList<>();
                for (FileListPO fileListPO : fileListPOS) {
                    fileIds.add(fileListPO.getFileId());
                }
                //userId==null删除文件夹内的文件，文件的文件夹id保留(因为它是要删除的文件夹的内部文件，所以要知道他是那个文件夹下的）
                trashFile(fileIds, 1L, null);
            }

            //然后将此文件夹下的文件夹放入回收战（根据要删除的文件夹id找出下级非垃圾文件夹）
            List<FilePathPO> filePathPOList = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(pathId, 0L);
            if (!filePathPOList.isEmpty()) {
                List<Long> pathIds2 = new ArrayList<>();
                for (FilePathPO filePathPO1 : filePathPOList) {
                    pathIds2.add(filePathPO1.getPathId());
                }
                trashPath(pathIds2, 1L, false);
            }
            filePathServiceV2.updateFilePathPOPathIsTrashAndPathParentId(isFirst, filePathPO);
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
     * @param name     从前端接收的修改名字
     * @param reNameFp 要修改的文件id或文件夹id
     * @param pathId   文件的文件夹id或文件夹的上级文件夹id
     * @param isFile   是不是文件
     */
    public void rename(String name, Long reNameFp, Long pathId, boolean isFile) {
        if (isFile) {
            //文件名修改
            FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(reNameFp);//根据要修改的文件id找文件
            String newName = onlyname(name, pathId, fileListPO.getFileShuffix(), 1, isFile);//新名字
            fileListServiceV2.updateFileListPOFileName(fileListPO, newName);// 更新文件名字
        } else {
            //文件夹名修改
            FilePathPO updateFilePathPO = filePathServiceV2.getFilePathPOByPathId(reNameFp);//根据要修改的文件夹id找文件夹信息
            String newName = onlyname(name, pathId, null, 1, isFile);
            filePathServiceV2.updateFilePathPOPathName(newName, updateFilePathPO);//根据文件夹新名字和要更新的文件夹路径信息修改文件夹名
        }
    }


    /**
     * 复制和移动
     *
     * @param mcFileIds 要移动或复制的文件id
     * @param mcPathIds 要移动或复制的文件夹id
     * @param toPathId  要移动到的文件夹id
     * @param fromWhere 1为移动true  2 为复制flase
     * @param userId    用户id
     */
    @Transactional
    public void moveAndCopy(List<Long> mcFileIds, List<Long> mcPathIds, Long toPathId, boolean fromWhere, Long userId) {
        FilePathPO toPath = filePathServiceV2.getFilePathPOByPathId(toPathId);//根据移动或复制到的文件夹id找文件夹信息(目标文件夹
        if (fromWhere) {//移动
            if (!mcFileIds.isEmpty()) {//移动文件
                for (Long mcFileId : mcFileIds) {
                    FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(mcFileId);  //根据要移动的文件id找文件信息
                    //要移动的文件名，要移动的文件夹id，文件后缀，1，是否是文件，作用防止移动到新的文件夹后重命
                    String newFileName = onlyname(fileListPO.getFileName(), toPathId, fileListPO.getFileShuffix(), 1, true);
                    fileListServiceV2.updateFileListPOFileNameAndFilePathId(fileListPO, newFileName, toPathId);
                }
            }
            if (!mcPathIds.isEmpty()) {//移动文件夹
                for (Long mcPathId : mcPathIds) {
                    FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(mcPathId);//根据要移动的文件夹id找到文件夹信息
                    //文件夹名，文件夹的父级id
                    String newPathName = onlyname(filePathPO.getPathName(), toPathId, null, 1, false);
                    filePathServiceV2.updateFilePathPOPathNameAndPathParentId(newPathName, toPathId, filePathPO);//更新文件夹名和路径名
                }
            }
        } else {//复制
            if (!mcFileIds.isEmpty()) {
                for (Long mcFileId : mcFileIds) {
                    FileListPO fileListPO = fileListServiceV2.getFileListPOByFileListPOId(mcFileId);//根据要复制的文件id找到要复制的文件信息
                    copyFile(fileListPO, toPath, true);
                }
            }
            if (!mcPathIds.isEmpty()) {
                for (Long mcPathId : mcPathIds) {
                    copyPath(mcPathId, toPathId, true, userId);
                }
            }
        }
    }

    /**
     * 文件夹复制
     *
     * @param mcPathId 要复制的文件夹id
     * @param toPathId 目标文件夹id
     * @param isFirst  为true，作用：只给它要复制的文件夹加拷贝，里面的文件或文件夹不加
     * @param userId   用户id
     */
    public void copyPath(Long mcPathId, Long toPathId, boolean isFirst, Long userId) {
        FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(mcPathId);//根据要复制的文件夹id找文件夹信息
        String copyPathName = filePathPO.getPathName();
        if (isFirst) {
            copyPathName = "拷贝 " + filePathPO.getPathName().replace("拷贝 ", "");
        }
        FilePathPO newFilePathPO = filePathServiceV2.insertNewFilePathPO(toPathId, copyPathName, userId);//复制的新的文件夹

        //找到要复制文件夹下的非垃圾文件
        List<FileListPO> fileListPOS = fileListServiceV2.getFileListPOSByFilePathIdAndFileIsTrash(filePathPO.getPathId(), 0L);
        if (!fileListPOS.isEmpty()) {//判断文件夹下有没有文件
            for (FileListPO fileList : fileListPOS) {
                //文件夹下的文件，已经复制的新文件夹， false代表他它是要复制文件夹下的文件
                copyFile(fileList, newFilePathPO, false);
            }
        }
        //把要复制的文件夹id当做父级id查询它下面是否有非垃圾文件夹
        List<FilePathPO> filePathPOList = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(filePathPO.getPathId(), 0L);
        if (!filePathPOList.isEmpty()) {
            for (FilePathPO filePathSon : filePathPOList) {
                // 要复制的文件id，已经复制好的新的文件夹id，false代表不是直接复制的文件夹，用户id
                copyPath(filePathSon.getPathId(), newFilePathPO.getPathId(), false, userId);
            }
        }

    }


    /**
     * 文件复制
     *
     * @param fileListPO 要复制的文件信息
     * @param toPathPO   目的地文件夹信息
     * @param isFileIn   是直接要复制的文件（true)还是要复制的文件夹内的文件（false)
     */
    public void copyFile(FileListPO fileListPO, FilePathPO toPathPO, boolean isFileIn) {
        File oldFile = getFile(fileListPO.getFilePath());//根据文件的具体路径获取文件
        UserPO userPO = userServiceV2.getUserPOByUserId(fileListPO.getFileUserId());//根据文件的用户id找用户信息
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath, simpleDateFormat.format(new Date()));//原路径+新的年月（修改了文件的部分名称年月）
        File savepath = new File(root, userPO.getUserName());//  新的完整路径
        if (!savepath.exists()) {
            savepath.mkdirs();
        }

        String shuffix = fileListPO.getFileShuffix();//文件后缀
        String newUUIDFileName = UUID.randomUUID().toString().toLowerCase() + "." + shuffix;//新的文件名
        File newFile = new File(savepath, newUUIDFileName); //文件路径+文件名
        copyFileIO(oldFile, newFile);// 把文件复制了一份

        String fileName = "";
        if (isFileIn) {
            fileName = "拷贝 " + fileListPO.getFileName().replace("拷贝 ", "");
        } else {
            fileName = fileListPO.getFileName();
        }
        //防止复制后的文件名到新的文件夹同名
        String newFileName = onlyname(fileName, toPathPO.getPathId(), shuffix, 1, true);
        String filePath = newFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, "");
        //插入新文件
        fileListServiceV2.insertFileListPO(newFileName, filePath, shuffix, fileListPO.getSize(), toPathPO.getPathId(), fileListPO.getContentType(), userPO.getUserId());
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
    public void copyFileIO(File s, File t) {
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
     * @param mctoId    要移动到哪个里面的的文件夹id
     * @param mcPathIds 要复制的文件夹ids
     * @return
     */
    public List<FilePathPO> mcpathload(Long mctoId, List<Long> mcPathIds) {
        List<FilePathPO> showsonpath = new ArrayList<>();//要进入文件夹内子文件夹
        //把要进入的文件夹id当做父级id找它下面的非垃圾文件夹
        List<FilePathPO> sonpaths = filePathServiceV2.getFilePathPOListByParentIdAndIsTrash(mctoId, 0L);//找到 mctoId 下的非垃圾文件夹
        for (FilePathPO sonpath : sonpaths) {
            boolean nosame = true;
            for (Long mcPathId : mcPathIds) {
                if (sonpath.getPathId().equals(mcPathId)) {
                    //为了防止把文件夹复制到自己的的文件夹内
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
            FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(pathId);//根据要删除的文件夹id找文件夹信息
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
    public void fileReturnBack(List<Long> checkFileIds, Long userId) {
        FilePathPO filePathPO = filePathServiceV2.getFilePathPOByUserIdAndParentId(userId, 1L);//用户文件夹信息
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
    public void pathReturnBack(List<Long> pathIds, Long userId) {
        for (Long pathId : pathIds) {
            FilePathPO filePathPO = filePathServiceV2.getFilePathPOByPathId(pathId);//根据要回复的文件夹id找文件夹信息
            //首先将此文件夹下的文件还原
            List<FileListPO> fileListPOS = fileListServiceV2.getFileListPOByFilePathId(pathId);//找到此文件夹下的文件
            if (!fileListPOS.isEmpty()) {
                List<Long> fileIds = new ArrayList<>();
                for (FileListPO fileListPO : fileListPOS) {
                    fileIds.add(fileListPO.getFileId());
                }
                fileReturnBack(fileIds, null);
            }
            System.out.println("此文件夹内的文件还原成功");
            System.out.println("然后将此文件夹下的文件夹还原");
            List<FilePathPO> filePathPOS = filePathServiceV2.getFilePathPOByParentId(pathId);//找到此文件夹下的文件夹
            if (!filePathPOS.isEmpty()) {
                System.out.println("此文件夹下还有文件夹");
                List<Long> pathIds2 = new ArrayList<>();
                for (FilePathPO filePathPO1 : filePathPOS) {
                    pathIds2.add(filePathPO1.getPathId());
                }
                System.out.println("接下来尽心递归调用");
                pathReturnBack(pathIds2, null);
            }
            System.out.println("此文件夹下再无文件夹");
            if (userId != null) {
                System.out.println("userid不为空表示是第一次进入的文件夹 现在还原");
                FilePathPO filePathPO1 = filePathServiceV2.getFilePathPOByUserIdAndParentId(userId, 1L);//用户文件夹
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
