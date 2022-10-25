
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouproduct.entity.R;
import com.hang.tudou.tudouproduct.service.SpuCommentService;
import com.hang.tudou.tudouproduct.entity.SpuComment;

@RestController
@RequestMapping("/spuComment")
public class SpuCommentController {

	@Autowired
	SpuCommentService spuCommentService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody SpuComment spuComment){
		boolean ok = spuCommentService.save(spuComment);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody SpuComment spuComment){
		boolean ok = spuCommentService.removeById(spuComment);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody SpuComment spuComment){
		LambdaQueryWrapper<SpuComment> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuComment.getId() != null,SpuComment::getId,spuComment.getId());
		boolean ok = spuCommentService.update(spuComment,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<SpuComment> getById(@RequestBody SpuComment spuComment){
		spuComment = spuCommentService.getById(spuComment.getId());
		return spuComment != null ? R.success(spuComment) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<SpuComment>> page(@RequestBody SpuComment spuComment){
		IPage<SpuComment> iPage = new Page<>(spuComment.getPage(), spuComment.getPageSize());
		LambdaQueryWrapper<SpuComment> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(spuComment.getId() != null,SpuComment::getId,spuComment.getId());
		wrapper.eq(spuComment.getSkuId() != null,SpuComment::getSkuId,spuComment.getSkuId());
		wrapper.eq(spuComment.getSpuId() != null,SpuComment::getSpuId,spuComment.getSpuId());
		wrapper.eq(spuComment.getSpuName() != null,SpuComment::getSpuName,spuComment.getSpuName());
		wrapper.eq(spuComment.getMemberNickName() != null,SpuComment::getMemberNickName,spuComment.getMemberNickName());
		wrapper.eq(spuComment.getStar() != null,SpuComment::getStar,spuComment.getStar());
		wrapper.eq(spuComment.getMemberIp() != null,SpuComment::getMemberIp,spuComment.getMemberIp());
		wrapper.eq(spuComment.getCreateTime() != null,SpuComment::getCreateTime,spuComment.getCreateTime());
		wrapper.eq(spuComment.getShowStatus() != null,SpuComment::getShowStatus,spuComment.getShowStatus());
		wrapper.eq(spuComment.getSpuAttributes() != null,SpuComment::getSpuAttributes,spuComment.getSpuAttributes());
		wrapper.eq(spuComment.getLikesCount() != null,SpuComment::getLikesCount,spuComment.getLikesCount());
		wrapper.eq(spuComment.getReplyCount() != null,SpuComment::getReplyCount,spuComment.getReplyCount());
		wrapper.eq(spuComment.getResources() != null,SpuComment::getResources,spuComment.getResources());
		wrapper.eq(spuComment.getContent() != null,SpuComment::getContent,spuComment.getContent());
		wrapper.eq(spuComment.getMemberIcon() != null,SpuComment::getMemberIcon,spuComment.getMemberIcon());
		wrapper.eq(spuComment.getCommentType() != null,SpuComment::getCommentType,spuComment.getCommentType());

		spuCommentService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
