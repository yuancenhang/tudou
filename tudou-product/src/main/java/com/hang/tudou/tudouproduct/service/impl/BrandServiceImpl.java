
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.Brand;
import com.hang.tudou.tudouproduct.mapper.BrandMapper;
import com.hang.tudou.tudouproduct.service.BrandService;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper,Brand> implements BrandService {

	@Autowired
	BrandMapper brandMapper;

}