package com.hang.tudou.tudouorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hang.tudou.tudouorder.mapper")
public class TudouOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(TudouOrderApplication.class, args);
    }

}
