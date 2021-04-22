package com.jin.springboot.config;

import com.jin.springboot.config.SpringMvcXmlConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 用WebXmlConfig替换web.xml
 */
public class WebXmlConfig implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 加载配置类
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        // 注册mvc配置信息
        webApplicationContext.register(SpringMvcXmlConfig.class);
        // 设置ServletContext上下文信息
        webApplicationContext.setServletContext(servletContext);
        // 配置转发器Dispatcher
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webApplicationContext));
        servlet.addMapping("/");
        // 启东市即实例化Bean
        servlet.setLoadOnStartup(1);
    }
}
