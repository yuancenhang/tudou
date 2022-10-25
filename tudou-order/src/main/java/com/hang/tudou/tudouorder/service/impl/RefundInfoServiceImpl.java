
package com.hang.tudou.tudouorder.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouorder.entity.RefundInfo;
import com.hang.tudou.tudouorder.mapper.RefundInfoMapper;
import com.hang.tudou.tudouorder.service.RefundInfoService;

@Service
public class RefundInfoServiceImpl extends ServiceImpl<RefundInfoMapper,RefundInfo> implements RefundInfoService {

	@Autowired
	RefundInfoMapper refundInfoMapper;

}