package cn.gson.oasys.voandfactory.statusVO2;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class StatusVO {


    private Long statusId; // 状态id


    private String statusName; // 状态名称

    private Integer statusSortValue; // 状态排序值

    private String statusModel; // 状态模块

    private String statusColor; // 状态颜色

    private String statusPercent;//百分比
}
