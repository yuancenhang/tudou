
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("pms_brand")
public class Brand extends MyPage {

	//品牌id
	@TableId
	private Long brandId;

	//品牌名
	private Character name;

	//品牌logo地址
	private String logo;

	//介绍
	private String descript;

	//显示状态[0-不显示；1-显示]
	private Integer showStatus;

	//检索首字母
	private Character firstLetter;

	//排序
	private Integer sort;



}
