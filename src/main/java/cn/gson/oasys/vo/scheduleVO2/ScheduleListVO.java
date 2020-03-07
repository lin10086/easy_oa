package cn.gson.oasys.vo.scheduleVO2;

import cn.gson.oasys.vo.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
@Data
public class ScheduleListVO {

    private Long rcId;    //日程id(rc_id)

    private Long typeId;    //类型id(type_id)

    private Long statusId;    //状态id(status_id)

    private Date startTime;    //开始时间start_time

    private Date endTime;    //结束时间end_time

    private Date createTime = new Date();    //发布时间create_time

    private String title;    //日程标题

    private String describe;    //日程描述miaoshu

    private Boolean isRemind = false;    //是否提醒is_remind

    private String username;

    private Boolean isreminded = false;

    private UserVO userVO;            //日程所属人user_id

//    @ManyToMany
//    @JsonIgnore
//    @JoinTable(
//            name = "aoa_schedule_user",            //日程联系人关联表
//            joinColumns = {
//                    @JoinColumn(name = "rcid")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "user_id")
//            })
    private List<UserVO> userVOList;    //联系人集合
}
