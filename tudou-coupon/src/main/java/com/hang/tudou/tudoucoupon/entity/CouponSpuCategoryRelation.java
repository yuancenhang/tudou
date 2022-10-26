
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("sms_coupon_spu_category_relation")
public class CouponSpuCategoryRelation extends MyPage {

	//id
	@TableId
	private Long id;

	//优惠券id
	private Long couponId;

	//产品分类id
	private Long categoryId;

	//产品分类名称
	private String categoryName;



}
