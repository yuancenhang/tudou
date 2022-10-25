
package com.hang.tudou.tudouorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouorder.entity.OrderReturnApply;
import com.hang.tudou.tudouorder.mapper.OrderReturnApplyMapper;
import com.hang.tudou.tudouorder.service.OrderReturnApplyService;

@Service
public class OrderReturnApplyServiceImpl extends ServiceImpl<OrderReturnApplyMapper,OrderReturnApply> implements OrderReturnApplyService {

	@Autowired
	OrderReturnApplyMapper orderReturnApplyMapper;

}