package com.parity.paritysync;

import com.parity.paritysync.controller.AuthorController;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.parity.paritysync.dao")
public class ParitySyncApplication {

    @Autowired
    AuthorController authorController;

    public static void main(String[] args) {
        SpringApplication.run(ParitySyncApplication.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> timeRouter() {
        return route(GET("/author"), authorController::sendTimePerSec);
    }
}
