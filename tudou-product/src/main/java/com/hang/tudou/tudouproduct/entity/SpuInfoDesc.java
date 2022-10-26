
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("pms_spu_info_desc")
public class SpuInfoDesc extends MyPage {

	//商品id
	@TableId
	private Long spuId;

	//商品介绍
	private String decript;



}
