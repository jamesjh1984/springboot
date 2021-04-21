package com.jin.springboot.service;


import com.jin.springboot.dao.WebsiteDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class WebsiteService {

    @Resource
    private WebsiteDao websiteDao;

    public void test() {
        websiteDao.test();
        System.out.println("WebsiteService.test()");
    }
}
