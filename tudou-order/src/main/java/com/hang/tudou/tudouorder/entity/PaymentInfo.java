
package com.hang.tudou.tudouorder.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@TableName("oms_payment_info")
public class PaymentInfo extends MyPage {

	//id
	@TableId
	private Long id;

	//订单号（对外业务号）
	private Character orderSn;

	//订单id
	private Long orderId;

	//支付宝交易流水号
	private String alipayTradeNo;

	//支付总金额
	private BigDecimal totalAmount;

	//交易内容
	private String subject;

	//支付状态
	private String paymentStatus;

	//创建时间
	private LocalDateTime createTime;

	//确认时间
	private LocalDateTime confirmTime;

	//回调内容
	private String callbackContent;

	//回调时间
	private LocalDateTime callbackTime;



}
