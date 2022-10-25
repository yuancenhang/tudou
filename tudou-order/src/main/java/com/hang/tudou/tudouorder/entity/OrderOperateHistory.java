
package com.hang.tudou.tudouorder.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("oms_order_operate_history")
public class OrderOperateHistory extends MyPage{

	//id
	private Long id;

	//订单id
	private Long orderId;

	//操作人[用户；系统；后台管理员]
	private String operateMan;

	//操作时间
	private LocalDateTime createTime;

	//订单状态【0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单】
	private Integer orderStatus;

	//备注
	private String note;



}
