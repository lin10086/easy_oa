package cn.gson.oasys.serviceV2.processServiceV2;

import cn.gson.oasys.mappers.NotePaperPOMapper;
import cn.gson.oasys.modelV2.po.NotePaperPO;
import cn.gson.oasys.modelV2.po.NotePaperPOExample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class NotePaperPOServiceV2 {
    @Resource
    private NotePaperPOMapper notePaperPOMapper;

    /**
     * 插入一条便签
     *
     * @param notePaperPO 便签信息
     */
    public void insertNotePaperPOByNotePaperPO(NotePaperPO notePaperPO) {
        notePaperPOMapper.insertSelective(notePaperPO);
    }

    /**
     * 根据笔记标签ID删除笔记标签
     *
     * @param notePaperPOId 笔记标签
     */
    public void deleteNotePaperPOByNotePaperId(Long notePaperPOId) {
        notePaperPOMapper.deleteByPrimaryKey(notePaperPOId);
    }

    /**
     * 更新便签信息
     *
     * @param notePaperPO 便签信息
     */
    public void updateNotePaperPOByNotePaperPO(NotePaperPO notePaperPO) {
        notePaperPOMapper.updateByPrimaryKeySelective(notePaperPO);
    }


    /**
     * 根据便签的创建人ID找标签集合并根据创建时间排序，只取前五条(系统首页）
     *
     * @param userId 用户ID
     * @return
     */
    public List<NotePaperPO> getNotePaperPOSByNotePaperUserIdAndCreateTimeDESCAndFrontFive(Long userId) {
        NotePaperPOExample notePaperPOExample = new NotePaperPOExample();
        notePaperPOExample.setOrderByClause("create_time DESC");
        notePaperPOExample.createCriteria().andNotepaperUserIdEqualTo(userId);
        List<NotePaperPO> notePaperPOList = notePaperPOMapper.selectByExampleWithBLOBs(notePaperPOExample);
        int end;
        if (notePaperPOList.size() > 5) {
            end = 5;
        } else {
            end = notePaperPOList.size();
        }
        List<NotePaperPO> subNotePaperPO = notePaperPOList.subList(0, end);
        return subNotePaperPO;
    }

    /**
     * 根据用户ID找便签并根据创建时间降序
     *
     * @param userId 用户ID
     * @return
     */
    public List<NotePaperPO> getNotePaperPOSByNotePaperUserIdAndCreateTimeDESC(Long userId) {
        NotePaperPOExample notePaperPOExample = new NotePaperPOExample();
        notePaperPOExample.setOrderByClause("create_time DESC");
        notePaperPOExample.createCriteria().andNotepaperUserIdEqualTo(userId);
        List<NotePaperPO> notePaperPOS = notePaperPOMapper.selectByExampleWithBLOBs(notePaperPOExample);
        return notePaperPOS;
    }

    /**
     * 根据标签ID找标签内容
     *
     * @param notePaperPOId 标签ID
     * @return
     */
    public NotePaperPO getNotePaperPOByNotePaperId(Long notePaperPOId) {
        NotePaperPO notePaperPO = notePaperPOMapper.selectByPrimaryKey(notePaperPOId);
        return notePaperPO;
    }
}
