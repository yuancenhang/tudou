
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pms_category_brand_relation")
public class CategoryBrandRelation extends MyPage{

	//
	private Long id;

	//品牌id
	private Long brandId;

	//分类id
	private Long catelogId;

	//
	private String brandName;

	//
	private String catelogName;



}
