
package com.hang.tudou.tudoumember.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoumember.entity.GrowthChangeHistory;
import com.hang.tudou.tudoumember.mapper.GrowthChangeHistoryMapper;
import com.hang.tudou.tudoumember.service.GrowthChangeHistoryService;

@Service
public class GrowthChangeHistoryServiceImpl extends ServiceImpl<GrowthChangeHistoryMapper,GrowthChangeHistory> implements GrowthChangeHistoryService {

	@Autowired
	GrowthChangeHistoryMapper growthChangeHistoryMapper;

}