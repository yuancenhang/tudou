
package com.hang.tudou.tudouorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouorder.service.OrderReturnReasonService;
import com.hang.tudou.tudouorder.entity.OrderReturnReason;

@RestController
@RequestMapping("/orderReturnReason")
public class OrderReturnReasonController {

	@Autowired
	OrderReturnReasonService orderReturnReasonService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody OrderReturnReason orderReturnReason){
		boolean ok = orderReturnReasonService.save(orderReturnReason);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody OrderReturnReason orderReturnReason){
		boolean ok = orderReturnReasonService.removeById(orderReturnReason);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody OrderReturnReason orderReturnReason){
		LambdaQueryWrapper<OrderReturnReason> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderReturnReason.getId() != null,OrderReturnReason::getId,orderReturnReason.getId());
		boolean ok = orderReturnReasonService.update(orderReturnReason,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<OrderReturnReason> getById(@RequestBody OrderReturnReason orderReturnReason){
		orderReturnReason = orderReturnReasonService.getById(orderReturnReason.getId());
		return orderReturnReason != null ? R.success(orderReturnReason) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<OrderReturnReason>> page(@RequestBody OrderReturnReason orderReturnReason){
		IPage<OrderReturnReason> iPage = new Page<>(orderReturnReason.getPage(), orderReturnReason.getPageSize());
		LambdaQueryWrapper<OrderReturnReason> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderReturnReason.getId() != null,OrderReturnReason::getId,orderReturnReason.getId());
		wrapper.eq(orderReturnReason.getName() != null,OrderReturnReason::getName,orderReturnReason.getName());
		wrapper.eq(orderReturnReason.getSort() != null,OrderReturnReason::getSort,orderReturnReason.getSort());
		wrapper.eq(orderReturnReason.getStatus() != null,OrderReturnReason::getStatus,orderReturnReason.getStatus());
		wrapper.eq(orderReturnReason.getCreateTime() != null,OrderReturnReason::getCreateTime,orderReturnReason.getCreateTime());

		orderReturnReasonService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
