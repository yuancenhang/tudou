
package com.hang.tudou.tudouware.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hang.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouware.service.UndoLogService;
import com.hang.tudou.tudouware.entity.UndoLog;

@RestController
@RequestMapping("/undoLog")
public class UndoLogController {

	@Autowired
	UndoLogService undoLogService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody UndoLog undoLog){
		boolean ok = undoLogService.save(undoLog);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody UndoLog undoLog){
		boolean ok = undoLogService.removeById(undoLog);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody UndoLog undoLog){
		LambdaQueryWrapper<UndoLog> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(undoLog.getId() != null,UndoLog::getId,undoLog.getId());
		boolean ok = undoLogService.update(undoLog,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<UndoLog> getById(@RequestBody UndoLog undoLog){
		undoLog = undoLogService.getById(undoLog.getId());
		return undoLog != null ? R.success(undoLog) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<UndoLog>> page(@RequestBody UndoLog undoLog){
		IPage<UndoLog> iPage = new Page<>(undoLog.getPage(), undoLog.getPageSize());
		LambdaQueryWrapper<UndoLog> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(undoLog.getId() != null,UndoLog::getId,undoLog.getId());
		wrapper.eq(undoLog.getBranchId() != null,UndoLog::getBranchId,undoLog.getBranchId());
		wrapper.eq(undoLog.getXid() != null,UndoLog::getXid,undoLog.getXid());
		wrapper.eq(undoLog.getContext() != null,UndoLog::getContext,undoLog.getContext());
		wrapper.eq(undoLog.getRollbackInfo() != null,UndoLog::getRollbackInfo,undoLog.getRollbackInfo());
		wrapper.eq(undoLog.getLogStatus() != null,UndoLog::getLogStatus,undoLog.getLogStatus());
		wrapper.eq(undoLog.getLogCreated() != null,UndoLog::getLogCreated,undoLog.getLogCreated());
		wrapper.eq(undoLog.getLogModified() != null,UndoLog::getLogModified,undoLog.getLogModified());
		wrapper.eq(undoLog.getExt() != null,UndoLog::getExt,undoLog.getExt());

		undoLogService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
