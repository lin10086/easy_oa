package cn.gson.oasys.vo.addressVO2;

import cn.gson.oasys.model.entity.note.Director;
import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.vo.UserVO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
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
