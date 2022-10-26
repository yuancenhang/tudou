package com.hang.tudou.tudouware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hang.tudou.tudouware.mapper")
public class TudouWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(TudouWareApplication.class, args);
    }

}
