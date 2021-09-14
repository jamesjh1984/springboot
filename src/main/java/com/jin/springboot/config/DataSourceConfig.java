package com.jin.springboot.config;


import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);


    /**
     * Mysql 主数据源
     */
    @Bean(name="mysqlDataSource")
//    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource(DataSourceProperties properties) {

        HikariDataSource mysqlDataSource = DataSourceBuilder.create(properties.getClassLoader())
                .type(HikariDataSource.class).driverClassName(properties.getDriverClassName())
                .url(properties.getUrl()).username(properties.getUsername())
                .password(properties.getPassword()).build();

        mysqlDataSource.addDataSourceProperty("cachePrepStmts",true);
        mysqlDataSource.addDataSourceProperty("prepStmtCacheSize",250);
        mysqlDataSource.addDataSourceProperty("prepStmtCacheSqlLimit",2048);
        mysqlDataSource.addDataSourceProperty("useServerPrepStmts",true);
        mysqlDataSource.addDataSourceProperty("verifyServerCertificate",false);
//        mysqlDataSource.addDataSourceProperty("ALTER SESSION SET CURRENT_SCHEMA = ", + properties.getSchemaUsername());

        return mysqlDataSource;
    }







    /**
     * Oracle 次数据源
     */
    @Bean(name="oracleDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    DataSource oracleDataSource(DataSourceProperties properties) {
        HikariDataSource oracleDataSource = DataSourceBuilder.create(properties.getClassLoader())
                .type(HikariDataSource.class).driverClassName(properties.getDriverClassName())
                .url(properties.getUrl()).username(properties.getUsername())
                .password(properties.getPassword()).build();

        oracleDataSource.addDataSourceProperty("cachePrepStmts",true);
        oracleDataSource.addDataSourceProperty("prepStmtCacheSize",250);
        oracleDataSource.addDataSourceProperty("prepStmtCacheSqlLimit",2048);
        oracleDataSource.addDataSourceProperty("useServerPrepStmts",true);
        oracleDataSource.addDataSourceProperty("verifyServerCertificate",false);

        return oracleDataSource;
    }

}
