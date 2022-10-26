package com.hang.tudou.tudoumember;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hang.tudou.tudoumember.mapper")
public class TudouMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(TudouMemberApplication.class, args);
    }

}
