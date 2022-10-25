
package com.hang.tudou.tudoumember.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

/**
 * 这个类是自动为实体类赋值用的。
 * 你需要在实体类中的公共字段上加注解，指明是什么时机赋值，如insert代表新增时赋值，update表示更新时赋值
 */

@Component
public class MetaHandler implements MetaObjectHandler {

    /*
     * 这个方法会在insert操作时为变量赋值
     * @TableField(fill = FieldFill.INSERT)
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        String[] strings = metaObject.getGetterNames();
        for (String s : strings){
            if (s.equals("createTime")) metaObject.setValue("createTime", LocalDateTime.now());
        }
    }

    /*
     * 这个方法会在update操作时为变量赋值
     * @TableField(fill = FieldFill.UPDATE)
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        String[] strings = metaObject.getGetterNames();
        for (String s : strings) {
            if (s.equals("updateTime")) metaObject.setValue("updateTime", LocalDateTime.now());
        }
    }
}

