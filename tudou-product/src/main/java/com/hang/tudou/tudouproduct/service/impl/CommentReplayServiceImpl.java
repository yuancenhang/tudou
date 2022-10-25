
package com.hang.tudou.tudouproduct.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouproduct.entity.CommentReplay;
import com.hang.tudou.tudouproduct.mapper.CommentReplayMapper;
import com.hang.tudou.tudouproduct.service.CommentReplayService;

@Service
public class CommentReplayServiceImpl extends ServiceImpl<CommentReplayMapper,CommentReplay> implements CommentReplayService {

	@Autowired
	CommentReplayMapper commentReplayMapper;

}