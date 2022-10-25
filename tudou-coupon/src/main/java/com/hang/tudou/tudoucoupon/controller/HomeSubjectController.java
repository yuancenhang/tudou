
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudoucoupon.entity.R;
import com.hang.tudou.tudoucoupon.service.HomeSubjectService;
import com.hang.tudou.tudoucoupon.entity.HomeSubject;

@RestController
@RequestMapping("/homeSubject")
public class HomeSubjectController {

	@Autowired
	HomeSubjectService homeSubjectService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody HomeSubject homeSubject){
		boolean ok = homeSubjectService.save(homeSubject);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody HomeSubject homeSubject){
		boolean ok = homeSubjectService.removeById(homeSubject);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody HomeSubject homeSubject){
		LambdaQueryWrapper<HomeSubject> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(homeSubject.getId() != null,HomeSubject::getId,homeSubject.getId());
		boolean ok = homeSubjectService.update(homeSubject,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<HomeSubject> getById(@RequestBody HomeSubject homeSubject){
		homeSubject = homeSubjectService.getById(homeSubject.getId());
		return homeSubject != null ? R.success(homeSubject) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<HomeSubject>> page(@RequestBody HomeSubject homeSubject){
		IPage<HomeSubject> iPage = new Page<>(homeSubject.getPage(), homeSubject.getPageSize());
		LambdaQueryWrapper<HomeSubject> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(homeSubject.getId() != null,HomeSubject::getId,homeSubject.getId());
		wrapper.eq(homeSubject.getName() != null,HomeSubject::getName,homeSubject.getName());
		wrapper.eq(homeSubject.getTitle() != null,HomeSubject::getTitle,homeSubject.getTitle());
		wrapper.eq(homeSubject.getSubTitle() != null,HomeSubject::getSubTitle,homeSubject.getSubTitle());
		wrapper.eq(homeSubject.getStatus() != null,HomeSubject::getStatus,homeSubject.getStatus());
		wrapper.eq(homeSubject.getUrl() != null,HomeSubject::getUrl,homeSubject.getUrl());
		wrapper.eq(homeSubject.getSort() != null,HomeSubject::getSort,homeSubject.getSort());
		wrapper.eq(homeSubject.getImg() != null,HomeSubject::getImg,homeSubject.getImg());

		homeSubjectService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
