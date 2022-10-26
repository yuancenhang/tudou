
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("sms_coupon_spu_relation")
public class CouponSpuRelation extends MyPage {

	//id
	@TableId
	private Long id;

	//优惠券id
	private Long couponId;

	//spu_id
	private Long spuId;

	//spu_name
	private String spuName;



}
