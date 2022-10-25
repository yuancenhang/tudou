
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.SkuInfo;
import com.hang.tudou.tudouproduct.mapper.SkuInfoMapper;
import com.hang.tudou.tudouproduct.service.SkuInfoService;

@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper,SkuInfo> implements SkuInfoService {

	@Autowired
	SkuInfoMapper skuInfoMapper;

}