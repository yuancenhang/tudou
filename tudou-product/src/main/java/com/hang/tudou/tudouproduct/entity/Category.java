
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("pms_category")
public class Category extends MyPage {

	//分类id
	private Long catId;

	//分类名称
	private Character name;

	//父分类id
	private Long parentCid;

	//层级
	private Integer catLevel;

	//是否显示[0-不显示，1显示]
	private Integer showStatus;

	//排序
	private Integer sort;

	//图标地址
	private Character icon;

	//计量单位
	private Character productUnit;

	//商品数量
	private Integer productCount;



}
