
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoucoupon.service.HomeAdvService;
import com.hang.tudou.tudoucoupon.entity.HomeAdv;

@RestController
@RequestMapping("/homeAdv")
public class HomeAdvController {

	@Autowired
	HomeAdvService homeAdvService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody HomeAdv homeAdv){
		boolean ok = homeAdvService.save(homeAdv);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody HomeAdv homeAdv){
		boolean ok = homeAdvService.removeById(homeAdv);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody HomeAdv homeAdv){
		LambdaQueryWrapper<HomeAdv> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(homeAdv.getId() != null,HomeAdv::getId,homeAdv.getId());
		boolean ok = homeAdvService.update(homeAdv,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<HomeAdv> getById(@RequestBody HomeAdv homeAdv){
		homeAdv = homeAdvService.getById(homeAdv.getId());
		return homeAdv != null ? R.success(homeAdv) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<HomeAdv>> page(@RequestBody HomeAdv homeAdv){
		IPage<HomeAdv> iPage = new Page<>(homeAdv.getPage(), homeAdv.getPageSize());
		LambdaQueryWrapper<HomeAdv> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(homeAdv.getId() != null,HomeAdv::getId,homeAdv.getId());
		wrapper.eq(homeAdv.getName() != null,HomeAdv::getName,homeAdv.getName());
		wrapper.eq(homeAdv.getPic() != null,HomeAdv::getPic,homeAdv.getPic());
		wrapper.eq(homeAdv.getStartTime() != null,HomeAdv::getStartTime,homeAdv.getStartTime());
		wrapper.eq(homeAdv.getEndTime() != null,HomeAdv::getEndTime,homeAdv.getEndTime());
		wrapper.eq(homeAdv.getStatus() != null,HomeAdv::getStatus,homeAdv.getStatus());
		wrapper.eq(homeAdv.getClickCount() != null,HomeAdv::getClickCount,homeAdv.getClickCount());
		wrapper.eq(homeAdv.getUrl() != null,HomeAdv::getUrl,homeAdv.getUrl());
		wrapper.eq(homeAdv.getNote() != null,HomeAdv::getNote,homeAdv.getNote());
		wrapper.eq(homeAdv.getSort() != null,HomeAdv::getSort,homeAdv.getSort());
		wrapper.eq(homeAdv.getPublisherId() != null,HomeAdv::getPublisherId,homeAdv.getPublisherId());
		wrapper.eq(homeAdv.getAuthId() != null,HomeAdv::getAuthId,homeAdv.getAuthId());

		homeAdvService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
