package com.jin.springboot.config;

import com.jin.springboot.dao.AccountDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 配置类
 * 零xml配置，转化为注解的形式
 * @PropertySource：加载外部xxx.properties文件
 */
@Configuration
@ComponentScan("com.jin.springboot")
@PropertySource(value = {"classpath:jdbc.properties"})
public class IocConfig {

    // 获取外部xxx.properties文件的值
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;




    // 将当前方法的返回值AccountDao交给IOC处理，为单例
    // @Bean注解， 通常用于整合第三方Bean对象，比如数据源(c3p0)组件，只需要实例化一次的对象
    @Bean
    public AccountDao accountDao() {
        return new AccountDao();
    }




    public void printInfo() {
        System.out.println("driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'');
    }
}
