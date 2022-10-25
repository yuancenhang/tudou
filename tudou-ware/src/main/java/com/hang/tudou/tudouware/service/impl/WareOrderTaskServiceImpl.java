
package com.hang.tudou.tudouware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouware.entity.WareOrderTask;
import com.hang.tudou.tudouware.mapper.WareOrderTaskMapper;
import com.hang.tudou.tudouware.service.WareOrderTaskService;

@Service
public class WareOrderTaskServiceImpl extends ServiceImpl<WareOrderTaskMapper,WareOrderTask> implements WareOrderTaskService {

	@Autowired
	WareOrderTaskMapper wareOrderTaskMapper;

}