
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.ProductAttrValue;
import com.hang.tudou.tudouproduct.mapper.ProductAttrValueMapper;
import com.hang.tudou.tudouproduct.service.ProductAttrValueService;

@Service
public class ProductAttrValueServiceImpl extends ServiceImpl<ProductAttrValueMapper,ProductAttrValue> implements ProductAttrValueService {

	@Autowired
	ProductAttrValueMapper productAttrValueMapper;

}