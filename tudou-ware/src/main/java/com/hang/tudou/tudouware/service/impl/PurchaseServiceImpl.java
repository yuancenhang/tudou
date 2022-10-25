
package com.hang.tudou.tudouware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouware.entity.Purchase;
import com.hang.tudou.tudouware.mapper.PurchaseMapper;
import com.hang.tudou.tudouware.service.PurchaseService;

@Service
public class PurchaseServiceImpl extends ServiceImpl<PurchaseMapper,Purchase> implements PurchaseService {

	@Autowired
	PurchaseMapper purchaseMapper;

}