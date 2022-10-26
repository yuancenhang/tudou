
package com.hang.tudou.tudouware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("wms_purchase")
public class Purchase extends MyPage {

	//
	@TableId
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
