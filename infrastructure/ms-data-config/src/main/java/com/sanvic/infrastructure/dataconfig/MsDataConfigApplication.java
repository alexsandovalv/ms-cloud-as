package com.sanvic.infrastructure.dataconfig;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableConfigServer
@SpringBootApplication
public class MsDataConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsDataConfigApplication.class, args);
    }

}
