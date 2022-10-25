
package com.hang.tudou.tudouware.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouware.entity.R;
import com.hang.tudou.tudouware.service.PurchaseService;
import com.hang.tudou.tudouware.entity.Purchase;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	PurchaseService purchaseService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody Purchase purchase){
		boolean ok = purchaseService.save(purchase);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody Purchase purchase){
		boolean ok = purchaseService.removeById(purchase);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody Purchase purchase){
		LambdaQueryWrapper<Purchase> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(purchase.getId() != null,Purchase::getId,purchase.getId());
		boolean ok = purchaseService.update(purchase,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<Purchase> getById(@RequestBody Purchase purchase){
		purchase = purchaseService.getById(purchase.getId());
		return purchase != null ? R.success(purchase) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<Purchase>> page(@RequestBody Purchase purchase){
		IPage<Purchase> iPage = new Page<>(purchase.getPage(), purchase.getPageSize());
		LambdaQueryWrapper<Purchase> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(purchase.getId() != null,Purchase::getId,purchase.getId());
		wrapper.eq(purchase.getAssigneeId() != null,Purchase::getAssigneeId,purchase.getAssigneeId());
		wrapper.eq(purchase.getAssigneeName() != null,Purchase::getAssigneeName,purchase.getAssigneeName());
		wrapper.eq(purchase.getPhone() != null,Purchase::getPhone,purchase.getPhone());
		wrapper.eq(purchase.getPriority() != null,Purchase::getPriority,purchase.getPriority());
		wrapper.eq(purchase.getStatus() != null,Purchase::getStatus,purchase.getStatus());
		wrapper.eq(purchase.getWareId() != null,Purchase::getWareId,purchase.getWareId());
		wrapper.eq(purchase.getAmount() != null,Purchase::getAmount,purchase.getAmount());
		wrapper.eq(purchase.getCreateTime() != null,Purchase::getCreateTime,purchase.getCreateTime());
		wrapper.eq(purchase.getUpdateTime() != null,Purchase::getUpdateTime,purchase.getUpdateTime());

		purchaseService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
