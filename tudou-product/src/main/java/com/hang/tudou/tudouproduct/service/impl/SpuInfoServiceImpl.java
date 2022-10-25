
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.SpuInfo;
import com.hang.tudou.tudouproduct.mapper.SpuInfoMapper;
import com.hang.tudou.tudouproduct.service.SpuInfoService;

@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper,SpuInfo> implements SpuInfoService {

	@Autowired
	SpuInfoMapper spuInfoMapper;

}