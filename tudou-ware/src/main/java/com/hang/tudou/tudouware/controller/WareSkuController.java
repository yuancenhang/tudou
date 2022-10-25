
package com.hang.tudou.tudouware.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouware.entity.R;
import com.hang.tudou.tudouware.service.WareSkuService;
import com.hang.tudou.tudouware.entity.WareSku;

@RestController
@RequestMapping("/wareSku")
public class WareSkuController {

	@Autowired
	WareSkuService wareSkuService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody WareSku wareSku){
		boolean ok = wareSkuService.save(wareSku);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody WareSku wareSku){
		boolean ok = wareSkuService.removeById(wareSku);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody WareSku wareSku){
		LambdaQueryWrapper<WareSku> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(wareSku.getId() != null,WareSku::getId,wareSku.getId());
		boolean ok = wareSkuService.update(wareSku,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<WareSku> getById(@RequestBody WareSku wareSku){
		wareSku = wareSkuService.getById(wareSku.getId());
		return wareSku != null ? R.success(wareSku) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<WareSku>> page(@RequestBody WareSku wareSku){
		IPage<WareSku> iPage = new Page<>(wareSku.getPage(), wareSku.getPageSize());
		LambdaQueryWrapper<WareSku> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(wareSku.getId() != null,WareSku::getId,wareSku.getId());
		wrapper.eq(wareSku.getSkuId() != null,WareSku::getSkuId,wareSku.getSkuId());
		wrapper.eq(wareSku.getWareId() != null,WareSku::getWareId,wareSku.getWareId());
		wrapper.eq(wareSku.getStock() != null,WareSku::getStock,wareSku.getStock());
		wrapper.eq(wareSku.getSkuName() != null,WareSku::getSkuName,wareSku.getSkuName());
		wrapper.eq(wareSku.getStockLocked() != null,WareSku::getStockLocked,wareSku.getStockLocked());

		wareSkuService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
