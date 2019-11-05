package cn.gson.oasys.vo;

import cn.gson.oasys.model.entity.process.ProcessList;
import cn.gson.oasys.model.entity.user.User;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 审核表
 */
@ToString
@Data
public class ReviewedVO {

    private Long reviewedId;//审核表ID

    private UserVO userId;//审核人（审核人ID）

    private String advice; //审核人意见

    private Long statusId;//审核人状态

    private Date reviewedTime;//审核时间

    private ProcessListVO proId;//主表（主表ID）

    private Boolean del = false;//是否删除，默认未删除

    private String username;//传过来的审核人的名字

}
