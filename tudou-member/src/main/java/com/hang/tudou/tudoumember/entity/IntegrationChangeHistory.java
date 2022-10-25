
package com.hang.tudou.tudoumember.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("ums_integration_change_history")
public class IntegrationChangeHistory extends MyPage{

	//id
	private Long id;

	//member_id
	private Long memberId;

	//create_time
	private LocalDateTime createTime;

	//变化的值
	private Integer changeCount;

	//备注
	private String note;

	//来源[0->购物；1->管理员修改;2->活动]
	private Integer sourceTyoe;



}
