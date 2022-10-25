
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.AttrAttrgroupRelation;
import com.hang.tudou.tudouproduct.mapper.AttrAttrgroupRelationMapper;
import com.hang.tudou.tudouproduct.service.AttrAttrgroupRelationService;

@Service
public class AttrAttrgroupRelationServiceImpl extends ServiceImpl<AttrAttrgroupRelationMapper,AttrAttrgroupRelation> implements AttrAttrgroupRelationService {

	@Autowired
	AttrAttrgroupRelationMapper attrAttrgroupRelationMapper;

}