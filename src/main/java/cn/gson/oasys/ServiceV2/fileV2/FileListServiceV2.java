package cn.gson.oasys.ServiceV2.fileV2;

import cn.gson.oasys.mappers.FileListPOMapper;
import cn.gson.oasys.model.po.FileListPO;
import cn.gson.oasys.model.po.FileListPOExample;
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

}
