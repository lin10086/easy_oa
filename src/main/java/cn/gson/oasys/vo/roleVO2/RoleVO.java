package cn.gson.oasys.vo.roleVO2;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RoleVO {
    private Long roleId;//角色id
    private String roleName;//角色名
    private Integer  roleValue;//角色权限值
}
