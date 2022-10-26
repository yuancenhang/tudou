
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.CouponSpuRelationService;
import com.hang.tudou.tudoucoupon.entity.CouponSpuRelation;

@RestController
@RequestMapping("/couponSpuRelation")
public class CouponSpuRelationController {

	@Autowired
	CouponSpuRelationService couponSpuRelationService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody CouponSpuRelation couponSpuRelation){
		boolean ok = couponSpuRelationService.save(couponSpuRelation);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody CouponSpuRelation couponSpuRelation){
		boolean ok = couponSpuRelationService.removeById(couponSpuRelation);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody CouponSpuRelation couponSpuRelation){
		LambdaQueryWrapper<CouponSpuRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(couponSpuRelation.getId() != null,CouponSpuRelation::getId,couponSpuRelation.getId());
		boolean ok = couponSpuRelationService.update(couponSpuRelation,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<CouponSpuRelation> getById(@RequestBody CouponSpuRelation couponSpuRelation){
		couponSpuRelation = couponSpuRelationService.getById(couponSpuRelation.getId());
		return couponSpuRelation != null ? R.success(couponSpuRelation) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<CouponSpuRelation>> page(@RequestBody CouponSpuRelation couponSpuRelation){
		IPage<CouponSpuRelation> iPage = new Page<>(couponSpuRelation.getPage(), couponSpuRelation.getPageSize());
		LambdaQueryWrapper<CouponSpuRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(couponSpuRelation.getId() != null,CouponSpuRelation::getId,couponSpuRelation.getId());
		wrapper.eq(couponSpuRelation.getCouponId() != null,CouponSpuRelation::getCouponId,couponSpuRelation.getCouponId());
		wrapper.eq(couponSpuRelation.getSpuId() != null,CouponSpuRelation::getSpuId,couponSpuRelation.getSpuId());
		wrapper.eq(couponSpuRelation.getSpuName() != null,CouponSpuRelation::getSpuName,couponSpuRelation.getSpuName());

		couponSpuRelationService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
