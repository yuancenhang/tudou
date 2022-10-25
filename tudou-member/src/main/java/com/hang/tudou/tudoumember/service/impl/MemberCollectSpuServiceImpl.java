
package com.hang.tudou.tudoumember.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoumember.entity.MemberCollectSpu;
import com.hang.tudou.tudoumember.mapper.MemberCollectSpuMapper;
import com.hang.tudou.tudoumember.service.MemberCollectSpuService;

@Service
public class MemberCollectSpuServiceImpl extends ServiceImpl<MemberCollectSpuMapper,MemberCollectSpu> implements MemberCollectSpuService {

	@Autowired
	MemberCollectSpuMapper memberCollectSpuMapper;

}