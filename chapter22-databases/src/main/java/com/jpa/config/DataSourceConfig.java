package com.jpa.config;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by yushi on 2018/4/26.
 */
@Configuration
public class DataSourceConfig {
    @Bean(name = "primaryDS")
    @Qualifier("primaryDS")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource primaryDataSource() {
        //此处一定要加上druid的DruidDataSource,否则数据源就不会出现，切记
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }


    @Bean(name = "secondaryDS")
    @Qualifier("secondaryDS")
    @ConfigurationProperties(prefix = "spring.datasource.secondary")
    public DataSource secondaryDataSource() {
        //此处一定要加上druid的DruidDataSource,否则数据源就不会出现，切记
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }
}
