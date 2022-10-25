
package com.hang.tudou.tudouorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouorder.entity.PaymentInfo;
import com.hang.tudou.tudouorder.mapper.PaymentInfoMapper;
import com.hang.tudou.tudouorder.service.PaymentInfoService;

@Service
public class PaymentInfoServiceImpl extends ServiceImpl<PaymentInfoMapper,PaymentInfo> implements PaymentInfoService {

	@Autowired
	PaymentInfoMapper paymentInfoMapper;

}