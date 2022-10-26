
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoumember.service.MemberService;
import com.hang.tudou.tudoumember.entity.Member;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody Member member){
		boolean ok = memberService.save(member);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody Member member){
		boolean ok = memberService.removeById(member);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody Member member){
		LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(member.getId() != null,Member::getId,member.getId());
		boolean ok = memberService.update(member,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<Member> getById(@RequestBody Member member){
		member = memberService.getById(member.getId());
		return member != null ? R.success(member) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<Member>> page(@RequestBody Member member){
		IPage<Member> iPage = new Page<>(member.getPage(), member.getPageSize());
		LambdaQueryWrapper<Member> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(member.getId() != null,Member::getId,member.getId());
		wrapper.eq(member.getLevelId() != null,Member::getLevelId,member.getLevelId());
		wrapper.eq(member.getUsername() != null,Member::getUsername,member.getUsername());
		wrapper.eq(member.getPassword() != null,Member::getPassword,member.getPassword());
		wrapper.eq(member.getNickname() != null,Member::getNickname,member.getNickname());
		wrapper.eq(member.getMobile() != null,Member::getMobile,member.getMobile());
		wrapper.eq(member.getEmail() != null,Member::getEmail,member.getEmail());
		wrapper.eq(member.getHeader() != null,Member::getHeader,member.getHeader());
		wrapper.eq(member.getGender() != null,Member::getGender,member.getGender());
		wrapper.eq(member.getBirth() != null,Member::getBirth,member.getBirth());
		wrapper.eq(member.getCity() != null,Member::getCity,member.getCity());
		wrapper.eq(member.getJob() != null,Member::getJob,member.getJob());
		wrapper.eq(member.getSign() != null,Member::getSign,member.getSign());
		wrapper.eq(member.getSourceType() != null,Member::getSourceType,member.getSourceType());
		wrapper.eq(member.getIntegration() != null,Member::getIntegration,member.getIntegration());
		wrapper.eq(member.getGrowth() != null,Member::getGrowth,member.getGrowth());
		wrapper.eq(member.getStatus() != null,Member::getStatus,member.getStatus());
		wrapper.eq(member.getCreateTime() != null,Member::getCreateTime,member.getCreateTime());

		memberService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
