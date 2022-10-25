
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.AttrGroup;
import com.hang.tudou.tudouproduct.mapper.AttrGroupMapper;
import com.hang.tudou.tudouproduct.service.AttrGroupService;

@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper,AttrGroup> implements AttrGroupService {

	@Autowired
	AttrGroupMapper attrGroupMapper;

}