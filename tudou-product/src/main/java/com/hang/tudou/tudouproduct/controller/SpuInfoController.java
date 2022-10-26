
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouproduct.service.SpuInfoService;
import com.hang.tudou.tudouproduct.entity.SpuInfo;

@RestController
@RequestMapping("/spuInfo")
public class SpuInfoController {

	@Autowired
	SpuInfoService spuInfoService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SpuInfo spuInfo){
		boolean ok = spuInfoService.save(spuInfo);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SpuInfo spuInfo){
		boolean ok = spuInfoService.removeById(spuInfo);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SpuInfo spuInfo){
		LambdaQueryWrapper<SpuInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuInfo.getId() != null,SpuInfo::getId,spuInfo.getId());
		boolean ok = spuInfoService.update(spuInfo,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SpuInfo> getById(@RequestBody SpuInfo spuInfo){
		spuInfo = spuInfoService.getById(spuInfo.getId());
		return spuInfo != null ? R.success(spuInfo) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SpuInfo>> page(@RequestBody SpuInfo spuInfo){
		IPage<SpuInfo> iPage = new Page<>(spuInfo.getPage(), spuInfo.getPageSize());
		LambdaQueryWrapper<SpuInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuInfo.getId() != null,SpuInfo::getId,spuInfo.getId());
		wrapper.eq(spuInfo.getSpuName() != null,SpuInfo::getSpuName,spuInfo.getSpuName());
		wrapper.eq(spuInfo.getSpuDescription() != null,SpuInfo::getSpuDescription,spuInfo.getSpuDescription());
		wrapper.eq(spuInfo.getCatalogId() != null,SpuInfo::getCatalogId,spuInfo.getCatalogId());
		wrapper.eq(spuInfo.getBrandId() != null,SpuInfo::getBrandId,spuInfo.getBrandId());
		wrapper.eq(spuInfo.getWeight() != null,SpuInfo::getWeight,spuInfo.getWeight());
		wrapper.eq(spuInfo.getPublishStatus() != null,SpuInfo::getPublishStatus,spuInfo.getPublishStatus());
		wrapper.eq(spuInfo.getCreateTime() != null,SpuInfo::getCreateTime,spuInfo.getCreateTime());
		wrapper.eq(spuInfo.getUpdateTime() != null,SpuInfo::getUpdateTime,spuInfo.getUpdateTime());

		spuInfoService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
