package com.jin.springboot.service;

import com.jin.springboot.entity.Website;

import java.util.List;
import java.util.Map;

public interface WebsiteService {

    List<Website> getAll();

    void add(Website website);

    void updateById(Website website);

    void deleteById(Integer id);

    Website getById(Integer id);

    Website getByName(String name);




    //    MySql Stored Procedure, call james.get_all_websites();
    List<Website> getAllWebsites();

    //    MySql Stored Procedure, call james.get_website_by_id();
    List<Website> getWebsiteById(Map<String, Object> map);

}
