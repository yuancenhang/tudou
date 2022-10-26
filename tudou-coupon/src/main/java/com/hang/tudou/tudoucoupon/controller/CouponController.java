
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.CouponService;
import com.hang.tudou.tudoucoupon.entity.Coupon;

@RestController
@RequestMapping("/coupon")
public class CouponController {

	@Autowired
	CouponService couponService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody Coupon coupon){
		boolean ok = couponService.save(coupon);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody Coupon coupon){
		boolean ok = couponService.removeById(coupon);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody Coupon coupon){
		LambdaQueryWrapper<Coupon> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(coupon.getId() != null,Coupon::getId,coupon.getId());
		boolean ok = couponService.update(coupon,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<Coupon> getById(@RequestBody Coupon coupon){
		coupon = couponService.getById(coupon.getId());
		return coupon != null ? R.success(coupon) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<Coupon>> page(@RequestBody Coupon coupon){
		IPage<Coupon> iPage = new Page<>(coupon.getPage(), coupon.getPageSize());
		LambdaQueryWrapper<Coupon> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(coupon.getId() != null,Coupon::getId,coupon.getId());
		wrapper.eq(coupon.getCouponType() != null,Coupon::getCouponType,coupon.getCouponType());
		wrapper.eq(coupon.getCouponImg() != null,Coupon::getCouponImg,coupon.getCouponImg());
		wrapper.eq(coupon.getCouponName() != null,Coupon::getCouponName,coupon.getCouponName());
		wrapper.eq(coupon.getNum() != null,Coupon::getNum,coupon.getNum());
		wrapper.eq(coupon.getAmount() != null,Coupon::getAmount,coupon.getAmount());
		wrapper.eq(coupon.getPerLimit() != null,Coupon::getPerLimit,coupon.getPerLimit());
		wrapper.eq(coupon.getMinPoint() != null,Coupon::getMinPoint,coupon.getMinPoint());
		wrapper.eq(coupon.getStartTime() != null,Coupon::getStartTime,coupon.getStartTime());
		wrapper.eq(coupon.getEndTime() != null,Coupon::getEndTime,coupon.getEndTime());
		wrapper.eq(coupon.getUseType() != null,Coupon::getUseType,coupon.getUseType());
		wrapper.eq(coupon.getNote() != null,Coupon::getNote,coupon.getNote());
		wrapper.eq(coupon.getPublishCount() != null,Coupon::getPublishCount,coupon.getPublishCount());
		wrapper.eq(coupon.getUseCount() != null,Coupon::getUseCount,coupon.getUseCount());
		wrapper.eq(coupon.getReceiveCount() != null,Coupon::getReceiveCount,coupon.getReceiveCount());
		wrapper.eq(coupon.getEnableStartTime() != null,Coupon::getEnableStartTime,coupon.getEnableStartTime());
		wrapper.eq(coupon.getEnableEndTime() != null,Coupon::getEnableEndTime,coupon.getEnableEndTime());
		wrapper.eq(coupon.getCode() != null,Coupon::getCode,coupon.getCode());
		wrapper.eq(coupon.getMemberLevel() != null,Coupon::getMemberLevel,coupon.getMemberLevel());
		wrapper.eq(coupon.getPublish() != null,Coupon::getPublish,coupon.getPublish());

		couponService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
