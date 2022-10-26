
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.CouponSpuCategoryRelationService;
import com.hang.tudou.tudoucoupon.entity.CouponSpuCategoryRelation;

@RestController
@RequestMapping("/couponSpuCategoryRelation")
public class CouponSpuCategoryRelationController {

	@Autowired
	CouponSpuCategoryRelationService couponSpuCategoryRelationService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation){
		boolean ok = couponSpuCategoryRelationService.save(couponSpuCategoryRelation);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation){
		boolean ok = couponSpuCategoryRelationService.removeById(couponSpuCategoryRelation);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation){
		LambdaQueryWrapper<CouponSpuCategoryRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(couponSpuCategoryRelation.getId() != null,CouponSpuCategoryRelation::getId,couponSpuCategoryRelation.getId());
		boolean ok = couponSpuCategoryRelationService.update(couponSpuCategoryRelation,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<CouponSpuCategoryRelation> getById(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation){
		couponSpuCategoryRelation = couponSpuCategoryRelationService.getById(couponSpuCategoryRelation.getId());
		return couponSpuCategoryRelation != null ? R.success(couponSpuCategoryRelation) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<CouponSpuCategoryRelation>> page(@RequestBody CouponSpuCategoryRelation couponSpuCategoryRelation){
		IPage<CouponSpuCategoryRelation> iPage = new Page<>(couponSpuCategoryRelation.getPage(), couponSpuCategoryRelation.getPageSize());
		LambdaQueryWrapper<CouponSpuCategoryRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(couponSpuCategoryRelation.getId() != null,CouponSpuCategoryRelation::getId,couponSpuCategoryRelation.getId());
		wrapper.eq(couponSpuCategoryRelation.getCouponId() != null,CouponSpuCategoryRelation::getCouponId,couponSpuCategoryRelation.getCouponId());
		wrapper.eq(couponSpuCategoryRelation.getCategoryId() != null,CouponSpuCategoryRelation::getCategoryId,couponSpuCategoryRelation.getCategoryId());
		wrapper.eq(couponSpuCategoryRelation.getCategoryName() != null,CouponSpuCategoryRelation::getCategoryName,couponSpuCategoryRelation.getCategoryName());

		couponSpuCategoryRelationService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
