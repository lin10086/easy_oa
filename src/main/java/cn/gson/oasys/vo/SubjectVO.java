package cn.gson.oasys.vo;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class SubjectVO {
    private Long subjectId;

    private Long parentId;

    private String subjectName;
}
