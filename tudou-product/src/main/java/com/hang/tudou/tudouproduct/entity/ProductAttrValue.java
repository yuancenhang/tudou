
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("pms_product_attr_value")
public class ProductAttrValue extends MyPage {

	//id
	@TableId
	private Long id;

	//商品id
	private Long spuId;

	//属性id
	private Long attrId;

	//属性名
	private String attrName;

	//属性值
	private String attrValue;

	//顺序
	private Integer attrSort;

	//快速展示【是否展示在介绍上；0-否 1-是】
	private Integer quickShow;



}
