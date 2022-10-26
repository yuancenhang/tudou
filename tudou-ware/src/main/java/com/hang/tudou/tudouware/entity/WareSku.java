
package com.hang.tudou.tudouware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("wms_ware_sku")
public class WareSku extends MyPage {

	//id
	private Long id;

	//sku_id
	private Long skuId;

	//仓库id
	private Long wareId;

	//库存数
	private Integer stock;

	//sku_name
	private String skuName;

	//锁定库存
	private Integer stockLocked;



}
