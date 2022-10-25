
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.HomeSubjectSpu;
import com.hang.tudou.tudoucoupon.mapper.HomeSubjectSpuMapper;
import com.hang.tudou.tudoucoupon.service.HomeSubjectSpuService;

@Service
public class HomeSubjectSpuServiceImpl extends ServiceImpl<HomeSubjectSpuMapper,HomeSubjectSpu> implements HomeSubjectSpuService {

	@Autowired
	HomeSubjectSpuMapper homeSubjectSpuMapper;

}