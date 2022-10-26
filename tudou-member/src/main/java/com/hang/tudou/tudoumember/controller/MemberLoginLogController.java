
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoumember.service.MemberLoginLogService;
import com.hang.tudou.tudoumember.entity.MemberLoginLog;

@RestController
@RequestMapping("/memberLoginLog")
public class MemberLoginLogController {

	@Autowired
	MemberLoginLogService memberLoginLogService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody MemberLoginLog memberLoginLog){
		boolean ok = memberLoginLogService.save(memberLoginLog);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody MemberLoginLog memberLoginLog){
		boolean ok = memberLoginLogService.removeById(memberLoginLog);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody MemberLoginLog memberLoginLog){
		LambdaQueryWrapper<MemberLoginLog> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberLoginLog.getId() != null,MemberLoginLog::getId,memberLoginLog.getId());
		boolean ok = memberLoginLogService.update(memberLoginLog,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<MemberLoginLog> getById(@RequestBody MemberLoginLog memberLoginLog){
		memberLoginLog = memberLoginLogService.getById(memberLoginLog.getId());
		return memberLoginLog != null ? R.success(memberLoginLog) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<MemberLoginLog>> page(@RequestBody MemberLoginLog memberLoginLog){
		IPage<MemberLoginLog> iPage = new Page<>(memberLoginLog.getPage(), memberLoginLog.getPageSize());
		LambdaQueryWrapper<MemberLoginLog> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberLoginLog.getId() != null,MemberLoginLog::getId,memberLoginLog.getId());
		wrapper.eq(memberLoginLog.getMemberId() != null,MemberLoginLog::getMemberId,memberLoginLog.getMemberId());
		wrapper.eq(memberLoginLog.getCreateTime() != null,MemberLoginLog::getCreateTime,memberLoginLog.getCreateTime());
		wrapper.eq(memberLoginLog.getIp() != null,MemberLoginLog::getIp,memberLoginLog.getIp());
		wrapper.eq(memberLoginLog.getCity() != null,MemberLoginLog::getCity,memberLoginLog.getCity());
		wrapper.eq(memberLoginLog.getLoginType() != null,MemberLoginLog::getLoginType,memberLoginLog.getLoginType());

		memberLoginLogService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
