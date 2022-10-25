
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudoucoupon.entity.R;
import com.hang.tudou.tudoucoupon.service.SeckillSkuRelationService;
import com.hang.tudou.tudoucoupon.entity.SeckillSkuRelation;

@RestController
@RequestMapping("/seckillSkuRelation")
public class SeckillSkuRelationController {

	@Autowired
	SeckillSkuRelationService seckillSkuRelationService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SeckillSkuRelation seckillSkuRelation){
		boolean ok = seckillSkuRelationService.save(seckillSkuRelation);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SeckillSkuRelation seckillSkuRelation){
		boolean ok = seckillSkuRelationService.removeById(seckillSkuRelation);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SeckillSkuRelation seckillSkuRelation){
		LambdaQueryWrapper<SeckillSkuRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(seckillSkuRelation.getId() != null,SeckillSkuRelation::getId,seckillSkuRelation.getId());
		boolean ok = seckillSkuRelationService.update(seckillSkuRelation,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SeckillSkuRelation> getById(@RequestBody SeckillSkuRelation seckillSkuRelation){
		seckillSkuRelation = seckillSkuRelationService.getById(seckillSkuRelation.getId());
		return seckillSkuRelation != null ? R.success(seckillSkuRelation) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SeckillSkuRelation>> page(@RequestBody SeckillSkuRelation seckillSkuRelation){
		IPage<SeckillSkuRelation> iPage = new Page<>(seckillSkuRelation.getPage(), seckillSkuRelation.getPageSize());
		LambdaQueryWrapper<SeckillSkuRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(seckillSkuRelation.getId() != null,SeckillSkuRelation::getId,seckillSkuRelation.getId());
		wrapper.eq(seckillSkuRelation.getPromotionId() != null,SeckillSkuRelation::getPromotionId,seckillSkuRelation.getPromotionId());
		wrapper.eq(seckillSkuRelation.getPromotionSessionId() != null,SeckillSkuRelation::getPromotionSessionId,seckillSkuRelation.getPromotionSessionId());
		wrapper.eq(seckillSkuRelation.getSkuId() != null,SeckillSkuRelation::getSkuId,seckillSkuRelation.getSkuId());
		wrapper.eq(seckillSkuRelation.getSeckillPrice() != null,SeckillSkuRelation::getSeckillPrice,seckillSkuRelation.getSeckillPrice());
		wrapper.eq(seckillSkuRelation.getSeckillCount() != null,SeckillSkuRelation::getSeckillCount,seckillSkuRelation.getSeckillCount());
		wrapper.eq(seckillSkuRelation.getSeckillLimit() != null,SeckillSkuRelation::getSeckillLimit,seckillSkuRelation.getSeckillLimit());
		wrapper.eq(seckillSkuRelation.getSeckillSort() != null,SeckillSkuRelation::getSeckillSort,seckillSkuRelation.getSeckillSort());

		seckillSkuRelationService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
