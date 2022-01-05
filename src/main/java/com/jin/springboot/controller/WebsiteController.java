package com.jin.springboot.controller;

import com.jin.springboot.entity.Website;
import com.jin.springboot.model.ResultInfo;
import com.jin.springboot.service.WebsiteService;
import com.mysql.cj.MysqlType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;





// http://localhost:8080/index
@Controller
@RequestMapping("/website")
@Api(tags = "website API management")
public class WebsiteController {


    @Autowired
    private WebsiteService websiteService;



    // http://localhost:8080/website/getAll
    @RequestMapping("/getAll")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => select all websites")
    public List<Website> getAll() {
        System.out.println("WebsiteController.getAll()");
        List<Website> websiteList = websiteService.getAll();

        System.out.println("websiteList => " + websiteList);
        return websiteList;
    }





    // http://localhost:8080/website/getById?id=9
    @RequestMapping("/getById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => select one website by id")
    @ApiImplicitParam(name = "id", value = "website id", required = true, paramType = "path")
    public Website getById(@RequestParam(name = "id") Integer id) {
        System.out.println("WebsiteController.getById()");
        Website website = websiteService.getById(id);

        System.out.println("website => " + website);
        return website;
    }






    // http://localhost:8080/website/getByName?iname=Apple
    @RequestMapping("/getByName")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => select one website by name")
    @ApiImplicitParam(name = "id", value = "website id", required = true, paramType = "path")
    public Website getByName(@RequestParam(name = "name") String name) {
        System.out.println("WebsiteController.getByName()");
        Website website = websiteService.getByName(name);

        System.out.println("website => " + website);
        return website;
    }






    // update one row by id, and return this row to updateSuccess.jsp
    @RequestMapping("/updateById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => update one website by id")
    @ApiImplicitParam(name = "id", value = "website id", required = true)
    public Website updateById(@RequestParam(name = "id") Integer id,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "url") String url,
                              @RequestParam(name = "country") String country) {
        System.out.println("WebsiteController.updateById()");

        Website website = new Website(id, name, url, country);

        System.out.println(website);

        websiteService.updateById(website);

        Website website1 = websiteService.getById(id);

        System.out.println("website => " + website1);
        return website1;
    }





    // add one row, and return this row to addSuccess.jsp
    @RequestMapping("/add")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => add one website")
    @ApiImplicitParam(name = "id", value = "website id", required = true)
    public List<Website> add(@RequestParam(name = "id") Integer id,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "url") String url,
                             @RequestParam(name = "country") String country) {
        System.out.println("WebsiteController.add()");

        Website website = new Website(id, name, url, country);

        System.out.println(website);

        websiteService.add(website);

        // items无法遍历会报错误，也就是说，该遍历的必须是一个List，不可以是Object！
        List<Website> websiteList = new ArrayList<Website>();
        websiteList.add(website);

        return websiteList;
    }








    // http://localhost:8080/website/deleteById/9
    @RequestMapping("/deleteById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => delete one website")
    @ApiImplicitParam(name = "id", value = "website id", required = true)
    public List<Website> deleteById(@RequestParam(name = "id") Integer id) {

        System.out.println("WebsiteController.deleteById()");
        websiteService.deleteById(id);

        return websiteService.getAll();
    }





    // http://localhost:8080/website/mysqlGetAllWebsites
    @RequestMapping("/mysqlGetAllWebsites")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => call MySql SP james.get_all_websites(), return all websites")
    public List<Website> mysqlGetAllWebsites() {
        System.out.println("WebsiteController.mysqlGetAllWebsites()...");

        List<Website> websiteResult = websiteService.mysqlGetAllWebsites();

        System.out.println("websiteResult => " + websiteResult);
        return websiteResult;
    }


    // http://localhost:8080/website/mysqlGetWebsiteById
    @RequestMapping("/mysqlGetWebsiteById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => call MySql SP james.get_website_by_id(), return all websites")
    public List<Website> mysqlGetWebsiteById(@RequestParam(name = "id") Integer id) {
        System.out.println("WebsiteController.mysqlGetWebsiteById()...");

        System.out.println("id => " + id);

        Map<String, Object> map = new HashMap<String, Object>();

//        in参数赋值
        map.put("id", id);
//        out参数赋值
//        map.put("result", OracleTypes.CURSOR);
//        map.put("result", MysqlType.JSON);

        List<Website> websiteResult = websiteService.mysqlGetWebsiteById(map);

        System.out.println("websiteResult => " + websiteResult);
        return websiteResult;
    }








    // http://localhost:8080/website/oracleGetAllWebsites
    @RequestMapping("/oracleGetAllWebsites")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => call Oracle SP c##e519013.pkg_website.get_all_websites(po_websites OUT SYS_REFCURSOR")
    public List<Website> oracleGetAllWebsites() {
        System.out.println("WebsiteController.oracleGetAllWebsites()...");

        Map<String, Object> map = new HashMap<String, Object>();

//        in参数赋值
//        map.put("id", id);
//        out参数赋值
        map.put("result", OracleTypes.CURSOR);

        List<Website> websiteResult = websiteService.oracleGetAllWebsites(map);

        System.out.println("websiteResult => " + websiteResult);
        return websiteResult;
    }


    // http://localhost:8080/website/oracleGetWebsiteById
    @RequestMapping("/oracleGetWebsiteById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => call Oracle SP c##e519013.pkg_website.get_website_by_id(pi_id IN INTEGER, po_websites OUT SYS_REFCURSOR")
    public List<Website> oracleGetWebsiteById(@RequestParam(name = "id") Integer id) {
        System.out.println("WebsiteController.oracleGetWebsiteById()...");

        System.out.println("id => " + id);

        Map<String, Object> map = new HashMap<String, Object>();

//        in参数赋值
        map.put("id", id);
//        out参数赋值
        map.put("result", OracleTypes.CURSOR);

        List<Website> websiteResult = websiteService.oracleGetWebsiteById(map);

        System.out.println("websiteResult => " + websiteResult);
        return websiteResult;
    }











    // http://localhost:8080/website/postgresqlGetAllWebsites
    @RequestMapping("/postgresqlGetAllWebsites")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => call PostgreSQL function get_all_websites(), return all websites")
    public List<Website> postgresqlGetAllWebsites() {
        System.out.println("WebsiteController.postgresqlGetAllWebsites()...");

        List<Website> websiteResult = websiteService.postgresqlGetAllWebsites();

        System.out.println("websiteResult => " + websiteResult);
        return websiteResult;
    }



    // http://localhost:8080/website/postgresqlGetWebsiteById
    @RequestMapping("/postgresqlGetWebsiteById")
    @ResponseBody // 直接输出json，不跳转
    @ApiOperation(value = "website API management => call PostgreSQL function get_website_by_id(p_id integer), return all websites")
    public List<Website> postgresqlGetWebsiteById(@RequestParam(name = "id") Integer id) {
        System.out.println("WebsiteController.postgresqlGetWebsiteById()...");

        System.out.println("id => " + id);

        Map<String, Object> map = new HashMap<String, Object>();

//        in参数赋值
        map.put("id", id);
//        out参数赋值
//        map.put("result", OracleTypes.CURSOR);
//        map.put("result", MysqlType.JSON);

        List<Website> websiteResult = websiteService.postgresqlGetWebsiteById(map);

        System.out.println("websiteResult => " + websiteResult);
        return websiteResult;
    }



}