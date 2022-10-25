
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.SpuComment;
import com.hang.tudou.tudouproduct.mapper.SpuCommentMapper;
import com.hang.tudou.tudouproduct.service.SpuCommentService;

@Service
public class SpuCommentServiceImpl extends ServiceImpl<SpuCommentMapper,SpuComment> implements SpuCommentService {

	@Autowired
	SpuCommentMapper spuCommentMapper;

}