
package com.hang.tudou.tudouware.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("undo_log")
public class UndoLog extends MyPage {

	//
	@TableId
	private Long id;

	//
	private Long branchId;

	//
	private String xid;

	//
	private String context;

	//
	private Integer rollbackInfo;

	//
	private Integer logStatus;

	//
	private LocalDateTime logCreated;

	//
	private LocalDateTime logModified;

	//
	private String ext;



}
