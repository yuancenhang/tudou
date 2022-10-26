
package com.hang.tudou.tudoumember.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("ums_member_collect_subject")
public class MemberCollectSubject extends MyPage {

	//id
	@TableId
	private Long id;

	//subject_id
	private Long subjectId;

	//subject_name
	private String subjectName;

	//subject_img
	private String subjectImg;

	//活动url
	private String subjectUrll;



}
