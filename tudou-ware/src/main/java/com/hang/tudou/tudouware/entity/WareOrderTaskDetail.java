
package com.hang.tudou.tudouware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("wms_ware_order_task_detail")
public class WareOrderTaskDetail extends MyPage{

	//id
	private Long id;

	//sku_id
	private Long skuId;

	//sku_name
	private String skuName;

	//购买个数
	private Integer skuNum;

	//工作单id
	private Long taskId;

	//仓库id
	private Long wareId;

	//1-已锁定  2-已解锁  3-扣减
	private Integer lockStatus;



}
