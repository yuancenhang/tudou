
package com.hang.tudou.tudouorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouorder.service.OrderItemService;
import com.hang.tudou.tudouorder.entity.OrderItem;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {

	@Autowired
	OrderItemService orderItemService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody OrderItem orderItem){
		boolean ok = orderItemService.save(orderItem);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody OrderItem orderItem){
		boolean ok = orderItemService.removeById(orderItem);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody OrderItem orderItem){
		LambdaQueryWrapper<OrderItem> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderItem.getId() != null,OrderItem::getId,orderItem.getId());
		boolean ok = orderItemService.update(orderItem,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<OrderItem> getById(@RequestBody OrderItem orderItem){
		orderItem = orderItemService.getById(orderItem.getId());
		return orderItem != null ? R.success(orderItem) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<OrderItem>> page(@RequestBody OrderItem orderItem){
		IPage<OrderItem> iPage = new Page<>(orderItem.getPage(), orderItem.getPageSize());
		LambdaQueryWrapper<OrderItem> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderItem.getId() != null,OrderItem::getId,orderItem.getId());
		wrapper.eq(orderItem.getOrderId() != null,OrderItem::getOrderId,orderItem.getOrderId());
		wrapper.eq(orderItem.getOrderSn() != null,OrderItem::getOrderSn,orderItem.getOrderSn());
		wrapper.eq(orderItem.getSpuId() != null,OrderItem::getSpuId,orderItem.getSpuId());
		wrapper.eq(orderItem.getSpuName() != null,OrderItem::getSpuName,orderItem.getSpuName());
		wrapper.eq(orderItem.getSpuPic() != null,OrderItem::getSpuPic,orderItem.getSpuPic());
		wrapper.eq(orderItem.getSpuBrand() != null,OrderItem::getSpuBrand,orderItem.getSpuBrand());
		wrapper.eq(orderItem.getCategoryId() != null,OrderItem::getCategoryId,orderItem.getCategoryId());
		wrapper.eq(orderItem.getSkuId() != null,OrderItem::getSkuId,orderItem.getSkuId());
		wrapper.eq(orderItem.getSkuName() != null,OrderItem::getSkuName,orderItem.getSkuName());
		wrapper.eq(orderItem.getSkuPic() != null,OrderItem::getSkuPic,orderItem.getSkuPic());
		wrapper.eq(orderItem.getSkuPrice() != null,OrderItem::getSkuPrice,orderItem.getSkuPrice());
		wrapper.eq(orderItem.getSkuQuantity() != null,OrderItem::getSkuQuantity,orderItem.getSkuQuantity());
		wrapper.eq(orderItem.getSkuAttrsVals() != null,OrderItem::getSkuAttrsVals,orderItem.getSkuAttrsVals());
		wrapper.eq(orderItem.getPromotionAmount() != null,OrderItem::getPromotionAmount,orderItem.getPromotionAmount());
		wrapper.eq(orderItem.getCouponAmount() != null,OrderItem::getCouponAmount,orderItem.getCouponAmount());
		wrapper.eq(orderItem.getIntegrationAmount() != null,OrderItem::getIntegrationAmount,orderItem.getIntegrationAmount());
		wrapper.eq(orderItem.getRealAmount() != null,OrderItem::getRealAmount,orderItem.getRealAmount());
		wrapper.eq(orderItem.getGiftIntegration() != null,OrderItem::getGiftIntegration,orderItem.getGiftIntegration());
		wrapper.eq(orderItem.getGiftGrowth() != null,OrderItem::getGiftGrowth,orderItem.getGiftGrowth());

		orderItemService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
