
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoumember.service.MemberCollectSubjectService;
import com.hang.tudou.tudoumember.entity.MemberCollectSubject;

@RestController
@RequestMapping("/memberCollectSubject")
public class MemberCollectSubjectController {

	@Autowired
	MemberCollectSubjectService memberCollectSubjectService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody MemberCollectSubject memberCollectSubject){
		boolean ok = memberCollectSubjectService.save(memberCollectSubject);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody MemberCollectSubject memberCollectSubject){
		boolean ok = memberCollectSubjectService.removeById(memberCollectSubject);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody MemberCollectSubject memberCollectSubject){
		LambdaQueryWrapper<MemberCollectSubject> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberCollectSubject.getId() != null,MemberCollectSubject::getId,memberCollectSubject.getId());
		boolean ok = memberCollectSubjectService.update(memberCollectSubject,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<MemberCollectSubject> getById(@RequestBody MemberCollectSubject memberCollectSubject){
		memberCollectSubject = memberCollectSubjectService.getById(memberCollectSubject.getId());
		return memberCollectSubject != null ? R.success(memberCollectSubject) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<MemberCollectSubject>> page(@RequestBody MemberCollectSubject memberCollectSubject){
		IPage<MemberCollectSubject> iPage = new Page<>(memberCollectSubject.getPage(), memberCollectSubject.getPageSize());
		LambdaQueryWrapper<MemberCollectSubject> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberCollectSubject.getId() != null,MemberCollectSubject::getId,memberCollectSubject.getId());
		wrapper.eq(memberCollectSubject.getSubjectId() != null,MemberCollectSubject::getSubjectId,memberCollectSubject.getSubjectId());
		wrapper.eq(memberCollectSubject.getSubjectName() != null,MemberCollectSubject::getSubjectName,memberCollectSubject.getSubjectName());
		wrapper.eq(memberCollectSubject.getSubjectImg() != null,MemberCollectSubject::getSubjectImg,memberCollectSubject.getSubjectImg());
		wrapper.eq(memberCollectSubject.getSubjectUrll() != null,MemberCollectSubject::getSubjectUrll,memberCollectSubject.getSubjectUrll());

		memberCollectSubjectService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
