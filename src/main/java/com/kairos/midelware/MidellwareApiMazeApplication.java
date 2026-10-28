package com.kairos.midelware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MidellwareApiMazeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MidellwareApiMazeApplication.class, args);
    }

}
