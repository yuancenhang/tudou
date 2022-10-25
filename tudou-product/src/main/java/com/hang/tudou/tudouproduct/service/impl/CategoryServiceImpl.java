
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.Category;
import com.hang.tudou.tudouproduct.mapper.CategoryMapper;
import com.hang.tudou.tudouproduct.service.CategoryService;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

}