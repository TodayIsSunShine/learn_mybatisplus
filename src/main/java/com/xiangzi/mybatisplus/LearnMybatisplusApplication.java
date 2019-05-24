package com.xiangzi.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.xiangzi.mybatisplus.dao")
public class LearnMybatisplusApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnMybatisplusApplication.class, args);
    }

}
