
package com.hang.tudou.tudouorder.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudouorder.service.OrderSettingService;
import com.hang.tudou.tudouorder.entity.OrderSetting;

@RestController
@RequestMapping("/orderSetting")
public class OrderSettingController {

	@Autowired
	OrderSettingService orderSettingService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody OrderSetting orderSetting){
		boolean ok = orderSettingService.save(orderSetting);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody OrderSetting orderSetting){
		boolean ok = orderSettingService.removeById(orderSetting);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody OrderSetting orderSetting){
		LambdaQueryWrapper<OrderSetting> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderSetting.getId() != null,OrderSetting::getId,orderSetting.getId());
		boolean ok = orderSettingService.update(orderSetting,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<OrderSetting> getById(@RequestBody OrderSetting orderSetting){
		orderSetting = orderSettingService.getById(orderSetting.getId());
		return orderSetting != null ? R.success(orderSetting) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<OrderSetting>> page(@RequestBody OrderSetting orderSetting){
		IPage<OrderSetting> iPage = new Page<>(orderSetting.getPage(), orderSetting.getPageSize());
		LambdaQueryWrapper<OrderSetting> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(orderSetting.getId() != null,OrderSetting::getId,orderSetting.getId());
		wrapper.eq(orderSetting.getFlashOrderOvertime() != null,OrderSetting::getFlashOrderOvertime,orderSetting.getFlashOrderOvertime());
		wrapper.eq(orderSetting.getNormalOrderOvertime() != null,OrderSetting::getNormalOrderOvertime,orderSetting.getNormalOrderOvertime());
		wrapper.eq(orderSetting.getConfirmOvertime() != null,OrderSetting::getConfirmOvertime,orderSetting.getConfirmOvertime());
		wrapper.eq(orderSetting.getFinishOvertime() != null,OrderSetting::getFinishOvertime,orderSetting.getFinishOvertime());
		wrapper.eq(orderSetting.getCommentOvertime() != null,OrderSetting::getCommentOvertime,orderSetting.getCommentOvertime());
		wrapper.eq(orderSetting.getMemberLevel() != null,OrderSetting::getMemberLevel,orderSetting.getMemberLevel());

		orderSettingService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
