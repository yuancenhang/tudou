
package com.hang.tudou.tudoumember.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoumember.entity.IntegrationChangeHistory;
import com.hang.tudou.tudoumember.mapper.IntegrationChangeHistoryMapper;
import com.hang.tudou.tudoumember.service.IntegrationChangeHistoryService;

@Service
public class IntegrationChangeHistoryServiceImpl extends ServiceImpl<IntegrationChangeHistoryMapper,IntegrationChangeHistory> implements IntegrationChangeHistoryService {

	@Autowired
	IntegrationChangeHistoryMapper integrationChangeHistoryMapper;

}