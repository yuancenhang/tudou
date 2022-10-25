
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.Coupon;
import com.hang.tudou.tudoucoupon.mapper.CouponMapper;
import com.hang.tudou.tudoucoupon.service.CouponService;

@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper,Coupon> implements CouponService {

	@Autowired
	CouponMapper couponMapper;

}