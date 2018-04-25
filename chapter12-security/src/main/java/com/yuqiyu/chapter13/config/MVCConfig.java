package com.yuqiyu.chapter13.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/18
 * Time：23:10
 * 码云：http://git.oschina.net/jnyqy
 *
 * 简单的SpringBoot内的MVC控制器跳转
 *
 * MVCConfig配置类继承WebMvcConfigurerAdapter类，重写addViewControllers()方法添加路径访问，可以通过Get形式的/login访问到我们的login.jsp
 * ========================
 */
@Configuration
public class MVCConfig extends WebMvcConfigurationSupport
{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main").setViewName("main");
    }
}
