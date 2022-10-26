
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.HomeSubjectSpuService;
import com.hang.tudou.tudoucoupon.entity.HomeSubjectSpu;

@RestController
@RequestMapping("/homeSubjectSpu")
public class HomeSubjectSpuController {

	@Autowired
	HomeSubjectSpuService homeSubjectSpuService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody HomeSubjectSpu homeSubjectSpu){
		boolean ok = homeSubjectSpuService.save(homeSubjectSpu);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody HomeSubjectSpu homeSubjectSpu){
		boolean ok = homeSubjectSpuService.removeById(homeSubjectSpu);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody HomeSubjectSpu homeSubjectSpu){
		LambdaQueryWrapper<HomeSubjectSpu> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(homeSubjectSpu.getId() != null,HomeSubjectSpu::getId,homeSubjectSpu.getId());
		boolean ok = homeSubjectSpuService.update(homeSubjectSpu,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<HomeSubjectSpu> getById(@RequestBody HomeSubjectSpu homeSubjectSpu){
		homeSubjectSpu = homeSubjectSpuService.getById(homeSubjectSpu.getId());
		return homeSubjectSpu != null ? R.success(homeSubjectSpu) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<HomeSubjectSpu>> page(@RequestBody HomeSubjectSpu homeSubjectSpu){
		IPage<HomeSubjectSpu> iPage = new Page<>(homeSubjectSpu.getPage(), homeSubjectSpu.getPageSize());
		LambdaQueryWrapper<HomeSubjectSpu> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(homeSubjectSpu.getId() != null,HomeSubjectSpu::getId,homeSubjectSpu.getId());
		wrapper.eq(homeSubjectSpu.getName() != null,HomeSubjectSpu::getName,homeSubjectSpu.getName());
		wrapper.eq(homeSubjectSpu.getSubjectId() != null,HomeSubjectSpu::getSubjectId,homeSubjectSpu.getSubjectId());
		wrapper.eq(homeSubjectSpu.getSpuId() != null,HomeSubjectSpu::getSpuId,homeSubjectSpu.getSpuId());
		wrapper.eq(homeSubjectSpu.getSort() != null,HomeSubjectSpu::getSort,homeSubjectSpu.getSort());

		homeSubjectSpuService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
