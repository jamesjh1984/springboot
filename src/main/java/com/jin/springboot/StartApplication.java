package com.jin.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // SpringBoot入口类
public class StartApplication {

    private static Logger logger = LoggerFactory.getLogger(StartApplication.class);


    public static void main( String[] args ) {

//        logger.info("Hello, SpringBoot Application starts ...");


        SpringApplication.run(StartApplication.class);



        // 新建banner.txt在resources目录下，加入需要的图形文字，SpringBoot会默认读取
        // 以下代码为启动时不打印输出banner.txt的图标
//        SpringApplication springApplication = new SpringApplication(StartApplication.class);
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        springApplication.run();


    }
}
