
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.CouponHistory;
import com.hang.tudou.tudoucoupon.mapper.CouponHistoryMapper;
import com.hang.tudou.tudoucoupon.service.CouponHistoryService;

@Service
public class CouponHistoryServiceImpl extends ServiceImpl<CouponHistoryMapper,CouponHistory> implements CouponHistoryService {

	@Autowired
	CouponHistoryMapper couponHistoryMapper;

}