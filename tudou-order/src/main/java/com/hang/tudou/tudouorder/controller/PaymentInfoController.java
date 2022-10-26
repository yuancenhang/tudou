
package com.hang.tudou.tudouorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouorder.service.PaymentInfoService;
import com.hang.tudou.tudouorder.entity.PaymentInfo;

@RestController
@RequestMapping("/paymentInfo")
public class PaymentInfoController {

	@Autowired
	PaymentInfoService paymentInfoService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody PaymentInfo paymentInfo){
		boolean ok = paymentInfoService.save(paymentInfo);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody PaymentInfo paymentInfo){
		boolean ok = paymentInfoService.removeById(paymentInfo);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody PaymentInfo paymentInfo){
		LambdaQueryWrapper<PaymentInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(paymentInfo.getId() != null,PaymentInfo::getId,paymentInfo.getId());
		boolean ok = paymentInfoService.update(paymentInfo,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<PaymentInfo> getById(@RequestBody PaymentInfo paymentInfo){
		paymentInfo = paymentInfoService.getById(paymentInfo.getId());
		return paymentInfo != null ? R.success(paymentInfo) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<PaymentInfo>> page(@RequestBody PaymentInfo paymentInfo){
		IPage<PaymentInfo> iPage = new Page<>(paymentInfo.getPage(), paymentInfo.getPageSize());
		LambdaQueryWrapper<PaymentInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(paymentInfo.getId() != null,PaymentInfo::getId,paymentInfo.getId());
		wrapper.eq(paymentInfo.getOrderSn() != null,PaymentInfo::getOrderSn,paymentInfo.getOrderSn());
		wrapper.eq(paymentInfo.getOrderId() != null,PaymentInfo::getOrderId,paymentInfo.getOrderId());
		wrapper.eq(paymentInfo.getAlipayTradeNo() != null,PaymentInfo::getAlipayTradeNo,paymentInfo.getAlipayTradeNo());
		wrapper.eq(paymentInfo.getTotalAmount() != null,PaymentInfo::getTotalAmount,paymentInfo.getTotalAmount());
		wrapper.eq(paymentInfo.getSubject() != null,PaymentInfo::getSubject,paymentInfo.getSubject());
		wrapper.eq(paymentInfo.getPaymentStatus() != null,PaymentInfo::getPaymentStatus,paymentInfo.getPaymentStatus());
		wrapper.eq(paymentInfo.getCreateTime() != null,PaymentInfo::getCreateTime,paymentInfo.getCreateTime());
		wrapper.eq(paymentInfo.getConfirmTime() != null,PaymentInfo::getConfirmTime,paymentInfo.getConfirmTime());
		wrapper.eq(paymentInfo.getCallbackContent() != null,PaymentInfo::getCallbackContent,paymentInfo.getCallbackContent());
		wrapper.eq(paymentInfo.getCallbackTime() != null,PaymentInfo::getCallbackTime,paymentInfo.getCallbackTime());

		paymentInfoService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
