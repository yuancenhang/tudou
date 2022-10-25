
package com.hang.tudou.tudouorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouorder.entity.OrderOperateHistory;
import com.hang.tudou.tudouorder.mapper.OrderOperateHistoryMapper;
import com.hang.tudou.tudouorder.service.OrderOperateHistoryService;

@Service
public class OrderOperateHistoryServiceImpl extends ServiceImpl<OrderOperateHistoryMapper,OrderOperateHistory> implements OrderOperateHistoryService {

	@Autowired
	OrderOperateHistoryMapper orderOperateHistoryMapper;

}