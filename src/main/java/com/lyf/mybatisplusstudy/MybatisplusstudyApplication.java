package com.lyf.mybatisplusstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


//@SpringBootApplication
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.lyf.mybatisplusstudy.sys.mapper")
public class MybatisplusstudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisplusstudyApplication.class, args);
    }
}
