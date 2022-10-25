
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouproduct.entity.R;
import com.hang.tudou.tudouproduct.service.CommentReplayService;
import com.hang.tudou.tudouproduct.entity.CommentReplay;

@RestController
@RequestMapping("/commentReplay")
public class CommentReplayController {

	@Autowired
	CommentReplayService commentReplayService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody CommentReplay commentReplay){
		boolean ok = commentReplayService.save(commentReplay);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody CommentReplay commentReplay){
		boolean ok = commentReplayService.removeById(commentReplay);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody CommentReplay commentReplay){
		LambdaQueryWrapper<CommentReplay> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(commentReplay.getId() != null,CommentReplay::getId,commentReplay.getId());
		boolean ok = commentReplayService.update(commentReplay,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<CommentReplay> getById(@RequestBody CommentReplay commentReplay){
		commentReplay = commentReplayService.getById(commentReplay.getId());
		return commentReplay != null ? R.success(commentReplay) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<CommentReplay>> page(@RequestBody CommentReplay commentReplay){
		IPage<CommentReplay> iPage = new Page<>(commentReplay.getPage(), commentReplay.getPageSize());
		LambdaQueryWrapper<CommentReplay> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(commentReplay.getId() != null,CommentReplay::getId,commentReplay.getId());
		wrapper.eq(commentReplay.getCommentId() != null,CommentReplay::getCommentId,commentReplay.getCommentId());
		wrapper.eq(commentReplay.getReplyId() != null,CommentReplay::getReplyId,commentReplay.getReplyId());

		commentReplayService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
