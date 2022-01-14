package com.moyu.myadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@EnableWebMvc
@SpringBootApplication
public class MyAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyAdminApplication.class, args);
    }

}
