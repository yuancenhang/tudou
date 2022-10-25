
package com.hang.tudou.tudoumember.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoumember.entity.MemberLevel;
import com.hang.tudou.tudoumember.mapper.MemberLevelMapper;
import com.hang.tudou.tudoumember.service.MemberLevelService;

@Service
public class MemberLevelServiceImpl extends ServiceImpl<MemberLevelMapper,MemberLevel> implements MemberLevelService {

	@Autowired
	MemberLevelMapper memberLevelMapper;

}