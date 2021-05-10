package com.jin.springboot.config;


//import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);


    /**
     * HikariCP数据源
     *
     */
    @Bean(name="HikariCP_dataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource dataSource(DataSourceProperties properties) {

        HikariDataSource hikariDataSource = DataSourceBuilder.create(properties.getClassLoader())
                .type(HikariDataSource.class).driverClassName(properties.getDriverClassName())
                .url(properties.getUrl()).username(properties.getUsername())
                .password(properties.getPassword()).build();

        hikariDataSource.addDataSourceProperty("cachePrepStmts",true);
        hikariDataSource.addDataSourceProperty("prepStmtCacheSize",250);
        hikariDataSource.addDataSourceProperty("prepStmtCacheSqlLimit",2048);
        hikariDataSource.addDataSourceProperty("useServerPrepStmts",true);
        hikariDataSource.addDataSourceProperty("verifyServerCertificate",false);
//        hikariDataSource.addDataSourceProperty("ALTER SESSION SET CURRENT_SCHEMA = ", + properties.getSchemaUsername());

        return hikariDataSource;
    }






    /**
     * c3p0数据源
     *
     */
//    @Bean(name="c3p0_dataSource1")
////    @Primary
//    @ConfigurationProperties(prefix = "c3p0")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
//    }


}
