
package com.hang.tudou.tudouware.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouware.entity.R;
import com.hang.tudou.tudouware.service.WareOrderTaskService;
import com.hang.tudou.tudouware.entity.WareOrderTask;

@RestController
@RequestMapping("/wareOrderTask")
public class WareOrderTaskController {

	@Autowired
	WareOrderTaskService wareOrderTaskService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody WareOrderTask wareOrderTask){
		boolean ok = wareOrderTaskService.save(wareOrderTask);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody WareOrderTask wareOrderTask){
		boolean ok = wareOrderTaskService.removeById(wareOrderTask);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody WareOrderTask wareOrderTask){
		LambdaQueryWrapper<WareOrderTask> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(wareOrderTask.getId() != null,WareOrderTask::getId,wareOrderTask.getId());
		boolean ok = wareOrderTaskService.update(wareOrderTask,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<WareOrderTask> getById(@RequestBody WareOrderTask wareOrderTask){
		wareOrderTask = wareOrderTaskService.getById(wareOrderTask.getId());
		return wareOrderTask != null ? R.success(wareOrderTask) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<WareOrderTask>> page(@RequestBody WareOrderTask wareOrderTask){
		IPage<WareOrderTask> iPage = new Page<>(wareOrderTask.getPage(), wareOrderTask.getPageSize());
		LambdaQueryWrapper<WareOrderTask> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(wareOrderTask.getId() != null,WareOrderTask::getId,wareOrderTask.getId());
		wrapper.eq(wareOrderTask.getOrderId() != null,WareOrderTask::getOrderId,wareOrderTask.getOrderId());
		wrapper.eq(wareOrderTask.getOrderSn() != null,WareOrderTask::getOrderSn,wareOrderTask.getOrderSn());
		wrapper.eq(wareOrderTask.getConsignee() != null,WareOrderTask::getConsignee,wareOrderTask.getConsignee());
		wrapper.eq(wareOrderTask.getConsigneeTel() != null,WareOrderTask::getConsigneeTel,wareOrderTask.getConsigneeTel());
		wrapper.eq(wareOrderTask.getDeliveryAddress() != null,WareOrderTask::getDeliveryAddress,wareOrderTask.getDeliveryAddress());
		wrapper.eq(wareOrderTask.getOrderComment() != null,WareOrderTask::getOrderComment,wareOrderTask.getOrderComment());
		wrapper.eq(wareOrderTask.getPaymentWay() != null,WareOrderTask::getPaymentWay,wareOrderTask.getPaymentWay());
		wrapper.eq(wareOrderTask.getTaskStatus() != null,WareOrderTask::getTaskStatus,wareOrderTask.getTaskStatus());
		wrapper.eq(wareOrderTask.getOrderBody() != null,WareOrderTask::getOrderBody,wareOrderTask.getOrderBody());
		wrapper.eq(wareOrderTask.getTrackingNo() != null,WareOrderTask::getTrackingNo,wareOrderTask.getTrackingNo());
		wrapper.eq(wareOrderTask.getCreateTime() != null,WareOrderTask::getCreateTime,wareOrderTask.getCreateTime());
		wrapper.eq(wareOrderTask.getWareId() != null,WareOrderTask::getWareId,wareOrderTask.getWareId());
		wrapper.eq(wareOrderTask.getTaskComment() != null,WareOrderTask::getTaskComment,wareOrderTask.getTaskComment());

		wareOrderTaskService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
