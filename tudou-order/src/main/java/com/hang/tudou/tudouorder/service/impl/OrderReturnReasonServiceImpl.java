
package com.hang.tudou.tudouorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouorder.entity.OrderReturnReason;
import com.hang.tudou.tudouorder.mapper.OrderReturnReasonMapper;
import com.hang.tudou.tudouorder.service.OrderReturnReasonService;

@Service
public class OrderReturnReasonServiceImpl extends ServiceImpl<OrderReturnReasonMapper,OrderReturnReason> implements OrderReturnReasonService {

	@Autowired
	OrderReturnReasonMapper orderReturnReasonMapper;

}