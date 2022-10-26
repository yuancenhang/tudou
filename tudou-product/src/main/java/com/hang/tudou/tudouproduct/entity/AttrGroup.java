
package com.hang.tudou.tudouproduct.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("pms_attr_group")
public class AttrGroup extends MyPage {

	//分组id
	@TableId
	private Long attrGroupId;

	//组名
	private Character attrGroupName;

	//排序
	private Integer sort;

	//描述
	private String descript;

	//组图标
	private String icon;

	//所属分类id
	private Long catelogId;



}
