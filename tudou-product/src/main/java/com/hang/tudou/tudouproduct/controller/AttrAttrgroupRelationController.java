
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouproduct.entity.R;
import com.hang.tudou.tudouproduct.service.AttrAttrgroupRelationService;
import com.hang.tudou.tudouproduct.entity.AttrAttrgroupRelation;

@RestController
@RequestMapping("/attrAttrgroupRelation")
public class AttrAttrgroupRelationController {

	@Autowired
	AttrAttrgroupRelationService attrAttrgroupRelationService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation){
		boolean ok = attrAttrgroupRelationService.save(attrAttrgroupRelation);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation){
		boolean ok = attrAttrgroupRelationService.removeById(attrAttrgroupRelation);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation){
		LambdaQueryWrapper<AttrAttrgroupRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(attrAttrgroupRelation.getId() != null,AttrAttrgroupRelation::getId,attrAttrgroupRelation.getId());
		boolean ok = attrAttrgroupRelationService.update(attrAttrgroupRelation,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<AttrAttrgroupRelation> getById(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation){
		attrAttrgroupRelation = attrAttrgroupRelationService.getById(attrAttrgroupRelation.getId());
		return attrAttrgroupRelation != null ? R.success(attrAttrgroupRelation) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<AttrAttrgroupRelation>> page(@RequestBody AttrAttrgroupRelation attrAttrgroupRelation){
		IPage<AttrAttrgroupRelation> iPage = new Page<>(attrAttrgroupRelation.getPage(), attrAttrgroupRelation.getPageSize());
		LambdaQueryWrapper<AttrAttrgroupRelation> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(attrAttrgroupRelation.getId() != null,AttrAttrgroupRelation::getId,attrAttrgroupRelation.getId());
		wrapper.eq(attrAttrgroupRelation.getAttrId() != null,AttrAttrgroupRelation::getAttrId,attrAttrgroupRelation.getAttrId());
		wrapper.eq(attrAttrgroupRelation.getAttrGroupId() != null,AttrAttrgroupRelation::getAttrGroupId,attrAttrgroupRelation.getAttrGroupId());
		wrapper.eq(attrAttrgroupRelation.getAttrSort() != null,AttrAttrgroupRelation::getAttrSort,attrAttrgroupRelation.getAttrSort());

		attrAttrgroupRelationService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
