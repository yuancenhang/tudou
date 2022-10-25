
package com.hang.tudou.tudouorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouorder.entity.Order;
import com.hang.tudou.tudouorder.mapper.OrderMapper;
import com.hang.tudou.tudouorder.service.OrderService;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper,Order> implements OrderService {

	@Autowired
	OrderMapper orderMapper;

}