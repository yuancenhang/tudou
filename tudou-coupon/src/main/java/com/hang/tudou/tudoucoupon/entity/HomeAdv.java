
package com.hang.tudou.tudoucoupon.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.hang.common.utils.MyPage;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("sms_home_adv")
public class HomeAdv extends MyPage {

	//id
	private Long id;

	//名字
	private String name;

	//图片地址
	private String pic;

	//开始时间
	private LocalDateTime startTime;

	//结束时间
	private LocalDateTime endTime;

	//状态
	private Integer status;

	//点击数
	private Integer clickCount;

	//广告详情连接地址
	private String url;

	//备注
	private String note;

	//排序
	private Integer sort;

	//发布者
	private Long publisherId;

	//审核者
	private Long authId;



}
