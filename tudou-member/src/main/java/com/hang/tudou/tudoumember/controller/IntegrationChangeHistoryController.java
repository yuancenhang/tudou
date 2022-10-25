
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudoumember.entity.R;
import com.hang.tudou.tudoumember.service.IntegrationChangeHistoryService;
import com.hang.tudou.tudoumember.entity.IntegrationChangeHistory;

@RestController
@RequestMapping("/integrationChangeHistory")
public class IntegrationChangeHistoryController {

	@Autowired
	IntegrationChangeHistoryService integrationChangeHistoryService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody IntegrationChangeHistory integrationChangeHistory){
		boolean ok = integrationChangeHistoryService.save(integrationChangeHistory);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody IntegrationChangeHistory integrationChangeHistory){
		boolean ok = integrationChangeHistoryService.removeById(integrationChangeHistory);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody IntegrationChangeHistory integrationChangeHistory){
		LambdaQueryWrapper<IntegrationChangeHistory> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(integrationChangeHistory.getId() != null,IntegrationChangeHistory::getId,integrationChangeHistory.getId());
		boolean ok = integrationChangeHistoryService.update(integrationChangeHistory,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<IntegrationChangeHistory> getById(@RequestBody IntegrationChangeHistory integrationChangeHistory){
		integrationChangeHistory = integrationChangeHistoryService.getById(integrationChangeHistory.getId());
		return integrationChangeHistory != null ? R.success(integrationChangeHistory) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<IntegrationChangeHistory>> page(@RequestBody IntegrationChangeHistory integrationChangeHistory){
		IPage<IntegrationChangeHistory> iPage = new Page<>(integrationChangeHistory.getPage(), integrationChangeHistory.getPageSize());
		LambdaQueryWrapper<IntegrationChangeHistory> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(integrationChangeHistory.getId() != null,IntegrationChangeHistory::getId,integrationChangeHistory.getId());
		wrapper.eq(integrationChangeHistory.getMemberId() != null,IntegrationChangeHistory::getMemberId,integrationChangeHistory.getMemberId());
		wrapper.eq(integrationChangeHistory.getCreateTime() != null,IntegrationChangeHistory::getCreateTime,integrationChangeHistory.getCreateTime());
		wrapper.eq(integrationChangeHistory.getChangeCount() != null,IntegrationChangeHistory::getChangeCount,integrationChangeHistory.getChangeCount());
		wrapper.eq(integrationChangeHistory.getNote() != null,IntegrationChangeHistory::getNote,integrationChangeHistory.getNote());
		wrapper.eq(integrationChangeHistory.getSourceTyoe() != null,IntegrationChangeHistory::getSourceTyoe,integrationChangeHistory.getSourceTyoe());

		integrationChangeHistoryService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
