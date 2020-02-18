package com.bbdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bbdemo.mapper")
public class BbdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BbdemoApplication.class, args);
    }

}
