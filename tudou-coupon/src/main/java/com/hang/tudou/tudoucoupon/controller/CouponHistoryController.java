
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudoucoupon.entity.R;
import com.hang.tudou.tudoucoupon.service.CouponHistoryService;
import com.hang.tudou.tudoucoupon.entity.CouponHistory;

@RestController
@RequestMapping("/couponHistory")
public class CouponHistoryController {

	@Autowired
	CouponHistoryService couponHistoryService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody CouponHistory couponHistory){
		boolean ok = couponHistoryService.save(couponHistory);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody CouponHistory couponHistory){
		boolean ok = couponHistoryService.removeById(couponHistory);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody CouponHistory couponHistory){
		LambdaQueryWrapper<CouponHistory> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(couponHistory.getId() != null,CouponHistory::getId,couponHistory.getId());
		boolean ok = couponHistoryService.update(couponHistory,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<CouponHistory> getById(@RequestBody CouponHistory couponHistory){
		couponHistory = couponHistoryService.getById(couponHistory.getId());
		return couponHistory != null ? R.success(couponHistory) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<CouponHistory>> page(@RequestBody CouponHistory couponHistory){
		IPage<CouponHistory> iPage = new Page<>(couponHistory.getPage(), couponHistory.getPageSize());
		LambdaQueryWrapper<CouponHistory> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(couponHistory.getId() != null,CouponHistory::getId,couponHistory.getId());
		wrapper.eq(couponHistory.getCouponId() != null,CouponHistory::getCouponId,couponHistory.getCouponId());
		wrapper.eq(couponHistory.getMemberId() != null,CouponHistory::getMemberId,couponHistory.getMemberId());
		wrapper.eq(couponHistory.getMemberNickName() != null,CouponHistory::getMemberNickName,couponHistory.getMemberNickName());
		wrapper.eq(couponHistory.getGetType() != null,CouponHistory::getGetType,couponHistory.getGetType());
		wrapper.eq(couponHistory.getCreateTime() != null,CouponHistory::getCreateTime,couponHistory.getCreateTime());
		wrapper.eq(couponHistory.getUseType() != null,CouponHistory::getUseType,couponHistory.getUseType());
		wrapper.eq(couponHistory.getUseTime() != null,CouponHistory::getUseTime,couponHistory.getUseTime());
		wrapper.eq(couponHistory.getOrderId() != null,CouponHistory::getOrderId,couponHistory.getOrderId());
		wrapper.eq(couponHistory.getOrderSn() != null,CouponHistory::getOrderSn,couponHistory.getOrderSn());

		couponHistoryService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
