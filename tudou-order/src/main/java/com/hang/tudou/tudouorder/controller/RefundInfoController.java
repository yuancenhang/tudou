
package com.hang.tudou.tudouorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouorder.service.RefundInfoService;
import com.hang.tudou.tudouorder.entity.RefundInfo;

@RestController
@RequestMapping("/refundInfo")
public class RefundInfoController {

	@Autowired
	RefundInfoService refundInfoService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody RefundInfo refundInfo){
		boolean ok = refundInfoService.save(refundInfo);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody RefundInfo refundInfo){
		boolean ok = refundInfoService.removeById(refundInfo);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody RefundInfo refundInfo){
		LambdaQueryWrapper<RefundInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(refundInfo.getId() != null,RefundInfo::getId,refundInfo.getId());
		boolean ok = refundInfoService.update(refundInfo,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<RefundInfo> getById(@RequestBody RefundInfo refundInfo){
		refundInfo = refundInfoService.getById(refundInfo.getId());
		return refundInfo != null ? R.success(refundInfo) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<RefundInfo>> page(@RequestBody RefundInfo refundInfo){
		IPage<RefundInfo> iPage = new Page<>(refundInfo.getPage(), refundInfo.getPageSize());
		LambdaQueryWrapper<RefundInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(refundInfo.getId() != null,RefundInfo::getId,refundInfo.getId());
		wrapper.eq(refundInfo.getOrderReturnId() != null,RefundInfo::getOrderReturnId,refundInfo.getOrderReturnId());
		wrapper.eq(refundInfo.getRefund() != null,RefundInfo::getRefund,refundInfo.getRefund());
		wrapper.eq(refundInfo.getRefundSn() != null,RefundInfo::getRefundSn,refundInfo.getRefundSn());
		wrapper.eq(refundInfo.getRefundStatus() != null,RefundInfo::getRefundStatus,refundInfo.getRefundStatus());
		wrapper.eq(refundInfo.getRefundChannel() != null,RefundInfo::getRefundChannel,refundInfo.getRefundChannel());
		wrapper.eq(refundInfo.getRefundContent() != null,RefundInfo::getRefundContent,refundInfo.getRefundContent());

		refundInfoService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
