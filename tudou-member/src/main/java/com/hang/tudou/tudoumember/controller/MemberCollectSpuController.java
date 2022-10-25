
package com.hang.tudou.tudoumember.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudoumember.entity.R;
import com.hang.tudou.tudoumember.service.MemberCollectSpuService;
import com.hang.tudou.tudoumember.entity.MemberCollectSpu;

@RestController
@RequestMapping("/memberCollectSpu")
public class MemberCollectSpuController {

	@Autowired
	MemberCollectSpuService memberCollectSpuService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody MemberCollectSpu memberCollectSpu){
		boolean ok = memberCollectSpuService.save(memberCollectSpu);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody MemberCollectSpu memberCollectSpu){
		boolean ok = memberCollectSpuService.removeById(memberCollectSpu);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody MemberCollectSpu memberCollectSpu){
		LambdaQueryWrapper<MemberCollectSpu> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberCollectSpu.getId() != null,MemberCollectSpu::getId,memberCollectSpu.getId());
		boolean ok = memberCollectSpuService.update(memberCollectSpu,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<MemberCollectSpu> getById(@RequestBody MemberCollectSpu memberCollectSpu){
		memberCollectSpu = memberCollectSpuService.getById(memberCollectSpu.getId());
		return memberCollectSpu != null ? R.success(memberCollectSpu) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<MemberCollectSpu>> page(@RequestBody MemberCollectSpu memberCollectSpu){
		IPage<MemberCollectSpu> iPage = new Page<>(memberCollectSpu.getPage(), memberCollectSpu.getPageSize());
		LambdaQueryWrapper<MemberCollectSpu> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(memberCollectSpu.getId() != null,MemberCollectSpu::getId,memberCollectSpu.getId());
		wrapper.eq(memberCollectSpu.getMemberId() != null,MemberCollectSpu::getMemberId,memberCollectSpu.getMemberId());
		wrapper.eq(memberCollectSpu.getSpuId() != null,MemberCollectSpu::getSpuId,memberCollectSpu.getSpuId());
		wrapper.eq(memberCollectSpu.getSpuName() != null,MemberCollectSpu::getSpuName,memberCollectSpu.getSpuName());
		wrapper.eq(memberCollectSpu.getSpuImg() != null,MemberCollectSpu::getSpuImg,memberCollectSpu.getSpuImg());
		wrapper.eq(memberCollectSpu.getCreateTime() != null,MemberCollectSpu::getCreateTime,memberCollectSpu.getCreateTime());

		memberCollectSpuService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
