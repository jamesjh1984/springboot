package com.jin.springboot;

//import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import springfox.documentation.oas.annotations.EnableOpenApi;


/**
 * 用jar包方式部署
 */
//@SpringBootApplication // SpringBoot入口类
//public class StartApplication {
//
//    private static Logger logger = LoggerFactory.getLogger(StartApplication.class);
//
//    public static void main( String[] args ) {
//
////        logger.info("Hello, SpringBoot Application starts ...");
//
//
//        SpringApplication.run(StartApplication.class);
//
//
//
//        // 新建banner.txt在resources目录下，加入需要的图形文字，SpringBoot会默认读取
//        // 以下代码为启动时不打印输出banner.txt的图标
////        SpringApplication springApplication = new SpringApplication(StartApplication.class);
////        springApplication.setBannerMode(Banner.Mode.OFF);
////        springApplication.run();
//
//
//    }
//}





/**
 * 用war包方式部署，忽略内嵌Tomcat
 */
//@SpringBootApplication // SpringBoot入口类
//public class StartApplication extends SpringBootServletInitializer {
//
//    private static Logger logger = LoggerFactory.getLogger(StartApplication.class);
//
//    public static void main( String[] args ) {
//        SpringApplication.run(StartApplication.class);
//    }
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(StartApplication.class);
//    }
//}





/**
 * SpringBoot整合Mybatis，程序入口
 */
@SpringBootApplication // SpringBoot入口类
@MapperScan("com.jin.springboot.mapper") // 运行的时候，给这些接口创建代理
@EnableOpenApi // 开启Swagger2注解，http://localhost:8080/swagger-ui/index.html
@EnableCaching // 开启缓存
public class StartApplication {

    private static Logger logger = LoggerFactory.getLogger(StartApplication.class);


    public static void main( String[] args ) {

        ConfigurableApplicationContext run = SpringApplication.run(StartApplication.class, args);

//        ComboPooledDataSource bean = run.getBean(ComboPooledDataSource.class); // c3p0
        HikariDataSource bean = run.getBean(HikariDataSource.class); // Hikari

        System.out.println(bean);
    }

}