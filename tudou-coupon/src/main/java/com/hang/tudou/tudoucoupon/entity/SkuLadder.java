
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("sms_sku_ladder")
public class SkuLadder extends MyPage {

	//id
	@TableId
	private Long id;

	//spu_id
	private Long skuId;

	//满几件
	private Integer fullCount;

	//打几折
	private BigDecimal discount;

	//折后价
	private BigDecimal price;

	//是否叠加其他优惠[0-不可叠加，1-可叠加]
	private Integer addOther;



}
