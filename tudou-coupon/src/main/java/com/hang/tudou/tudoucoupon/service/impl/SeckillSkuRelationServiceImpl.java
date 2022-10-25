
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.SeckillSkuRelation;
import com.hang.tudou.tudoucoupon.mapper.SeckillSkuRelationMapper;
import com.hang.tudou.tudoucoupon.service.SeckillSkuRelationService;

@Service
public class SeckillSkuRelationServiceImpl extends ServiceImpl<SeckillSkuRelationMapper,SeckillSkuRelation> implements SeckillSkuRelationService {

	@Autowired
	SeckillSkuRelationMapper seckillSkuRelationMapper;

}