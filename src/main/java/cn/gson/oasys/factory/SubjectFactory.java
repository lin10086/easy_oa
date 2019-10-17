package cn.gson.oasys.factory;


import cn.gson.oasys.model.entity.process.Subject;
import cn.gson.oasys.model.po.SubjectPO;

import java.util.ArrayList;
import java.util.List;

public class SubjectFactory {
    //把费用报销表进行转换
    public static Subject create(SubjectPO subjectPO) {
        Subject subject = new Subject();
        subject.setSubjectId(subjectPO.getSubjectId());
        subject.setName(subjectPO.getName());
        subject.setParentId(subjectPO.getParentId());
        return subject;
    }

    public static List<Subject> createSubjectList(List<SubjectPO> subjectPOList) {
        List<Subject> subjectList = new ArrayList<>();
        for (SubjectPO subjectPO : subjectPOList) {
            subjectList.add(SubjectFactory.create(subjectPO));
        }
        return subjectList;
    }
}
