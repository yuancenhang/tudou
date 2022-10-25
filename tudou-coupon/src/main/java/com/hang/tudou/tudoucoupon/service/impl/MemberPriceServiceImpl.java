
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.MemberPrice;
import com.hang.tudou.tudoucoupon.mapper.MemberPriceMapper;
import com.hang.tudou.tudoucoupon.service.MemberPriceService;

@Service
public class MemberPriceServiceImpl extends ServiceImpl<MemberPriceMapper,MemberPrice> implements MemberPriceService {

	@Autowired
	MemberPriceMapper memberPriceMapper;

}