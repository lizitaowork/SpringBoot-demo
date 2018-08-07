package com.example.springboottoken;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.springboottoken.dao")
public class SpringBootTokenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTokenApplication.class, args);
    }
}
