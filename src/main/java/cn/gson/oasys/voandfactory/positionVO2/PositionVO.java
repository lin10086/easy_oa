package cn.gson.oasys.voandfactory.positionVO2;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class PositionVO {
    private Long positionId;	//职位id

    private String positionName;	//职位名称

    private Integer positionLevel;	//职位层级

    private String positionDescription;//职位描述

    private Long deptId;    // 部门ID
}
