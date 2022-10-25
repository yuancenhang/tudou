
package com.hang.tudou.tudouorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouorder.entity.OrderSetting;
import com.hang.tudou.tudouorder.mapper.OrderSettingMapper;
import com.hang.tudou.tudouorder.service.OrderSettingService;

@Service
public class OrderSettingServiceImpl extends ServiceImpl<OrderSettingMapper,OrderSetting> implements OrderSettingService {

	@Autowired
	OrderSettingMapper orderSettingMapper;

}