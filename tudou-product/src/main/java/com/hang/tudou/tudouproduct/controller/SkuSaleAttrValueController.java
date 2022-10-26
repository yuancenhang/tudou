
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouproduct.service.SkuSaleAttrValueService;
import com.hang.tudou.tudouproduct.entity.SkuSaleAttrValue;

@RestController
@RequestMapping("/skuSaleAttrValue")
public class SkuSaleAttrValueController {

	@Autowired
	SkuSaleAttrValueService skuSaleAttrValueService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SkuSaleAttrValue skuSaleAttrValue){
		boolean ok = skuSaleAttrValueService.save(skuSaleAttrValue);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SkuSaleAttrValue skuSaleAttrValue){
		boolean ok = skuSaleAttrValueService.removeById(skuSaleAttrValue);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SkuSaleAttrValue skuSaleAttrValue){
		LambdaQueryWrapper<SkuSaleAttrValue> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuSaleAttrValue.getId() != null,SkuSaleAttrValue::getId,skuSaleAttrValue.getId());
		boolean ok = skuSaleAttrValueService.update(skuSaleAttrValue,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SkuSaleAttrValue> getById(@RequestBody SkuSaleAttrValue skuSaleAttrValue){
		skuSaleAttrValue = skuSaleAttrValueService.getById(skuSaleAttrValue.getId());
		return skuSaleAttrValue != null ? R.success(skuSaleAttrValue) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SkuSaleAttrValue>> page(@RequestBody SkuSaleAttrValue skuSaleAttrValue){
		IPage<SkuSaleAttrValue> iPage = new Page<>(skuSaleAttrValue.getPage(), skuSaleAttrValue.getPageSize());
		LambdaQueryWrapper<SkuSaleAttrValue> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuSaleAttrValue.getId() != null,SkuSaleAttrValue::getId,skuSaleAttrValue.getId());
		wrapper.eq(skuSaleAttrValue.getSkuId() != null,SkuSaleAttrValue::getSkuId,skuSaleAttrValue.getSkuId());
		wrapper.eq(skuSaleAttrValue.getAttrId() != null,SkuSaleAttrValue::getAttrId,skuSaleAttrValue.getAttrId());
		wrapper.eq(skuSaleAttrValue.getAttrName() != null,SkuSaleAttrValue::getAttrName,skuSaleAttrValue.getAttrName());
		wrapper.eq(skuSaleAttrValue.getAttrValue() != null,SkuSaleAttrValue::getAttrValue,skuSaleAttrValue.getAttrValue());
		wrapper.eq(skuSaleAttrValue.getAttrSort() != null,SkuSaleAttrValue::getAttrSort,skuSaleAttrValue.getAttrSort());

		skuSaleAttrValueService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
