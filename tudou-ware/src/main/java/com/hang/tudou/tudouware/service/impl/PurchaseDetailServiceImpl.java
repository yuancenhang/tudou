
package com.hang.tudou.tudouware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouware.entity.PurchaseDetail;
import com.hang.tudou.tudouware.mapper.PurchaseDetailMapper;
import com.hang.tudou.tudouware.service.PurchaseDetailService;

@Service
public class PurchaseDetailServiceImpl extends ServiceImpl<PurchaseDetailMapper,PurchaseDetail> implements PurchaseDetailService {

	@Autowired
	PurchaseDetailMapper purchaseDetailMapper;

}