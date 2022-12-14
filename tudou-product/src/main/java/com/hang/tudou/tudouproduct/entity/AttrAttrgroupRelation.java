
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("pms_attr_attrgroup_relation")
public class AttrAttrgroupRelation extends MyPage {

	//id
	@TableId
	private Long id;

	//属性id
	private Long attrId;

	//属性分组id
	private Long attrGroupId;

	//属性组内排序
	private Integer attrSort;



}
