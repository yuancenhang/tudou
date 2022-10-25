
package com.hang.tudou.tudouorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouorder.entity.OrderItem;
import com.hang.tudou.tudouorder.mapper.OrderItemMapper;
import com.hang.tudou.tudouorder.service.OrderItemService;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper,OrderItem> implements OrderItemService {

	@Autowired
	OrderItemMapper orderItemMapper;

}