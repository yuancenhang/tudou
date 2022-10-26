
package com.hang.tudou.tudouorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouorder.service.OrderService;
import com.hang.tudou.tudouorder.entity.Order;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody Order order){
		boolean ok = orderService.save(order);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody Order order){
		boolean ok = orderService.removeById(order);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody Order order){
		LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(order.getId() != null,Order::getId,order.getId());
		boolean ok = orderService.update(order,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<Order> getById(@RequestBody Order order){
		order = orderService.getById(order.getId());
		return order != null ? R.success(order) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<Order>> page(@RequestBody Order order){
		IPage<Order> iPage = new Page<>(order.getPage(), order.getPageSize());
		LambdaQueryWrapper<Order> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(order.getId() != null,Order::getId,order.getId());
		wrapper.eq(order.getMemberId() != null,Order::getMemberId,order.getMemberId());
		wrapper.eq(order.getOrderSn() != null,Order::getOrderSn,order.getOrderSn());
		wrapper.eq(order.getCouponId() != null,Order::getCouponId,order.getCouponId());
		wrapper.eq(order.getCreateTime() != null,Order::getCreateTime,order.getCreateTime());
		wrapper.eq(order.getMemberUsername() != null,Order::getMemberUsername,order.getMemberUsername());
		wrapper.eq(order.getTotalAmount() != null,Order::getTotalAmount,order.getTotalAmount());
		wrapper.eq(order.getPayAmount() != null,Order::getPayAmount,order.getPayAmount());
		wrapper.eq(order.getFreightAmount() != null,Order::getFreightAmount,order.getFreightAmount());
		wrapper.eq(order.getPromotionAmount() != null,Order::getPromotionAmount,order.getPromotionAmount());
		wrapper.eq(order.getIntegrationAmount() != null,Order::getIntegrationAmount,order.getIntegrationAmount());
		wrapper.eq(order.getCouponAmount() != null,Order::getCouponAmount,order.getCouponAmount());
		wrapper.eq(order.getDiscountAmount() != null,Order::getDiscountAmount,order.getDiscountAmount());
		wrapper.eq(order.getPayType() != null,Order::getPayType,order.getPayType());
		wrapper.eq(order.getSourceType() != null,Order::getSourceType,order.getSourceType());
		wrapper.eq(order.getStatus() != null,Order::getStatus,order.getStatus());
		wrapper.eq(order.getDeliveryCompany() != null,Order::getDeliveryCompany,order.getDeliveryCompany());
		wrapper.eq(order.getDeliverySn() != null,Order::getDeliverySn,order.getDeliverySn());
		wrapper.eq(order.getAutoConfirmDay() != null,Order::getAutoConfirmDay,order.getAutoConfirmDay());
		wrapper.eq(order.getIntegration() != null,Order::getIntegration,order.getIntegration());
		wrapper.eq(order.getGrowth() != null,Order::getGrowth,order.getGrowth());
		wrapper.eq(order.getBillType() != null,Order::getBillType,order.getBillType());
		wrapper.eq(order.getBillHeader() != null,Order::getBillHeader,order.getBillHeader());
		wrapper.eq(order.getBillContent() != null,Order::getBillContent,order.getBillContent());
		wrapper.eq(order.getBillReceiverPhone() != null,Order::getBillReceiverPhone,order.getBillReceiverPhone());
		wrapper.eq(order.getBillReceiverEmail() != null,Order::getBillReceiverEmail,order.getBillReceiverEmail());
		wrapper.eq(order.getReceiverName() != null,Order::getReceiverName,order.getReceiverName());
		wrapper.eq(order.getReceiverPhone() != null,Order::getReceiverPhone,order.getReceiverPhone());
		wrapper.eq(order.getReceiverPostCode() != null,Order::getReceiverPostCode,order.getReceiverPostCode());
		wrapper.eq(order.getReceiverProvince() != null,Order::getReceiverProvince,order.getReceiverProvince());
		wrapper.eq(order.getReceiverCity() != null,Order::getReceiverCity,order.getReceiverCity());
		wrapper.eq(order.getReceiverRegion() != null,Order::getReceiverRegion,order.getReceiverRegion());
		wrapper.eq(order.getReceiverDetailAddress() != null,Order::getReceiverDetailAddress,order.getReceiverDetailAddress());
		wrapper.eq(order.getNote() != null,Order::getNote,order.getNote());
		wrapper.eq(order.getConfirmStatus() != null,Order::getConfirmStatus,order.getConfirmStatus());
		wrapper.eq(order.getDeleteStatus() != null,Order::getDeleteStatus,order.getDeleteStatus());
		wrapper.eq(order.getUseIntegration() != null,Order::getUseIntegration,order.getUseIntegration());
		wrapper.eq(order.getPaymentTime() != null,Order::getPaymentTime,order.getPaymentTime());
		wrapper.eq(order.getDeliveryTime() != null,Order::getDeliveryTime,order.getDeliveryTime());
		wrapper.eq(order.getReceiveTime() != null,Order::getReceiveTime,order.getReceiveTime());
		wrapper.eq(order.getCommentTime() != null,Order::getCommentTime,order.getCommentTime());
		wrapper.eq(order.getModifyTime() != null,Order::getModifyTime,order.getModifyTime());

		orderService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
