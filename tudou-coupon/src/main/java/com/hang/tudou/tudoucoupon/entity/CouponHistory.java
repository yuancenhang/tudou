
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sms_coupon_history")
public class CouponHistory extends MyPage {

	//id
	private Long id;

	//优惠券id
	private Long couponId;

	//会员id
	private Long memberId;

	//会员名字
	private String memberNickName;

	//获取方式[0->后台赠送；1->主动领取]
	private Integer getType;

	//创建时间
	private LocalDateTime createTime;

	//使用状态[0->未使用；1->已使用；2->已过期]
	private Integer useType;

	//使用时间
	private LocalDateTime useTime;

	//订单id
	private Long orderId;

	//订单号
	private Long orderSn;



}
