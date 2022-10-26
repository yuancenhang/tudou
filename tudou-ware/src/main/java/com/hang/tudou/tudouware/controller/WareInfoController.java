
package com.hang.tudou.tudouware.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hang.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouware.service.WareInfoService;
import com.hang.tudou.tudouware.entity.WareInfo;

@RestController
@RequestMapping("/wareInfo")
public class WareInfoController {

	@Autowired
	WareInfoService wareInfoService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody WareInfo wareInfo){
		boolean ok = wareInfoService.save(wareInfo);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody WareInfo wareInfo){
		boolean ok = wareInfoService.removeById(wareInfo);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody WareInfo wareInfo){
		LambdaQueryWrapper<WareInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(wareInfo.getId() != null,WareInfo::getId,wareInfo.getId());
		boolean ok = wareInfoService.update(wareInfo,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<WareInfo> getById(@RequestBody WareInfo wareInfo){
		wareInfo = wareInfoService.getById(wareInfo.getId());
		return wareInfo != null ? R.success(wareInfo) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<WareInfo>> page(@RequestBody WareInfo wareInfo){
		IPage<WareInfo> iPage = new Page<>(wareInfo.getPage(), wareInfo.getPageSize());
		LambdaQueryWrapper<WareInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(wareInfo.getId() != null,WareInfo::getId,wareInfo.getId());
		wrapper.eq(wareInfo.getName() != null,WareInfo::getName,wareInfo.getName());
		wrapper.eq(wareInfo.getAddress() != null,WareInfo::getAddress,wareInfo.getAddress());
		wrapper.eq(wareInfo.getAreacode() != null,WareInfo::getAreacode,wareInfo.getAreacode());

		wareInfoService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
