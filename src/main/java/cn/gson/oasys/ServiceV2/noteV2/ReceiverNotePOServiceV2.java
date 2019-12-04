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
     * 根据关联表列表找笔记ids
     *
     * @param receiverNotePOS 关联表列表
     * @return
     */
    public List<Long> getNoteIdByReceiverNotePO(List<ReceiverNotePO> receiverNotePOS) {
        List<Long> noteIds = new ArrayList<>();
        for (ReceiverNotePO receiverNotePO : receiverNotePOS) {
            noteIds.add(receiverNotePO.getId());
        }
        return noteIds;
    }
}
