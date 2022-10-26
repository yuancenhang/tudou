
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

@Data
@TableName("sms_home_subject")
public class HomeSubject extends MyPage {

	//id
	@TableId
	private Long id;

	//专题名字
	private String name;

	//专题标题
	private String title;

	//专题副标题
	private String subTitle;

	//显示状态
	private Integer status;

	//详情连接
	private String url;

	//排序
	private Integer sort;

	//专题图片地址
	private String img;



}
