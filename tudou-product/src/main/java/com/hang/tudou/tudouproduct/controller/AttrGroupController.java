
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouproduct.entity.R;
import com.hang.tudou.tudouproduct.service.AttrGroupService;
import com.hang.tudou.tudouproduct.entity.AttrGroup;

@RestController
@RequestMapping("/attrGroup")
public class AttrGroupController {

	@Autowired
	AttrGroupService attrGroupService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody AttrGroup attrGroup){
		boolean ok = attrGroupService.save(attrGroup);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody AttrGroup attrGroup){
		boolean ok = attrGroupService.removeById(attrGroup);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody AttrGroup attrGroup){
		LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(attrGroup.getAttrGroupId() != null,AttrGroup::getAttrGroupId,attrGroup.getAttrGroupId());
		boolean ok = attrGroupService.update(attrGroup,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<AttrGroup> getById(@RequestBody AttrGroup attrGroup){
		attrGroup = attrGroupService.getById(attrGroup.getAttrGroupId());
		return attrGroup != null ? R.success(attrGroup) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<AttrGroup>> page(@RequestBody AttrGroup attrGroup){
		IPage<AttrGroup> iPage = new Page<>(attrGroup.getPage(), attrGroup.getPageSize());
		LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(attrGroup.getAttrGroupId() != null,AttrGroup::getAttrGroupId,attrGroup.getAttrGroupId());
		wrapper.eq(attrGroup.getAttrGroupName() != null,AttrGroup::getAttrGroupName,attrGroup.getAttrGroupName());
		wrapper.eq(attrGroup.getSort() != null,AttrGroup::getSort,attrGroup.getSort());
		wrapper.eq(attrGroup.getDescript() != null,AttrGroup::getDescript,attrGroup.getDescript());
		wrapper.eq(attrGroup.getIcon() != null,AttrGroup::getIcon,attrGroup.getIcon());
		wrapper.eq(attrGroup.getCatelogId() != null,AttrGroup::getCatelogId,attrGroup.getCatelogId());

		attrGroupService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
