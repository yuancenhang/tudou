
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("pms_category_brand_relation")
public class CategoryBrandRelation extends MyPage {

	//
	@TableId
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
