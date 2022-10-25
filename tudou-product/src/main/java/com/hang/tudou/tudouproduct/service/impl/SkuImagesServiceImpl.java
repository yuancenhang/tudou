
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.SkuImages;
import com.hang.tudou.tudouproduct.mapper.SkuImagesMapper;
import com.hang.tudou.tudouproduct.service.SkuImagesService;

@Service
public class SkuImagesServiceImpl extends ServiceImpl<SkuImagesMapper,SkuImages> implements SkuImagesService {

	@Autowired
	SkuImagesMapper skuImagesMapper;

}