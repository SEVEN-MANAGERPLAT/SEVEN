package com.seven.aemp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事务管理
@EnableTransactionManagement
//扫描mapper
@MapperScan("com.seven.aemp.dao")
public class SevenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SevenApplication.class, args);
    }

}
