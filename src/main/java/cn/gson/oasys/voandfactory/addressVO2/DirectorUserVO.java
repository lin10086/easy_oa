package cn.gson.oasys.voandfactory.addressVO2;

import cn.gson.oasys.voandfactory.userVO2.UserVO;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class DirectorUserVO {

    private Long directorUserId;//主键

    private DirectorVO directorVO;//director_id

    private UserVO userVO;//user_id被动

    private UserVO shareUser;//share_user_id主动

    private String catalogName;//目录名

    private Date shareTime;//分享时间

    private Boolean handle;//is_handle是否处理了
}
