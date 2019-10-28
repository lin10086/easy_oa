package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.AttachmentListPO;
import cn.gson.oasys.vo.AttachmentVO;

import java.util.ArrayList;
import java.util.List;

public class AttachmentFactoryVO {
    public static AttachmentVO createAttachmentVO(AttachmentListPO attachmentListPO) {
        AttachmentVO attachmentVO = new AttachmentVO();
        attachmentVO.setAttachmentId(attachmentListPO.getAttachmentId());
        attachmentVO.setAttachmentName(attachmentListPO.getAttachmentName());
        attachmentVO.setAttachmentPath(attachmentListPO.getAttachmentPath());
        attachmentVO.setAttachmentShuffix(attachmentListPO.getAttachmentShuffix());
        attachmentVO.setAttachmentSize(attachmentListPO.getAttachmentId());
        attachmentVO.setAttachmentType(attachmentListPO.getAttachmentType());
        attachmentVO.setModel(attachmentListPO.getModel());
        attachmentVO.setUploadTime(attachmentListPO.getUploadTime());
        attachmentVO.setUserVOId(Long.parseLong(attachmentListPO.getUserId()));
        return attachmentVO;
    }

    public static List<AttachmentVO> createAttachmentVOList(List<AttachmentListPO> attachmentListPOList) {
        List<AttachmentVO> attachmentVOList = new ArrayList<>();
        for (AttachmentListPO attachmentListPO : attachmentListPOList) {
            attachmentVOList.add(AttachmentFactoryVO.createAttachmentVO(attachmentListPO));
        }
        return attachmentVOList;
    }
}
