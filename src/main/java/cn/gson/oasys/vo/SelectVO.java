package cn.gson.oasys.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class SelectVO {
    private String selectTypeName;//类型名
    private String selectLabel;//标签
    private String selectTitle;//标题
    private String selectDeptName;//部门名
    private String selectStatusName;//状态名
    private String selectStartTime;//开始时间
    private String selectEndTime;//结束时间
    private String selectPushUsername;//用户名
}
