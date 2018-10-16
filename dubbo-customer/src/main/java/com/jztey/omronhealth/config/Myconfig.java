package com.jztey.omronhealth.config;


import com.jztey.omronhealth.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置类，进行new实例
 */
@Configuration
public class Myconfig {
    @Bean(name = "student")
    public Student getBean() {
        return new Student();
    }
}
