
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouproduct.entity.R;
import com.hang.tudou.tudouproduct.service.CategoryBrandRelationService;
import com.hang.tudou.tudouproduct.entity.CategoryBrandRelation;

@RestController
@RequestMapping("/categoryBrandRelation")
public class CategoryBrandRelationController {

	@Autowired
	CategoryBrandRelationService categoryBrandRelationService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody CategoryBrandRelation categoryBrandRelation){
		boolean ok = categoryBrandRelationService.save(categoryBrandRelation);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody CategoryBrandRelation categoryBrandRelation){
		boolean ok = categoryBrandRelationService.removeById(categoryBrandRelation);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody CategoryBrandRelation categoryBrandRelation){
		LambdaQueryWrapper<CategoryBrandRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(categoryBrandRelation.getId() != null,CategoryBrandRelation::getId,categoryBrandRelation.getId());
		boolean ok = categoryBrandRelationService.update(categoryBrandRelation,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<CategoryBrandRelation> getById(@RequestBody CategoryBrandRelation categoryBrandRelation){
		categoryBrandRelation = categoryBrandRelationService.getById(categoryBrandRelation.getId());
		return categoryBrandRelation != null ? R.success(categoryBrandRelation) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<CategoryBrandRelation>> page(@RequestBody CategoryBrandRelation categoryBrandRelation){
		IPage<CategoryBrandRelation> iPage = new Page<>(categoryBrandRelation.getPage(), categoryBrandRelation.getPageSize());
		LambdaQueryWrapper<CategoryBrandRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(categoryBrandRelation.getId() != null,CategoryBrandRelation::getId,categoryBrandRelation.getId());
		wrapper.eq(categoryBrandRelation.getBrandId() != null,CategoryBrandRelation::getBrandId,categoryBrandRelation.getBrandId());
		wrapper.eq(categoryBrandRelation.getCatelogId() != null,CategoryBrandRelation::getCatelogId,categoryBrandRelation.getCatelogId());
		wrapper.eq(categoryBrandRelation.getBrandName() != null,CategoryBrandRelation::getBrandName,categoryBrandRelation.getBrandName());
		wrapper.eq(categoryBrandRelation.getCatelogName() != null,CategoryBrandRelation::getCatelogName,categoryBrandRelation.getCatelogName());

		categoryBrandRelationService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
