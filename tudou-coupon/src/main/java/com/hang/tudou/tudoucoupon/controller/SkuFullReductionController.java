
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.SkuFullReductionService;
import com.hang.tudou.tudoucoupon.entity.SkuFullReduction;

@RestController
@RequestMapping("/skuFullReduction")
public class SkuFullReductionController {

	@Autowired
	SkuFullReductionService skuFullReductionService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SkuFullReduction skuFullReduction){
		boolean ok = skuFullReductionService.save(skuFullReduction);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SkuFullReduction skuFullReduction){
		boolean ok = skuFullReductionService.removeById(skuFullReduction);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SkuFullReduction skuFullReduction){
		LambdaQueryWrapper<SkuFullReduction> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuFullReduction.getId() != null,SkuFullReduction::getId,skuFullReduction.getId());
		boolean ok = skuFullReductionService.update(skuFullReduction,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SkuFullReduction> getById(@RequestBody SkuFullReduction skuFullReduction){
		skuFullReduction = skuFullReductionService.getById(skuFullReduction.getId());
		return skuFullReduction != null ? R.success(skuFullReduction) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SkuFullReduction>> page(@RequestBody SkuFullReduction skuFullReduction){
		IPage<SkuFullReduction> iPage = new Page<>(skuFullReduction.getPage(), skuFullReduction.getPageSize());
		LambdaQueryWrapper<SkuFullReduction> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuFullReduction.getId() != null,SkuFullReduction::getId,skuFullReduction.getId());
		wrapper.eq(skuFullReduction.getSkuId() != null,SkuFullReduction::getSkuId,skuFullReduction.getSkuId());
		wrapper.eq(skuFullReduction.getFullPrice() != null,SkuFullReduction::getFullPrice,skuFullReduction.getFullPrice());
		wrapper.eq(skuFullReduction.getReducePrice() != null,SkuFullReduction::getReducePrice,skuFullReduction.getReducePrice());
		wrapper.eq(skuFullReduction.getAddOther() != null,SkuFullReduction::getAddOther,skuFullReduction.getAddOther());

		skuFullReductionService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
