package cn.gson.oasys.ServiceV2.noteV2;

import cn.gson.oasys.mappers.ReceiverNotePOMapper;
import cn.gson.oasys.model.po.ReceiverNotePO;
import cn.gson.oasys.model.po.ReceiverNotePOExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceiverNotePOServiceV2 {
    @Resource
    private ReceiverNotePOMapper receiverNotePOMapper;

    /**
     * 笔记用户关联表插入接收人
     *
     * @param userId 接收用户ID
     * @param noteId 笔记ID
     */
    public void insertReceiverNotePOByNoteIdAndUserId(Long userId, Long noteId) {
        ReceiverNotePO receiverNotePO = new ReceiverNotePO();
        receiverNotePO.setNoteId(noteId);
        receiverNotePO.setUserId(userId);
        receiverNotePOMapper.insertSelective(receiverNotePO);
    }

    /**
     * 根据用户笔记关联表ID删除关联表信息
     *
     * @param receiverNotePOId
     */
    public void deleteReceiverNotePOByReceiverNotePO(Long receiverNotePOId) {
        receiverNotePOMapper.deleteByPrimaryKey(receiverNotePOId);
    }

    /**
     * 根据用户id找关联表信息
     *
     * @param userId 用户id
     * @return
     */
    public List<ReceiverNotePO> getReceiverNotePOSByUserId(Long userId) {
        ReceiverNotePOExample receiverNotePOExample = new ReceiverNotePOExample();
        receiverNotePOExample.createCriteria().andUserIdEqualTo(userId);
        List<ReceiverNotePO> receiverNotePOS = receiverNotePOMapper.selectByExample(receiverNotePOExample);
        return receiverNotePOS;
    }

    /**
     * 根据用户ID和笔记ID找用户笔记关联表信息
     *
     * @param userId 用户ID
     * @param noteId 笔记ID
     * @return
     */
    public ReceiverNotePO getReceiverNotePOByUserIdAndNoteId(Long userId, Long noteId) {
        ReceiverNotePOExample receiverNotePOExample = new ReceiverNotePOExample();
        receiverNotePOExample.createCriteria().andUserIdEqualTo(userId).andNoteIdEqualTo(noteId);
        List<ReceiverNotePO> receiverNotePOS = receiverNotePOMapper.selectByExample(receiverNotePOExample);
        if (receiverNotePOS != null) {
            return receiverNotePOS.get(0);
        }
        return null;
    }

    /**
     * 根据关联表列表找笔记ids
     *
     * @param receiverNotePOS 关联表列表
     * @return
     */
    public List<Long> getNoteIdByReceiverNotePO(List<ReceiverNotePO> receiverNotePOS) {
        List<Long> noteIds = new ArrayList<>();
        for (ReceiverNotePO receiverNotePO : receiverNotePOS) {
            noteIds.add(receiverNotePO.getNoteId());
        }
        return noteIds;
    }


}
