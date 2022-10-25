
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.Attr;
import com.hang.tudou.tudouproduct.mapper.AttrMapper;
import com.hang.tudou.tudouproduct.service.AttrService;

@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper,Attr> implements AttrService {

	@Autowired
	AttrMapper attrMapper;

}