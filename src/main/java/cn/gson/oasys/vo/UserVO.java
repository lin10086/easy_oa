package cn.gson.oasys.vo;

import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@ToString
@Data
public class UserVO {
    private Long userId;		//用户id
    private String userName;	//登录用户名
    private String userTel;		//用户电话
    private String realName;    //真实姓名
    private String pinyin;      //用户名的拼音
    private String userEmail;		//邮件
    private String userAddress;		//地址
    private String userEdu;		//用户学历
    private Boolean superman=false;//是否是超人，默认不是
    private String userSchool;		//学校
    private String userIdCard;		//用户身份证
    private String bank;		//银行
    private String sex;			//性别
    private String themeSkin;	//主题皮肤
    private Date birth;			//生日
    private String userSign;	//用户签名
    private String password;	//用户密码
    private String salary;		//用户薪水
    private String imgPath;		//用户头像路径
    private Date hireTime;		//入职时间
    private Integer isLock=0;		//该用户是否被禁用,默认可以用
    private String lastLoginIp;	//用户最后登录ip；
    private Date lastLoginTime;	//最后登录时间
    private Date modifyTime;		//最后修改时间
    private Long modifyUserId;	//最后修改此用户的用户id
    private Long fatherId;		//上司id
    private Integer holiday;   //请假天数
    private PositionVO positionVO;	//外键关联 职位表
    private DeptVO deptVO;			//外键关联 部门表
    private RoleVO roleVO;			//外键关联 角色表
//    private List<ScheduleList> scheduleLists;
//    private List<Reply> replys;
//    private List<Discuss> discuss;
//    private List<Note> note;
//    private Set<Attends> aSet;

}

