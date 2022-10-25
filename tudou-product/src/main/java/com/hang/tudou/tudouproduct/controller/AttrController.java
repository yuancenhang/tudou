
package com.hang.tudou.tudouproduct.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouproduct.entity.R;
import com.hang.tudou.tudouproduct.service.AttrService;
import com.hang.tudou.tudouproduct.entity.Attr;

@RestController
@RequestMapping("/attr")
public class AttrController {

	@Autowired
	AttrService attrService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody Attr attr){
		boolean ok = attrService.save(attr);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody Attr attr){
		boolean ok = attrService.removeById(attr);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody Attr attr){
		LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(attr.getAttrId() != null,Attr::getAttrId,attr.getAttrId());
		boolean ok = attrService.update(attr,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<Attr> getById(@RequestBody Attr attr){
		attr = attrService.getById(attr.getAttrId());
		return attr != null ? R.success(attr) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<Attr>> page(@RequestBody Attr attr){
		IPage<Attr> iPage = new Page<>(attr.getPage(), attr.getPageSize());
		LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(attr.getAttrId() != null,Attr::getAttrId,attr.getAttrId());
		wrapper.eq(attr.getAttrName() != null,Attr::getAttrName,attr.getAttrName());
		wrapper.eq(attr.getSearchType() != null,Attr::getSearchType,attr.getSearchType());
		wrapper.eq(attr.getIcon() != null,Attr::getIcon,attr.getIcon());
		wrapper.eq(attr.getValueSelect() != null,Attr::getValueSelect,attr.getValueSelect());
		wrapper.eq(attr.getAttrType() != null,Attr::getAttrType,attr.getAttrType());
		wrapper.eq(attr.getEnable() != null,Attr::getEnable,attr.getEnable());
		wrapper.eq(attr.getCatelogId() != null,Attr::getCatelogId,attr.getCatelogId());
		wrapper.eq(attr.getShowDesc() != null,Attr::getShowDesc,attr.getShowDesc());

		attrService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
