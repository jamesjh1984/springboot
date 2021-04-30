package com.jin.springboot.service;

import com.jin.springboot.StartApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StartApplication.class})
public class TestWebsiteServiceImpl {

    private static Logger logger = LoggerFactory.getLogger(TestWebsiteServiceImpl.class);

    @Resource // 注入要测试的service类
    private WebsiteServiceImpl websiteServiceImpl;


    /**
     * c3p0 will not printout
     * Hikari will printout automatically, so can comment before()
     */
//    @Before
//    public void before() {
//        logger.info("Test: unit test start...");
//    }



    @Test // 表明是测试方法
    public void testgetAll() {
        logger.info("Test: all websites => " + websiteServiceImpl.getAll().toString());
    }


    @Test // 表明是测试方法
    public void testgetById() {
        logger.info("Test: one website by id => " + websiteServiceImpl.getById(2).toString());
    }



    /**
     * c3p0 will not printout
     * Hikari will printout automatically, so can comment after()
     */
//    @After
//    public void after() {
//        logger.info("Test: unit test end...");
//    }

}
