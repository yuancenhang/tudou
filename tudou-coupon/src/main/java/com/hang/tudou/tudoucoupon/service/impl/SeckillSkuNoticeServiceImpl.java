
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.SeckillSkuNotice;
import com.hang.tudou.tudoucoupon.mapper.SeckillSkuNoticeMapper;
import com.hang.tudou.tudoucoupon.service.SeckillSkuNoticeService;

@Service
public class SeckillSkuNoticeServiceImpl extends ServiceImpl<SeckillSkuNoticeMapper,SeckillSkuNotice> implements SeckillSkuNoticeService {

	@Autowired
	SeckillSkuNoticeMapper seckillSkuNoticeMapper;

}