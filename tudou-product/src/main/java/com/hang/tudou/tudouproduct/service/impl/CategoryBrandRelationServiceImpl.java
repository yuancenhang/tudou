
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.CategoryBrandRelation;
import com.hang.tudou.tudouproduct.mapper.CategoryBrandRelationMapper;
import com.hang.tudou.tudouproduct.service.CategoryBrandRelationService;

@Service
public class CategoryBrandRelationServiceImpl extends ServiceImpl<CategoryBrandRelationMapper,CategoryBrandRelation> implements CategoryBrandRelationService {

	@Autowired
	CategoryBrandRelationMapper categoryBrandRelationMapper;

}