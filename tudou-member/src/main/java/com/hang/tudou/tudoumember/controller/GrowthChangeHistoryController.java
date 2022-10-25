
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudoumember.entity.R;
import com.hang.tudou.tudoumember.service.GrowthChangeHistoryService;
import com.hang.tudou.tudoumember.entity.GrowthChangeHistory;

@RestController
@RequestMapping("/growthChangeHistory")
public class GrowthChangeHistoryController {

	@Autowired
	GrowthChangeHistoryService growthChangeHistoryService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody GrowthChangeHistory growthChangeHistory){
		boolean ok = growthChangeHistoryService.save(growthChangeHistory);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody GrowthChangeHistory growthChangeHistory){
		boolean ok = growthChangeHistoryService.removeById(growthChangeHistory);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody GrowthChangeHistory growthChangeHistory){
		LambdaQueryWrapper<GrowthChangeHistory> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(growthChangeHistory.getId() != null,GrowthChangeHistory::getId,growthChangeHistory.getId());
		boolean ok = growthChangeHistoryService.update(growthChangeHistory,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<GrowthChangeHistory> getById(@RequestBody GrowthChangeHistory growthChangeHistory){
		growthChangeHistory = growthChangeHistoryService.getById(growthChangeHistory.getId());
		return growthChangeHistory != null ? R.success(growthChangeHistory) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<GrowthChangeHistory>> page(@RequestBody GrowthChangeHistory growthChangeHistory){
		IPage<GrowthChangeHistory> iPage = new Page<>(growthChangeHistory.getPage(), growthChangeHistory.getPageSize());
		LambdaQueryWrapper<GrowthChangeHistory> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(growthChangeHistory.getId() != null,GrowthChangeHistory::getId,growthChangeHistory.getId());
		wrapper.eq(growthChangeHistory.getMemberId() != null,GrowthChangeHistory::getMemberId,growthChangeHistory.getMemberId());
		wrapper.eq(growthChangeHistory.getCreateTime() != null,GrowthChangeHistory::getCreateTime,growthChangeHistory.getCreateTime());
		wrapper.eq(growthChangeHistory.getChangeCount() != null,GrowthChangeHistory::getChangeCount,growthChangeHistory.getChangeCount());
		wrapper.eq(growthChangeHistory.getNote() != null,GrowthChangeHistory::getNote,growthChangeHistory.getNote());
		wrapper.eq(growthChangeHistory.getSourceType() != null,GrowthChangeHistory::getSourceType,growthChangeHistory.getSourceType());

		growthChangeHistoryService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
