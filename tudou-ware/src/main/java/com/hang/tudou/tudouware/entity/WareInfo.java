
package com.hang.tudou.tudouware.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("wms_ware_info")
public class WareInfo extends MyPage{

	//id
	private Long id;

	//仓库名
	private String name;

	//仓库地址
	private String address;

	//区域编码
	private String areacode;



}
