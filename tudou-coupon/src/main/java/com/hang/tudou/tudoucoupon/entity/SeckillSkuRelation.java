
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("sms_seckill_sku_relation")
public class SeckillSkuRelation extends MyPage {

	//id
	@TableId
	private Long id;

	//活动id
	private Long promotionId;

	//活动场次id
	private Long promotionSessionId;

	//商品id
	private Long skuId;

	//秒杀价格
	private BigDecimal seckillPrice;

	//秒杀总量
	private BigDecimal seckillCount;

	//每人限购数量
	private BigDecimal seckillLimit;

	//排序
	private Integer seckillSort;



}
