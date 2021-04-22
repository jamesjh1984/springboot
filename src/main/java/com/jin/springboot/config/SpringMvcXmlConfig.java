package com.jin.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * 用SpringMvcXmlConfig替换springmvc.xml
 *
 */
@Configuration
@ComponentScan("com.jin.springboot")
@EnableWebMvc // 启用MVC
public class SpringMvcXmlConfig extends WebMvcConfigurationSupport {


    /**
     * 定义MVC视图解析器
     * 因为要交给IOC实例化，所以加上@Bean注解
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/page/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }






    /**
     * 若要释放静态资源，可extends WebMvcConfigurationSupport，共三步
     * 1. 访问静态资源，Handler不进行处理，直接响应到客户端
     *
     */
//    @Override
//    protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    /**
     * 2. 配置自定义拦截器
     */
//    public LoginInterceptor loginInterceptor() {
//        return new LoginInterceptor();
//    }

    /**
     * 3. 注册添加拦截器，重写父类方法addInterceptors()
     *
     */
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptors(loginInterceptor());
//    }







}
