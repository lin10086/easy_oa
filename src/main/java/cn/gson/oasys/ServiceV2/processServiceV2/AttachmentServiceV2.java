package cn.gson.oasys.ServiceV2.processServiceV2;

import cn.gson.oasys.mappers.AttachmentListPOMapper;
import cn.gson.oasys.model.po.AttachmentListPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AttachmentServiceV2 {
    @Resource
    private AttachmentListPOMapper attachmentListPOMapper;

    /**
     * 根据附件ID找附件信息
     *
     * @param attachmentListPOId
     * @return
     */
    public AttachmentListPO getAttachmentListPOByAttachmentListPOId(Long attachmentListPOId) {
        AttachmentListPO attachmentListPO = attachmentListPOMapper.selectByPrimaryKey(attachmentListPOId);
        return attachmentListPO;
    }

    /**
     * 根据附件ID找附件存储路径
     *
     * @param attachmentListPOId 附件ID
     * @return
     */
    public String getAttachmentPathByFileId(Long attachmentListPOId) {
        AttachmentListPO attachmentListPO = attachmentListPOMapper.selectByPrimaryKey(attachmentListPOId);
        String attachmentPath = attachmentListPO.getAttachmentPath();
        return attachmentPath;
    }

    /**
     * 设置附件的model信息并插入附近
     *
     * @param attachmentListPO
     */
    public void insertAttachmentListPOSetModel(AttachmentListPO attachmentListPO, String setModel) {
        attachmentListPO.setModel(setModel);
        attachmentListPOMapper.insertSelective(attachmentListPO);
    }
}
