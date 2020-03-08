package cn.gson.oasys.voandfactory.processVO2;

import cn.gson.oasys.modelV2.po.SubjectPO;

import java.util.ArrayList;
import java.util.List;

public class SubjectVOFactory {
    public static SubjectVO createSubjectVOBySubjectPO(SubjectPO subjectPO) {
        SubjectVO subjectVO = new SubjectVO();
        subjectVO.setSubjectId(subjectPO.getSubjectId());
        subjectVO.setSubjectName(subjectPO.getName());
        subjectVO.setParentId(subjectPO.getParentId());
        return subjectVO;
    }

    public static List<SubjectVO> createSubjectVOListBySubjectPOList(List<SubjectPO> subjectPOList) {
        List<SubjectVO> subjectVOList = new ArrayList<>();
        for (SubjectPO subjectPO : subjectPOList) {
            subjectVOList.add(SubjectVOFactory.createSubjectVOBySubjectPO(subjectPO));
        }
        return subjectVOList;
    }

}
