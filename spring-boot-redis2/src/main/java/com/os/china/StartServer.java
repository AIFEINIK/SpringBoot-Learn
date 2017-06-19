package com.os.china;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class StartServer {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(StartServer.class);
        app.run(args);
    }
}
