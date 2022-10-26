
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.common.utils.R;
import com.hang.tudou.tudoumember.service.MemberStatisticsInfoService;
import com.hang.tudou.tudoumember.entity.MemberStatisticsInfo;

@RestController
@RequestMapping("/memberStatisticsInfo")
public class MemberStatisticsInfoController {

	@Autowired
	MemberStatisticsInfoService memberStatisticsInfoService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody MemberStatisticsInfo memberStatisticsInfo){
		boolean ok = memberStatisticsInfoService.save(memberStatisticsInfo);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody MemberStatisticsInfo memberStatisticsInfo){
		boolean ok = memberStatisticsInfoService.removeById(memberStatisticsInfo);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody MemberStatisticsInfo memberStatisticsInfo){
		LambdaQueryWrapper<MemberStatisticsInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberStatisticsInfo.getId() != null,MemberStatisticsInfo::getId,memberStatisticsInfo.getId());
		boolean ok = memberStatisticsInfoService.update(memberStatisticsInfo,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<MemberStatisticsInfo> getById(@RequestBody MemberStatisticsInfo memberStatisticsInfo){
		memberStatisticsInfo = memberStatisticsInfoService.getById(memberStatisticsInfo.getId());
		return memberStatisticsInfo != null ? R.success(memberStatisticsInfo) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<MemberStatisticsInfo>> page(@RequestBody MemberStatisticsInfo memberStatisticsInfo){
		IPage<MemberStatisticsInfo> iPage = new Page<>(memberStatisticsInfo.getPage(), memberStatisticsInfo.getPageSize());
		LambdaQueryWrapper<MemberStatisticsInfo> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberStatisticsInfo.getId() != null,MemberStatisticsInfo::getId,memberStatisticsInfo.getId());
		wrapper.eq(memberStatisticsInfo.getMemberId() != null,MemberStatisticsInfo::getMemberId,memberStatisticsInfo.getMemberId());
		wrapper.eq(memberStatisticsInfo.getConsumeAmount() != null,MemberStatisticsInfo::getConsumeAmount,memberStatisticsInfo.getConsumeAmount());
		wrapper.eq(memberStatisticsInfo.getCouponAmount() != null,MemberStatisticsInfo::getCouponAmount,memberStatisticsInfo.getCouponAmount());
		wrapper.eq(memberStatisticsInfo.getOrderCount() != null,MemberStatisticsInfo::getOrderCount,memberStatisticsInfo.getOrderCount());
		wrapper.eq(memberStatisticsInfo.getCouponCount() != null,MemberStatisticsInfo::getCouponCount,memberStatisticsInfo.getCouponCount());
		wrapper.eq(memberStatisticsInfo.getCommentCount() != null,MemberStatisticsInfo::getCommentCount,memberStatisticsInfo.getCommentCount());
		wrapper.eq(memberStatisticsInfo.getReturnOrderCount() != null,MemberStatisticsInfo::getReturnOrderCount,memberStatisticsInfo.getReturnOrderCount());
		wrapper.eq(memberStatisticsInfo.getLoginCount() != null,MemberStatisticsInfo::getLoginCount,memberStatisticsInfo.getLoginCount());
		wrapper.eq(memberStatisticsInfo.getAttendCount() != null,MemberStatisticsInfo::getAttendCount,memberStatisticsInfo.getAttendCount());
		wrapper.eq(memberStatisticsInfo.getFansCount() != null,MemberStatisticsInfo::getFansCount,memberStatisticsInfo.getFansCount());
		wrapper.eq(memberStatisticsInfo.getCollectProductCount() != null,MemberStatisticsInfo::getCollectProductCount,memberStatisticsInfo.getCollectProductCount());
		wrapper.eq(memberStatisticsInfo.getCollectSubjectCount() != null,MemberStatisticsInfo::getCollectSubjectCount,memberStatisticsInfo.getCollectSubjectCount());
		wrapper.eq(memberStatisticsInfo.getCollectCommentCount() != null,MemberStatisticsInfo::getCollectCommentCount,memberStatisticsInfo.getCollectCommentCount());
		wrapper.eq(memberStatisticsInfo.getInviteFriendCount() != null,MemberStatisticsInfo::getInviteFriendCount,memberStatisticsInfo.getInviteFriendCount());

		memberStatisticsInfoService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
