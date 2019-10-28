package cn.gson.oasys.vo;

import lombok.Data;
import lombok.ToString;

//费用科目明细表
@ToString
@Data
public class SubjectVO {
    private Long subjectId;

    private Long parentId;

    private String subjectName;
}
