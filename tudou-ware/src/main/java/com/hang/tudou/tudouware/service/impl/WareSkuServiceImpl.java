
package com.hang.tudou.tudouware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouware.entity.WareSku;
import com.hang.tudou.tudouware.mapper.WareSkuMapper;
import com.hang.tudou.tudouware.service.WareSkuService;

@Service
public class WareSkuServiceImpl extends ServiceImpl<WareSkuMapper,WareSku> implements WareSkuService {

	@Autowired
	WareSkuMapper wareSkuMapper;

}