
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.SpuBounds;
import com.hang.tudou.tudoucoupon.mapper.SpuBoundsMapper;
import com.hang.tudou.tudoucoupon.service.SpuBoundsService;

@Service
public class SpuBoundsServiceImpl extends ServiceImpl<SpuBoundsMapper,SpuBounds> implements SpuBoundsService {

	@Autowired
	SpuBoundsMapper spuBoundsMapper;

}