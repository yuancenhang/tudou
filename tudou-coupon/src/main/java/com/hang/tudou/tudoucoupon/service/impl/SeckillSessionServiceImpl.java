
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.SeckillSession;
import com.hang.tudou.tudoucoupon.mapper.SeckillSessionMapper;
import com.hang.tudou.tudoucoupon.service.SeckillSessionService;

@Service
public class SeckillSessionServiceImpl extends ServiceImpl<SeckillSessionMapper,SeckillSession> implements SeckillSessionService {

	@Autowired
	SeckillSessionMapper seckillSessionMapper;

}