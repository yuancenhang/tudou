
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudoumember.entity.R;
import com.hang.tudou.tudoumember.service.MemberReceiveAddressService;
import com.hang.tudou.tudoumember.entity.MemberReceiveAddress;

@RestController
@RequestMapping("/memberReceiveAddress")
public class MemberReceiveAddressController {

	@Autowired
	MemberReceiveAddressService memberReceiveAddressService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody MemberReceiveAddress memberReceiveAddress){
		boolean ok = memberReceiveAddressService.save(memberReceiveAddress);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody MemberReceiveAddress memberReceiveAddress){
		boolean ok = memberReceiveAddressService.removeById(memberReceiveAddress);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody MemberReceiveAddress memberReceiveAddress){
		LambdaQueryWrapper<MemberReceiveAddress> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberReceiveAddress.getId() != null,MemberReceiveAddress::getId,memberReceiveAddress.getId());
		boolean ok = memberReceiveAddressService.update(memberReceiveAddress,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<MemberReceiveAddress> getById(@RequestBody MemberReceiveAddress memberReceiveAddress){
		memberReceiveAddress = memberReceiveAddressService.getById(memberReceiveAddress.getId());
		return memberReceiveAddress != null ? R.success(memberReceiveAddress) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<MemberReceiveAddress>> page(@RequestBody MemberReceiveAddress memberReceiveAddress){
		IPage<MemberReceiveAddress> iPage = new Page<>(memberReceiveAddress.getPage(), memberReceiveAddress.getPageSize());
		LambdaQueryWrapper<MemberReceiveAddress> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberReceiveAddress.getId() != null,MemberReceiveAddress::getId,memberReceiveAddress.getId());
		wrapper.eq(memberReceiveAddress.getMemberId() != null,MemberReceiveAddress::getMemberId,memberReceiveAddress.getMemberId());
		wrapper.eq(memberReceiveAddress.getName() != null,MemberReceiveAddress::getName,memberReceiveAddress.getName());
		wrapper.eq(memberReceiveAddress.getPhone() != null,MemberReceiveAddress::getPhone,memberReceiveAddress.getPhone());
		wrapper.eq(memberReceiveAddress.getPostCode() != null,MemberReceiveAddress::getPostCode,memberReceiveAddress.getPostCode());
		wrapper.eq(memberReceiveAddress.getProvince() != null,MemberReceiveAddress::getProvince,memberReceiveAddress.getProvince());
		wrapper.eq(memberReceiveAddress.getCity() != null,MemberReceiveAddress::getCity,memberReceiveAddress.getCity());
		wrapper.eq(memberReceiveAddress.getRegion() != null,MemberReceiveAddress::getRegion,memberReceiveAddress.getRegion());
		wrapper.eq(memberReceiveAddress.getDetailAddress() != null,MemberReceiveAddress::getDetailAddress,memberReceiveAddress.getDetailAddress());
		wrapper.eq(memberReceiveAddress.getAreacode() != null,MemberReceiveAddress::getAreacode,memberReceiveAddress.getAreacode());
		wrapper.eq(memberReceiveAddress.getDefaultStatus() != null,MemberReceiveAddress::getDefaultStatus,memberReceiveAddress.getDefaultStatus());

		memberReceiveAddressService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
