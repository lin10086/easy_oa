package cn.gson.oasys.ServiceV2.processV2;

import cn.gson.oasys.mappers.AttachmentListPOMapper;
import cn.gson.oasys.mappers.AttendsPOMapper;
import cn.gson.oasys.model.po.AttachmentListPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AttachmentServiceV2 {
    @Resource
    private AttachmentListPOMapper attachmentListPOMapper;

    /**
     * 插入附件到附件表
     */
    public void insertAttachmentListPO(AttachmentListPO attachmentListPO) {
        attachmentListPO.setModel("aoa_bursement");
        attachmentListPOMapper.insertSelective(attachmentListPO);
    }

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
    public String getAttachmentPathByAttachmentListPOId(Long attachmentListPOId) {
        AttachmentListPO attachmentListPO = attachmentListPOMapper.selectByPrimaryKey(attachmentListPOId);
        String attachmentPath = attachmentListPO.getAttachmentPath();
        return attachmentPath;
    }
}
