
package com.hang.tudou.tudouware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.math.BigDecimal;

@Data
@TableName("wms_purchase_detail")
public class PurchaseDetail extends MyPage {

	//
	@TableId
	private Long id;

	//采购单id
	private Long purchaseId;

	//采购商品id
	private Long skuId;

	//采购数量
	private Integer skuNum;

	//采购金额
	private BigDecimal skuPrice;

	//仓库id
	private Long wareId;

	//状态[0新建，1已分配，2正在采购，3已完成，4采购失败]
	private Integer status;



}
