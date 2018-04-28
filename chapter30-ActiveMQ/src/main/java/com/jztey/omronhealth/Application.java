package com.jztey.omronhealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication

/**
 * @author yushi
 */
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
