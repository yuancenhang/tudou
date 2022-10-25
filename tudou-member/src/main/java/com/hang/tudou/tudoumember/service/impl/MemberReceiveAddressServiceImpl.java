
package com.hang.tudou.tudoumember.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudoumember.entity.MemberReceiveAddress;
import com.hang.tudou.tudoumember.mapper.MemberReceiveAddressMapper;
import com.hang.tudou.tudoumember.service.MemberReceiveAddressService;

@Service
public class MemberReceiveAddressServiceImpl extends ServiceImpl<MemberReceiveAddressMapper,MemberReceiveAddress> implements MemberReceiveAddressService {

	@Autowired
	MemberReceiveAddressMapper memberReceiveAddressMapper;

}