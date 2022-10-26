
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouproduct.service.ProductAttrValueService;
import com.hang.tudou.tudouproduct.entity.ProductAttrValue;

@RestController
@RequestMapping("/productAttrValue")
public class ProductAttrValueController {

	@Autowired
	ProductAttrValueService productAttrValueService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody ProductAttrValue productAttrValue){
		boolean ok = productAttrValueService.save(productAttrValue);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody ProductAttrValue productAttrValue){
		boolean ok = productAttrValueService.removeById(productAttrValue);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody ProductAttrValue productAttrValue){
		LambdaQueryWrapper<ProductAttrValue> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(productAttrValue.getId() != null,ProductAttrValue::getId,productAttrValue.getId());
		boolean ok = productAttrValueService.update(productAttrValue,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<ProductAttrValue> getById(@RequestBody ProductAttrValue productAttrValue){
		productAttrValue = productAttrValueService.getById(productAttrValue.getId());
		return productAttrValue != null ? R.success(productAttrValue) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<ProductAttrValue>> page(@RequestBody ProductAttrValue productAttrValue){
		IPage<ProductAttrValue> iPage = new Page<>(productAttrValue.getPage(), productAttrValue.getPageSize());
		LambdaQueryWrapper<ProductAttrValue> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(productAttrValue.getId() != null,ProductAttrValue::getId,productAttrValue.getId());
		wrapper.eq(productAttrValue.getSpuId() != null,ProductAttrValue::getSpuId,productAttrValue.getSpuId());
		wrapper.eq(productAttrValue.getAttrId() != null,ProductAttrValue::getAttrId,productAttrValue.getAttrId());
		wrapper.eq(productAttrValue.getAttrName() != null,ProductAttrValue::getAttrName,productAttrValue.getAttrName());
		wrapper.eq(productAttrValue.getAttrValue() != null,ProductAttrValue::getAttrValue,productAttrValue.getAttrValue());
		wrapper.eq(productAttrValue.getAttrSort() != null,ProductAttrValue::getAttrSort,productAttrValue.getAttrSort());
		wrapper.eq(productAttrValue.getQuickShow() != null,ProductAttrValue::getQuickShow,productAttrValue.getQuickShow());

		productAttrValueService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
