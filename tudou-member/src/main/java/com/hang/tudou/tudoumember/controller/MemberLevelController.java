
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoumember.service.MemberLevelService;
import com.hang.tudou.tudoumember.entity.MemberLevel;

@RestController
@RequestMapping("/memberLevel")
public class MemberLevelController {

	@Autowired
	MemberLevelService memberLevelService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody MemberLevel memberLevel){
		boolean ok = memberLevelService.save(memberLevel);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody MemberLevel memberLevel){
		boolean ok = memberLevelService.removeById(memberLevel);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody MemberLevel memberLevel){
		LambdaQueryWrapper<MemberLevel> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberLevel.getId() != null,MemberLevel::getId,memberLevel.getId());
		boolean ok = memberLevelService.update(memberLevel,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<MemberLevel> getById(@RequestBody MemberLevel memberLevel){
		memberLevel = memberLevelService.getById(memberLevel.getId());
		return memberLevel != null ? R.success(memberLevel) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<MemberLevel>> page(@RequestBody MemberLevel memberLevel){
		IPage<MemberLevel> iPage = new Page<>(memberLevel.getPage(), memberLevel.getPageSize());
		LambdaQueryWrapper<MemberLevel> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberLevel.getId() != null,MemberLevel::getId,memberLevel.getId());
		wrapper.eq(memberLevel.getName() != null,MemberLevel::getName,memberLevel.getName());
		wrapper.eq(memberLevel.getGrowthPoint() != null,MemberLevel::getGrowthPoint,memberLevel.getGrowthPoint());
		wrapper.eq(memberLevel.getDefaultStatus() != null,MemberLevel::getDefaultStatus,memberLevel.getDefaultStatus());
		wrapper.eq(memberLevel.getFreeFreightPoint() != null,MemberLevel::getFreeFreightPoint,memberLevel.getFreeFreightPoint());
		wrapper.eq(memberLevel.getCommentGrowthPoint() != null,MemberLevel::getCommentGrowthPoint,memberLevel.getCommentGrowthPoint());
		wrapper.eq(memberLevel.getPriviledgeFreeFreight() != null,MemberLevel::getPriviledgeFreeFreight,memberLevel.getPriviledgeFreeFreight());
		wrapper.eq(memberLevel.getPriviledgeMemberPrice() != null,MemberLevel::getPriviledgeMemberPrice,memberLevel.getPriviledgeMemberPrice());
		wrapper.eq(memberLevel.getPriviledgeBirthday() != null,MemberLevel::getPriviledgeBirthday,memberLevel.getPriviledgeBirthday());
		wrapper.eq(memberLevel.getNote() != null,MemberLevel::getNote,memberLevel.getNote());

		memberLevelService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
