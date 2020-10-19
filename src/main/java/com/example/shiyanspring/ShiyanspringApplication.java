package com.example.shiyanspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//使用定时任务时添加@EnableScheduling
//@EnableScheduling
public class ShiyanspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiyanspringApplication.class, args);
    }

}
