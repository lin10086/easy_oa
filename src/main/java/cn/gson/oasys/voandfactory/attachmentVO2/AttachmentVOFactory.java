package cn.gson.oasys.voandfactory.attachmentVO2;

import cn.gson.oasys.modelV2.po.AttachmentListPO;

import java.util.ArrayList;
import java.util.List;

public class AttachmentVOFactory {

    public static AttachmentVO createAttachmentVOByAttachmentPO(AttachmentListPO attachmentListPO) {
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

    public static List<AttachmentVO> createAttachmentVOListByAttachmentPOList(List<AttachmentListPO> attachmentListPOList) {
        List<AttachmentVO> attachmentVOList = new ArrayList<>();
        for (AttachmentListPO attachmentListPO : attachmentListPOList) {
            attachmentVOList.add(AttachmentVOFactory.createAttachmentVOByAttachmentPO(attachmentListPO));
        }
        return attachmentVOList;
    }
}
