package com.hang.tudou.tudouproduct;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hang.tudou.tudouproduct.mapper")
public class TudouProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(TudouProductApplication.class, args);
    }

}
