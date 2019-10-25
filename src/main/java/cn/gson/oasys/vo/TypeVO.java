package cn.gson.oasys.vo;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class TypeVO {

    private Long typeId;			//类型id

    private String typeName;		//类型名字

    private Integer typeSortValue;	//排序值

    private String typeModel;		//所属模块

    private String typeColor;		//类型颜色
}
