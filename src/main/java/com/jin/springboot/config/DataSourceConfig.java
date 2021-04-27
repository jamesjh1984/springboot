package com.jin.springboot.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
class DataSourceConfig {


    /**
     * c3p0数据源
     *
     */
    @Bean(name="dataSource1")
    @Primary
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource() {
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }
}
