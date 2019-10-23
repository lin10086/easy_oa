package cn.gson.oasys.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class DeptVO {
    private Long deptId;	//部门id
    private String deptName;	//部门名字  非空 唯一
    private String deptTel;		//部门电话
    private String deptFax;		//部门传真
    private String email;		//部门email
    private String deptAddress;	//部门地址
    private Long deptManager;   //部门领导ID
    private Date startTime;		//部门上班时间
    private Date endTime;		//部门下班时间
}
