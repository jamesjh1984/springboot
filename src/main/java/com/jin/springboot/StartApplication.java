package com.jin.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication // SpringBoot入口类
public class StartApplication
{
    public static void main( String[] args )
    {

//        SpringApplication.run(StartApplication.class);


        // 启动时不打印输出resources:banner.txt的图标
        SpringApplication springApplication = new SpringApplication(StartApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run();


    }
}
