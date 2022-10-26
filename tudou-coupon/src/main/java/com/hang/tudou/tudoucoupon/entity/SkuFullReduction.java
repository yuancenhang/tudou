
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("sms_sku_full_reduction")
public class SkuFullReduction extends MyPage {

	//id
	@TableId
	private Long id;

	//spu_id
	private Long skuId;

	//满多少
	private BigDecimal fullPrice;

	//减多少
	private BigDecimal reducePrice;

	//是否参与其他优惠
	private Integer addOther;



}
