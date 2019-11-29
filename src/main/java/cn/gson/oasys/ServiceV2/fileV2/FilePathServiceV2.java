package cn.gson.oasys.ServiceV2.fileV2;

import cn.gson.oasys.mappers.FilePathPOMapper;
import cn.gson.oasys.model.po.FilePathPO;
import cn.gson.oasys.model.po.FilePathPOExample;
import cn.gson.oasys.model.po.UserPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FilePathServiceV2 {
    @Resource
    private FilePathPOMapper filePathPOMapper;


    /**
     * 插入文件路径
     *
     * @param userPO
     * @return
     */
    public FilePathPO insertFilePathPO(UserPO userPO) {
        FilePathPO filePathPO = new FilePathPO();
        filePathPO.setParentId(1L);
        filePathPO.setPathName(userPO.getUserName());
        filePathPO.setPathUserId(userPO.getUserId());
        filePathPOMapper.insertSelective(filePathPO);
        return filePathPO;
    }

    /**
     * 插入新路径(新建文件夹，有新名字，有上级路径，有用户id）
     *
     * @param pathId  上级路径id
     * @param newName 新名字
     * @param userId  用户id
     * @return
     */
    public FilePathPO insertFilePathPOByNewNameAndParentId(Long pathId, String newName, Long userId) {
        FilePathPO filePathPO = new FilePathPO();
        filePathPO.setParentId(pathId);//新路径的上级路径
        filePathPO.setPathName(newName);//新文件名
        filePathPO.setPathUserId(userId);//路径的用户id
        filePathPOMapper.insertSelective(filePathPO);
        return filePathPO;
    }


    /**
     * 根据文件路径父路径和是垃圾
     *
     * @param parentId
     * @return
     */
    public List<FilePathPO> getFilePathPOListByParentId(Long parentId) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andParentIdEqualTo(parentId).andPathIstrashEqualTo(0L);
        List<FilePathPO> filePathPOList = filePathPOMapper.selectByExample(filePathPOExample);
        return filePathPOList;
    }

    /**
     * 根据文件路径名找唯一文件路径
     *
     * @param pathName
     * @return
     */
    public FilePathPO getFilePathPOByPathName(String pathName) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andPathNameEqualTo(pathName);
        List<FilePathPO> filePathPOList = filePathPOMapper.selectByExample(filePathPOExample);
        FilePathPO filePathPO = null;
        if (filePathPOList != null) {
            filePathPO = filePathPOList.get(0);
        }
        return filePathPO;
    }

    /**
     * 根据文件路径id找文件当前路径
     *
     * @param pathId
     * @return
     */
    public FilePathPO getFilePathPOByPathId(Long pathId) {
        FilePathPO filePathPO = filePathPOMapper.selectByPrimaryKey(pathId);
        return filePathPO;
    }

    /**
     * 根据路径名和路径的父id找路径
     *
     * @param parentId
     * @param pathName
     * @return
     */
    public FilePathPO getFilePathPOByFilePathNameAndParentId(Long parentId, String pathName) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andPathNameEqualTo(pathName).andParentIdEqualTo(parentId);
        List<FilePathPO> filePathPOS = filePathPOMapper.selectByExample(filePathPOExample);
        if (filePathPOS.size()!=0) {
            filePathPOS.get(0);
        }
        return null;
    }


}
