package cn.gson.oasys.serviceV2.directormanageV2;

import cn.gson.oasys.mappers.DirectorPOMapper;
import cn.gson.oasys.model.po.DirectorPO;
import cn.gson.oasys.model.po.DirectorPOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DirectorPOServiceV2 {
    @Resource
    private DirectorPOMapper directorPOMapper;

    /**
     * 更新或插入外部通讯录
     *
     * @param directorPO
     * @return
     */
    public DirectorPO insertOrUpdateDirectorPOByDirectorPO(DirectorPO directorPO) {
        if (directorPO.getDirectorId() != null) {
            directorPOMapper.updateByPrimaryKeySelective(directorPO);
        } else {
            directorPOMapper.insertSelective(directorPO);
        }
        return directorPO;
    }

    /**
     * 根据外部用户ID删除外部用户信息
     *
     * @param directorPOId
     */
    public void deleteDirectorPOByDirectorPOId(Long directorPOId) {
        directorPOMapper.deleteByPrimaryKey(directorPOId);
    }

    /**
     * 根据用户拼音模糊查找通讯录用户信息
     *
     * @param pinyin
     * @return
     */
    public List<DirectorPO> getDirectorPOListByPinyinLike(String pinyin) {
        DirectorPOExample directorPOExample = new DirectorPOExample();
        directorPOExample.createCriteria().andPinyinLike(pinyin + "%");
        List<DirectorPO> directorPOList = directorPOMapper.selectByExample(directorPOExample);
        return directorPOList;
    }

    /**
     * 根据用户名模糊找外部用户信息
     *
     * @param baseKey
     * @return
     */
    public List<DirectorPO> getDirectorPOListByUserNameLike(String baseKey) {
        DirectorPOExample directorPOExample = new DirectorPOExample();
        directorPOExample.createCriteria().andUserNameLike("%" + baseKey + "%");
        List<DirectorPO> directorPOList = directorPOMapper.selectByExample(directorPOExample);
        return directorPOList;
    }

    /**
     * 根据电话号码模糊查找外部通讯录
     *
     * @param baseKey
     * @return
     */
    public List<DirectorPO> geDirectorPOListByPhoneNumberLike(String baseKey) {
        DirectorPOExample directorPOExample = new DirectorPOExample();
        directorPOExample.createCriteria().andPhoneNumberLike("%" + baseKey + "%");
        List<DirectorPO> directorPOList = directorPOMapper.selectByExample(directorPOExample);
        return directorPOList;
    }

    /**
     * 根据公司名找外部通讯录
     *
     * @param baseKey
     * @return
     */
    public List<DirectorPO> geDirectorPOListByCompanyNameLike(String baseKey) {
        DirectorPOExample directorPOExample = new DirectorPOExample();
        directorPOExample.createCriteria().andCompanynameLike("%" + baseKey + "%");
        List<DirectorPO> directorPOList = directorPOMapper.selectByExample(directorPOExample);
        return directorPOList;
    }

    /**
     * 找所有外部用户
     *
     * @return
     */
    public List<DirectorPO> getDirectorPOListByALL() {
        DirectorPOExample directorPOExample = new DirectorPOExample();
        List<DirectorPO> directorPOList = directorPOMapper.selectByExample(directorPOExample);
        return directorPOList;
    }

    /**
     * 根据外部通讯录ID找外部通讯录用户
     *
     * @param directorPOId 外部通讯录ID
     * @return
     */
    public DirectorPO getDirectorPOByDirectorPOId(Long directorPOId) {
        DirectorPO directorPO = directorPOMapper.selectByPrimaryKey(directorPOId);
        return directorPO;
    }

    /**
     * 根据外部联系人名和手机号码模糊查找(获取挖补联系人IDS）
     *
     * @param baseKey
     * @return
     */
    public List<Long> getDirectorPOIdsByUserNameLikeOrPhoneNumberLike(String baseKey) {
        DirectorPOExample directorPOExample = new DirectorPOExample();
        directorPOExample.createCriteria().andUserNameLike("%" + baseKey + "%");
        DirectorPOExample.Criteria criteria2 = directorPOExample.createCriteria().andPhoneNumberLike("%" + baseKey + "%");
        directorPOExample.or(criteria2);
        List<DirectorPO> directorPOList = directorPOMapper.selectByExample(directorPOExample);
        List<Long> longList = new ArrayList<>();
        for (DirectorPO directorPO : directorPOList) {
            longList.add(directorPO.getDirectorId());
        }
        return longList;
    }

}
