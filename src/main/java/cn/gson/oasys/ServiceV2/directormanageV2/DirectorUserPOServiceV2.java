package cn.gson.oasys.ServiceV2.directormanageV2;

import cn.gson.oasys.ServiceV2.UserPOServiceV2;
import cn.gson.oasys.ServiceV2.directormanageV2.DirectorPOServiceV2;
import cn.gson.oasys.mappers.DirectorUsersPOMapper;
import cn.gson.oasys.model.po.DirectorUsersPO;
import cn.gson.oasys.model.po.DirectorUsersPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DirectorUserPOServiceV2 {
    @Resource
    private DirectorUsersPOMapper directorUsersPOMapper;
    @Resource
    private DirectorPOServiceV2 directorPOServiceV2;
    @Resource
    private UserPOServiceV2 UserPOServiceV2;


    /**
     * 更新或插入用户目录信息表
     *
     * @param directorUsersPO
     * @return
     */
    public DirectorUsersPO insertOrUpdateDirectorUsersPOByDirectorUsersPO(DirectorUsersPO directorUsersPO) {
        if (directorUsersPO.getDirectorUsersId() != null) {
            directorUsersPOMapper.updateByPrimaryKeySelective(directorUsersPO);
        } else {
            directorUsersPOMapper.insertSelective(directorUsersPO);
        }
        return directorUsersPO;
    }

    /**
     * 根据关联表ID删除关联表信息
     *
     * @param directorUsersPOId
     */
    public void deleteDirectorUsersPOByDirectorUsersPOId(Long directorUsersPOId) {
        directorUsersPOMapper.deleteByPrimaryKey(directorUsersPOId);
    }

    /**
     * 更新关联表外部用户信息
     *
     * @param directorUsersPO
     */
    public void updateDirectorUsersPOByDirectorUsersPO(DirectorUsersPO directorUsersPO) {
        directorUsersPOMapper.updateByPrimaryKeySelective(directorUsersPO);
    }

    /**
     * 根据关联表ID找关联表信息
     *
     * @param directorUsersPOId
     * @return
     */
    public DirectorUsersPO getDirectorUsersPOByDirectorUsersPOId(Long directorUsersPOId) {
        DirectorUsersPO directorUsersPO = directorUsersPOMapper.selectByPrimaryKey(directorUsersPOId);
        return directorUsersPO;
    }

    /**
     * 根据用户ID和目录名非空非""找目录用户信息（从中取出目录名并去重）
     *
     * @param userId 用户ID
     * @return
     */
    public Set<String> getCatalogNameByUserId(Long userId) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andUserIdEqualTo(userId).andCatelogNameIsNotNull().andCatelogNameNotEqualTo("");
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        Set<String> catalogNames = new HashSet<>();
        for (DirectorUsersPO directorUsersPO : directorUsersPOList) {
            catalogNames.add(directorUsersPO.getCatelogName());
        }
        return catalogNames;
    }


    /**
     * 根据用户ID和分享人非空和handle找用户通讯录
     *
     * @param userId 用户ID
     * @param handle
     * @return
     */
    public List<DirectorUsersPO> getDirectorUsersPOByUserIdAndShareUserNotNullAndHandle(Long userId, Boolean handle) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andUserIdEqualTo(userId).andShareUserIdIsNotNull().andIsHandleEqualTo(handle == false ? 0 : 1);
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;
    }

    /**
     * 根据用户ID和外部用户ID找外部用户信息
     *
     * @param userId       用户ID
     * @param directorPOId 外部用户ID
     * @return
     */
    public DirectorUsersPO getDirectorUsersPOByUserIdAndDirectorPOId(Long userId, Long directorPOId) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andUserIdEqualTo(userId).andDirectorIdEqualTo(directorPOId);
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        if (directorUsersPOList.size() > 0) {
            DirectorUsersPO directorUsersPO = directorUsersPOList.get(0);
            return directorUsersPO;
        }
        return null;
    }

    /**
     * 根据用户ID和目录名找用户关联表信息
     *
     * @param userId
     * @param catalogName
     * @return
     */
    public List<DirectorUsersPO> getDirectorUsersPOByUserIdAndCatalogName(Long userId, String catalogName) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andUserIdEqualTo(userId).andCatelogNameEqualTo(catalogName);
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;
    }

    /**
     * 根据外部通讯录ID找关联表信息
     *
     * @param directorPOId 外部通讯录ID
     * @return
     */
    public List<DirectorUsersPO> getDirectorUsersPOSByDirectorPOId(Long directorPOId) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andDirectorIdEqualTo(directorPOId);
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;
    }

    /**
     * 根据分享人ID获取关联表列表
     *
     * @param shareUserId 分享人ID
     * @return
     */
    public List<DirectorUsersPO> getDirectorUsersPOSByShareUserId(Long shareUserId) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andShareUserIdEqualTo(shareUserId);
        directorUsersPOExample.setOrderByClause("sharetime DESC");
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;
    }

    /**
     * 模糊查询；可根据联系人名字、电话、用户名字查找中间表
     *
     * @param baseKey
     * @param userId
     * @return
     * @Query("from DirectorUser du where (du.director.userName like ?1 or du.director.phoneNumber like ?1 or du.user.userName like ?1) and du.user =?2 and du.shareuser is NOT null")
     * Page<DirectorUser> findBaseKey(String baseKey,User user,Pageable pa);
     */
    public List<DirectorUsersPO> getDirectorUsersPOSByUserIdAndShareUserIdIsNotNUllAndDirectorUserNameLike(String baseKey, Long userId) {
        List<Long> directorPOIds = directorPOServiceV2.getDirectorPOIdsByUserNameLikeOrPhoneNumberLike(baseKey);
        List<Long> userIds = UserPOServiceV2.getUserIdsByUsernameLike(baseKey);
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andShareUserIdIsNotNull().andUserIdEqualTo(userId)
                .andDirectorIdIn(directorPOIds);
        DirectorUsersPOExample.Criteria criteria2 = directorUsersPOExample.createCriteria().andShareUserIdIsNotNull().andUserIdEqualTo(userId)
                .andUserIdIn(userIds);
        directorUsersPOExample.or(criteria2);
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;
    }

    /**
     * 根据用户ID和外部通讯录ID非空和是外部通讯录
     *
     * @param userId 用户ID
     * @return
     */
    public List<DirectorUsersPO> getDirectorUsersPOListByUserIdAndDirectorIdIsNotNullAndIsHandle(Long userId) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andUserIdEqualTo(userId)
                .andDirectorIdIsNotNull().andIsHandleEqualTo(1);


        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;

    }

    /**
     * 根据外部目录名查找并根据目录名排序
     *
     * @param outType 外部类型名
     * @return
     */
    public List<DirectorUsersPO> getDirectorUsersPOListByCatelogNameEqualToAndCatelogNameAsc(String outType) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andCatelogNameEqualTo(outType);
        directorUsersPOExample.setOrderByClause("catelog_name ASC");
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;
    }

    /**
     * 根据外部目录名模糊查找
     *
     * @param baseKey 模糊字
     * @return
     */
    public List<DirectorUsersPO> getDirectorUsersPOListByCatelogNameLike(String baseKey) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andCatelogNameLike("%" + baseKey + "%");
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;
    }

    /**
     * 根据用户ID（即被分享人的ID）和主动分享人的ID非空找中间表
     *
     * @param userId 被分享人的ID
     * @return
     */
    public List<DirectorUsersPO> getDirectorUsersPOSByUserIdAndShareUserIdIsNotNull(Long userId) {
        DirectorUsersPOExample directorUsersPOExample = new DirectorUsersPOExample();
        directorUsersPOExample.createCriteria().andUserIdEqualTo(userId).andShareUserIdIsNotNull();
        directorUsersPOExample.setOrderByClause("is_handle ASC,sharetime DESC");
        List<DirectorUsersPO> directorUsersPOList = directorUsersPOMapper.selectByExample(directorUsersPOExample);
        return directorUsersPOList;
    }

}
