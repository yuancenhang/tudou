
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.SeckillPromotion;
import com.hang.tudou.tudoucoupon.mapper.SeckillPromotionMapper;
import com.hang.tudou.tudoucoupon.service.SeckillPromotionService;

@Service
public class SeckillPromotionServiceImpl extends ServiceImpl<SeckillPromotionMapper,SeckillPromotion> implements SeckillPromotionService {

	@Autowired
	SeckillPromotionMapper seckillPromotionMapper;

}