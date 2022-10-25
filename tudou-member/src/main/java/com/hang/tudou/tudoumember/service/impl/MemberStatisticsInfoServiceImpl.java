
package com.hang.tudou.tudoumember.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoumember.entity.MemberStatisticsInfo;
import com.hang.tudou.tudoumember.mapper.MemberStatisticsInfoMapper;
import com.hang.tudou.tudoumember.service.MemberStatisticsInfoService;

@Service
public class MemberStatisticsInfoServiceImpl extends ServiceImpl<MemberStatisticsInfoMapper,MemberStatisticsInfo> implements MemberStatisticsInfoService {

	@Autowired
	MemberStatisticsInfoMapper memberStatisticsInfoMapper;

}