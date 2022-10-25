
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.HomeSubject;
import com.hang.tudou.tudoucoupon.mapper.HomeSubjectMapper;
import com.hang.tudou.tudoucoupon.service.HomeSubjectService;

@Service
public class HomeSubjectServiceImpl extends ServiceImpl<HomeSubjectMapper,HomeSubject> implements HomeSubjectService {

	@Autowired
	HomeSubjectMapper homeSubjectMapper;

}