
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sms_seckill_promotion")
public class SeckillPromotion extends MyPage {

	//id
	@TableId
	private Long id;

	//活动标题
	private String title;

	//开始日期
	private LocalDateTime startTime;

	//结束日期
	private LocalDateTime endTime;

	//上下线状态
	private Integer status;

	//创建时间
	private LocalDateTime createTime;

	//创建人
	private Long userId;



}
