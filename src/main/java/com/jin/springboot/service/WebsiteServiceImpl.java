package com.jin.springboot.service;

import com.jin.springboot.entity.Website;
import com.jin.springboot.mapper.WebsiteMapper;
import com.jin.springboot.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component("websiteService")
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {

    @Qualifier("websiteMapper")
    @Autowired
    private WebsiteMapper websiteMapper;


    @Override
    @Cacheable(value = "website") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public List<Website> getAll() {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.getAll()");
        List<Website> websiteList = websiteMapper.getAll();
        return websiteList;
    }



    @Override
    @Cacheable(value = "website", key = "#id") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public Website getById(Integer id) {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.getById()");
        Website website = websiteMapper.getById(id);
        return website;
    }





    @Override
    public void add(Website website) {
        System.out.println("WebsiteServiceImpl.add()");
        websiteMapper.add(website);
    }


    @Override
    public void updateById(Website website) {
        System.out.println("WebsiteServiceImpl.updateById()");
        websiteMapper.updateById(website);
    }


    @Override
    public void deleteById(Integer id) {
        System.out.println("WebsiteServiceImpl.deleteById()");
        websiteMapper.deleteById(id);
        int a=1/0; // 为了测试事务控制，加入的代码
    }

}
