
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.CouponSpuCategoryRelation;
import com.hang.tudou.tudoucoupon.mapper.CouponSpuCategoryRelationMapper;
import com.hang.tudou.tudoucoupon.service.CouponSpuCategoryRelationService;

@Service
public class CouponSpuCategoryRelationServiceImpl extends ServiceImpl<CouponSpuCategoryRelationMapper,CouponSpuCategoryRelation> implements CouponSpuCategoryRelationService {

	@Autowired
	CouponSpuCategoryRelationMapper couponSpuCategoryRelationMapper;

}