
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.Category;
import com.hang.tudou.tudouproduct.mapper.CategoryMapper;
import com.hang.tudou.tudouproduct.service.CategoryService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {

	@Autowired
	CategoryMapper categoryMapper;

	@Override
	public List<Category> getAll() {
		List<Category> categories = categoryMapper.selectList(null);

		//filter是过滤
		return categories.stream().filter(category ->
				//满足这个条件的对象会留下来,生成一个新流,parentCid==0,表示第一级菜单
				category.getParentCid() == 0
		//peek表示对流里的每个对象进行一些操作
		).peek((menu) ->
				//对每个一级菜单设置它的子菜单
				menu.setChildren(getChildren(menu, categories)
				)
		//sorted表示排序,getSort()是获取实体类的变量,值来自数据库
		).sorted(Comparator.comparingInt(Category::getSort)).toList();
	}

	//封装的一个递归方法,能不断的找出层层包含的对象
	private List<Category> getChildren(Category menu, List<Category> categories) {
		return categories.stream().filter(category ->
			//获取parentCid等于传入对象的catId的对象
			category.getParentCid() == menu.getCatId()
		//把这些对象传入本方法,再次获取
		).peek(category -> {
			category.setChildren(getChildren(category,categories));
		}).sorted(Comparator.comparingInt(Category::getSort)).toList();
	}
}