
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.SpuImages;
import com.hang.tudou.tudouproduct.mapper.SpuImagesMapper;
import com.hang.tudou.tudouproduct.service.SpuImagesService;

@Service
public class SpuImagesServiceImpl extends ServiceImpl<SpuImagesMapper,SpuImages> implements SpuImagesService {

	@Autowired
	SpuImagesMapper spuImagesMapper;

}