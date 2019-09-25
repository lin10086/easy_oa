package cn.gson.oasys.model.entity;

import cn.gson.oasys.model.entity.attendce.Attends;
import cn.gson.oasys.model.entity.discuss.Discuss;
import cn.gson.oasys.model.entity.discuss.Reply;
import cn.gson.oasys.model.entity.note.Note;
import cn.gson.oasys.model.entity.role.Role;
import cn.gson.oasys.model.entity.schedule.ScheduleList;
import cn.gson.oasys.model.entity.user.Dept;
import cn.gson.oasys.model.entity.user.Position;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class UserEntity {
    private Integer userId;		//用户id
    private String bank;		//银行
    private String address;		//地址
    private Date birth;			//生日
    private String email;		//邮件
    private Integer fatherId;		//上司ID
    private Date hireTime;		//入职时间
    private String userIdCard;		//用户身份证
    private String imgPath;		//用户头像路径
    private Integer isLock;		//该用户是否被禁用
    private String lastLoginIp;	//用户最后登录ip；
    private Date lastLoginTime;	//最后登录时间
    private Date modifyTime;		//最后修改时间
    private Integer modifyUserId;	//最后修改此用户的用户id
    private String password;  //密码
    private String realName;    //真实姓名
    private Double salary;		//用户薪水
    private String userSchool;		//学校
    private String sex;			//性别
    private String themeSkin;	//主题皮肤
    private String userEdu;		//用户学历
    private String userName;	//登录用户名
    private String userSign;	//用户签名
    private String userTel;		//用户电话
    private Integer deptId;		// 部门id
    private Integer positionId;		//职位id
    private Integer roleId;		//角色id
    private Integer superMan;		//是否是超人
    private Integer holiday;		//请假
    private String pinyin;      //登录名拼音

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    public Date getHireTime() {
        return hireTime;
    }

    public void setHireTime(Date hireTime) {
        this.hireTime = hireTime;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Integer getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(Integer modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getThemeSkin() {
        return themeSkin;
    }

    public void setThemeSkin(String themeSkin) {
        this.themeSkin = themeSkin;
    }

    public String getUserEdu() {
        return userEdu;
    }

    public void setUserEdu(String userEdu) {
        this.userEdu = userEdu;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getSuperMan() {
        return superMan;
    }

    public void setSuperMan(Integer superMan) {
        this.superMan = superMan;
    }

    public Integer getHoliday() {
        return holiday;
    }

    public void setHoliday(Integer holiday) {
        this.holiday = holiday;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", bank='" + bank + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                ", email='" + email + '\'' +
                ", fatherId=" + fatherId +
                ", hireTime=" + hireTime +
                ", userIdCard='" + userIdCard + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", isLock=" + isLock +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", modifyTime=" + modifyTime +
                ", modifyUserId=" + modifyUserId +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", salary=" + salary +
                ", userSchool='" + userSchool + '\'' +
                ", sex='" + sex + '\'' +
                ", themeSkin='" + themeSkin + '\'' +
                ", userEdu='" + userEdu + '\'' +
                ", userName='" + userName + '\'' +
                ", userSign='" + userSign + '\'' +
                ", userTel='" + userTel + '\'' +
                ", deptId=" + deptId +
                ", positionId=" + positionId +
                ", roleId=" + roleId +
                ", superMan=" + superMan +
                ", holiday=" + holiday +
                ", pinyin='" + pinyin + '\'' +
                '}';
    }
}
