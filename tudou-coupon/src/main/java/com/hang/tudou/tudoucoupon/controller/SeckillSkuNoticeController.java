
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.SeckillSkuNoticeService;
import com.hang.tudou.tudoucoupon.entity.SeckillSkuNotice;

@RestController
@RequestMapping("/seckillSkuNotice")
public class SeckillSkuNoticeController {

	@Autowired
	SeckillSkuNoticeService seckillSkuNoticeService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SeckillSkuNotice seckillSkuNotice){
		boolean ok = seckillSkuNoticeService.save(seckillSkuNotice);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SeckillSkuNotice seckillSkuNotice){
		boolean ok = seckillSkuNoticeService.removeById(seckillSkuNotice);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SeckillSkuNotice seckillSkuNotice){
		LambdaQueryWrapper<SeckillSkuNotice> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(seckillSkuNotice.getId() != null,SeckillSkuNotice::getId,seckillSkuNotice.getId());
		boolean ok = seckillSkuNoticeService.update(seckillSkuNotice,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SeckillSkuNotice> getById(@RequestBody SeckillSkuNotice seckillSkuNotice){
		seckillSkuNotice = seckillSkuNoticeService.getById(seckillSkuNotice.getId());
		return seckillSkuNotice != null ? R.success(seckillSkuNotice) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SeckillSkuNotice>> page(@RequestBody SeckillSkuNotice seckillSkuNotice){
		IPage<SeckillSkuNotice> iPage = new Page<>(seckillSkuNotice.getPage(), seckillSkuNotice.getPageSize());
		LambdaQueryWrapper<SeckillSkuNotice> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(seckillSkuNotice.getId() != null,SeckillSkuNotice::getId,seckillSkuNotice.getId());
		wrapper.eq(seckillSkuNotice.getMemberId() != null,SeckillSkuNotice::getMemberId,seckillSkuNotice.getMemberId());
		wrapper.eq(seckillSkuNotice.getSkuId() != null,SeckillSkuNotice::getSkuId,seckillSkuNotice.getSkuId());
		wrapper.eq(seckillSkuNotice.getSessionId() != null,SeckillSkuNotice::getSessionId,seckillSkuNotice.getSessionId());
		wrapper.eq(seckillSkuNotice.getSubcribeTime() != null,SeckillSkuNotice::getSubcribeTime,seckillSkuNotice.getSubcribeTime());
		wrapper.eq(seckillSkuNotice.getSendTime() != null,SeckillSkuNotice::getSendTime,seckillSkuNotice.getSendTime());
		wrapper.eq(seckillSkuNotice.getNoticeType() != null,SeckillSkuNotice::getNoticeType,seckillSkuNotice.getNoticeType());

		seckillSkuNoticeService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
