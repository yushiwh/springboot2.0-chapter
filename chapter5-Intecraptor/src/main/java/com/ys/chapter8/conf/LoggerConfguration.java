package com.ys.chapter8.conf;


import com.ys.chapter8.util.LoggerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：ys
 * Date：2018/4/10
 * Time：21:52
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Configuration
public class LoggerConfguration extends WebMvcConfigurationSupport
{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有的
        registry.addInterceptor(new LoggerInterceptor()).addPathPatterns("/**");
    }
}
