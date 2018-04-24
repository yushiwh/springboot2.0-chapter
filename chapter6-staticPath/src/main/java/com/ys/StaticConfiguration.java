package com.ys;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/11
 * Time：20:55
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Configuration
public class StaticConfiguration extends WebMvcConfigurationSupport {
    //自定义静态资源文件路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //前面随意配置地址，影藏真实的地址
        //http://127.0.0.1:8080/ys/1233/resources/imgs/t.png  实际访问是 http://127.0.0.1:8080/imgs/t.png
        registry.addResourceHandler("/ys/123/resources/**").addResourceLocations("classpath:/static/");
    }
}
