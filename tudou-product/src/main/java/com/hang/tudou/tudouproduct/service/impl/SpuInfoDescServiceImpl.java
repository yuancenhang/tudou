
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.SpuInfoDesc;
import com.hang.tudou.tudouproduct.mapper.SpuInfoDescMapper;
import com.hang.tudou.tudouproduct.service.SpuInfoDescService;

@Service
public class SpuInfoDescServiceImpl extends ServiceImpl<SpuInfoDescMapper,SpuInfoDesc> implements SpuInfoDescService {

	@Autowired
	SpuInfoDescMapper spuInfoDescMapper;

}