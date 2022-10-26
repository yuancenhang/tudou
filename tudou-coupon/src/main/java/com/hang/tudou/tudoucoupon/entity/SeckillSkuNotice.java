
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sms_seckill_sku_notice")
public class SeckillSkuNotice extends MyPage {

	//id
	@TableId
	private Long id;

	//member_id
	private Long memberId;

	//sku_id
	private Long skuId;

	//活动场次id
	private Long sessionId;

	//订阅时间
	private LocalDateTime subcribeTime;

	//发送时间
	private LocalDateTime sendTime;

	//通知方式[0-短信，1-邮件]
	private Integer noticeType;



}
