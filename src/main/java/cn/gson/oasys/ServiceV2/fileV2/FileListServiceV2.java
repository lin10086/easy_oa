package cn.gson.oasys.ServiceV2.fileV2;

import cn.gson.oasys.mappers.FileListPOMapper;
import cn.gson.oasys.model.entity.file.FileList;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.FileListPO;
import cn.gson.oasys.model.po.FileListPOExample;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileListServiceV2 {
    @Resource
    private FileListPOMapper fileListPOMapper;


    private String rootPath;

    @PostConstruct
    public void UserpanelController() {
        try {
            rootPath = ResourceUtils.getURL("classpath:").getPath().replace("/target/classes/", "/src/main/resources/attachment");
//            rootPath= ResourceUtils.getURL("classpath:").getPath().replace("target/classes/","static/file");
            System.out.println(rootPath);
        } catch (IOException e) {
            System.out.println("获取项目路径异常");
        }
    }

    /**
     * 根据文件id删除文件
     *
     * @param fileId
     */
    public void deleteFileListPOByFileListPOId(Long fileId) {
        fileListPOMapper.deleteByPrimaryKey(fileId);
    }

    /**
     * 把文件设置为垃圾文件
     *
     * @param userId
     * @param setIsTrashHowMany
     * @param fileListPO
     */
    public void updateFileListPOByIsTrash(Long userId, Long setIsTrashHowMany, FileListPO fileListPO) {
        if (userId != null) {
            fileListPO.setPathId(null);
        }
        fileListPO.setFileIstrash(setIsTrashHowMany);
        fileListPOMapper.updateByPrimaryKeySelective(fileListPO);
    }

    /**
     * 更新FileListPO的isShare字段
     *
     * @param fileListPO
     */
    public void updateFileListPOIsShare(FileListPO fileListPO) {
        fileListPO.setFileIsshare(1L);
        fileListPOMapper.updateByPrimaryKeySelective(fileListPO);
    }

    /**
     * 修改文件名
     *
     * @param fileListPO 文件信息
     * @param newName    新的文件名
     */
    public void updateFileListPOFileName(FileListPO fileListPO, String newName) {
        fileListPO.setFileName(newName);
        fileListPOMapper.updateByPrimaryKeySelective(fileListPO);
    }

    /**
     * 根据文件路径和文件是否是垃圾
     *
     * @param filePathId
     * @return
     */
    public List<FileListPO> getFileListPOByFilePathIdAndIsTrash(Long filePathId) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andPathIdEqualTo(filePathId).andFileIstrashEqualTo(0L);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;
    }

    /**
     * 根据文件路径
     *
     * @param filePathId
     * @return
     */
    public List<FileListPO> getFileListPOByFilePathId(Long filePathId) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andPathIdEqualTo(filePathId);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;
    }


    /**
     * 根据文件id查询文件
     *
     * @param fileId
     * @return
     */
    public FileListPO getFileListPOByFileListPOId(Long fileId) {
        FileListPO fileListPO = fileListPOMapper.selectByPrimaryKey(fileId);
        return fileListPO;
    }

    /**
     * @param filePath
     * @return
     */
    public File getFile(String filePath) {
        return new File(this.rootPath, filePath);

    }

    /**
     * 根据文件名和路径id找文件
     *
     * @param fileName
     * @param filePathId
     * @return
     */
    public FileListPO getFileListPOByFileNameAndPathId(String fileName, Long filePathId) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileNameEqualTo(fileName).andPathIdEqualTo(filePathId);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        if (fileListPOS.size() != 0) {
            return fileListPOS.get(0);
        }
        return null;
    }

    //---------------

    /**
     * 根据用户id和文件类型找文件
     *
     * @param userId 用户id
     * @return
     */
    public List<FileListPO> getDocument(Long userId) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileUserIdEqualTo(userId).andFileIstrashEqualTo(0L)
                .andContentTypeNotLike("image/" + "%").andContentTypeNotLike("application/" + "%")
                .andContentTypeNotLike("video/" + "%").andContentTypeNotLike("audio/" + "%");
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;
    }


    /**
     * 根据用户id和文件名和是否删除
     *
     * @param userId
     * @param fileName
     * @return
     */
    public List<FileListPO> getDocumentLike(Long userId, String fileName) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileUserIdEqualTo(userId).andFileIstrashEqualTo(0L).andFileNameEqualTo(fileName)
                .andContentTypeNotLike("image/" + "%").andContentTypeNotLike("application/" + "%")
                .andContentTypeNotLike("video/" + "%").andContentTypeNotLike("audio/" + "%");
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;
    }


    /**
     * 根据用户id和是否是垃圾文件和文件类型找文件
     *
     * @param userId
     * @param contentType
     * @param isTrash
     * @return
     */
    public List<FileListPO> getFileListPOByUserIdAndContentTypeLikeAndFileIsTrash(Long userId, String contentType, Long isTrash) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileUserIdEqualTo(userId).andFileIstrashEqualTo(isTrash)
                .andContentTypeLike(contentType);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;

    }

    /**
     * 根据用户id和是否是垃圾文件找文件列表
     *
     * @param userId  用户id
     * @param isTrash 是否是垃圾文件
     * @return
     */
    public List<FileListPO> getFileListPOByUserIdAndFileIsTrash(Long userId, Long isTrash) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileUserIdEqualTo(userId).andFileIstrashEqualTo(isTrash);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;

    }

    /**
     * 根据是否是分享文件和是否是否是垃圾文件
     *
     * @param isShare
     * @param isTrash
     * @return
     */
    public List<FileListPO> getFileListPOByFileIsShareAndFileIsTrash(Long isShare, Long isTrash) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileIsshareEqualTo(isShare).andFileIstrashEqualTo(isTrash);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;

    }


    /**
     * @param userId    用户id
     * @param countType 类型名
     * @param fileName  文件名
     * @param isTrash   是否是垃圾文件
     * @return
     */
    public List<FileListPO> getFileListPOSByUserIdAndFileIsTrashAndCountTypeLikeAndFileNameLike(Long userId, String countType, String fileName, Long isTrash) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileUserIdEqualTo(userId).andFileIstrashEqualTo(isTrash)
                .andContentTypeLike(countType).andFileNameEqualTo(fileName);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;

    }

    /**
     * @param fileName 文件名
     * @param isShare  是否是共享文件
     * @return
     */
    public List<FileListPO> getFileListPOSByFileIsShareAndFileNameLike(String fileName, Long isShare) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileIsshareEqualTo(isShare).andFileNameLike(fileName);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;

    }

    /**
     * 根据用户id和是否删除和文件名
     *
     * @param userId   用户id
     * @param fileName 文件名
     * @param isTrash  是否删除
     * @return
     */
    public List<FileListPO> getFileListPOSByUserIdAndFileIsTrashAndFileNameLike(Long userId, String fileName, Long isTrash) {
        FileListPOExample fileListPOExample = new FileListPOExample();
        fileListPOExample.createCriteria().andFileUserIdEqualTo(userId).andFileIstrashEqualTo(isTrash).andFileNameLike(fileName);
        List<FileListPO> fileListPOS = fileListPOMapper.selectByExample(fileListPOExample);
        return fileListPOS;
    }


}
