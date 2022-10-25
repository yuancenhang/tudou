
package com.hang.tudou.tudoucoupon.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoucoupon.entity.SkuLadder;
import com.hang.tudou.tudoucoupon.mapper.SkuLadderMapper;
import com.hang.tudou.tudoucoupon.service.SkuLadderService;

@Service
public class SkuLadderServiceImpl extends ServiceImpl<SkuLadderMapper,SkuLadder> implements SkuLadderService {

	@Autowired
	SkuLadderMapper skuLadderMapper;

}