
package com.hang.tudou.tudoumember.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("ums_member_collect_spu")
public class MemberCollectSpu extends MyPage {

	//id
	@TableId
	private Long id;

	//会员id
	private Long memberId;

	//spu_id
	private Long spuId;

	//spu_name
	private String spuName;

	//spu_img
	private String spuImg;

	//create_time
	private LocalDateTime createTime;



}
