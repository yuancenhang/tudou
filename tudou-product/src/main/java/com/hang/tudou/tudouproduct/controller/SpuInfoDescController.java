
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouproduct.service.SpuInfoDescService;
import com.hang.tudou.tudouproduct.entity.SpuInfoDesc;

@RestController
@RequestMapping("/spuInfoDesc")
public class SpuInfoDescController {

	@Autowired
	SpuInfoDescService spuInfoDescService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SpuInfoDesc spuInfoDesc){
		boolean ok = spuInfoDescService.save(spuInfoDesc);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SpuInfoDesc spuInfoDesc){
		boolean ok = spuInfoDescService.removeById(spuInfoDesc);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SpuInfoDesc spuInfoDesc){
		LambdaQueryWrapper<SpuInfoDesc> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuInfoDesc.getSpuId() != null,SpuInfoDesc::getSpuId,spuInfoDesc.getSpuId());
		boolean ok = spuInfoDescService.update(spuInfoDesc,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SpuInfoDesc> getById(@RequestBody SpuInfoDesc spuInfoDesc){
		spuInfoDesc = spuInfoDescService.getById(spuInfoDesc.getSpuId());
		return spuInfoDesc != null ? R.success(spuInfoDesc) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SpuInfoDesc>> page(@RequestBody SpuInfoDesc spuInfoDesc){
		IPage<SpuInfoDesc> iPage = new Page<>(spuInfoDesc.getPage(), spuInfoDesc.getPageSize());
		LambdaQueryWrapper<SpuInfoDesc> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuInfoDesc.getSpuId() != null,SpuInfoDesc::getSpuId,spuInfoDesc.getSpuId());
		wrapper.eq(spuInfoDesc.getDecript() != null,SpuInfoDesc::getDecript,spuInfoDesc.getDecript());

		spuInfoDescService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
