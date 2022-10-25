
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pms_spu_images")
public class SpuImages extends MyPage{

	//id
	private Long id;

	//spu_id
	private Long spuId;

	//图片名
	private String imgName;

	//图片地址
	private String imgUrl;

	//顺序
	private Integer imgSort;

	//是否默认图
	private Integer defaultImg;



}