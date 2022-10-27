package com.hang.tudou.tudougateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TudouGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TudouGatewayApplication.class, args);
    }

}
