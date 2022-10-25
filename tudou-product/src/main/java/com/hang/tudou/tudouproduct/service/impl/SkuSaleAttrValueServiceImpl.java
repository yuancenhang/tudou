
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.SkuSaleAttrValue;
import com.hang.tudou.tudouproduct.mapper.SkuSaleAttrValueMapper;
import com.hang.tudou.tudouproduct.service.SkuSaleAttrValueService;

@Service
public class SkuSaleAttrValueServiceImpl extends ServiceImpl<SkuSaleAttrValueMapper,SkuSaleAttrValue> implements SkuSaleAttrValueService {

	@Autowired
	SkuSaleAttrValueMapper skuSaleAttrValueMapper;

}