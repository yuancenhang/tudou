
package com.hang.tudou.tudoumember.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoumember.entity.MemberLoginLog;
import com.hang.tudou.tudoumember.mapper.MemberLoginLogMapper;
import com.hang.tudou.tudoumember.service.MemberLoginLogService;

@Service
public class MemberLoginLogServiceImpl extends ServiceImpl<MemberLoginLogMapper,MemberLoginLog> implements MemberLoginLogService {

	@Autowired
	MemberLoginLogMapper memberLoginLogMapper;

}