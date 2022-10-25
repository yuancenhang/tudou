
package com.hang.tudou.tudouware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouware.entity.WareInfo;
import com.hang.tudou.tudouware.mapper.WareInfoMapper;
import com.hang.tudou.tudouware.service.WareInfoService;

@Service
public class WareInfoServiceImpl extends ServiceImpl<WareInfoMapper,WareInfo> implements WareInfoService {

	@Autowired
	WareInfoMapper wareInfoMapper;

}