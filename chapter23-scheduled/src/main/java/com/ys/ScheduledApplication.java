package com.ys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableScheduling//开启定时任务
public class ScheduledApplication {

    @Bean
    public WebMvcConfigurer corsConfigurer() { // 允许跨域
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "DELETE", "PUT", "GET",
                        "OPTIONS");
            }
        };
    }


    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class, args);
    }
}
