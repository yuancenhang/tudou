
package com.hang.tudou.tudouware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("wms_purchase")
public class Purchase extends MyPage{

	//
	private Long id;

	//
	private Long assigneeId;

	//
	private String assigneeName;

	//
	private Character phone;

	//
	private Integer priority;

	//
	private Integer status;

	//
	private Long wareId;

	//
	private BigDecimal amount;

	//
	private LocalDateTime createTime;

	//
	private LocalDateTime updateTime;



}