package cn.gson.oasys.vo.roleVO2;

import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.system.SystemMenu;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Data
@ToString
public class RolePowerMenuVO {
    private Long menuId; // 菜单id 1

    private String menuName; // 菜单名字1

    private String menuUrl; // 菜单链接1

    private Boolean show = false; // 菜单是否显示1

    private Boolean check = false; // 是否分配资源1

    private String menuIcon; // 菜单图标1

    private Integer sortId; // 菜单排序id1

    private Integer menuGrade; // 权限值分数1

    private Long parentId = 0L;//父级ID1

//    private Role roleId;//角色表ID


}
