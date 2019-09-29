package cn.gson.oasys.model.bo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@ToString
@Data
public class QueryAttendsBO {
    /**
     * 搜索
     */
    private String baseKey;

    /**
     * 考勤类型
     */
    private List<Long> attendTypes;

    /**
     * 考勤状态
     */
    private List<Long> attendStatus;

    /**
     * 考勤开始时间
     */
    private Date attendDayStart;


    /**
     * 考勤结束时间
     */
    private Date attendDayEnd;

    /**
     * 登录人下属id集合
     */
    private List<Long> userIds;
}
