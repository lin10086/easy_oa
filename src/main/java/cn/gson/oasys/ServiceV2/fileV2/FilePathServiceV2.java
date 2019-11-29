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
     * 根据路径id删除路径信息
     *
     * @param pathId
     */
    public void deleteFilePathPOByPathId(Long pathId) {
        filePathPOMapper.deleteByPrimaryKey(pathId);
    }

    /**
     * 根据文件夹新名字和要更新的文件夹路径信息修改文件夹名
     *
     * @param newName
     * @param updateFilePathPO
     */
    public void updateFilePathPOPathName(String newName, FilePathPO updateFilePathPO) {
        updateFilePathPO.setPathName(newName);
        filePathPOMapper.updateByPrimaryKeySelective(updateFilePathPO);
    }

    /**
     * 根据文件路径父路径和是垃圾
     *
     * @param parentId
     * @return
     */
    public List<FilePathPO> getFilePathPOListByParentIdAndIsTrash(Long parentId, Long isTrash) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andParentIdEqualTo(parentId).andPathIstrashEqualTo(isTrash);
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
        if (filePathPOS.size() != 0) {
            return filePathPOS.get(0);
        }
        return null;
    }

    /**
     * 根据文件路径用户id和是否是垃圾文件找路径列表
     *
     * @param userId
     * @param isTrash
     * @return
     */
    public List<FilePathPO> getFilePathPOUserIdAndIsTrash(Long userId, Long isTrash) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andPathUserIdEqualTo(userId).andPathIstrashEqualTo(isTrash);
        List<FilePathPO> filePathPOS = filePathPOMapper.selectByExample(filePathPOExample);
        return filePathPOS;
    }


    /**
     * 根据用户id和路径的父id
     *
     * @param userId   用户id
     * @param parentId 路径的父id
     * @return
     */
    public FilePathPO getFilePathPOByUserIdAndParentId(Long userId, Long parentId) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andPathUserIdEqualTo(userId).andParentIdEqualTo(parentId);
        List<FilePathPO> filePathPOS = filePathPOMapper.selectByExample(filePathPOExample);
        if (filePathPOS.size() != 0) {
            return filePathPOS.get(0);
        }
        return null;
    }

    /**
     * 根据父路径找下面所有的路径
     *
     * @param parentId
     * @return
     */
    public List<FilePathPO> getFilePathPOByParentId(Long parentId) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andParentIdEqualTo(parentId);
        List<FilePathPO> filePathPOS = filePathPOMapper.selectByExample(filePathPOExample);
        return filePathPOS;
    }

    /**
     * @param userId
     * @param isTrash
     * @param pathName
     * @param parentId
     * @return
     */
    public List<FilePathPO> getFilePathPOByUserIdAndPathIsTrashAndPathNameLikeAndParentIdNot(Long userId, Long isTrash, String pathName, Long parentId) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andPathUserIdEqualTo(userId).andPathIstrashEqualTo(isTrash)
                .andPathNameLike(pathName).andParentIdEqualTo(parentId);
        List<FilePathPO> filePathPOList = filePathPOMapper.selectByExample(filePathPOExample);
        return filePathPOList;

    }

}
