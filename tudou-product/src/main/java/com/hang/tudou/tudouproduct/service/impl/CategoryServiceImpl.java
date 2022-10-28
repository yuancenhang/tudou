
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.Category;
import com.hang.tudou.tudouproduct.mapper.CategoryMapper;
import com.hang.tudou.tudouproduct.service.CategoryService;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	//@Autowired
	//RedisTemplate<String,Object> redisTemplate;

	@Override
	public List<Category> getAll() {
		List<Category> categories = categoryMapper.selectList(null);
		//filter是过滤,只留下parentCid==0的对象
		return categories.stream().filter(category -> category.getParentCid() == 0)
				//peek表示对流里的每个对象进行一些操作,设置当前对象的子对象
				.peek(category -> category.setChildren(getChildren(category, categories)))
				//sorted表示排序,getSort()是获取实体类的变量,值来自数据库
				.sorted(Comparator.comparingInt(m -> (m.getSort() == null ? 0 : m.getSort()))).toList();
	}

	//封装的一个递归方法,能不断的找出层层包含的对象
	private List<Category> getChildren(Category menu, List<Category> categories) {
		return categories.stream().filter(category -> Objects.equals(category.getParentCid(), menu.getCatId()))
				.peek(category -> category.setChildren(getChildren(category, categories)))
				.sorted(Comparator.comparingInt(m -> (m.getSort() == null ? 0 : m.getSort()))).toList();
	}
}