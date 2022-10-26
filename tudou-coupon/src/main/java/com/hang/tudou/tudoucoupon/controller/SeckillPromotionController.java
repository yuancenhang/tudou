
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.SeckillPromotionService;
import com.hang.tudou.tudoucoupon.entity.SeckillPromotion;

@RestController
@RequestMapping("/seckillPromotion")
public class SeckillPromotionController {

	@Autowired
	SeckillPromotionService seckillPromotionService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SeckillPromotion seckillPromotion){
		boolean ok = seckillPromotionService.save(seckillPromotion);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SeckillPromotion seckillPromotion){
		boolean ok = seckillPromotionService.removeById(seckillPromotion);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SeckillPromotion seckillPromotion){
		LambdaQueryWrapper<SeckillPromotion> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(seckillPromotion.getId() != null,SeckillPromotion::getId,seckillPromotion.getId());
		boolean ok = seckillPromotionService.update(seckillPromotion,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SeckillPromotion> getById(@RequestBody SeckillPromotion seckillPromotion){
		seckillPromotion = seckillPromotionService.getById(seckillPromotion.getId());
		return seckillPromotion != null ? R.success(seckillPromotion) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SeckillPromotion>> page(@RequestBody SeckillPromotion seckillPromotion){
		IPage<SeckillPromotion> iPage = new Page<>(seckillPromotion.getPage(), seckillPromotion.getPageSize());
		LambdaQueryWrapper<SeckillPromotion> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(seckillPromotion.getId() != null,SeckillPromotion::getId,seckillPromotion.getId());
		wrapper.eq(seckillPromotion.getTitle() != null,SeckillPromotion::getTitle,seckillPromotion.getTitle());
		wrapper.eq(seckillPromotion.getStartTime() != null,SeckillPromotion::getStartTime,seckillPromotion.getStartTime());
		wrapper.eq(seckillPromotion.getEndTime() != null,SeckillPromotion::getEndTime,seckillPromotion.getEndTime());
		wrapper.eq(seckillPromotion.getStatus() != null,SeckillPromotion::getStatus,seckillPromotion.getStatus());
		wrapper.eq(seckillPromotion.getCreateTime() != null,SeckillPromotion::getCreateTime,seckillPromotion.getCreateTime());
		wrapper.eq(seckillPromotion.getUserId() != null,SeckillPromotion::getUserId,seckillPromotion.getUserId());

		seckillPromotionService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
