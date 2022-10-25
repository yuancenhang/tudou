
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.HomeAdv;
import com.hang.tudou.tudoucoupon.mapper.HomeAdvMapper;
import com.hang.tudou.tudoucoupon.service.HomeAdvService;

@Service
public class HomeAdvServiceImpl extends ServiceImpl<HomeAdvMapper,HomeAdv> implements HomeAdvService {

	@Autowired
	HomeAdvMapper homeAdvMapper;

}