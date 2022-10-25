
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pms_sku_images")
public class SkuImages extends MyPage{

	//id
	private Long id;

	//sku_id
	private Long skuId;

	//图片地址
	private String imgUrl;

	//排序
	private Integer imgSort;

	//默认图[0 - 不是默认图，1 - 是默认图]
	private Integer defaultImg;



}
