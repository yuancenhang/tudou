
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouproduct.service.CategoryService;
import com.hang.tudou.tudouproduct.entity.Category;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	/**
	 * 获取所有,树形分层
	 * @return
	 */
	@GetMapping("/getAll")
	public R<List<Category>> getAll(){
		List<Category> list = categoryService.getAll();
		System.out.println("查到的数据:-----------" + list);
		return list.isEmpty() ? R.error("还没有数据") : R.success(list);
	}

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody Category category){
		boolean ok = categoryService.save(category);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody Category category){
		boolean ok = categoryService.removeById(category);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody Category category){
		LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(category.getCatId() != null,Category::getCatId,category.getCatId());
		boolean ok = categoryService.update(category,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<Category> getById(@RequestBody Category category){
		category = categoryService.getById(category.getCatId());
		return category != null ? R.success(category) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<Category>> page(@RequestBody Category category){
		IPage<Category> iPage = new Page<>(category.getPage(), category.getPageSize());
		LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(category.getCatId() != null,Category::getCatId,category.getCatId());
		wrapper.eq(category.getName() != null,Category::getName,category.getName());
		wrapper.eq(category.getParentCid() != null,Category::getParentCid,category.getParentCid());
		wrapper.eq(category.getCatLevel() != null,Category::getCatLevel,category.getCatLevel());
		wrapper.eq(category.getShowStatus() != null,Category::getShowStatus,category.getShowStatus());
		wrapper.eq(category.getSort() != null,Category::getSort,category.getSort());
		wrapper.eq(category.getIcon() != null,Category::getIcon,category.getIcon());
		wrapper.eq(category.getProductUnit() != null,Category::getProductUnit,category.getProductUnit());
		wrapper.eq(category.getProductCount() != null,Category::getProductCount,category.getProductCount());

		categoryService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
