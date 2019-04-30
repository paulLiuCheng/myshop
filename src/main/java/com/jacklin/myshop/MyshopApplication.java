package com.jacklin.myshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.jacklin.myshop.mapper")
@SpringBootApplication
public class MyshopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyshopApplication.class, args);
    }

}
