
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.SkuLadderService;
import com.hang.tudou.tudoucoupon.entity.SkuLadder;

@RestController
@RequestMapping("/skuLadder")
public class SkuLadderController {

	@Autowired
	SkuLadderService skuLadderService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SkuLadder skuLadder){
		boolean ok = skuLadderService.save(skuLadder);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SkuLadder skuLadder){
		boolean ok = skuLadderService.removeById(skuLadder);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SkuLadder skuLadder){
		LambdaQueryWrapper<SkuLadder> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuLadder.getId() != null,SkuLadder::getId,skuLadder.getId());
		boolean ok = skuLadderService.update(skuLadder,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SkuLadder> getById(@RequestBody SkuLadder skuLadder){
		skuLadder = skuLadderService.getById(skuLadder.getId());
		return skuLadder != null ? R.success(skuLadder) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SkuLadder>> page(@RequestBody SkuLadder skuLadder){
		IPage<SkuLadder> iPage = new Page<>(skuLadder.getPage(), skuLadder.getPageSize());
		LambdaQueryWrapper<SkuLadder> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(skuLadder.getId() != null,SkuLadder::getId,skuLadder.getId());
		wrapper.eq(skuLadder.getSkuId() != null,SkuLadder::getSkuId,skuLadder.getSkuId());
		wrapper.eq(skuLadder.getFullCount() != null,SkuLadder::getFullCount,skuLadder.getFullCount());
		wrapper.eq(skuLadder.getDiscount() != null,SkuLadder::getDiscount,skuLadder.getDiscount());
		wrapper.eq(skuLadder.getPrice() != null,SkuLadder::getPrice,skuLadder.getPrice());
		wrapper.eq(skuLadder.getAddOther() != null,SkuLadder::getAddOther,skuLadder.getAddOther());

		skuLadderService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
