
package com.hang.tudou.tudouorder.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class MyPage {

    @TableField(exist = false)
    Integer page;

    @TableField(exist = false)
    Integer pageSize;
}

