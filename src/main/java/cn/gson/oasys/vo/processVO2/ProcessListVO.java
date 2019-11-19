package cn.gson.oasys.vo.processVO2;

import cn.gson.oasys.vo.AttachmentVO;
import cn.gson.oasys.vo.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

//主表
@ToString
@Data
public class ProcessListVO {

    private Long processId;

    private String typeName;            //流程申请类型

    private Long statusId;            //流程审核状态 id

    private Long deeplyId;    //紧急程度（对应类型表里面的typeId）

    private String processName;        //标题

    private String processDescribe;    //流程申请原因内容

    private UserVO userVO;            //流程申请人（数据库process_user_id)

    private Date applyTime;            //流程申请时间

    private Boolean isChecked = false;        //流程是否被驳回

    private Date startTime;            //流程开始时间

    private Date endTime;            //流程结束时间

    private Integer processDays;        //流程总天数

    private AttachmentVO attachmentVO;   //流程附件id对应流程附件表pro_file_id

    private String auditUsername;        //审核人用户名

}
