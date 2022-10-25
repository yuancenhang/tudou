
package com.hang.tudou.tudoumember.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoumember.entity.MemberCollectSubject;
import com.hang.tudou.tudoumember.mapper.MemberCollectSubjectMapper;
import com.hang.tudou.tudoumember.service.MemberCollectSubjectService;

@Service
public class MemberCollectSubjectServiceImpl extends ServiceImpl<MemberCollectSubjectMapper,MemberCollectSubject> implements MemberCollectSubjectService {

	@Autowired
	MemberCollectSubjectMapper memberCollectSubjectMapper;

}