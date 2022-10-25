
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouproduct.entity.R;
import com.hang.tudou.tudouproduct.service.SpuImagesService;
import com.hang.tudou.tudouproduct.entity.SpuImages;

@RestController
@RequestMapping("/spuImages")
public class SpuImagesController {

	@Autowired
	SpuImagesService spuImagesService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SpuImages spuImages){
		boolean ok = spuImagesService.save(spuImages);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SpuImages spuImages){
		boolean ok = spuImagesService.removeById(spuImages);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SpuImages spuImages){
		LambdaQueryWrapper<SpuImages> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuImages.getId() != null,SpuImages::getId,spuImages.getId());
		boolean ok = spuImagesService.update(spuImages,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SpuImages> getById(@RequestBody SpuImages spuImages){
		spuImages = spuImagesService.getById(spuImages.getId());
		return spuImages != null ? R.success(spuImages) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SpuImages>> page(@RequestBody SpuImages spuImages){
		IPage<SpuImages> iPage = new Page<>(spuImages.getPage(), spuImages.getPageSize());
		LambdaQueryWrapper<SpuImages> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuImages.getId() != null,SpuImages::getId,spuImages.getId());
		wrapper.eq(spuImages.getSpuId() != null,SpuImages::getSpuId,spuImages.getSpuId());
		wrapper.eq(spuImages.getImgName() != null,SpuImages::getImgName,spuImages.getImgName());
		wrapper.eq(spuImages.getImgUrl() != null,SpuImages::getImgUrl,spuImages.getImgUrl());
		wrapper.eq(spuImages.getImgSort() != null,SpuImages::getImgSort,spuImages.getImgSort());
		wrapper.eq(spuImages.getDefaultImg() != null,SpuImages::getDefaultImg,spuImages.getDefaultImg());

		spuImagesService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
