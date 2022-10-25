
package com.hang.tudou.tudouorder.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("oms_order_return_reason")
public class OrderReturnReason extends MyPage{

	//id
	private Long id;

	//退货原因名
	private String name;

	//排序
	private Integer sort;

	//启用状态
	private Integer status;

	//create_time
	private LocalDateTime createTime;



}
