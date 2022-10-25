
package com.hang.tudou.tudouorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouorder.entity.R;
import com.hang.tudou.tudouorder.service.OrderReturnApplyService;
import com.hang.tudou.tudouorder.entity.OrderReturnApply;

@RestController
@RequestMapping("/orderReturnApply")
public class OrderReturnApplyController {

	@Autowired
	OrderReturnApplyService orderReturnApplyService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody OrderReturnApply orderReturnApply){
		boolean ok = orderReturnApplyService.save(orderReturnApply);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody OrderReturnApply orderReturnApply){
		boolean ok = orderReturnApplyService.removeById(orderReturnApply);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody OrderReturnApply orderReturnApply){
		LambdaQueryWrapper<OrderReturnApply> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderReturnApply.getId() != null,OrderReturnApply::getId,orderReturnApply.getId());
		boolean ok = orderReturnApplyService.update(orderReturnApply,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<OrderReturnApply> getById(@RequestBody OrderReturnApply orderReturnApply){
		orderReturnApply = orderReturnApplyService.getById(orderReturnApply.getId());
		return orderReturnApply != null ? R.success(orderReturnApply) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<OrderReturnApply>> page(@RequestBody OrderReturnApply orderReturnApply){
		IPage<OrderReturnApply> iPage = new Page<>(orderReturnApply.getPage(), orderReturnApply.getPageSize());
		LambdaQueryWrapper<OrderReturnApply> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderReturnApply.getId() != null,OrderReturnApply::getId,orderReturnApply.getId());
		wrapper.eq(orderReturnApply.getOrderId() != null,OrderReturnApply::getOrderId,orderReturnApply.getOrderId());
		wrapper.eq(orderReturnApply.getSkuId() != null,OrderReturnApply::getSkuId,orderReturnApply.getSkuId());
		wrapper.eq(orderReturnApply.getOrderSn() != null,OrderReturnApply::getOrderSn,orderReturnApply.getOrderSn());
		wrapper.eq(orderReturnApply.getCreateTime() != null,OrderReturnApply::getCreateTime,orderReturnApply.getCreateTime());
		wrapper.eq(orderReturnApply.getMemberUsername() != null,OrderReturnApply::getMemberUsername,orderReturnApply.getMemberUsername());
		wrapper.eq(orderReturnApply.getReturnAmount() != null,OrderReturnApply::getReturnAmount,orderReturnApply.getReturnAmount());
		wrapper.eq(orderReturnApply.getReturnName() != null,OrderReturnApply::getReturnName,orderReturnApply.getReturnName());
		wrapper.eq(orderReturnApply.getReturnPhone() != null,OrderReturnApply::getReturnPhone,orderReturnApply.getReturnPhone());
		wrapper.eq(orderReturnApply.getStatus() != null,OrderReturnApply::getStatus,orderReturnApply.getStatus());
		wrapper.eq(orderReturnApply.getHandleTime() != null,OrderReturnApply::getHandleTime,orderReturnApply.getHandleTime());
		wrapper.eq(orderReturnApply.getSkuImg() != null,OrderReturnApply::getSkuImg,orderReturnApply.getSkuImg());
		wrapper.eq(orderReturnApply.getSkuName() != null,OrderReturnApply::getSkuName,orderReturnApply.getSkuName());
		wrapper.eq(orderReturnApply.getSkuBrand() != null,OrderReturnApply::getSkuBrand,orderReturnApply.getSkuBrand());
		wrapper.eq(orderReturnApply.getSkuAttrsVals() != null,OrderReturnApply::getSkuAttrsVals,orderReturnApply.getSkuAttrsVals());
		wrapper.eq(orderReturnApply.getSkuCount() != null,OrderReturnApply::getSkuCount,orderReturnApply.getSkuCount());
		wrapper.eq(orderReturnApply.getSkuPrice() != null,OrderReturnApply::getSkuPrice,orderReturnApply.getSkuPrice());
		wrapper.eq(orderReturnApply.getSkuRealPrice() != null,OrderReturnApply::getSkuRealPrice,orderReturnApply.getSkuRealPrice());
		wrapper.eq(orderReturnApply.getReason() != null,OrderReturnApply::getReason,orderReturnApply.getReason());
		wrapper.eq(orderReturnApply.getDescription述() != null,OrderReturnApply::getDescription述,orderReturnApply.getDescription述());
		wrapper.eq(orderReturnApply.getDescPics() != null,OrderReturnApply::getDescPics,orderReturnApply.getDescPics());
		wrapper.eq(orderReturnApply.getHandleNote() != null,OrderReturnApply::getHandleNote,orderReturnApply.getHandleNote());
		wrapper.eq(orderReturnApply.getHandleMan() != null,OrderReturnApply::getHandleMan,orderReturnApply.getHandleMan());
		wrapper.eq(orderReturnApply.getReceiveMan() != null,OrderReturnApply::getReceiveMan,orderReturnApply.getReceiveMan());
		wrapper.eq(orderReturnApply.getReceiveTime() != null,OrderReturnApply::getReceiveTime,orderReturnApply.getReceiveTime());
		wrapper.eq(orderReturnApply.getReceiveNote() != null,OrderReturnApply::getReceiveNote,orderReturnApply.getReceiveNote());
		wrapper.eq(orderReturnApply.getReceivePhone() != null,OrderReturnApply::getReceivePhone,orderReturnApply.getReceivePhone());
		wrapper.eq(orderReturnApply.getCompanyAddress() != null,OrderReturnApply::getCompanyAddress,orderReturnApply.getCompanyAddress());

		orderReturnApplyService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
