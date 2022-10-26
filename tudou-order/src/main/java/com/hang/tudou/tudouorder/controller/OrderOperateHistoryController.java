
package com.hang.tudou.tudouorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouorder.service.OrderOperateHistoryService;
import com.hang.tudou.tudouorder.entity.OrderOperateHistory;

@RestController
@RequestMapping("/orderOperateHistory")
public class OrderOperateHistoryController {

	@Autowired
	OrderOperateHistoryService orderOperateHistoryService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody OrderOperateHistory orderOperateHistory){
		boolean ok = orderOperateHistoryService.save(orderOperateHistory);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody OrderOperateHistory orderOperateHistory){
		boolean ok = orderOperateHistoryService.removeById(orderOperateHistory);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody OrderOperateHistory orderOperateHistory){
		LambdaQueryWrapper<OrderOperateHistory> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderOperateHistory.getId() != null,OrderOperateHistory::getId,orderOperateHistory.getId());
		boolean ok = orderOperateHistoryService.update(orderOperateHistory,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<OrderOperateHistory> getById(@RequestBody OrderOperateHistory orderOperateHistory){
		orderOperateHistory = orderOperateHistoryService.getById(orderOperateHistory.getId());
		return orderOperateHistory != null ? R.success(orderOperateHistory) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<OrderOperateHistory>> page(@RequestBody OrderOperateHistory orderOperateHistory){
		IPage<OrderOperateHistory> iPage = new Page<>(orderOperateHistory.getPage(), orderOperateHistory.getPageSize());
		LambdaQueryWrapper<OrderOperateHistory> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderOperateHistory.getId() != null,OrderOperateHistory::getId,orderOperateHistory.getId());
		wrapper.eq(orderOperateHistory.getOrderId() != null,OrderOperateHistory::getOrderId,orderOperateHistory.getOrderId());
		wrapper.eq(orderOperateHistory.getOperateMan() != null,OrderOperateHistory::getOperateMan,orderOperateHistory.getOperateMan());
		wrapper.eq(orderOperateHistory.getCreateTime() != null,OrderOperateHistory::getCreateTime,orderOperateHistory.getCreateTime());
		wrapper.eq(orderOperateHistory.getOrderStatus() != null,OrderOperateHistory::getOrderStatus,orderOperateHistory.getOrderStatus());
		wrapper.eq(orderOperateHistory.getNote() != null,OrderOperateHistory::getNote,orderOperateHistory.getNote());

		orderOperateHistoryService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
