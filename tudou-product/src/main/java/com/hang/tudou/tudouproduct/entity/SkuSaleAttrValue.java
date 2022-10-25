
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pms_sku_sale_attr_value")
public class SkuSaleAttrValue extends MyPage{

	//id
	private Long id;

	//sku_id
	private Long skuId;

	//attr_id
	private Long attrId;

	//销售属性名
	private String attrName;

	//销售属性值
	private String attrValue;

	//顺序
	private Integer attrSort;



}
