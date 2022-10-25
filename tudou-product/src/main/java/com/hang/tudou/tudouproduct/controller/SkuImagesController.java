
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouproduct.entity.R;
import com.hang.tudou.tudouproduct.service.SkuImagesService;
import com.hang.tudou.tudouproduct.entity.SkuImages;

@RestController
@RequestMapping("/skuImages")
public class SkuImagesController {

	@Autowired
	SkuImagesService skuImagesService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SkuImages skuImages){
		boolean ok = skuImagesService.save(skuImages);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SkuImages skuImages){
		boolean ok = skuImagesService.removeById(skuImages);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SkuImages skuImages){
		LambdaQueryWrapper<SkuImages> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuImages.getId() != null,SkuImages::getId,skuImages.getId());
		boolean ok = skuImagesService.update(skuImages,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SkuImages> getById(@RequestBody SkuImages skuImages){
		skuImages = skuImagesService.getById(skuImages.getId());
		return skuImages != null ? R.success(skuImages) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SkuImages>> page(@RequestBody SkuImages skuImages){
		IPage<SkuImages> iPage = new Page<>(skuImages.getPage(), skuImages.getPageSize());
		LambdaQueryWrapper<SkuImages> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuImages.getId() != null,SkuImages::getId,skuImages.getId());
		wrapper.eq(skuImages.getSkuId() != null,SkuImages::getSkuId,skuImages.getSkuId());
		wrapper.eq(skuImages.getImgUrl() != null,SkuImages::getImgUrl,skuImages.getImgUrl());
		wrapper.eq(skuImages.getImgSort() != null,SkuImages::getImgSort,skuImages.getImgSort());
		wrapper.eq(skuImages.getDefaultImg() != null,SkuImages::getDefaultImg,skuImages.getDefaultImg());

		skuImagesService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
