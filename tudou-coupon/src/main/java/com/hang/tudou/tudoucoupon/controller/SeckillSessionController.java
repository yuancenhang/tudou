
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.SeckillSessionService;
import com.hang.tudou.tudoucoupon.entity.SeckillSession;

@RestController
@RequestMapping("/seckillSession")
public class SeckillSessionController {

	@Autowired
	SeckillSessionService seckillSessionService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SeckillSession seckillSession){
		boolean ok = seckillSessionService.save(seckillSession);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SeckillSession seckillSession){
		boolean ok = seckillSessionService.removeById(seckillSession);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SeckillSession seckillSession){
		LambdaQueryWrapper<SeckillSession> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(seckillSession.getId() != null,SeckillSession::getId,seckillSession.getId());
		boolean ok = seckillSessionService.update(seckillSession,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SeckillSession> getById(@RequestBody SeckillSession seckillSession){
		seckillSession = seckillSessionService.getById(seckillSession.getId());
		return seckillSession != null ? R.success(seckillSession) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SeckillSession>> page(@RequestBody SeckillSession seckillSession){
		IPage<SeckillSession> iPage = new Page<>(seckillSession.getPage(), seckillSession.getPageSize());
		LambdaQueryWrapper<SeckillSession> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(seckillSession.getId() != null,SeckillSession::getId,seckillSession.getId());
		wrapper.eq(seckillSession.getName() != null,SeckillSession::getName,seckillSession.getName());
		wrapper.eq(seckillSession.getStartTime() != null,SeckillSession::getStartTime,seckillSession.getStartTime());
		wrapper.eq(seckillSession.getEndTime() != null,SeckillSession::getEndTime,seckillSession.getEndTime());
		wrapper.eq(seckillSession.getStatus() != null,SeckillSession::getStatus,seckillSession.getStatus());
		wrapper.eq(seckillSession.getCreateTime() != null,SeckillSession::getCreateTime,seckillSession.getCreateTime());

		seckillSessionService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
