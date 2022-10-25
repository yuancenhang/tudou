
package com.hang.tudou.tudoumember.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("ums_growth_change_history")
public class GrowthChangeHistory extends MyPage{

	//id
	private Long id;

	//member_id
	private Long memberId;

	//create_time
	private LocalDateTime createTime;

	//改变的值（正负计数）
	private Integer changeCount;

	//备注
	private String note;

	//积分来源[0-购物，1-管理员修改]
	private Integer sourceType;



}
