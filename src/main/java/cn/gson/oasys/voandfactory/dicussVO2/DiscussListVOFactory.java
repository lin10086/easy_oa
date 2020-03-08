package cn.gson.oasys.voandfactory.dicussVO2;

import cn.gson.oasys.modelV2.po.DiscussListPO;

public class DiscussListVOFactory {
    public static DiscussListVO createDiscussListVOByDiscussListPO(DiscussListPO discussListPO) {
        DiscussListVO discussListVO = new DiscussListVO();
        discussListVO.setDiscussId(discussListPO.getDiscussId());
        discussListVO.setCreateTime(discussListPO.getCreateTime());
        discussListVO.setVisitNum(discussListPO.getVisitNum());
        discussListVO.setAttachmentId(discussListPO.getAttachmentId());
        discussListVO.setContent(discussListPO.getContent());
        discussListVO.setModifyTime(discussListPO.getModifyTime());
        discussListVO.setStatusId(discussListPO.getStatusId());
        discussListVO.setTitle(discussListPO.getTitle());
        discussListVO.setTypeId(discussListPO.getTypeId());
        return discussListVO;
    }
}
