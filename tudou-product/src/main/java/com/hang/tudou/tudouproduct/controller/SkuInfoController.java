
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouproduct.service.SkuInfoService;
import com.hang.tudou.tudouproduct.entity.SkuInfo;

@RestController
@RequestMapping("/skuInfo")
public class SkuInfoController {

	@Autowired
	SkuInfoService skuInfoService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SkuInfo skuInfo){
		boolean ok = skuInfoService.save(skuInfo);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SkuInfo skuInfo){
		boolean ok = skuInfoService.removeById(skuInfo);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SkuInfo skuInfo){
		LambdaQueryWrapper<SkuInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuInfo.getSkuId() != null,SkuInfo::getSkuId,skuInfo.getSkuId());
		boolean ok = skuInfoService.update(skuInfo,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SkuInfo> getById(@RequestBody SkuInfo skuInfo){
		skuInfo = skuInfoService.getById(skuInfo.getSkuId());
		return skuInfo != null ? R.success(skuInfo) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SkuInfo>> page(@RequestBody SkuInfo skuInfo){
		IPage<SkuInfo> iPage = new Page<>(skuInfo.getPage(), skuInfo.getPageSize());
		LambdaQueryWrapper<SkuInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuInfo.getSkuId() != null,SkuInfo::getSkuId,skuInfo.getSkuId());
		wrapper.eq(skuInfo.getSpuId() != null,SkuInfo::getSpuId,skuInfo.getSpuId());
		wrapper.eq(skuInfo.getSkuName() != null,SkuInfo::getSkuName,skuInfo.getSkuName());
		wrapper.eq(skuInfo.getSkuDesc() != null,SkuInfo::getSkuDesc,skuInfo.getSkuDesc());
		wrapper.eq(skuInfo.getCatalogId() != null,SkuInfo::getCatalogId,skuInfo.getCatalogId());
		wrapper.eq(skuInfo.getBrandId() != null,SkuInfo::getBrandId,skuInfo.getBrandId());
		wrapper.eq(skuInfo.getSkuDefaultImg() != null,SkuInfo::getSkuDefaultImg,skuInfo.getSkuDefaultImg());
		wrapper.eq(skuInfo.getSkuTitle() != null,SkuInfo::getSkuTitle,skuInfo.getSkuTitle());
		wrapper.eq(skuInfo.getSkuSubtitle() != null,SkuInfo::getSkuSubtitle,skuInfo.getSkuSubtitle());
		wrapper.eq(skuInfo.getPrice() != null,SkuInfo::getPrice,skuInfo.getPrice());
		wrapper.eq(skuInfo.getSaleCount() != null,SkuInfo::getSaleCount,skuInfo.getSaleCount());

		skuInfoService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
