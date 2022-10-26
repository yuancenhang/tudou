package com.hang.tudou.tudoucoupon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.hang.tudou.tudoucoupon.mapper")
public class TudouCouponApplication {

    public static void main(String[] args) {
        SpringApplication.run(TudouCouponApplication.class, args);
    }

}
