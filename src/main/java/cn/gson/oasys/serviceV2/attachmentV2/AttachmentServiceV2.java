package cn.gson.oasys.serviceV2.attachmentV2;

import cn.gson.oasys.mappers.AttachmentListPOMapper;
import cn.gson.oasys.model.po.AttachmentListPO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class AttachmentServiceV2 {
    @Resource
    private AttachmentListPOMapper attachmentListPOMapper;

    /**
     * 设置附件的model信息并插入附件
     *
     * @param attachmentListPO
     */
    public void insertAttachmentListPOSetModel(AttachmentListPO attachmentListPO, String setModel) {
        attachmentListPO.setModel(setModel);
        attachmentListPOMapper.insertSelective(attachmentListPO);
    }

    /**
     * 插入附件
     *
     * @param attachmentListPO
     */
    public void insertAttachmentListPO(AttachmentListPO attachmentListPO) {
        attachmentListPOMapper.insertSelective(attachmentListPO);
    }


    /**
     * 更新附件
     *
     * @param attachmentName
     * @param attachmentPath
     * @param shuffix
     * @param size
     * @param type
     * @param upTime
     * @param attachmentId
     */
    public Integer updateAttachmentListPO(String attachmentName, String attachmentPath, String shuffix, Long size, String type, Date upTime, Long attachmentId) {
        AttachmentListPO attachmentListPO = new AttachmentListPO();
        attachmentListPO.setAttachmentId(attachmentId);
        attachmentListPO.setAttachmentName(attachmentName);
        attachmentListPO.setAttachmentPath(attachmentPath);
        attachmentListPO.setAttachmentShuffix(shuffix);
        attachmentListPO.setAttachmentSize(size + "");
        attachmentListPO.setAttachmentType(type);
        attachmentListPO.setUploadTime(upTime);
        Integer rows = attachmentListPOMapper.updateByPrimaryKeySelective(attachmentListPO);
        return rows;
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
    public String getAttachmentPathByFileId(Long attachmentListPOId) {
        AttachmentListPO attachmentListPO = attachmentListPOMapper.selectByPrimaryKey(attachmentListPOId);
        String attachmentPath = attachmentListPO.getAttachmentPath();
        return attachmentPath;
    }


}
