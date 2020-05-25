package com.hhtt.blog;

import com.hhtt.blog.config.InitMg;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@MapperScan("com.hhtt.blog.mapper")
public class BlogApplication {


    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }



}
