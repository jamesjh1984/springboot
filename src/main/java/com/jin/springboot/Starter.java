package com.jin.springboot;

import com.jin.springboot.config.IocConfig;
import com.jin.springboot.dao.AccountDao;
import com.jin.springboot.service.WebsiteService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class Starter
{
    public static void main( String[] args )
    {
        // 实例化Spring IOC
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(IocConfig.class);

        // 获取需要的Bean对象
        WebsiteService websiteService = applicationContext.getBean(WebsiteService.class);
        websiteService.test();



        // 获取需要的Bean对象
        IocConfig iocConfig = applicationContext.getBean(IocConfig.class);
        AccountDao accountDao = iocConfig.accountDao();
        accountDao.test();

        // 判断IocConfig是否为单例
        System.out.println(applicationContext.isSingleton("iocConfig"));

        AccountDao accountDao01 = iocConfig.accountDao();
        AccountDao accountDao02 = iocConfig.accountDao();
        System.out.println(accountDao01+", "+accountDao02);

        iocConfig.printInfo();

    }
}
