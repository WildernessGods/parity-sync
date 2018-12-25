package com.parity.paritysync;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.parity.paritysync.dao")
public class ParitySyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParitySyncApplication.class, args);
    }
}
