package cn.gson.oasys.serviceV2.fileV2;

import cn.gson.oasys.mappers.FilePathPOMapper;
import cn.gson.oasys.modelV2.po.FilePathPO;
import cn.gson.oasys.modelV2.po.FilePathPOExample;
import cn.gson.oasys.modelV2.po.UserPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FilePathServiceV2 {
    @Resource
    private FilePathPOMapper filePathPOMapper;


    /**
     * 根据用户名和用户id插入用户文件夹
     *
     * @param userPO
     * @return
     */
    public FilePathPO insertFilePathPOByUserPO(UserPO userPO) {
        FilePathPO filePathPO = new FilePathPO();
        filePathPO.setParentId(1L);//把父文件夹设为1L（即根目录，1L相当于最外层的文件夹）
        filePathPO.setPathName(userPO.getUserName());//把用户名设为路径名
        filePathPO.setPathUserId(userPO.getUserId());//把用户id设为创建文件夹的的用户id
        filePathPOMapper.insertSelective(filePathPO);
        return filePathPO;
    }

    /**
     * 插入一个新的文件夹
     *
     * @param parentId 文件夹父级id
     * @param pathName 文件夹名
     * @param userId   用户id
     * @return
     */
    public FilePathPO insertNewFilePathPO(Long parentId, String pathName, Long userId) {
        FilePathPO filePathPO = new FilePathPO();
        filePathPO.setParentId(parentId);
        filePathPO.setPathName(pathName);
        filePathPO.setPathUserId(userId);
        filePathPO.setPathIstrash(0L);
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
    public FilePathPO insertFilePathPOByNewNameAndParentIdAndUserId(Long pathId, String newName, Long userId) {
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
     * 更新文件夹名
     *
     * @param newPathName      新的文件夹名
     * @param updateFilePathPO
     */
    public void updateFilePathPOPathName(String newPathName, FilePathPO updateFilePathPO) {
        updateFilePathPO.setPathName(newPathName);
        filePathPOMapper.updateByPrimaryKeySelective(updateFilePathPO);
    }

    /**
     * 更新文件夹名和路径的父级id
     *
     * @param newPathName
     * @param toPathId
     * @param updateFilePathPO
     */
    public void updateFilePathPOPathNameAndPathParentId(String newPathName, Long toPathId, FilePathPO updateFilePathPO) {
        updateFilePathPO.setPathName(newPathName);
        updateFilePathPO.setParentId(toPathId);
        filePathPOMapper.updateByPrimaryKeySelective(updateFilePathPO);
    }

    /**
     * 更新文件夹是否是垃圾文件夹
     *
     * @param isTrash          是否是垃圾文件夹
     * @param updateFilePathPO 文件夹信息
     */
    public void updateFilePathPOPathIsTrashAndPathParentId(Boolean isTrash, FilePathPO updateFilePathPO) {
        updateFilePathPO.setPathIstrash(isTrash == false ? 0L : 1L);
        if (isTrash) {
            updateFilePathPO.setParentId(0L);
        }
        filePathPOMapper.updateByPrimaryKeySelective(updateFilePathPO);
    }

    /**
     * 根据上级文件夹id和文件夹是否是垃圾文件夹
     *
     * @param parentId 上级文件夹id
     * @return 找文件夹下的所有文件夹
     */
    public List<FilePathPO> getFilePathPOListByParentIdAndIsTrash(Long parentId, Long isTrash) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andParentIdEqualTo(parentId).andPathIstrashEqualTo(isTrash);
        List<FilePathPO> filePathPOList = filePathPOMapper.selectByExample(filePathPOExample);
        return filePathPOList;
    }

    /**
     * 根据用户名找用户的文件夹
     *
     * @param pathName 文件夹名
     * @return
     */
    public FilePathPO getFilePathPOByPathName(String pathName) {
        FilePathPOExample filePathPOExample = new FilePathPOExample();
        filePathPOExample.createCriteria().andPathNameEqualTo(pathName);
        List<FilePathPO> filePathPOList = filePathPOMapper.selectByExample(filePathPOExample);
        FilePathPO filePathPO = null;
        if (filePathPOList.size() > 0) {
            filePathPO = filePathPOList.get(0);
        }
        return filePathPO;
    }

    /**
     * 根据文件夹id找文件当前文件夹信息
     *
     * @param pathId 文件夹id
     * @return
     */
    public FilePathPO getFilePathPOByPathId(Long pathId) {
        FilePathPO filePathPO = filePathPOMapper.selectByPrimaryKey(pathId);
        return filePathPO;
    }

    /**
     * 根据路径名和路径的父id找路径
     *
     * @param parentId 文件id
     * @param pathName 文件夹名
     * @return
     */
    public FilePathPO getFilePathPOByFilePathNameAndParentId(String pathName, Long parentId) {
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
        if (userId != null) {
            filePathPOExample.createCriteria().andPathUserIdEqualTo(userId).andParentIdEqualTo(parentId);
        } else {
            filePathPOExample.createCriteria().andParentIdEqualTo(parentId);
        }
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
     * @param userId  用户id
     * @param isTrash 是否是垃圾文件
     * @param pathName 输入的文件名
     * @param parentId 父级id
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
