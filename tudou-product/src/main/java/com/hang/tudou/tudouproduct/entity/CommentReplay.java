
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("pms_comment_replay")
public class CommentReplay extends MyPage {

	//id
	private Long id;

	//评论id
	private Long commentId;

	//回复id
	private Long replyId;



}
