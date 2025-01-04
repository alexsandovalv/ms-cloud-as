package com.sanvic.infrastructure.serverconfig;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableConfigServer
@SpringBootApplication
public class MsServerConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsServerConfigApplication.class, args);
    }

}
