package cn.gson.oasys.vo.addressVO2;

import cn.gson.oasys.model.entity.user.User;
import cn.gson.oasys.vo.UserVO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
public class DirectorVO {


    private Long directorId; //主键

    private String userName;    //通讯录名称

    private String pinyin;        //通讯录名称的拼音

    private String sex;        //性别

    private String phoneNumber;  //电话号码

    private Long attachment;     //头像路径image_path(附件ID）

    private String remark;     //备注

    private String address;    //用户住址

    private UserVO userVO;        //由哪个用户创建的user_id

    private String email;        //邮件

    private String companyNumber;    //公司号码

    private String companyName;        //公司名称
}
