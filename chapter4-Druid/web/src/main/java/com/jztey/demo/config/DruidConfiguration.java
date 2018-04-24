/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: DruidConfiguration
 * Author:   yushi
 * Date:     2018/4/23 15:20
 * Description: Druid
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jztey.demo.config;


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：yushi
 * Date：2018/4/23
 * Time：21:46
 * 码云：http://git.oschina.net/jnyqy
 * <p>
 * Druid的配置
 * <p>
 * <p>
 * ========================
 */
@Configuration
public class DruidConfiguration {

    @Value("${druid.loginUsername}")
    private String loginUsername;
    @Value("${druid.loginPassword}")
    private String loginPassword;

    @Value("${druid.allow}")
    private String allow;

    @Value("${druid.deny}")
    private String deny;

    @Value("${druid.resetEnable}")
    private String resetEnable;

    @Value("${druid.exclusions}")
    private String exclusions;

    @Bean
    public ServletRegistrationBean statViewServlet() {
        //创建servlet注册实体
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //设置ip白名单
        servletRegistrationBean.addInitParameter("allow", allow);
        //设置ip黑名单，如果allow与deny共同存在时,deny优先于allow
        servletRegistrationBean.addInitParameter("deny", deny);
        //设置控制台管理用户
        servletRegistrationBean.addInitParameter("loginUsername", loginUsername);
        servletRegistrationBean.addInitParameter("loginPassword", loginPassword);
        //是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable", resetEnable);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter() {
        //创建过滤器
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        //设置过滤器过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        //忽略过滤的形式
        filterRegistrationBean.addInitParameter("exclusions", exclusions);
        return filterRegistrationBean;
    }
}