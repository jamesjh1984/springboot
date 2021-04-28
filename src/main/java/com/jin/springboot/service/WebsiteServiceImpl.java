package com.jin.springboot.service;

import com.jin.springboot.entity.Website;
import com.jin.springboot.mapper.WebsiteMapper;
import com.jin.springboot.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component("websiteService")
@Service("websiteService")
public class WebsiteServiceImpl implements WebsiteService {

    @Qualifier("websiteMapper")
    @Autowired
    private WebsiteMapper websiteMapper;


    @Override
    public List<Website> getAll() {
        System.out.println("WebsiteServiceImpl.getAll()");
        List<Website> websiteList = websiteMapper.getAll();
        return websiteList;
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
    }


    @Override
    public Website getById(Integer id) {
        System.out.println("WebsiteServiceImpl.getById()");
        Website website = websiteMapper.getById(id);
        return website;
    }

}
