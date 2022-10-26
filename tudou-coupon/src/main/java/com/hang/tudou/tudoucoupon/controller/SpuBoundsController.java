
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.SpuBoundsService;
import com.hang.tudou.tudoucoupon.entity.SpuBounds;

@RestController
@RequestMapping("/spuBounds")
public class SpuBoundsController {

	@Autowired
	SpuBoundsService spuBoundsService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SpuBounds spuBounds){
		boolean ok = spuBoundsService.save(spuBounds);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SpuBounds spuBounds){
		boolean ok = spuBoundsService.removeById(spuBounds);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SpuBounds spuBounds){
		LambdaQueryWrapper<SpuBounds> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuBounds.getId() != null,SpuBounds::getId,spuBounds.getId());
		boolean ok = spuBoundsService.update(spuBounds,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SpuBounds> getById(@RequestBody SpuBounds spuBounds){
		spuBounds = spuBoundsService.getById(spuBounds.getId());
		return spuBounds != null ? R.success(spuBounds) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SpuBounds>> page(@RequestBody SpuBounds spuBounds){
		IPage<SpuBounds> iPage = new Page<>(spuBounds.getPage(), spuBounds.getPageSize());
		LambdaQueryWrapper<SpuBounds> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuBounds.getId() != null,SpuBounds::getId,spuBounds.getId());
		wrapper.eq(spuBounds.getSpuId() != null,SpuBounds::getSpuId,spuBounds.getSpuId());
		wrapper.eq(spuBounds.getGrowBounds() != null,SpuBounds::getGrowBounds,spuBounds.getGrowBounds());
		wrapper.eq(spuBounds.getBuyBounds() != null,SpuBounds::getBuyBounds,spuBounds.getBuyBounds());
		wrapper.eq(spuBounds.getWork() != null,SpuBounds::getWork,spuBounds.getWork());

		spuBoundsService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
