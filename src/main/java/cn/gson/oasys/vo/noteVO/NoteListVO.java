package cn.gson.oasys.vo.noteVO;

import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.model.po.UserPO;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * 笔记表
 */
@ToString
@Data
public class NoteListVO {
    private Long noteId; // 笔记id（note_id）

    private String title;// 笔记标题

    private String content;// 内容

    private Long catalogId; // 目录id（catalog_id）

    private Long typeId; // 类型id（type_id）

    private Long statusId; // 状态id（status_id）

    private Long attachId; // 附件id（attach_id）

    private Date createTime;// 发布时间（create_time）

    private Long isCollected; // 是否收藏（is_collected）

    private Long createManId; // 创建人ID（createman_id）

    private String receiver;// 笔记分享接收人名（receiver）

    private Set<UserPO> userPOSet;//接收人表的用户（user_id）
}
