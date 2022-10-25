
package com.hang.tudou.tudouware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouware.entity.WareOrderTaskDetail;
import com.hang.tudou.tudouware.mapper.WareOrderTaskDetailMapper;
import com.hang.tudou.tudouware.service.WareOrderTaskDetailService;

@Service
public class WareOrderTaskDetailServiceImpl extends ServiceImpl<WareOrderTaskDetailMapper,WareOrderTaskDetail> implements WareOrderTaskDetailService {

	@Autowired
	WareOrderTaskDetailMapper wareOrderTaskDetailMapper;

}