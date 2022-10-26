
package com.hang.tudou.tudouware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("wms_ware_order_task")
public class WareOrderTask extends MyPage {

	//id
	private Long id;

	//order_id
	private Long orderId;

	//order_sn
	private String orderSn;

	//收货人
	private String consignee;

	//收货人电话
	private Character consigneeTel;

	//配送地址
	private String deliveryAddress;

	//订单备注
	private String orderComment;

	//付款方式【 1:在线付款 2:货到付款】
	private Integer paymentWay;

	//任务状态
	private Integer taskStatus;

	//订单描述
	private String orderBody;

	//物流单号
	private Character trackingNo;

	//create_time
	private LocalDateTime createTime;

	//仓库id
	private Long wareId;

	//工作单备注
	private String taskComment;



}
