
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sms_seckill_session")
public class SeckillSession extends MyPage{

	//id
	private Long id;

	//场次名称
	private String name;

	//每日开始时间
	private LocalDateTime startTime;

	//每日结束时间
	private LocalDateTime endTime;

	//启用状态
	private Integer status;

	//创建时间
	private LocalDateTime createTime;



}
