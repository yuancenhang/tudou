package com.hang.tudou.tudouorder.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */

@Configuration
public class MybatisConfig{

    /**
     * 一个mybatisPlus的的拦截器
     * 启用IPage的分页功能
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        //创建一个mybatisPlus的的拦截器容器,本质是一个List
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //往拦截器里装一个分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return interceptor;
    }

}

