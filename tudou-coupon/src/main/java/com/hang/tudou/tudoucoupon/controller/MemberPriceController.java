
package com.hang.tudou.tudoucoupon.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudoucoupon.entity.R;
import com.hang.tudou.tudoucoupon.service.MemberPriceService;
import com.hang.tudou.tudoucoupon.entity.MemberPrice;

@RestController
@RequestMapping("/memberPrice")
public class MemberPriceController {

	@Autowired
	MemberPriceService memberPriceService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody MemberPrice memberPrice){
		boolean ok = memberPriceService.save(memberPrice);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody MemberPrice memberPrice){
		boolean ok = memberPriceService.removeById(memberPrice);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody MemberPrice memberPrice){
		LambdaQueryWrapper<MemberPrice> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberPrice.getId() != null,MemberPrice::getId,memberPrice.getId());
		boolean ok = memberPriceService.update(memberPrice,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<MemberPrice> getById(@RequestBody MemberPrice memberPrice){
		memberPrice = memberPriceService.getById(memberPrice.getId());
		return memberPrice != null ? R.success(memberPrice) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<MemberPrice>> page(@RequestBody MemberPrice memberPrice){
		IPage<MemberPrice> iPage = new Page<>(memberPrice.getPage(), memberPrice.getPageSize());
		LambdaQueryWrapper<MemberPrice> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberPrice.getId() != null,MemberPrice::getId,memberPrice.getId());
		wrapper.eq(memberPrice.getSkuId() != null,MemberPrice::getSkuId,memberPrice.getSkuId());
		wrapper.eq(memberPrice.getMemberLevelId() != null,MemberPrice::getMemberLevelId,memberPrice.getMemberLevelId());
		wrapper.eq(memberPrice.getMemberLevelName() != null,MemberPrice::getMemberLevelName,memberPrice.getMemberLevelName());
		wrapper.eq(memberPrice.getMemberPrice() != null,MemberPrice::getMemberPrice,memberPrice.getMemberPrice());
		wrapper.eq(memberPrice.getAddOther() != null,MemberPrice::getAddOther,memberPrice.getAddOther());

		memberPriceService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
