
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("sms_home_subject_spu")
public class HomeSubjectSpu extends MyPage {

	//id
	@TableId
	private Long id;

	//专题名字
	private String name;

	//专题id
	private Long subjectId;

	//spu_id
	private Long spuId;

	//排序
	private Integer sort;



}
