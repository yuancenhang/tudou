
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouproduct.service.BrandService;
import com.hang.tudou.tudouproduct.entity.Brand;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	BrandService brandService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody Brand brand){
		boolean ok = brandService.save(brand);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody Brand brand){
		boolean ok = brandService.removeById(brand);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody Brand brand){
		LambdaQueryWrapper<Brand> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(brand.getBrandId() != null,Brand::getBrandId,brand.getBrandId());
		boolean ok = brandService.update(brand,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<Brand> getById(@RequestBody Brand brand){
		brand = brandService.getById(brand.getBrandId());
		return brand != null ? R.success(brand) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<Brand>> page(@RequestBody Brand brand){
		IPage<Brand> iPage = new Page<>(brand.getPage(), brand.getPageSize());
		LambdaQueryWrapper<Brand> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(brand.getBrandId() != null,Brand::getBrandId,brand.getBrandId());
		wrapper.eq(brand.getName() != null,Brand::getName,brand.getName());
		wrapper.eq(brand.getLogo() != null,Brand::getLogo,brand.getLogo());
		wrapper.eq(brand.getDescript() != null,Brand::getDescript,brand.getDescript());
		wrapper.eq(brand.getShowStatus() != null,Brand::getShowStatus,brand.getShowStatus());
		wrapper.eq(brand.getFirstLetter() != null,Brand::getFirstLetter,brand.getFirstLetter());
		wrapper.eq(brand.getSort() != null,Brand::getSort,brand.getSort());

		brandService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
