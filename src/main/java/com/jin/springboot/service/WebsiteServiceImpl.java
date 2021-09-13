package com.jin.springboot.service;

import com.jin.springboot.entity.Website;
import com.jin.springboot.mapper.WebsiteMapper;
import com.jin.springboot.service.WebsiteService;
import com.jin.springboot.utils.AssertUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

//@Component("websiteService")
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {

    @Qualifier("websiteMapper")
    @Autowired
    private WebsiteMapper websiteMapper;


    @Override
//    @Cacheable(value = "website") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public List<Website> getAll() {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.getAll()");
        List<Website> websiteList = websiteMapper.getAll();
        return websiteList;
    }



    @Override
    @Cacheable(value = "website", key = "#id") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public Website getById(Integer id) {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.getById()");

//        AssertUtils.isTure(true,"Exception Test..."); // 故意加入异常

        Website website = websiteMapper.getById(id);
        return website;
    }



    @Override
    @Cacheable(value = "website", key = "#name") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public Website getByName(String name) {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.getByName()");

//        AssertUtils.isTure(true,"Exception Test..."); // 故意加入异常

        Website website = websiteMapper.getByName(name);
        return website;
    }





    @Override
//    @Cacheable(value = "website", key = "#website") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    @CacheEvict(value = "website", key = "#website.id")
    @Transactional(propagation = Propagation.REQUIRED) // 加入事务控制，遇到错误就回滚
    public void updateById(Website website) {
        System.out.println("WebsiteServiceImpl.updateById()");
        websiteMapper.updateById(website);
    }





    @Override
    @CacheEvict(value = "website", key = "#website.id")
    @Transactional(propagation = Propagation.REQUIRED) // 加入事务控制，遇到错误就回滚
    public void add(Website website) {
        System.out.println("WebsiteServiceImpl.add()");

        // 加入数据校验
//        AssertUtils.isTure(StringUtils.isBlank(website.getName()), "Website name can not be null!");
//        AssertUtils.isTure(StringUtils.isBlank(website.getUrl()), "Website url can not be null!");
//        AssertUtils.isTure(StringUtils.isBlank(website.getCountry()), "Website country can not be null!");

//        AssertUtils.isTure(null!=websiteMapper.getByName(website.getName()), "This website name has already existed.");

        websiteMapper.add(website);
    }





    @Override
    @Transactional(propagation = Propagation.REQUIRED) // 加入事务控制，遇到错误就回滚
    public void deleteById(Integer id) {
        System.out.println("WebsiteServiceImpl.deleteById()");
        websiteMapper.deleteById(id);
//        int a=1/0; // 为了测试事务控制，加入的代码
    }














//    MySql Stored Procedure, call james.get_all_websites();
    @Override
    @Cacheable(value = "website") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public List<Website> mysqlGetAllWebsites() {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.mysqlGetAllWebsites()");

        List<Website> websites = websiteMapper.mysqlGetAllWebsites();
        return websites;
    }




//    MySql Stored Procedure, call james.get_website_by_id();
    @Override
    @Cacheable(value = "website", key = "'map[0].id'") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public List<Website> mysqlGetWebsiteById(Map<String, Object> map) {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.mysqlGetWebsiteById()");
        List<Website> website = websiteMapper.mysqlGetWebsiteById(map);
        return website;
    }







//    Oracle Stored Procedure, call c##e519013.pkg_website.get_all_websites(po_websites OUT SYS_REFCURSOR);
    @Override
    @Cacheable(value = "website", key = "'map'") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public List<Website> oracleGetAllWebsites(Map<String, Object> map) {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.oracleGetAllWebsites()");
        websiteMapper.oracleGetAllWebsites(map);
        // 根据key获取结果集，进行强制转换
        List<Website> websites = (List<Website>) map.get("result");
        return websites;
    }


//    Oracle Stored Procedure, call c##e519013.pkg_website.get_website_by_id(pi_id IN INTEGER, po_websites OUT SYS_REFCURSOR);
    @Override
    @Cacheable(value = "website", key = "'map[0].id'") // 第一次不会去缓存中取，第二次之后会根据key去缓存中取，找不到再执行下面的方法
    public List<Website> oracleGetWebsiteById(Map<String, Object> map) {
        System.out.println("Get from Mybatis, not Cache, WebsiteServiceImpl.oracleGetWebsiteById()");
        websiteMapper.oracleGetWebsiteById(map);
        // 根据key获取结果集，进行强制转换
        List<Website> website = (List<Website>) map.get("result");
        return website;
    }


}
