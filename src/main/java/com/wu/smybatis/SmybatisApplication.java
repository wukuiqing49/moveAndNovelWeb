package com.wu.smybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//表示扫描包下的所有mapper
//@MapperScan("com.wu.smybatis.mapper")
@SpringBootApplication
public class SmybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmybatisApplication.class, args);
        String path= System.getProperty("user.dir");
        System.out.println("项目路径:"+path);
    }

}
