
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("pms_spu_info_desc")
public class SpuInfoDesc extends MyPage{

	//商品id
	private Long spuId;

	//商品介绍
	private String decript;



}
