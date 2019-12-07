package cn.gson.oasys.vo.systemmenuVO2;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@ToString
public class SystemMenuVO {

    private Long menuId; // 菜单id

    private Long parentId = 0L; // 父id

    private String menuName; // 菜单名字

    private String menuUrl; // 菜单链接

    private String menuIcon; // 菜单图标

    private Integer sortId = 999; // 菜单排序id

    private Boolean isShow = false; // 菜单是否显示

    private Integer menuGrade; // 权限值分数


}
