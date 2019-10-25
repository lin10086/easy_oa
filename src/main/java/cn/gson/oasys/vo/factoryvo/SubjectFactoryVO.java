package cn.gson.oasys.vo.factoryvo;

import cn.gson.oasys.model.po.SubjectPO;
import cn.gson.oasys.vo.SubjectVO;

import java.util.ArrayList;
import java.util.List;

public class SubjectFactoryVO {
    public static SubjectVO createSubjectVO(SubjectPO subjectPO){
        SubjectVO subjectVO = new SubjectVO();
        subjectVO.setSubjectId(subjectPO.getSubjectId());
        subjectVO.setSubjectName(subjectPO.getName());
        subjectVO.setParentId(subjectPO.getParentId());
        return subjectVO;
    }
    public static List<SubjectVO> createSubjectVOList(List<SubjectPO>subjectPOList){
        List<SubjectVO>subjectVOList = new ArrayList<>();
        for(SubjectPO subjectPO :subjectPOList){
            subjectVOList.add(SubjectFactoryVO.createSubjectVO(subjectPO));
        }
        return subjectVOList;
    }

}
