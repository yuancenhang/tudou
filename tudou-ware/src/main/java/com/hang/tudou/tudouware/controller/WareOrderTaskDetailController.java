
package com.hang.tudou.tudouware.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hang.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouware.service.WareOrderTaskDetailService;
import com.hang.tudou.tudouware.entity.WareOrderTaskDetail;

@RestController
@RequestMapping("/wareOrderTaskDetail")
public class WareOrderTaskDetailController {

	@Autowired
	WareOrderTaskDetailService wareOrderTaskDetailService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody WareOrderTaskDetail wareOrderTaskDetail){
		boolean ok = wareOrderTaskDetailService.save(wareOrderTaskDetail);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody WareOrderTaskDetail wareOrderTaskDetail){
		boolean ok = wareOrderTaskDetailService.removeById(wareOrderTaskDetail);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody WareOrderTaskDetail wareOrderTaskDetail){
		LambdaQueryWrapper<WareOrderTaskDetail> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(wareOrderTaskDetail.getId() != null,WareOrderTaskDetail::getId,wareOrderTaskDetail.getId());
		boolean ok = wareOrderTaskDetailService.update(wareOrderTaskDetail,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<WareOrderTaskDetail> getById(@RequestBody WareOrderTaskDetail wareOrderTaskDetail){
		wareOrderTaskDetail = wareOrderTaskDetailService.getById(wareOrderTaskDetail.getId());
		return wareOrderTaskDetail != null ? R.success(wareOrderTaskDetail) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<WareOrderTaskDetail>> page(@RequestBody WareOrderTaskDetail wareOrderTaskDetail){
		IPage<WareOrderTaskDetail> iPage = new Page<>(wareOrderTaskDetail.getPage(), wareOrderTaskDetail.getPageSize());
		LambdaQueryWrapper<WareOrderTaskDetail> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(wareOrderTaskDetail.getId() != null,WareOrderTaskDetail::getId,wareOrderTaskDetail.getId());
		wrapper.eq(wareOrderTaskDetail.getSkuId() != null,WareOrderTaskDetail::getSkuId,wareOrderTaskDetail.getSkuId());
		wrapper.eq(wareOrderTaskDetail.getSkuName() != null,WareOrderTaskDetail::getSkuName,wareOrderTaskDetail.getSkuName());
		wrapper.eq(wareOrderTaskDetail.getSkuNum() != null,WareOrderTaskDetail::getSkuNum,wareOrderTaskDetail.getSkuNum());
		wrapper.eq(wareOrderTaskDetail.getTaskId() != null,WareOrderTaskDetail::getTaskId,wareOrderTaskDetail.getTaskId());
		wrapper.eq(wareOrderTaskDetail.getWareId() != null,WareOrderTaskDetail::getWareId,wareOrderTaskDetail.getWareId());
		wrapper.eq(wareOrderTaskDetail.getLockStatus() != null,WareOrderTaskDetail::getLockStatus,wareOrderTaskDetail.getLockStatus());

		wareOrderTaskDetailService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
