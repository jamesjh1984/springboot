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




    //    Oracle Stored Procedure, call e519013.pkg_website.get_all_websites(po_websites OUT SYS_REFCURSOR);
//    List<Website> getAllWebsites(Map<String, Object> map);

    //    Oracle Stored Procedure, call e519013.pkg_website.get_website_by_id(pi_id IN INTEGER, po_websites OUT SYS_REFCURSOR);
//    List<Website> getWebsiteById(Map<String, Object> map);

}
