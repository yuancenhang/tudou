
package com.hang.tudou.tudouware.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hang.tudou.tudouware.entity.R;
import com.hang.tudou.tudouware.service.PurchaseDetailService;
import com.hang.tudou.tudouware.entity.PurchaseDetail;

@RestController
@RequestMapping("/purchaseDetail")
public class PurchaseDetailController {

	@Autowired
	PurchaseDetailService purchaseDetailService;

	/*
	新增操作
	自动生成,请检查,优化
	 */
	@PostMapping
	public R<String> save(@RequestBody PurchaseDetail purchaseDetail){
		boolean ok = purchaseDetailService.save(purchaseDetail);
		return ok ? R.success("保存成功") : R.error("保存失败");
	}

	/*
	根据id删除
	自动生成,请检查,优化
	 */
	@DeleteMapping
	public R<String> removeById(@RequestBody PurchaseDetail purchaseDetail){
		boolean ok = purchaseDetailService.removeById(purchaseDetail);
		return ok ? R.success("删除成功") : R.error("删除失败");
	}

	/*
	更新操作
	自动生成,请检查,优化
	 */
	@PutMapping
	public R<String> update(@RequestBody PurchaseDetail purchaseDetail){
		LambdaQueryWrapper<PurchaseDetail> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(purchaseDetail.getId() != null,PurchaseDetail::getId,purchaseDetail.getId());
		boolean ok = purchaseDetailService.update(purchaseDetail,wrapper);
		return ok ? R.success("更新成功") : R.error("更新失败");
	}

	/*
	根据id查询
	自动生成,请检查,优化
	 */
	@GetMapping("/get")
	public R<PurchaseDetail> getById(@RequestBody PurchaseDetail purchaseDetail){
		purchaseDetail = purchaseDetailService.getById(purchaseDetail.getId());
		return purchaseDetail != null ? R.success(purchaseDetail) : R.error("没有查到任何数据");
	}

	/*
	动态条件查询
	自动生成,请检查,优化
	 */
	@GetMapping("/page")
	public R<IPage<PurchaseDetail>> page(@RequestBody PurchaseDetail purchaseDetail){
		IPage<PurchaseDetail> iPage = new Page<>(purchaseDetail.getPage(), purchaseDetail.getPageSize());
		LambdaQueryWrapper<PurchaseDetail> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(purchaseDetail.getId() != null,PurchaseDetail::getId,purchaseDetail.getId());
		wrapper.eq(purchaseDetail.getPurchaseId() != null,PurchaseDetail::getPurchaseId,purchaseDetail.getPurchaseId());
		wrapper.eq(purchaseDetail.getSkuId() != null,PurchaseDetail::getSkuId,purchaseDetail.getSkuId());
		wrapper.eq(purchaseDetail.getSkuNum() != null,PurchaseDetail::getSkuNum,purchaseDetail.getSkuNum());
		wrapper.eq(purchaseDetail.getSkuPrice() != null,PurchaseDetail::getSkuPrice,purchaseDetail.getSkuPrice());
		wrapper.eq(purchaseDetail.getWareId() != null,PurchaseDetail::getWareId,purchaseDetail.getWareId());
		wrapper.eq(purchaseDetail.getStatus() != null,PurchaseDetail::getStatus,purchaseDetail.getStatus());

		purchaseDetailService.page(iPage,wrapper);
		return iPage.getRecords().isEmpty() ? R.error("没有查到任何数据") : R.success(iPage);
	}

}
