
package com.hang.tudou.tudouware.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hang.tudou.tudouware.entity.UndoLog;
import com.hang.tudou.tudouware.mapper.UndoLogMapper;
import com.hang.tudou.tudouware.service.UndoLogService;

@Service
public class UndoLogServiceImpl extends ServiceImpl<UndoLogMapper,UndoLog> implements UndoLogService {

	@Autowired
	UndoLogMapper undoLogMapper;

}