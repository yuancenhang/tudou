
package com.hang.tudou.tudoumember.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("ums_member_login_log")
public class MemberLoginLog extends MyPage {

	//id
	private Long id;

	//member_id
	private Long memberId;

	//创建时间
	private LocalDateTime createTime;

	//ip
	private String ip;

	//city
	private String city;

	//登录类型[1-web，2-app]
	private Integer loginType;



}
